package com.sunglowsys.resource;

import com.sunglowsys.domain.HotelInventory;
import com.sunglowsys.service.HotelInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelInventoryResource {

    @Autowired
    private HotelInventoryService hotelInventoryService;

    @PostMapping("/hotel_inventory")
    public ResponseEntity<?> create(@RequestBody HotelInventory hotelInventory){
        HotelInventory result = hotelInventoryService.create(hotelInventory);
        return ResponseEntity.ok().body(" HotelInventory is created successfully: " + result);
    }

    @GetMapping
    public List<HotelInventory> getAll(){
        List<HotelInventory> result1 = hotelInventoryService.findAll();
        return result1;
    }

    @GetMapping("find_hotel_inventory/{id}")
    public HotelInventory getById(@PathVariable("id") Integer id){
        return hotelInventoryService.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody HotelInventory hotelInventory, @PathVariable("id") Integer id){
        hotelInventoryService.update(hotelInventory, id);
        return ResponseEntity.ok().body(" HotelInventory is updated successfully: " + id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        hotelInventoryService.delete(id);
        return ResponseEntity.ok().body(" HotelInventory is successfully Deleted on this ID: " + id);
    }
}
