package Algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Greedy {
    public static void main(String[] args) {
        Math.pow(3, 2);
        //创建广播电台，放入到Map
        HashMap<String, HashSet<String>> broadcast = new HashMap<>();
        //将各个城市刚入到
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();

        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("天津");
        hashSet4.add("上海");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("大连");
        hashSet5.add("杭州");
        //加入到Map
        broadcast.put("K1", hashSet1);
        broadcast.put("K2", hashSet2);
        broadcast.put("K3", hashSet3);
        broadcast.put("K4", hashSet4);
        broadcast.put("K5", hashSet5);
        //allAreas存放所有的地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建ArrayList，存放电台集合
        ArrayList<String> selects = new ArrayList<>();
        //定义一个临时的集合，在遍历的过程中，存放遍历过程中的电台覆盖的地区和当前还没有覆盖地区的交集
        HashSet<String> tempSet ;
        //定义一个maxKey，保存在一次遍历中，能够覆盖
        String maxkey = null;
        while (!allAreas.isEmpty()){
            maxkey = null;
            tempSet= new HashSet<>();
            //不为零，则还没有覆盖掉所有地区
            for (String key : broadcast.keySet()){
                //当前这个key能够覆盖的地区
                tempSet = broadcast.get(key);
//                tempSet.addAll(areas);
                tempSet.retainAll(allAreas);
                //如果当前指向的没有maxkey多，那么就指向maxkey；
                if (!tempSet.isEmpty() &&
                        (maxkey == null || tempSet.size() > broadcast.get(maxkey).size())){
                    maxkey = key;
                }
            }
            //maxKey != null,就应该将maxKey加入selects
            if (maxkey != null){
                selects.add(maxkey);
                //清除掉已经选中的地区
                allAreas.removeAll(broadcast.get(maxkey));
            }
        }
        System.out.println("得到的选择结果是" + selects);
    }

    int cutRope(int number) {
        if(number < 4) return number - 1;
        int x = number / 3, y = number % 3;
        double[] f = {1, 4/3.0, 2};
        return (int)(Math.pow(3, x)*f[y]);
    }
}
