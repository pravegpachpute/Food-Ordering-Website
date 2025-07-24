import "./App.css";
import Navbar from "./component/Navbar/Navbar";
import { CssBaseline, ThemeProvider } from "@mui/material";
import { darkTheme } from "./Theme/DarkTheme";
import Home from "./component/Home/Home";
import RestuarantDetails from "./component/Resturant/RestuarantDetails";
import Cart from "./component/Cart/Cart";
import Profile from "./component/Profile/Profile";
import { CustomerRoute } from "./Routers/CustomerRoute";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getUser } from "./component/State/Authentication/Action";
import { findCart } from "./component/State/Cart/Action";
import Routers from "./Routers/Routers";
import { getResturantByUserId } from "./component/State/Resturant/Action";

function App() {
  const dispatch = useDispatch();

  const jwt = localStorage.getItem("jwt");

  const { auth } = useSelector((store) => store);

  useEffect(() => {
    dispatch(getResturantByUserId(auth.jwt || jwt));
  }, [auth.user]);

  useEffect(() => {
    dispatch(getUser(auth.jwt || jwt));
    dispatch(findCart(jwt));
  }, [auth.jwt]);

  return (
    <ThemeProvider theme={darkTheme}>
      <CssBaseline />
      {/* <Navbar/> */}
      {/* <Home/> */}
      {/* <RestuarantDetails/> */}
      {/* <Cart/> */}
      {/* <Profile/> */}
      {/* <CustomerRoute /> */}
      <Routers />
    </ThemeProvider>
  );
}

export default App;
