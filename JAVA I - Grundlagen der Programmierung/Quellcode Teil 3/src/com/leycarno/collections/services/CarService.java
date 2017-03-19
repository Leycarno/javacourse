package com.leycarno.collections.services;

import com.leycarno.collections.models.Car;

public class CarService {

    /**
     * refuel the car (max to maxFuel)
     *
     * @param car
     * @param fuel
     * @return amount of fuel you have not filled into the car
     */
    public float refuel(Car car, float fuel) {
        float max = car.getFuelMax() - car.getFuel();
        if (max >= fuel) {
            car.setFuel(car.getFuel() + fuel);
            return 0;
        } else {
            car.setFuel(car.getFuelMax());
            return fuel - max;
        }
    }

    /**
     * use fuel if you can
     *
     * @param car
     * @param fuel
     * @return used?
     */
    public boolean useFuel(Car car, float fuel) {
        if (car.getFuel() < fuel) return false;
        car.setFuel(car.getFuel() - fuel);
        return true;
    }
}
