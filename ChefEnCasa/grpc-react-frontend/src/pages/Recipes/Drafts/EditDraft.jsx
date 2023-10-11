import React, {useState } from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import { Grid, Stack, TextField } from '@mui/material';
import { draftPresenter } from '../../../presenter/DraftPresenter'

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

export const ModalDraftEdit = (props) => {
  const [open, setOpen] = React.useState(false);
  
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const {draft, updateDraft} = props
  const [descriptionLength, setDescriptionLength] = useState(0);

  const { updateDraft: update } = draftPresenter()

  const close = () => {
    setOpen(false);
  }

  const edit = async (event) => {
    event.preventDefault();
  
    if (!validateFields()) {
      return;
    }
  
    update(draft)
      .then((res) => {
        alert("Borrador editado");
      })
      .then(() => {
        close();
      });
  };

  const validateFields = () => {
    if (!draft.title || !draft.description || !draft.category || !draft.preparationTime) {
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

    if (name == "description") {
        if(value > 250){
            return;
        }        
    }

    let temp = { ...draft }
    temp[name] = value
    updateDraft(draft.draftId ,temp)
 }

  return (
    <div>
      <Button onClick={handleOpen} variant="outlined">
        Editar
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
                Editar borrador
            </Typography>     
            <Grid item container>
                <TextField
                    fullWidth
                    name="title"
                    label="Titulo"
                    variant="outlined"
                    defaultValue={draft.title}
                    onChange={handleInputChange}
                />
            </Grid>
            <Grid item container>
                <TextField
                    fullWidth
                    name="description"
                    label="Descripcion"
                    variant="outlined"
                    defaultValue={draft.description}
                    onChange={handleInputChange}
                />
            </Grid>
            <Grid item container>
                <TextField
                    fullWidth
                    name="category"
                    label="Categoria"
                    variant="outlined"
                    defaultValue={draft.category}
                    onChange={handleInputChange}
                />
            </Grid>
            <Grid item container>
                <TextField
                    fullWidth
                    name="preparationTime"
                    label="Tiempo de preparación"
                    variant="outlined"
                    defaultValue={draft.preparationTime}
                    onChange={handleInputChange}
                />
            </Grid>
            <Box pb={2} display="flex" justifyContent="space-around" alignItems="center">
                <Button onClick={close} variant="outlined" color="primary">
                    Cancelar
                </Button>
                <Button onClick={edit} variant="contained" color="primary">
                    Editar
                </Button>
            </Box>
          </Stack>
        </Box>
      </Modal>
    </div>
  );
}