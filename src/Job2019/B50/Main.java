package Job2019.B50;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int count=0;
        int[][] a=new int[n][2];
        for(int i=0;i<n;i++){
            String[] str=br.readLine().split(" ");
            a[i][0]=Integer.parseInt(str[0]);
            a[i][1]=Integer.parseInt(str[1]);
        }
        for(int j=0;j<n;j++){
            if(cover(a,n,a[j][0],a[j][1],j+1)){
                count++;
            }
        }
        System.out.println(count);
    }
    private static boolean cover(int[][] a,int n,int Li,int Ri,int next){
        if(Li==Ri)
            return false;
        if(next>=n)
            return true;
        if(a[next][0]<=Li&&Ri<=a[next][1])  //(x,y)被完全覆盖
            return false;
        else if(a[next][0]>=Ri||a[next][1]<=Li)//不交叠
            return cover(a,n,Li,Ri,next+1);
        else if(Li<=a[next][0]&&a[next][1]<=Ri)
            return cover(a,n,Li,a[next][0],next+1) || cover(a,n,a[next][1],Ri,next+1);
        else if(Li<a[next][1]&&a[next][1]<=Ri)
            return cover(a,n,a[next][1],Ri,next+1);
        else if(Li<a[next][0]&&a[next][0]<Ri)
            return cover(a,n,Li,a[next][0],next+1);
        return false;
    }
}
