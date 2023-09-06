import React, { useEffect, useState } from "react";
import { recipePresenter } from '../presenter/RecipePresenter'
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';

import {Recipe} from "./Recipes/Recipe";

const Home = (props) => {
   const [recipes, setRecipes] = useState([]);
   const {getRecipes} = recipePresenter()
   
    useEffect(() => {
      getRecipes()
        .then((res) => {
          setRecipes(res)
        })
        .catch((err) => console.log(err));
    }, []);

    return (
      <Box sx={{ flexGrow: 1, margin: 5, alignContent:'center' }}>
        <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
          {
              recipes ? recipes.map((recipe) =>{
              return (
                  <Recipe recipe={recipe} key={recipe.idRecipe}/>
                )
              })
              : null
          }
        </Grid>
      </Box>
    );
  }

export default Home;