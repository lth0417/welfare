package cn.com.sise.welfare.utils;

import java.util.Random;

public class CodeUtils {

    public static String getOrgCode() {
        //取当前时间的长整形值包含毫秒  long millis = System.nanoTime()
        long millis = System.currentTimeMillis();
        //加上两位随机数
        Random random = new Random();
        int num = random.nextInt(99);
        //如果不足两位前面补0
        String res = "440"+millis + String.format("%02d", num);
        return res;
    }


    public static String getImgName() {
        //取当前时间的长整形值包含毫秒  long millis = System.nanoTime()
        long millis = System.currentTimeMillis();
        //加上两位随机数
        Random random = new Random();
        int num = random.nextInt(999);
        //如果不足两位前面补0
        String res = "img_"+millis + String.format("%03d", num);
        return res;
    }
}
