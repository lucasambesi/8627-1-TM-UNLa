import React, { useState, useEffect } from 'react';
import { Box, Button, Chip, Container, Divider, Grid, List, ListItemButton, Paper, Stack, TextField, Typography } from '@mui/material';
import { useNavigate } from 'react-router'
import { messagePresenter } from '../../presenter/MessagePresenter'
import { userPresenter } from '../../presenter/UserPresenter'

import MarkEmailUnreadIcon from '@mui/icons-material/MarkEmailUnread';
import SendIcon from '@mui/icons-material/Send';
import EmailIcon from '@mui/icons-material/Email';

export const Messages = (props) => {

  const {user } = props
  const navigate = useNavigate();
  const { getByUserId, updateMessage } = messagePresenter()
  const { getById } = userPresenter()
  const [messages, setMessages] = useState(null);
  const [actualMessage, setActualMessage] = useState(null);
  const [message, setMessage] = useState(null);
  const [idMessage, setIdMessage] = useState(null);

  useEffect(() => {
    getByUserId(user.idUser)
       .then((res) => {
        setMessages(res)
        setIdMessage(res[0].IdMessage)
        setActualMessage(res[0])
       })
       .catch((err) => console.log(err));
   }, []);

//    useEffect(() => {
//     if(idMessage){
//         getById(idMessage)
//         .then((res) => {
//          setRecipe(res)
//         })
//         .catch((err) => console.log(err));
//     }
//    }, [idMessage]);

   const handleClickMessage = (message) => {
        setActualMessage(message)
        setIdMessage(message.IdMessage)
    }

   const checkMessage = () => {
    };

    const sendResponse = (recipe) => {
    };

    const handleInputChange = (event) => {
        const name = event.target.name
    
        const value = event.target.type === "number"
            ? event.target.valueAsNumber : event.target.type === 'checkbox'
            ? event.target.checked : event.target.value
    
        let temp = { ...report }
        temp[name] = value
        setActualMessage(temp)

        //TODO: set el mensaje en la lista tmb
     }

  return (
    <Container sx={{  justifySelf:'center', alignSelf: 'center', marginTop:"40px"}}>
        <Paper elevation={0} sx={{ flexGrow: 1, alignContent:'center' }}>
          <Stack spacing={5}>
            <Typography id="modal-modal-title" align="center" variant="h5" component="h5">
                Casilla de mensajes
            </Typography>
            <Box sx={{ flexGrow: 1, marginLeft: 12, marginTop:10 ,alignContent:'center' }}>
                <Stack spacing={3} direction={"row"} justifyContent={"center"}>
                    <Paper elevation={3} sx={{ width:"40%", minHeight:"500px"}}>
                        <Typography sx={{marginTop:"15px"}} id="modal-modal-title" align="center" variant="h5" component="h5">
                            Mensajes
                        </Typography>
                        <Box sx={{ flexGrow: 1, marginTop: 2, alignContent:'center' }}>
                            <List container rowSpacing={2} sx={{padding:"2%"}}>
                            {
                                messages ? messages.map((message) =>{
                                return (
                                    <Paper sx={{width:"100%", marginBottom: 1}} elevation={3}>
                                        <ListItemButton onClick={(() => handleClickMessage(message))}>
                                            <Stack spacing={1} sx={{padding:"1.5%"}}>
                                                <Stack direction="row" spacing={1} alignItems={"center"}>
                                                    {
                                                        message.SenderId == user.idUser
                                                        ?
                                                        <Chip icon={<SendIcon />}  label="enviado" color="success" variant="outlined" />
                                                        :
                                                        <Chip icon={<EmailIcon />} label="recibido" color="default" variant="outlined" />
                                                    }
                                                    {
                                                        message.Answered != "true"
                                                        ?
                                                        <Chip icon={<MarkEmailUnreadIcon />} label="no leido" color="warning" variant="outlined" />
                                                        :
                                                        null
                                                    }                                                                  
                                                </Stack>
                                                <Typography variant="body1" component="body1" sx={{fontWeight: "bold"}}>
                                                    {`${message.Subject}`}
                                                </Typography>
                                                {
                                                    message.SenderId == user.idUser
                                                    ?
                                                    <Typography variant="body1" component="body1" >
                                                        {`A ${message.ReceiverId }`}
                                                    </Typography>
                                                    :
                                                    <Typography variant="body1" component="body1" >
                                                        {`De ${message.SenderId }`}
                                                    </Typography>
                                                }                 
                                            </Stack>
                                        </ListItemButton>
                                    </Paper>
                                    )
                                })
                                : 
                                <Box sx={{ flexGrow: 1, margin: 12, alignContent:'center' }}>
                                    <h4>
                                        No hay recetas creadas, puedes hacerlo desde el boton de abajo a la derecha!
                                    </h4>
                                </Box>
                            }
                            </List>
                        </Box>
                    </Paper>
                    <Divider orientation="vertical" flexItem />
                    <Paper  elevation={3} sx={{ width:"60%", minHeight:"70%", position: 'relative'}}>
                        {
                            (actualMessage != null) ?
                            <Stack spacing={3} sx={{padding:"1.5%", marginTop:"10px"}}>
                                <Stack spacing={3} >    
                                    <Stack spacing={3}>
                                        <Typography variant="h6" align='center' component="h6" sx={{fontWeight: "bold"}}>
                                            {actualMessage.Subject}
                                        </Typography>
                                        {
                                            (actualMessage.SenderId != user.idUser)
                                            ?
                                            <Typography variant="h6" component="h6">
                                                {`De ${actualMessage.SenderId } para ti`}
                                            </Typography>
                                            :
                                            <Typography variant="h6" component="h6">
                                                {`De ti para ${actualMessage.ReceiverId }`}
                                            </Typography>
                                        }
                                        <Typography variant="body1" component="body1">
                                            {actualMessage.Value ? actualMessage.Value : null}
                                        </Typography>
                                    </Stack>
                                    {
                                        (actualMessage.SenderId == user.idUser)
                                        ?
                                            (actualMessage.Respone)
                                            ?
                                                <Stack spacing={2}>
                                                    <Typography variant="h6" component="h6">
                                                        Respuesta:
                                                    </Typography>
                                                    <Typography variant="body1" component="body1">
                                                        {actualMessage.Respone}
                                                    </Typography>
                                                </Stack>
                                            :
                                                <Stack spacing={2}>
                                                    <Divider variant="middle"/>
                                                    <Typography variant="caption" align='center' component="caption">
                                                        (Todavia no hay respuesta)
                                                    </Typography>
                                                </Stack>
                                                
                                        :
                                            (actualMessage.Respone)
                                            ?      
                                                <Stack spacing={2}>
                                                    <Typography variant="h6" component="h6">
                                                        Tu respusta fue:
                                                    </Typography>
                                                    <Typography variant="body1" component="body1">
                                                        {actualMessage.Respone}
                                                    </Typography>
                                                </Stack>
                                            :
                                                <Stack spacing={4}>
                                                    <Stack spacing={2}>
                                                        <Typography variant="h6" component="h6">
                                                            Responder:
                                                        </Typography>
                                                        <Grid item container>
                                                            <TextField
                                                                fullWidth
                                                                multiline
                                                                rows={3}
                                                                name="Respone"
                                                                label="Respuesta"
                                                                variant="outlined"
                                                                value={actualMessage.Respone}
                                                                onChange={handleInputChange}
                                                            />
                                                        </Grid>
                                                    </Stack>
                                                    <Box pb={2} display="flex" justifyContent="center" alignItems="center">
                                                        <Stack alignContent={"start"} justifyContent={"start"} spacing={2}>
                                                            <Stack direction={"row"} spacing={5}>
                                                                <Button onClick={(() => checkMessage())} variant="outlined" color="inherit">
                                                                    Marcar como leido
                                                                </Button>
                                                                <Button onClick={(() => sendResponse(actualMessage))} variant="contained" color="info">
                                                                    Enviar respuesta
                                                                </Button>
                                                            </Stack>
                                                        </Stack>
                                                    </Box>      
                                                </Stack>
                                    }                                           
                                </Stack>
                            </Stack>
                            : 
                            <Box sx={{ flexGrow: 1, margin: 12, alignContent:'center' }}>
                                <h4>
                                    Seleccionar un mensaje!
                                </h4>
                            </Box>
                        }

                    </Paper>
                </Stack>
            </Box> 
          </Stack>
        </Paper>        
    </Container>
  );
};
