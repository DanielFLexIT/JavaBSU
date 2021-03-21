package TotalPacket.models;

import java.util.Objects;

public class Passenger {
    public final static int MIN_AGE = 0;
    public final static int MAX_AGE = 100;
    public final static int MAX_BAGGAGE_WEIGHT = 50;

    private int age;
    private int baggageWeight;
    private String name;

    public Passenger(int age, String name) {
        this.age = age;
        this.baggageWeight = 0;
        this.name = name;
    }

    public Passenger(int age, int baggageWeight, String name){
        setAge(age);
        setBaggageWeight(baggageWeight);
        setName(name);
    }

    public int setAge(int age) {
        if (age < MIN_AGE || age > MAX_AGE){
            throw new IllegalArgumentException("Illegal age");
        }
        return age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null){
            throw new IllegalArgumentException("Empty name");
        }
        this.name = name;
    }

    public int getBaggageWeight() {
        return baggageWeight;
    }

    public void setBaggageWeight(int baggageWeight) {
        if (baggageWeight < 0 || baggageWeight > MAX_BAGGAGE_WEIGHT){
            throw new IllegalArgumentException("Illegal weight");
        }
        this.baggageWeight = baggageWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passanger = (Passenger) o;
        return age == passanger.age &&
                baggageWeight == passanger.baggageWeight &&
                Objects.equals(name, passanger.name);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "age=" + age +
                ", baggageWeight=" + baggageWeight +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, baggageWeight, name);
    }
}
