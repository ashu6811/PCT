import java.util.Scanner;

public class Hashing {

    public Integer removeLastDigit(Integer num)
    {
        return num/10;
    }

    public Integer lastDigit(Integer num)
    {
        return num%10;
    }

    public Integer findPlace (Integer num, Integer N)
    {
        return num%N;
    }

    public Integer recursivePosition(Integer num, Integer[] hashtable, Integer N)
    {
        // full fill the recursive call position
    }

    public static void main (String [] args)
    {
        Scanner input = new Scanner(System.in);
        Integer N = input.nextInt();
        int i;
        Integer[] raw = new Integer[N];
        Integer[] hashtable = new Integer[N];
        Hashing hashing = new Hashing();


        for(i=0;i<N;i++)
        {
            raw[i] = input.nextInt();
        }

        for(i=0; i<N ; i++)
        {
            if(hashtable[hashing.findPlace(raw[i], N)] != 0)
            {
                hashtable[hashing.findPlace(raw[i], N)] = raw[i];
                System.out.print(i);
            }
            else
            {
                // when position doesn't match
                hashtable[hashing.recursivePosition()] = raw[i];

            }



            System.out.print("\n");
        }

    }
}
