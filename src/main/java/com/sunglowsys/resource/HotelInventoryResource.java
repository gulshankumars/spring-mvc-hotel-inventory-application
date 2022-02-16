package com.sunglowsys.resource;

import com.sunglowsys.domain.HotelInventory;
import com.sunglowsys.resource.util.BadRequestException;
import com.sunglowsys.service.HotelInventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HotelInventoryResource {

    private final Logger log = LoggerFactory.getLogger(HotelInventoryResource.class);

    private  final HotelInventoryService hotelInventoryService;

    public HotelInventoryResource(HotelInventoryService hotelInventoryService) {
        this.hotelInventoryService = hotelInventoryService;
    }

    @PostMapping("/hotel-inventory")
    public ResponseEntity<HotelInventory> createHotelInventory(@RequestBody HotelInventory hotelInventory) throws URISyntaxException {
        log.debug("REST request to save HotelInventory : {}",hotelInventory);
        if (hotelInventory.getId() != null){
            throw new BadRequestException("Id should be null in create api call");
        }
        HotelInventory result = hotelInventoryService.create(hotelInventory);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/hotel-inventory")
    public ResponseEntity<List<HotelInventory>> getAllHotelInventory(@RequestBody Pageable pageable){
        log.debug("REST request to getAll HotelInventory : {}", pageable.toString());
        Page<HotelInventory> result = hotelInventoryService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(result.getContent());
    }

    @GetMapping("hotel-inventory/{id}")
    public ResponseEntity<HotelInventory> getHotelInventory(@PathVariable("id") Long id){
        log.debug("REST request to get HotelInventory : {}", id);
        Optional<HotelInventory> result = hotelInventoryService.findById(id);
        return ResponseEntity
                .ok()
                .body(result.get());
    }

    @PutMapping("/hotel-inventory/{id}")
    public ResponseEntity<HotelInventory> updateHotelInventory(@RequestBody HotelInventory hotelInventory) throws URISyntaxException{
        log.debug("REST request to update HotelInventory : {}", hotelInventory);
        if (hotelInventory.getId() == null){
            throw new BadRequestException("Id should not be null for update api");
        }
        HotelInventory result = hotelInventoryService.update(hotelInventory);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @DeleteMapping("hotel-inventory/{id}")
    public ResponseEntity<Void> deleteHotelInventory(@PathVariable Long id){
        log.debug("REST request to delete HotelInventory : {}",id);
        hotelInventoryService.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }
}
