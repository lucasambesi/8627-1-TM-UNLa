import React, { useEffect, useState } from "react";
import unlalogo from '../assets/unla_logo.png'; 
import { recipePresenter } from '../presenter/RecipePresenter'
import { experimentalStyled as styled } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { Button, CardActionArea, CardActions } from '@mui/material';

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(2),
  textAlign: 'center',
  color: theme.palette.text.secondary,
}));

const Home = () => {
   const [recipes, setRecipes] = useState([]);
   const {getRecipes} = recipePresenter()
   
    useEffect(() => {
      getRecipes()
        .then((data) => {
          setRecipes(data.recipes)
          console.log('recetas: ', recipes)
        })
        .catch((err) => console.log(err));
    }, []);

    return (
      <Box sx={{ flexGrow: 1, margin: 5 }}>
        <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
          {
              recipes ? recipes.map((recipe) =>{
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
                )
              })
              : null
          }
        </Grid>
      </Box>
    );
  }

export default Home;