package TotalPacket.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Car {
    public final static int MAX_PASSENGERS = 70;
    public final static int MAX_COMFORT_LEVEL = 10;
    public final static int MIN_COMFORT_LEVEL = 1;

    private int comfortLevel;
    private final List<Passenger> passengers;

    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers);
    }

    public Car(int comfortLevel, List<Passenger> passengers) {
        setComfortLevel(comfortLevel);
        this.passengers = passengers;
    }

    public Car(int comfortLevel){
        this(comfortLevel, new ArrayList<>());
    }

    public void setComfortLevel(int comfortLevel) {
        if (comfortLevel < MIN_COMFORT_LEVEL || comfortLevel > MAX_COMFORT_LEVEL){
            throw new IllegalArgumentException("Illegal comfort level");
        }
        this.comfortLevel = comfortLevel;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }

    public void addPassenger(Passenger passenger){
        if(passengers.size() >= MAX_PASSENGERS){
            throw new IllegalArgumentException("Wagon is full");
        }
        passengers.add(passenger);
    }

    public void addPassengers(List<Passenger> passengers){
        if(this.passengers.size() + passengers.size() >= MAX_PASSENGERS){
            throw new IllegalArgumentException("Not enough seats for " + passengers.size() +
                    " passengers. " + "Only has " + (MAX_PASSENGERS - this.passengers.size()));
        }
        this.passengers.addAll(passengers);
    }

    public boolean deletePassenger(Passenger passenger){
        return passengers.remove(passenger);
    }

    public boolean deletePassengers(List<Passenger> passengers){
        return this.passengers.removeAll(passengers);
    }

    @Override
    public String toString() {
        return "Car\n" +
                "comfortLevel=" + comfortLevel + "\n" +
                " passengers= " + passengers + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return comfortLevel == car.comfortLevel && Objects.equals(passengers, car.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comfortLevel, passengers);
    }
}
