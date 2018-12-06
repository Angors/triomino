package projet;

public class Node {



	face current;

	Node right;

	Node left;



	//Constructor

	public Node(face c)

	{

		this.current = c;

		right = null;

		left = null;

	}

	

public int getX() {

	return this.current.getX();

}



public int getY() {

	return this.current.getY();

}



}
