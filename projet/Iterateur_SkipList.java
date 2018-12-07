package projet;

import java.util.*;

public class Iterateur_SkipList<f extends Comparable<face>> implements Iterator<face> {

    Skip_List<f> list;

    Noeud_SkipList<face> current;



    public Iterateur_SkipList(Skip_List<f> list) {

	this.list = list;

	this.current = list.getHead();

    }



    public boolean hasNext() {

	return current.nextNodes.get(0) != null;

    }



    public face next() {

	current = (Noeud_SkipList<face>)current.nextNodes.get(0);

	return (face)current.getValue();

    }



    public void remove() throws UnsupportedOperationException {

	throw new UnsupportedOperationException();

    }

}

