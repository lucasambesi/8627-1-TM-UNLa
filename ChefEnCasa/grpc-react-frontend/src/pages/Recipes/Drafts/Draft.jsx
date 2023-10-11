import React, {useState} from 'react';
import { Paper, Stack, Typography, Button } from "@mui/material";
import { ModalDraftEdit } from "./EditDraft";
import { ModalRecipe } from '../ModalRecipe';

export const Draft = (props) => {
    const {draft, updateDraft, user} = props

    const [recipe, setRecipe] = useState({
        idRecipe: "",
        title: draft.title,
        description: draft.description,
        ingredients: "",
        preparationTime: draft.preparationTime,
        idCategory: draft.category,
        idUser: user.idUser,
        images: []
      });

    const [open, setOpen] = useState(false);

    const handlerSubmit = () => {
        setOpen(true);
      };

return (
        <Paper elevation={3} sx={{padding:"20px", margin:"2%"}}>
            <Stack justifyContent={"space-between"} sx={{ marginTop:'20px'}}>
                <Typography id="modal-modal-title" align="center" variant="h5" component="h5">
                    {
                        draft.title.length > 70
                            ? `${draft.title.slice(0, 67)}...`
                            : draft.title
                    }
                </Typography>
                <Typography id="modal-modal-description" sx={{ mt: 2, marginTop:"20px" }}>
                    La receta te tomara aproximadamente {draft.preparationTime} minutos.
                </Typography>       
                <Stack direction={"row"} justifyContent={"space-between"}>
                    <Stack>
                        <Typography sx={{marginTop: 2}} id="modal-modal-title" variant="h6" component="h2">
                            Descripcion: 
                        </Typography>
                        <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                            {
                                draft.description.length > 30
                                    ? `${draft.description.slice(0, 27)}...`
                                    : draft.description
                            }
                        </Typography>
                        </Stack>
                        <Stack>
                        <Typography sx={{marginTop: 2}} id="modal-modal-title" variant="h6" component="h2">
                            Categoria: 
                        </Typography>
                        <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                            {draft.category}
                        </Typography>
                    </Stack>
                </Stack>        
                <Stack direction={"row"} spacing={2} justifyContent={"center"} sx={{marginTop: 2}}>
                    <ModalDraftEdit draft={draft} updateDraft={updateDraft}/>
                    <Button onClick={handlerSubmit} variant="outlined">
                        Completar
                    </Button>
                    <ModalRecipe editMode={false} user={user}
                                 open={open} setOpen={setOpen} rcp={recipe}
                                 draftMode={true}
                                 draft={draft} idCategory={draft.category}/>
                </Stack>
            </Stack>
        </Paper>
  );
}