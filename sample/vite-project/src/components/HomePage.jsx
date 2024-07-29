import React from 'react'
import '../assets/Pro.css';
import logo from '../assets/images/logo.png'
import { Link } from 'react-router-dom';
export const HomePage = () => {
  return (
    <div className='home-page'>
        <div className='home'>
        <header className="header">
        <img src={logo} alt="Logo" className="logo" />
        <nav className="home-nav">
           <Link to='' className="b">Feutures</Link>
            <Link to='' className="b">Pricing</Link>
            <Link to='' className="b">Help</Link>
            <Link to='/login' className="b">Login</Link>
            <div class="schedule">
            <Link to='/Dashboard'>Create Schedule</Link>
            </div>

        </nav>
      </header>
        <div className="text-center">
            <div className="main-title home-page-title">
             <div className='home-page-tile'>Employee scheduling software made simple.</div>
            </div>
        </div>
        <br></br>
        <div className='text-center'>
          <br></br>
          <br></br>
        <p className='home-para'>Create employee schedules, manage shift requests, </p>
        <br/>
        <p className='home-para'>track your labor costs and communicate with your employee.</p>
        </div>
        <div class="cta-buttons">
          <span class="button-container">
            <Link to="/login" class="fill-on-hover white">Get started</Link> 
            </span>           
            <br/>
            <br/>
            <p>or</p>
            <span class="button-container">
              <Link to="/Dashboard" class="invert-on-hover green">Try the demo</Link></span>
        </div>
        </div>
    </div>
  )
}
