package chap4;

import java.util.Scanner;

public class Check753 {
    private static int count =  0;

    //base: 現在の値
    //flag: 7,5,3のうち、どれを使ったか
    public static void check753(int target, long base, int flag) {
        if(base > target) return;
        if(flag == 0b111) {
            count++;
        }
        final long next = base*10;
        // flag "or" だから、既に5(010)があったら、+3をすると、(011)になる。
        check753(target, next+3, flag | 0b001);
        check753(target, next+5, flag | 0b010);
        check753(target, next+7, flag | 0b100);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = Integer.parseInt(sc.nextLine());
        check753(target, 0, 0);
        System.out.println(count);
    }

}
