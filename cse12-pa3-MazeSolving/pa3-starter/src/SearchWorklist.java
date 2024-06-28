import java.util.ArrayList;
/*
 * Class to implement SearchWorklist as a Stack and a Queue.
 * You can use any built-in Java collections for this class.
 */

class StackWorklist implements SearchWorklist {
	ArrayList<Square> contents;
	
	public StackWorklist() {
		this.contents = new ArrayList<Square>();
	}
	
	public void add(Square c) {
		this.contents.add(c);
	}
	
	public Square remove() {
		Square ss1 = this.contents.remove(this.contents.size() - 1);
		return ss1;
	}
	
	public boolean isEmpty() {
		if (this.contents.size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}		

class QueueWorklist implements SearchWorklist {
	ArrayList<Square> contents;
	
	public QueueWorklist() {
		this.contents = new ArrayList<Square>();
	}
	
	public void add(Square c) {
		this.contents.add(c);
	}
	
	public Square remove() {
		Square s1 = this.contents.remove(0);
		return s1;
	}
	
	public boolean isEmpty() {
		if (this.contents.size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}

public interface SearchWorklist {
	void add(Square c);
	Square remove();
	boolean isEmpty();
}
