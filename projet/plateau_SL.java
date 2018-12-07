package projet;

import java.util.Scanner;

public class plateau_SL {
// Classe concernant le plateau de jeu
// Note : Avec une SkipList
	
	triomino[][] plat; // Tableau de triomino en deux dimensions.
	int ligne;         // Peut contenir jusqu'a 30 pieces
	int colonne;  
	SkipList cote_libre;
	
	// Constructeur
	public plateau_SL(int rempli) {
		
		ligne = 28;
		colonne = 28;
		plat = new triomino[ligne][colonne];
		
		cote_libre = new SkipList();

			for (int u = 0; u <= 27; u++)
			{
				for (int t = 0; t <= 27; t++)
				{
					// Chaque case u.u est un triomino au valeurs (-1,-1,-1)
					plat[u][t] = new triomino();
		
				}
			}
			// On choisit alors un plateau rempli. Donc on fait appel a SaisiePlateau() n fois
		
	}
	
	public plateau_SL()
	{
		ligne = 28;
		colonne = 28;
		plat = new triomino[ligne][colonne];
		
		cote_libre = new SkipList();

			for (int u = 0; u <= 27; u++)
			{
				for (int t = 0; t <= 27; t++)
				{
					// Chaque case u.u est un triomino au valeurs (-1,-1,-1)
					plat[u][t] = new triomino();
		
				}
			}
	}
	// Accesseur
	public int getLigne()
	{
		return this.ligne;	
	}
	
	public int getColonne()
	{
		return this.colonne;
	}
	
	// Méthodes
	
	public void SaisiePlateau_test(int x, int y, int z, int coordx, int coordy, int compt, int compt2, int compt3)
	{
		
			// Saisie du triomino
	
			triomino t = new triomino(x,y,z);	
			
			// Saisie des coordonnées 
		
		if (this.plat[coordx][coordy].ne.getX() == -1)
		{
			// On ajoute ce triomino
			this.plat[coordx][coordy] = t;

			// On verifie si ses cotes sont libres et qu'ils ne dépassent pas notre plateau
			if (this.plat[coordx+1][coordy].ne.getX() == -1 && (coordx+1 <= 28))
			{
				cote_libre.put(toString(compt),this.plat[coordx][coordy].ne);
			}
			if (this.plat[coordx][coordy+1].ne.getX() == -1 && (coordy+1 <= 28))
			{
				cote_libre.put(toString(compt2),this.plat[coordx][coordy].south);
			}
			if (this.plat[coordx-1][coordy].ne.getX() == -1 && (coordx-1 >= 0))
			{
				cote_libre.put(toString(compt3),this.plat[coordx][coordy].no);
			}
			
		} else { 
			System.out.println("Erreur coordonnées, case occupée ou en dehors du terrain");
		}
	}
	
	
	
	public void SaisiePlateau()
	{
		
			// Saisie du triomino
			int x=0;
			int y=0;
			int z=0;
	
			Scanner scan = new Scanner(System.in);
	
			System.out.println("Saisie des triominos");
			scan.nextInt(x);
			
			while (x < 0) 
			{ 
				System.out.println("Erreur : nombre négatif. Saisir x :");
				scan.nextInt(x);
			}
			
			System.out.println("Saisir y : ");
			scan.nextInt(y);
			
			while (y < 0)
			{
				System.out.println("Erreur : nombre négatif. Saisir y :");
				scan.nextInt(y);
			}
			
			System.out.println("Saisir z : ");
			scan.nextInt(z);
			
			while (z < 0)
			{
				System.out.println("Erreur : nombre négatif. Saisir z :");
				scan.nextInt(z);
			}
	
			triomino t = new triomino(x,y,z);	
			
			// Saisie des coordonnées 
			
			int coordx=0;
			int coordy=0;
		
			System.out.println("Saisie des coordonnées de ce triomino");
		
			System.out.println("Coordonnée colonne");
			scan.nextInt(coordx);
		
			System.out.print("Coordonnée ligne");
			scan.nextInt(coordy);
		
		if (this.plat[coordx][coordy].ne.getX() == -1)
		{
			// On ajoute ce triomino
			this.plat[coordx][coordy] = t;

			// On verifie si ses cotes sont libres et qu'ils ne dépassent pas notre plateau
			if (this.plat[coordx+1][coordy].ne.getX() == -1 && (coordx+1 <= 28))
			{
				cote_libre.put(toString(coordx+coordy),this.plat[coordx][coordy].ne);
			}
			if (this.plat[coordx][coordy+1].ne.getX() == -1 && (coordy+1 <= 28))
			{
				cote_libre.put(toString(coordx+coordy),this.plat[coordx][coordy].south);
			}
			if (this.plat[coordx-1][coordy].ne.getX() == -1 && (coordx-1 >= 0))
			{
				cote_libre.put(toString(coordx+coordy),this.plat[coordx][coordy].no);
			}
			
		} else { 
			System.out.println("Erreur coordonnées, case occupée ou en dehors du terrain");
		}
	}
	
	
	
