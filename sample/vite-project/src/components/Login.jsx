import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import '../assets/Pro.css'
import logo from '../assets/images/logo.png'
import { useDispatch } from 'react-redux'
import { setName } from '../redux/NameSlice'

export default function Login() {
    // //Login
    const dispatch = useDispatch();
    //  //inside condition
    //  dispatch(setName(name));
    const nav = useNavigate();
    const [name, setNameInput] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = (e) => {
        e.preventDefault();

        if (name && password) {
            if (! /^(?=.*\d)[a-zA-Z\d]{1,}$/.test(name) || password.length < 8) {
                alert('Enter a valid username or password')
            }
            else {
                if(name==="admin2004" && password==="admin2004")
                {
                    dispatch(setName(name))
                    nav('/AdminDashboard')
                }
                else
                {
                dispatch(setName(name))
                console.log('Form submitted')
                console.log('Username : ', name)
                console.log('Password : ', password)
                nav('/Dashboard')
                }
            }
        }
        else if (!name) {
            alert('Fill the username')
        }
        else if (!password) {
            alert('Fill the password')
        }
        else {
            alert('Fill the username and password')
        }
    }


    return (
        <>
        <div className='neee-lo'>
            <header className="lo" style={{
                position: 'relative',
                width: '10%',
                height: '1px',  // Adjust height as needed
            }}>
                <div className="l" style={{
                    position: 'absolute',
                    left: '0',
                    bottom: '1',
                    padding: '10px',
                    marginTop:'10px',
                    border:'10px' // Adjust padding as needed
                }}>
                    <img src={logo} alt="l" className='l' />
                </div>
            </header>

            <div className="text-center m-5-auto">
                <h2>Sign in to us</h2>
                <form action="/home">
                    <p>
                        <label>Username or email address</label><br />
                        <input type="text" name="first_name" value={name}
                            onChange={(e) => setNameInput(e.target.value)}
                            required />
                    </p>
                    <p>
                        <label>Password</label>
                        <Link to="/forg"><label className="right-label">Forget password?</label></Link>
                        <br />
                        <input type="password" name="password" minLength={8}
                            id='pass'
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required />
                    </p>
                    <p>
                        <button id="sub_btn" type="submit" onClick={handleLogin}>Login</button>
                    </p>
                </form>

                <footer>
                    <p>First time? <Link to="/register">Create an account</Link></p>
                    <p><Link to="/home">Back to Homepage</Link></p>

                </footer>
            </div>
            </div>
        </>
    )
}
