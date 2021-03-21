package TotalPacket.models.strategies.sort;

import TotalPacket.models.Car;

import java.util.List;
import java.util.stream.Collectors;

public class DescendingComfortLevelStrategy implements Sort{
    @Override
    public List<Car> sort(List<Car> cars) {
        return cars.stream().sorted(((o1, o2) -> Integer.compare(o2.getComfortLevel(), o1.getComfortLevel()))).collect(Collectors.toList());
    }
}
