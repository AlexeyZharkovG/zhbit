package com.example.zhbit.service;

import com.example.zhbit.DTO.CityHousesDTO;
import com.example.zhbit.DTO.HousesApartmensDTO;
import com.example.zhbit.DTO.StreetHousesDTO;
import com.example.zhbit.Dao.Dao;
import com.example.zhbit.entity.City;
import com.example.zhbit.entity.House;
import com.example.zhbit.entity.Street;
import com.example.zhbit.repository.CityRepository;
import com.example.zhbit.repository.StreetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private Dao daoImp;

    private CityRepository cityRepository;
    private StreetRepository streetRepository;

    public CityServiceImpl(Dao daoImp, CityRepository cityRepository, StreetRepository streetRepository) {
        this.daoImp = daoImp;
        this.cityRepository = cityRepository;
        this.streetRepository = streetRepository;
    }

    @Override
    public List<CityHousesDTO> readAllCityAndHouses() {
        return daoImp.readAllCityAndHouses();
    }

    @Override
    public List<StreetHousesDTO> readAllStreetAndHouses(Long city_id) {
        return daoImp.readAllStreetAndHouses(city_id);
    }

    @Override
    public List<HousesApartmensDTO> readAllHousesAndApartments(Long city_id, Long street_id) {
        if (city_id != 0) {
            return daoImp.readAllHousesAndApartmentsByCityId(city_id);
        } else {
            return daoImp.readAllHousesAndApartmentsByStreetId(street_id);
        }
    }

    @Override
    public Long getHouseIdByAddress(String address) {
        Integer cityId = 0;
        Integer streetId = 0;
        Integer houseId = 0;

        for (City city : cityRepository.findAll()) {
            if(address.contains(city.getName())) {
                cityId = city.getId();
            }
        }
        if (cityId == 0) {
            return 0L;
        }

        for (Street street : cityRepository.getReferenceById(cityId).getStreets()) {
            if (address.contains(street.getName())) {
                streetId = street.getId();
            }
        }
        if (streetId == 0) {
            return 0L;
        }

        for (House house : streetRepository.getReferenceById(streetId).getHouses()) {
            if (address.contains(house.getNumber())) {
                houseId = house.getId();
            }
        }
        return (houseId == 0) ? 0L : houseId;
    }
}
