/*
 * Name: Hyun Joon Sung
 * Student ID #: 2019147593
 */

/* 
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class CDLList implements ICDLList {
    private Node head;
    /*
     * Add some variables you will use.
     */
    private Node list;
    int count;

    public CDLList() {
        /*
         * Constructor 
         * This function is an initializer for this class.
         */
        count = 0;
    }

    @Override
    public void insert(int value) {
        /*
         * Function input:
         *  + value: An integer to be inserted.
         * 
         * Job:
         *  Insert the given integer to the list.
         */
        Node newnode = new Node(value);

        if (count == 0 ){
            list = newnode;
            list.next = list;
            list.prev = list;
            head = list;
        }
        else {
            newnode.prev = list.prev;
            newnode.next = list;
            list.prev.next = newnode;
            list.prev = newnode;
            
            head = list;
        }
        count++;
    }

    @Override
    public void delete() throws IllegalStateException {
        /*
         * Function input: Nothing
         * 
         * Job:
         *  Delete the previous node of the head.
         */
        
        if(count == 0) {
            throw new IllegalStateException("[THE LIST IS EMPTY!!!!!!!!!]");
        }
        else {
            //reach last node
            Node current = head;
            while(current.next != head) {
                current = current.next;
            }
            
            //change links of the last node
            current.prev.next = head;
            head.prev = current.prev;
            current = null;
            count--;
        }
    }

    @Override
    public Node getHead() throws IllegalStateException {
        /*
         * Function input: Nothing
         * 
         * Job:
         *  return the reference of the head. If none, raise an exception.
         */
        if(count == 0) {
            throw new IllegalStateException("[THE LIST IS EMPTY!!!!!!!!!]");
        }
        else {
            return head;
        }
    }

    @Override
    public void rotateForward() throws IllegalStateException {
        /*
         * Function input: Nothing
         * 
         * Job:
         *  Rotate the list forward. If none, raise an exception.
         */
        if(count == 0) {
            throw new IllegalStateException("[THE LIST IS EMPTY!!!!!!!!!]");
        }
        else {
            head = head.next;
        }
    }

    @Override
    public void rotateBackward() throws IllegalStateException {
        /*
         * Function input: Nothing
         * 
         * Job:
         *  Rotate the list backward. If none, raise an exception.
         */
        if(count == 0) {
            throw new IllegalStateException("[THE LIST IS EMPTY!!!!!!!!!]");
        }
        else {
            head = head.prev;
        }
    }

    @Override
    public int size() {
        /*
         * Function input: Nothing
         * 
         * Job:
         *  Return the size of the list
         */
        return count;
    }

    @Override
    public boolean isEmpty() {
        /* You do not have to edit this function. */
        return size() == 0;
    }
}
