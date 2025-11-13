package com.hotel.model.entities;

import com.hotel.model.enums.RoomStatus;

public class Room {
    private int id;
    private String roomNumber;
    private String type;
    private double pricePerNight;
    private int capacity;
    private String description;
    private RoomStatus status;

    // Default constructor
    public Room() {
        this.status = RoomStatus.AVAILABLE;
    }

    // Constructor for creating new room
    public Room(String roomNumber, String type, double pricePerNight, int capacity, String description) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
        this.description = description;
        this.status = RoomStatus.AVAILABLE;
    }

    // Constructor for existing room from database
    public Room(int id, String roomNumber, String type, double pricePerNight, int capacity, String description, RoomStatus status) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
        this.description = description;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public boolean isAvailable() {
        return status == RoomStatus.AVAILABLE;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", type='" + type + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", capacity=" + capacity +
                ", status=" + status +
                '}';
    }
}