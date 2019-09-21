package com.king.util;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

public class RandomUtil {

    public static String createLogId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     * 生成随机序列数[0, maxValue)
     * @param maxValue
     * @return
     */
    public static int createSeq(int maxValue) {
        SecureRandom random = new SecureRandom();
        return random.nextInt(maxValue);
    }
    
    /**
     * 生成16位不重复的随机数，含数字+大小写
     * @return
     */
    public static String getGUID(int length) {
        StringBuilder uid = new StringBuilder();
        //产生16位的强随机数
        Random rd = new SecureRandom();
        for (int i = 0; i < length; i++) {
            //产生0-2的3位随机数
            int type = rd.nextInt(3);
            switch (type){
                case 0:
                    //0-9的随机数
                    uid.append(rd.nextInt(10));
                    break;
                case 1:
                    //ASCII在65-90之间为大写,获取大写随机
                    uid.append((char)(rd.nextInt(25)+65));
                    break;
                case 2:
                    //ASCII在97-122之间为小写，获取小写随机
                    uid.append((char)(rd.nextInt(25)+97));
                    break;
                default:
                    break;
            }
        }
        return uid.toString();
    }

}
