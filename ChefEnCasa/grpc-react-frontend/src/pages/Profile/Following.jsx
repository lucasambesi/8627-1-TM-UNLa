import * as React from 'react';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemText from '@mui/material/ListItemText';
import { Container } from "@mui/material";
import Button from '@mui/material/Button';
import Paper from '@mui/material/Paper';
import { useLocalStorage } from '../../helpers/useLocalStorage';
import { userPresenter } from '../../presenter/UserPresenter'

export const Following =() => {
  const [user, setUser] = useLocalStorage('user')

  const { deleteFollowing } = userPresenter()

  const unfollow = (follow) => {

    deleteFollowing(user.idUser, follow.idUser)
    .then((res) => {
      if(res){
        let userTemp = user
        userTemp.following = userTemp.following.filter(item => item.idUser !== follow.idUser);
        setUser(userTemp)
        alert(`Eliminaste a ${follow.name} ${follow.lastName}`)    
      }
    })
    .catch((err) => console.log(err));
  }

  return (
    <Container sx={{ marginTop:"30px",  justifySelf:'center', alignSelf: 'center'}}>
      <Paper elevation={3}>
        <List dense sx={{ bgcolor: 'background.paper' }}>
          {user.following.map((follow, index) => {
            const labelId = `checkbox-list-secondary-label-${follow.name}`;
            return (
              <ListItem key={follow.name}>
                <ListItemText id={labelId} primary={` ${follow.name} ${follow.lastName}`} />
                <ListItemButton>
                  <Button
                    size='small'
                    fullWidth
                    onClick={(() => unfollow(follow))}>
                    Eliminar
                  </Button>
                </ListItemButton>
              </ListItem>
            );
          })}
        </List>
      </Paper>
    </Container>
  );
}