package Job2019.B54;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

/*
 * 思路：
 * 1.将区间按照右端大小排列
 * 2.如果第一个区间的right<第二个区间的left，说明两个区间没有交集，则第一个区间需要两个数
 * */
public class Main {
    private static class Line{
        int left,right;
        public Line(int left,int right){
            this.left=left;
            this.right=right;
        }
    }
    private static class cmp implements Comparator<Line>{
        @Override
        public int compare(Line o1, Line o2) {
            int t = o1.right - o2.right;
            if (t == 0){
                t = o2.left - o1.left;
            }
            return t;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //存储数组的数量
        int n = scanner.nextInt();
        Line[] lines = new Line[n];
        for (int i=0;i<n;i++){
            lines[i] = new Line(scanner.nextInt(), scanner.nextInt());
        }
        int cnt = 2;
        Arrays.sort(lines,0, n, new cmp());
        int l1 = lines[0].right;
        int l2 = lines[0].right - 1;
        for (int i = 1; i < n ; i++) {
            if (l1<lines[i].left){
                //两者完全不交叉
                cnt+=2;
                l1=lines[i].right;
                l2=lines[i].right-1;
            }
            else if (l1>=lines[i].left&&l1<lines[i].right&&l2<lines[i].left){
                //l1大于左边，但是小于右边，同时不足一公分的富余量
                cnt+=1;
                l2=l1;
                l1=lines[i].right;
            }else if (l1<=lines[i].right&&l2>=lines[i].left){
                //l1的右边小于它的右边，同时大于一公分的富余量
                continue;
            }
        }
        System.out.println(cnt);
    }
}

