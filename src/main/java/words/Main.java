package words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{

        Scanner sc = new Scanner(new File("text.txt"));
        List<String> words = new ArrayList<>();

        try {
            sc.useDelimiter("\\W+");
            while (sc.hasNext()){
                words.add(sc.next());
            }
        } finally {
            sc.close();
        }

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

        for (String i: words){
            System.out.println(i);
        }

    }
}
