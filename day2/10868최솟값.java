import java.util.Scanner;

public class Main {
	static int [] a;
	static int [] tree;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		a = new int[N+1];
		tree = new int[1000000];
		for(int i=1; i<=N; i++)
		{
			a[i] = sc.nextInt();
		}
		mTree(1, 1, N);
		for(int i = 0; i < M; i++)
		{
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			System.out.println(fTree(1, 1, N, n1, n2));
		}
		
	}

	public static int mTree(int n, int s, int e)
	{
		if(s==e) // leaf인 경우
		{
			tree[n] = a[s];
		}
		else
		{
			int m = (s + e) / 2;
			int r1 = mTree(n*2, s, m); // 왼쪽자식으로 이동
			int r2 = mTree(n*2+1, m+1, e); //  오른쪽 자식으로 이동
			tree[n] = Math.min(r1, r2);
		}
		return tree[n];
	}
	public static int fTree(int n, int s, int e, int l, int r)
	{
		if((e<l)||(r<s)) // 노드가 가진 구간이 찾는 구간을 벗어난 경우
		{
			return Integer.MAX_VALUE;
		}
		else if((l<=s)&&(e<=r)) // 찾는 구간에 포함된 노드
		{
			return tree[n];
		}
		else
		{
			int m = (s+e)/2;
			int r1 = fTree(n*2, s, m, l, r);
			int r2 = fTree(n*2+1, m+1, e, l, r);
			return Math.min(r1, r2);
		}
	}
}
