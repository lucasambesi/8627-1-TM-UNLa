import React, {useState } from 'react';
import { Stack, Box, FormControl, InputLabel, MenuItem, Select, Button, Typography, Modal, Grid, TextField } from '@mui/material';
import { reportPresenter } from '../../presenter/ReportPresenter'
import ReportType from '../../helpers/ReportType';

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

export const ModalReport = (props) => {
  const [open, setOpen] = React.useState(false);

  const ReportTypesArray = Object.values(ReportType);
  const {recipeId, user} = props
  
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const [commentLength, setCommentLength] = useState(0);
  const [report, setReport] = useState({
    "userId": user.idUser ?  user.idUser.toString() : null,
    "recipeId": recipeId,
    "type": 1,
    "comment": null
  });

  const { addReport } = reportPresenter()

  const close = () => {
    setOpen(false);
  }

  const handleTypeChange = (event) => {
    const selectedType = event.target.value;
    setReport({ ...report, type: selectedType.id });
  };

  const sendReport = async (event) => {
    event.preventDefault();

    if (!validateFields()) {
      return;
    }

    addReport(report)
      .then((res) => {
        alert("Denuncia enviada");
      })
      .then(() => {
        close();
      });
  };

  const validateFields = () => {
    if (!report.type || !report.comment) {
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

    if (name == "comment") {
        if(value > 250){
            return;
        }        
    }

    let temp = { ...report }
    temp[name] = value
    setReport(temp)
 }

  return (
    <div>
      <Button onClick={handleOpen} variant="outlined">
        Denunciar
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
                Denuncia
            </Typography>     
            <Grid item container>
                <FormControl fullWidth variant="outlined">
                <InputLabel id="type-label">Motivo</InputLabel>
                <Select
                    labelId="type-label"
                    id="type"
                    label="Motivo"
                    value={ReportTypesArray.find((type) => type.id === report.type) || ""}
                    onChange={handleTypeChange}
                >
                    {ReportTypesArray.map((type) => (
                    <MenuItem key={type.id} value={type}>
                        {type.description}
                    </MenuItem>
                    ))}
                </Select>
                </FormControl>
            </Grid>
            <Grid item container>
                <TextField
                    fullWidth
                    multiline
                    rows={3}
                    name="comment"
                    label="Comentario"
                    variant="outlined"
                    defaultValue={report.comment}
                    onChange={handleInputChange}
                />
            </Grid>
            <Box pb={2} display="flex" justifyContent="space-around" alignItems="center">
                <Button onClick={close} variant="outlined" color="primary">
                    Cancelar
                </Button>
                <Button onClick={sendReport} variant="contained" color="primary">
                    Enviar
                </Button>
            </Box>
          </Stack>
        </Box>
      </Modal>
    </div>
  );
}