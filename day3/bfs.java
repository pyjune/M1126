import java.util.ArrayList;
import java.util.Scanner;

/*

5 6
1 2 1 3 3 2 3 4 2 5 5 4
 
 */
public class Solution {
	static int V;
	static int E;
	static int [][] adj;
	static ArrayList<Integer>[] adjlist;
	static int [] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		visited = new int[V+1];
		// 인접리스트
		adj = new int[V+1][V+1];
		adjlist = new ArrayList[V+1];
		
		for(int i = 0; i<=V; i++)
		{
			adjlist[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++)
		{
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			adj[n1][n2] = 1;
			
			adjlist[n1].add(n2); // 인접리스트
		}
		bfs(1);
		System.out.println(visited[4]-1);
		
	}
	public static int bfs(int n)
	{
		int [] q = new int[V];
		int front = -1;
		int rear = -1;
		// 시작노드 인큐, 방문표시
		q[++rear] = n;
		visited[n] = 1;
		while( front != rear )
		{
			n = q[++front]; // dequeue
			// n번 노드 처리..
			System.out.println(n);
			if(n==V)
				return visited[V]-1;
			
//			for(int i = 1; i <= V; i++)
//			{
//				if((adj[n][i]!=0)&&(visited[i]==0))
//				{
//					q[++rear] = i;
//					visited[i] = visited[n] + 1;
//				}
//			}
			//  인접리스트인 경우..
			for(int i=0; i<adjlist[n].size(); i++)
			{
				int t = adjlist[n].get(i);
				if(visited[t]==0)
				{
					q[++rear] = t;
					visited[t] = visited[n] + 1;
				}
			}
		}
		return 0;
	}
}
