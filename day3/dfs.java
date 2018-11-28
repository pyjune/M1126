/*

5 6
1 2 1 3 3 2 3 4 2 5 5 4
 
 */

import java.util.Scanner;

public class Solution {
	static int V;
	static int E;
	static int[][] adj;
	static int[] visited;
	
	static int[] s;
	static int top;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		// dfs3()에 사용할 스택
		s = new int[V];
		top = -1;
		
		adj = new int[V+1][V+1];
		visited = new int[V+1];
		for(int i = 0; i < E; i++)
		{
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			
			adj[n1][n2] = 1;
			// adj[n2][n1] = 1; // 무방향 그래프인 경우
		}
		//dfs(1);
		dfs3(1);
	}
	public static void dfs(int n)
	{
		visited[n] = 1;
		System.out.println(n);
		for(int i = 1; i <= V; i++)
		{
			if((adj[n][i] != 0)&&(visited[i] == 0))
			{
				dfs(i);
			}
		}
	}
	//  k번 노드에 도착하면 1, 아니면 0 출력
	public static int dfs2(int n, int k)
	{
		if(n==k)
		{
			return 1;
		}
		else
		{
			visited[n] = 1;
			//System.out.println(n);
			for(int i = 1; i <= V; i++)
			{
				if((adj[n][i] != 0)&&(visited[i] == 0))
				{
					if(dfs2(i, k) == 1)
						return 1;
				}
			}
			return 0;
		}
		
	}
	// 반복구조의 dfs
	public static void dfs3(int n)
	{
		// 시작점 push
		s[++top] = n;
		visited[n] = 1;
		while( top >= 0 ) // 스택이 비어있지 않으면
		{
			n = s[top--]; // pop()
			System.out.println(n);
			// 인접하고 미방문인 노드  push()
			for(int i = 1; i <= V; i++)
			{
				if(( adj[n][i] != 0 ) && ( visited[i] == 0))
				{
					s[++top] = i;
					visited[i] = 1;
				}
			}
		}
	}
	//  k번 노드에 도착하면 1, 아니면 0 출력
	public static int dfs4(int n, int k)
	{
		// 시작점 push
		s[++top] = n;
		visited[n] = 1;
		while( top >= 0 ) // 스택이 비어있지 않으면
		{
			n = s[top--]; // pop()
			if(n==k)
				return 1;
			// 인접하고 미방문인 노드  push()
			for(int i = 1; i <= V; i++)
			{
				if(( adj[n][i] != 0 ) && ( visited[i] == 0))
				{
					s[++top] = i;
					visited[i] = 1;
				}
			}
		}
		return 0;
	}
}
