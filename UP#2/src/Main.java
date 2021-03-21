import TotalPacket.models.Car;
import TotalPacket.models.Passenger;
import TotalPacket.models.Train;

import TotalPacket.models.strategies.count.CountPassengers;
import TotalPacket.models.strategies.select.SelectPassengersStrategy;
import TotalPacket.models.strategies.sort.DescendingComfortLevelStrategy;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Passenger Daniel = new Passenger(19, 10, "Daniel");
        Passenger Ivan = new Passenger(29, 39, "Ivan");
        Passenger Maria = new Passenger(67, 5, "Maria");

        Passenger Kirill = new Passenger(10, 1, "Kirill");
        Passenger Katerina = new Passenger(34, 20, "Katerina");
        Passenger Olga = new Passenger(55, 14, "Olga");

        List<Passenger> firstCarPassengers = Arrays.asList(Daniel, Ivan, Maria);
        List<Passenger> secondCarPassengers = Arrays.asList(Kirill, Katerina, Olga);

        Car firstCar = new Car(4, firstCarPassengers);
        Car secondCar = new Car(8, secondCarPassengers);

        List<Car> trainCars = Arrays.asList(firstCar,secondCar);

        Train train = new Train(trainCars,
                new CountPassengers(),
                new SelectPassengersStrategy(2,5),
                new DescendingComfortLevelStrategy());

        System.out.println(train.executeCountStrategy());
        train.executeCountStrategy();
        train.executeSortStrategy();
        System.out.println(train.getCars());
        List<Car> selectedCars = train.executeSelectStrategy();
        System.out.println(selectedCars);
    }
}
