package projet;

public class face {

	int face[];
	int coordx;
	int coordy;
	String name;
	int key;
	
	// Constructeur 
	
	public face(int x, int y)
	{
		face = new int[2];
		face[0]=x;
		face[1]=y;
	}
	
	public int getX() {
		return this.face[0];
	}

	public int getY() {
		return this.face[1];
	}
	
	public void get_Valeur()
	{
			System.out.print("("+this.face[0]+","+this.face[1]+")");
	}

	public int get_coordx()
	{
		return this.coordx;
	}
	
	public int get_coordy()
	{
		return this.coordy;
	}

	public void set_coordx(int n)
	{
		this.coordx = n;
	}
	
	public void set_coordy(int n)
	{
		this.coordy = n;
	}

	public void set_name(String name)
	{
		this.name = name;
	}
	
	public int get_Key_face()
	{
		return this.key;
	}

	public int compareTo(face b) {
		// TODO Auto-generated method stub
		return 0;
	}
}



