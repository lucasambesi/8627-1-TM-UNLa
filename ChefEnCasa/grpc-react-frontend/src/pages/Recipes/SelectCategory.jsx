import { Box } from '@mui/material';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';

export const SelectCategory = (props) => {
    const {
        setCategory,
        category,
        categories
    } = props   

    const handleChange = (event) => {
        setCategory(event.target.value);
    };

    return (
        <Box sx={{ minWidth: 120,width:'100%', marginTop:2 }}>
            <FormControl fullWidth>
                <InputLabel id="demo-simple-select-label">Categoria</InputLabel>
                <Select
                labelId="demo-simple-select-label"
                id="demo-simple-select"
                value={category}
                label="Categoria"
                onChange={handleChange}
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
            </FormControl>
        </Box>
    )
}