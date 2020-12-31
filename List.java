
package NBody2;

public interface List {
	
	public void add(Celestial object);
	
	public void remove(int position);	
	public void pop();
	
	public int size();
	
	public Celestial get(int index);

}
