import React, { useState, useEffect } from 'react';
import { Box, Button, Grid, Stack, TextField, Typography } from '@mui/material';
import { bookPresenter } from '../../../presenter/BookPresenter'
import Fab from '@mui/material/Fab';
import AddIcon from '@mui/icons-material/Add';
import Modal from '@mui/material/Modal';

export const CreateBook = (props) => {

    const fabStyle = {
        position: 'absolute',
        bottom: 30,
        right: 30,
    };

    const style = {
        position: 'absolute',
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        width: 400,
        bgcolor: 'background.paper',
        border: '2px solid #000',
        boxShadow: 24,
        p: 4,
    };
  
    
  const { user, setBooks, books } = props

  const [book, setBook] = useState({
      "Name": null,
      "IdUser": user.idUser ? user.idUser: null,
  });

  const [open, setOpen] = React.useState(false);
  
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const [users, setUsers] = useState(null);
  const [receiver, setReceiver] = useState({});

  const { addBook } = bookPresenter()

   useEffect(() => {    
    }, []);

  const handlerCreate = () => {
    
    if(!validateFields()){
      return;
    }

    addBook(book)
    .then((res) => {
        const temp = books
        temp.push(book)
        setBooks(temp)

        handleClose();
        alert("Recetario creado con exito")
    })
    .catch((err) => console.log(err));
  };

  const validateFields = () => {
    if (!book.Name|| !book.IdUser) {      
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

    let temp = { ...book }
    temp[name] = value
    setBook(temp)
 }

  return (
    <div>
        <Fab color="primary" aria-label="add" sx={fabStyle} onClick={handleOpen}>
            <AddIcon />
        </Fab>
        <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title-book"
        aria-describedby="modal-modal-descriptionCreateBook">
            <Box sx={style}>
                <Stack spacing={3}>
                    <Typography id="modal-modal-title" align="center" variant="h5" component="h5">
                        Crear recetario
                    </Typography> 
                    <Grid item container>
                        <TextField
                            fullWidth
                            name="Name"
                            multiline
                            rows={3}
                            label="Nombre"
                            variant="outlined"
                            defaultValue={book.Name}
                            onChange={handleInputChange}
                        />
                    </Grid>
                    <Button marginTop={"20px"} onClick={handlerCreate} variant="contained">
                        Crear
                    </Button>
                </Stack>
            </Box>
        </Modal>
    </div>
  );
};