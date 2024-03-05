import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import { PaletteColorOptions, PaletteOptions, ThemeProvider, createTheme } from '@mui/material';
import { Provider } from 'react-redux';
import { store } from './redux/store.ts';
interface CustomPaletteOptions extends PaletteOptions {
  tertiary?: PaletteColorOptions; 
}
const theme = createTheme({
  palette: {
    primary: {
      main: '#1971c2', 
    },
    secondary: {
      main: '#ffffff', 
    },
    tertiary: {
      main: '#1e1e1e', 
    },
  } as CustomPaletteOptions,
  typography: {
    fontSize: 16,
    fontFamily: "Poppins",
    allVariants: {
      textTransform: 'none', 
    },
    h1: {
      fontSize: '2rem', 
    },
    h2: {
      fontSize: '1.5rem',
    },
    h3: {
      fontSize:'1.3rem'
    },
    h4: {
      fontSize:'1rem'
    },
    h5: {
      fontSize:'0.8rem'
    },
    h6: {
      fontSize:'0.7rem'
    }
  },
 

});

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
   
    <ThemeProvider theme={theme}>
    <Provider store={store}>
        <App />
           </Provider>
      </ThemeProvider>
 
   
  </React.StrictMode>,
)
