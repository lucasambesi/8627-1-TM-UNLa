import React, { useEffect, useState } from "react";
import { userPresenter } from '../../../presenter/UserPresenter'
import { Box, List, ListItem, ListItemText, Paper, Stack, Typography } from "@mui/material";

export const TopUsers = (props) => {

    const [users, setUsers] = useState(null);
    
    const {getUsersByPopularity} = userPresenter()

    useEffect(() => {
        getUsersByPopularity(3,1)
          .then((res) => {
            console.log("🚀 ~ file: TopUsers.jsx:17 ~ .then ~ res:", res)
            setUsers(res)
          })
          .catch((err) => console.log(err));
      }, [])

    return (
        <Box width={"100%"}>
            <List>
                {
                    users ? users.map((user, index) =>{
                    return (
                        <ListItem alignItems="flex-start">
                            <Paper elevation={3} sx={{width:"100%", padding:"2%"}}>
                                <Stack direction={"row"} justifyContent={"space-between"}>
                                    <ListItemText
                                    primary={user.name + " " + user.lastName}
                                    secondary={
                                        <React.Fragment>
                                        <Typography
                                            sx={{ display: 'inline', marginTop:"10px" }}
                                            component="span"
                                            variant="body2"
                                            color="text.primary"
                                        >
                                            {"@" + user.username + " - "}
                                        </Typography>
                                        {"Acumula una popularidad de " + user.popularity + " puntos."}
                                        </React.Fragment>
                                    }
                                    />
                                    <Typography variant="h6" alignSelf={"center"} >
                                        {`Puesto #${index + 1}`}
                                    </Typography>
                                </Stack>
                            </Paper>
                        </ListItem>
                    )
                    })                        
                    : 
                    <ListItem alignItems="flex-start">
                        <Paper elevation={3} sx={{width:"100%", padding:"2%"}}>
                            <h4>
                            No hay usuarios para ver!
                            </h4>
                        </Paper>
                    </ListItem>
                }
            </List>
        </Box>        
    );
  }