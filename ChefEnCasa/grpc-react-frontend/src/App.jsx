import React, { useState } from 'react'
import './styles/App.css'
import { NavBar } from "./components/Shared/NavBar";
import Login from './pages/Authentication/Login'
import Home from './pages/Home'
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { useLocalStorage } from './helpers/useLocalStorage';
import {Register} from './pages/Authentication/Register';
import { Profile } from './pages/Profile/Profile';
import { Recipes } from './pages/Recipes/Recipes';

function App() {

  const [user, setUser] = useLocalStorage('user', '')
  
  return (
    <>
    <BrowserRouter>
      <NavBar user={user} setUser={setUser} />
      <Routes>
        <Route index element={user ? <Home /> : <Login user={user} setUser={setUser}/>} />
        <Route path="/login" element={<Login user={user} setUser={setUser}/>} />
        <Route path="/register" element={<Register />} />
        <Route path="/home" element={<Home />} />
        <Route path="/profile" element={<Profile />} />
        <Route path="/recipes" element={<Recipes />} />        
      </Routes>
    </BrowserRouter>
    </>
  )
}

export default App
