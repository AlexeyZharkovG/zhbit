package com.example.zhbit.Dao;

import com.example.zhbit.DTO.CityHousesDTO;
import com.example.zhbit.DTO.HousesApartmensDTO;
import com.example.zhbit.DTO.StreetHousesDTO;

import java.util.List;

public interface Dao {
    List<CityHousesDTO> readAllCityAndHouses();

    List<StreetHousesDTO> readAllStreetAndHouses(Long city_id);

    List<HousesApartmensDTO> readAllHousesAndApartmentsByCityId (Long city_id);

    List<HousesApartmensDTO> readAllHousesAndApartmentsByStreetId (Long street_id);
}
