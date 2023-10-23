import React, { useEffect, useState } from "react";
import { bookPresenter } from '../../../presenter/BookPresenter'
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import { Container } from "@mui/material";
import { BooksTable } from "./BooksTable";
import { CreateBook } from "./ModalBook";


export const Books = (props) => {
    const {getBooksByUserId} = bookPresenter()
    const { user } = props;

    const [books, setBooks] = useState([]);

     useEffect(() => {
        getBooksByUserId(user.idUser, true)
            .then((res) => {
                if(res.length > 1){
                    setBooks(res)
                }else{
                    let array = []
                    array.push(res)
                    setBooks(array)
                }
            })
            .catch((err) => console.log(err));
     }, []);

     useEffect(() => {
     }, [books]);

     const updateBooks = () => {
        getBooksByUserId(user.idUser, true)
            .then((res) => {
                if(res.length > 1){
                    setBooks(res)
                }else{
                    let array = []
                    array.push(res)
                    setBooks(array)
                }
            })
            .catch((err) => console.log(err));
      };
 
     return (
        <Container sx={{  justifySelf:'center', alignSelf: 'center'}}>
            <Box sx={{ flexGrow: 1, marginTop:5,  marginLeft: 12, alignContent:'center' }}>
                <Grid container rowSpacing={2} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
                {
                    books.length > 0 ? 
                        <BooksTable books={books} updateBooks={updateBooks}/>
                    : 
                        <Box sx={{ flexGrow: 1, margin: 12, alignContent:'center' }}>
                        <h4>
                            No hay recetarios creados, puedes hacerlo desde el boton de abajo a la derecha!
                        </h4>
                        </Box>
                }
                </Grid>                
            </Box>
            <CreateBook user={user} updateBooks={updateBooks} books={books} />            
        </Container>
     );
   }