import { applyMiddleware, combineReducers, legacy_createStore } from "redux";
import { authReducer } from "./Authentication/Reducer";
import { thunk } from "redux-thunk";
import resturantReducer from "./Resturant/Reducer";
import menuItemReducer from "./Menu/Reducer";
import cartReducer from "./Cart/Reducer";
import { orderReducer } from "./Order/Reducer";
import resturantsOrderReducer from "./Resturant Order/Reducer";
import { ingredientReducer } from "./Ingredients/Reducer";

const rootReducer = combineReducers({
    auth : authReducer, 
    resturant:resturantReducer,
    menu:menuItemReducer,
    cart:cartReducer,
    order: orderReducer,
    resturantOrder: resturantsOrderReducer,
    ingredients: ingredientReducer

})

export const Store = legacy_createStore(rootReducer, applyMiddleware(thunk))