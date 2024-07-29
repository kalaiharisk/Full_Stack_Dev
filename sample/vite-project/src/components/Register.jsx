import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import '../assets/Pro.css'
import logo from '../assets/images/logo.png'
import { useDispatch } from 'react-redux'
import { setName } from '../redux/NameSlice'

export default function Register() {
    const dispatch = useDispatch();
    const nav = useNavigate();
    const [name, setNameInput] = useState('');
    const [password, setPassword] = useState('');
    const [email, setEmail] = useState('');
    
    const handleRegister = (e) => {
        e.preventDefault();

        if (name && password ) {
            if (! /^(?=.*\d)[a-zA-Z\d]{1,}$/.test(name) || password.length < 8 || /^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(name)) {
                alert('Enter a valid username or password or email')
            }
            else {
                dispatch(setName(name))
                console.log('Form submitted')
                console.log('Username : ', name)
                console.log('Password : ', password)
                console.log('Email : ', email)
                nav('/login')
            }
        }
        else if (!name) {
            alert('Fill the username')
        }
        else if (!password) {
            alert('Fill the password')
        }
        else if (!email) {
            alert('Fill the email')
        }
        else {
            alert('Fill the username and password')
        }
    }


    return (
        <>
        <div className='reggg'>
        <header className="lo" style={{
                position: 'relative',
                width: '10%',
                height: '1px',
                border:'10px'  // Adjust height as needed
            }}>
                <div className="l" style={{
                    position: 'absolute',
                    left: '0',
                    bottom:'1',
                    padding: '10px' ,
                    marginTop:'10px',
                    border:'10px' // Adjust padding as needed
                }}>
                    <img src={logo} alt="l" className='l' />
                </div>
            </header>
        <div className="text-center m-5-auto">
            <h2>Join us</h2>
            <h5>Create your personal account</h5>
            <form action="/home">
                <p>
                    <label>Username</label><br/>
                    <input type="text" name="first_name" value={name}
                            onChange={(e) => setNameInput(e.target.value)} required />
                </p>
                <p>
                    <label>Email address</label><br/>
                    <input type="email" name="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)} required />
                </p>
                <p>
                    <label>Password</label><br/>
                    <input type="password" name="password" minLength={8}
                            id='pass'
                            value={password}
                            onChange={(e) => setPassword(e.target.value)} requiredc />
                </p>
                <p>
                    <input type="checkbox" name="checkbox" id="checkbox" required /> <span>I agree all statements in <a href="https://google.com" target="_blank" rel="noopener noreferrer">terms of service</a></span>.
                </p>
                <p>
                    <button id="sub_btn" type="submit"  onClick={handleRegister}>Register</button>
                </p>
            </form>
            <footer>
                <p><Link to="/home">Back to Homepage</Link>.</p>
            </footer>
        </div>
        </div>
        </>
    )

}
