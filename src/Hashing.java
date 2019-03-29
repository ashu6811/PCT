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

    public void recursivePosition(Integer num, Integer[] hashtable, Integer N, Integer pos)
    {

        if (num / 10 == 0)
        {

            if(hashtable[pos] == null)
            {
                hashtable[pos] = num;
                System.out.print(pos +"\n");
                return ;
            }
            else
            {

                if(num %2 == 0 || num == 0)
                {

                        System.out.print(pos + " ");
                        while (hashtable[pos] != null)
                        {
                            System.out.print(pos + " ");
                            pos = (pos-1 + N ) %N;
                        }
                        System.out.print(pos + "\n");
                        hashtable[pos] = num ;
                        return;

                }
                else
                {

                        System.out.print(pos + " ");
                        while (hashtable[pos] != null)
                        {
                            System.out.print(pos + " ");
                            pos = (pos+1 + N ) %N;
                        }
                        System.out.print(pos + "\n");
                        hashtable[pos] = num ;
                        return;

                }
            }
        }
        else
        {
            System.out.print(pos + " ");
            if(hashtable[pos] == null)
            {
                hashtable[pos] = num;
                System.out.print("\n");
                return ;


            }
            else
            {
                Integer righMostDigit = lastDigit(num);
                Integer newNum = removeLastDigit(num);
                Integer j = newNum%num;

                if (righMostDigit%2 == 0)
                {
                    pos = (pos -j + N)%N;
                    recursivePosition(newNum, hashtable, N, pos);
                }
                else
                {
                    pos = (pos +j + N)%N;
                    recursivePosition(newNum, hashtable, N, pos);
                }
            }
        }


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
            hashtable[i] = null;
        }

        i =0;
        Integer tempInput = input.nextInt();
        while(tempInput !=-1)
        {
            raw[i] = tempInput;
            tempInput = input.nextInt();
            i++;
        }

        Integer count = i;
        for(i=0; i<count ; i++)
        {
            hashing.recursivePosition(raw[i], hashtable, N , raw[i]%N);
        }

    }
}
