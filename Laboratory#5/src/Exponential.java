class Exponential extends Series{
    Exponential(double coefficient, double firstElement, int numOfElements){
        super(coefficient, firstElement, numOfElements);
    }

    public double getElement(int j) {
        return firstElement_ * (double) Math.pow((double) coefficient_, (double) j - 1);
    }

    @Override
    public double sum(int numOfElements_){
        double ratio = 1 - (double) Math.pow((double) coefficient_, (double) numOfElements_);
        return (ratio * firstElement_) / (1 - coefficient_);
    }
}
