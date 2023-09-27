import React, { useEffect, useState } from "react";
import { recipePresenter } from '../../presenter/RecipePresenter'
import {Box } from "@mui/material";
import { RecipeNew } from "./recipes/RecipeNew";
import CircularProgress from '@mui/material/CircularProgress';

export const News = (props) => {
    
    const COUNT_MAX_RECIPES = 5

    const [news, setNews] = useState(null);

    const [loading, setLoading] = useState(true);
    
    const {getKafkaRecipes} = recipePresenter()

    useEffect(() => {
        getKafkaRecipes(COUNT_MAX_RECIPES)
          .then((res) => {
            setNews(res)
            setLoading(false)
          })
          .catch((err) => console.log(err));
      }, [])

    return (
        <>
            {
                !loading ?
                (
                    news ? news.map((recipe) =>{
                        return (<RecipeNew recipe={recipe}/>)
                    })
                    : 
                    <Box sx={{ flexGrow: 1, margin: 12, alignContent:'center' }}>
                    <h4>
                        No hay novedades para ver!
                    </h4>
                    </Box>
                )
                :
                <Box sx={{ display: 'flex', justifySelf:'center', alignSelf:'center' }}>
                    <CircularProgress />
                </Box>
            }
        </>        
    );
  }