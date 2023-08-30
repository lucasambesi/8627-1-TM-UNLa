import React, { Component, useState, useEffect } from 'react';
import unlalogo from '../../assets/unla_logo.png'; 
import { userPresenter } from '../../presenter/UserPresenter'

const Login = () => {
    
    const {getById} = userPresenter()
    const [user, setUser] = useState({})

    useEffect (()=>{
        getById(1)
            .then(res => setUser(res.user))
            .catch(e=>console.log(e))
        }, [])

    return (
      <>
        <div>
            <a href="http://www.unla.edu.ar/" target="_blank">
                <img src={unlalogo} className="logo unla" alt="Unla logo" />
            </a>
        </div>
        <div>
            <h1>{JSON.stringify(user)}</h1>
        </div>
      </>
    );
  }

export default Login;