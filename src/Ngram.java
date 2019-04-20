import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Ngram {
    Integer nGram;
    ArrayList<String> nGramArrayList;
    TreeMap<String, Integer> freqTreeMap;
    Ngram(Integer nGram)
    {
        this.nGram = nGram;
        nGramArrayList = new ArrayList<>();
        freqTreeMap = new TreeMap<>();
    }

    public void makeNGrams(String[] raw)
    {
        String tempGram;
        for(int i=0; i<raw.length; i++)
        {
            for(int j=0; j<raw[i].length()-this.nGram+1; j++)
            {
                tempGram = raw[i].substring(j,j+this.nGram);
                if(tempGram.contains(".") || tempGram.contains(",") || tempGram.contains(" "))
                    tempGram = null;
                else
                {
                    this.nGramArrayList.add(tempGram);
                    tempGram = null;
                }
            }
        }
    }

    public void freqBuilder() {

        int tempCount;
        for(String i: nGramArrayList)
        {
           tempCount= this.freqTreeMap.getOrDefault(i, 0);
           this.freqTreeMap.put(i,tempCount+1);

        }

    }

    public void printMaxFreqGram()
    {
        Integer max =0;
        String maxKey = "";
        for( String key: this.freqTreeMap.keySet())
        {
            if(this.freqTreeMap.get(key)> max)
            {
                max= this.freqTreeMap.get(key);
                maxKey = key;
            }
        }

        if(nGram==1)
        {
            System.out.print("Unigram ");
            System.out.print(maxKey);
        }
        else if(nGram==2)
        {
            System.out.print("Bigram ");
            System.out.print(maxKey);
        }
        else if(nGram==3)
        {
            System.out.print("Trigram ");
            System.out.print(maxKey);
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Integer numOfLines = input.nextInt();
        input.nextLine();
        String[] raw = new String[numOfLines];
        for(int i=0; i<numOfLines; i++)
        {
            raw[i] = input.nextLine();
        }
        Integer nGram = input.nextInt();

        // input done....
        Ngram obj = new Ngram(nGram);
        obj.makeNGrams(raw);
        //System.out.println(obj.nGramArrayList);
        obj.freqBuilder();
        obj.printMaxFreqGram();

    }


}

/*

2
abcd
zz. z,z. z z. z,z.
1


3
a a. a,a.
bc  bc
abcd abcd abcd
2

1
abababababababababa
3
*/