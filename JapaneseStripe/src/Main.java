import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class Main implements Runnable {
    @Override
    public void run() {
        Scanner input = null;
        BigInteger one = new BigInteger("1");
        BigInteger zero = new BigInteger("0");
        try {
            FileWriter output = new FileWriter("out.txt");
            input = new Scanner(new File("in.txt"));
            int length;
            length = input.nextInt();
            int amountOfGroups = input.nextInt();
            if (amountOfGroups > 0) {
                for (long i = 0; i < amountOfGroups; ++i) {
                    int element = input.nextInt();
                    length -= element;
                }
                input.close();
                ++length;
                if (length <= 0) {
                    output.write(String.valueOf(zero));
                    output.close();
                }
                else {
                    if (amountOfGroups > length) {
                        output.write(String.valueOf(zero));
                        output.close();
                    } else {
                        BigInteger[][] pascalTriangle = new BigInteger[length+1][length+1];
                        for (int i = 0; i < length + 1; ++i) {
                            pascalTriangle[i][0] = one;
                            pascalTriangle[i][i] = one;
                            for (int j = 1; j < i; j++) {
                                pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1].add(pascalTriangle[i - 1][j]);
                            }
                        }
                        output.write(String.valueOf(pascalTriangle[length][amountOfGroups]));
                        output.close();
                    }
                }
            }else {
                output.write(String.valueOf(one));
                output.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Thread(null, new Main(),"", 64*1024*1024 ).start();
    }
}
