// END: sort a randomly permuted input of numbers from 1 to 100.

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        // Place numbers 1-100 in random order.
        
        Integer[] unsorted = new Integer[100];

        HashSet<Integer> used = new HashSet<Integer>();
        for (int i = 0; i < 100; i++) 
        {
            int add = (int)(Math.random() * 100) + 1;
            
            while (used.contains(add))
            {
                add = (int) (Math.random() * 100) + 1;
            }

            used.add(add);
            unsorted[i] = add;
            System.out.print(unsorted[i] + " ");
        }
        // 5 31 7 96 58 47 22 16 21 29
        // Place the elements of unsorted into a tree.
        Quicksort q = new Quicksort();
        BinaryTree tree = Quicksort.<Integer>quicksort(unsorted);
        
        tree.printTree();
    }
}
