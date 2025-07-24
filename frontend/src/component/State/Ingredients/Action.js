import { API_URL, api } from "../../Config/api";
import axios from "axios";
import {
  CREATE_INGREDINT_CATEGORY_SUCCESS,
  CREATE_INGREDINT_SUCCESS,
  GET_INGREDINT_CATEGORY_SUCCESS,
  GET_INGREDINTS,
  UPDATE_STOCK,
} from "./ActionType";

export const getIngredintsOfResturant = ({ id, jwt }) => {
  return async (dispatch) => {
    try {
      const response = await api.get(`/api/admin/ingredients/resturant/${id}`, {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });
      console.log("Get all Ingredints", response.data);
      dispatch({ type: GET_INGREDINTS, payload: response.data });
    } catch (error) {
      console.log("Catch Error", error);
    }
  };
};

export const createIngredient = ({ data, jwt }) => {
  return async (dispatch) => {
    try {
      const response = await api.post(`/api/admin/ingredients`, data, {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });
      console.log("create Ingredints", response.data);
      dispatch({ type: CREATE_INGREDINT_SUCCESS, payload: response.data });
    } catch (error) {
      console.log("Catch Error", error);
    }
  };
};

export const createIngredientCategory = ({ data, jwt }) => {
  console.log("data", data, "jwt", jwt);
  return async (dispatch) => {
    try {
      const response = await api.post(`/api/admin/ingredients/category`, data, {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });
      console.log("create Ingredient category", response.data);
      dispatch({
        type: CREATE_INGREDINT_CATEGORY_SUCCESS,
        payload: response.data,
      });
    } catch (error) {
      console.log("Catch Error", error);
    }
  };
};

export const getIngredientCategory = ({ id, jwt }) => {
  return async (dispatch) => {
    try {
      const response = await api.get(
        `/api/admin/ingredients/resturant/${id}/category`,
        {
          headers: {
            Authorization: `Bearer ${jwt}`,
          },
        }
      );
      console.log("get Ingredint category", response.data);
      dispatch({
        type: GET_INGREDINT_CATEGORY_SUCCESS,
        payload: response.data,
      });
    } catch (error) {
      console.log("Catch Error", error);
    }
  };
};

export const updateStockOfIngredient = ({ id, jwt }) => {
  return async (dispatch) => {
    try {
      const { data } = await api.put(
        `/api/admin/ingredients/${id}/stock`,
        {},
        {
          headers: {
            Authorization: `Bearer ${jwt}`,
          },
        }
      );
      console.log("update Ingredint stock", data);
      dispatch({ type: UPDATE_STOCK, payload: data });
    } catch (error) {
      console.log("Catch Error", error);
    }
  };
};
