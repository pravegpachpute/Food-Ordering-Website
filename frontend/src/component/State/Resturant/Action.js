import { api } from "../../Config/api";
import {
  CREATE_CATEGORY_FAILURE,
  CREATE_CATEGORY_REQUEST,
  CREATE_CATEGORY_SUCCESS,
  CREATE_EVENTS_FAILURE,
  CREATE_EVENTS_REQUEST,
  CREATE_EVENTS_SUCCESS,
  CREATE_RESTURANT_FAILURE,
  CREATE_RESTURANT_REQUEST,
  CREATE_RESTURANT_SUCCESS,
  DELETE_EVENTS_FAILURE,
  DELETE_EVENTS_REQUEST,
  DELETE_EVENTS_SUCCESS,
  DELETE_RESTURANT_FAILURE,
  DELETE_RESTURANT_REQUEST,
  DELETE_RESTURANT_SUCCESS,
  GET_ALL_EVENTS_FAILURE,
  GET_ALL_EVENTS_REQUEST,
  GET_ALL_EVENTS_SUCCESS,
  GET_ALL_RESTURANTS_FAILURE,
  GET_ALL_RESTURANTS_REQUEST,
  GET_ALL_RESTURANTS_SUCCESS,
  GET_RESTURANT_BY_ID_FAILURE,
  GET_RESTURANT_BY_ID_REQUEST,
  GET_RESTURANT_BY_ID_SUCCESS,
  GET_RESTURANT_BY_USER_ID_FAILURE,
  GET_RESTURANT_BY_USER_ID_REQUEST,
  GET_RESTURANT_BY_USER_ID_SUCCESS,
  GET_RESTURANTS_CATEGORY_FAILURE,
  GET_RESTURANTS_CATEGORY_REQUEST,
  GET_RESTURANTS_CATEGORY_SUCCESS,
  GET_RESTURANTS_EVENTS_FAILURE,
  GET_RESTURANTS_EVENTS_REQUEST,
  GET_RESTURANTS_EVENTS_SUCCESS,
  UPDATE_RESTURANT_FAILURE,
  UPDATE_RESTURANT_REQUEST,
  UPDATE_RESTURANT_STATUS_FAILURE,
  UPDATE_RESTURANT_STATUS_REQUEST,
  UPDATE_RESTURANT_STATUS_SUCCESS,
  UPDATE_RESTURANT_SUCCESS,
} from "./ActionType";

export const getAllResturantsAction = (token) => {
  return async (dispatch) => {
    dispatch({ type: GET_ALL_RESTURANTS_REQUEST });
    try {
      const { data } = await api.get(`/api/resturants`, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });

      dispatch({ type: GET_ALL_RESTURANTS_SUCCESS, payload: data });
      console.log("All Resturants", data);
    } catch (error) {
      dispatch({ type: GET_ALL_RESTURANTS_FAILURE, payload: error });
      console.log("Catch Error", error);
    }
  };
};

export const getResturantById = (reqData) => {
  return async (dispatch) => {
    dispatch({ type: GET_RESTURANT_BY_ID_REQUEST });
    try {
      const response = await api.get(`/api/resturants/${reqData.resturantId}`, {
        headers: {
          Authorization: `Bearer ${reqData.jwt}`,
        },
      });

      dispatch({ type: GET_RESTURANT_BY_ID_SUCCESS, payload: response.data });
    } catch (error) {
      dispatch({ type: GET_RESTURANT_BY_ID_FAILURE, payload: error });
     
    }
  };
};

export const getResturantByUserId = (jwt) => {
  return async (dispatch) => {
    dispatch({ type: GET_RESTURANT_BY_USER_ID_REQUEST });
    try {
      const { data } = await api.get(`/api/admin/resturants/user`, {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });

      dispatch({ type: GET_RESTURANT_BY_USER_ID_SUCCESS, payload: data });
      console.log("Get Resturant By User Id", data);
    } catch (error) {
      dispatch({ type: GET_RESTURANT_BY_USER_ID_FAILURE, payload: error });
      console.log("Catch Error", error);
    }
  };
};

export const createResturant = (reqData) => {
  console.log("token---", reqData.token);
  return async (dispatch) => {
    dispatch({ type: CREATE_RESTURANT_REQUEST });
    try {
      const { data } = await api.post(
        `/api/admin/resturants`,
        reqData.data,
        {
          headers: {
            Authorization: `Bearer ${reqData.token}`,
          },
        }
      );

      dispatch({ type: CREATE_RESTURANT_SUCCESS, payload: data });
      console.log("Create a Resturant", data);
    } catch (error) {
      dispatch({ type: CREATE_RESTURANT_FAILURE, payload: error });
      console.log("Catch Error", error);
    }
  };
};

export const updateResturant = ({ resturantId, resturantData, jwt }) => {
  return async (dispatch) => {
    dispatch({ type: UPDATE_RESTURANT_REQUEST });
    try {
      const res = await api.put(
        `/api/admin/resturants/${resturantId}`,
        resturantData,
        {
          headers: {
            Authorization: `Bearer ${jwt}`,
          },
        }
      );

      dispatch({ type: UPDATE_RESTURANT_SUCCESS, payload: res.data });
    } catch (error) {
      dispatch({ type: UPDATE_RESTURANT_FAILURE, payload: error });
    }
  };
};