	public void GetCellule(int x, int y)
	{
		System.out.println("["+this.plat[x][y].get_ne().getX()+","+ this.plat[x][y].get_ne().getY() +"]");
		System.out.println("["+this.plat[x][y].get_no().getX()+","+ this.plat[x][y].get_no().getY() +"]");
		System.out.println("["+this.plat[x][y].get_south().getX()+","+ this.plat[x][y].get_south().getY() +"]");
	}
	
	public void OuPlacerTriomino(triomino t)
	{
		// Retourne les faces libre pour placer un triomino, ainsi que leur coordonnées
		
		if (cote_libre.n == 0)
		{
		
			System.out.println("Pas de cote libre encore");
		
		} else {
		
			System.out.println("Voici les côtés dispos pour "+ t);
		
		
			for (int i = 0; i <= cote_libre.n; i++ )
			{
				if (cote_libre.get(toString(i)) == t.ne || cote_libre.get(toString(i)) == t.south || cote_libre.get(toString(i)) == t.no )
		
				System.out.println("(" + cote_libre.get(toString(i)).getX() + "," + cote_libre.get(toString(i)).getY() + ")");
				
			}
		}
	}
	
	public int ajouter_SL(triomino t,int o)
	// int o est le nombre de coups effectués
	// Il sera pratique pour la méthode Recherche()
	{


		// Dans le cas ou le plateau est vide
		if (o == 0) // Permet de savoir si la case est vide
		{
			
			
			o = 1;								// Il s'agit de notre premier coup : o sera donc à 1
			this.plat[14][14] = t;			// Et notre Triomino t est donc le premier triomino,
												// on le pose au milieu pour moins de contrainte
			
			t.ne.set_coordx(14);
			t.ne.set_coordy(14);
			t.ne.key = o;
			
			
			this.cote_libre.put(toString(o), t.ne);
			
			t.no.set_coordx(14);
			t.no.set_coordy(14);
			o += 1;
			t.no.key = o;
			this.cote_libre.put(toString(o),t.no);

			t.south.set_coordx(14);
			t.south.set_coordy(14);
			o += 1;
			
			this.cote_libre.put(toString(o),t.south);
			
			
			return o;
			
		} else {
		
			// On recherche parmis les côtés libres si on peut ajouter le triomino
			for (int i = 0; i <= cote_libre.n; i++)
			{
				if (this.cote_libre.get(toString(i)).getX() == t.ne.getX()
						&& t.ne.getY() == this.cote_libre.get(toString(i)).getY())
				{
					
		/*			if (cote_libre.get(toString(i)).get_coordx() % 2 != 0)
					{
						// Colonne impaire
						if (cote_libre.get(toString(i)).get_coordy() % 2 != 0)
						{
						  */
							if((this.plat[cote_libre.get(toString(i)).get_coordx()+2][cote_libre.get(toString(i)).get_coordy()].get_ne().getX() == -1 || 
							this.plat[cote_libre.get(toString(i)).get_coordx()+2][cote_libre.get(toString(i)).get_coordy()].get_no() == t.no) 
									&&
									(this.plat[cote_libre.get(toString(i)).get_coordx()+1][cote_libre.get(toString(i)).get_coordy()-1].get_south() == t.south || 
									this.plat[cote_libre.get(toString(i)).get_coordx()+2][cote_libre.get(toString(i)).get_coordy()].get_ne().getX() == -1))
							{
								// On peut alors ajouté à droite 
					
								this.plat[cote_libre.get(toString(i)).get_coordx()+1][cote_libre.get(toString(i)).get_coordy()] = t;
					
					
								// Maintenant que le triomino t est ajouté on doit modifier nos côtés libres de notre SD. Ici notre côté
								// i n'est plus disponible. On ajoute alors t.no et t.south aux côtés libres et on retire t.ne
					
							
							
							o +=1;
							
							t.no.set_coordx(cote_libre.get(toString(i)).get_coordx()+1);
							t.no.set_coordy(cote_libre.get(toString(i)).get_coordy());
							this.cote_libre.put(toString(o),t.no);
						
							o +=1;
							
							t.south.set_coordx(cote_libre.get(toString(i)).get_coordx()+1);
							t.south.set_coordx(cote_libre.get(toString(i)).get_coordy());
							this.cote_libre.put(toString(o),t.south);
						
							this.cote_libre.remove(toString(i));
							
							return o;
						}
					}
					if (this.cote_libre.get(toString(i)).getX() == t.no.getX()
							&& t.no.getY() == this.cote_libre.get(toString(i)).getY())
					{
					
						if((this.plat[cote_libre.get(toString(i)).get_coordx()-2][cote_libre.get(toString(i)).get_coordy()].get_no().getX() == -1 || 
							this.plat[cote_libre.get(toString(i)).get_coordx()-2][cote_libre.get(toString(i)).get_coordy()].get_ne() == t.ne) 
								&&
							this.plat[cote_libre.get(toString(i)).get_coordx()-1][cote_libre.get(toString(i)).get_coordy()-1].get_south() == t.south || 
							this.plat[cote_libre.get(toString(i)).get_coordx()-2][cote_libre.get(toString(i)).get_coordy()].get_ne().getX() == -1)
						{
							// On peut alors ajouté à gauche 
							this.plat[cote_libre.get(toString(i)).get_coordx()-1][cote_libre.get(toString(i)).get_coordy()] = t;
						
	
							// Maintenant que le triomino t est ajouté on doit modifier nos côtés libres de notre SD. Ici notre côté
							// i n'est plus disponible. On ajoute alors t.ne et t.south aux côtés libres
						
							this.cote_libre.remove(toString(i));
							
							o +=1;
							
							t.ne.set_coordx(cote_libre.get(toString(i)).get_coordx()-1);
							t.ne.set_coordy(cote_libre.get(toString(i)).get_coordy());
							this.cote_libre.put(toString(o), t.ne);
						
							o +=1;
						
							t.south.set_coordx(cote_libre.get(toString(i)).get_coordx()-1);
							t.south.set_coordy(cote_libre.get(toString(i)).get_coordy());
							this.cote_libre.put(toString(o), t.south);
						
						
							return o;
						}
					}
					if (this.cote_libre.get(toString(i)).getX() == t.south.getX()
							&& t.south.getY() == this.cote_libre.get(toString(i)).getY())
					{
						
						if((this.plat[cote_libre.get(toString(i)).get_coordx()-1][cote_libre.get(toString(i)).get_coordy()+1].get_ne().getX() == -1 || 
							this.plat[cote_libre.get(toString(i)).get_coordx()-1][cote_libre.get(toString(i)).get_coordy()+1].get_no() == t.no) 
								&&
							this.plat[cote_libre.get(toString(i)).get_coordx()+1][cote_libre.get(toString(i)).get_coordy()+1].get_ne() == t.ne || 
							this.plat[cote_libre.get(toString(i)).get_coordx()+1][cote_libre.get(toString(i)).get_coordy()+1].get_ne().getX() == -1)
						{
							// On peut alors ajouté en bas 
							this.plat[cote_libre.get(toString(i)).get_coordx()][cote_libre.get(toString(i)).get_coordy()+1] = t;
					
	
							// Maintenant que le triomino t est ajouté on doit modifier nos côtés libres de notre SD. Ici notre côté
							// i n'est plus disponible. On ajoute alors t.no et t.ne aux côtés libres
						
							this.cote_libre.remove(toString(i));
							
							o +=1;
			
							t.no.set_coordx(cote_libre.get(toString(i)).get_coordx()); // la face prends les coordonnées de sa case
							t.no.set_coordy(cote_libre.get(toString(i)).get_coordy()+1);
							this.cote_libre.put(toString(o),t.no);
						
							o +=1;
							t.ne.set_coordx(cote_libre.get(toString(i)).get_coordx());
							t.ne.set_coordy(cote_libre.get(toString(i)).get_coordy()+1);
							this.cote_libre.put(toString(o),t.ne);
						
						
							return o;
						}
					  }
				//	} 
			//	}
			}
			// /!\ A prendre en compte les cas particuliers 
			// Proposition de Théo : Prendre un périmetre de trois/deux triominos et travailler sur les cotes adjancents sur lesquels on s'interesse
			// Ou bien de gérer un booleen qui sera retourner vrai ou faux si on peut placer le triomino
		}
		return o;
	}
	
