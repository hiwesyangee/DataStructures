package setAndmap;

import java.util.ArrayList;

public class Main {

    public static void main2(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("src/setAndmap/pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BinarySearchTreeSet<String> set1 = new BinarySearchTreeSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println("---------------------------");

        System.out.println("A Tale of Two Cities");
        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("src/setAndmap/a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            BinarySearchTreeSet<String> set2 = new BinarySearchTreeSet<>();
            for (String word : words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }
    }

    public static double testSet(Set<String> set, String fileName) {
        long start = System.nanoTime();

        System.out.println(fileName);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(fileName, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }

        long stop = System.nanoTime();

        return (stop - start) / 1000000000.0;
    }

    public static void main(String[] args) {
        String fileName = "src/setAndmap/pride-and-prejudice.txt";

        BinarySearchTreeSet bstSet = new BinarySearchTreeSet();
        double time1 = testSet(bstSet, fileName);
        System.out.println("BST Set: " + time1 + "s.");


        LinkedListSet llSet = new LinkedListSet();
        double time2 = testSet(llSet, fileName);

        System.out.println("LinkedList Set: " + time2 + "s.");
    }
}
