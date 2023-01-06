import { BrowserRouter, Routes, Route } from "react-router-dom";
import MainLayout from "@/layouts/MainLayout";
import HomePage from "@/pages/HomePage";
import IntroPage from "@/pages/IntroPage";
import NewsPage from "@/pages/NewsPage";
import { NotFoundPage } from "@/pages/NotFoundPage";
import PortfolioPage from "@/pages/portfolio/PortfolioPage";
import PortfolioViewPage from "@/pages/portfolio/PortfolioViewPage";
import RequestPage from "@/pages/RequestPage";
import { PokemonPage } from "@/pages/PokemonPage";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route
            path="/"
            element={
              <MainLayout>
                <HomePage />
              </MainLayout>
            }
          />
          <Route
            path="/intro"
            element={
              <MainLayout>
                <IntroPage />
              </MainLayout>
            }
          />
          <Route
            path="/portfolio"
            element={
              <MainLayout>
                <PortfolioPage />
              </MainLayout>
            }
          />
          <Route
            path="/portfolio/:portfolioId"
            element={
              <MainLayout>
                <PortfolioViewPage />
              </MainLayout>
            }
          />
          <Route
            path="/request"
            element={
              <MainLayout>
                <RequestPage />
              </MainLayout>
            }
          />
          <Route path="/pokemon" element={<PokemonPage />} />
          <Route
            path="/news"
            element={
              <MainLayout>
                <NewsPage />
              </MainLayout>
            }
          />
          <Route path="/error/not-found" element={<NotFoundPage />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
