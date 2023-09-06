import React from "react";
import unlalogo from '../../assets/unla_logo.png'; 
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { Button, CardActionArea, CardActions } from '@mui/material';
import CssBaseline from '@mui/material/CssBaseline';
import Popup from 'reactjs-popup';
import 'reactjs-popup/dist/index.css';

import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';

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

 export default  Recipe = (props) => {
    const {recipe} = props
    const [open, setOpen] = React.useState(false);
    const handleOpen = () => setOpen(true);
    const handleClose = () => setOpen(false);

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
            <Button onClick={handleOpen}>INGREDIENTES</Button>
            <Modal
                open={open}
                onClose={handleClose}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description">
            <Box sx={style}>
                <Typography id="modal-modal-title" variant="h6" component="h2">
                    {recipe.title}
                </Typography>
                <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                    {recipe.ingredients}
                </Typography>
                <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                    La receta te tomara aproximadamente {recipe.preparationTime} minutos.
                </Typography>
            </Box>
            </Modal>
            </CardActions>
        </Card>
    );
  }
