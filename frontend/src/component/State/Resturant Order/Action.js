import axios from "axios";

import { api } from "../../Config/api";
import { GET_RESTURANTS_ORDER_FAILURE, GET_RESTURANTS_ORDER_REQUEST, GET_RESTURANTS_ORDER_SUCCESS, UPDATE_ORDER_STATUS_FAILURE, UPDATE_ORDER_STATUS_REQUEST, UPDATE_ORDER_STATUS_SUCCESS } from "./ActionType";



export const updateOrderStatus = ({orderId, orderStatus, jwt}) => {
  return async (dispatch) => {
    dispatch({ type: UPDATE_ORDER_STATUS_REQUEST });
    try {
      const response = await api.put(
        `/api/admin/order/${orderId}/${orderStatus}` , {} ,
        {
          headers: {
            Authorization: `Bearer ${jwt}`,
          },
        }
      );

      const updatedOrder = response.data;
      console.log("Updated order", updatedOrder);

      dispatch({ type: UPDATE_ORDER_STATUS_SUCCESS, payload: updatedOrder, });
      
    } catch (error) {
      dispatch({ type: UPDATE_ORDER_STATUS_FAILURE, payload: error });
      console.log("Catch Error", error);
    }
  };
};

export const fetchResturantsOrder = ({resturantId, orderStatus, jwt}) => {
    return async (dispatch) => {
      try {
        dispatch({ type: GET_RESTURANTS_ORDER_REQUEST });

        const { data } = await api.get(
          `/api/admin/order/resturant/${resturantId}` , { 
            params: { order_status : orderStatus  } ,
            headers: {
              Authorization: `Bearer ${jwt}`,
            },
          }
        );
  
        const orders = data;
        console.log("resturant orders", orders);
        dispatch({ type: GET_RESTURANTS_ORDER_SUCCESS, payload: orders, });
        
      } catch (error) {
        dispatch({ type: GET_RESTURANTS_ORDER_FAILURE, payload: error });
        console.log("Catch Error", error);
      }
    };
  };