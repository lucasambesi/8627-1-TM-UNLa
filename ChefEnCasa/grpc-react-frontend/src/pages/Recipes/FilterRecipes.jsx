import React, { useEffect, useState } from 'react'
import Grid from '@mui/material/Grid';
import { TextField } from '@mui/material';
import Box from '@mui/material/Box';
import IconButton from '@mui/material/IconButton'
import { blue } from '@mui/material/colors'
import SearchIcon from '@mui/icons-material/Search';
import Paper from '@mui/material/Paper';
import {recipePresenter} from '../../presenter/RecipePresenter'
import { categoryPresenter } from '../../presenter/CategoryPresenter'
import Select from '@mui/material/Select';
import MenuItem from '@mui/material/MenuItem';

export const FilterRecipes = (props) => {
    const { 
        setRecipes,
        filter,
        setFilter
    } = props;

    const {getByFilter} = recipePresenter()
    const { getCategories } = categoryPresenter()
    const [categories, setCategories] = useState(null);


    useEffect(() => {
        getCategories()
          .then((res) => {
            setCategories(res)
          })
          .catch((err) => console.log(err));
      }, [])

    const handleChange = (e) => {
        let value = e.target.value
        if(e.target.type === "number"){
            value = Number(value)
        }

        let tempFilter = { ...filter }
        tempFilter[e.target.name] = value
        
        setFilter(tempFilter)
    }

    const HandleChangeCategory = (e) => {
        let value = e.target.value

        let tempFilter = { ...filter }
        tempFilter["category"] = value
        
        setFilter(tempFilter)
    }
    
    const find = () => {
        getByFilter(filter)
        .then((res) => {
          console.log(res)
          setRecipes(res)
        })
        .catch((err) => console.log(err));
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
                                value={filter.title}
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
                                value={filter.ingredients}
                                size="small"
                                onChange={handleChange}
                            />
                        </Grid>
                        <Grid item xs={2}>
                            <TextField
                                type="number"
                                label="Tiempo desde"
                                variant="outlined"
                                name="timeSince"
                                onChange={handleChange}
                                value={filter.timeSince}
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
                                value={filter.timeUntil}
                                size="small"
                            />
                        </Grid>
                        <Grid item xs={2}>
                            <Select
                                item
                                labelId="demo-simple-select-label"
                                id="demo-simple-select"
                                value={filter.category}
                                label="Categoria"
                                size="small"
                                fullWidth
                                onChange={HandleChangeCategory}
                                >                                    
                                {
                                    categories ? categories.map((category , index) =>{
                                        return (
                                            <MenuItem id={category.id} key={index} value={category}>
                                                {category.name}
                                            </MenuItem>
                                            )
                                        })
                                        : null
                                }                            
                            </Select>
                        </Grid>
                    </Grid>
                    <Grid item xs={1}>
                        <IconButton onClick={find}>
                            <SearchIcon style={{ color: blue[700], fontSize: "24px" }} />
                        </IconButton>
                    </Grid>
                </Grid>
            </Box>
        </Paper>
    )
}
