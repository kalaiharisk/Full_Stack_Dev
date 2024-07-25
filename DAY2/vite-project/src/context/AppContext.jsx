import React, { createContext, useContext, useState } from 'react'
const GlobalContext=createContext();
export const useGlobalContext=()=>useContext(GlobalContext);

function AppContext({children}) {
    const[name,setName]=useState("Suresh");
  return (
    
    <GlobalContext.Provider value={{name,setName}}>
      {children}

    </GlobalContext.Provider>  
  )
}

export default AppContext