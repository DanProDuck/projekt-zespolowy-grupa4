import { useState, useEffect, useRef } from "react";
import axios from "axios";
import DataList from "../components/adminPanel/DataList";
import "../components/adminPanel/AdminPanel.css"
import { Center } from "@mantine/core";
import { Container } from "react-bootstrap";
import logo from '../logo_bookly_text.png';
import classes from './contact.module.css';
import { fontFamily, fontStyle } from "@mui/system";

function Contact() {
    return (
        <Container>
            <a href="/">
                <img style={{ marginTop: "30px", marginBotton: "60px" }} width="40%" src={logo} alt="logoBrand" />
            </a>
            <h1>Contacts</h1>
            <Center>
                <div className = {classes.font} 
                style={{
                    display: "grid",
                    gridTemplateColumns: "1fr 200px",
                    //gridTemplateRows: "2fr 100px",
                    gridColumnGap: "50px",
                    gridRowGap: "20px",
                    justifyItems: "stretch",
                    alignItems: "stretch",
                    
                }}>
                    <div style={{ 'borderRadius': '15px', 'background': 'linear-gradient(120.08deg, #995AE7 0.53%, #AAFDE4 100%)'}}>
                        Lorem ipsum dolor sit, amet consectetur adipisicing elit. Maiores quia illo deleniti laudantium eaque exercitationem ab, rem quibusdam excepturi? Blanditiis accusantium ducimus illo cupiditate animi in dolorem minima maxime odio!
                    </div>
                    <div style={{ 'borderRadius': '15px', 'background': 'linear-gradient(240.08deg, #995AE7 0.53%, #AAFDE4 100%)' }}>
                        <Center>
                            <p>Contacts us</p>
                        </Center>
                        <p> +48 576 832 123</p>
                        <p> +48 576 239 366</p>
                        <p> +48 576 902 062</p>
                    </div>
                </div>
            </Center>
            <div style={{
                marginTop: "40px",
                borderRadius: '15px',
                background: 'linear-gradient(10.08deg, #995AE7 0.53%, #AAFDE4 100%)',
                gridTemplateColumns: "200px",
                //gridTemplateRows: "2fr 100px",


            }}>
                <p style = {{paddingTop:"20px"}}>Work schedule</p>
                <Center>
                    <span>mon - fr: 8 - 21 </span>
                </Center>
                <Center>
                    <span style = {{paddingBottom:"20px"}}>sat: 10 - 18 </span>
                </Center>
            </div>
        </Container>
    )
}

export default Contact;