package com.example.zhbit.controller;

import com.example.zhbit.DTO.CityHousesDTO;
import com.example.zhbit.DTO.HousesApartmensDTO;
import com.example.zhbit.DTO.StreetHousesDTO;
import com.example.zhbit.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("")
public class CityRestController {

    private final CityService cityService;

    public CityRestController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public ResponseEntity<List<CityHousesDTO>> getCitiesAndHouses() {

        final List<CityHousesDTO> cities = cityService.readAllCityAndHouses();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/streets")
    public ResponseEntity<List<StreetHousesDTO>> getStreetsAndHouses(@RequestParam Long city_id) {

        final List<StreetHousesDTO> cities = cityService.readAllStreetAndHouses(city_id);
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/houses")
    public ResponseEntity<List<HousesApartmensDTO>> getHousesAndApartments(
            @RequestParam(name="city_id", defaultValue = "0") Long city_id,
            @RequestParam(name="street_id", defaultValue = "0") Long street_id) {

        if (city_id > 0 && street_id == 0 || city_id == 0 && street_id > 0) {
            final List<HousesApartmensDTO> cities = cityService.readAllHousesAndApartments(city_id, street_id);
            return new ResponseEntity<>(cities, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body(Collections.emptyList());
    }

    @GetMapping("/address/{address}")
    public String getHouseIdByAddress(@PathVariable String address) {
        Long houseId = cityService.getHouseIdByAddress(address);

        return (houseId == 0) ? "Адрес отсутсвует в БД" : houseId.toString();
    }
}
