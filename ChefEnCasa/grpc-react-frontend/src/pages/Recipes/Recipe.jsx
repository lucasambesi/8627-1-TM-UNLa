import React from "react";
import unlalogo from '../../assets/unla_logo.png'; 
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { Button, CardActionArea, CardActions } from '@mui/material';

const Recipe = (props) => {
   const {recipe} = props

    return (
        <Card elevation={3} sx={{ maxWidth: 345, minWidth: 345, margin: 2 }}>
            <CardActionArea>
                <CardMedia
                    component="img"
                    height="140"
                    image={unlalogo}
                    alt="unlalogo"
                />
                <CardContent>
                    <Typography gutterBottom variant="h5" component="div">
                    {recipe.title}
                    </Typography>
                    <Typography variant="body2" color="text.secondary">
                    {recipe.description}
                    </Typography>
                </CardContent>
            </CardActionArea>
            <CardActions>
            <Button size="small" color="primary">
                Ver detalles
            </Button>
            </CardActions>
        </Card>
    );
  }

export default Recipe;