package com.example.zhbit.DTO;

public class HousesApartmensDTO {
    private String house;
    private String address;
    private Long apartmentCount;

    public HousesApartmensDTO() {
    }

    public HousesApartmensDTO(String house, String address, Long apartmentCount) {
        this.house = house;
        this.address = address;
        this.apartmentCount = apartmentCount;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getApartmentCount() {
        return apartmentCount;
    }

    public void setApartmentCount(Long apartmentCount) {
        this.apartmentCount = apartmentCount;
    }
}
