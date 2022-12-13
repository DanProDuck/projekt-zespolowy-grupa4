import {Row, Col} from 'react-bootstrap';
import { productsArray } from '../productsStore';
import ProductCard from '../components/ProductCard';
import React, {useState} from 'react' ;
import axios from 'axios';  
//import SidebarMenuComponent from '../components/SidebarMenuComponent';
//import "react-pro-sidebar/dist/css/styles.css";
//import 'bootstrap/dist/css/bootstrap.min.css';
//import "react-pro-sidebar/dist/css/styles.css";
import NavbarComponent from '../components/Navbar';
import PrimarySearchAppBar from '../components/Navbar1';
import ArticlesCardsGrid  from '../components/Card';
import GoogleBooksSearch from "../googleBooksSearch"; 
import { createStyles, SimpleGrid, Card, Image, Text, Container, AspectRatio } from '@mantine/core';
import '../App.css';


// //<> 
// <NavbarComponent></NavbarComponent>
// <Row xs={1} md={3} className="g-4">
//     {productsArray.map((product, idx) => (
//     <Col align="center" key={idx}>
//         <Card/>
//     </Col>
//     ))}
// </Row>
// </> // </> <-- this is fragment

//      image:
//        'https://images.unsplash.com/photo-1527004013197-933c4bb611b3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=720&q=80',

function Store(){
  
    return(
        <>
            <NavbarComponent></NavbarComponent>
            <GoogleBooksSearch></GoogleBooksSearch>

        </>
    ) 
}

export default Store;