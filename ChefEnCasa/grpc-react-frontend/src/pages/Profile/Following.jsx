import React, { useEffect, useState } from "react";
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';

export const Following = (props) => {
    const { user } = props;
 
     return (
       <Box sx={{ flexGrow: 1, margin: 5, alignContent:'center' }}>
          <List sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper' }}>
           {
               user.following ? user.following.map((follow) =>{
               return (
                <>  
                <ListItemText>
                    {follow.name} {follow.lastName}
                </ListItemText>                          
                </>
                 )
               })
               : null
           }
         </List>
       </Box>
     );
   }