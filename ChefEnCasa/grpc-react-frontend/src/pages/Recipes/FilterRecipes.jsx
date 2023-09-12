import React, { useEffect, useState } from 'react'
import Grid from '@mui/material/Grid';
import { TextField } from '@mui/material';
import Box from '@mui/material/Box';
import IconButton from '@mui/material/IconButton'
import { blue } from '@mui/material/colors'
import SearchIcon from '@mui/icons-material/Search';
import Paper from '@mui/material/Paper';

export const FilterRecipes = (props) => {
    const { 
        setProductos
    } = props;

    const [categoria, setCategoria] = useState({});
    const [filtros, setFiltros] = useState({
        categoria: 0,
        title: "",
        ingredients: "",
        TimeSince: 0,
        timeUntil: 1000
    })

    useEffect(() => {
        let tempFiltros = { ...filtros }
        tempFiltros.categoria = categoria.idCategoria
        setFiltros(tempFiltros)
    }, [categoria])

    const handleChange = (e) => {
        let value = e.target.value
        if(e.target.type === "number"){
            value = Number(value)
        }
        let tempFiltros = { ...filtros }
        tempFiltros[e.target.name] = value
        setFiltros(tempFiltros)
    }
    
    const buscarProductos = () => {
    }

    return (
        <Paper elevation={3}>
            <Box p={2}>
                <Grid container spacing={2}>
                    <Grid item container xs={11} spacing={1}>
                        <Grid item xs={3}>
                            <TextField
                                name="title"
                                label="Titulo"
                                id="title"
                                variant="outlined"
                                value={filtros.title}
                                size="small"
                                onChange={handleChange}
                            />
                        </Grid>
                        <Grid item xs={3}>
                            <TextField
                                name="ingredients"
                                label="Ingredientes"
                                id="ingredients"
                                variant="outlined"
                                value={filtros.ingredients}
                                size="small"
                                onChange={handleChange}
                            />
                        </Grid>
                        <Grid item xs={2}>
                            <TextField
                                type="number"
                                label="Tiempo desde"
                                variant="outlined"
                                name="TimeSince"
                                onChange={handleChange}
                                value={filtros.TimeSince}
                                size="small"
                            />
                        </Grid>
                        <Grid item xs={2}>
                            <TextField
                                type="number"
                                label="Tiempo Hasta"
                                variant="outlined"
                                name="timeUntil"
                                onChange={handleChange}
                                value={filtros.timeUntil}
                                size="small"
                            />
                        </Grid>
                    </Grid>
                    <Grid item xs={1}>
                        <IconButton onClick={buscarProductos}>
                            <SearchIcon style={{ color: blue[700], fontSize: "24px" }} />
                        </IconButton>
                    </Grid>
                </Grid>
            </Box>
        </Paper>
    )
}
