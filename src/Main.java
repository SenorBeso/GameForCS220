import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int [][] generation = new int[10][10];
        int [][] futureGen;

        Scanner scan = new Scanner(System.in);

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
        for (int i = 0; i < 10; i++ ){
            for (int j = 0; j < 10; j++){
                //new cell is born
                if (matrix[i][j] == 0 && sumMatrix(matrix) == 3){
                    matrix[i][j] = 1;
                //Cell dies of over population
                } else if(matrix[i][j] == 1 && sumMatrix(matrix) > 3){
                    matrix[i][j] = 0;
                //Cell is lonely and dies
                } else if (matrix[i][j] == 1 && sumMatrix(matrix) < 2) {
                    matrix[i][j] = 0;
                //Stays the same
                } else {
                    future[i][j] = matrix[i][j];
                }
            }
        }
        return matrix;
    }
    static int sumMatrix(int[][] matrix){
        int sum = 0;

        for (int row = 0; row < 10; row++){
            //nested for loop for the columns
            for (int col = 0; col < 10; col++){
                //for summing the middle of the array
                if(row > 0 && row < 9 && col >0 && col < 9){
                    sum = (matrix[row-1][col-1])+(matrix[row-1][col])+(matrix[row-1][col+1])
                        +(matrix[row][col-1]) +(matrix[row][col+1])+
                        (matrix[row+1][col-1])+(matrix[row+1][col])+(matrix[row+1][col+1]);
                }
                //for summing the corners of the array
                //top left corner
                if(row==0 && col == 0){
                    sum = (matrix[row][col+1])+(matrix[row+1][col])+(matrix[row+1][col+1]);
                }
                //top right corner
                if(row==0 && col == 9){
                    sum = (matrix[row][col-1])+(matrix[row+1][col])+(matrix[row+1][col-1]);
                }

                //bottom left corner
                if(row==9 && col == 0){
                    sum = (matrix[row][col+1])+(matrix[row-1][col])+(matrix[row-1][col+1]);
                }

                //bottom right corner
                if(row==9 && col == 9){
                    sum = (matrix[row][col-1])+(matrix[row-1][col])+(matrix[row-1][col-1]);
                }

                //for summing the outer rows
                //top row
                if (row==0 && (col>0 && col <9 )) {
                    sum = (matrix[row][col - 1]) + (matrix[row][col + 1]) +
                        (matrix[row + 1][col - 1]) + (matrix[row + 1][col]) + (matrix[row + 1][col + 1]);
                }

                //bottom row
                if (row==9 && (col>0 && col <9 )){
                    sum = (matrix[row][col-1]) + (matrix[row][col+1])
                        +(matrix[row-1][col-1])+(matrix[row-1][col])+(matrix[row-1][col+1]);
                }

                //for summing the outer columns
                //left column
                if (col==0 && (row >0 && row < 9)) {
                    sum = (matrix[row][col+1])+(matrix[row-1][col])+(matrix[row+1][col])+
                        (matrix[row-1][col+1])+(matrix[row+1][col+1]);
                }

                //right column
                if (col==9 && (row >0 && row < 9)) {
                    sum = (matrix[row][col-1])+(matrix[row-1][col])+(matrix[row+1][col])+
                        (matrix[row+1][col-1])+(matrix[row-1][col-1]);
                }
            }
        }
        return sum;
    }
}
