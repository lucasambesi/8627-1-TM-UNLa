import React, { useEffect, useState } from "react";
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import { useNavigate } from 'react-router'
import { Container, Fab } from "@mui/material";
import AddIcon from '@mui/icons-material/Add';
import { draftPresenter } from '../../presenter/DraftPresenter'
import { Draft } from "./Drafts/Draft";

export const Drafts = (props) => {
    const navigate = useNavigate();

    const { user } = props;
    const { getByUserId } = draftPresenter()

    const toCsvUploader = () => { navigate("/drafts/uploader") }
    const [drafts, setDrafts] = useState(null);

    useEffect(() => {    
        getByUserId(user.idUser)
          .then((res) => {
            console.log("🚀 ~ file: Drafts.jsx:22 ~ .then ~ res:", res)
            setDrafts(res)
          })
          .catch((err) => console.log(err));
      }, []);

    const updateDraft = (draftId, updatedDraft) => {
      setDrafts(prevDrafts => prevDrafts.map(draft => (draft.draftId === draftId ? updatedDraft : draft)))
    };

    const fabStyle = {
        position: 'absolute',
        bottom: 30,
        right: 30,
      };

     return (
        <Container sx={{  justifySelf:'center', alignSelf: 'center'}}> 
        <Box sx={{ flexGrow: 1, margin: 5, alignContent:'center' }}>
          <Grid container rowSpacing={3} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
          {
                    drafts ? drafts.map((draft) =>{
                    return (  
                          <Draft draft={draft} user={user} updateDraft={updateDraft}/>
                        )
                    })
                    : 
                    <Box sx={{ flexGrow: 1, margin: 12, alignContent:'center' }}>
                      <h4>
                        No hay borradores creados, puedes hacerlo desde el boton de abajo a la derecha!
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