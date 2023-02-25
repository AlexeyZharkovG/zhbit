package com.example.zhbit.DTO;

public class StreetHousesDTO {
    private String street;
    private Long houseCount;

    public StreetHousesDTO() {
    }

    public StreetHousesDTO(String street, Long houseCount) {
        this.street = street;
        this.houseCount = houseCount;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(Long houseCount) {
        this.houseCount = houseCount;
    }
}
