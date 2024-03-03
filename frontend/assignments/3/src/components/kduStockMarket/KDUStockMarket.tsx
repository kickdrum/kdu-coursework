import { BrowserRouter, Route, Routes } from "react-router-dom";
import DashboardHeader from "../navbar/DashboardHeader";
import DashboardPage from "../pages/DashboardPage";
import StockPage from "../pages/StockPage";
import PortfolioPage from "../pages/PortfolioPage";
import { SummarizerPage } from "../pages/SummarizerPage";

export function KDUStockMarket() {
  return (
    <div>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap"/>
      <BrowserRouter>
            <div className='header'>
              <DashboardHeader/>
            </div>
            <Routes>
                <Route path="/" element={<DashboardPage/>}/>
                <Route path="/stock/:id" element={<StockPage/>}/>
                <Route path="/portfolio" element={<PortfolioPage/>}/>
                <Route path="/summerizer" element={<SummarizerPage/>}/>
            </Routes>
        </BrowserRouter>
    </div>
  )
}
