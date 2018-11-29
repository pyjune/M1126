import java.util.Scanner;
 
public class Solution {
    static int V;
    static int E;
    static ArrayList<Integer> [] adj;
    static int [] danger;
    static int [] visited;
    static int minV;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++)
        {
            minV = Integer.MAX_VALUE;
             
            V = sc.nextInt();
            E = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
             
            adj = new ArrayList[V+1];
            for(int i = 0; i<=V; i++)
            {
                adj[i] = new ArrayList<>();
            }
            danger = new int[V+1];
            visited = new int[V+1];
             
            int d = sc.nextInt(); // 위험지역수
            for(int i=0; i<d; i++)
            {
                int a = sc.nextInt();
                danger[a] = 1;
            }
            for(int i=0; i<E; i++)
            {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                adj[v1].add(v2);
                adj[v2].add(v1);
            }
            //find(n, k, 0);
            //if(minV == Integer.MAX_VALUE)
            //  minV = 0;
            find2(n, k);
            System.out.println("#"+tc);
            //System.out.println(minV);
            if(visited[k] == Integer.MAX_VALUE)
                visited[k] = 0;
            System.out.println(visited[k]);
        }
    }
    public static void find2(int n, int k)
    {
        int [] q = new int [1000000];
        int front = -1;
        int rear = -1;
        q[++rear] = n;
        for(int i = 1; i <= V; i++)
            visited[i] = Integer.MAX_VALUE;
        visited[n] = 0;
        while( front != rear )
        {
            n = q[++front];
            for(int i = 0; i<adj[n].size(); i++)
            {
                int t = adj[n].get(i);
                if(danger[n] + visited[n]<visited[t])
                {
                    q[++rear] = t;
                    visited[t] = danger[n]+visited[n];
                }
            }
        }
    }
 
}
