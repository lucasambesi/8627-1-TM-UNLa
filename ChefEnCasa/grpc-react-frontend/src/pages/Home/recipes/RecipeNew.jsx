import { Button, Card, CardActions, CardContent, CardMedia, Stack, Typography } from "@mui/material";
import React, { useEffect, useState } from "react";
import { useNavigate } from 'react-router'
import unla_logo from '../../../assets/unla_logo.png'
export const RecipeNew = (props) => {

    const { recipe } = props;
    const navigate = useNavigate();

    const handleDetalles = () => {
        navigate(`/recipe/${recipe.recipeId}`)
      };

    return (
        <Card elevation={3} sx={{ maxWidth: 200, minWidth: 200, minHeight: 150, marginTop: 4, marginRight: 3 }}>
            <CardMedia
                component="img"
                height="120"
                image={unla_logo}
                alt="Imagen"
            />
            <CardContent sx={{justifyContent:'center', minHeight:'120px'}}>
                <Typography gutterBottom variant="body1" component="div" sx={{fontWeight: "bold"}}>
                    {recipe.title.length > 20
                    ? `${recipe.title.slice(0, 37)}...`
                    : recipe.title}
                </Typography>
                <Typography gutterBottom variant="body2" component="div">
                    {`Creada por @${recipe.username}`}
                </Typography>
            </CardContent>
            <CardActions sx={{justifyContent:'center', alignContent:'end'}}>
                <Button onClick={handleDetalles}>DETALLES</Button>       
            </CardActions>
        </Card>
    );
  }
