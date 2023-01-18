import React from "react";
import {Route, Router, Routes} from "react-router-dom";
import Privacy from "./elements/Privacy.jsx";
import TermsOfService from "./elements/TermsOfService.jsx";
import About from "./elements/About.jsx";
import {ContactUs} from "./elements/ContactUs.jsx";

const FooterRouter = () => {
    return (
        <Routes>
            <Route path="/contacts" element={<ContactUs/>} />
            <Route path="/privacy" element={<Privacy/>} />
            <Route path="/tos" element={<TermsOfService/>} />
            <Route path="/about" element={<About/>} />
        </Routes>
    )
}

export default FooterRouter;