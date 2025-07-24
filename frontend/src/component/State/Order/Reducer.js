import {
  GET_USERS_NOTIFICATION_SUCCESS,
  GET_USERS_ORDER_FAILURE,
  GET_USERS_ORDER_REQUEST,
  GET_USERS_ORDER_SUCCESS,
} from "./ActionType";

const initialState = {
  loading: false,
  orders: [],
  error: null,
//   notifications: [],
};

export const orderReducer = (state = initialState, { type, payload }) => {
  switch (type) {
    case GET_USERS_ORDER_REQUEST:
      return {
        ...state,
        error: null,
        loading: true,
      };

    case GET_USERS_ORDER_SUCCESS:
      return {
        ...state,
        error: null,
        loading: false,
        orders: payload,
      };

    // case GET_USERS_NOTIFICATION_SUCCESS:
    //   return {
    //     ...state,
    //     notifications: payload,
    //     error: null,
    //     loading: false,
    //   };

    case GET_USERS_ORDER_FAILURE:
      return {
        ...state,
        error: payload,
        loading: false,
      };

      default:
        return state;
  }
};
