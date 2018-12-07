package projet;



public class binarySearchTree {

	

	Node root;

	

	//Constructor

	



private boolean empty(Node current)

{

	if (current == null)

	{

		return true;

	}

	else

	{

	return false;

	}

}





private Node insert(Node n, face value)

{

	if (this.empty(n))

	{

		root.current= value;
		root.left = null;
		root.right = null;
		return n;

	}
	else 
	{
		if (value.getX() < n.getX()){

			return insert(n.left, value);

		}
		else if (value.getX() > n.getX()) {

			return insert(n.right, value);

		}
	}

	return n;

}



public boolean search(Node n, face value) 
{

	if (this.empty(n)) {

		return false;

	}

	if ((value.getX() == n.getX()) && (value.getY() == n.getY()))

	{

		return true;

	}

	else

	{

		

	if (value.getX() < n.getX()){

		return search(n.left, value);

	}

	else

	{

		if (value.getX() > n.getX()) {

			return search(n.right, value);

		}

	}

	}

	}	
}
