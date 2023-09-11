import React, { useEffect, useState } from "react";
import { recipePresenter } from '../presenter/RecipePresenter'
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import {Recipe} from "./Recipes/Recipe";
import Fab from '@mui/material/Fab';
import AddIcon from '@mui/icons-material/Add';
import { Container } from "@mui/material";
import { useNavigate } from 'react-router'

const fabStyle = {
  position: 'absolute',
  bottom: 30,
  right: 30,
};

const Home = (props) => {
   const [recipes, setRecipes] = useState([]);
   const {getRecipes} = recipePresenter()

   const navigate = useNavigate();
   
   const toCreateRecipe = () => { navigate("/create-recipe") }

    useEffect(() => {
      getRecipes()
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
                    <Recipe editMode={false} recipe={recipe} key={recipe.idRecipe}/>
                  )
                })
                : null
            }
          </Grid>
          <Fab color="primary" aria-label="add" sx={fabStyle} onClick={toCreateRecipe}>
            <AddIcon />
          </Fab>
        </Box>
      </Container>
    );
  }

export default Home;