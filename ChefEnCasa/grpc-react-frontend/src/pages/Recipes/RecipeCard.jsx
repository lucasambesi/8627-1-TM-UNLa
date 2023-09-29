import 'reactjs-popup/dist/index.css';

import React from "react";
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import { Button, CardActions } from '@mui/material';
import { SwipleableImages } from './SwipleableImages';

import { useNavigate } from 'react-router'

  export const RecipeCard = (props) => {
    const {recipe } = props

    const navigate = useNavigate();

      const handleDetalles = () => {
        navigate(`/recipe/${recipe.idRecipe}`)
      };

    return (
        <Card elevation={3} sx={{ maxWidth: 300, minWidth: 300, minHeight: 425, marginTop: 4, marginRight: 3 }}>
            {
                (recipe.images.length > 0) 
                ? 
                    <SwipleableImages images={recipe.images} /> 
                :
                    <RecipeImages images={recipe.images} />
            }
            <CardContent>
                <Typography gutterBottom variant="h6" component="div">
                    {recipe.title.length > 40
                    ? `${recipe.title.slice(0, 37)}...`
                    : recipe.title}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                    {recipe.description.length > 100
                    ? `${recipe.description.slice(0, 97)}...`
                    : recipe.description}
                </Typography>
            </CardContent>
            <CardActions>
                <Button onClick={handleDetalles}>
                    DETALLES
                </Button>
            </CardActions>
        </Card>
    );
  }
