import java.util.Scanner;

public class Main {
	static long [] a;
	static long [] tree;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		a = new long[N+1];
		tree = new long[N*4];
		for(int i=1; i<=N; i++)
		{
			a[i] = sc.nextInt();
		}
		mTree(1, 1, N);
		for(int i = 0; i < M+K; i++)
		{
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			if(n1 == 1)
			{
				
				cTree(1, N, n2, n3);
			}
			else
			{
				System.out.println(fTree(1, 1, N, n2, n3));
			}
		}
		
	}
	public static void cTree(int s, int e, int i, long diff)
	{
		int n = 1;
		diff = diff - a[i];
		a[i] += diff;
		tree[n] += diff; // root
		while(s != e)
		{
			int m = ( s + e ) / 2;
			if( i <= m)
			{
				e = m;
				n = 2*n;
			}
			else
			{
				s = m + 1;
				n = 2*n + 1;
			}
			tree[n] += diff;
		}
	}
	public static long mTree(int n, int s, int e)
	{
		if(s==e) // leaf인 경우
		{
			tree[n] = a[s];
		}
		else
		{
			int m = (s + e) / 2;
			long r1 = mTree(n*2, s, m); // 왼쪽자식으로 이동
			long r2 = mTree(n*2+1, m+1, e); //  오른쪽 자식으로 이동
			tree[n] = r1 + r2;
		}
		return tree[n];
	}
	public static long fTree(int n, int s, int e, int l, int r)
	{
		if((e<l)||(r<s)) // 노드가 가진 구간이 찾는 구간을 벗어난 경우
		{
			return 0;
		}
		else if((l<=s)&&(e<=r)) // 찾는 구간에 포함된 노드
		{
			return tree[n];
		}
		else
		{
			int m = (s+e)/2;
			long r1 = fTree(n*2, s, m, l, r);
			long r2 = fTree(n*2+1, m+1, e, l, r);
			return (r1 + r2);
		}
	}
}
