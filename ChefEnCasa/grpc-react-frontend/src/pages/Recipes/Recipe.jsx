import 'reactjs-popup/dist/index.css';

import React, { useEffect, useState }  from "react";
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import { Button, CardActionArea, CardActions } from '@mui/material';
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';

import { categoryPresenter } from '../../presenter/CategoryPresenter'
import { stepPresenter } from '../../presenter/StepPresenter'
import { userPresenter } from '../../presenter/UserPresenter'
import { SwipleableImages } from './SwipleableImages';

const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '2px solid #000',
    boxShadow: 24,
    p: 4,
  };

  export const Recipe = (props) => {
    const {recipe, editMode, edit} = props

    const [open, setOpen] = React.useState(false);
    const [category, setCategory] = useState({});
    const [steps, setSteps] = useState([]);
    const [autor, setAutor] = useState({});

    const { getCategoryById } = categoryPresenter()
    const { getStepsByRecipeId } = stepPresenter()
    const { getById } = userPresenter()

    useEffect(() => {
        getCategoryById(recipe.idCategory)
          .then((res) => {
            setCategory(res)
          })
          .catch((err) => console.log(err));
      }, [])

      useEffect(() => {
        getStepsByRecipeId(recipe.idRecipe)
          .then((res) => {
            setSteps(res)
          })
          .catch((err) => console.log(err));
      }, [])

      useEffect(() => {
        getById(recipe.idUser)
          .then((res) => {            
            setAutor(res.user)
          })
          .catch((err) => console.log(err));
      }, [])

      const handleOpen = () => setOpen(true);
      const handleClose = () => setOpen(false);  

    return (
        <Card elevation={3} sx={{ maxWidth: 300, minWidth: 300, marginTop: 4, marginRight: 3 }}>
            <CardActionArea>
                {
                    (recipe.images.length > 0) ? <SwipleableImages images={recipe.images} /> :<RecipeImages images={recipe.images} />
                }
            </CardActionArea>
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
            <Button onClick={handleOpen}>DETALLES</Button>
            {
                (editMode) ? <Button onClick={() => edit(recipe)}>Editar</Button> : null
            }
            
            <Modal
                open={open}
                onClose={handleClose}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description">
            <Box sx={style}>
                <Typography id="modal-modal-title" align="center" variant="h4" component="h2">
                    {recipe.title}
                </Typography>
                <Typography id="modal-modal-description" sx={{ mt: 2 }}>
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
                <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                    {`${autor.name} ${autor.lastName}`}
                </Typography>
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
            </Box>
            </Modal>
            </CardActions>
        </Card>
    );
  }
