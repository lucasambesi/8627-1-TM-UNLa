import { Box } from '@mui/material';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';

export const SelectUsers = (props) => {
    const {
        setReceiver,
        receiver,
        users
    } = props

    const handleChange = (event) => {
        setReceiver(event.target.value);
    };

    return (
        <Box sx={{ minWidth: 120,width:'100%', marginTop:2 }}>
            <FormControl fullWidth>
                <InputLabel id="demo-simple-select-label">Elegir usuario</InputLabel>
                <Select
                labelId="demo-simple-select-label"
                id="demo-simple-select"
                value={receiver}
                label="Destinatario"
                onChange={handleChange}
                >
                {
                    users ? users.map((user , index) =>{
                        return (
                            <MenuItem id={user.id} key={index} value={user}>
                                {`${user.Username}: ${user.Email}`}
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