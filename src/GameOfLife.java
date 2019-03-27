import java.util.Scanner;

public class GameOfLife {


    public String[][] matrix;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer m = input.nextInt();
        Integer n = input.nextInt();


        int i, j;
        GameOfLife game = new GameOfLife();
        game.matrix = new String[m + 2][n + 2];


        // input
        for (i = 0; i <= m + 1; i++) {
            for (j = 0; j <= n + 1; j++) {
                //padding the boundaries
                if (i == 0 || j == 0 || i == m + 1 || j == n + 1)
                    game.matrix[i][j] = "#";
                else
                    game.matrix[i][j] = input.next();

            }
        }


        //print
        for (i = 0; i <= m + 1; i++) {
            for (j = 0; j <= n + 1; j++) {
                //padding the boundaries
                System.out.print(game.matrix[i][j] + " ");

            }
            System.out.print("\n");
        }

        String[][] matrix2 = new String[m + 2][n + 2];
        //initialize dummy matrix
        for (i = 0; i <= m + 1; i++)
        {
            for (j = 0; j <= n + 1; j++)
            {
                matrix2[i][j] = "#";
            }
        }

        //Run the game N times
        Integer N = input.nextInt();
        int k, temp;
        for (k = 1; k <= N; k++)
        {
            for (i = 1; i <= m; i++)
            {
                for (j = 1; j <= n; j++)
                {
                    temp = game.neighbour(i, j);
                    if(temp>=4)
                        matrix2[i][j] = "#";
                    else if(temp==0 || temp == 1)
                        matrix2[i][j] = "#";
                    else if (temp == 2 )
                        matrix2[i][j] = game.matrix[i][j];
                    else if(temp == 3)
                        matrix2[i][j] = "@";

                }
            }

            game.matrix = matrix2.clone();
            System.out.print("\n");
            for (i = 1; i <= m; i++)
            {
                for (j = 1; j <= n; j++)
                {
                    System.out.print(game.matrix[i][j]);


                }
                System.out.println("");
            }



        }




            // count the number of lives in game
            Integer countLives = 0;
            for (i = 1; i <= m; i++)
            {
                for (j = 1; j <= n; j++)
                {
                    System.out.print(game.matrix[i][j]);
                    if (game.matrix[i][j] == "@")
                        countLives++;
                }
                System.out.println("");
            }
            System.out.print(countLives);


        }


    public Integer neighbour(int i , int j)
    {
        Integer count = 0;

        System.out.print(matrix[i][j]);
        if ( matrix[i-1][j-1].equals("@") )
        {
            count++;
        }
        if ( matrix[i][j-1].equals("@") )
        {
            count++;
        }
        if ( matrix[i+1][j-1].equals("@") )
        {
            count++;
        }
        if ( matrix[i-1][j].equals("@") )
        {
            count++;
        }
        if ( matrix[i+1][j].equals("@") )
        {
            count++;
        }
        if ( matrix[i-1][j+1].equals("@") )
        {
            count++;
        }
        if ( matrix[i][j+1].equals("@") )
        {
            count++;
        }
        if (matrix[i+1][j+1].equals("@") )
        {
            count++;
        }
        System.out.print(" "+count+"\n");
        return count;
    }
}


