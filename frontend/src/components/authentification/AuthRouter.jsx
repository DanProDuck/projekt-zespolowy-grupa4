import {Route, Router, Routes} from "react-router-dom";
import {LogIn} from "./elements/LogIn.jsx";
import {SignUp} from "./elements/SignUp.jsx";
import {ResetPassword} from "./elements/ResetPassword.jsx";

const AuthRouter = () => {
    return(
        <Routes>
            <Route path="/login" element={<LogIn />}/>
            <Route path="/signup" element={<SignUp />}/>
            <Route path="/reset" element={<ResetPassword />}/>
        </Routes>
    );
}

export default AuthRouter;