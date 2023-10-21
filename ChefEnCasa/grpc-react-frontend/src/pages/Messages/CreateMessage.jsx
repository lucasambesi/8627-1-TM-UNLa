import React, { useState, useEffect } from 'react';
import { Box, Button, Container, Grid, Paper, Stack, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, TextField, Typography } from '@mui/material';
import { useNavigate } from 'react-router'
import { messagePresenter } from '../../presenter/MessagePresenter'
import { userPresenter } from '../../presenter/UserPresenter'
import { SelectUsers } from './SelectUsers';
export const CreateMenssage = (props) => {

  const { user } = props

  const [message, setMessage] = useState({
      "IdReceiver": null,
      "IdSender": user.idUser ? user.idUser.toString() : null,
      "Subject": null,
      "Value": null
  });

  const [users, setUsers] = useState(null);
  const [receiver, setReceiver] = useState({});
  const navigate = useNavigate();
  const { addMessage } = messagePresenter()
  const { getUsersSoap } = userPresenter()

   useEffect(() => {    
      getUsersSoap()
        .then((res) => {
          setUsers(res);
        })
        .catch((err) => console.log(err));
    }, []);

  const handleSend = () => {
    message.IdReceiver = receiver.IdUser
    
    if(!validateFields()){
      return;
    }

    addMessage(message)
    .then((res) => {
        alert("Mensaje enviado con exito")
        navigate("/messages")
    })
    .catch((err) => console.log(err));
  };

  const validateFields = () => {
    if (!message.IdReceiver|| !message.Value || !message.Subject || !message.IdSender) {      
      alert("Por favor, complete todos los campos obligatorios.");
      return false;
    }
    return true;
  };

  const handleInputChange = (event) => {
    const name = event.target.name

    const value = event.target.type === "number"
        ? event.target.valueAsNumber : event.target.type === 'checkbox'
        ? event.target.checked : event.target.value

    let temp = { ...message }
    temp[name] = value
    setMessage(temp)
 }

  return (
    <Container sx={{  justifySelf:'center', alignSelf: 'center', marginTop:"40px"}}>
        <Paper elevation={0} sx={{ flexGrow: 1, alignContent:'center' }}>
          <Stack spacing={5}>
            <Typography id="modal-modal-title" align="center" variant="h5" component="h5">
              Enviar mensaje
            </Typography>
          </Stack>
        <Stack marginTop={"20px"} spacing={5}>
          {
            users 
            ? 
            <SelectUsers users={users.filter(usr => usr.IdUser != user.idUser)} receiver={receiver} setReceiver={setReceiver}/>
            : 
            null
          }
            
            <Grid item container>
                <TextField
                    fullWidth
                    name="Subject"
                    multiline
                    rows={1}
                    label="Asunto"
                    variant="outlined"
                    defaultValue={message.Subject}
                    onChange={handleInputChange}
                />
            </Grid>
            <Grid item container>
                  <TextField
                      fullWidth
                      name="Value"
                      multiline
                      rows={3}
                      label="Mensaje"
                      variant="outlined"
                      defaultValue={message.Value}
                      onChange={handleInputChange}
                  />
              </Grid>
            <Button marginTop={"20px"} onClick={handleSend} variant="outlined">
            Enviar
            </Button>
        </Stack>
        </Paper>        
    </Container>
  );
};