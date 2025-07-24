import { Card, Chip, IconButton } from '@mui/material'
import React from 'react'
import FavoriteIcon from '@mui/icons-material/Favorite';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import { useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { addToFavorite } from '../State/Authentication/Action';
import { isPresentInFavorites } from '../Config/logic';

const ResturantCard = ({item}) => {
    const navigate = useNavigate()
    const dispatch = useDispatch();
    const jwt = localStorage.getItem("jwt")

    const {auth} = useSelector(store=>store)

    const handleAddTofavorite = ()=>{
        dispatch(addToFavorite({resturantId:item.id, jwt}))
    } 

    const handleNavigateToResturant=()=>{
        if(item.open){
            navigate(`/resturant/${item.address.city}/${item.name}/${item.id}`)
        }
    }

  return (
    <Card className=' w-[18rem]  '>
        <div className= {`${true ? "cursor-pointer" : "cursor-not-allowed"} relative `}>
            <img className='w-full h-[10rem] rounded-t-md object-cover'
             src={item.images[1]} alt="restuarant-image" />
             <Chip
             size="small"
             className="absolute top-2 left-2 "
             color={item.open ? "success" : "error"}
             label={item.open ? "open" : "closed"}
             />
        </div>
        <div className="p-4 textPart lg:flex w-full justify-between">
            <div className="space-y-1 ">
                <p onClick={handleNavigateToResturant} className="font-semibold text-lg cursor-pointer">
                    {item.name}
                </p>
                <p className="text-gray-500 text-sm ">
                   {item.description}
                </p>
            </div>
            <div>
                <IconButton onClick={handleAddTofavorite}>
                    {isPresentInFavorites(auth.favorites, item) ? <FavoriteIcon className="text-red-500"/> : <FavoriteBorderIcon/>}
                </IconButton>
            </div>

        </div>

    </Card>
  )
}

export default ResturantCard