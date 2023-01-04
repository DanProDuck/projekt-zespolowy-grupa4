import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
// import SidebarMenuComponent from './components/SidebarMenu';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Cancel from './pages/Cancel';
import Store from './pages/Store';
import Success from './pages/Success';
import Registration from "./pages/Registration";
import Login from "./pages/Login";
import ResetPassword from "./pages/ResetPassword";
import AdminPanel from './pages/AdminPanel';
import Contact from './pages/Contact';
import About from './pages/About';
import Privacy from './pages/Privacy';
import TermsOfService from './pages/TermsOfService';
import CartProvider from './CartContext';
import { Container } from "react-bootstrap";
import { Link } from 'react-router-dom';
import F2oter from './components/F2oter';
// import "react-pro-sidebar/dist/css/styles.css";
//import "./CardStyles.css";
// localhost:3000 -> Home
// localhost:3000/success -> Success

function App() {
  return (
    <>
      <CartProvider>
        <div className="App" >
            <Container>
              <BrowserRouter>
                <Routes>
                  <Route index element={<Store />} />
                  <Route path="success" element={<Success />} />
                  <Route path="cancel" element={<Cancel />} />
                  <Route path="registration" element={<Registration />} />
                  <Route path="login" element={<Login />} />
                  <Route path="passreset" element={<ResetPassword />} />
                  <Route path="adminPanel" element={<AdminPanel />} />
                  
                  {/*footer*/}
                  <Route path="contact" element={<Contact />} />
                  <Route path="privacy" element={<Privacy />} />
                  <Route path="termsofservice" element={< TermsOfService/>} />
                  <Route path="about" element={<About />} />
                </Routes>
              </BrowserRouter>
          </Container>
        </div>
      </CartProvider> 
    </>
  );
}

export default App;