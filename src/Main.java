/**
 * @author Steven Behrens & Aiden Kiss
 * @Version 9.14.23
 * A Recreation of The Game of Life
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int [][] generation = new int[10][10];
        int [][] futureGen;

        // Fill the Array with user inputted values
        Scanner scan = new Scanner(System.in);
        System.out.println("How many cells would you like in the neighborhood?");
        int amtOfCells = scan.nextInt();
        for(int i = 0; i < amtOfCells; i++){
            System.out.println("Please enter x value");
            int x = scan.nextInt();
            System.out.println("Please enter y value");
            int y = scan.nextInt();
            generation[x][y] = 1;
        }

        //Determines the amount of generations produced
        int rounds;
        System.out.println("enter the number of rounds");
        rounds = scan.nextInt();
        System.out.println("You selected "+ rounds + "rounds");


        //Prints the Game
        for(int i = 0; i <= rounds; i++) {
            for (int row = 0; row < 10; row++) {
                System.out.println();
                //nested for loop for the columns
                for (int col = 0; col < 10; col++) {
                    System.out.print(generation[row][col] + "\t");
                }
            }
            futureGen = nextGen(generation);
            System.arraycopy(futureGen, 0, generation, 0, generation.length);
            System.out.println();
            System.out.println("Generation "+ i);
        }
    }

    static int[][] nextGen (int[][] matrix){
        int[][] future = new int[10][10];
        for (int i = 0; i < 10; i++ ){
            for (int j = 0; j < 10; j++){
                //new cell is born
                if (matrix[i][j] == 0 && sumMatrix(matrix,i,j) == 3){
                    future[i][j] = 1;
                //Cell dies of over population
                } else if(matrix[i][j] == 1 && sumMatrix(matrix,i,j) > 3){
                    future[i][j] = 0;
                //Cell is lonely and dies
                } else if (matrix[i][j] == 1 && sumMatrix(matrix,i,j) < 2) {
                    future[i][j] = 0;
                //Stays the same
                } else {
                    future[i][j] = matrix[i][j];
                }
            }
        }
        return future;
    }

    static int sumMatrix(int[][] matrix, int x, int y) {
        int sum = 0;
        int[][] neighbors = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
        };

        for(int i = 0; i < neighbors.length; i++) {
            int newX = x + neighbors[i][0];
            int newY = y + neighbors[i][1];

            if (newX >= 0 && newX < 10 && newY >= 0 && newY < 10) {
                sum += matrix[newX][newY];
            }
        }
        return sum;
    }
}
