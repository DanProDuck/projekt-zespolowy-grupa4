import './App.css';
import {Route, Routes} from "react-router-dom";
import CartProvider from './context/CartContext';
import {Container} from '@mantine/core';
import FooterRouter from './components/footer/FooterRouter';
import Store from "./pages/Store";
import AuthRouter from "./components/authentification/AuthRouter.jsx";
import SingleProduct from "./pages/SingleProduct.jsx";
import Success from "./pages/Success.jsx";

function App() {
    return (
        <CartProvider>
            <Container fluid={true}>
                <Routes>
                    <Route index path="/" element={<Store/>}/>
                    <Route path="/product/:id" element={<SingleProduct/>}/>
                    <Route path="/success" element={<Success/>}/>
                </Routes>

                <AuthRouter/>
                <FooterRouter/>

            </Container>
        </CartProvider>
    );
}

export default App;