import React from "react";

const AuthContext = React.createContext(
    {
        isLoggedIn: false,
        userRole: 'ROLE_ANON'
    }
);