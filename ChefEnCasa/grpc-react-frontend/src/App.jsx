import { useState } from 'react'
import './styles/App.css'
import Login from './pages/Authentication/Login'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
        <Login />
    </>
  )
}

export default App
