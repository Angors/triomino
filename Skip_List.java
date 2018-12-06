package projet;

import java.util.*;



public class Skip_List<f extends Comparable<face>> {

    private Noeud_SkipList<face> head;

    private int maxLevel;

    public int size;



    private static final double PROBABILITY = 0.5;



    public Skip_List() {

	size = 0;

	maxLevel = 0;

	// a SkipListNode with value null marks the beginning

	head = new Noeud_SkipList<face>(null);

	// null marks the end

	head.nextNodes.add(null); 

    }



    public Noeud_SkipList getHead() {

	return head;

    }



    // Adds e to the skiplist.

    // Returns false if already in skiplist, true otherwise.

    public boolean add(face e) {

	if(contains(e)) return false;

	size++;

	// random number from 0 to maxLevel+1 (inclusive)

	int level = 0; 

	while (Math.random() < PROBABILITY)

		level++;

	while(level > maxLevel) { // should only happen once

	    head.nextNodes.add(null);

	    maxLevel++;

	}

	Noeud_SkipList newNode = new Noeud_SkipList<face>(e);

	Noeud_SkipList current = head;

      	do {

	    current = findNext(e,current,level);

	    newNode.nextNodes.add(0,current.nextNodes.get(level));

	    current.nextNodes.set(level,newNode);

	} while (level-- > 0);

	return true;

    }



    // Returns the skiplist node with greatest value <= e

    public Noeud_SkipList find(face e) {

	return find(e,head,maxLevel);

    }



    // Returns the skiplist node with greatest value <= e

    // Starts at node start and level

    public Noeud_SkipList find(face e, Noeud_SkipList current, int level) {

	do {

	    current = findNext(e,current,level);

	} while(level-- > 0);

	return current;

    }



    // Returns the node at a given level with highest value less than e

    private Noeud_SkipList findNext(face e, Noeud_SkipList current, int level) {

        Noeud_SkipList next = (Noeud_SkipList)current.nextNodes.get(level);

	while(next != null) {

	    face value = (face)next.getValue();

	    if(lessThan(e,value)) // e < value

		break;

	    current = next;

	    next = (Noeud_SkipList)current.nextNodes.get(level);

	}

	return current;

    }

    

    public int size() {

	return size;

    }



    public boolean contains(Object o) {

	face e = (face)o;

	Noeud_SkipList node = find(e);

	return node != null &&

	    node.getValue() != null &&

	    equalTo((face)node.getValue(),e);

    }



    public Iterator<face> iterator() {

	return new Iterateur_SkipList(this);

   	}
    
    private boolean lessThan(face a, face b) {

     	return a.compareTo(b) < 0;

    }



    private boolean equalTo(face a, face b) {

    	return a.compareTo(b) == 0;
    }



    private boolean greaterThan(face a, face b) {

	   return a.compareTo(b) > 0;

    }
}