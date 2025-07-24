import * as actionType from "./ActionType";

const initialState = {
  resturants: [],
  usersResturant: null,
  resturant: null,
  loading: false,
  error: null,
  events: [],
  resturantsEvents: [],
  categories: [],
};

const resturantReducer = ( state = initialState, action ) => {
  switch (action.type) {
    case actionType.CREATE_RESTURANT_REQUEST:
    case actionType.GET_ALL_RESTURANTS_REQUEST:
    case actionType.DELETE_RESTURANT_REQUEST:
    case actionType.UPDATE_RESTURANT_REQUEST:
    case actionType.GET_RESTURANT_BY_ID_REQUEST:
    case actionType.CREATE_CATEGORY_REQUEST:
    case actionType.GET_RESTURANTS_CATEGORY_REQUEST:
      return { ...state, loading: true, error: null };

    case actionType.CREATE_RESTURANT_SUCCESS:
      return { ...state, loading: false, usersResturant: action.payload };

    case actionType.GET_ALL_RESTURANTS_SUCCESS:
      return { ...state, loading: false, resturants: action.payload };

    case actionType.GET_RESTURANT_BY_ID_SUCCESS:
      return { ...state, loading: false, resturant: action.payload };

    case actionType.GET_RESTURANT_BY_USER_ID_SUCCESS:
    case actionType.UPDATE_RESTURANT_STATUS_SUCCESS:
    case actionType.UPDATE_RESTURANT_SUCCESS:
      return { ...state, loading: false, usersResturant: action.payload };

    case actionType.DELETE_RESTURANT_SUCCESS:
      return {
        ...state,
        error: null,
        loading: false,
        resturants: state.resturants.filter(
          (item) => item.id !== action.payload
        ),
        usersResturant: state.usersResturant.filter(
          (item) => item.id !== action.payload
        ),
      };

    case actionType.CREATE_EVENTS_SUCCESS:
      return {
        ...state,
        loading: false,
        events: [...state.events, action.payload],
        resturantsEvents: [...state.resturantsEvents, action.payload],
      };

    case actionType.GET_ALL_EVENTS_SUCCESS:
      return { ...state, loading: false, events: action.payload };

    case actionType.GET_RESTURANTS_EVENTS_SUCCESS:
      return { ...state, loading: false, resturantsEvents: action.payload };

    case actionType.DELETE_EVENTS_SUCCESS:
      return {
        ...state,
        loading: false,
        events: state.events.filter((item) => item.id !== action.payload),
        resturantsEvents: state.resturantsEvents.filter(
          (item) => item.id !== action.payload
        ),
      };

    case actionType.CREATE_CATEGORY_SUCCESS:
      return {
        ...state,
        loading: false,
        categories: [...state.categories, action.payload],
      };

    case actionType.GET_RESTURANTS_CATEGORY_SUCCESS:
      return { ...state, loading: false, categories: action.payload };

    case actionType.CREATE_RESTURANT_FAILURE:
    case actionType.GET_ALL_RESTURANTS_FAILURE:
    case actionType.DELETE_RESTURANT_FAILURE:
    case actionType.UPDATE_RESTURANT_FAILURE:
    case actionType.GET_RESTURANT_BY_ID_FAILURE:
    case actionType.CREATE_EVENTS_FAILURE:
    case actionType.CREATE_CATEGORY_FAILURE:
    case actionType.GET_RESTURANTS_CATEGORY_FAILURE:
      return {
        ...state,
        loading: false,
        error: action.payload,
      };
    default:
      return state;
  }
};

export default resturantReducer;