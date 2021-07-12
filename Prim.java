/*
 * Justin Woo 250860368
 * jwoo58@uwo.ca
 * Assignment 3, CS3340
 */

/**
 * Prim's minimum spanning tree algorithm on input file
 * 
 * @author Justin Woo
 */

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Prim {

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.out.println("Incorrect number of arguments");
			return;
		}
		Path file = Paths.get(args[0]);
		Scanner scanner = new Scanner(file);

		int count = 0, i = 0, j = 0, w = 0, nodes;
		nodes = scanner.nextInt();
		// Initialize the adjacency list
		ArrayList<Edge>[] AdjList = new ArrayList[nodes + 1];
		for (int a = 1; a < nodes + 1; a++) {
			AdjList[a] = new ArrayList<Edge>();
		}

		// Add edges from file to adjacency list
		while (scanner.hasNext()) {
			if (scanner.hasNextInt()) {
				if (count == 0) {
					i = scanner.nextInt();
					count++;
				} else if (count == 1) {
					j = scanner.nextInt();
					count++;
				} else if (count == 2) {
					w = scanner.nextInt();
					count++;
				}
			} else {
				scanner.next();
			}

			if (count == 3) {
				count = 0;
				AdjList[i].add(new Edge(j, w));
				AdjList[j].add(new Edge(i, w));
			}
		}
		scanner.close();

		// Output displaying the adjacency list
		for (int v = 1; v <= nodes; v++) {
			System.out.println("Edges out of " + v + ":");
			for (int e = 0; e < AdjList[v].size(); e++) {
				System.out.println(
						"Edge to " + AdjList[v].get(e).get_end() + " with weight " + AdjList[v].get(e).get_weight());
			}
		}

		System.out.println("\n__________________________________________________________________________\n");
		// Create a heap with starting node with key of 0 and rest with infinite
		int keys[] = new int[nodes];
		keys[0] = 0;
		for (i = 1; i < nodes; i++) {
			keys[i] = Integer.MAX_VALUE;
		}
		Heap min_heap = new Heap(keys, nodes);
		boolean first = true;
		while (min_heap.min_key() != -1) {
			int min = min_heap.min_id();
			int weight = min_heap.min_key();
			if (first) // Don't print for first iteration
				first = false;
			else { // Print the next edge from Prim's
				for (int e = 0; e < AdjList[min].size(); e++) {
					if (AdjList[min].get(e).get_weight() == weight)
						System.out.print("Edge from " + AdjList[min].get(e).get_end());
				}
				System.out.print(" to " + min + " with weight " + weight + "\n");
			}
			// Delete the minimum from the heap
			min_heap.delete_min();
			// Update the heap with the edges connected to the newly connected node
			for (int edge = 0; edge < AdjList[min].size(); edge++) {
				min_heap.decrease_key(AdjList[min].get(edge).get_end(), AdjList[min].get(edge).get_weight());
			}
		}

	}

}
