package projet;

import java.util.Scanner;

public class plateau {
// Classe concernant le plateau de jeu
// Note : Avec une SkipList
	
	triomino[][] plat; // Tableau de triomino en deux dimensions.
	int ligne;         // Peut contenir jusqu'a 30 pieces
	int colonne;  
	ABR cote_libre;
	
	// Constructeur
	public plateau(int rempli) {
		
		ligne = 30;
		colonne = 30;
		plat = new triomino[ligne][colonne];
		
		cote_libre = new ABR();

			for (int u = 0; u <= 27; u++)
			{
				for (int t = 0; t <= 27; t++)
				{
					// Chaque case u.u est un triomino au valeurs (-1,-1,-1)
					plat[u][t] = new triomino();
		
				}
			}
			// On choisit alors un plateau rempli. Donc on fait appel a SaisiePlateau() n fois
			System.out.println("Saississez combien de triominos, puis les coordonnées des triominos déjà placé et leurs valeurs");
			
			for (int i = 0; i <=rempli; i++)
			{
				SaisiePlateau();
			}
	}
	
	public plateau()
	{
		ligne = 28;
		colonne = 28;
		plat = new triomino[ligne][colonne];
		
		cote_libre = new ABR();

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
	
	
	public void SaisiePlateau()
	{
		
			// Saisie du triomino
			int x=0;
			int y=0;
			int z=0;
	
			Scanner scan = new Scanner(System.in);
	
			System.out.println("Saisie des triominos");
	
			System.out.println("Saisir x : ");
			scan.nextInt(x);
	
	
			System.out.println("Saisir y : ");
			scan.nextInt(y);
	
			System.out.println("Saisir z : ");
			scan.nextInt(z);
	
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
				cote_libre.add(this.plat[coordx][coordy].ne);
			}
			if (this.plat[coordx][coordy+1].ne.getX() == -1 && (coordy+1 <= 28))
			{
				cote_libre.add(this.plat[coordx][coordy].south);
			}
			if (this.plat[coordx-1][coordy].ne.getX() == -1 && (coordx-1 >= 0))
			{
				cote_libre.add(this.plat[coordx][coordy].no);
			}
			
		} else { 
			int rep = 0;
			System.out.println("Erreur coordonnées, case occupée ou en dehors du terrain");
			System.out.println("Souhaitez vous re-essayer? Ecrivez 0 pour oui ou 1 pour non");
			scan.nextInt(rep);
			
			if (rep == 0) { SaisiePlateau(); }
		}
		
	}
	
	

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
				cote_libre.add(this.plat[coordx][coordy].ne);
			}
			if (this.plat[coordx][coordy+1].ne.getX() == -1 && (coordy+1 <= 28))
			{
				cote_libre.add(this.plat[coordx][coordy].south);
			}
			if (this.plat[coordx-1][coordy].ne.getX() == -1 && (coordx-1 >= 0))
			{
				cote_libre.add(this.plat[coordx][coordy].no);
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
		
		if (this.cote_libre.contains(t.ne) == true || this.cote_libre.contains(t.no) || this.cote_libre.contains(t.south))
		{
			System.out.println("Voici les côtés dispos pour "+ t);
		
			for (int i = 0 ; i <= this.plat.length; i++)
			{
				for (int j = 0; j <= this.plat.length; j++)
				{
					if (this.cote_libre.find(t.ne) == this.plat[i][j].get_ne() ||
						this.cote_libre.find(t.no) == this.plat[i][j].get_no() ||
						this.cote_libre.find(t.south) == this.plat[i][j].get_south())
					{
						System.out.print(this.plat[i][j]);
						System.out.println("(" + cote_libre.find(t.ne).getX() + "," + cote_libre.find(t.ne).getY() + ")");
						System.out.println("(" + cote_libre.find(t.no).getX() + "," + cote_libre.find(t.no).getY() + ")");
						System.out.println("(" + cote_libre.find(t.south).getX() + "," + cote_libre.find(t.south).getY() + ")");			
					}
				
				}
			}
			
		} else {
			
			System.out.println("Pas de côté dispo pour " + t.get_ne().getX() + " , "+ t.get_ne().getY());
			System.out.println("Pas de côté dispo pour " + t.get_no().getX() + " , "+ t.get_no().getY());
			System.out.println("Pas de côté dispo pour " + t.get_south().getX() + " , "+ t.get_south().getY());
		}
	}
	
	public int ajouter_SL(triomino t,int o)
	// int o est le nombre de coups effectués
	// Il sera pratique pour la méthode Recherche()
	{


		// Dans le cas ou le plateau est vide
		if (o == 0) // Permet de savoir si la case est vide
		{
			
			triomino milieu = new triomino(t.ne.getX(),t.ne.getY(),t.no.getY());
			o = 1;								// Il s'agit de notre premier coup : o sera donc à 1
			this.plat[14][14] = milieu;			// Et notre Triomino t est donc le premier triomino,
												// on le pose au milieu pour moins de contrainte
			
			milieu.ne.set_coordx(14);
			milieu.ne.set_coordy(14);
			t.ne.key = 1;
			
			String name = toString(o);
			
			
			this.cote_libre.add(milieu.ne);
			this.cote_libre = this.cote_libre.add(milieu.ne);
			
			milieu.no.set_coordx(14);
			milieu.no.set_coordy(14);
			o += 1;
			t.no.key = o;
			this.cote_libre.add(t.no);
			this.cote_libre = this.cote_libre.add(milieu.no);
			
			milieu.south.set_coordx(14);
			milieu.south.set_coordy(14);
			o += 1;
			
			this.cote_libre = this.cote_libre.add(milieu.south);
			this.cote_libre.find(t.ne).coordx = 14;
			milieu.south.key= o;
			System.out.println(cote_libre.find(milieu.south).key);
			return o;
			
		} else {
			System.out.println("Test conditionnelle");
			// On recherche parmis les côtés libres si on peut ajouter le triomino
		//	for (int i = 0; i <= cote_libre.size(); i++)
		//	{
				if (this.cote_libre.contains(t.ne) == true)
				{
					System.out.println(cote_libre.find(t.ne).key);
					
					// Colonne impaire
					if((this.plat[cote_libre.find(t.ne).get_coordx()+2][cote_libre.find(t.ne).get_coordy()].get_ne().getX() == -1 || 
						this.plat[cote_libre.find(t.ne).get_coordx()+2][cote_libre.find(t.ne).get_coordy()].get_no() == t.no) 
							&&
						(this.plat[cote_libre.find(t.ne).get_coordx()+1][cote_libre.find(t.ne).get_coordy()-1].get_south() == t.south || 
						this.plat[cote_libre.find(t.ne).get_coordx()+2][cote_libre.find(t.ne).get_coordy()].get_ne().getX() == -1))
					{
					// On peut alors ajouté à droite 
					
						this.plat[cote_libre.find(t.ne).get_coordx()+1][cote_libre.find(t.ne).get_coordy()] = t;
					
					
						// Maintenant que le triomino t est ajouté on doit modifier nos côtés libres de notre SD. Ici notre côté
						// i n'est plus disponible. On ajoute alors t.no et t.south aux côtés libres et on retire t.ne
					
						this.cote_libre.remove(t.ne);
						
						o +=1;
						t.ne.name = toString(o);
						this.cote_libre.add(t.no);
					
						o +=1;
						t.ne.name = toString(o);
						this.cote_libre.add(t.south);
					
						return o;
					}
				}
				if (this.cote_libre.contains(t.no) == true)
				{
					if((this.plat[cote_libre.find(t.no).get_coordx()-2][cote_libre.find(t.no).get_coordy()].get_no().getX() == -1 || 
						this.plat[cote_libre.find(t.no).get_coordx()-2][cote_libre.find(t.no).get_coordy()].get_ne() == t.ne) 
							&&
						this.plat[cote_libre.find(t.no).get_coordx()+1][cote_libre.find(t.no).get_coordy()-1].get_south() == t.south || 
						this.plat[cote_libre.find(t.no).get_coordx()-2][cote_libre.find(t.no).get_coordy()].get_ne().getX() == -1)
					{
						// On peut alors ajouté à gauche 
						this.plat[cote_libre.find(t.no).get_coordx()-1][cote_libre.find(t.no).get_coordy()] = t;
					

						// Maintenant que le triomino t est ajouté on doit modifier nos côtés libres de notre SD. Ici notre côté
						// i n'est plus disponible. On ajoute alors t.ne et t.south aux côtés libres
					
						o +=1;
						t.ne.name = toString(o);
						this.cote_libre.add(t.ne);
					
						o +=1;
						t.ne.name = toString(o);
						this.cote_libre.add(t.south);
					
					
						return o;
					}
				}
				if (this.cote_libre.contains(t.south) == true)
				{
					if((this.plat[cote_libre.find(t.south).get_coordx()-1][cote_libre.find(t.south).get_coordy()+1].get_ne().getX() == -1 || 
						this.plat[cote_libre.find(t.south).get_coordx()-1][cote_libre.find(t.south).get_coordy()+1].get_no() == t.no) 
							&&
						this.plat[cote_libre.find(t.south).get_coordx()+1][cote_libre.find(t.south).get_coordy()+1].get_ne() == t.ne || 
						this.plat[cote_libre.find(t.south).get_coordx()+1][cote_libre.find(t.south).get_coordy()+1].get_ne().getX() == -1)
					{
						// On peut alors ajouté en bas 
						this.plat[cote_libre.find(t.south).get_coordx()][cote_libre.find(t.south).get_coordy()+1] = t;
				

						// Maintenant que le triomino t est ajouté on doit modifier nos côtés libres de notre SD. Ici notre côté
						// i n'est plus disponible. On ajoute alors t.no et t.ne aux côtés libres
					
						o +=1;
						t.ne.name = toString(o);
						this.cote_libre.add(t.no);
					
						o +=1;
						t.ne.name = toString(o);
						this.cote_libre.add(t.ne);
					
					
						return o;
					}
				}
			}
			// /!\ A prendre en compte les cas particuliers 
			// Proposition de Théo : Prendre un périmetre de trois/deux triominos et travailler sur les cotes adjancents sur lesquels on s'interesse
			// Ou bien de gérer un booleen qui sera retourner vrai ou faux si on peut placer le triomino
		//}
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
	public void addPlateau(triomino t)
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