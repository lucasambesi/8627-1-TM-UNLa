import React, { useEffect, useState } from "react";

import { Container, Button, Paper, Divider, Rating } from "@mui/material";
import Typography from '@mui/material/Typography';
import Stack from '@mui/material/Stack';

import { useLocalStorage } from '../../helpers/useLocalStorage';

import { categoryPresenter } from '../../presenter/CategoryPresenter'
import { stepPresenter } from '../../presenter/StepPresenter'
import { userPresenter } from '../../presenter/UserPresenter'
import { recipePresenter } from '../../presenter/RecipePresenter'

import { useParams } from 'react-router-dom';
import { ModalRecipe } from "./ModalRecipe";
import { Comments } from "./Recipe/Comments";
import { CustomRating } from "./Recipe/Rating";

export const Recipe = () => {

    const { recipeId } = useParams();

    const [user, setUser] = useLocalStorage('user')

    const [category, setCategory] = useState({});
    const [steps, setSteps] = useState([]);
    const [autor, setAutor] = useState({});
    const [recipe, setRecipe] = useState({});
    const [isFavorite, setIsFavorite] = useState(false);

    const [openEdicion, setOpenEdicion] = useState(false);
    const [RecipeAEditar, setProductoAEditar] = useState({});
    const [esEdicion, setEsEdicion] = useState(false);

    const { getById: getByIdRecipe } = recipePresenter()
    const { getCategoryById } = categoryPresenter()
    const { getStepsByRecipeId } = stepPresenter()
    const { getById, addFollowing, deleteToFavorites, addToFavorites, isInFavorites } = userPresenter()

    useEffect(() => {
        getByIdRecipe(recipeId)
          .then((res) => {
            setRecipe(res)

            getCategoryById(res.idCategory)
            .then((response) => {
              setCategory(response)
            })
            .catch((err) => console.log(err));

            getStepsByRecipeId(recipeId)
            .then((response) => {
              setSteps(response)
            })
            .catch((err) => console.log(err));

            getById(res.idUser)
            .then((response) => {            
              setAutor(response.user)
            })
            .catch((err) => console.log(err));

            isInFavorites(user.idUser, recipeId)
            .then((response) => {
                setIsFavorite(response)
            })
            .catch((err) => console.log(err));

          })
          .catch((err) => console.log(err));
    }, [])

    const abrirModalEdicion = (recipe) => {
        setProductoAEditar(recipe)
        setEsEdicion(true)
        setOpenEdicion(true);
    };

    const isIdInFollowing = (id) => user.following.some(item => item.idUser === id);

    const follow = () =>{
        addFollowing(user.idUser, recipe.idUser)        
            .then((res) => {
                let userTemp = user
                userTemp.following.push(autor);

                setUser(userTemp)
                alert(`Seguiste a ${autor.name} ${autor.lastName}`)
            })
            .catch((err) => console.log(err));
    } 

    const addToFavorite = (recipe) => {
        addToFavorites(user.idUser, recipe.idRecipe, recipe.idUser)
        .then((res) => {
          if(res)
            alert(`${recipe.title} agregada a favoritos`)
        })
        .catch((err) => console.log(err));
      };

    const deleteFavorite = (recipe) =>{
        deleteToFavorites(user.idUser, recipe.idRecipe, recipe.idUser)
        .then((res) => {
          if(res)
            alert(`${recipe.title} eliminada de favoritos`)
        })
        .catch((err) => console.log(err));
      } 

    return (
        <Container maxWidth="lg" sx={{ marginTop:'2%'}}>
            <Paper elevation={3} sx={{padding:"20px"}}>

                <Stack direction="row" justifyContent={"space-between"} sx={{ marginTop:'20px'}}>
                    <Typography id="modal-modal-title" align="center" variant="h4" component="h2">
                            {recipe.title}
                    </Typography>
                    <Stack direction={"row"} spacing={3} alignItems={"center"}>
                        <CustomRating idRecipe={recipeId} user={user} readOnly={"true"}/>
                        {
                            (user.idUser == autor.idUser) 
                            ? 
                            <Button variant="outlined" onClick={() => abrirModalEdicion(recipe)}>Editar</Button> 
                            : 
                            (
                            (!isFavorite)
                            ?
                            <Button variant="outlined" onClick={() => addToFavorite(recipe)}>Agregar a Fav</Button>
                            :
                            <Button variant="outlined" onClick={() => deleteFavorite(recipe)}>Eliminar Fav</Button>
                            )
                        }
                    </Stack>
                </Stack>  
                <Typography id="modal-modal-description" sx={{ mt: 2, marginTop:"50px" }}>
                    La receta te tomara aproximadamente {recipe.preparationTime} minutos.
                </Typography>               
                <Typography sx={{marginTop: 2}} id="modal-modal-title" variant="h6" component="h2">
                    Categoria: 
                </Typography>
                <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                    {category.name}
                </Typography>
                <Typography sx={{marginTop: 2}} id="modal-modal-title" variant="h6" component="h2">
                    Creada por: 
                </Typography>
                <Stack direction={{ xs: 'column', sm: 'row' }} justifyContent={"space-between"} alignContent={"center"}>
                    <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                        {`${autor.name} ${autor.lastName}`}
                    </Typography>
                    {
                        (recipe.idUser != user.idUser)
                        ?
                        (
                            (isIdInFollowing(autor.idUser))
                            ?
                            <Button variant="outlined" size='small'disabled='true'>
                                Siguiendo
                            </Button>
                            :
                            <Button variant="outlined" size='small' onClick={follow}>
                                Seguir
                            </Button>
                        )
                        :
                        null
                    }
                </Stack>

                <Typography sx={{marginTop: 2}} id="modal-modal-title" variant="h6" component="h2">
                    Ingredientes:
                </Typography>                
                <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                    {(recipe.ingredients != "") ? recipe.ingredients : "No posee ingredientes"}
                </Typography>
                <Typography sx={{marginTop: 2}} id="modal-modal-title" variant="h6" component="h2">
                    Pasos:
                </Typography>                
                {
                    steps ? steps.map((step , index) =>{
                    return (
                        <Typography key={step.idStep} id="modal-modal-description" sx={{ mt: 2 }}>
                           Paso {index + 1}: {step.description}
                        </Typography>
                        )
                    })
                    : "No posee pasos"
                } 
                <Divider component="div" variant="fullWidth" sx={{marginTop: "20px"}} />
                <Stack spacing={2} sx={{marginTop:"20px"}}>
                    {
                        (recipe.idUser != user.idUser)
                        ?
                        <Stack spacing={2}>
                            <Typography sx={{marginTop: 2}} id="modal-modal-title" variant="h6" component="h2">
                                Tu valoración:
                            </Typography>
                            <CustomRating idRecipe={recipeId} user={user} readOnly={"false"}/>
                        </Stack>
                        :
                        null
                    } 
                    <Comments recipe={recipe} idRecipe={recipeId} user={user}/>
                </Stack>
            </Paper>
            <ModalRecipe editMode={true} user={user} open={openEdicion} setOpen={setOpenEdicion} rcp={RecipeAEditar} idCategory={""}/>
        </Container>
    );
  }
