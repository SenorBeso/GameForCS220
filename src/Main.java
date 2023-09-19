/**
 * @author Steven Behrens & Aiden Kiss
 * @Version 9.14.23
 * A Recreation of The Game of Life
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Initializes the game board size
        Scanner scan = new Scanner(System.in);
        System.out.println("How big would you like the game board to be? " + "\n" +
            "(For example, inputting 10 creates a 10x10 board");
        int boardSize = scan.nextInt();

        int [][] generation = new int[boardSize][boardSize];
        int [][] futureGen;

        // Fill the Array with user inputted values
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
        System.out.println("You selected "+ rounds + " rounds");


        //Prints the Game
        for(int i = 0; i <= rounds; i++) {
            for (int row = 0; row < boardSize; row++) {
                System.out.println();
                //nested for loop for the columns
                for (int col = 0; col < boardSize; col++) {
                    System.out.print(generation[row][col] + "\t");
                }
            }
            futureGen = nextGen(generation, boardSize);
            System.arraycopy(futureGen, 0, generation, 0, generation.length);
            System.out.println();
            System.out.println("Generation "+ i);
        }
    }

    /*This method is given the past generation, and based on the rules of the game, calculates whether a new cell is
    born or killed. It returns the new array/generation
     */
    static int[][] nextGen (int[][] matrix, int boardSize){
        int[][] future = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++ ){
            for (int j = 0; j < boardSize; j++){
                //new cell is born
                if (matrix[i][j] == 0 && sumMatrix(matrix,i,j,boardSize) == 3){
                    future[i][j] = 1;
                //Cell dies of over population
                } else if(matrix[i][j] == 1 && sumMatrix(matrix,i,j,boardSize) > 3){
                    future[i][j] = 0;
                //Cell is lonely and dies
                } else if (matrix[i][j] == 1 && sumMatrix(matrix,i,j,boardSize) < 2) {
                    future[i][j] = 0;
                //Stays the same
                } else {
                    future[i][j] = matrix[i][j];
                }
            }
        }
        return future;
    }

    //This is the method that takes a sum of the cell's neighbors. The method returns a sum.
    static int sumMatrix(int[][] matrix, int x, int y, int boardSize) {
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

        //This loop goes through each possible neighbor cell, and will add its value to the sum
        for(int i = 0; i < neighbors.length; i++) {
            int newX = x + neighbors[i][0];
            int newY = y + neighbors[i][1];

            if (newX >= 0 && newX < boardSize && newY >= 0 && newY < boardSize) {
                sum += matrix[newX][newY];
            }
        }
        return sum;
    }
}
