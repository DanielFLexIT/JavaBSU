public class Application {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new IndexOutOfBoundsException("Too many arguments");
            }
            double variable = Double.parseDouble(args[0]);
            double eps = Double.parseDouble(args[1]);

            if (eps < 0) {
                throw new NumberFormatException("Accuracy is less than 0");
            }

            double sumOfRow = rowCalculate(variable, eps);
            System.out.println(sumOfRow);


        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
    private static double rowCalculate(double variable, double eps) {
        int step = 1;
        double sum = 0;
        double currentItem = firstItemCalculate(variable);
        double nextItem = nextItemCalculate(currentItem, variable, step);
        sum += currentItem;
        while(Math.abs(Math.abs(nextItem) - Math.abs(currentItem)) > eps){
            sum += nextItem;
            currentItem = nextItem;
            ++step;
            nextItem = nextItemCalculate(currentItem,variable, step);
        }
        return sum;
    }
    private static double firstItemCalculate(double variable){
        return Math.pow(variable, 2) / 2;
    }
    private static double nextItemCalculate(double previousItem, double variable,int step){
        return (previousItem * (Math.pow(variable, 2))/(2*(step+1)));
    }
}
