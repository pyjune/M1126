// SWExpertAcademy 5948번 새샘이의 7-3-5 게임

import java.util.Scanner;


public class Solution {
	static int [] p;
	static int [] used;
	static int [] a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
			used = new int [300];
			a = new int[7];
			p = new int[3];
			for(int i = 0; i < 7; i++)
			{
				a[i] = sc.nextInt();
			}
			find(7, 3);
			int cnt = 0;
			for(int i = 299; i>0; i--)
			{
				if(used[i]!=0)
				{
					cnt++;
					if(cnt == 5)
					{
						cnt = i;
						break;
					}
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
		}
		
	}
	public static void find(int n, int k) {
		if( k == 0 )
		{
			used[p[0]+p[1]+p[2]] = 1;
		}
		else if( n < k)
		{
			return;
		}
		else
		{
			p[k-1] = a[n-1];
			find(n-1, k-1);
			find(n-1, k);
		}
	}

}
