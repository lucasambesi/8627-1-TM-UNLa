import React, { useState } from 'react'
import './styles/App.css'
import { NavBar } from "./components/Shared/NavBar";
import Login from './pages/Authentication/Login'
import Home from './pages/Home'
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { useLocalStorage } from './helpers/useLocalStorage';
import {Register} from './pages/Authentication/Register';
import { Profile } from './pages/Profile/Profile';
import { Following } from './pages/Profile/Following';
import { RecipeTabs } from './pages/Recipes/TabsRecipes';
import { SearchRecipe } from './pages/Recipes/SearchRecipe';

function App() {

  const [user, setUser] = useLocalStorage('user', '')
  
  return (
    <>    
      <BrowserRouter>
        <NavBar user={user} setUser={setUser} />
        <Routes>
          <Route index element={user ? <Home user={user}/> : <Login user={user} setUser={setUser}/>} />
          <Route path="/home" element={<Home user={user}/>} />
          <Route path="/search" element={<SearchRecipe user={user}/>} />
          <Route path="/login" element={<Login user={user} setUser={setUser}/>} />
          <Route path="/register" element={<Register />} />
          <Route path="/profile" element={<Profile user={user} setUser={setUser}/>} />
          <Route path="/recipes" element={<RecipeTabs user={user}/>} />        
          <Route path="/following" element={<Following user={user}/>} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
