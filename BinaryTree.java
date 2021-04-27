
/**
 * Stores a binary tree.
 * 
 * Construction:
 * (a) no params
 * (b) an object to be placed in the root of a 1-element tree.
 */
public class BinaryTree<AnyType extends Comparable<? super AnyType>>
{
    
    /**
     * Create an empty Tree.
     */
    public BinaryTree()
        { root = null; }
    public BinaryTree( AnyType rootItem )
        { root = new BinaryNode<AnyType> (rootItem, null, null); }
    
    public BinaryNode<AnyType> getRoot( )
        { return root; }
        
    public void insert( AnyType x )
        { root = insert( x, root ); }
    
    
    public void printTree( )
        { if ( isEmpty() ) 
            System.out.println( "Empty tree" );
        else 
            printTree(root); 
    }
    
        
    public void makeEmpty( )
        { root = null; }
    public boolean isEmpty( )
        { return root == null; }
    
    public void merge ( AnyType rootItem,
                        BinaryTree<AnyType> t1, BinaryTree<AnyType> t2 )
    {
        // check for redundancy
        if (t1.root == t2.root && t1.root != null)
            throw new IllegalArgumentException( );
            
        // Allocate new node
        root = new BinaryNode<AnyType>( rootItem, t1.root, t2.root );
        
        if ( this != t1 )
            t1.root = null;
        if ( this != t2 )
            t2.root = null;
    }
    
    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> insert( AnyType x , BinaryNode<AnyType> t )
    {
        if (t == null)
            return new BinaryNode<>( x, null, null );
        
        int compareResult = x.compareTo( t.element );
            
        if (compareResult < 0)
            t.left = insert( x, t.left );
        else if ( compareResult > 0 )
            t.right = insert( x, t.right );
        else
            ;
        return t;
    }
    
    private static class BinaryNode<AnyType>
    {
        // Constructors
        BinaryNode( AnyType elem )
        { this ( elem, null, null ); }
        
        BinaryNode( AnyType elem, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
        {
            element = elem;
            left = lt;
            right = rt;
        }
        
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
    }
    
    // Inorder print: The left child is recursively processed, the current node is processed,
                // and then the right child is recursively processed. 
    private void printTree( BinaryNode<AnyType> t )
    {
        if (t != null)
        {
            printTree( t.left );
            System.out.println( t.element );
            printTree( t.right );
        }
    }
    // tree root
    private BinaryNode<AnyType> root;
}
