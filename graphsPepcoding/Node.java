package graphsPepcoding;

class Node implements Comparable<Node> {
	int value;
	int weight;

	public Node(int value, int weight) {
		super();
		this.value = value;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}

}