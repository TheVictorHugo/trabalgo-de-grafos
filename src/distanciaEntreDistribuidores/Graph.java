package distanciaEntreDistribuidores;

import java.io.*; 
import java.util.*; 


class Graph 
{ 
	private int V; // No. of vertices 
	private LinkedList<Integer> adj[]; //Adjacency Lists 
	private int pai[];
	private int cont =0;
	private int vet[];

	Graph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	void addEdge(int v,int w) 
	{ 
		adj[v].add(w); 
	} 
	
	void imprimirPai() {
		for(int i = 0 ; i < pai.length; i++) {
			System.out.printf(" %d",pai[i]);
		}
	}
	
	void imprimirVet() {
		for(int i = 0 ; i < vet.length; i++) {
			System.out.printf(" %d",vet[i]);
		}
	}

	void BFS(int s) 
	{ 
		boolean visited[] = new boolean[V]; 
		pai = new int[V];
		vet = new int[V];
		
		LinkedList<Integer> queue = new LinkedList<Integer>(); 

		visited[s]=true;
		vet[s] = cont++;
		pai[s] = s;
		queue.add(s); 
		//vet[s] = vet[s] + 1;

		while (queue.size() != 0) 
		{ 
			s = queue.poll(); 
			System.out.print(s+" "); 
			
			//vet[s] = vet[s] + 1;

			Iterator<Integer> i = adj[s].listIterator(); 
			while (i.hasNext()) 
			{ 
				
				//cont = 0;
				int n = i.next();
				//vet[n] = cont++;
				if (!visited[n]) 
				{ 
					visited[n] = true;
					vet[n] = cont++;
					pai[n] = s;
					queue.add(n); 
				} 
			} 
		} 
	} 

	public static void main(String args[]) 
	{ 
		Graph g = new Graph(10); 

		/*
		 * g.addEdge(0, 2); g.addEdge(0, 3); g.addEdge(0, 4); g.addEdge(1, 2);
		 * g.addEdge(1, 4); g.addEdge(2, 4); g.addEdge(3, 4); g.addEdge(3, 5);
		 * g.addEdge(4, 5); g.addEdge(5, 1);
		 */
		
		g.addEdge(9,0); 
		g.addEdge(1,1);
		g.addEdge(4,2); 
		g.addEdge(9,3); 
		g.addEdge(0,4); 
		g.addEdge(4,5); 
		g.addEdge(8,6); 
		g.addEdge(9,7); 
		g.addEdge(0,8); 
		g.addEdge(1,9);
		
	

		System.out.println("Following is Breadth First Traversal "+ 
						"(starting from vertex 2)"); 

		g.BFS(1); 
		System.out.println(); 
		g.imprimirPai();
		System.out.println(); 
		g.imprimirVet();
	} 
} 

