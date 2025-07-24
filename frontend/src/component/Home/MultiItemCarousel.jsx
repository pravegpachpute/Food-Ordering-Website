import React from 'react'
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import Slider from 'react-slick';
import { TopMeels } from './topMeel';
import CarouselItems from './CarouselItems';

function MultiItemCarousel() {
    const settings = {
        dots: true,
        infinite: true,
        speed: 500,
        slidesToShow: 5,
        slidesToScroll: 1,
        autoplay:true,
        autoplaySpeed:2000,
        arrows:false

      };
  return (
    <div>
        <Slider{...settings}>
            {TopMeels.map((item) =>
             <CarouselItems image={item.image} title={item.title} />
             )}
        </Slider>
    </div>
  )
}

export default MultiItemCarousel