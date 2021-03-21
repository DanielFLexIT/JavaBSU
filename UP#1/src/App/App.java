package App;

public class App {
    public static void main(String[] args) {
        Number zero = new Number(0);
        Number one = new Number(1);
        Number minus_one = new Number(-1);
        Number minus_two = new Number(-2);
        Number four = new Number(4);
        Number two = new Number(2);
        Number six = new Number(6);
        Number three = new Number(3);

        try{
            Fraction fraction = new Fraction(one,zero);
        }
        catch(MyException e){
            e.printMessage();
        }

        try {
            Fraction fraction = new Fraction(one, two);
            Fraction fraction1 = new Fraction(one, three);

            System.out.println(fraction1.multiplicateFraction(fraction));
            System.out.println(fraction1.addFraction(fraction));
            System.out.println(fraction1.divideFraction(fraction));
            System.out.println(fraction1.substractFraction(fraction));

        } catch (MyException e) {
            e.printMessage();
        }


    }
}
