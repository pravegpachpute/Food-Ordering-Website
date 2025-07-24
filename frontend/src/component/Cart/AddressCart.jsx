import React from 'react'
import HomeIcon from '@mui/icons-material/Home';
import { Button, Card } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';

const AddressCart = ({item, showButton, handleSelectAddress}) => {
  const navigate = useNavigate()
  const dispatch = useDispatch();
  const jwt = localStorage.getItem("jwt")

  const {auth} = useSelector(store=>store)
 
  return (
    // rout for cart short box type
    <Card className="flex gap-5 w-64 p-5 ">
        <HomeIcon/>
        <div className='space-y-3 text-gray-500 '>
            <h1 className='font-semibold text-lg text-white'>Home</h1>
            <p>
                Bhairavnath chauk , kashti, shrighonda, A-nagar 414701, maharastra, India
            </p>
            {/* hide button in addesss page */}
           {showButton && (
             <Button variant='outlined' fullWidth onClick={()=> handleSelectAddress(item)}>Select</Button>)}

        </div>
    </Card>
  )
}

export default AddressCart