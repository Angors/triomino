package projet;

import java.util.*;



public class Noeud_SkipList<f> {

    public face value;

    public List<Noeud_SkipList<face> > nextNodes;

	

    public face getValue() {

	return value;

    }



    public Noeud_SkipList(face value) {

	this.value = value;

	nextNodes = new ArrayList<Noeud_SkipList<face> >();

    }



    public int level() {

	return nextNodes.size()-1;

    }



    public String toString() {

	return "SLN: " + value;

    }

}