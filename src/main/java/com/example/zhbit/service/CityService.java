package com.example.zhbit.service;

import com.example.zhbit.DTO.CityHousesDTO;
import com.example.zhbit.DTO.HousesApartmensDTO;
import com.example.zhbit.DTO.StreetHousesDTO;
import java.util.List;

public interface CityService {

    List<CityHousesDTO> readAllCityAndHouses();

    List<StreetHousesDTO> readAllStreetAndHouses(Long city_id);

    List<HousesApartmensDTO> readAllHousesAndApartments (Long city_id, Long street_id);

}
