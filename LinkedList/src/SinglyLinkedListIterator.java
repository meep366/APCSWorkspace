// Implements an iterator for a SinglyLinkedList.

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedListIterator implements Iterator<Object>
{
  private ListNode nextNode;

  // Constructor
  public SinglyLinkedListIterator(ListNode head)
  {
    nextNode = head;
  }

  public boolean hasNext()
  {
    return nextNode != null;
  }

  public Object next()
  {
    if (nextNode == null)
      throw new NoSuchElementException();

    Object value = nextNode.getValue();
    nextNode = nextNode.getNext();
    return value;
  }

  // Not implemented.
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}
