import java.util.ArrayList;


/*
 * Write your JUnit tests here
 * Use the formatMaze() method to get nicer JUnit output
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSolvers {

	/* Helper method to compare two mazes */
	public void checkMaze(SearchWorklist wl, Maze startMaze, String[] expected) {
		Square s = MazeSolver.solve(startMaze, wl);
		if(expected == null) { assertNull(s); }
		else {
			ArrayList<Square> sp = startMaze.storePath();
			String actualStr = formatMaze(startMaze.showSolution(sp));
			String expectedStr = formatMaze(expected);
			assertEquals(expectedStr, actualStr);
		}
	}	

	/* Helper method to format String[] output as String */
	public String formatMaze(String[] arr) {
		String result = "";
		for (String s: arr)
			result += "\n"+s;
		return (result+"\n");
	}

	/* Add your own Worklist tests below */

	/* ************** HINT ******************** 
	 * Use the helper methods to create simple
	 * tests that are easier to debug. 
	 */
	
	
	@Test 
	public void emptyTest() {
		SearchWorklist wl1 =  new StackWorklist();
		assertEquals(true, wl1.isEmpty());
		
		
		
	}
	@Test 
	public void removeTest() {
		SearchWorklist wl2 =  new StackWorklist();
		Square square = new Square(1,2, false);
		wl2.add(square);
		assertEquals(square, wl2.remove());
	}
	
	@Test 
	public void remove1Test() {
		SearchWorklist wl2 =  new StackWorklist();
		Square square = new Square(1,2, false);
		Square square1 = new Square(2,2, false);
		Square square2 = new Square(3,2, false);
		wl2.add(square);
		wl2.add(square1);
		wl2.add(square2);
		assertEquals(square2, wl2.remove());
	}
	
	 
	@Test
	public void MazeTests() {
		SearchWorklist wl3 =  new StackWorklist();
		Maze m1 = new Maze(new String[] {
	            "#___",
	            "__F_",
	            "S##_",
	            "____"
	        });
		/*String[] sol1 = new String[] { 
				"#___",
	            "__F*",
	            "S##*",
	            "****" 
			};*/
		Square result = MazeSolver.solve(m1, wl3);
		Square expected = new Square(1,2, false);
		Square finish1 = m1.finish;
		//expected.visit();
		assertEquals(finish1, result);
		
	}
	@Test
	public void storeTest() {
		Maze maze1 = new Maze(new String[] {
	            "#___",
	            "_#F_",
	            "S###",
	            "____"
	        });
		ArrayList<Square> test = maze1.storePath();
		ArrayList<Square> testing = new ArrayList<>();
		assertEquals(testing, test);
	}
	@Test
	public void MazeTests1() {
		SearchWorklist wl4 =  new StackWorklist();
		Maze m2 = new Maze(new String[] {
            "#___",
            "__F_",
            "S##_",
            "____"
        });
		String[] sol1 = new String[] { 
			"#___",
            "__F*",
            "S##*",
            "****" 
		};
		checkMaze(wl4, m2, sol1);
	}
	@Test
	public void MazeTests2() {
		SearchWorklist wl5 =  new StackWorklist();
		Maze m3 = new Maze(new String[] {
            "#___",
            "##F#",
            "S##_",
            "____"
        });
		String[] sol2 = new String[] { 
			"#___",
            "##F#",
            "S##_",
            "____" 
		};
		checkMaze(wl5, m3, sol2);
	}
	@Test
	public void MazeTests3() {
		SearchWorklist wl4 =  new QueueWorklist();
		Maze m2 = new Maze(new String[] {
            "#___",
            "__F_",
            "S##_",
            "____"
        });
		String[] sol1 = new String[] { 
			"#___",
            "**F_",
            "S##_",
            "____" 
		};
		checkMaze(wl4, m2, sol1);
	}
	@Test
	public void MazeTests4() {
		SearchWorklist wl5 =  new QueueWorklist();
		Maze m3 = new Maze(new String[] {
            "#___",
            "##F#",
            "S##_",
            "____"
        });
		String[] sol2 = new String[] { 
			"#___",
            "##F#",
            "S##_",
            "____" 
		};
		checkMaze(wl5, m3, sol2);
	}
	
	@Test
	public void MazeTests5() {
		SearchWorklist wl5 =  new StackWorklist();
		Maze m3 = new Maze(new String[] {
            "S___",
            "_##_",
            "_##_",
            "___F"
        });
		String[] sol2 = new String[] { 
			"S***",
            "_##*",
            "_##*",
            "___F" 
		};
		checkMaze(wl5, m3, sol2);
	}
	
	@Test
	public void MazeTests6() {
		SearchWorklist wl5 =  new QueueWorklist();
		Maze m3 = new Maze(new String[] {
            "S___",
            "_##_",
            "_##_",
            "___F"
        });
		String[] sol2 = new String[] { 
			"S___",
            "*##_",
            "*##_",
            "***F" 
		};
		checkMaze(wl5, m3, sol2);
	}
	
	@Test
	public void MazeTests7() {
		SearchWorklist wl5 =  new StackWorklist();
		SearchWorklist wl6 =  new QueueWorklist();
		Maze m3 = new Maze(new String[] {
            "SF__",
            "_##_",
            "_##_",
            "____"
        });
		String[] sol2 = new String[] { 
			"SF__",
            "_##_",
            "_##_",
            "____" 
		};
		checkMaze(wl5, m3, sol2);
		checkMaze(wl6, m3, sol2);
	}
	
	@Test
	public void MazeTests8() {
		SearchWorklist wl5 =  new StackWorklist();
		SearchWorklist wl6 =  new QueueWorklist();
		Maze m3 = new Maze(new String[] {
            "S___",
            "_##_",
            "F##_",
            "____"
        });
		String[] sol2 = new String[] { 
			"S___",
            "*##_",
            "F##_",
            "____" 
		};
		String[] sol3 = new String[] { 
				"S***",
	            "_##*",
	            "F##*",
	            "****" 
			};
		//checkMaze(wl6, m3, sol2);
		checkMaze(wl5, m3, sol3);
	}

}
	




