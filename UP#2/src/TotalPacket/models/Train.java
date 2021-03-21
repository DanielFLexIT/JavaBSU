package TotalPacket.models;

import TotalPacket.models.strategies.count.Count;
import TotalPacket.models.strategies.select.Select;
import TotalPacket.models.strategies.sort.Sort;

import java.util.Collections;
import java.util.List;

public class Train {
    private List<Car> cars;
    private Count countStrategy;
    private Select selectStrategy;
    private Sort sortStrategy;

    public Train(List<Car> cars, Count countStrategy, Select selectStrategy, Sort sortStrategy) {
        this.cars = cars;
        this.countStrategy = countStrategy;
        this.selectStrategy = selectStrategy;
        this.sortStrategy = sortStrategy;
    }

    public void setCountStrategy(Count countStrategy) {
        this.countStrategy = countStrategy;
    }

    public void setSelectStrategy(Select selectStrategy) {
        this.selectStrategy = selectStrategy;
    }

    public void setSortStrategy(Sort sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int executeCountStrategy(){
        return countStrategy.count(cars);
    }

    public List<Car> executeSelectStrategy(){
        return selectStrategy.select(cars);
    }

    public void executeSortStrategy(){
        this.cars = sortStrategy.sort(cars);
    }


}
