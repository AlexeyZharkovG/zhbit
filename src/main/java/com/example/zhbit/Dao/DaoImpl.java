package com.example.zhbit.Dao;

import com.example.zhbit.DTO.CityHousesDTO;
import com.example.zhbit.DTO.HousesApartmensDTO;
import com.example.zhbit.DTO.StreetHousesDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoImpl implements Dao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CityHousesDTO> readAllCityAndHouses() {
        return entityManager.createQuery("""
                        SELECT new com.example.zhbit.DTO.CityHousesDTO(
                        c.name,
                        count (h.id)
                        ) from City c join Street s ON c.id = s.city.id 
                        join House h ON s.id = h.street.id  
                        GROUP BY c.name""", CityHousesDTO.class)
                .getResultList();
    }

    @Override
    public List<StreetHousesDTO> readAllStreetAndHouses(Long city_id) {
        return entityManager.createQuery("""
                        SELECT new com.example.zhbit.DTO.StreetHousesDTO(
                        s.name,
                        count (h.id)
                        ) from City c join Street s ON c.id = s.city.id AND c.id = : id
                        join House h ON s.id = h.street.id  
                        GROUP BY s.name""", StreetHousesDTO.class).setParameter("id", city_id)
                .getResultList();
    }

    @Override
    public List<HousesApartmensDTO> readAllHousesAndApartmentsByCityId(Long city_id) {
        return entityManager.createQuery("""
                        SELECT new com.example.zhbit.DTO.HousesApartmensDTO(
                        h.number,
                        CONCAT(c.name, ", ", s.name, " ", h.number),
                        count (a.id)
                        ) from City c join Street s ON c.id = s.city.id AND c.id = : id
                        join House h ON s.id = h.street.id  
                        join Apartment a ON h.id = a.house.id 
                        GROUP BY h.number, c.name, s.name""", HousesApartmensDTO.class).setParameter("id", city_id)
                .getResultList();
    }

    @Override
    public List<HousesApartmensDTO> readAllHousesAndApartmentsByStreetId(Long street_id) {
        return entityManager.createQuery("""
                        SELECT new com.example.zhbit.DTO.HousesApartmensDTO(
                        h.number,
                        CONCAT(c.name, ", ", s.name, " ", h.number),
                        count (a.id)
                        ) from City c join Street s ON c.id = s.city.id AND s.id = : id
                        join House h ON s.id = h.street.id  
                        join Apartment a ON h.id = a.house.id 
                        GROUP BY h.number, c.name, s.name""", HousesApartmensDTO.class).setParameter("id", street_id)
                .getResultList();
    }
}
