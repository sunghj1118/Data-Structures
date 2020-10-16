/*
 * Name: Hyun Joon Sung
 * Student ID #: 2019147593
 */

/* 
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class Set implements ISet {
    /*
     * Add some variables you will use.
     */
    private int[] myset;
    private int entries = 0;

    public Set() {
        /*
         * Constructor This function is an initializer for this class.
         */
        myset = new int[10];
    }

    @Override
    public void insert(int value) {
        /*
         * Function input: + value: An integer to be inserted.
         * 
         * Job: Insert the integer if it does not exist.
         */
        boolean exists = false;
        for (int i = 0; i < entries; i++) {
            if (myset[i] == value) {
                exists = true;
            }
        }
        if (exists == false) {
            entries++;
            myset[entries - 1] = value;
        }
    }

    @Override
    public void delete(int value) throws IllegalStateException {
        /**
         * Function input: + value: An integer to be deleted
         * 
         * Job: Delete the integer from the set. Raise an exception if it does not
         * exist.
         */
        boolean exists = false;
        int index = 0;
        for (int i = 0; i < entries; i++) {
            if (myset[i] == value) {
                exists = true;
                index = i;
            }
        }
        if (exists == false) {
            throw new IllegalStateException("Object to delete doesn't exist");
        } else {
            for (int i = index; i < entries - 1; i++) {
                myset[i] = myset[i + 1];
            }
            entries--;
        }
    }

    @Override
    public void union(ISet set) {
        /**
         * Function input: + set: A set to be unioned
         * 
         * Job: Union the other set to this set
         */
        int[] comparingset = set.show();
        int[] temp = new int[10];
        int tcounter = 0;
        for (int i = 0; i < myset.length; i++) {
            for (int j = 0; j < comparingset.length; j++)
                if (myset[i] == comparingset[j]) {
                    temp[tcounter] = myset[i];
                    tcounter++;
                }
        }
        for (int i = 0; i < tcounter; i++) {
            myset[i] = temp[i];
        }
    }

    @Override
    public void intersection(ISet set) {
        /**
         * Function input: + set: A set to be intersectioned
         * 
         * Job: Intersect the other set to this set
         */
    }

    @Override
    public void subtraction(ISet set) {
        /**
         * Function input: + set: A set to be subtracted
         * 
         * Job: Subtract the other set from this set
         */
    }

    @Override
    public int[] show() {
        /**
         * Function input: Nothing
         * 
         * Job: Return the elements of the set as an array.
         */
        int[] array = new int[entries];
        for (int i = 0; i < entries; i++) {
            array[i] = myset[i];

        }
        return array;
    }
}
