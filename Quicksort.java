import java.lang.Math;
import java.util.*;

public class Quicksort<AnyType>
{
    /**This version of quicksort will return a sorted Binary Tree
     */
    public static <AnyType extends Comparable<? super AnyType>>
        BinaryTree quicksort( AnyType [ ] a)
        {
            BinaryTree binaryTree = new BinaryTree();
            
            quicksort( binaryTree, a, 0, a.length - 1);
            
            return binaryTree;
        }
    
    // I keep adding elements to my binary tree
    // ... and do this recursively; keep adding elements until only leaves remain, with
    // null left and right nodes.
                                                        
    // Then, the resulting binary tree is printed using a Preorder Traversal, which displays all
    // numbers 1-100 in order.
    
    private static <AnyType extends Comparable<? super AnyType>>
        void quicksort( BinaryTree tree, AnyType [ ] a, int low, int high)
        {
            // Base condition: size of subset is smaller than cutoff of 10 elements.
            if (a.length == 0 || a.length == 1)
                return;
            if ( low + 10 > high ) 
            {
                // place all elements of array a into a binary tree.
                // if pivot < element, element is placed right.
                  // if pivot > element, element is placed left.
                  // Implemented in the BinaryTree class.
                
                for (int i = low; i <= high; i++)
                {
                    tree.insert(a[i]);
                }
            }
            else
            {
                /**
                 * Apr 26, 10:00 AM
                 * Implementation of first turn-in must be improved.
                 * FIXME: 
                 * - use median-of-three partitioning, but with something better.
                 * - Also fix the pivot.
                 * 
                 * So far:
                 * 
                 * CHOOSING A PIVOT
                 * 
                 * Take two averages:
                     * 1 for the first half of array's first and last elements.
                     * 1 for the second half of array's first and last elements.
                 * If either of these averages are between 33 and 66,
                     * this will be the used average.
                 * 
                 * Now, we find the element closest to the average
                 * And temporarily call this the "Somewhere".
                 * 
                 * "Somewhere" has to have a certain number of elements above it ( g )
                 * and below it ( l ).
                 * 
                 * While the absolute value of (elements lower than pivot)
                     * minus (elements greater than pivot) is greater than 1,
                     * 
                     * We advance the position of "Somewhere" by
                     * swapping it with an element from the partition with the higher number of elements,
                     * (higher end for lower partition, lower end for higher partition)
                     * until |l-g| == 1. This is not concerning because we are dealing
                     * with an even number of elements.
                     * 
                     * then "Somewhere" is the pivot.
                 * 
                 * int min = Collections.min(Arrays.asList(a));
                 * int max = Collections.max(Arrays.asList(a));
                 * 
                 * ---------------------------------------------------------------------
                 * 10:37 PM
                 * The plan is now to implement a randomized median-of-three.
                 * That is, select three elements at random and then finally select their
                 * median as a pivot.
                 */
                
                int elem_1 = (int)(Math.random() * (high-low) );
                int elem_2 = (int)(Math.random() * (high-low) );
                int elem_3 = (int)(Math.random() * (high-low) );
                
                // Sorting the first, second, and third random elements.
                if (a[ elem_2 ].compareTo( a[ elem_1 ] ) < 0) 
                    swapReferences( a, elem_1, elem_2 );
                
                if (a[ elem_3 ].compareTo( a[ elem_1 ] ) < 0)
                    swapReferences( a, elem_1, elem_3 );
                
                if (a[ elem_3 ].compareTo ( a[ elem_2 ] ) < 0)
                    swapReferences( a, elem_2, elem_3 );
                
                // selecting the median of the three randoms as a pivot.
                // swapReferences( a, elem_2, high-1 );
                AnyType pivot = a[ elem_2 ];
                
                // Partitioning process.
                int i, j;
                for (i = low, j = high - 1;;)
                {
                    while ( a[++i].compareTo(pivot) < 0)
                        ;
                    while ( pivot.compareTo( a[--j] ) < 0 )
                        ;
                    
                    if (i >= j)
                        break;
                    swapReferences( a, i, j );
                }
                // Restore the pivot to its original position
                swapReferences( a, i, high-1 );
                
                // Recursion.
                quicksort(tree, a, low, i);
                quicksort(tree, a, i, high);
            }
        }
    private static <AnyType> void swapReferences(AnyType[] array, int a, int b)
    {
        AnyType x = array[a];
        array[a] = array[b];
        array[b] = x;
    }
}
