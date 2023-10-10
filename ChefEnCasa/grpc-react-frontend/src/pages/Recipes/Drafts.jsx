import React, { useEffect, useState } from "react";
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import { useNavigate } from 'react-router'
import { Container, Fab } from "@mui/material";
import AddIcon from '@mui/icons-material/Add';
import { draftPresenter } from '../../presenter/DraftPresenter'

export const Drafts = (props) => {
    const navigate = useNavigate();

    const { user } = props;
    const { getByUserId } = draftPresenter()
    const toCsvUploader = () => { navigate("/drafts/uploader") }
    const [drafts, setDrafts] = useState(null);

    useEffect(() => {
        getByUserId(user.idUser)
          .then((res) => {
            setDrafts(res)
          })
          .catch((err) => console.log(err));
      }, []);

    const fabStyle = {
        position: 'absolute',
        bottom: 30,
        right: 30,
      };

     return (
        <Container sx={{  justifySelf:'center', alignSelf: 'center'}}> 
        <Box sx={{ flexGrow: 1, margin: 5, alignContent:'center' }}>
          <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
          {
                    drafts ? drafts.map((draft) =>{
                    return (
                        <h1>{draft.title}</h1>
                        )
                    })
                    : 
                    <Box sx={{ flexGrow: 1, margin: 12, alignContent:'center' }}>
                      <h4>
                        No hay recetas creadas, puedes hacerlo desde el boton de abajo a la derecha!
                      </h4>
                    </Box>
                }
          </Grid>
        </Box>
        <Fab color="primary" aria-label="add" sx={fabStyle} onClick={toCsvUploader}>
            <AddIcon />
        </Fab>
      </Container>
     );
   }