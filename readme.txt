UPDATED VERSION!

To implement a quicksort without use of any other algorithms, I used recursive calls to the private method
quicksort(BinaryTree tree, AnyType [ ] a, int low, int high) alongside a binary tree.
These recursive calls, while the base condition was not reached, implemented RANDOMIZED median-of-three partitioning
and sorted elements at three ranked, but randomized, indices of the array.

After this was completed, I implemented pivot by means of choosing the median element of these randomized indices

I then parsed through the elements on both sides of the pivot--if any elements on the right were smaller than the
pivot (selected by j), I would replace those elements with elements on the left that were bigger than the pivot
(selected by i).

After this process was completed, I considered the array to be successfully partitioned, and continued to make
recursive calls to quicksort until the base case was satisfied--that is, once the size of the subset being
examined was smaller than my chosen cutoff of 10 elements. Each time this base case was satisfied, 
I inserted items of the subset into the tree. I made sure to skip over duplicates while doing this in BinaryTree.java.

Driver: I return the binary tree after performing a quicksort. Execute javac Main.java || java Main to run.


