import * as React from 'react';
import Button from '@mui/material/Button';
import Menu from '@mui/material/Menu';
import MenuItem from '@mui/material/MenuItem';
import { Avatar, Stack } from '@mui/material';
import { useNavigate } from 'react-router'

export default function BasicMenu() {
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);

  const navigate = useNavigate();

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  const toProfile = () => { 
    navigate("/profile")
    handleClose()
 }
  const toRecipes = () => { 
    navigate("/recipes")
    handleClose()
 }

 const toMessages = () => { 
    navigate("/messages")
    handleClose()
 }

  const logout = () => {
    localStorage.removeItem("user")
    localStorage.removeItem("role")
    navigate("/login")
  }

  return (
    <Stack direction={"row"}>
        
      <Button
        id="basic-button"
        aria-controls={open ? 'basic-menu' : undefined}
        aria-haspopup="true"
        aria-expanded={open ? 'true' : undefined}
        onClick={handleClick}
      >
        <Avatar src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png" />
      </Button>
      <Menu
        id="basic-menu"
        anchorEl={anchorEl}
        open={open}
        onClose={handleClose}
        MenuListProps={{
          'aria-labelledby': 'basic-button',
        }}
      >
        <MenuItem onClick={toProfile}>Mi Perfil</MenuItem>
        <MenuItem onClick={toRecipes}>Mis recetas</MenuItem>
        <MenuItem onClick={toMessages}>Mis mensajes</MenuItem>
        <MenuItem onClick={logout}>Cerrar sesión</MenuItem>
      </Menu>
    </Stack>
  );
}