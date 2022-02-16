package com.sunglowsys.repository;

import com.sunglowsys.domain.HotelInventory;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelInventoryRepository extends JpaRepository<HotelInventory, Long> {

}