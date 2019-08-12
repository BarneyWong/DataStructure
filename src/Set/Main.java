package Set;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        long start = System.currentTimeMillis();
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src/Set/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            BSTSet<String> set = new BSTSet<String>();
//            LinkedListSet<String> set = new LinkedListSet<String>();
            for (String word : words) {
                set.add(word);
            }
            System.out.println("Total different words : " + set.getSize());
        }
        System.out.println(System.currentTimeMillis()-start);
        System.out.println();
        System.out.println("a-tale-of-two-cities");
        long start2= System.currentTimeMillis();
        ArrayList<String> anotherWords = new ArrayList<>();
        if(FileOperation.readFile("src/Set/a-tale-of-two-cities.txt",anotherWords)){
            System.out.println("Total words: "+anotherWords.size());
//            LinkedListSet<String> set = new LinkedListSet<String>();
            BSTSet<String> set = new BSTSet<String>();
            for(String word:anotherWords){
                set.add(word);
            }
            System.out.println("Total different words: "+set.getSize());
        }
        System.out.println(System.currentTimeMillis()-start2);
    }
}
