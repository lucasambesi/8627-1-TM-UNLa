import React, { useState, useEffect } from 'react';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemText from '@mui/material/ListItemText';
import IconButton from '@mui/material/IconButton';
import { Add, DeleteOutline } from '@mui/icons-material';
import { TextField, Button } from "@mui/material";
import Grid from '@mui/material/Grid';

export default function StepsList(props) {
  const { steps, setSteps } = props;
  const [step, setStep] = useState("");

  const addStep = () => {
    if (step.trim() !== "") {
        const tempStep = {
            "description": step
        }
      setSteps([...steps, tempStep]); 
      setStep(""); 
    }
  };

  const removeStep = (index) => () => {
    const updatedSteps = [...steps];
    updatedSteps.splice(index, 1); 
    setSteps(updatedSteps); 
  };

  return (
    <>
      <Grid container item marginTop={"20px"}>
        <TextField
          fullWidth
          name="step"
          label="Pasos"
          variant="outlined"
          value={step}
          onChange={(e) => setStep(e.target.value)} // Actualiza el estado 'step' cuando se escribe en el campo
        />
        <Button onClick={addStep}>Agregar</Button>
      </Grid>
      <List sx={{ width: '100%', bgcolor: 'background.paper' }}>
        {steps.map((step, index) => {
          const labelId = `checkbox-list-label-${index}`;

          return (
            <ListItem
              key={index}
              secondaryAction={
                <IconButton edge="end" aria-label="comments" onClick={removeStep(index)}>
                  <DeleteOutline />
                </IconButton>
              }
              disablePadding
            >
              <ListItemButton role={undefined} dense>
                <ListItemText id={labelId} primary={`Paso ${index +1}: ${step.description}`} />
              </ListItemButton>
            </ListItem>
          );
        })}
      </List>
    </>
  );
}