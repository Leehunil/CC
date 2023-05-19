package com.union_hackathon.CC.domain.food.domain.repository;

import com.union_hackathon.CC.domain.food.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {

    @Query(value = "SELECT * FROM Food order by RAND() limit 1", nativeQuery = true)
    Optional<Food> findRandomFood();
}
