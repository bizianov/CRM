package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.hotel.Hotel;
import project.model.hotel.HotelDao;
import project.model.hotel.Rate;

/**
 * Created by slava23 on 11/28/2016.
 */

@Service
public class HotelService {

    @Autowired
    private HotelDao hotelDao;

    public Hotel createHotel(String name, Rate rate, String country, String region){
        Hotel hotel = new Hotel(name, rate, country, region);
        hotelDao.save(hotel);
        return hotel;
    }


    public HotelDao getHotelDao() {
        return hotelDao;
    }

    public void setHotelDao(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }
}
