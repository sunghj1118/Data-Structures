/*
 * Name: Hyun Joon Sung
 * Student ID #: 2019147593
 */

/* 
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class RRScheduler implements IRRScheduler {
    /*
     * Add some variables you will use.
     */
	
	private boolean direction = true;
	private CDLList list = new CDLList();
	
    @Override
    public void insert(int id) {
        /*
        * Function input:
        *  + id: the job id to insert
        *
        * Job:
        *  Insert the job at the back of the scheduler.
        */
    	
    	list.insert(id);
    	
    }

    @Override
    public void done() {
        /*
        * Function input: Nothing
        *
        * Job:
        *  One time segment passes and the job processed is deleted
        */
    	if (direction) {	
    		if(!list.isEmpty()) {
    			list.rotateForward();
    		}
	    	if(!list.isEmpty()) {
	    		list.delete();
	    	}    		
	    }
	    else {
	    	if(!list.isEmpty()) {
	    		list.rotateForward();
	    	}
	    	if(!list.isEmpty()) {
	    		list.delete();
	    	}
	    	if(!list.isEmpty()) {
	    		list.rotateBackward();	
	    	}
	    }
    }

    @Override
    public void timeflow(int n) {
        /*
        * Function input:
        *  + n: An integer.
        *
        * Job:
        *  Simulate n time segments.
        */
    	for(int i = 0; i < n; i++) {
    		done();
    	}
    }

    @Override
    public void changeDirection() {
        /*
        * Function input: Nothing
        *
        * Job:
        *  Change the direction of the scheduler.
        */
    	if (direction) {
    		direction = false;
    	}
    	else {
    		direction = true;
    	}
    }

    @Override
    public int currentJob() throws IllegalStateException {
        /*
        * Function input: Nothing
        *
        * Job:
        *  Return the current job.
        */

   		return list.getHead().getValue();

    }
}
