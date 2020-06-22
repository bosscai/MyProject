package KCode;

import java.io.*;
import java.lang.reflect.Method;

public class KcodeMain {
    public static void main(String[] args) throws Exception {
        // "demo.data" 是你从网盘上下载的测试数据，这里直接填你的本地绝对路径
//        InputStream fileInputStream = new FileInputStream("demo.data");
//        Class<?> clazz = Class.forName("com.kuaishou.kcode.KcodeQuestion");
        InputStream fileInputStream = new FileInputStream("D:/Kcode/2kcodeRpcMonitor.data");
        Class<?> clazz = Class.forName("KCode.KcodeQuestion");
        Object instance = clazz.newInstance();
        Method prepareMethod = clazz.getMethod("prepare", InputStream.class);
        Method getResultMethod = clazz.getMethod("getResult", Long.class, String.class);
        // 调用prepare()方法准备数据
        prepareMethod.invoke(instance, fileInputStream);

        // 验证正确性
        // "result.data" 是你从网盘上下载的结果数据，这里直接填你的本地绝对路径
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("result.data")));
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line;
        line = reader.readLine();
        System.out.println(line);
//        while ((line = reader.readLine()) != null) {
//            String[] split = line.split("\\|");
//            String[] keys = split[0].split(",");
//            // 调用getResult()方法
//            Object result = getResultMethod.invoke(instance, new Long(keys[0]), keys[1]);
//            if (!split[1].equals(result)) {
//                System.out.println("fail");
//            }
//            // System.out.println("success");
//        }
    }

}
