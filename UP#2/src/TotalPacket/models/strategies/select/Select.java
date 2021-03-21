package TotalPacket.models.strategies.select;

import TotalPacket.models.Car;

import java.util.List;

public interface Select {
    public List<Car> select(List<Car> cars);
}
