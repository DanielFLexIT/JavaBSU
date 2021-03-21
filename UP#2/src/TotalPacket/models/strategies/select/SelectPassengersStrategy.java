package TotalPacket.models.strategies.select;

import TotalPacket.models.Car;

import java.util.List;
import java.util.stream.Collectors;

public class SelectPassengersStrategy implements Select {
    private int minPassengerCount;
    private int maxPassengerCount;

    public SelectPassengersStrategy(int minPassengerCount, int maxPassengerCount) {
        this.minPassengerCount = Math.min(minPassengerCount,maxPassengerCount);
        this.maxPassengerCount = Math.max(minPassengerCount,maxPassengerCount);
    }

    @Override
    public List<Car> select(List<Car> cars) {
        return cars.stream().filter(car -> {
            int passengersCount = car.getPassengers().size();
            return passengersCount >= minPassengerCount && passengersCount <= maxPassengerCount;
        }).collect(Collectors.toList());
    }
}
