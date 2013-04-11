// Implements a BST with TreeNode nodes.

import java.util.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyTreeSet
/* Extra credit
      implements Iterable
*/
{
  private TreeNode root;  // holds the root of this BST

  // Constructor: creates an empty BST.
  public MyTreeSet()
  {
    root = null;
  }

  // Returns true if this BST contains value; otherwise returns false.
  public boolean contains(Object value)
  {
    return contains(root, value);
  }

  // Adds value to this BST, unless this tree already holds value.
  // Returns true if value has been added; otherwise returns false.
  public boolean add(Object value)
  {
    if (contains(value))
      return false;
    root = add(root, value);
    return true;
  }

  // Removes value from this BST.  Returns true if value has been
  // found and removed; otherwise returns false.
  public boolean remove(Object value)
  {
    if (!contains(value))
      return false;
    root = remove(root, value);
    return true;
  }

  // Returns a string representation of this BST.
  public String toString()
  {
    String str = toString(root);
    if (str.endsWith(", "))
      str = str.substring(0, str.length() - 2);
    return "[" + str + "]";
  }
/* Extra credit
  // Returns an iterator for this BST.
  public Iterator<Object> iterator()
  {
    return new MyTreeSetIterator(root);
  }
*/
  //*************** Private helper methods: *********************

  // Returns true if the BST rooted at node contains value;
  // otherwise returns false (recursive version).
  private boolean contains(TreeNode node, Object value)
  {
    if (node == null)
      return false;
    else
    {
      int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
      if (diff == 0)
        return true;
      else if (diff < 0)
        return contains(node.getLeft(), value);
      else // if (diff > 0)
        return contains(node.getRight(), value);
    }
  }

/*
  // Iterative version:
  private boolean contains(TreeNode node, Object value)
  {
    while (node != null)
    {
      int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
      if (diff == 0)
        return true;
      else if (diff < 0)
        node = node.getLeft();
      else // if (diff > 0)
        node = node.getRight();
    }
    return false;
  }
*/

  // Adds value to the BST rooted at node. Returns the
  // root of the new tree.
  // Precondition: the tree rooted at node does not contain value.
  private TreeNode add(TreeNode node, Object value)
  {
    if (node == null)
      node = new TreeNode(value);
    else
    {
      int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
      if (diff < 0)
        node.setLeft(add(node.getLeft(), value));
      else // if (diff > 0)
        node.setRight(add(node.getRight(), value));
    }
    return node;
  }

  // Removes value from the BST rooted at node.
  // Returns the root of the new tree.
  // Precondition: the tree rooted at node contains value.
  private TreeNode remove(TreeNode node, Object value)
  {
    int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
    if (diff == 0)  // base case
      node = removeRoot(node);
    else if (diff < 0)
      node.setLeft(remove(node.getLeft(), value));
    else // if (diff > 0)
      node.setRight(remove(node.getRight(), value));
    return node;
  }

  // Removes the root of the BST rooted at root
  // replacing it with the smallest node from the right subtree.
  // Returns the root of the new tree.
  private TreeNode removeRoot(TreeNode root)
  {
    ________________________________________
    ...
  }

  // Returns a string representation of the tree rooted at node.
  private String toString(TreeNode node)
  {
    if (node == null)
      return "";
    else
      return toString(node.getLeft()) + node.getValue() + ", " +
                          toString(node.getRight());
  }

/* Extra credit
  // Implements an Iterator for this tree.
  private class MyTreeSetIterator implements Iterator<Object>
  {
    ________________________________________
    ...
  }
*/

  //************************** main: **************************

  public static void main(String[] args)
  {
    String[] words = {"One", "Two", "Three", "Four", "Five",
                      "Six", "Seven", "Eight", "Nine", "Ten"};
    MyTreeSet bst = new MyTreeSet();

    for (String word : words)
    {
      System.out.println("Added: " + word + " " + bst.add(word));
      System.out.println("Contains: " + word + " " + bst.contains(word));
      if(bst.add(word))
        System.out.println("*** Added a duplicate value ***");
      System.out.println(bst);
    }

    System.out.println("Traversal with an iterator:");
    for (Object obj : bst)
      System.out.print(obj + " ");
    System.out.println();

    for (String word : words)
    {
      System.out.println("Removed: " +  word + " " + bst.remove(word));
      if(bst.remove(word))
        System.out.println("*** Removed a non-existent value ***");
      System.out.println(bst);
    }
  }
}
