import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

	static int K;
	static int [][]a;
	static int [][]t = {
		{1, 2, 3, 4},
		{4, 1, 2, 3},
		{3, 4, 1, 2},
		{2, 3, 4, 1}
	};
	static int N;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++)
		{
			N = sc.nextInt();
			K = sc.nextInt();
			a = new int [K+1][2];
			a[0][0] = 1;
			a[0][1] = 1;
			for(int i = 1; i<=K; i++)
			{
					a[i][0] = sc.nextInt();
					a[i][1] = sc.nextInt();
			}
			int r = find(K);
			System.out.println("#"+tc+" "+r);
		}
	}
	public static int find(int k)
	{
		int dir = 0;
		int pos = 0;
		int cnt = 0; 
		for (int i = 0; i < k; i++)
		{
			if (a[i][0] < a[i+1][0] && a[i][1] < a[i+1][1]) // 다음 숫자가 오른쪽 아래
			{
				pos = 0;
			}
			else if (a[i][0] < a[i+1][0] && a[i+1][1] < a[i][1]) // 다음 숫자가 왼쪽 아래
			{
				pos = 1;
			}
			else if (a[i+1][0] < a[i][0] && a[i+1][1] < a[i][1]) // 다음 숫자가 왼쪽 위
			{
				pos = 2;
			}
			else if (a[i+1][0] < a[i][0] && a[i][1] < a[i+1][1]) // 다음 숫자가 오른쪽 위
			{
				pos = 3;
			}

			cnt += t[dir][pos];
			dir = (dir + t[dir][pos]) % 4;

		}
		return cnt;
	}
}



