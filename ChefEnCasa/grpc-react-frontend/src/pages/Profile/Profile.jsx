import 'mdb-react-ui-kit/dist/css/mdb.min.css';
import "@fortawesome/fontawesome-free/css/all.min.css";
import { recipePresenter } from '../../presenter/RecipePresenter'
import React, {useEffect, useState} from 'react';
import { MDBCol, MDBContainer, MDBRow, MDBCard, MDBCardText, MDBCardBody, MDBCardImage, MDBBtn, MDBTypography, MDBCardLink } from 'mdb-react-ui-kit';
import '../../styles/profile.css'
import { Button } from '@mui/material';
import uno from '../../assets/recetas/uno.jpg'; 
import dos from '../../assets/recetas/dos.jpg'; 
import tres from '../../assets/recetas/tres.jpg'; 
import cuatro from '../../assets/recetas/cuatro.jpg'; 
import cinco from '../../assets/recetas/cinco.jpg'; 
import { RecipeCard } from '../Recipes/RecipeCard';
import { useLocalStorage } from '../../helpers/useLocalStorage';

import { useNavigate } from 'react-router'

export const Profile = () => {
    const [user, setUser] = useLocalStorage('user')
    const [recipes, setRecipes] = useState([]);
    const images = [uno, dos, tres, cuatro, cinco]
    const navigate = useNavigate();
    const {getRecipesByUserId} = recipePresenter()    

    useEffect(() => {
      getRecipesByUserId(user.idUser)
        .then((res) => {
          setRecipes(res)
        })
        .catch((err) => console.log(err));
    }, []);

    const toRecipes = () => { navigate("/recipes") }

    return (
      <div >
        <MDBContainer className="py-5 h-100">
          <MDBRow className="justify-content-center align-items-center h-100">
            <MDBCol lg="9" xl="7">
              <MDBCard>
              <div className="rounded-top text-white d-flex flex-row" style={{ backgroundImage: 'url("https://malevamag.com/wp-content/uploads/2015/02/10731090_732574466835103_7682023087681209921_n.jpg%22)', backgroundPosition: "center", height: '200px' }}>
                  <div className="ms-4 mt-5 d-flex flex-column" style={{ width: '150px' }}>
                    <MDBCardImage src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"
                      alt="Generic placeholder image" className="mt-4 mb-2 img-thumbnail" fluid style={{ width: '150px', zIndex: '1' }} />
                  </div>
                  <div className="ms-3" style={{ marginTop: '130px' }}>
                    <MDBTypography tag="h5">{user.name} {user.lastName}</MDBTypography>
                    <MDBCardText>{`@${user.username}`}</MDBCardText>
                  </div>
                </div>
                <div className="p-4 text-black" style={{ backgroundColor: '#f8f9fa' }}>
                  <div className="d-flex justify-content-end text-center py-1">
                    <div>
                      <MDBCardText className="mb-1 h5">{user.following.length}</MDBCardText>
                      <MDBCardLink href='/following' className="small text-muted mb-0">Seguidos</MDBCardLink>
                    </div>
                  </div>
                </div>
                <MDBCardBody className="text-black">
                  <div className="d-flex justify-content-between align-items-center">
                    <MDBCardText className="lead fw-normal mb-0">Recetas de {user.name}</MDBCardText>
                  </div>
                  <MDBRow>
                    {
                        recipes 
                        ? 
                        recipes.slice(0, 2).map((recipe) =>{
                        return (
                          <MDBCol className="mb-2" key={recipe.idRecipe} style={{ minWidth: '40%', minHeight: '40%' }}>
                            <RecipeCard recipe={recipe} favoriteMode={true} key={recipe.idRecipe}/>
                          </MDBCol>
                          
                          )
                        })
                        : 
                        "No posee recetas creadas"
                    }
                  </MDBRow>
                  <MDBRow style={{ marginTop: '30px', paddingLeft:'12px', paddingRight:'50px' }}>
                    {
                      recipes 
                        ? 
                          <Button
                              size="small"
                              variant="outlined"
                              color='primary'
                              onClick={toRecipes}
                          >
                              Ver todas
                          </Button>
                        : null
                    }
                  </MDBRow>
                </MDBCardBody>
              </MDBCard>
            </MDBCol>
          </MDBRow>
        </MDBContainer>
      </div>
    );
  }