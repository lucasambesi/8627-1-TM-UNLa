import React, { useState } from 'react'
import './styles/App.css'
import { MyAppBar } from "./components/Shared/AppBar";
import { ProtectedRoute } from "./components/ProtectedRoute";
import Login from './pages/Authentication/Login'
import Home from './pages/Home'
import { BrowserRouter, Route, Routes, Link } from "react-router-dom";
import { useLocalStorage } from './helpers/useLocalStorage';
import {Register} from './pages/Authentication/Register';

function App() {

  const [user, setUser] = useLocalStorage('user', '')
  
  return (
    <>
    <BrowserRouter>
      <MyAppBar user={user} setUser={setUser} />

      <Routes>
        <Route index element={<Login user={user} setUser={setUser}/>} />
        <Route path="/login" element={<Login user={user} setUser={setUser}/>} />
        <Route path="/register" element={<Register />} />
        <Route path="/home" element={
          <ProtectedRoute user={user}>
            <Home user={user}/>
          </ProtectedRoute>
        } />
      </Routes>
    </BrowserRouter>
    </>
  )
}

export default App
