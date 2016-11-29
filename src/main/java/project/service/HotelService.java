package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.hotel.Hotel;
import project.model.hotel.HotelDao;
import project.model.hotel.Rate;

import java.util.List;

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

    public Hotel findHotelById(int id){
        return hotelDao.findOne(id);
    }

    public Hotel findHotelByName(String name){
        return hotelDao.findByName(name);
    }

    public List<Hotel> findHotelsByCountry(String country){
        return hotelDao.findByCountry(country);
    }

    public List<Hotel> findHotelsByRegion(String region){
        return hotelDao.findByRegion(region);
    }

    public Hotel saveHotel(Hotel hotel){
        return hotelDao.save(hotel);
    }

    public Hotel deleteHotel(int id){
        Hotel hotelById = findHotelById(id);
        if (hotelById != null){
            hotelDao.delete(hotelById);
        }
        return hotelById;
    }

    public HotelDao getHotelDao() {
        return hotelDao;
    }

    public void setHotelDao(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }
}
