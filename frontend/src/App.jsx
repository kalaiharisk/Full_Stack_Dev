import { useState } from 'react'

import { Provider } from 'react-redux'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Dashboard from '../src/components/Dashboard'
import AdminDashboard from './components/AdminDashboard'
import Footer from './components/Footer'
import { ForgotPasswordPage } from './components/ForgotPasswordPage'
import { HomePage } from './components/HomePage'
import { LandingPage } from './components/Landingpage'
import Login from './components/Login'
import MessageDialog from './components/MessageDialog'
import Payment from './components/Payment'
import Pricing from './components/Pricing'
import Register from './components/Register'
import store from './redux/Store'
import AdminMessages from './components/AdminMessage'


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
            <Route path="/AdminDashboard" element={<AdminDashboard />} />
            <Route path="/payment" element={<Payment/>} />
            <Route path="/message" element={<MessageDialog/>} />
            <Route path="/adminmessage" element={<AdminMessages/>} />
            
            <Route path="/pricing" element={<Pricing/>} />
          </Routes>
        </BrowserRouter>
        <Footer/>
        </Provider> 


      </>
      )
}
const AppStyle = {
  display: 'flex',
  flexDirection: 'column',
  minHeight: '100vh'
};

const ContentStyle = {
  flex: '1'
};

      export default App




