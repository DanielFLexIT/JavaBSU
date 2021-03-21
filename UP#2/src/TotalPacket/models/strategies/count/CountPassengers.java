package TotalPacket.models.strategies.count;

import TotalPacket.models.Car;

import java.util.List;

public class CountPassengers implements Count {
    @Override
    public int count(List<Car> cars) {
        int passengers = 0;
        for (Car car: cars){
            passengers += car.getPassengers().size();
        }
        return passengers;
    }
}
