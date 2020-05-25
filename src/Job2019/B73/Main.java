package Job2019.B73;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    //算法步骤：
    //1，根据不同类型进行分类，采用map
    //2，统计各个种类的个数
    //2.1 个数小于则补满
    //2.2 个数大于则看到底需要几个圈，团块
    //3，把所有团块数量求和
    //求和公式为 ∑(团块数量 * （团块类型 + 1 )）
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line1 = scan.nextLine();
        // 本人比较喜欢整形数组，所以转为为整形来操作
        int[] childs = strToIntArray(line1);
        // core
        int ans = minChildren(childs);
        System.out.println(ans);

        // 关闭输入流
        scan.close();
    }
    private static int minChildren(int[] childs) {
        // 设置最少获得糖果的小朋友(answer)的值0
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < childs.length; i++) {
            // 这句话比较漂亮，省了if……else判断map是否包含此key
            map.put(childs[i], map.getOrDefault(childs[i], 0) + 1);
        }
        // 累加求和，otherCandy + map,get(otherCandy)是补满操作
        // 即使现在为1，那么加上otherCandy以后就能被整除
        for (Integer otherCandy : map.keySet()) {
            //先抹掉余数，在乘积的基础上多加一个
            ans += (otherCandy + map.get(otherCandy)) / (otherCandy + 1) * (otherCandy + 1);
        }
        return ans;
    }


    // 将String转为数组
    private static int[] strToIntArray(String line1) {
        String[] strArr = line1.split(" ");
        int[] intArr = new int[strArr.length];
        // 将string转换为整数
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.valueOf(strArr[i]);
        }
        // 返回结果
        return intArr;
    }
}
