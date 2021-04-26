import java.lang.Math;
import java.util.Arrays;
import java.util.Collections;

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
                 * FIXME: 
                 * - don't use median-of-three partitioning. something better.
                 * - Also fix the pivot.
                 * - Fix the algo so the array stores all elems of the tree.
                 * 
                 * So far:
                 * 
                 * CHOOSING A PIVOT
                 * 
                 * Take two averages:
                     * 1 for the first half of array
                     * 1 for the second half of array
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
                 * 
                 * int min = Collections.min(Arrays.asList(a));
                 * int max = Collections.max(Arrays.asList(a));
                 */
                // Sort low, middle, high--by median-of-three partitioning.
                int middle = (low + high) / 2;
                if ( a[ middle ].compareTo( a[ low ] ) < 0 )
                    swapReferences( a, low, middle );
                if ( a[ high ].compareTo( a[ low ] ) < 0 )
                    swapReferences( a, low, high );
                if ( a[ high ].compareTo( a[ middle ] ) < 0 )
                    swapReferences( a, middle, high );
                
                
                AnyType pivot = a[ middle ];
                
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
                // Restore pivot
                swapReferences( a,i,high-1 );
                
                // Recursion.
                quicksort(tree, a, low, i);
                quicksort(tree, a, i, high);
            }
        }
    // might return an int to get the new value of p
    /**
     * The first param is what we are watching.
     */
    private static <AnyType> void swapReferences(AnyType[] array, int a, int b)
    {
        AnyType x = array[a];
        array[a] = array[b];
        array[b] = x;
    }
}
