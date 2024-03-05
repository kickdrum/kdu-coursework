import './App.css'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import DashboardPage from './pages/DashboardPage'
import PorfolioPage from './pages/PortfolioPage'
import StockPage from './pages/StockPage'
import SummarizerPage from './pages/SummarizerPage'
import { useEffect } from 'react'
import { useDispatch } from 'react-redux'
import { AppDispatch } from './redux/store'
import { getStocks } from './redux/thunks/GetStocks'


function App() {
  const reduxDispatch: AppDispatch = useDispatch();
  useEffect(() => {
    reduxDispatch(getStocks());
   
  }, []);
  

  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<DashboardPage />} />
        <Route path='/stock/:id' element={<StockPage/> } />
        <Route path='/portfolio' element={<PorfolioPage />} />
        <Route path='/summarizer' element={<SummarizerPage/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App
