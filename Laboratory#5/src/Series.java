import java.io.FileWriter;
import java.io.IOException;


abstract class Series {
    protected double coefficient_;
    protected double firstElement_;
    protected int numOfElements_;

    public abstract double getElement(int j);

    public Series(double coefficient, double firstElement, int numOfElements) {
        coefficient_ = coefficient;
        firstElement_ = firstElement;
        numOfElements_ = numOfElements;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Your series up to");
        for (int i = 1; i <= numOfElements_; ++i) {
            string.append(" ").append(getElement(i)).append(",");
        }
        return string.toString();
    }

    public double sum(int numOfElements_) {
        double sum = 0;
        for (int i = 1; i < numOfElements_; ++i) {
            sum += getElement(i);
        }
        return sum;
    }

    public void saveToFile(String name, int numOfElements_) throws IOException {
            FileWriter writer = new FileWriter(name, false);
            writer.write(this.toString());
            writer.append('\n');
            writer.write(Double.toString(this.sum(numOfElements_)));
            writer.flush();
            writer.close();
    }
}