/*
 * Name: Hyun Joon Sung
 * Student ID #: 2019147593
 */

/* 
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class TourSolver implements ITourSolver {
	/*
	 * Add some variables you will use.
	 */

	@Override
	public int[] solve(Board board) {
		/*
		 * Function input: + board: A board with some missing squares.
		 *
		 * Job: Return a seqence of knight's tour solution on the given board. If there
		 * is no solution, return an empty sequence.
		 */
		// variables to be used
		int[] empty = { 0 };
		int[] sequence = new int[board.getWidth() * board.getHeight()];
		// possible movement
		int xchange[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int ychange[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
		int[][] solution = new int[board.getWidth()][board.getHeight()];

		// initialize solution key
		for (int x = 0; x < board.getWidth(); x++)
			for (int y = 0; y < board.getHeight(); y++)
				if(board.isMissing(x, y)) {
					solution[x][y] = 0;
				}
				else {
					solution[x][y] = -1;
				}
		
		// start at [0][0]
		solution[0][0] = -1;

		// if the recursion works until the end then it will return the sequence
		// else, it will return an empty array
		if (!solver(0, 0, 1, solution, xchange, ychange, board, sequence)) {
			return empty;
		} else {
			return sequence;
		}
	}
	
	
	static void printSolution(int sol[][], Board board) { 
        for (int x = 0; x < board.getWidth(); x++) { 
            for (int y = 0; y < board.getHeight(); y++) 
                System.out.print(sol[x][y] + " "); 
            System.out.println(); 
        } 
    }

	// check if move is possible
	static boolean isPos(int x, int y, int sol[][], Board board) {
		return (x >= 0 && x < board.getWidth() && y >= 0 && y < board.getHeight() && sol[x][y] == -1
				&& !board.isMissing(x, y));
	}

	public boolean solver(int x, int y, int movei, int solution[][], int xchange[], int ychange[], Board board,
			int sequence[]) {
		int k, next_x, next_y;
		
		// if it checks all the possible squares excluding the missing
		if (movei == (board.getHeight() * board.getWidth()) + 1)
			return true;

		/*
		 * Try all next moves from the current coordinate x, y
		 */
		for (k = 0; k < 8; k++) {
			next_x = x + xchange[k];
			next_y = y + ychange[k];
			if (isPos(next_x, next_y, solution, board)) {
				solution[next_x][next_y] = movei;
				sequence[movei - 1] = board.squareId(next_x, next_y);
				if (solver(next_x, next_y, movei + 1, solution, xchange, ychange, board, sequence))
					return true;
				else {
					solution[next_x][next_y] = -1;// backtracking
					sequence[movei - 1] = 0;
				}
			}
		}
		return false;
	}
}
