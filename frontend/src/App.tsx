import { Container } from "@mui/system";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import MainLayout from "./layouts/MainLayout";
import HomePage from "./pages/HomePage";
import IntroPage from "./pages/IntroPage";
import NewsPage from "./pages/NewsPage";
import PortfolioPage from "./pages/portfolio/PortfolioPage";
import PortfolioViewPage from "./pages/portfolio/PortfolioViewPage";
import RequestPage from "./pages/RequestPage";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <MainLayout>
          <Routes>
            <Route path="/" element={<HomePage />}></Route>
            <Route path="/intro" element={<IntroPage />}></Route>
            <Route path="/portfolio" element={<PortfolioPage />}></Route>
            <Route path="/portfolio/:portfolioId" element={<PortfolioViewPage />}></Route>
            <Route path="/request" element={<RequestPage />}></Route>
            <Route path="/news" element={<NewsPage />}></Route>
          </Routes>
        </MainLayout>
      </BrowserRouter>
    </div>
  );
}

export default App;
