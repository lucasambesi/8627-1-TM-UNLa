import React, { useEffect, useState } from "react";
import { recipePresenter } from '../../presenter/RecipePresenter'
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';

import {Recipe} from "./Recipe";
import { Container } from "@mui/material";

export const FavoriteRecipes = (props) => {
    const [recipes, setRecipes] = useState([]);
    const {getFavorites} = recipePresenter()
    const { user } = props;

     useEffect(() => {
      getFavorites(user.idUser)
         .then((res) => {
          console.log("recipes = ", res)
           setRecipes(res)
         })
         .catch((err) => console.log(err));
     }, []);
 
     return (
      <Container sx={{  justifySelf:'center', alignSelf: 'center'}}>
        <Box sx={{ flexGrow: 1, margin: 5, alignContent:'center' }}>
          <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
            {
                recipes ? recipes.map((recipe) =>{
                return (
                    <Recipe recipe={recipe} favoriteMode={true} key={recipe.idRecipe}/>
                  )
                })
                : 
                <Box sx={{ flexGrow: 1, margin: 12, alignContent:'center' }}>
                  <h4>
                    No tienes recetas favoritas, cuando las tengas apareceran aqui!
                  </h4>
                </Box>
            }
          </Grid>
        </Box>
      </Container>
     );
   }