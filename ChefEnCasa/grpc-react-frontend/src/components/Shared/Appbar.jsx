import * as React from 'react';

import { userPresenter } from '../../presenter/UserPresenter'

import { Link, Navigate } from "react-router-dom";
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Button from '@mui/material/Button';
import AdbIcon from '@mui/icons-material/Adb';
import { Typography } from '@mui/material';
import { useLocalStorage } from '../../helpers/useLocalStorage';

export const MyAppBar = (props) => {
    const { user, setUser } = props;
    const {getById} = userPresenter()

    const login = () => {
        getById(1)
          .then(res => {
            setUser(res.user)
            // window.localStorage.setItem('user', res.user)
            
            console.log(user)
            return <Navigate to="/home" />
          })
          .catch(e=>console.log(e))
      }
    
    const logout = () => setUser(null);    

  return (
    <Box sx={{ flexGrow: 1 }}>
    <AppBar position="static">
      <Toolbar>
      <AdbIcon sx={{ display: { xs: 'none', md: 'flex' }, mr: 1 }} />
            <Button
                variant="h6"
                noWrap
                component="a"
                disabled='true'
                sx={{
                    mr: 2,
                    display: { xs: 'none', md: 'flex' },
                    fontFamily: 'monospace',
                    fontWeight: 700,
                    letterSpacing: '.3rem',
                    color: 'inherit',
                    textDecoration: 'none',
                }}
            >
                CHEF EN CASA
            </Button>
            {user ? (
                <>   
                    <Typography textAlign='center' color='white'>
                        <Link to={'/home'} color='white'>
                            Home
                        </Link>
                    </Typography>
                    <Button color="inherit" onClick={logout}>
                        Logout
                    </Button>                  
                </>
            ) : (
                <></>      
            )}
      </Toolbar>
    </AppBar>
  </Box>
  );
}