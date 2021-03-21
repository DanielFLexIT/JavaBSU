class Liner extends Series {

    Liner(double coefficient, double firstElement, int numOfElements){
        super(coefficient, firstElement, numOfElements);
    }

    public double getElement(int j) {
        return firstElement_ + (j - 1) * coefficient_;
    }

    @Override
    public double sum(int numOfElements_) {
        return ((2 * firstElement_ + coefficient_ * (numOfElements_ - 1)) / 2) * numOfElements_;
    }
}
