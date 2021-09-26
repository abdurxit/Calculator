package com.company;

import java.awt.*; //添加AWT库
import javax.swing.JLabel; //添加swing库
public class JAVA_Gui_HelloWorld {
    public static void main(String[] args) {
// TODO 自动生成的方法存根
        Frame frame=new Frame("hello world");//创建图形用户界面，并设置界面的标题
        Panel panel=new Panel(); //创建类panel的对象P1
        JLabel lad=new JLabel("Hello world"); //创建属于类JLabel的对象，并设置在标签中显示的内容
        frame.setSize(300,300); //设置界面的宽度和高度
        frame.setVisible(true); //设置界面的可见性
        frame.setBackground(Color.gray);//设置界面的背景颜色
        frame.add(panel); //将面板p1添加到界面中
        panel.add(lad); //将标签lad添加到面板p1中
    }
}
