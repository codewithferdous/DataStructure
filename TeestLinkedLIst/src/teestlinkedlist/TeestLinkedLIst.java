/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package teestlinkedlist;

/**
 *
 * @author WALEED TRADERS
 */
public class TeestLinkedLIst
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        CircularLinkedList<String> f = new CircularLinkedList<String>();
        f.insertAtStart("A");
        f.insertAtEnd("B");
        f.insertAtStart("C");
        f.insertAtEnd("D");
        f.deleteAtStart();
        f.deleteAtEnd();
        f.trevers();
    }

}

class SingleLinkedList<F>
{

    Node start = null;

    class Node
    {

        F num;
        Node next;
    }

    public boolean isEmpty()
    {
        if (start == null)
        {
            return true;
        } else
        {
            return false;
        }
    }

    public void insertAtTheEnd(F key)
    {
        Node newElement = new Node();
        newElement.num = key;
        newElement.next = null;
        if (start == null)
        {
            start = newElement;
        } else
        {
            Node temp = start;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newElement;
        }
    }

    public void treverse()
    {
        if (isEmpty())
        {
            System.out.println("LInkedList is Empty");
        } else
        {
            Node temp = start;
            while (temp != null)
            {
                System.out.print(temp.num + " -> ");
                temp = temp.next;
            }
            System.out.print("NULL");
            System.out.println("");
        }
    }

    public void InsertAtTheFirst(F key)
    {
        Node newnode = new Node();
        newnode.num = key;
        newnode.next = start;
        start = newnode;

    }

    public boolean search(F key)
    {
        if (isEmpty())
        {
            return false;
        } else
        {
            Node temp = start;
            while (temp != null)
            {
                if (temp.num == key)
                {
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }
    }

    public F DeleteAtTheFirst()
    {
        Node temp = start;
        start = start.next;
        return temp.num;

    }

    public F DeleteAtTheEnd()
    {
        Node temp = start, temp2 = null;
        while (temp.next != null)
        {
            temp2 = temp;
            temp = temp.next;
        }
        temp2.next = null;
        return temp.num;
    }

}

class CircularLinkedList<F>
{

    Node start = null;

    class Node
    {

        Node pri;
        F data;
        Node next;

        public Node(F data)
        {
            this.data = data;
        }

    }

    public boolean isEmpty()
    {
        if (start == null)
        {
            return true;
        }
        return false;
    }

    public void trevers()
    {

        if (isEmpty())
        {
            return;
        }
        Node t = start;
        do
        {
            System.out.print(t.data + " <->");
            t = t.next;
        } while (t != start);
    }

    public void insertAtStart(F val)
    {
        Node newNode = new Node(val);

        if (isEmpty())
        {
            newNode.next = newNode.pri = newNode;
            start = newNode;
        } else
        {
            newNode.next = start;
            newNode.pri = start.pri;
            start.pri.next = newNode;
            start.pri = newNode;
            start = newNode;

        }
    }

    public void insertAtEnd(F val)
    {
        Node newNode = new Node(val);
        if (isEmpty())
        {
            newNode.next = newNode.pri = newNode;
            start = newNode;
        } else
        {
            newNode.next = start;
            newNode.pri = start.pri;
            start.pri.next = newNode;
            start.pri = newNode;
        }
    }

    public F deleteAtStart()
    {
        if (isEmpty())
        {
            System.out.println("LISt is empty");
            return null;
        } else if (start.next == start.pri)
        {
            F data = start.data;
            start = null;
            return data;
        } else
        {
            F data = start.data;
            start.next.pri = start.pri;
            start.pri.next = start.next;
            start = start.next;
            return data;
        }
    }

    public F deleteAtEnd()
    {
        if (isEmpty())
        {
            System.out.println("LISt is empty");
            return null;
        } else if (start.next == start.pri)
        {
            F data = start.data;
            start = null;
            return data;
        } else
        {
            F data = start.pri.data;
            start.pri.pri.next = start;
            start.pri = start.pri.pri;

            return data;
        }
    }

}

class DoubleLinkedList<F>
{

    Node start = null;
    Node end = null;

    class Node
    {

        Node pri;
        F data;
        Node next;

        public Node(F data)
        {
            this.data = data;
        }

    }

    public boolean isEmpty()
    {
        if (start == null)
        {
            return true;
        }
        return false;
    }

    public void trevers()
    {
        Node temp = start;
        while (temp != null)
        {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.print("NULL");
    }

    public void insertAtStart(F val)
    {
        Node newNode = new Node(val);
        newNode.pri = null;
        if (isEmpty())
        {
            newNode.next = null;
            start = end = newNode;
        } else
        {
            newNode.next = start;
            start.pri = newNode;
            start = newNode;
        }
    }

    public void insertAtEnd(F val)
    {
        Node newNode = new Node(val);
        newNode.next = null;
        if (isEmpty())
        {
            newNode.pri = null;
            start = end = newNode;
        } else
        {
            newNode.pri = end;
            end.next = newNode;
            end = newNode;
        }
    }

    public F deleteAtStart()
    {
        if (isEmpty())
        {
            System.out.println("LISt is empty");
            return null;
        } else if (start.next == null)
        {
            F data = start.data;
            start = end = null;
            return data;
        } else
        {
            F data = start.data;
            start.next.pri = null;
            start = start.next;
            return data;
        }
    }

    public F deleteAtEnd()
    {
        if (isEmpty())
        {
            System.out.println("LISt is empty");
            return null;
        } else if (start.next == null)
        {
            F data = end.data;
            start = end = null;
            return data;
        } else
        {
            F data = end.data;
            end.pri.next = null;
            end = end.pri;
            return data;
        }
    }

}
