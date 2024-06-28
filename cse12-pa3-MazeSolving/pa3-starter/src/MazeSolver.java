/* Class to implement a Maze solver */

public abstract class MazeSolver {
	
	public static Square solve(Maze maze, SearchWorklist wl) {
		/* Complete this method */
		
		wl.add(maze.start);
		maze.start.visit();
		while (wl.isEmpty() == false) {
			Square current = wl.remove();
			if (current == maze.finish) {
				return current;
			}
			else {
				int NorthRow = -1;
				int NorthCol = 0;
				Square[][] contents1 = maze.contents;
				boolean one = availableNeighbor(contents1, current, NorthRow, NorthCol);
				if (one == true) {
					Square markN = contents1[current.getRow() + NorthRow][current.getCol() + NorthCol];
					markN.visit();
					markN.setPrevious(current);
					wl.add(markN);
				}
				int SouthRow = 1;
				int SouthCol = 0;
				boolean two = availableNeighbor(contents1, current, SouthRow, SouthCol); 
				if ( two == true) {
					Square markS = contents1[current.getRow() + SouthRow][current.getCol() + SouthCol];
					markS.visit();
					markS.setPrevious(current);
					wl.add(markS);
				}
				
				
				int EastRow = 0;
				int EastCol = 1;
				boolean three = availableNeighbor(contents1, current, EastRow, EastCol);
				if ( three == true) {
					Square markE = contents1[current.getRow() + EastRow][current.getCol() + EastCol];
					markE.visit();
					markE.setPrevious(current);
					wl.add(markE);
				}
				int WestRow = 0;
				int WestCol = -1;
				boolean four = availableNeighbor(contents1, current, WestRow, WestCol);
				if ( four == true) {
					Square markW = contents1[current.getRow() + WestRow][current.getCol() + WestCol];
					markW.visit();
					markW.setPrevious(current);
					wl.add(markW);
				}
				if (one && two && three && four == false) {
					return null;
				}
			}
		}
		return null;
	}

	/* Add any helper methods you want */
	private static boolean availableNeighbor(Square[][] contents, Square s, int rowOffset, int colOffset) {
		int row1 = s.getRow();
		int col1 = s.getCol();
		if ((row1 + rowOffset) < contents.length && (row1 + rowOffset) >= 0 && (col1 + colOffset) < contents[0].length && (col1 + colOffset) >= 0) {
			Square toCheck = contents[row1 + rowOffset][col1 + colOffset];
			if ( toCheck.getIsWall() == false && toCheck.isVisited() == false) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}

