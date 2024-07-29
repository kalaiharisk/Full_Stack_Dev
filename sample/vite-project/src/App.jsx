import { useState } from 'react'

import Register from './components/Register'
import { BrowserRouter, Route, RouterProvider, Routes } from 'react-router-dom'
import { LandingPage } from './components/Landingpage'
import { HomePage } from './components/HomePage'
import Login from './components/Login'
import { ForgotPasswordPage } from './components/ForgotPasswordPage'
import Dashboard from '../src/components/Dashboard'
import store from './redux/Store'
import {Provider} from 'react-redux'
import AdminDashboard from './components/AdminDashboard'


function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Provider store={store}>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<LandingPage />} />
            <Route path="/home" element={<HomePage />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/forg" element={<ForgotPasswordPage />} />
            <Route path="/Dashboard" element={<Dashboard />} />
            <Route path="/AdminDashboard" element={<AdminDashboard/>} />
          </Routes>
          <Footer />
        </BrowserRouter>
        </Provider> 


      </>
      )
}

      export default App

const Footer = () => {
  return (
      <p className="text-center" style={FooterStyle}> &copy; 2024 Find My App. All rights reserved.</p>
      )
}

      const FooterStyle = {
        background: "#222",
      fontSize: ".8rem",
      color: "#fff",
      position: "fixed",
      bottom: 0,
      padding: "1rem",
      margin: 0,
      width: "100%",
      opacity: ".5",
      zIndex: 1000, // Ensure it stays above other content
};

