import React, { useState } from 'react';
import Papa from 'papaparse';
import { Box, Button, Container, Grid } from '@mui/material';
import { useNavigate } from 'react-router'

export const CsvUploader = () => {
  const [csvData, setCsvData] = useState(null);
  const navigate = useNavigate();

  const handleCsvUpload = (event) => {
    const file = event.target.files[0];
    
    Papa.parse(file, {
      complete: (result) => {
        console.log("🚀 ~ file: CsvUploader.jsx:12 ~ handleCsvUpload ~ result:", result)
        setCsvData(result.data);
      },
      header: true,
    });
  };

  const handleDrafts = () => {
    alert("Borradores subidos con exito")
    navigate("/recipes")
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
                                <strong>Título:</strong> {row.título},{' '}
                                <strong>Descripción:</strong> {row.descripción},{' '}
                                <strong>Categoría:</strong> {row.categoría},{' '}
                                <strong>Tiempo de Preparación:</strong> {row['tiempo de preparación']}
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