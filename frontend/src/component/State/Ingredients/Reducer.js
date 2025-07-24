import {
  CREATE_INGREDINT_CATEGORY_SUCCESS,
  CREATE_INGREDINT_SUCCESS,
  GET_INGREDINT_CATEGORY_SUCCESS,
  GET_INGREDINTS,
  UPDATE_STOCK,
} from "./ActionType";

const initialState = {
  ingredients: [],
  update: null,
  category: [],
};

export const ingredientReducer = (state = initialState, action) => {
  switch (action.type) {
    case GET_INGREDINTS:
      return {
        ...state,
        ingredients: action.payload,
      };

    case GET_INGREDINT_CATEGORY_SUCCESS:
      return {
        ...state,
        category: action.payload,
      };

    case CREATE_INGREDINT_CATEGORY_SUCCESS:
      return {
        ...state,
        category: [...state.category, action.payload],
      };

    case CREATE_INGREDINT_SUCCESS:
      return {
        ...state,
        ingredients: [...state.ingredients, action.payload],
      };

    case UPDATE_STOCK:
      return {
        ...state,
        update: action.payload,
        ingredients: state.ingredients.map((item) =>
          item.id === action.payload.id ? action.payload : item
        ),
      };

    default:
      return state;
  }
};
