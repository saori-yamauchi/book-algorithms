package chap5;

import java.util.Scanner;

public class Vacation {
    public static void vacation(int n, int[] a, int[] b, int[] c) {
        int[][] dp = new int[n+1][3];
        for(int i=0; i<n; i++) {
            //i+1日にabc(=0,1,2)それぞれを選んだ場合のi+1日の幸福度
            //選んだ活動以外のi日までの最大幸福度に選んだ幸福度を足して比較
            dp[i+1][0] = Math.max(dp[i][1]+a[i], dp[i][2]+a[i]);
            dp[i+1][1] = Math.max(dp[i][0]+b[i], dp[i][2]+b[i]);
            dp[i+1][2] = Math.max(dp[i][0]+c[i], dp[i][1]+c[i]);
        }
        //最終日のa,b,c比較
        int max = 0;
        for(int j=0; j<3; j++) {
            max = Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int[] a = new int[N];
        int[] b = new int[N];
        int[] c = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(sc.next());
            b[i] = Integer.parseInt(sc.next());
            c[i] = Integer.parseInt(sc.next());
        }
        vacation(N, a,b,c);
    }
}
