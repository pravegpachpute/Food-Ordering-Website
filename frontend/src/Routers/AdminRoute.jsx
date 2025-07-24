import React from "react";
import { Route, Routes } from "react-router-dom";
import CreateResturantForm from "../AdminComponent/CreateResturantForm/CreateResturantForm";
import { Admin } from "../AdminComponent/Admin/Admin";
import { useSelector } from "react-redux";

export const AdminRoute = () => {
  const { resturant } = useSelector((store) => store);

  return (
    <div>
      <Routes>
        <Route
          path='/*'
          element={
            !resturant.usersResturant ? <CreateResturantForm /> : <Admin />
          }
        ></Route>
      </Routes>
    </div>
  );
};
