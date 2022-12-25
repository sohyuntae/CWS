import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { useRecoilValueLoadable } from "recoil";
import { portfolioSelector } from "@/states/portfolio";
import iPortfolio from "@/interfaces/iPortfolio";

export default function PortfolioViewPage() {
  const navigate = useNavigate();
  const { portfolioId } = useParams();
  const { state, contents } = useRecoilValueLoadable(portfolioSelector);
  const [portfolio, setPortfolio] = useState<iPortfolio>();

  useEffect(() => {
    if (state === "hasValue") {
      const data = contents.find((content: iPortfolio) => content.id === Number(portfolioId));

      if (!data) {
        alert("존재하지 않는 포트폴리오입니다.");
        navigate("/portfolio");
      } else {
        setPortfolio(data);
      }
    }
  }, [state, contents, navigate, portfolioId]);

  return (
    <div>
      {portfolio !== null && (
        <div>
          <h1>{portfolio?.title}</h1>
          <hr />
          <div className="content">{portfolio?.description}</div>
        </div>
      )}
    </div>
  );
}
