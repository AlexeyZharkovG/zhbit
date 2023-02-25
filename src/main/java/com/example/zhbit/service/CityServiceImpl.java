package com.example.zhbit.service;

import com.example.zhbit.DTO.CityHousesDTO;
import com.example.zhbit.DTO.HousesApartmensDTO;
import com.example.zhbit.DTO.StreetHousesDTO;
import com.example.zhbit.Dao.Dao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private Dao daoImp;

    public CityServiceImpl(Dao daoImp) {
        this.daoImp = daoImp;
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
}
