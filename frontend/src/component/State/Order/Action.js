import { api } from "../../Config/api";
import { CREATE_ORDER_FAILURE, CREATE_ORDER_REQUEST, CREATE_ORDER_SUCCESS, GET_USERS_NOTIFICATION_FAILURE, GET_USERS_NOTIFICATION_REQUEST, GET_USERS_NOTIFICATION_SUCCESS, GET_USERS_ORDER_FAILURE, GET_USERS_ORDER_REQUEST, GET_USERS_ORDER_SUCCESS } from "./ActionType";

export const createOrder = (reqData) => {
  return async (dispatch) => {
    dispatch({ type: CREATE_ORDER_REQUEST });
    try {
      const { data } = await api.post(
        `/api/order` , reqData.order,
        {
          headers: {
            Authorization: `Bearer ${reqData.jwt}`,
          },
        }
      );
      if(data.payment_url){
        window.location.href=data.payment_url;
      }

      dispatch({ type: CREATE_ORDER_SUCCESS, payload: data });
      console.log("Create Order", data);
    } catch (error) {
      dispatch({ type: CREATE_ORDER_FAILURE, payload: error });
      console.log("Catch Error", error);
    }
  };
};

export const getUsersOrder = (jwt) => {
    return async (dispatch) => {
      dispatch({ type: GET_USERS_ORDER_REQUEST });
      try {
        const { data } = await api.get(
          `/api/order/user` ,
          {
            headers: {
              Authorization: `Bearer ${jwt}`,
            },
          }
        );
        dispatch({ type: GET_USERS_ORDER_SUCCESS, payload: data });
        console.log("Users Order", data);
      } catch (error) {
        dispatch({ type: GET_USERS_ORDER_FAILURE, payload: error });
        console.log("Catch Error", error);
      }
    };
  };

// export const getUsersNotification = () => {
//     return async (dispatch) => {
//       dispatch({ type: GET_USERS_NOTIFICATION_REQUEST });
//       try {
//         const { data } = await api.get(`/api/notifications`);

//         dispatch({ type: GET_USERS_NOTIFICATION_SUCCESS, payload: data });
//         console.log("all notification", data);
//       } catch (error) {
//         dispatch({ type: GET_USERS_NOTIFICATION_FAILURE, payload: error });
//         console.log("Catch Error", error);
//       }
//     };
//   };