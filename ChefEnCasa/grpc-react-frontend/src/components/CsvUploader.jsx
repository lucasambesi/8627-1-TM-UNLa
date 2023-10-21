import React, { useState } from 'react';
import Papa from 'papaparse';
import { Box, Button, Container, Paper, Stack, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Typography } from '@mui/material';
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
    <Container sx={{  justifySelf:'center', alignSelf: 'center', marginTop:"40px"}}>
        <Paper elevation={0} sx={{ flexGrow: 1, alignContent:'center' }}>
          <Stack spacing={5}>
            <Typography id="modal-modal-title" align="center" variant="h5" component="h5">
              Subir Archivo CSV
            </Typography>
            <Stack spacing={3}>
              <Typography variant="h5" component="h5">
                Seleccionar archivo:
              </Typography>
              <input type="file" accept=".csv" onChange={handleCsvUpload} />
            </Stack>
          </Stack>
        
          {
            csvData
            ?
                <Stack marginTop={"20px"} spacing={5}>
                  <Typography id="modal-modal-title" variant="h5" component="h5">
                    Contenido del CSV:
                  </Typography>
                  <TableContainer component={Paper} elevation={3} >
                    <Table sx={{ minWidth: 650 }} aria-label="simple table">
                      <TableHead>
                        <TableRow >
                          <TableCell align="center" sx={{fontWeight: "bold"}}>
                            Borrador
                          </TableCell>
                          <TableCell align="center" sx={{fontWeight: "bold"}}>
                            Titulo
                          </TableCell>
                          <TableCell align="center" sx={{fontWeight: "bold"}}>
                            Descripción
                          </TableCell>
                          <TableCell align="center" sx={{fontWeight: "bold"}}>
                            Categoria
                          </TableCell>
                          <TableCell align="center" sx={{fontWeight: "bold"}}>
                            Tiempo de preparación
                          </TableCell>
                        </TableRow>
                      </TableHead>
                      <TableBody>
                        {csvData.map((row, index) => (
                          <TableRow
                            key={row.title}
                            sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                          >
                            <TableCell component="th" scope="row" align="center" sx={{fontWeight: "bold"}}>
                              {index + 1}
                            </TableCell>
                            <TableCell align="center">
                              {
                                row.title.length > 100
                                  ? `${row.title.slice(0, 97)}...`
                                  : row.title
                              }
                            </TableCell>
                            <TableCell align="center">
                              {
                                row.description.length > 100
                                  ? `${row.description.slice(0, 97)}...`
                                  : row.description
                              }
                            </TableCell>
                            <TableCell align="center">
                              {row.category}
                            </TableCell>
                            <TableCell align="center">
                              {row.preparationTime + " minutos"} 
                            </TableCell>
                          </TableRow>
                        ))}
                      </TableBody>
                    </Table>
                  </TableContainer>
                  <Button marginTop={"20px"} onClick={handleDrafts} variant="outlined">
                    SUBIR
                  </Button>
                </Stack>
            :
            null
          }
        </Paper>        
    </Container>
  );
};