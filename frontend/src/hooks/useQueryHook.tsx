import React from "react";
import { useQuery, UseQueryOptions } from "react-query";
import axios, { AxiosError, AxiosPromise, AxiosResponse } from "axios";

export const useQueryHook = (
  key: string | readonly unknown[],
  api: Promise<any>,
  options?: UseQueryOptions<AxiosResponse<any>, AxiosError, any>
) => {
  //   const { key, params, api } = props;
  return useQuery(key, () => api, { ...options });
};
