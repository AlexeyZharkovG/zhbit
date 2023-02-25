package com.example.zhbit.DTO;

import com.example.zhbit.entity.House;

import java.util.List;

public class CityHousesDTO {
    private String city;
    private Long houseCount;

    public CityHousesDTO() {
    }

    public CityHousesDTO(String city, Long houseCount) {
        this.city = city;
        this.houseCount = houseCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(Long houseCount) {
        this.houseCount = houseCount;
    }
}
