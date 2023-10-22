import React, {useState, useEffect } from 'react';
import { Stack, Box, FormControl, InputLabel, MenuItem, Select, Button, Typography, Modal, Grid, TextField } from '@mui/material';
import { bookPresenter } from '../../../presenter/BookPresenter'

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

export const ModalRecipeBook = (props) => {
  const [open, setOpen] = React.useState(false);
  const [books, setBooks] = useState([]);
  const {recipeId, user} = props
  
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const [recipe, setRecipe] = useState({
    "idRecipe": recipeId,
    "book": null,
  });

  const { addRecipe, getBooksByUserId } = bookPresenter()

  const close = () => {
    setOpen(false);
  }

  useEffect(() => {
    getBooksByUserId(user.idUser, false)
        .then((res) => {
            if(res.length > 1){
                setBooks(res)
            }else{
                let array = []
                array.push(res)
                setBooks(array)
            }
        })
        .catch((err) => console.log(err));
 }, []);

  const handleTypeChange = (event) => {
    const book = event.target.value;
    setRecipe({ ...recipe, book: book });
  };

  const sendRecipe = async (event) => {
    event.preventDefault();

    if (!validateFields()) {
      return;
    }

    addRecipe(recipe.idRecipe, recipe.book.IdBook)
      .then((res) => {
        alert("Receta agregada");
      })
      .then(() => {
        close();
      });
  };

  const validateFields = () => {
    if (!recipe.book || !recipe.idRecipe) {
      alert("Por favor, complete todos los campos obligatorios.");
      return false;
    }
    return true;
  };

  return (
    <div>
      <Button onClick={handleOpen} variant="outlined">
        Agrega a Recetario
      </Button>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <Stack spacing={3}>      
            <Typography id="modal-modal-title" align="center" variant="h5" component="h5">
                Agregar receta a recetario
            </Typography> 
            {
                books
                ?
                <Stack spacing={4}>
                    <Grid item container>
                        <FormControl fullWidth variant="outlined">
                        <InputLabel id="type-label">Recetario</InputLabel>
                        <Select
                            labelId="type-label"
                            id="book"
                            label="Recetario"
                            value={books.find((book) => book == recipe.book) || ""}
                            onChange={handleTypeChange}
                        >
                            {books.map((book) => (
                            <MenuItem key={book.IdBook} value={book}>
                                {book.Name}
                            </MenuItem>
                            ))}
                        </Select>
                        </FormControl>
                    </Grid>
                    <Box pb={2} display="flex" justifyContent="space-around" alignItems="center">
                        <Button onClick={close} variant="outlined" color="primary">
                            Cancelar
                        </Button>
                        <Button onClick={sendRecipe} variant="contained" color="primary">
                            Enviar
                        </Button>
                    </Box>
                </Stack>
                :  
                <Stack spacing={3}>
                    <Typography id="modal-modal-title" align="center" variant="body1" component="body1">
                        No tienes recetarios
                    </Typography> 
                    <Box pb={2} display="flex" justifyContent="space-around" alignItems="center">
                        <Button onClick={close} variant="outlined" color="primary">
                            Cancelar
                        </Button>
                    </Box>
                </Stack>
            } 
          </Stack>
        </Box>
      </Modal>
    </div>
  );
}