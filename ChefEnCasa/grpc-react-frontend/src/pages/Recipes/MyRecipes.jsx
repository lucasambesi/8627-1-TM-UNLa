import React, { useEffect, useState } from "react";
import { recipePresenter } from '../../presenter/RecipePresenter'
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import { Container } from "@mui/material";
import { useNavigate } from 'react-router'

import {Recipe} from "./Recipe";

export const MyRecipes = (props) => {
    const [recipes, setRecipes] = useState([]);
    const {getRecipesByUserId} = recipePresenter()
    const { user } = props;


     useEffect(() => {
       getRecipesByUserId(user.idUser)
         .then((res) => {
           setRecipes(res)
         })
         .catch((err) => console.log(err));
     }, []);
 
     return (
        <Container sx={{  justifySelf:'center', alignSelf: 'center', marginTop:'2%'}}>     
            <Box sx={{ flexGrow: 1, margin: 5, alignContent:'center' }}>
                <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
                {
                    recipes ? recipes.map((recipe) =>{
                    return (
                        <Recipe editMode={true} recipe={recipe} key={recipe.idRecipe}/>
                        )
                    })
                    : null
                }
                </Grid>
            </Box>
        </Container>
     );
   }