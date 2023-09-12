import React, { useState } from 'react'
import './styles/App.css'
import { NavBar } from "./components/Shared/NavBar";
import Login from './pages/Authentication/Login'
import Home from './pages/Home'
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { useLocalStorage } from './helpers/useLocalStorage';
import {Register} from './pages/Authentication/Register';
import { Profile } from './pages/Profile/Profile';
import { MyRecipes } from './pages/Recipes/MyRecipes'
import { Following } from './pages/Profile/Following';

function App() {

  const [user, setUser] = useLocalStorage('user', '')
  
  return (
    <>    
      <BrowserRouter>
        <NavBar user={user} setUser={setUser} />
        <Routes>
          <Route index element={user ? <Home /> : <Login user={user} setUser={setUser}/>} />
          <Route path="/home" element={<Home />} />
          <Route path="/login" element={<Login user={user} setUser={setUser}/>} />
          <Route path="/register" element={<Register />} />
          <Route path="/profile" element={<Profile user={user} setUser={setUser}/>} />
          <Route path="/recipes" element={<MyRecipes user={user}/>} />        
          <Route path="/following" element={<Following user={user}/>} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
