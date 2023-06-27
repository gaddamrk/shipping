package com.instana.robotshop.shipping;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends CrudRepository<City, Long> {
    List<City> findByCode(String code);

    @Query(
        value = "select ci from City ci where ci.code = ?1 and ci.city like ?2%"
    )
    List<City> match(String code, String text);

    City findById(long id);
}
