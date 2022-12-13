import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
// import SidebarMenuComponent from './components/SidebarMenu';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Cancel from './pages/Cancel';
import Store from './pages/Store';
import Success from './pages/Success';
import Registration from "./pages/Registration";
 import Login from "./pages/Login";
 import CartProvider from './CartContext';
 import { Container } from "react-bootstrap";
 import { Link } from 'react-router-dom';
 // import "react-pro-sidebar/dist/css/styles.css";
//import "./CardStyles.css";
// localhost:3000 -> Home
// localhost:3000/success -> Success

function App() {
  return (
    <>
      <CartProvider>
        <div className="App">
            <Container>
              <BrowserRouter>
                <Routes>
                  <Route index element={<Store />} />
                  <Route path="success" element={<Success />} />
                  <Route path="cancel" element={<Cancel />} />
                  <Route path="registration" element={<Registration />} />
                  <Route path="login" element={<Login />} />
                </Routes>
              </BrowserRouter>
          </Container>
        </div>
      </CartProvider> 
    </>
  );
}

export default App;