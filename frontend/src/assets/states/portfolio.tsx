import { selector, selectorFamily } from "recoil";
import axios from "axios";

export const portfolioSelector = selector<any>({
  key: "portfolioSelector",
  get: async () => {
    const response = await axios.get("/data/portfolio.json");
    return response.data;
  },
});

export const porfolioSelectorFamily = selectorFamily<any, string>({
  key: "portfolioSelectorFamily",
  get: (portfolioId: string) => async () => {
    const response = await axios.get("http://localhost:3000/data/portfolio.json");
    return response.data;
  },
});
