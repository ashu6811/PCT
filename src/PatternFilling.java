import java.util.Scanner;

public class PatternFilling {
    public static int N;
    public static int p;
    public static Integer[] mainArray;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        p = input.nextInt();
        mainArray = new Integer[N+1];

        for(int i=1; i<=N; i++)
        {
            mainArray[i] = null;
        }

        for(int i=1; i<=p; i++)
        {
            fillArray(i);
            //printArray();
        }

        for(int i=1; i<=p; i++)
        {

            if(mainArray[i] != null && p == mainArray[i])
                System.out.print(i);
        }

    }

    public  static void  printArray()
    {
        for(int i=1; i<=N; i++)
            System.out.print(mainArray[i] +" ");
        System.out.println();
    }
    public static void fillArray(int num)
    {
        if(num == 1)
        {
            mainArray[1] = 1;
        }
        else if (num == 2)
        {
            mainArray[N] =2;
        }
        else
        {
            int farthestIndex = calFarthestIndex(num);
            mainArray[farthestIndex] = num;
        }
    }

    public static  int calFarthestIndex(int num)
    {
        int farthestClosestDist =0;
        int farthestDistIndex =0;
        int temp =0;
        //int fathestSumDist =0;
        for(int i = 1 ; i<=N; i++)
        {
            if(mainArray[i] ==null)
            {
                temp = calDistForEach(i);
                if(farthestClosestDist< temp)
                {
                    farthestClosestDist = temp;
                    farthestDistIndex = i;
                }
            }
        }
        return farthestDistIndex;
    }

    public static int calDistForEach(int i)
    {
        int r =0;
        int l =0;
        int j =1;

        while(i-j >0 && mainArray[i-j]==null)
        {
            l++;
            j++;
        }

        j=1;

        while(i+j <= N && mainArray[i+1]==null)
        {
            r++;
            j++;
        }
        //System.out.println("index: " + i +"  " + l +":" +r) ;
        return Math.min(r,l) + 1;
    }

}
