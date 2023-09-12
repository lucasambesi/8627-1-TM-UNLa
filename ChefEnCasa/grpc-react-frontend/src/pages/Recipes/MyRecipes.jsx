import React, { useEffect, useState } from "react";
import { recipePresenter } from '../../presenter/RecipePresenter'
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import { Container } from "@mui/material";
import Fab from '@mui/material/Fab';
import AddIcon from '@mui/icons-material/Add';

import {Recipe} from "./Recipe";
import { ModalRecipe } from "./ModalRecipe";

const fabStyle = {
    position: 'absolute',
    bottom: 30,
    right: 30,
  };

export const MyRecipes = (props) => {
    const {getRecipesByUserId} = recipePresenter()
    const { user } = props;

    const [open, setOpen] = useState(false);
    const [esEdicion, setEsEdicion] = useState(false);
    const [openEdicion, setOpenEdicion] = useState(false);
    const [productoAEditar, setProductoAEditar] = useState({});

    const [recipes, setRecipes] = useState([]);
    const [recipe, setRecipe] = useState({
        idRecipe: "",
        title: "",
        description: "",
        ingredients: "",
        preparationTime: "",
        idCategory: "",
        idUser: "",
        images: [],
        steps: []
      });

     useEffect(() => {
       getRecipesByUserId(user.idUser)
         .then((res) => {
           setRecipes(res)
         })
         .catch((err) => console.log(err));
     }, []);

     const abrirModalCreacion = () => {
        setEsEdicion(false)
        setOpen(true);
      };

      const abrirModalEdicion = (recipe) => {
        setProductoAEditar(recipe)
        console.log("receta a editar", productoAEditar)
        setEsEdicion(true)
        setOpenEdicion(true);
      };
 
     return (
        <Container sx={{  justifySelf:'center', alignSelf: 'center', marginTop:'4%'}}>     
            <Box sx={{ flexGrow: 1, margin: 5, alignContent:'center' }}>
                <Grid container rowSpacing={2} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
                {
                    recipes ? recipes.map((recipe) =>{
                    return (
                        <Recipe editMode={true} edit={abrirModalEdicion} recipe={recipe} key={recipe.idRecipe}/>
                        )
                    })
                    : null
                }
                </Grid>
            </Box>
            <Fab color="primary" aria-label="add" sx={fabStyle} onClick={abrirModalCreacion}>
                <AddIcon />
            </Fab>
            <ModalRecipe editMode={false} user={user} open={open} setOpen={setOpen} rcp={recipe} />
            <ModalRecipe editMode={true} user={user} open={openEdicion} setOpen={setOpenEdicion} rcp={productoAEditar} />
        </Container>
     );
   }