import React, { useEffect, useState } from "react";
import { recipePresenter } from '../../presenter/RecipePresenter'
import { categoryPresenter } from '../../presenter/CategoryPresenter'
import { draftPresenter } from '../../presenter/DraftPresenter'
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import { useNavigate } from 'react-router'
import { Button, TextField, Typography, Dialog } from "@mui/material";
import {Files} from './Files'
import {SelectCategory} from './SelectCategory'
import StepsList from "./AddStepList";

export const ModalRecipe = (props) => {
    const navigate = useNavigate();

    const {addRecipe, updateRecipe} = recipePresenter()
    const { getCategories } = categoryPresenter()
    const { deleteDraft } = draftPresenter()
    const [descriptionLength, setDescriptionLength] = useState(0);
    const [steps, setSteps] = useState([]);

    const { user, 
            open,
            setOpen,
            editMode, 
            idCategory,
            draftMode,
            draft,
            rcp } = props
  
    const [recipe, setRecipe] = useState(rcp);
    const [category, setCategory] = useState("");
    const [categories, setCategories] = useState([]);

    useEffect(() => {
        setRecipe(rcp)
        if(rcp.description){
            setDescriptionLength(rcp.description.length)
        }
      }, [rcp])

      useEffect(() => {
            getCategories()
            .then((res) => {
                setCategories(res);
                if (idCategory && idCategory !== "") {
                    const foundCategory = res.find((cat) => cat.idCategory == idCategory);
                    if (foundCategory) {
                        setCategory(foundCategory);
                    }
                }
            })
            .catch((err) => console.log(err));
        }, []);

      useEffect(() => {
        setRecipe({ ...recipe, idCategory: category.idCategory })
      }, [category])

     const handleInputChange = (event) => {
        const name = event.target.name

        const value = event.target.type === "number"
            ? event.target.valueAsNumber : event.target.type === 'checkbox'
            ? event.target.checked : event.target.value

        if (name == "description") {
            if(value > 250){
                return;
            }
            else{
                setDescriptionLength(value.length);
            }
            
        }

        let temp = { ...recipe }
        temp[name] = value
        setRecipe(temp)
     }
  

     const createRecipe = async (event) => {
        event.preventDefault();
      
        if (!validateFields(recipe)) {
          return;
        }
      
        addRecipe({ ...recipe, idUser: user.idUser, steps: steps })
        .then((res) => {
            if(draftMode == true){
                deleteDraft(draft.draftId)
                .then((res) => {console.log("borrador eliminado: " + draft.draftId)})
                .catch((err) => console.log(err));
            }
          alert("Receta creada");
        }).then(() => {
          navigate("/recipes");
          close();
        });
      };
      
      const editRecipe = (event) => {
        event.preventDefault();
      
        if (!validateFields(recipe)) {
          return;
        }
      
        updateRecipe({ ...recipe, idUser: user.idUser }).then((res) => {
          alert("Producto Actualizado");
        }).then(() => {
          navigate("/recipes");
          close();
        });
      };

      const validateFields = (recipe) => {
        if (!recipe.title || !recipe.description || !recipe.ingredients || !recipe.preparationTime || !recipe.idCategory) {
          alert("Por favor, complete todos los campos obligatorios.");
          return false;
        }
        return true;
      };

    const close = () => {
        setOpen(false);
      }
 
     return (
        <Dialog
        open={open}
        onClose={close}>
            <Box m={2} >
                <Grid container spacing={2}>
                    <Grid container item justifyContent="center" >
                        <Box m={3}>
                            <Typography variant="h5" color="initial"> 
                            {
                                (editMode) ? "Editar receta" : "Crear receta"
                            }  
                            </Typography>
                        </Box>
                    </Grid>
                    <Grid item container>
                        <TextField
                            fullWidth
                            name="title"
                            label="Titulo"
                            variant="outlined"
                            defaultValue={recipe.title}
                            onChange={handleInputChange}
                        />
                    </Grid>
                    <Grid item container>
                        <TextField
                            fullWidth
                            multiline
                            name="description"
                            label={`Descripción (${descriptionLength}/250)`}
                            variant="outlined"
                            rows={4}
                            value={recipe.description}
                            onChange={handleInputChange}
                            inputProps={{
                                maxLength: 250 
                            }}
                            />
                    </Grid>                        
                    <Grid container item>
                        <TextField
                            fullWidth
                            multiline
                            name="ingredients"
                            label="Ingredientes"
                            variant="outlined"
                            rows={4}
                            defaultValue={recipe.ingredients}
                            onChange={handleInputChange}
                        />
                    </Grid>
                    <Grid container item>
                        <TextField
                            fullWidth
                            name="preparationTime"
                            label="Tiempo de preparación"
                            variant="outlined"
                            defaultValue={recipe.preparationTime}
                            onChange={handleInputChange}
                        />
                    </Grid>
                    <Grid item xs={12}>
                    {
                        (!editMode) ?
                        <SelectCategory categories={categories} setCategory={setCategory} category={category} />
                        :
                        <></>
                    }                        
                    </Grid>   
                </Grid>     
                <Grid item xs={12}>
                {
                    (!editMode) ?
                    <StepsList setSteps={setSteps} steps={steps}></StepsList>
                    :
                    <></>
                }
                </Grid>     
                <Grid item xs={12}>
                {
                    (!editMode) ?
                    <Files
                        form={recipe}
                        setForm={setRecipe}
                    />
                    :
                    <></>
                }
                </Grid>
            </Box>
            <Box pb={2} display="flex" justifyContent="space-around" alignItems="center">
                {
                    !editMode
                    ?
                        <Button onClick={createRecipe} variant="contained" color="primary">
                            Crear
                        </Button>
                    :
                        <Button onClick={editRecipe} variant="contained" color="primary">
                            Editar
                        </Button>
                }
                <Button onClick={close} variant="outlined" color="primary">
                    Cancelar
                </Button>
            </Box>
        </Dialog>
     );
   }