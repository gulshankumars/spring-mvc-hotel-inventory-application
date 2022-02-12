package com.sunglowsys.service;

import com.sunglowsys.domain.HotelInventory;
import com.sunglowsys.repository.HotelInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelInventoryServiceImpl implements HotelInventoryService{

    @Autowired
    private HotelInventoryRepository hotelInventoryRepository;

    @Override
    public HotelInventory create(HotelInventory hotelInventory) {
        return hotelInventoryRepository.save(hotelInventory);
    }

    @Override
    public HotelInventory update(HotelInventory hotelInventory, Integer id) {
        HotelInventory hotelInventory1 = hotelInventoryRepository.findById(id).get();
        hotelInventory1.setTotalInventory(hotelInventory1.getTotalInventory());
        hotelInventory1.setHotelId(hotelInventory1.getHotelId());
        hotelInventory1.setRoomTypeId(hotelInventory1.getRoomTypeId());
        return hotelInventoryRepository.save(hotelInventory);
    }

    @Override
    public List<HotelInventory> findAll() {
        return hotelInventoryRepository.findAll();
    }

    @Override
    public HotelInventory findById(Integer id) {
        Optional<HotelInventory> optional = hotelInventoryRepository.findById(id);
        HotelInventory hotelInventory = null;
        if (optional.isPresent()){
            hotelInventory = optional.get();
        }
        else {
            throw new RuntimeException("Hotel-Inventory not found for id:" +id);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        hotelInventoryRepository.deleteById(id);
    }
}
