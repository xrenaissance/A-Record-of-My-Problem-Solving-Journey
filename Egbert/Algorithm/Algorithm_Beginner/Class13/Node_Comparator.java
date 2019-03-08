class Node {
	int value;
	public Node(int v) {
		value = v;
	}
}

class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
    if (o1.value == o2.value) return 0;
    return o1.value < o2.value ? -1 : 1;
	}
}
