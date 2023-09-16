import React, { useEffect, useState } from "react";
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import { Container } from "@mui/material";

import { recipePresenter } from '../../presenter/RecipePresenter'
import { userPresenter } from '../../presenter/UserPresenter'

import PaginationControlled from "../../components/Shared/Pagination";
import { FilterRecipes } from "../../pages/Recipes/FilterRecipes";
import {Recipe} from "../Recipes/Recipe";

export const SearchRecipe = (props) => {
   const [recipes, setRecipes] = useState([]);
   const { user } = props;
   const {getByFilter} = recipePresenter()
   const {addToFavorites} = userPresenter()

   const [filter, setFilter] = useState({
        category: {"idCategory": 0},
        title: "",
        ingredients: "",
        timeSince: 0,
        timeUntil: 1000,
        pageNumber: 1,
        pageSize:6,
    })

    useEffect(() => {
      getByFilter(filter)
        .then((res) => {
          console.log(res)
          setRecipes(res)
        })
        .catch((err) => console.log(err));
    }, []);

    const addToFavorite = (recipe) => {
      addToFavorites(user.idUser, recipe.idRecipe)
      .then((res) => {
        if(res)
          alert(`${recipe.title} agregada a favoritos`)
      })
      .catch((err) => console.log(err));
    };

    return (
      <Container sx={{ marginTop:'2%'}}>        
        <Box sx={{ flexGrow: 1, margin: 5, }}>
          <Grid container justifyContent={"center"} rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
            <FilterRecipes filter={filter} setFilter={setFilter} setRecipes={setRecipes}/>
            {
                recipes ? recipes.map((recipe) =>{
                return (
                    <Recipe idUser={user.idUser} editMode={false} recipe={recipe} favoriteMode={false} favorite={addToFavorite} key={recipe.idRecipe}/>
                  )
                })
                : 
                <Box sx={{ flexGrow: 1, margin: 12, alignContent:'center' }}>
                  <h4>
                    No hay recetas que se ajusten a la busqueda!
                  </h4>
                </Box>
            }
          </Grid>
          <Grid container justifyContent={"center"} rowSpacing={1} columnSpacing={{ xs: 25}} marginTop={"40px"}>
            <PaginationControlled filter={filter} setFilter={setFilter} setRecipes={setRecipes}/>
          </Grid>
        </Box>
      </Container>
    );
  }