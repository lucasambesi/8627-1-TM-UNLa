import React, { useState, useEffect } from 'react';
import { Box, Button, Container, Divider, ImageList, ImageListItem, List, ListItemButton, Paper, Stack, Typography } from '@mui/material';
import { useNavigate } from 'react-router'
import { reportPresenter } from '../../presenter/ReportPresenter'
import { recipePresenter } from '../../presenter/RecipePresenter'
import ReportType from '../../helpers/ReportType';
import { SwipleableImages } from '../Recipes/SwipleableImages';

export const Reports = (props) => {

  const {user } = props
  const navigate = useNavigate();
  const { getAll, updateReport } = reportPresenter()
  const { getById, updateRecipe } = recipePresenter()
  const [reports, setReports] = useState(null);
  const [actualReport, setActualReport] = useState(null);
  const [recipe, setRecipe] = useState(null);
  const [idRecipe, setIdRecipe] = useState(null);

  useEffect(() => {
    getAll()
       .then((res) => {
        setReports(res)
        setIdRecipe(res[0].recipeId)
        setActualReport(res[0])
       })
       .catch((err) => console.log(err));
   }, []);

   useEffect(() => {
    if(idRecipe){
        getById(idRecipe)
        .then((res) => {
         setRecipe(res)
        })
        .catch((err) => console.log(err));
    }
   }, [idRecipe]);

   const handleClickReport = (report) => {
        setActualReport(report)
        setIdRecipe(report.recipeId)
    }

   const ignoreReport = () => {
        actualReport.resolved = true

        updateReport(actualReport)
        .then((res) => {
            const updatedReports = reports.filter(item => item.reportId != actualReport.reportId);
            setReports(updatedReports);
            setIdRecipe(updatedReports[0].recipeId)
            setActualReport(updatedReports[0])

            alert("Denuncia ignorada");
        })
        .catch((err) => console.log(err));
    };

    const deleteRecipe = (recipe) => {
        recipe.active = false
        console.log("🚀 ~ file: Reports.jsx:62 ~ deleteRecipe ~ recipe:", recipe)

        updateRecipe(recipe, recipe.idUser)
        .then((res) => {

            actualReport.resolved = true

            updateReport(actualReport)
            .then((res) => {

                const updatedReports = reports.filter(report => report.recipeId != recipe.idRecipe);
                setReports(updatedReports);
                setIdRecipe(updatedReports[0].recipeId)
                setActualReport(updatedReports[0])
    
                alert("Receta eliminada");
            })
            .catch((err) => console.log(err));
          })
          .catch((err) => console.log(err));
    };

   function GetType(report) {
        if(report != null){
            let result = ReportType[Object.keys(ReportType).find(key => ReportType[key].id === report.type)]
            if(result != null){
                return result.description;
            }
        }
   }

  return (
    <Container sx={{  justifySelf:'center', alignSelf: 'center', marginTop:"40px"}}>
        <Paper elevation={0} sx={{ flexGrow: 1, alignContent:'center' }}>
          <Stack spacing={5}>
            <Typography id="modal-modal-title" align="center" variant="h5" component="h5">
                Gestor de denuncias
            </Typography>
            <Box sx={{ flexGrow: 1, marginLeft: 12, marginTop:10 ,alignContent:'center' }}>
                <Stack spacing={3} direction={"row"} justifyContent={"center"}>
                    <Paper elevation={3} sx={{ width:"40%", minHeight:"500px"}}>
                        <Typography sx={{marginTop:"15px"}} id="modal-modal-title" align="center" variant="h5" component="h5">
                            Denuncias
                        </Typography>
                        <Box sx={{ flexGrow: 1, marginTop: 2, alignContent:'center' }}>
                            <List container rowSpacing={2} sx={{padding:"2%"}}>
                            {
                                reports ? reports.map((report) =>{
                                return (
                                    <Paper sx={{width:"100%", marginBottom: 1}} elevation={3}>
                                        <ListItemButton onClick={(() => handleClickReport(report))}>
                                            <Stack spacing={1} sx={{padding:"1.5%"}}>
                                                <Typography variant="body1" component="body1">
                                                    {`Denuncia a Receta con id: ${report.recipeId}`}
                                                </Typography>
                                                <Typography variant="body1" component="body1">
                                                    {`Motivo de denuncia: ${GetType(report)}`}
                                                </Typography>
                                            </Stack>
                                        </ListItemButton>
                                    </Paper>
                                    )
                                })
                                : 
                                <Box sx={{ flexGrow: 1, margin: 12, alignContent:'center' }}>
                                    <h4>
                                        No hay recetas creadas, puedes hacerlo desde el boton de abajo a la derecha!
                                    </h4>
                                </Box>
                            }
                            </List>
                        </Box>
                    </Paper>
                    <Divider orientation="vertical" flexItem />
                    <Paper elevation={3} sx={{ width:"60%", minHeight:"70%"}}>
                        {
                            (recipe != null) ?
                            <Stack spacing={3} sx={{padding:"1.5%", marginTop:"10px"}}>
                                <Stack spacing={1}>
                                    <Box pb={2} display="flex" justifyContent="center" alignItems="center">
                                        <Stack alignContent={"start"} justifyContent={"start"} spacing={2}>
                                            <Stack direction={"row"} spacing={5}>
                                                <Button onClick={(() => ignoreReport())} variant="outlined" color="primary">
                                                    Ignorar denuncia
                                                </Button>
                                                <Button onClick={(() => deleteRecipe(recipe))} variant="contained" color="error">
                                                    Elimnar receta
                                                </Button>
                                            </Stack>
                                        </Stack>
                                    </Box>     
                                    <Stack spacing={2}>
                                        <Typography variant="h6" component="h6">
                                            Comentario del denunciante:
                                        </Typography>
                                        <Typography variant="body1" component="body1">
                                            {actualReport.comment ? actualReport.comment : "No hay comentario sobre la denuncia."}
                                        </Typography>
                                    </Stack>                                                       
                                </Stack>
                                <Stack spacing={2}> 
                                    <Divider />                                   
                                    <Typography id="modal-modal-title" align="center" variant="h4" component="h2">
                                            {recipe.title}
                                    </Typography>
                                    <Typography id="modal-modal-description" align="center" sx={{ mt: 2, marginTop:"50px" }}>
                                        La receta te tomara aproximadamente {recipe.preparationTime} minutos.
                                    </Typography>   
                                    <Typography id="modal-modal-description" sx={{ mt: 2, marginTop:"50px" }}>
                                    {recipe.description}
                                    </Typography>
                                    <Typography sx={{marginTop: 2}} id="modal-modal-title" variant="h6" component="h2">
                                        Ingredientes:
                                    </Typography>                
                                    <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                                        {(recipe.ingredients != "") ? recipe.ingredients : "No posee ingredientes"}
                                    </Typography>
                                </Stack>
                                <Box sx={{width:"100%", paddingLeft:"120px", justifyContent:"center", alignItems:'center' }}>
                                    <SwipleableImages images={recipe.images}></SwipleableImages>                              
                                </Box>
                            </Stack>
                            : 
                            <Box sx={{ flexGrow: 1, margin: 12, alignContent:'center' }}>
                                <h4>
                                    Seleccionar una receta!
                                </h4>
                            </Box>
                        }

                    </Paper>
                </Stack>
            </Box> 
          </Stack>
        </Paper>        
    </Container>
  );
};
