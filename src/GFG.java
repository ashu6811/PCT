
import java.util.*;

public class GFG {

    // Driver Code
    public static void main(String[] args)
    {

        // Declare and Initialize an array
        int[] array = { 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5 };
        String[] array2 = {"abc", "bcd", "def" , "abc", "bcd" , "def" , "def" , "def", "aa", "bcd"  };

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> outputArray = new ArrayList<>();

        Map<String, Integer> map2 = new HashMap<>();
        List<String> outputArray2 = new ArrayList<>();


        // Assign elements and their count in the list and map
        for (int current : array) {
            int count = map.getOrDefault(current, 0);
            map.put(current, count + 1);
            outputArray.add(current);
        }

        for(int i =0 ; i<array2.length; i++)
        {
            int count = map2.getOrDefault(array2[i], 0);
            map2.put(array2[i], count+1);
            outputArray2.add(array2[i]);

        }


        // Compare the map by value
        SortComparator comp = new SortComparator(map);

        SortComparator2 comp2 = new SortComparator2(map2);

        // Sort the map using Collections CLass
        Collections.sort(outputArray, comp);

        Collections.sort(outputArray2, comp2);

        // Final Output
        for (Integer i : outputArray) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (String i : outputArray2) {
            System.out.print(i + " ");
        }


    }
}

// Implement Comparator Interface to sort the values
class SortComparator implements Comparator<Integer> {
    private final Map<Integer, Integer> freqMap;

    // Assign the specified map
    SortComparator(Map<Integer, Integer> tFreqMap)
    {
        this.freqMap = tFreqMap;
    }

    // Compare the values
    @Override
    public int compare(Integer k1, Integer k2)
    {

        // Compare value by frequency
        int freqCompare = freqMap.get(k2).compareTo(freqMap.get(k1));

        // Compare value if frequency is equal
        int valueCompare = k1.compareTo(k2);

        // If frequency is equal, then just compare by value, otherwise -
        // compare by the frequency.
        if (freqCompare == 0)
            return valueCompare;
        else
            return freqCompare;
    }

}


class SortComparator2 implements Comparator<String>
{
    private final Map<String, Integer> freqMap;

    SortComparator2(Map<String, Integer> freqMap)
    {
        this.freqMap = freqMap;
    }

    public int compare(String k1, String k2)
    {
        int freqCompare = freqMap.get(k2).compareTo(freqMap.get(k1));

        int valueCompare = k1.compareTo(k2);

        if(freqCompare ==  0)
            return valueCompare;
        else
            return freqCompare;
    }

}