import axios from "axios";
import { selectorFamily } from "recoil";

const apiKey = "c813fd83574245dfbc06d771ae0ba570";

export const newsSelectorFamily = selectorFamily<any, string>({
  key: "newsSelectorFamily",
  get:
    (params: any = { q: "news", page: 1, pageSize: 10 }) =>
    async () => {
      const response = await axios.get(`https://newsapi.org/v2/everything`, { params: { ...params, apiKey: apiKey } });
      return response.data;
    },
});
