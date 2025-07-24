import React, { useState } from 'react'
import { ProfileNavigation } from './ProfileNavigation'
import { Route, Routes } from 'react-router-dom';
import UserProfile from './UserProfile';
import Address from './Address';
import Favorites from './Favorites';
import { Events } from './Events';
import Payment from './Payment';
import Notification from './Notification';
import Orders from './Orders';

const Profile = () => {
    const [openSideBar, setOpenSideBar]=useState(false);
  return (
    <div className='lg:flex justify-between '>
        <div className='sticky h-[80vh] lg:w-[20%]'>

            {/* rendor profile Navigation */}
            <ProfileNavigation open={openSideBar}/>
        </div>

        <div className='lg:w-[80%]'>
          <Routes>

                {/* component */}
              <Route path='/' element={<UserProfile/>}/>
              <Route path='/orders' element={<Orders/>}/>
              <Route path='/address' element={<Address/>}/>
              <Route path='/favorites' element={<Favorites/>}/>
              {/* <Route path='/payment' element={<Payment/>}/>
              <Route path='/notification' element={<Notification/>}/> */}
              <Route path='/events' element={<Events/>}/>

             

          </Routes>
        </div>

    </div>
  )
}

export default Profile