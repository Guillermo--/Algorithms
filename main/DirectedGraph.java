import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class DirectedGraph {

	public List<Node> adjacency;
	
	class Node {
		public Comparable element;
		public List<Node> children = new ArrayList<>();
	}
	
	public DirectedGraph() {
		this.adjacency = new ArrayList<>();
	}
	
	public void insert(Comparable source, Comparable dest) {
		
	}
}
