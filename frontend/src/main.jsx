import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'
import {AppShell, MantineProvider} from "@mantine/core";
import Navbar from "./components/UI/Navbar";
import Footer from "./components/UI/Footer";
import {BrowserRouter} from "react-router-dom";

ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <MantineProvider theme={{colorScheme: 'light'}} withGlobalStyles withNormalizeCSS>
            <BrowserRouter>
                <AppShell navbar={<Navbar/>}
                          footer={<Footer/>}
                          aside={<div style={{width: 0}}/>}
                >
                    <App/>
                </AppShell>
            </BrowserRouter>
        </MantineProvider>
    </React.StrictMode>
)
