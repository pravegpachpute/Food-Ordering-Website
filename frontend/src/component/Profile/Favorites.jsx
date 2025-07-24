import React from 'react'
import ResturantCard from '../Resturant/ResturantCard'
import { useSelector } from 'react-redux'

export default function Favorites() {
  const {auth} = useSelector(store=>store)
  return (
    <div>
      <h1 className='py-5 text-2xl font-semibold text-center'>My Favorites</h1>

      {/* all resturant here */}

      <div className='flex flex-wrap gap-3 justify-center'>
        {auth.favorites.map((item)=> <ResturantCard item={item}/>)}
      </div>
    </div>
  )
}
