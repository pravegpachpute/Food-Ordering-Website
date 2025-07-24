import React, { useEffect } from "react";
import { AdminSideBar } from "./AdminSideBar";
import { Route, Routes } from "react-router-dom";
import { Orders } from "../Orders/Orders";
import { Menu } from "../Menu/Menu";
import { FoodCategory } from "../FoodCategory/FoodCategory";
import { Ingredients } from "../Ingredients/Ingredients";
import { Events } from "../Events/Events";
import { ResturantDetails } from "../Admin/ResturantDetails";
import { ResturantDashBoard } from "../DashBoard/ResturantDashBoard";
import CreateMenuForm from "../Menu/CreateMenuForm";
import { useDispatch, useSelector } from "react-redux";
import {
  getResturantById,
  getResturantsCategory,
} from "../../component/State/Resturant/Action";
import { getMenuItemsByResturantId } from "../../component/State/Menu/Action";
import { fetchResturantsOrder } from "../../component/State/Resturant Order/Action";

export const Admin = () => {
  const dispatch = useDispatch();
  const jwt = localStorage.getItem("jwt");
  const { resturant } = useSelector((store) => store);

  const handleClose = () => {};

  useEffect(() => {
    dispatch(
      getResturantsCategory({ jwt, resturantId: resturant.usersResturant?.id })
    );
    dispatch(
      fetchResturantsOrder({ jwt, resturantId: resturant.usersResturant?.id })
    );
  }, []);

  console.log("resturant details", resturant);

  return (
    <div>
      <div className="lg:flex justify-between">
        <div>
          <AdminSideBar handleClose={handleClose} />
        </div>

        <div className="lg:w-[80%]">
          <Routes>
            <Route path="/" element={<ResturantDashBoard />} />
            <Route path="/orders" element={<Orders />} />
            <Route path="/menu" element={<Menu />} />
            <Route path="/category" element={<FoodCategory />} />
            <Route path="/ingredients" element={<Ingredients />} />
            <Route path="/event" element={<Events />} />
            <Route path="/details" element={<ResturantDetails />} />
            <Route path="/add-menu" element={<CreateMenuForm />} />
          </Routes>
        </div>
      </div>
    </div>
  );
};
