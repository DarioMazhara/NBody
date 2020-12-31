package NBody2;

import java.util.ArrayList;
import java.util.Arrays;

class ArrayListCustom implements List {
	ArrayList<Celestial> bodies;
	


	public ArrayListCustom() {
		bodies = new ArrayList();
	}
	
	


	@Override
	public void remove(int position) {
		// TODO Auto-generated method stub
		bodies.remove(position);
	}


	@Override
	public void pop() {
		// TODO Auto-generated method stub
		bodies.remove(bodies.size()-1);
	}


	@Override
	public void add(Celestial body) {
		// TODO Auto-generated method stub
		bodies.add(body);
	}
	
	@Override
	public int size() {
		return bodies.size();
	}



	public Celestial get(int index) {
		// TODO Auto-generated method stub
		return bodies.get(index);
	}
}
