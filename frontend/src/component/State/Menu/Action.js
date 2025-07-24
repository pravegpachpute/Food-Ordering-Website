import { api } from "../../Config/api";

import { CREATE_MENU_ITEM_FAILURE, CREATE_MENU_ITEM_REQUEST, CREATE_MENU_ITEM_SUCCESS, DELETE_MENU_ITEM_FAILURE, DELETE_MENU_ITEM_REQUEST, DELETE_MENU_ITEM_SUCCESS, GET_MENU_ITEMS_BY_RESTURANT_ID_FAILURE, GET_MENU_ITEMS_BY_RESTURANT_ID_REQUEST, GET_MENU_ITEMS_BY_RESTURANT_ID_SUCCESS, SEARCH_MENU_ITEM_FAILURE, SEARCH_MENU_ITEM_REQUEST, SEARCH_MENU_ITEM_SUCCESS, UPDATE_MENU_ITEMS_AVAILABILITY__FAILURE, UPDATE_MENU_ITEMS_AVAILABILITY__SUCCESS, UPDATE_MENU_ITEMS_AVAILABILITY_REQUEST } from "./ActionType";


export const createMenuItem = ({ menu, jwt}) => {
  return async (dispatch) => {
    dispatch({ type: CREATE_MENU_ITEM_REQUEST });
    try {
      const { data } = await api.post(
        `/api/admin/food` , menu,
        {
          headers: {
            Authorization: `Bearer ${jwt}`,
          },
        }
      );

      dispatch({ type: CREATE_MENU_ITEM_SUCCESS, payload: data });
      console.log("Create Menu", data);
    } catch (error) {
      dispatch({ type: CREATE_MENU_ITEM_FAILURE, payload: error });
      console.log("Catch Error", error);
    }
  };
};

export const getMenuItemsByResturantId = ( reqData ) => {
    return async (dispatch) => {
      dispatch({ type: GET_MENU_ITEMS_BY_RESTURANT_ID_REQUEST });
      try {
        const { data } = await api.get(
          `/api/food/resturant/${reqData.resturantId}?vegetarian=${reqData.vegetarian}&nonveg=${reqData.nonveg}&seasonal=${reqData.seasonal}&food_category=${reqData.foodCategory}` ,
          {
            headers: {
              Authorization: `Bearer ${reqData.jwt}`,
            },
          }
        );
  
        dispatch({ type: GET_MENU_ITEMS_BY_RESTURANT_ID_SUCCESS, payload: data });
        console.log("Get Menu Items by Resturant", data);
      } catch (error) {
        dispatch({ type: GET_MENU_ITEMS_BY_RESTURANT_ID_FAILURE, payload: error });
        console.log("Catch Error", error);
      }
    };
  };

  export const searchMenuItem = ({ keyword, jwt }) => {
    return async (dispatch) => {
      dispatch({ type: SEARCH_MENU_ITEM_REQUEST });
      try {
        const { data } = await api.get(
          `/api/food/search?name=${keyword}` ,
          {
            headers: {
              Authorization: `Bearer ${jwt}`,
            },
          }
        );
  
        dispatch({ type: SEARCH_MENU_ITEM_SUCCESS, payload: data });
        console.log("data----", data);
      } catch (error) {
        dispatch({ type: SEARCH_MENU_ITEM_FAILURE, payload: error });
        console.log("Catch Error", error);
      }
    };
  };

// //not creating this method
//   export const getAllIngredientsOfMenuItem = ( reqData ) => {
//     return async (dispatch) => {
//       dispatch({ type: });
//       try {
//         const { data } = await api.get(
//           `api/food/resturant/${reqData.resturantId}` ,
//           {
//             headers: {
//               Authorization: `Bearer ${reqData.jwt}`,
//             },
//           }
//         );
  
//         dispatch({ type: , payload: data });
//         console.log("Get Menu Items Resturant", data);
//       } catch (error) {
//         dispatch({ type: , payload: error });
//         console.log("Catch Error", error);
//       }
//     };
//   };

export const updateMenuItemsAvailability = ({ foodId, jwt}) => {
    return async (dispatch) => {
      dispatch({ type: UPDATE_MENU_ITEMS_AVAILABILITY_REQUEST });
      try {
        const { data } = await api.put(
          `/api/admin/food/${foodId}` , {},
          {
            headers: {
              Authorization: `Bearer ${jwt}`,
            },
          }
        );
  
        dispatch({ type: UPDATE_MENU_ITEMS_AVAILABILITY__SUCCESS, payload: data });
        console.log("Update menuItem Availability", data);
      } catch (error) {
        dispatch({ type: UPDATE_MENU_ITEMS_AVAILABILITY__FAILURE, payload: error });
        console.log("Catch Error", error);
      }
    };
  };

export const deleteFoodAction = ({ foodId, jwt}) => {
    return async (dispatch) => {
      dispatch({ type: DELETE_MENU_ITEM_REQUEST });
      try {
        const { data } = await api.delete(
          `/api/admin/food/${foodId}` , 
          {
            headers: {
              Authorization: `Bearer ${jwt}`,
            },
          }
        );
  
        dispatch({ type: DELETE_MENU_ITEM_SUCCESS, payload: foodId });
        console.log("delete food", data);
      } catch (error) {
        dispatch({ type: DELETE_MENU_ITEM_FAILURE, payload: error });
        console.log("Catch Error", error);
      }
    };
};  
