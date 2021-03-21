package TotalPacket.models.strategies.count;

import TotalPacket.models.Car;
import TotalPacket.models.Passenger;

import java.util.List;

public class CountBaggages implements Count {
    @Override
    public int count(List<Car> cars) {
        int baggageWeights = 0;
        for (Car car : cars){
            for(Passenger passenger : car.getPassengers()){
                baggageWeights += passenger.getBaggageWeight();
            }
        }
        return baggageWeights;
    }
}