export const deleteResturant = ({ resturantId, jwt }) => {
  return async (dispatch) => {
    dispatch({ type: DELETE_RESTURANT_REQUEST });
    try {
      const res = await api.delete(`/api/admin/resturants/${resturantId}`, {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });

      dispatch({ type: DELETE_RESTURANT_SUCCESS, payload: resturantId });
      console.log("Delete a Resturant", res.data);
    } catch (error) {
      dispatch({ type: DELETE_RESTURANT_FAILURE, payload: error });
      console.log("Catch Error", error);
    }
  };
};

export const updateResturantStatus = ({ resturantId, jwt }) => {
  return async (dispatch) => {
    dispatch({ type: UPDATE_RESTURANT_STATUS_REQUEST });
    try {
      const res = await api.put(
        `/api/admin/resturants/${resturantId}/status`,
        {},
        {
          headers: {
            Authorization: `Bearer ${jwt}`,
          },
        }
      );

      dispatch({ type: UPDATE_RESTURANT_STATUS_SUCCESS, payload: res.data });
      console.log("Status Resturant", res.data);
    } catch (error) {
      dispatch({ type: UPDATE_RESTURANT_STATUS_FAILURE, payload: error });
      console.log("error", error);
    }
  };
};

export const createEventAction = ({ data, jwt, resturantId }) => {
  return async (dispatch) => {
    dispatch({ type: CREATE_EVENTS_REQUEST });
    try {
      const res = await api.post(
        `/api/admin/events/resturant/${resturantId}`,
        data,
        {
          headers: {
            Authorization: `Bearer ${jwt}`,
          },
        }
      );

      dispatch({ type: CREATE_EVENTS_SUCCESS, payload: res.data });
      console.log("Create a Event", res.data);
    } catch (error) {
      dispatch({ type: CREATE_EVENTS_FAILURE, payload: error });
      console.log("Catch Error", error);
    }
  };
};

export const getAllEvents = ({ jwt }) => {
  return async (dispatch) => {
    dispatch({ type: GET_ALL_EVENTS_REQUEST });
    try {
      const res = await api.get(`/api/events`, {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });

      dispatch({ type: GET_ALL_EVENTS_SUCCESS, payload: res.data });
      console.log("Create a Event", res.data);
    } catch (error) {
      dispatch({ type: GET_ALL_EVENTS_FAILURE, payload: error });
      console.log("Catch Error", error);
    }
  };
};

export const deleteEventAction = ({ eventId, jwt }) => {
  return async (dispatch) => {
    dispatch({ type: DELETE_EVENTS_REQUEST });
    try {
      const res = await api.delete(`/api/admin/events/${eventId}`, {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });

      dispatch({ type: DELETE_EVENTS_SUCCESS, payload: eventId });
      console.log("delete a Event", res.data);
    } catch (error) {
      dispatch({ type: DELETE_EVENTS_FAILURE, payload: error });
      console.log("Catch Error", error);
    }
  };
};

export const getResturantsEvents = ({ resturantId, jwt }) => {
  return async (dispatch) => {
    dispatch({ type: GET_RESTURANTS_EVENTS_REQUEST });
    try {
      const res = await api.get(`/api/admin/events/resturant/${resturantId}`, {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });

      dispatch({ type: GET_RESTURANTS_EVENTS_SUCCESS, payload: res.data });
      console.log("Get Resturant Events", res.data);
    } catch (error) {
      dispatch({ type: GET_RESTURANTS_EVENTS_FAILURE, payload: error });
      console.log("Catch Error", error);
    }
  };
};

export const createCategoryAction = ({ reqData, jwt }) => {
  return async (dispatch) => {
    dispatch({ type: CREATE_CATEGORY_REQUEST });
    try {
      const res = await api.post(`/api/admin/category`, reqData, {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });

      dispatch({ type: CREATE_CATEGORY_SUCCESS, payload: res.data });
      console.log("Create Category", res.data);
    } catch (error) {
      dispatch({ type: CREATE_CATEGORY_FAILURE, payload: error });
      console.log("Catch Error", error);
    }
  };
};

export const getResturantsCategory = ({ jwt, resturantId }) => {
  return async (dispatch) => {
    dispatch({ type: GET_RESTURANTS_CATEGORY_REQUEST });
    try {
      const res = await api.get(
        `/api/category/resturant/${resturantId}`,
        {
          headers: {
            Authorization: `Bearer ${jwt}`,
          },
        }
      );

      dispatch({ type: GET_RESTURANTS_CATEGORY_SUCCESS, payload: res.data });
      console.log("Get Resturant Category", res.data);
    } catch (error) {
      dispatch({ type: GET_RESTURANTS_CATEGORY_FAILURE, payload: error });
      console.log("Catch Error", error);
    }
  };
};