	private String toString(int o) {
		// TODO Auto-generated method stub
		return "o";
	}
	
	public boolean Recherche(triomino t)
	{
		// Recherche si un triomino est présent sur le plateau
		
		for (int i = 0; i < this.plat.length; i++)
		{
			for (int j = 0; j < this.plat.length; j++)
			{
				if (this.plat[i][j] == t)
				{
					return true;
				}
			}
		}
		// Si on ne le trouve pas, on retourne faux
		return false;
	}
	
	
/*
	public void putPlateau(triomino t)
	{
		int n = this.plat.length/2;
		
		// Dans le cas ou le plateau est vide
		if (this.plat[n/2][n/2] == null)
		{
		
			this.plat[n/2][n/2] = t;
		
		} else {
		// Dans le cas ou le plateau a déjà un ou plusieurs élement(s)
			
			for (int i = n/2; i<=this.plat.length; i++)
			{
				
			// On souhaite mettre le triomino a gauche
				if(this.plat[i][n/2].ne == t.no)
				{
					// On ajoute le triomino t a gauche
					if ( (this.plat[i+1][n/2].no == t.south || (this.plat[i+1][n/2] == null)) && (i%2 == 0) )
					{
						// On vérfie bien que la case en dessous est vide ou est égale a la face de t sur une colonne pair
					
						this.plat[i+1][n/2] = t;
				
					} else {
						
						if(this.plat[i][n/2].south == t.ne)
						{ 
							// On ajoute le triomino t en dessous
							// On vérifie la case en bas à gauche
							
							// Si : 		/   \
							//			   /no ne\
							//			  /_south_\
							//             ___ne__
							//			  \   	  /
							//			   \S  no/
							//			    \   /
							
							if (this.plat[i+1][(n/2)+1].no == t.no || (this.plat[i+1][(n/2)+1] == null) && (this.plat[i-1][(n/2)+1].ne == t.south || this.plat[i+1][(n/2)+1].ne == null) && (i%2 == 0))
							{ 
								this.plat[i][(n/2)+1] = t;
							} else {

								if (this.plat[i+1][(n/2)+1].south == t.ne || (this.plat[i+1][(n/2)+1] == null) && (this.plat[i-1][(n/2)+1].no == t.no || this.plat[i+1][(n/2)+1].ne == null))
								{
									this.plat[i][(n/2)+1] = t;
								}	
							}
							
						}
					}
				}
			
			} // Fin du pour en décalage 
			
			// On fait la recherche a gauche maintenant
			for (int j = n/2; j == 0; j--)
			{
			
				// On souhaite mettre le triomino a gauche
				if(this.plat[j][n/2].no == t.no)
				{
					// On ajoute le triomino t a gauche
					if (this.plat[j-2][n/2].ne == t.ne || (this.plat[j-2][n/2] == null))
					{
						// On vérfie bien que la case en dessous est vide ou est égale a la face de t sur une colonne pair
					
						this.plat[j][n/2] = t;
				
					} else {
						
						if(this.plat[i][n/2].south == t.ne)
						{ 
							// On ajoute le triomino t en dessous
							// On vérifie la case en bas à gauche
							
							// Si : 		/   \
							//			   /no ne\
							//			  /_south_\
							//             ___ne__
							//			  \   	  /
							//			   \S  no/
							//			    \   /
							
							if (this.plat[i+1][(n/2)+1].no == t.no || (this.plat[i+1][(n/2)+1] == null) && (this.plat[i-1][(n/2)+1].ne == t.south || this.plat[i+1][(n/2)+1].ne == null) && (i%2 == 0))
							{ 
								this.plat[i][(n/2)+1] = t;
							} else {

								if (this.plat[i+1][(n/2)+1].south == t.ne || (this.plat[i+1][(n/2)+1] == null) && (this.plat[i-1][(n/2)+1].no == t.no || this.plat[i+1][(n/2)+1].ne == null))
								{
									this.plat[i][(n/2)+1] = t;
								}	
							}
							
						}
					}
				}
			
			}
		}
		
}
*/
}