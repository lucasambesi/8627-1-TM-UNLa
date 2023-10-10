import React, { useState } from 'react';
import Papa from 'papaparse';
import { Box, Button, Container, Grid } from '@mui/material';
import { useNavigate } from 'react-router'
import { draftPresenter } from '../presenter/DraftPresenter'
export const CsvUploader = (props) => {

  const {user } = props
  const [csvData, setCsvData] = useState(null);
  const navigate = useNavigate();
  const { addDrafts } = draftPresenter()


  const handleCsvUpload = (event) => {
    const file = event.target.files[0];
    
    Papa.parse(file, {
      complete: (result) => {
        setCsvData(result.data);
      },
      header: true,
    });
  };

  const handleDrafts = () => {
    addDrafts(csvData, user.idUser)
    .then((res) => {
        alert("Borradores subidos con exito")
        navigate("/recipes")
    })
    .catch((err) => console.log(err));
  };

  return (
    <Container sx={{  justifySelf:'center', alignSelf: 'center'}}>
        <Box sx={{ flexGrow: 1, marginLeft: 12, alignContent:'center' }}>
        <h2>Subir Archivo CSV</h2>
        <input type="file" accept=".csv" onChange={handleCsvUpload} />
        {
            csvData
            ?
                <>
                        <h3>Contenido del CSV:</h3>
                        <Grid container rowSpacing={2} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
                            {csvData.map((row, index) => (
                            <li key={index}>
                                <strong>{"Receta " + (index + 1) + ": "}</strong>
                                <strong>Título:</strong> {row.title},{' '}
                                <strong>Descripción:</strong> {row.description},{' '}
                                <strong>Categoría:</strong> {row.category},{' '}
                                <strong>Tiempo de Preparación:</strong> {row.preparationTime},{' '}
                            </li>
                            ))}
                        </Grid>
                </>
            :
            null
        }
        </Box>
        <Button onClick={handleDrafts}>SUBIR</Button>       
    </Container>
  );
};