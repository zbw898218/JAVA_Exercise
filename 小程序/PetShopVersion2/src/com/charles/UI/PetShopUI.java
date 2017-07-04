package com.charles.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Charles on 2017/6/30
 */
public class PetShopUI {
    JFrame frame=new JFrame("Charles's PetShop");
    JPanel panel=new JPanel();
    JPanel panel1=new JPanel();
    JPanel panel2=new JPanel();
    JPanel panel3=new JPanel();
    JTextArea views=new JTextArea();
    JTextField textField=new JTextField();
    JLabel titile=new JLabel();
    JLabel label1=new JLabel();
    JLabel label2=new JLabel();
    JLabel label3=new JLabel();
    JButton submit=new JButton("确定");
    JButton back=new JButton("取消");
    public void start(){
        frame.setLayout(new BorderLayout());
        frame.add(panel,BorderLayout.SOUTH);
        frame.add(panel1,BorderLayout.WEST);
        frame.add(panel2,BorderLayout.NORTH);
        frame.add(panel3,BorderLayout.CENTER);
        frame.setSize(800,600);
        frame.setVisible(true);
        titile.setText("dsajfklfdsafjkl");
        panel2.add(titile);
        Box box=Box.createVerticalBox();
        Box box1=Box.createHorizontalBox();
        label1.setText("hello123");
        label2.setText("hello123");
        label3.setText("hello123");
        box.add(label1);
        box.add(label2);
        box.add(label3);

        panel1.add(box);
        box1.add(submit);
        box1.add(back);
        views.setColumns(2);
//        views.append("fdjklafbelkfkl" +
//                "kabfkweafkef"+"kaeafkef"+"kabfkweafkef"+"kabfkweafkef");
        panel3.add(views);
//        panel.setLayout(new BorderLayout());
        panel.add(box1);

    }
    public static void main(String[] args){
        PetShopUI petShopUI=new PetShopUI();
        petShopUI.start();
    }
}
