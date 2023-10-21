import React, { useState } from 'react'
import './styles/App.css'
import { NavBar } from "./components/Shared/NavBar";
import Login from './pages/Authentication/Login'
import Home from './pages/Home/Home'
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { useLocalStorage } from './helpers/useLocalStorage';
import {Register} from './pages/Authentication/Register';
import { Profile } from './pages/Profile/Profile';
import { Following } from './pages/Profile/Following';
import { RecipeTabs } from './pages/Recipes/TabsRecipes';
import { SearchRecipe } from './pages/Recipes/SearchRecipe';
import { Recipe } from './pages/Recipes/Recipe';
import { CsvUploader } from './components/CsvUploader';
import RoleType from './helpers/RoleType';
import { Reports } from './pages/Reports/Reports';
import { Messages } from './pages/Messages/Messages';
import { CreateMenssage } from './pages/Messages/CreateMessage';

function App() {

  const [user, setUser] = useLocalStorage('user', '')
  const [role, setRole] = useLocalStorage('role', '')
  
  return (
    <>    
      <BrowserRouter>
        <NavBar user={user} setUser={setUser} />
        <Routes>
          <Route index element={user ? <Home user={user}/> : <Login user={user} setUser={setUser}/>} />
          <Route path="/home" element={<Home user={user}/>} />
          <Route path="/search" element={<SearchRecipe user={user}/>} />
          <Route path="/recipe/:recipeId" element={<Recipe />} />
          <Route path="/login" element={<Login user={user} setUser={setUser}/>} />
          <Route path="/register" element={<Register />} />
          <Route path="/profile" element={<Profile user={user} setUser={setUser}/>} />
          <Route path="/recipes" element={<RecipeTabs user={user}/>} />        
          <Route path="/following" element={<Following user={user}/>} />
          <Route path="/drafts/uploader" element={<CsvUploader user={user}/>} />
          <Route path="/reports" element={<Reports user={user} />} />
          <Route path="/messages" element={<Messages user={user} />} />
          <Route path="/send-message" element={<CreateMenssage user={user} />} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
