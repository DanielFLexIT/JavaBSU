package TotalPacket.models.strategies.sort;

import TotalPacket.models.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AscendingComfortLevelStrategy implements Sort{
    @Override
    public List<Car> sort(List<Car> cars) {
        return cars.stream().sorted(Comparator.comparingInt(Car::getComfortLevel)).collect(Collectors.toList());
    }
}
