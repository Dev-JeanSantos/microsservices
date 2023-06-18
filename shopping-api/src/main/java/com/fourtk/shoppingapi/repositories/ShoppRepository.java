package com.fourtk.shoppingapi.repositories;

import com.fourtk.shoppingapi.entities.Shopp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShoppRepository extends JpaRepository<Shopp, Long> {

    List<Shopp> findAllByUserIdentifier(String userIdentify);

//    List<Shopp> findAllByDatePuchaseGreaterThanEquals(LocalDate date);
}
