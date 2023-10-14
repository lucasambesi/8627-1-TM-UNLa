import React, { useState } from 'react'
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Button from '@mui/material/Button';
import { useNavigate } from 'react-router'
import Card from '@mui/material/Card';
import CardMedia from '@mui/material/CardMedia';
import unlalogo from '../../assets/unla_logo.png';
import { useLocalStorage } from '../../helpers/useLocalStorage';
import RoleType from '../../helpers/RoleType';
import BasicMenu from './Menu';

export const NavBar = (props) => {

  const { user, setUser } = props;
  const [role, setRole] = useState(window.localStorage.getItem('role'))

  const navigate = useNavigate();

  const toSearch = () => { navigate("/search") }
  const toReports = () => { navigate("/reports") }

  return (
    <AppBar position="static">
      <Container maxWidth="xl">
        <Toolbar disableGutters>
          <Box sx={{ flexGrow: 5, display: { xs: 'flex' } }}>  
            <Card>
                <CardMedia
                    component="img"
                    alt="Logo Unla"
                    height="50"
                    image={unlalogo}
                    title="UNLa"
                />
            </Card>
            <Box sx={{ marginLeft: 2 }}></Box>
            <Typography
                variant="h6"
                noWrap
                component="a"
                href="/"
                sx={{
                mr: 2,
                display: { xs: 'none', md: 'flex' },
                alignItems: 'center',
                justifyContent: 'center',
                fontFamily: 'monospace',
                fontWeight: 700,
                letterSpacing: '.3rem',
                color: 'inherit',
                textDecoration: 'none',
                }}
            >
                CHEF EN CASA
            </Typography>
          </Box>
          <Box sx={{ flexGrow: 1, display: { xs: 'none', md: 'flex' } }}>
            { user ? (
                <>                     
                    {
                      (role == RoleType.moderator)
                      ?
                      <Button onClick={toReports} sx={{ my: 2, color: 'white', display: 'block' }}>Denuncias</Button>
                      :
                      null
                    }
                    <Button onClick={toSearch} sx={{ my: 2, color: 'white', display: 'block' }}>Explorar</Button>
                    <BasicMenu />
                </>
            ) : (
                <></>      
            )}

          </Box>

        </Toolbar>
      </Container>
    </AppBar>
  );
};
