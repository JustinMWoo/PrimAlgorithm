/*
 * Justin Woo 250860368
 * jwoo58@uwo.ca
 * Assignment 3, CS3340
 */

/**
 * Edge data type
 * 
 * @author Justin Woo
 */
public class Edge {
	private int end, weight;

	/*
	 * Constructor for an edge
	 * 
	 * @param end the vertex that the edge goes to
	 * 
	 * @param weight the weight of the edge
	 * 
	 */
	public Edge(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	/*
	 * Getter function for the end of the edge
	 * 
	 * @return the end that the edge goes to
	 * 
	 */
	public int get_end() {
		return end;
	}

	/*
	 * Getter function for the weight of the edge
	 * 
	 * @return the weight of the edge
	 * 
	 */
	public int get_weight() {
		return weight;
	}
}
