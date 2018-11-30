import java.awt.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
	static String st;
	static int N;
	static int K;
	static TreeSet<Integer> ts;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();
			K = sc.nextInt();
			st = sc.next();
			ts = new TreeSet<>();
			for(int i = 0; i<N/4; i++)
			{
				for(int j = 0; j<4; j++)
				{
					String stmp = "";
					for(int k = 0; k<N/4; k++)
					{
						stmp += st.charAt((i+j*N/4+k)%N);
					}
					ts.add(Integer.parseInt(stmp, 16));
				}
			}
			Integer [] ans = new Integer[N/4];
			ans = ts.toArray(ans);
			System.out.println("#"+tc+" "+ans[ans.length -K]);
		}
	}

}
