import React, { useEffect, useState } from "react";
import { recipePresenter } from '../../../presenter/RecipePresenter'
import { Box, Button, Divider, FormControl, Grid, Input, InputAdornment, InputLabel, List, ListItem, ListItemText, OutlinedInput, Pagination, Paper, Stack, Typography } from "@mui/material";
import CommentIcon from '@mui/icons-material/Comment';

export const Comments = (props) => {
        const [comments, setComments] = useState([
            { idUser: 1, comment: "Comentario 1" },
            { idUser: 2, comment: "Comentario 2" },
            { idUser: 3, comment: "Comentario 3" }
        ]);

        const [comment, setComment] = useState("")

        const { sendCommentKafka } = recipePresenter()
        const { user, recipe } = props;

        useEffect(() => {
        }, []);

        const [page, setPage] = React.useState(1);
    
        const  handleChangePagination = async (event, value) => {
            setPage(value)     
        }

        const call_setComment = (value) => {
            setComment(value) 
        }
    
        const sendComment = async () => {
            const sendPopularity = user.idUser != recipe.idUser

            if(comment != ""){
                sendCommentKafka(user.idUser, recipe.idRecipe, comment, sendPopularity)
                .then((res) => {
                    setComment("")
                    alert("¡El comentario fue enviado, se visualizará más tarde!")
                })
                .catch((err) => console.log(err));
            }else{
                alert("Ingresa un texto para poder enviar el comentario")
            }
        }
    
     return (
        <Box sx={{ flexGrow: 1, alignContent:'center' }}>
            <Stack spacing={1}>
                <Box>
                    <Typography id="modal-modal-title" variant="h6" component="h2">
                        Comentarios:
                    </Typography>
                </Box>
                    <List>
                        <ListItem alignItems="flex-start">
                            <Paper elevation={3} sx={{width:"100%", padding:"2%"}}>
                                <Stack spacing={1}>
                                    <Box>
                                        <FormControl fullWidth >
                                            <InputLabel htmlFor="outlined-adornment-comment">
                                                Enviar Comentario
                                            </InputLabel>
                                            <OutlinedInput
                                                id="outlined-adornment-comment"
                                                value={comment}
                                                onChange={e=>{call_setComment(e.target.value)}}
                                                startAdornment={<CommentIcon color="info" position="start" />}
                                                label="Comentario"
                                            />
                                        </FormControl>
                                    </Box>
                                    <Button color="info" variant="contained"
                                            onClick={sendComment}
                                            sx={{alignSelf:"end"}}>
                                        Enviar
                                    </Button>
                                </Stack>
                            </Paper>
                        </ListItem>
                        {
                            comments ? comments.map((comment) =>{
                            return (
                                <ListItem alignItems="flex-start">
                                    <Paper elevation={3} sx={{width:"100%", padding:"2%"}}>
                                        <ListItemText
                                        primary={"name of user " + comment.idUser}
                                        secondary={
                                            <React.Fragment>
                                            <Typography
                                                sx={{ display: 'inline' }}
                                                component="span"
                                                variant="body2"
                                                color="text.primary"
                                            >
                                                {"@username - "}
                                            </Typography>
                                                {comment.comment}
                                            </React.Fragment>
                                        }
                                        />
                                    </Paper>
                                </ListItem>
                            )
                            })                        
                            : 
                            <Paper elevation={3} sx={{width:"100%", padding:"2%"}}>
                                <h4>
                                    No hay comentarios aún.
                                </h4>
                            </Paper>
                        }
                    </List>
                <Box sx={{ alignSelf:'center' }}>
                    {
                        comments ? <Pagination count={10} page={page} onChange={handleChangePagination} /> : null
                    }                
                </Box>
            </Stack>
        </Box>
     );
   }