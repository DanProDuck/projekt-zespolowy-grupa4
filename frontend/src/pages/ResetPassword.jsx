
import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Paper from '@mui/material/Paper';
import Container from '@mui/material/Container';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import logo from '../logo-bookly_v2.png';
//import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import { createTheme, ThemeProvider } from '@mui/material/styles';

const theme = createTheme();

function ResetPassword() {
  const handleSubmit = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    var datta = {
      email: data.get('email')
    };
    console.log(JSON.stringify(datta));

    (async () => {
      const rawResponse = await fetch("http://127.0.0.1:8082/auth/registration", {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
      },
      body: JSON.stringify(datta)
    })

    const content = await rawResponse.json();

   console.log(content);
  })();
}

  return (
    <ThemeProvider theme={theme}>
      <Container component="main" maxWidth="xs">
        <a href="/">
          <img style = {{marginTop:"30px"}} width= "40%" src={logo} alt="logoBrand"/>
        </a>
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          <Typography component="h1" variant="h5">
            Password Reset
          </Typography>
          <Box component="form" style={{backgroundColor: 'transparent'}} noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
          <Typography component="h1" style={{color:'grey', fontSize:'12px'}}>
            Please enter your email to reset your password
          </Typography>
            <Grid container spacing={2}>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  id="email"
                  label="Email Address"
                  name="email"
                  autoComplete="email"
                />
              </Grid>
            </Grid>
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              Reset
            </Button>
          </Box>
        </Box>
      </Container>
    </ThemeProvider>
  );
}

export default ResetPassword;