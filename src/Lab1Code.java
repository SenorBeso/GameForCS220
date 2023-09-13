public class Lab1Code {
    public static void main(String[] args) {
        int[][] matrix = new int[10][10];
//        Random rand = new Random();
        int[][]sumMatrix = new int[10][10];

        //for loop for the rows
        for (int row = 0; row < 10; row++){
            System.out.println();
            //nested for loop for the columns
            for (int col = 0; col < 10; col++){
                //determines if the row is even or odd
                if (row%2 == 0){
                    matrix[row][col] = 0;
                } else {
                    matrix[row][col] = 1;
                }
                System.out.print(matrix[row][col] + "\t");
            }
        }

        for (int row = 0; row < 10; row++){
            //nested for loop for the columns
            for (int col = 0; col < 10; col++){
                //for summing the middle of the array
                if(row > 0 && row < 9 && col >0 && col < 9){
                    sumMatrix[row][col] = (matrix[row-1][col-1])+(matrix[row-1][col])+(matrix[row-1][col+1])
                        +(matrix[row][col-1]) +(matrix[row][col+1])+
                        (matrix[row+1][col-1])+(matrix[row+1][col])+(matrix[row+1][col+1]);
                }
                //for summing the corners of the array
                //top left corner
                if(row==0 && col == 0){
                    sumMatrix[row][col] = (matrix[row][col+1])+(matrix[row+1][col])+(matrix[row+1][col+1]);
                }
                //top right corner
                if(row==0 && col == 9){
                    sumMatrix[row][col] = (matrix[row][col-1])+(matrix[row+1][col])+(matrix[row+1][col-1]);

                }
                //bottom left corner
                if(row==9 && col == 0){
                    sumMatrix[row][col] = (matrix[row][col+1])+(matrix[row-1][col])+(matrix[row-1][col+1]);

                }
                //bottom right corner
                if(row==9 && col == 9){
                    sumMatrix[row][col] = (matrix[row][col-1])+(matrix[row-1][col])+(matrix[row-1][col-1]);
                }
                //for summing the outer rows
                //top row
                if (row==0 && (col>0 && col <9 )) {
                    sumMatrix[row][col] = (matrix[row][col - 1]) + (matrix[row][col + 1]) +
                        (matrix[row + 1][col - 1]) + (matrix[row + 1][col]) + (matrix[row + 1][col + 1]);
                }
                //bottom row
                if (row==9 && (col>0 && col <9 )){
                    sumMatrix[row][col] = (matrix[row][col-1]) + (matrix[row][col+1])
                        +(matrix[row-1][col-1])+(matrix[row-1][col])+(matrix[row-1][col+1]);

                }
                //for summing the outer columns
                //left column
                if (col==0 && (row >0 && row < 9)) {
                    sumMatrix[row][col] = (matrix[row][col+1])+(matrix[row-1][col])+(matrix[row+1][col])+
                        (matrix[row-1][col+1])+(matrix[row+1][col+1]);
                }
                //right column
                if (col==9 && (row >0 && row < 9)) {
                    sumMatrix[row][col] = (matrix[row][col-1])+(matrix[row-1][col])+(matrix[row+1][col])+
                        (matrix[row+1][col-1])+(matrix[row-1][col-1]);
                }
            }
        }

        System.out.println();
        System.out.println();

        //for loop for the rows
        for (int row = 0; row < 10; row++){
            System.out.println();
            //nested for loop for the columns
            for (int col = 0; col < 10; col++){
                //determines if the row is even or odd
                System.out.print(sumMatrix[row][col] + "\t");
            }
        }
    }

}
