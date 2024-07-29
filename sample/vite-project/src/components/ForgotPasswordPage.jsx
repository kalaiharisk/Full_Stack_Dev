import React, { useState } from 'react'
import '../assets/Pro.css';
import { Link, useNavigate } from 'react-router-dom';
import logo from '../assets/images/logo.png'

export const ForgotPasswordPage = () => {
    const nav = useNavigate();
    const[email,setMail] = useState('');

    const handleMail = (e) => {
        e.preventDefault();

        if(email) 
        {
            if (! /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(email)) {
                alert('Enter a valid email')
            }
            else {
                console.log('Form submitted')
                console.log('email : ', email)
                alert('Password reset link sent to your email');
                nav('/login')
            }
        }
        else {
            alert('Fill the email correctly!')
        }
    }

  return (
    <>
     <header className="lo" style={{
                position: 'relative',
                width: '10%',
                height: '1px',  // Adjust height as needed
            }}>
                <div className="l" style={{
                    position: 'absolute',
                    left: '0',
                    bottom:'1',
                    padding: '10px'  // Adjust padding as needed
                }}>
                    <img src={logo} alt="l" className='l' />
                </div>
            </header>
    <div>
        <div className="text-center m-5-auto">
            <h2>Reset your password</h2>
            <h5>Enter your email address and we will send you a new password</h5>
            <form action="/login">
                <p>
                    <label id="reset_pass_lbl">Email address</label><br/>
                    <input type="email" name="email" 
                    value={email}
                    onChange={(e) => setMail(e.target.value)}
                    required />
                </p>
                <p>
                    <button id="sub_btn" type="submit" onClick={handleMail}>Send password reset email</button>
                </p>
            </form>
            <footer>
                <p>First time? <Link to="/register">Create an account</Link>.</p>
                <p><Link to="/home">Back to Homepage</Link></p>
            </footer>
        </div>
    </div>
    </>
  )
}
