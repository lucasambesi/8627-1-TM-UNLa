import { Avatar, Box, Container, Divider, Grid, Paper, Stack, Typography } from "@mui/material";
import { deepOrange } from '@mui/material/colors';
import { Link } from "react-router-dom";
export const Profile = (props) => {
  
    return (
        <Container maxWidth="sm" >
            <Box display="flex" justifyContent="center" m={8} >
                <Paper elevation={0} sx={{minWidth:550, height:750, justifyContent: 'center', alignContent:'center'}}>
                    <Grid container spacing={2}>
                        <Grid container item justifyContent="center" >
                            <Box>
                                <Avatar sx={{ bgcolor: deepOrange[500], width:100, height: 100 }}>L</Avatar>
                            </Box>    
                        </Grid>
                        <Grid container item justifyContent="center" >
                            <Box>
                                <Typography variant="h5" color="initial">Lucas Ambesi</Typography>
                            </Box>    
                        </Grid>
                        <Grid container item justifyContent="center" >
                            <Box>
                                <Link>
                                    {'Sigues a 10 personas'}
                                </Link> 
                            </Box>   
                        </Grid>         

                    </Grid>
                    <Box m={2}></Box>
                    <Divider></Divider>

                    {}
                </Paper>            
            </Box>
        </Container>
    );
  }