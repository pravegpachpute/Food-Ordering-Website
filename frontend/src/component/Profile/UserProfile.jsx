import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import { Button } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { logout, getUser } from '../State/Authentication/Action';
import React, { useEffect } from "react";


const UserProfile = () => {
  const dispatch = useDispatch();
  const jwt = localStorage.getItem("jwt");
  const { resturant , auth } = useSelector(
    (store) => store
  );
  const navigate = useNavigate();


  const handleNavigate = (item) => {
    if (item.title === "Logout") {
      dispatch(logout());
      navigate("/");
    } else {
      navigate(`/my-profile/${item.title.toLowerCase()}`);
    }
  };

  useEffect(() => {
    dispatch(
      getUser(jwt))
      },[auth.jwt])

  // Define the item object for the logout action
  const logoutItem = { title: "Logout" };

  return (
    <div className='min-h-[80vh] flex flex-col justify-center items-center text-center'>
      <div className='flex flex-col items-center justify-center'>
        <AccountCircleIcon sx={{ fontSize: "9rem" }} />
        <h1 className='py-5 text-2xl font-semibold'>{auth.user?.fullName}</h1>
        <p>{auth.user?.email}</p>
        <Button 
          variant='contained' 
          onClick={() => handleNavigate(logoutItem)} 
          sx={{ margin: "2rem 0rem" }}
        >
          Logout
        </Button>
      </div>
    </div>
  );
};

export default UserProfile;