package com.sunglowsys.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "hotel_inventory")
public class HotelInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id ;

    @NotNull
    private Integer totalInventory ;

    @NotNull
    private Integer hotelId ;

    @NotNull
    private Integer roomTypeId ;


    public HotelInventory(){
        System.out.println("HotelInventory object is created :");
    }

    public HotelInventory(Integer id, Integer totalInventory, Integer hotelId, Integer roomTypeId) {
        this.id = id;
        this.totalInventory = totalInventory;
        this.hotelId = hotelId;
        this.roomTypeId = roomTypeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(Integer totalInventory) {
        this.totalInventory = totalInventory;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelInventory that = (HotelInventory) o;
        return Objects.equals(id, that.id) && Objects.equals(totalInventory, that.totalInventory) && Objects.equals(hotelId, that.hotelId) && Objects.equals(roomTypeId, that.roomTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalInventory, hotelId, roomTypeId);
    }

    @Override
    public String toString() {
        return "HotelInventory{" +
                "id=" + id +
                ", totalInventory=" + totalInventory +
                ", hotelId=" + hotelId +
                ", roomTypeId=" + roomTypeId +
                '}';
    }
}
