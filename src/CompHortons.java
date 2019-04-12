import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CompHortons {
    public Integer limit1, limit2, limit3;
    public String[] result;

    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);

        CompHortons obj = new CompHortons();

        obj.limit1 = input.nextInt();
        obj.limit2 = input.nextInt();
        obj.limit3 = input.nextInt();

        Integer numOfCustomers;
        numOfCustomers = input.nextInt();

        obj.result = new String[numOfCustomers];

        String[] names= new String[numOfCustomers];
        Integer[] ages = new Integer[numOfCustomers];
        Integer[] heightsFeet = new Integer[numOfCustomers];
        Integer[] heightsInches = new Integer[numOfCustomers];

        for (int i =0; i<numOfCustomers; i++)
        {
            names[i] = input.next();
            ages[i] = input.nextInt();
            heightsFeet[i] = input.nextInt();
            heightsInches[i] = input.nextInt();
        }


        // input done...........

        //Result for Basic
        for (int i=0; i<numOfCustomers; i++)
        {
            obj.printBasicOutput(obj, names[i], ages[i], heightsFeet[i], heightsInches[i], i);
            System.out.println();
        }

        // Result for Advanced
        List<String> resultToSort = new ArrayList<>();
        resultToSort = Arrays.asList(obj.result);
        resultToSort.sort(String::compareTo);
        System.out.println();

        for (int i =0; i < numOfCustomers; i++)
            System.out.println(resultToSort.toArray()[i]);


    }

    public  Float calcSize (Integer hFeet, Integer hInch)
    {
        float height = hFeet + hInch/12;
        float units=0;
        if(height< 5)
            units = 10*height;
        else
            units = 50 + 8*(height-5);

        return units;
    }
    public void printBasicOutput(CompHortons obj, String name, Integer age, Integer hFeet, Integer hInch, Integer i)
    {
        System.out.print(name);
        result[i] = "";
        result[i] += name;

        if(age < 18 )
        {
            System.out.print(" Water");
            result[i] += " Water";
        }
        else
            {
            System.out.print(" Beer");
            result[i] += " Beer";
            }

        if(0 < calcSize(hFeet, hInch) && calcSize(hFeet, hInch)<= obj.limit1)
        {
            System.out.print(" ExtraSmall");
            result[i] += " ExtraSmall";
        }
        else if(obj.limit1 < calcSize(hFeet, hInch) && calcSize(hFeet, hInch)<= obj.limit2)
        {
            System.out.print(" Small");
            result[i] += " Small";
        }

        else if(obj.limit2 < calcSize(hFeet, hInch) && calcSize(hFeet, hInch)<= obj.limit3)
        {
            System.out.print(" Medium");
            result[i] += " Medium";
        }
        else
            {
            System.out.print(" Large");
            result[i] += " Large";
        }

        System.out.print(" " + age +" " + hFeet + " " + hInch);
        result[i] += " " + age +" " + hFeet + " " + hInch;

    }
}
/*
25 50 75
3
Charles 29 5 0
Adam 56 6 3
Bob 11 4 6

25 50 75
3
Bob 29 5 0
Adam 56 6 3
Bob 11 4 6


 */