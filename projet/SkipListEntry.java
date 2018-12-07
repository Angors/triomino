package projet;

public class SkipListEntry {

	// Parametres
	
	public String key;
	public face value;
	
	int pos;
	
	public SkipListEntry up;
	public SkipListEntry down;
	public SkipListEntry left;
	public SkipListEntry right;
		
	public static String negInf = "-oo"; // valeur - infini
	public static String posInf = "+oo"; // valeur + infini 

	public SkipListEntry(String k,face v)
	{
		key = k;
		value = v;
		up = down = left = right = null;
	}
	
	// Methodes
	
	  public face getValue() 
	  { 
	    return value; 
	    
	  }
	  
	  public String getKey() 
	  { return key; 
	  }

	  public face setValue(face face) 
	  {
		face temp;
	    temp = value;
	    value = face;
	    return temp;
	  }

	  public boolean equals(Object o) 
	  {
	    SkipListEntry ent;
	    try 
	    { 
	      ent = (SkipListEntry) o;    // Test if o is a SkipListEntry...
	    }
	    catch (ClassCastException ex) 
	    { 
		return false; 
	    }

	    return (ent.getKey() == key) && (ent.getValue() == value);
	  }

	  public String toString() 
	  {
	    return "(" + key + "," + value + ")";
	  }
	  
}