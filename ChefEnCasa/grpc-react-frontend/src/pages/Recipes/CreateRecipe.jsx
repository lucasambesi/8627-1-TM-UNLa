import React, { useEffect, useState } from "react";
import { recipePresenter } from '../../presenter/RecipePresenter'
import { categoryPresenter } from '../../presenter/CategoryPresenter'
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import { useNavigate } from 'react-router'
import { useParams } from 'react-router-dom';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import { Button, Container, Paper, TextField, Typography } from "@mui/material";
import Alert from '@mui/material/Alert';

export const CreateRecipe = (props) => {
    const [recipe, setRecipe] = useState(null);
    const {getById, addRecipe, updateRecipe} = recipePresenter()

    const navigate = useNavigate();
    const {user} = props

    const { idRecipe: id } = useParams();
    const [idRecipe, setIdRecipe] = useState(decodeURIComponent(id));

    const [visible, setVisible] = useState(false);
    const [cargando, setCargando] = useState(true);
  
    const [ingredients, setIngredients] = useState("");
    const [errIngredients, setErrIngredients] = useState("");
  
    const [preparationTime, setPreparationTime] = useState("");
    const [errPreparationTime, setErrPreparationTime] = useState("");
  
    const [title, setTitle] = useState("");
    const [errTitle, setErrTitle] = useState("");
  
    const [description, setDescription] = useState("");
    const [errDescription, setErrDescription] = useState("");
  
    const [alertMsg, setAlertMsg] = useState("");
    const [alertSeverity, setAlertSeverity] = useState("")

    const [category, setCategory] = useState('');
    const [errCategory, setErrCategory] = useState("");
  
    const [categories, setCategories] = useState(null);

    const { getCategories } = categoryPresenter()
    
    useEffect(() => {
        getCategories()
          .then((res) => {
            setCategories(res)
          })
          .catch((err) => console.log(err));
      }, [])

      useEffect(() => {
        if(idRecipe){
            getById(id)
            .then((res) => {
              setRecipe(res)
            })
            .catch((err) => console.log(err));
        }
      }, [])

      useEffect(() => {
        if(recipe){
            const cat = categories.filter((element) => element.idCategory == recipe.idCategory);

            setTitle(recipe.title)
            setDescription(recipe.description)
            setCategory(cat[0])
            setPreparationTime(recipe.preparationTime)
            setIngredients(recipe.ingredients)
        }
      }, [recipe, categories])

    const call_setTitle = (val) => {
      if (val === "") {
        setErrTitle("Este campo no puede estar vacio")
      } else {
        setErrTitle("")
      }
      setTitle(val)
    }
  
    const call_setDescription = (val) => {
      if (val === "") {
        setErrDescription("Este campo no puede estar vacio")
      } else {
        setErrDescription("")
      }
      setDescription(val)
    }
  
    const call_setIngredients = (val) => {
      if (val === "") {
        setErrIngredients("Este campo no puede estar vacio")
      } else {
        setErrIngredients("")
      }
      setIngredients(val)
    }
  
    const call_setPreparationTime = (val) => {
      if (val === "") {
        setErrPreparationTime("Este campo no puede estar vacio")
      } else {
        setErrPreparationTime("")
      }
      setPreparationTime(val)
    }
  
    const clear = () => {
      setIngredients("");
      setPreparationTime("");
      setDni("");
      setEmail("");
      setTitle("");
      setDescription("");
  
      setErrIngredients("");
      setErrPreparationTime("");
      setErrDni("");
      setErrEmail("");
      setErrTitle("");
      setErrDescription("");
  
      setVisible(false);
  
    }
  
    const validate = () => {
      let retorno = true;
      if (title === "") {
        setErrTitle("Este campo es requerido");
        retorno = false;
      }
      if (description === "") {
        setErrDescription("Este campo es requerido");
        retorno = false;
      }
      if (ingredients === "") {
        setErrIngredients("Este campo es requerido");
        retorno = false;
      }
      if (preparationTime === "") {
        setErrPreparationTime("Este campo es requerido");
        retorno = false;
      }
      if (category === null) {
        setErrPreparationTime("Este campo es requerido");
        retorno = false;
      }
  
      return retorno;
    }

    const goHome = () => {
        navigate("/home")
        clear()
    }

    const handleChange = (event) => {
        setCategory(event.target.value);
    };
  
    const send = async () => {

    console.log("user =", user)
      const formOK = validate();
      if (formOK) {
        try {
            const newRecipe = {
                "idUser": user.idUser,
                "idRecipe": idRecipe,
                "title": title,
                "description": description,
                "ingredients": ingredients,
                "idCategory": category.idCategory,
                "preparationTime": preparationTime
            }

            if(!recipe){
                await addRecipe(newRecipe)
                alert("Receta creada")

                navigate("/home")
            }else{
                await updateRecipe(newRecipe)
                alert("Receta actualizada")

                navigate("/recipes")
            }
          
        } catch (error) {
          console.log(error)
          setAlertSeverity("error")
          setAlertMsg("Error, intente nuevamente")
        }
  
      }
    }
 
     return (
        <>        
            <Box m={8} />
            <Container maxWidth="sm" >
            <Paper elevation={3}>
                <Box m={3} >
                    <Grid container spacing={2}>
                        <Grid container item justifyContent="center" >
                            <Box m={3}>
                                <Typography variant="h5" color="initial"> 
                                {
                                    (recipe) ? "Editar receta" : "Crear receta"
                                }  
                                </Typography>
                            </Box>
                        </Grid>
                        <Grid item container>
                            <TextField
                                fullWidth
                                id="title"
                                label="Titulo"
                                variant="outlined"
                                value={title}
                                onChange={e => { call_setTitle(e.target.value) }}
                                error={errTitle !== "" ? true : false}
                                helperText={errTitle}
                            />
                        </Grid>
                        <Grid item container>
                            <TextField
                                fullWidth
                                multiline
                                id="description"
                                label="Descripción"
                                variant="outlined"
                                rows={4}
                                value={description}
                                onChange={e => { call_setDescription(e.target.value) }}
                                error={errDescription !== "" ? true : false}
                                helperText={errDescription}
                            />
                        </Grid>                        
                        <Grid container item>
                            <TextField
                                fullWidth
                                multiline                              
                                id="ingredients"
                                label="Ingredientes"
                                variant="outlined"
                                rows={4}
                                value={ingredients}
                                onChange={e => { call_setIngredients(e.target.value) }}
                                error={errIngredients !== "" ? true : false}
                                helperText={errIngredients}
                            />
                        </Grid>
                        <Grid container item>
                            <TextField
                                fullWidth
                                id="preparationTime"
                                label="Tiempo de preparación"
                                variant="outlined"
                                value={preparationTime}
                                onChange={e => { call_setPreparationTime(e.target.value) }}
                                error={errPreparationTime !== "" ? true : false}
                                helperText={errPreparationTime}
                            />
                        </Grid>
                    </Grid>
                    <Box sx={{ minWidth: 120, marginTop:2 }}>
                        <FormControl fullWidth>
                            <InputLabel id="demo-simple-select-label">Categoria</InputLabel>
                            <Select
                            labelId="demo-simple-select-label"
                            id="demo-simple-select"
                            value={category}
                            label="Categoria"
                            onChange={handleChange}
                            >
                            {
                                categories ? categories.map((category , index) =>{
                                    return (
                                        <MenuItem id={category.id} value={category}>
                                            {category.name}
                                        </MenuItem>
                                        )
                                    })
                                    : null
                            }                            
                            </Select>
                        </FormControl>
                    </Box>
                </Box>
                <Box display="flex" justifyContent="center">
                {
                    alertMsg ?
                    <Alert severity={alertSeverity}>{alertMsg} </Alert>
                    :
                    <></>
                }
                </Box>
                <Box pb={2} display="flex" justifyContent="space-around" alignItems="center">
                    <Button onClick={goHome} variant="outlined" color="primary">
                        Cancelar
                    </Button>
                    <Button onClick={send} variant="contained" color="primary">
                       {
                        (recipe) ? "Editar" : "Crear"
                       } 
                    </Button>
                </Box>
            </Paper >
            </Container>
        </>
     );
   }