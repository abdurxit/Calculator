package com.company;

public class SushuTongJI {
    //输出从1到20000之间所有的质数
    public static void main(String[] args) {
        int n = 1;//声明变量n，判断是否换行

        // 质数是从2开始的，所以先遍历2到20000的整数
        for (int i = 2; i <= 20000; i++) {
            //声明变量j，遍历小于i的所有整数
            int j = 2;
            while (i % j != 0) {
                //如果i%j 余数不为0，则 自增，直到余数为0
                j++;
            }
            //如果余数为0，j为除了1之外最小的能被自己整除的整数，判断j是不是本身
            if (i == j) {
                //如果j等于i，输出i

                if (n % 5 != 0) {//判断是否换行
                    System.out.print(i + ",");//如果不是5的倍数，在同行输出
                    n++;
                } else {
                    System.out.println(i);//如果是5的倍数，换行输出
                    n++;
                }
            }
        }
    }
}

