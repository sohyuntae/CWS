import axios from "axios";

const url = "https://pokeapi.co/api/v2/pokemon";

export const getPokemon = async (id: number) => {
  const response = await axios.get(url + `/${id}`);
  return response.data;
};
