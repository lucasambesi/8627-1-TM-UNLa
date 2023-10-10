import React, { useEffect, useState } from "react";
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import { useNavigate } from 'react-router'
import { Container, Fab } from "@mui/material";
import AddIcon from '@mui/icons-material/Add';

export const Drafts = (props) => {

    const navigate = useNavigate();
    const toCsvUploader = () => { navigate("/drafts/uploader") }

    const fabStyle = {
        position: 'absolute',
        bottom: 30,
        right: 30,
      };

     return (
        <Container sx={{  justifySelf:'center', alignSelf: 'center'}}> 
        <Box sx={{ flexGrow: 1, margin: 5, alignContent:'center' }}>
          <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
          </Grid>
        </Box>
        <Fab color="primary" aria-label="add" sx={fabStyle} onClick={toCsvUploader}>
            <AddIcon />
        </Fab>
      </Container>
     );
   }