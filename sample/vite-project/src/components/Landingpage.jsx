import React from 'react';
import '../assets/Pro.css';

import background from '../assets/images/bg.png';
import { Link } from 'react-router-dom';

export const LandingPage = () => {
  return (
    <div>
        {/* <img src={logo} alt="Logo" className="logo" /> */}
        <header style={ HeaderStyle }>
            <h1 className="main-title text-center">Welcome to FindMyShift</h1>
            <div className="buttons text-center">
                <Link to="/home">
                    <button className="primary-button">Explore Now</button>
                </Link>
            </div>
        </header>
    </div>
  )
}
const HeaderStyle = {
    width: "100%",
    height: "100vh",
    background:`url(${background})`,
    backgroundPosition: "center",
    backgroundRepeat: "no-repeat",
    backgroundSize: "cover"
}
