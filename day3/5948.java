// SWExpertAcademy 5948번 새샘이의 7-3-5 게임

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
	static int [] p;
	static TreeSet<Integer> set;
	static int[] a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
			set = new TreeSet<>();
			a = new int[7];
			p = new int[3];
			for(int i = 0; i < 7; i++)
			{
				a[i] = sc.nextInt();
			}
			find(7, 3);
			Integer [] arr = new Integer[set.size()];
			arr = set.toArray(arr);
			System.out.println("#"+tc+" "+arr[set.size()-5]);
		}
		
	}
	public static void find(int n, int k) {
		if( k == 0 )
		{
			set.add(new Integer(p[0]+p[1]+p[2]));
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
