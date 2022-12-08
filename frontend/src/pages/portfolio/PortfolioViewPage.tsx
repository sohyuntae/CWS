import { useEffect } from "react";
import { useParams } from "react-router-dom";
import { useRecoilValueLoadable } from "recoil";
import { portfolioSelector } from "../../assets/states/portfolio";

export default function PortfolioViewPage() {
  const { state, contents } = useRecoilValueLoadable(portfolioSelector);
  const { portfolioId } = useParams();

  return <div>PortfolioViewPage {portfolioId} </div>;
}
