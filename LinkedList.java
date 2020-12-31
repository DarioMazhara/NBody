package NBody2;

class LinkedList implements List {
	Node root;
	
	public class Node {
		Celestial object;
		Node next;
		
		public Node(Celestial object) {
			next = null;
			this.object = object;
		}
		
	}
	
	public LinkedList() {
		root = new Node(null);
	}
	

	@Override
	public void add(Celestial object) {
		if (root == null)
			root = new Node(null);
		
		Node copy = root;
		
		while (copy.next != null) {
			copy = copy.next;
		}
		copy.next = new Node(object);
		
	}



	@Override
	public void remove(int position) {
		Node copy = root;
		
		for (int i = 0; i < position - 1; i++) {
			copy = copy.next;
		}
		
		Node save = copy.next.next;
		copy.next = save;
	}

	@Override
	public void pop() {
		// TODO Auto-generated method stub
		Node copy = root;
		
		while (copy.next != null) {
			copy = copy.next;
		}
		copy = null;
	}
	
	@Override
	public int size() {
		int size = 0;
		
		Node copy = root;
		
		while (copy.next != null)
			size++;
		return size;
	}

	public Celestial get(int position) {
		System.out.println("get");
		if (root == null)
			return null;
		
		Node copy = root;
		for (int i = 0; i < position; i++) {
			copy = copy.next;
		} 
		
		return copy.object;
	}
	
}
