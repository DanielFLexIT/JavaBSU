import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;

/**
 * Исправить
 * Добавить MissMatch исключение
 */
public class App {
    public static void main(String[] args) {
        String desktop = System.getProperty ("user.home") + "/Desktop/BSU/Programming/";
      try(FileReader reader = new FileReader(desktop + "input1.txt")){
              Scanner scanner = new Scanner(reader);
              int size = scanner.nextInt();
              double[][] matrix = new double[size][size];
              for (int i = 0; i < size; ++i) {
                  for (int j = 0; j < size; ++j) {
                      matrix[i][j] = scanner.nextDouble();
                  }
              }
          double determinant = matrixDeterminant(matrix);
          if (determinant == 0){
              System.out.println("Determinant is 0");
          }
          double[][] invertableMatrix = inverseMatrix(matrix);
          printMatrix(invertableMatrix);

      }

      catch (InputMismatchException exception){
          System.out.println("InputMissMatch error");
      }

      catch (IOException exception){
          System.out.println(exception.getMessage());
      }

      catch (NoSuchElementException exception)
      {
          System.out.println("No elements");
      }
    }
    public static void printMatrix(double[][] matrix){
        int size = matrix.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i){
            for (int j = 0; j < size; ++j){
                sb.append(matrix[i][j]);
                sb.append(' ');
            }
            System.out.println(sb.toString());
            sb.delete(0,sb.length());
        }
    }
    public static double matrixDeterminant(double[][] matrix) {
        double[][] temporaryMatrix = new double[matrix.length][matrix.length];
        double determinant = 0;
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        for (int i = 0; i < matrix[0].length; ++i) {
            temporaryMatrix = new double[matrix.length - 1][matrix[0].length - 1];
            for (int j = 1; j < matrix.length; ++j) {
                for (int k = 0; k < matrix[0].length; ++k) {
                    if (k < i) {
                        temporaryMatrix[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        temporaryMatrix[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }
            determinant += matrix[0][i] * Math.pow(-1, (double) i) * matrixDeterminant(temporaryMatrix);
        }
        return determinant;
    }

    public static double[][] inverseMatrix(double[][] matrix) {
        int size = matrix.length;
        double[][] temporaryMatrix = new double[size][size];
        double[][] identifyMatrix = new double[size][size];
        /**
         * Create a temporary matrix and identify Matrix
         */
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                temporaryMatrix[i][j] = matrix[i][j];
                if (i == j) {
                    identifyMatrix[i][j] = 1.;
                } else {
                    identifyMatrix[i][j] = 0.;
                }
            }
        }
        /**
         * Making a triangle matrix from current
         */
        double coefficient;
        double[] delta;
        for (int i = 0; i < size - 1; ++i) {
            for (int j = i + 1; j < size; ++j) {
                if (temporaryMatrix[i][i] == 0) {
                    for (int k = i + 1; k < size ; ++k) {
                        if (temporaryMatrix[k][j] != 0) {
                            delta = temporaryMatrix[i];
                            temporaryMatrix[i] = temporaryMatrix[k];
                            temporaryMatrix[k] = delta;
                            delta = identifyMatrix[i];
                            identifyMatrix[i] = identifyMatrix[k];
                            identifyMatrix[k] = delta;
                            break;
                        }
                    }
                }
                coefficient = -1 * temporaryMatrix[j][i] / temporaryMatrix[i][i];
                for (int q = i; q < size; ++q) {
                    temporaryMatrix[j][q] += coefficient * temporaryMatrix[i][q];
                }
                for (int r = 0; r < size; ++r) {
                    identifyMatrix[j][r] += coefficient * identifyMatrix[i][r];
                }
            }
        }
        /**
         * Making a diagonal matrix from triangle
         */
        for (int i = size - 1; i >= 0; --i){
            for (int j = i - 1; j >= 0; --j){
                coefficient = -1 * temporaryMatrix[j][i] / temporaryMatrix[i][i];
                for (int q = i; q > 0; --q){
                    temporaryMatrix[j][q] += coefficient * temporaryMatrix[i][q];
                }
                for (int r = size - 1; r >= 0; --r){
                    identifyMatrix[j][r] += coefficient * identifyMatrix[i][r];
                }
            }
        }
        /**
         * Getting invertable Matrix
         */
        for (int i = 0; i < size; ++i){
            coefficient = temporaryMatrix[i][i];
            for (int j = 0; j < size; ++j){
                identifyMatrix[i][j] = identifyMatrix[i][j] / coefficient;
            }
        }
        return identifyMatrix;
    }
}
