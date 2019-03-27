import java.util.Scanner;

public class GameOfLife {


    public String[][] matrix;


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Integer m = input.nextInt();
        Integer n = input.nextInt();

        m++;m++;
        n++;n++;
        int i , j;
        GameOfLife game = new GameOfLife();
         game.matrix = new String[m][n];



        for (i=0;i<=m+1;i++)
        {
            for(j=0;j<=n+1;j++)
            {
                //padding the boundaries
                if(i == 0 || j==0 || i==m+1 || j==n+1)
                    game.matrix[i][j]="#";
                else
                    game.matrix[i][j] = input.next();

            }
        }

        String[][] matrix2 = new String[m][n];
        //Run the game N times
        Integer N =input.nextInt();
        int k;
        for (k = 1; k<=N; k++)
        {
            for(i=1; i<=m; i++)
            {
                for(j=1;j<=n;j++)
                {
                    if(game.neighbour(i,j,game) == 0 || game.neighbour(i,j,game) == 1)
                        matrix2[i][j] = "#";
                    else if (game.neighbour(i,j,game) >4)
                        matrix2[i][j] = "#";
                    else if (game.neighbour(i,j,game) == 2 || game.neighbour(i,j,game) == 3 )
                    {
                        if ()matrix2[i][j] = "@";
                    }

                }
            }
        }


    }

    public Integer neighbour(int i , int j, GameOfLife game)
    {
        Integer count = 0;

        if ( game.matrix[i-1][j-1].equals("@") )
        {
            count++;
        }
        if ( game.matrix[i][j-1].equals("@") )
        {
            count++;
        }
        if ( game.matrix[i+1][j-1].equals("@") )
        {
            count++;
        }
        if ( game.matrix[i-1][j].equals("@") )
        {
            count++;
        }
        if ( game.matrix[i+1][j].equals("@") )
        {
            count++;
        }
        if ( game.matrix[i-1][j+1].equals("@") )
        {
            count++;
        }
        if ( game.matrix[i][j+1].equals("@") )
        {
            count++;
        }
        if ( game.matrix[i+1][j+1].equals("@") )
        {
            count++;
        }
        return count;
    }
}


