package projet;

//package structures_de_donnees;
import java.util.LinkedList;

public class ABR {
	
	//VARIABLES D'INSTANCE
	public int nbTrio;
	private face key;
	private LinkedList values;
	private ABR filsG;
	private ABR filsD;
	
	
	//CONSTRUCTEUR
	ABR () {
		this.nbTrio = 0;
		this.key = null;
		this.values = null;
		this.filsG = null;
		this.filsD = null;
	}
	
	//GETTERS
	public face getKey () {
		return this.key;
	}
	
	public ABR getFilsG () {
		return this.filsG;
	}
	
	public ABR getFilsD () {
		return this.filsD;
	}
	
	//METHODES D'INSTANCE
	
	//Retourne 1 si l'ABR est vide et 0 sinon
	private boolean isEmpty () {
		return this.key == null;
	}
	
	//Construit un ABR vide
	
	private ABR vide() {
		ABR A=new ABR();
		return A;
		
	}
	//Construit un ABR en initialisant ses parametres 
	private ABR Cons (face K, ABR G, ABR D) {
	   // ABR A= new ABR();
		this.key=K;
		this.filsG=G;
		this.filsD=D;
		//System.out.printf(this.getKey()[0]+" "+this.getKey()[1]+" "+this.getKey()[2]/*+" "+this.getFilsG().getKey()+" "+this.getFilsD().getKey()*/+"|    ");
		return this;
	}
	
	
	//Recherche d'un element dans l'arbre boolean
	public boolean contains(face key) {
		ABR B=this;
		while (!(B.equalsABR()) && !(B.equalsT(key.getX(), B.getKey().getX()))) {
			if (superior(B.getKey().getX(),key.getX())) {
				B=B.getFilsG();
			}
			else {
				B=B.getFilsD();
			}
			
		}
		if(B.equalsABR()) {
			return false;
		}
		else {
			return true;
		}
	}

	
	
	//Recherche d'un element dans l'arbre
	public face find(face key) {
		ABR B=this;
		while (!(B.equalsABR()) && !(B.equalsT(key.getX(), B.getKey().getX()))) {
			if (superior(B.getKey().getX(),key.getX())) {
				B=B.getFilsG();
			}
			else {
				B=B.getFilsD();
			}
			
		}
		if(B.equalsABR()) {
			return B.getKey();
		}
		face nul = new face(-1,-1);
		return nul;
	}
	
	
	//Ajoute un element a l'ABR
	
		public ABR add (face key) {
		if(this.isEmpty()) {
			return this.Cons(key, this.vide(),this.vide());
		}
		else {
			if (superior(this.getKey().getX(),key.getX())) {
				//System.out.printf("      gauche:");
				return(this.Cons(this.getKey(),this.getFilsG().add(key),this.getFilsD()));
			}
			else {
				if(superior(key.getX(),this.getKey().getX())) {
					//System.out.printf("     droite:");
				face K= key;
				return this.Cons(this.getKey(),this.getFilsG(),this.getFilsD().add(K));
				}
				else {
					this.nbTrio +=1;
					return (this);
				}
			}
		}
		
	}
	
	/////////////////////////suppr_max///////////////////////////////////
	private ABR Suppr_max() {
		if (this.getFilsD().isEmpty()) {
			return this.getFilsG();
		}
		else {return this.Cons(this.getKey(), this.getFilsG(), this.getFilsD().Suppr_max());}
	}
	
	//retourne le plus grand element d'un arbre
	private face Max() {
		if (this.getFilsD().isEmpty()) {
			return this.getKey();
		}
		else {return this.getFilsD().Max();}
	}
	
	//Supprime l'element avec la cle entree en parametre
	ABR remove (face key) {
		if (this.isEmpty()) {
			return this;
		}
		else {
			if(superior(this.getKey().getX(),key.getX())) {
				return (this.Cons(this.getKey(),this.getFilsG().remove(key),this.getFilsD()));
			}
			else {
				if (superior(key.getX(),this.getKey().getX())) {
				return this.Cons(this.getKey(), this.getFilsG(), this.getFilsD().remove(key));
				}
				else {
				if (this.getFilsG().isEmpty()) {
					return this.getFilsD();
				}
				else {
					if (this.getFilsD().isEmpty()) {
						return this.getFilsG();
					}
					else {
						return this.Cons(this.getFilsG().Max(), this.getFilsG().Suppr_max(),this.getFilsD());
					}
				}
			}
		}
	}
	}
	
	
	//Fonction renvoyant 1 si la cle tab1 est superieure a la cle tab2
	private boolean superior (int i, int j) {
		if (i>j) {
			return true;
		}
		else {
			if (i<j) {
				return false;
			}
			else {
				if (i>j) {
					return true;
				}
				else {
					if (i<j) {
						return false ;
					}
					else {
						if (i>j) {
							return true;
						}
						else {
							return false;
						}
					}
				}
			}
		}
	}

	//Permet de tester l'egalite entre deux cles
	boolean equalsT (int i, int j) {
		if (i==j && i==j && i==j) {
			return true;
		}
		else return false;
	}

	//permet de tester si chaque element de la clef est egal � la valeur passee en parametre 
	boolean equals (Integer[] key, Integer I) {
		if (key[0]==I && key[1]==I && key[2]==I) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//permet de tester si la clef d'un ABR est null
	boolean equalsABR () {
		if (this.getKey()==null) {
			return true;
		}
		else return false;
	}

	//Copie le tabeau a dans b
	/*Integer [] affect(Integer[] a, Integer[]b) {
		a[0]=b[0];
		a[1]=b[1];
		a[2]=b[2];
		return a;
	
	}*/
	
	public int key_face (face key)
	{
		if (this.contains(key))
		{
			return find(key).key;
		} else {
		
		return (Integer) null;
		}
	}	
	
}