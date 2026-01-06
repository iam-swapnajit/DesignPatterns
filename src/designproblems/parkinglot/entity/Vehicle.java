package designproblems.parkinglot.entity;

import designproblems.parkinglot.common.VehicleSize;

public abstract class Vehicle {
    private String lisenseNumber;
    private VehicleSize vehicleSize;

    public Vehicle(String lisenseNumber, VehicleSize vehicleSize){
        this.lisenseNumber = lisenseNumber;
        this.vehicleSize = vehicleSize;
    }

}
