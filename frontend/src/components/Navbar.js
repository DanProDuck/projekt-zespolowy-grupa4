import {Button, Container, Navbar, Modal} from 'react-bootstrap';
import { useState, useContext } from 'react';
import TextField from "@mui/material/TextField";
import { CartContext } from "../CartContext";
import CartProduct from './CartProduct';
import logo from '../logo_bookly_v2.png';

function NavbarComponent() {
    const cart = useContext(CartContext);

    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const [book, setBook] = useState("");  

    const checkout = async () => {
        await fetch('http://localhost:4000/checkout', {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({items: cart.items})
        }).then((response) => {
            return response.json();
        }).then((response) => {
            if(response.url) {
                window.location.assign(response.url); // Forwarding user to Stripe
            }
        });
    }

    function handleChange(event) {  
        const book = event.target.value;  
        setBook(book);  
    }  

    const productsCount = cart.items.reduce((sum, product) => sum + product.quantity, 0);
    return (
        <>
            <Navbar  expand="sm">
                <a href="#">
                    <img width= "50%" auto src={logo} alt="logoBrand"/>
                    {/* <img max-width= "50%" height="auto" auto src={logo} alt="logoBrand"/> */}
                </a>

                <Navbar.Toggle />
                <Navbar.Collapse className="justify-content-end">
                    <Button onClick={handleShow}>Cart ({productsCount} Items)</Button>
                    <a style={{marginLeft: '10px'}} href = "http://localhost:3000/registration">Sign In/Up</a>
                </Navbar.Collapse>
            </Navbar>
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Shopping Cart</Modal.Title>
                    <Modal.Title>Sign In/Up</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    {productsCount > 0 ?
                        <>
                            <p>Items in your cart:</p>
                            {cart.items.map( (currentProduct, idx) => (
                                <CartProduct key={idx} id={currentProduct.id} quantity={currentProduct.quantity}></CartProduct>
                            ))}

                            <h1>Total: {cart.getTotalCost().toFixed(2)}</h1>

                            <Button variant="success" onClick={checkout}>
                                Purchase items!
                            </Button>
                        </>
                    :
                        <h1>There are no items in your cart!</h1>
                    }
                </Modal.Body>
            </Modal>
        </>
    )
}

export default NavbarComponent;