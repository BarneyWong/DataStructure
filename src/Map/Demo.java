package Map;


import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("Pride and prejudice");
        ArrayList<String> wordList = new ArrayList<>();
        if (FileOperation.readFile("src/Map/pride-and-prejudice.txt", wordList)) {
            System.out.println("Total words :" + wordList.size());
            LinkedListMap<String, Integer> wordsMap = new LinkedListMap<String, Integer>();
//            TreeMap<String, Integer> wordsMap = new TreeMap<String, Integer>();
            for (String word : wordList) {
                if (wordsMap.contains(word)) {
                    wordsMap.set(word, wordsMap.get(word) + 1);
                } else {
                    wordsMap.add(word, 1);
                }
            }
//            System.out.println(wordsMap.remove("pride"));
            System.out.println("Total different words: " + wordsMap.getSize());
            System.out.println("Frequency of PRIDE: " + wordsMap.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + wordsMap.get("prejudice"));


        }
        System.out.println(System.currentTimeMillis()-start);
        start=System.currentTimeMillis();
        System.out.println("Pride and prejudice");
        ArrayList<String> wordList1 = new ArrayList<>();
        if (FileOperation.readFile("src/Map/pride-and-prejudice.txt", wordList1)) {
            System.out.println("Total words :" + wordList1.size());
//            LinkedListMap<String, Integer> wordsMap = new LinkedListMap<String, Integer>();
            TreeMap<String, Integer> wordsMap = new TreeMap<String, Integer>();
            for (String word : wordList1) {
                if (wordsMap.contains(word)) {
                    wordsMap.set(word, wordsMap.get(word) + 1);
                } else {
                    wordsMap.add(word, 1);
                }
            }
//            System.out.println(wordsMap.remove("pride"));
            System.out.println("Total different words: " + wordsMap.getSize());
            System.out.println("Frequency of PRIDE: " + wordsMap.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + wordsMap.get("prejudice"));

            System.out.println(System.currentTimeMillis()-start);
        }
    }
}
