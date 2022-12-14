import React from 'react';
import NavbarComponent from '../components/Navbar';
import F2oter from '../components/F2oter';
import GoogleBooksSearch from "../components/googleBooksSearch"; 
import {links} from "../data/links";
import '../App.css';

function Store(){
  
    return(
        <>
        
            <NavbarComponent></NavbarComponent>
            <GoogleBooksSearch></GoogleBooksSearch>
            <F2oter links={links}></F2oter>
        </>
    ) 
}

export default Store;