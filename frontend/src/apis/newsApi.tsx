import axios from "axios";

const apiKey = "c813fd83574245dfbc06d771ae0ba570";

const url = "https://newsapi.org/v2/everything";

export const getNews = async (params: any) => {
  const response = await axios.get(url, { params: { ...params, apiKey: apiKey } });
  return response.data;
};
