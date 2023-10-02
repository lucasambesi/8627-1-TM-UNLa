import React, { useEffect, useState } from "react";
import { recipePresenter } from '../../../presenter/RecipePresenter'
import { Box, Button, List, ListItem, ListItemText, Paper, Stack, Typography } from "@mui/material";
import { useNavigate } from 'react-router'

export const TopRecipes = (props) => {

    const [recipes, setRecipes] = useState(null);
    
    const {getRecipesByPopularity} = recipePresenter()

    const navigate = useNavigate();

    const handleDetalles = (idRecipe) => {
      navigate(`/recipe/${idRecipe}`)
    };

    useEffect(() => {
        getRecipesByPopularity(5,1)
          .then((res) => {
            setRecipes(res)
          })
          .catch((err) => console.log(err));
      }, [])

    return (
        <Box width={"100%"}>
            <List>
                {
                    recipes ? recipes.map((recipe, index) =>{
                    return (
                        <ListItem alignItems="flex-start">
                            <Paper elevation={3} sx={{width:"100%", padding:"2%"}}>
                                <Stack direction={"row"} justifyContent={"space-between"}>
                                <Stack sx={{marginTop:"20px"}} justifyContent={"start"} alignItems={"start"} spacing={3}>
                                    <Stack>
                                        <Typography
                                            sx={{ display: 'inline' }}
                                            component="span"
                                            variant="h5"
                                            color="text.primary"
                                        >
                                            {recipe.title}
                                        </Typography>  
                                        <Typography
                                            sx={{ display: 'inline', marginTop:"10px" }}
                                            component="span"
                                            variant="body1"
                                            color="text.primary"
                                        >
                                            {"Acumula una popularidad de " + recipe.popularity + " puntos."}
                                        </Typography>
                                        <Box marginTop={"10px"}></Box>
                                        <Typography
                                            sx={{ display: 'inline', }}
                                            component="span"
                                            variant="body2"
                                            color="text.primary"
                                        >
                                            {recipe.description.length > 130
                                            ? `${recipe.description.slice(0, 127)}...`
                                            : recipe.description}
                                        </Typography>                                             
                                    </Stack>
                                
                                </Stack>
                                    <Stack sx={{marginTop:"20px"}} justifyContent={"start"} alignItems={"start"} spacing={3}>
                                        <Typography variant="h6" alignSelf={"center"} >
                                            {`Puesto #${index + 1}`}
                                        </Typography>
                                        <Button width={"4px"}  onClick={(() => handleDetalles(recipe.idRecipe))}>
                                                    DETALLES
                                        </Button>
                                    </Stack>
                                </Stack>
                            </Paper>
                        </ListItem>
                    )
                    })                        
                    : 
                    <ListItem alignItems="flex-start">
                        <Paper elevation={3} sx={{width:"100%", padding:"2%"}}>
                            <h4>
                            No hay recetas para ver!
                            </h4>
                        </Paper>
                    </ListItem>
                }
            </List>
        </Box>        
    );
  }