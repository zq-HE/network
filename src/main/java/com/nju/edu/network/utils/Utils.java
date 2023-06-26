package com.nju.edu.network.utils;

import com.nju.edu.network.entity.vo.packageFormat.NetworkInterfacePackage;
import com.nju.edu.network.entity.vo.packageFormat.NetworkPackage;
import com.nju.edu.network.entity.vo.packageFormat.TransportPackage;
import com.nju.edu.network.entity.vo.packageFormat.packagehead.FrameHead;
import com.nju.edu.network.entity.vo.packageFormat.packagehead.IpHead;
import com.nju.edu.network.entity.vo.packageFormat.packagehead.PackageHead;
import com.nju.edu.network.entity.vo.packageFormat.packagehead.UdpHead;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Utils {
    static Charset charset = StandardCharsets.UTF_8;

    public static boolean isSubclassOf(Class<?> subclass, Class<?> superclass) {
        return superclass.isAssignableFrom(subclass);
    }

    public static String ip2To10(String ip) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= 24; i += 8) {
            String part = String.valueOf(Integer.parseInt(ip.substring(i, i + 8), 2));
            result.append(part).append(".");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public static String ip10To2(String ip) {
        String[] splits = ip.split("\\.");
        StringBuilder result = new StringBuilder();
        for (String split : splits) {
            StringBuilder binary = new StringBuilder(Integer.toBinaryString(Integer.parseInt(split)));
            while (binary.length() < 8) {
                binary.insert(0, "0");
            }
            result.append(binary);
        }
        return result.toString();
    }

    public static String mac16To2(String mac) {
        String[] splits = mac.split("-");
        StringBuilder result = new StringBuilder();
        for (String split : splits) {
            StringBuilder binary = new StringBuilder(Integer.toBinaryString(Integer.parseInt(split, 16)));
            while (binary.length() < 8) {
                binary.insert(0, "0");
            }
            result.append(binary);
        }
        return result.toString();
    }


    public static String mac2To16(String mac) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= 40; i += 8) {
            String part = Integer.toHexString(Integer.parseInt(mac.substring(i, i + 8), 2));
            if (part.length() < 2) {
                part = "0" + part;
            }
            result.append(part).append("-");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString().toUpperCase(Locale.ROOT);
    }


    //中文开头的字符串转换了有bug不知道为什么
    public static String dataStringToBinary(String data) {
        byte[] bytes = data.getBytes(charset);
        BigInteger bigInteger = new BigInteger(1, bytes); // 创建一个正数的BigInteger对象
        return bigInteger.toString(2);
    }

    public static String binaryToDataString(String binary) {
        BigInteger bigInteger = new BigInteger(binary, 2);
        byte[] bytes = bigInteger.toByteArray();
        return new String(bytes, charset);
    }

    //二进制默认为
    public static String word10To2(String word){
        StringBuilder result = new StringBuilder(Integer.toBinaryString(Integer.parseInt(word)));
        while(result.length() < 32){
            result.insert(0, "0");
        }
        return result.toString();
    }

    public static String word2To10(String word){
        return String.valueOf(Integer.parseInt(word,2));
    }

    public static void setParentStringFieldsToBinary(Object obj) {
        if(obj == null){
            return;
        }
        try {
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if(field.getType() == String.class){
                    if(field.getName().equals("data")){
                        field.set(obj, Utils.dataStringToBinary((String)field.get(obj)));
                    }
                    else{
                        field.set(obj, Utils.word10To2((String)field.get(obj)));
                    }
                }
                else {
                    setParentStringFieldsToBinary(field.get(obj));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void setParentStringFieldsToTen(Object obj) {
        if(obj == null){
            return;
        }
        try {
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if(field.getType() == String.class){
                    if(field.getName().equals("data")){
                        field.set(obj, Utils.binaryToDataString((String)field.get(obj)));
                    }
                    else{
                        field.set(obj, Utils.word2To10((String)field.get(obj)));
                    }
                }
                else {
                    setParentStringFieldsToBinary(field.get(obj));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static NetworkInterfacePackage testCaseGenerator(){
        UdpHead udpHead = new UdpHead("8080","1654","50","5498");
        TransportPackage transportPackage = new TransportPackage(udpHead,"test message");

        IpHead ipHead = new IpHead("1","20","5","55","55"
                ,"66","52","4546","1","4","192.168.1.1"
                ,"192.168.1.2","5","00000");
        NetworkPackage networkPackage = new NetworkPackage(ipHead, transportPackage);

        FrameHead frameHead = new FrameHead("00-16-EA-AE-3C-40","08-00-20-0A-8C-6D","0","1546");
        NetworkInterfacePackage networkInterfacePackage = new NetworkInterfacePackage(frameHead,networkPackage);
        return networkInterfacePackage;
    }
}
