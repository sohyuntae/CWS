import axios from "axios";
import { selectorFamily } from "recoil";

export const newsSelectorFamily = selectorFamily<any, string>({
  key: "newsSelectorFamily",
  get:
    (query: string | undefined = "database") =>
    async () => {
      const response = await axios.get(
        `https://newsapi.org/v2/everything?q=${query}&from=2022-11-13&sortBy=publishedAt&apiKey=c813fd83574245dfbc06d771ae0ba570`
      );
      return response.data;
    },
});
