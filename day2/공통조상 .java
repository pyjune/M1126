import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	static int V;
	static int E;
	static int [] c1;
	static int [] c2;
	static int [] par;
	static int [] anc;
	static int cnt;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++)
		{
			cnt = 0;
			V = sc.nextInt();
			E = sc.nextInt();
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			anc = new int[V+1];
			c1 = new int[V+1];
			c2 = new int[V+1];
			par = new int[V+1];
			int subroot = 0;
			for(int i = 0; i < E; i++)
			{
				int p = sc.nextInt();
				int c = sc.nextInt();
				if(c1[p] == 0)
					c1[p] = c;
				else
					c2[p] = c;
				par[c] = p;
			}
			//  n1 의 조상찾기..
			while(par[n1]!=0) //  n1의 부모가 존재하면
			{
				n1 = par[n1]; //  n1의 조상 기록
				anc[n1] = 1;
			}
			while(par[n2]!=0) //  n2의 부모가 존재하면
			{
				n2 = par[n2];
				if(anc[n2]==1)
				{
					subroot = n2;
					break;
				}
			}
			f(subroot);
			System.out.println("#"+tc+" "+subroot+" "+cnt);
		}
	}
	public static void f(int n) 
	{
		if(n>0)
		{
			cnt++; // 순회한 노드 개수
			//System.out.println(n); // 전위순회
			f(c1[n]);
			//System.out.println(n); //  중위순회
			f(c2[n]);
			//System.out.println(n); //  후위순회
		}
	}
}
