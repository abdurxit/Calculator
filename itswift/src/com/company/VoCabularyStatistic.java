package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
 import java.util.Map;
 import java.util.Scanner;
 public class VoCabularyStatistic {
     public static void main(String[] args) throws IOException//扔掉很重要
     {
         File file = new File("F:\\setup\\git\\Calculator\\itswift\\src\\vocabulary.txt");
         System.out.println("0.统计英文字母个数及其百分比    1.统计英文单词个数");
         Scanner sc = new Scanner(System.in);
         int value = sc.nextInt();
         while (true) {
             switch (value) {
                 case 0:
                     txtString(file);
                 case 1:
                     txtString2(file);
                 default:
                     break;
             }
         }
     }

     /*
      * 统计字母
      */
     public static void txtString(File file) throws IOException {
         try {
             //IO操作读取文件内容
             FileReader fr = new FileReader(file);
             @SuppressWarnings("resource")
             BufferedReader br = new BufferedReader(fr);//构造一个BufferedReader类来读取文件
             HashMap<String, Integer> hm = new HashMap<String, Integer>();//构建了一个新的HashMap对象，强制指定这个HashMap必须是以String为key, 以Integer为值。
             String line = null;
             Integer count = 0;//每个字母的个数
             Integer total = 0;//统计字母总数，作百分比用
             while ((line = br.readLine()) != null) {
                 char[] ch = line.toCharArray();//将字符串对象中的字符转换为一个字符数组。
                 total = total + ch.length;
                 for (int i = 0; i < ch.length; i++) {
                     ch[i] = Character.toLowerCase(ch[i]);//将大写字符转换为小写，小写字母不变
                     count = hm.get(ch[i] + "");//ch[i]+""的作用是加一个空格后，括号内转化为字符串
                     if (count == null) {
                         count = 1;//只出现一次
                     } else {
                         count++;
                     }
                     hm.put(ch[i] + "", count);
                 }
             }
             for (String str : hm.keySet()) {//设变量str获取键
                 System.out.println(str + "个数:" + hm.get(str) + "        " + hm.get(str) * 100.0 / total + "%");
             }
             System.out.println("总字母个数：" + total);//排序输出
             List<Map.Entry<String, Integer>> list_Data = new ArrayList<Map.Entry<String, Integer>>(hm.entrySet());
             Collections.sort(list_Data, new Comparator<Map.Entry<String, Integer>>() {
                 public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                     //o1 to o2升序   o2 to o1降序
                     return o2.getValue().compareTo(o1.getValue());
                 }
             });
             System.out.println("排序输出：");
             System.out.println(hm);
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
     }

     /*
      * 统计单词
      */
     public static void txtString2(File file) throws IOException {
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);//构造一个BufferedReader类来读取文件
         StringBuffer sb = new StringBuffer();
         String line = null;
         while ((line = br.readLine()) != null) {
             sb.append(line);//将读取出的字符追加到stringbuffer中
         }
         fr.close();
         // 关闭读入流
         String str = sb.toString().toLowerCase(); // 将stringBuffer转为字符并转换为小写
         String[] words = str.split("[^(a-zA-Z)]+");  // 非单词的字符来分割，得到所有单词
         Map<String, Integer> map = new HashMap<String, Integer>();
         for (String word : words) {
             if (map.get(word) == null) {  // 若不存在说明是第一次，则加入到map,出现次数为1
                 map.put(word, 1);
             } else {
                 map.put(word, map.get(word) + 1);  // 若存在，次数累加1
             }
         }
         // 排序
         List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
         Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
             public int compare(Map.Entry<String, Integer> left, Map.Entry<String, Integer> right) {
                 int i = left.getValue() - right.getValue();
                 if (i == 0) {
                     return (right.getKey().compareTo(left.getKey()));
                 }
                 return (left.getValue().compareTo(right.getValue()));
             }
         };

         // 集合默认升序
         Collections.sort(list, comparator);
         int n = list.size();
         System.out.println("一共有" + n + "种单词");
         System.out.println("请输入你要排序前几个单词：");
         Scanner scanner = new Scanner(System.in);
         n = scanner.nextInt();
         for (int i = 0; i < n; i++) {// 由高到低输出
             System.out.println(list.get(list.size() - i - 1).getKey() + ":" + list.get(list.size() - i - 1).getValue());
         }
     }
 }