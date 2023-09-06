import 'mdb-react-ui-kit/dist/css/mdb.min.css';
import "@fortawesome/fontawesome-free/css/all.min.css";
import { recipePresenter } from '../../presenter/RecipePresenter'
import React, {useEffect, useState} from 'react';
import { MDBCol, MDBContainer, MDBRow, MDBCard, MDBCardText, MDBCardBody, MDBCardImage, MDBBtn, MDBTypography } from 'mdb-react-ui-kit';
import '../../styles/profile.css'
export const Profile = (props) => {
    const { user, setUser } = props;
    const [recipes, setRecipes] = useState([]);

    const {getRecipesByUserId} = recipePresenter()

    useEffect(() => {
      getRecipesByUserId(user.idUser)
        .then((res) => {
          setRecipes(res)
        })
        .catch((err) => console.log(err));
    }, []);


    return (
      <div >
        <MDBContainer className="py-5 h-100">
          <MDBRow className="justify-content-center align-items-center h-100">
            <MDBCol lg="9" xl="7">
              <MDBCard>
              <div className="rounded-top text-white d-flex flex-row" style={{ backgroundImage: 'url("https://malevamag.com/wp-content/uploads/2015/02/10731090_732574466835103_7682023087681209921_n.jpg%22)', backgroundPosition: "center", height: '200px' }}>
                  <div className="ms-4 mt-5 d-flex flex-column" style={{ width: '150px' }}>
                    <MDBCardImage src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-profiles/avatar-1.webp"
                      alt="Generic placeholder image" className="mt-4 mb-2 img-thumbnail" fluid style={{ width: '150px', zIndex: '1' }} />
                  </div>
                  <div className="ms-3" style={{ marginTop: '130px' }}>
                    <MDBTypography tag="h5">{user.name}</MDBTypography>
                    <MDBCardText>{user.dni}</MDBCardText>
                  </div>
                </div>
                <div className="p-4 text-black" style={{ backgroundColor: '#f8f9fa' }}>
                  <div className="d-flex justify-content-end text-center py-1">
                    <div>
                      {/* ENLACE HACIA LOS SEGUIDORES */}
                      <MDBCardText className="mb-1 h5">478</MDBCardText>
                      <MDBCardText className="small text-muted mb-0">Following</MDBCardText>
                    </div>
                  </div>
                </div>
                <MDBCardBody className="text-black p-4">
                  <div className="d-flex justify-content-between align-items-center mb-4">
                    <MDBCardText className="lead fw-normal mb-0">Recetas de {user.name}</MDBCardText>
                  </div>
                  <MDBRow>
                    {
                        recipes ? recipes.map((recipe) =>{
                        return (
                          <MDBCol className="mb-2" key={recipe.idRecipe} style={{ minWidth: '80%' }}>
                          <MDBCard>
                            <MDBCardImage src='https://mdbootstrap.com/img/new/standard/nature/182.webp' alt='...' position='top' style={{ maxHeight:'200px' }} />
                              <MDBCardBody>
                                <MDBRow>
                                  <MDBCardText>
                                    {recipe.title}
                                  </MDBCardText>
                                  <MDBCardText>
                                    {recipe.description}
                                  </MDBCardText>
                                </MDBRow>
                            </MDBCardBody>
                          </MDBCard>
                        </MDBCol>
                          )
                        })
                        : "No posee recetas creadas"
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