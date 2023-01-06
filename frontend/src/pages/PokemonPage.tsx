import React, { useState } from "react";
import { useQueryHook } from "@/hooks/useQueryHook";
import { getPokemon } from "@/apis/pokemonApi";
import QUERY_KEYS from "@/constants/queryKeys";

export const PokemonPage = () => {
  const [id, setId] = useState<number>(1);
  const { isLoading, isError, data } = useQueryHook([QUERY_KEYS.POKEMON, id], getPokemon(id));

  return (
    <div>
      {/* {data && <p>{JSON.stringify(data)}</p>} */}
      <button onClick={() => setId(id - 1)}>-</button>
      <button onClick={() => setId(id + 1)}>+</button>
      <p>{data && data.name}</p>
    </div>
  );
};
