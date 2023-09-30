import React, { useEffect, useState } from "react";
import { recipePresenter } from '../../../presenter/RecipePresenter'
import { Box, Button, Divider, FormControl, Grid, Input, InputAdornment, InputLabel, List, ListItem, ListItemText, OutlinedInput, Pagination, Paper, Stack, Typography } from "@mui/material";
import CommentIcon from '@mui/icons-material/Comment';

import { commentPresenter } from '../../../presenter/CommentPresenter'

export const Comments = (props) => {

    const { getComments } = commentPresenter()

        const { sendCommentKafka } = recipePresenter()
        
        const { user, recipe } = props;

        const [comments, setComments] = useState(null);

        const [comment, setComment] = useState("")

        const [page, setPage] = React.useState(1);

        useEffect(() => {
            getComments(recipe.idRecipe, 3, page)
            .then((res) => {      
              console.log("🚀 ~ file: Comments.jsx:22 ~ .then ~ res:", res)
              if(res){
                setComments(res)
              }
            })
            .catch((err) => console.log(err));
        }, []);

    
        const  handleChangePagination = async (event, value) => {
            setPage(value) 
            
            getComments(recipe.idRecipe, 3, page)
            .then((res) => {
              if(res){
                setComments(res)
              }
            })
            .catch((err) => console.log(err));
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
                                        primary={comment.name}
                                        secondary={
                                            <React.Fragment>
                                            <Typography
                                                sx={{ display: 'inline', marginTop:"10px" }}
                                                component="span"
                                                variant="body2"
                                                color="text.primary"
                                            >
                                                {"@" + comment.username + " dijo : "}
                                            </Typography>
                                                {comment.value}
                                            </React.Fragment>
                                        }
                                        />
                                    </Paper>
                                </ListItem>
                            )
                            })                        
                            : 
                            <ListItem alignItems="flex-start">
                                <Paper elevation={3} sx={{width:"100%", padding:"2%"}}>
                                    <h4>
                                        No hay comentarios aún.
                                    </h4>
                                </Paper>
                            </ListItem>
                        }
                    </List>
                    <Box sx={{ alignSelf:'center' }}>
                        {
                            comments ? <Pagination count={5} page={page} onChange={handleChangePagination} /> : null
                        }                
                    </Box>
            </Stack>
        </Box>
     );
   }