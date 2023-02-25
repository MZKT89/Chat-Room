/*
 * Created by JFormDesigner on Mon Feb 20 18:51:57 CST 2023
 */

package com.mzhu.UITest;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

import com.mzhu.pojo.User;
import net.miginfocom.swing.*;

/**
 * @author zrh
 */
public class RegisterTest1 extends JFrame {

    //注册的用户
    private User user = new User();
    //数据库操作
    operationOnDatabaseTest1 operation = new operationOnDatabaseTest1();

    public RegisterTest1() {
        initComponents();
    }

    private void textField1(ActionEvent e) {
        // username Text
        JTextField usernameField  = (JTextField) e.getSource();
        System.out.println(usernameField.getText());
        this.user.setUsername(usernameField.getText());
    }

    private void passwordField1(ActionEvent e) {
        // password text
        JPasswordField passwordField = (JPasswordField) e.getSource();
        String password = new String(passwordField.getPassword());
        System.out.println(passwordField.getPassword());
        this.user.setPassword(password);
    }

    private void textField2(ActionEvent e) {
        // age
        JTextField ageField  = (JTextField) e.getSource();
        int age = Integer.parseInt(ageField.getText());
        System.out.println(age);
        this.user.setAge(age);

    }

    private void textField3(ActionEvent e) {
        // address text
        JTextField addressField  = (JTextField) e.getSource();
        System.out.println(addressField.getText());
        this.user.setAddress(addressField.getText());
    }

    private void textField2KeyTyped(KeyEvent e) {
        //限制年龄只能输入数字
        String key="0123456789"+(char)8;
        if(key.indexOf(e.getKeyChar())<0){
            e.consume();//如果不是数字则取消
        }
    }

    private void radioButton1ItemStateChanged(ItemEvent e) {
        // male
        user.setGender("male");
    }

    private void radioButton2ItemStateChanged(ItemEvent e) {
        // female
        user.setGender("female");
    }

    private void RegisterConfirmed(ActionEvent e) throws IOException {

        System.out.println(user);
            //用户名和密码同时存在
       if(user.getUsername() != null && user.getPassword() != null){
           //先查用户是否存在
           boolean checkResult = operation.checkUsernameExistence(user.getUsername());
           if(checkResult){
               //用户名存在
               System.out.println("用户名已存在重新输入");
               //加载提示弹窗...


           }else{
               // 调用operation中的addUser
               boolean addResult = operation.addUser(user);
               if(addResult){
                   //添加成功，加载提示弹窗
                   System.out.println("添加成功");
                   this.setVisible(false);
               }else{
                   //添加失败，加载提示弹窗
                   System.out.println("添加失败");
               }
           }



       }
       else{
           //注册失败
           System.out.println("注册失败");
       }
       //重新加载登录界面

    }







    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField3 = new JTextField();
        buttonBar = new JPanel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        button1 = new JButton();

        //======== this ========
        setTitle("Register");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new MigLayout(
                    "insets dialog,hidemode 3",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[133,fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //---- label1 ----
                label1.setText("Username");
                contentPanel.add(label1, "cell 0 2 1 3");

                //---- textField1 ----
                textField1.addActionListener(e -> textField1(e));
                contentPanel.add(textField1, "cell 3 3 7 1");

                //---- label2 ----
                label2.setText("Password");
                contentPanel.add(label2, "cell 0 6 1 3");

                //---- passwordField1 ----
                passwordField1.addActionListener(e -> passwordField1(e));
                contentPanel.add(passwordField1, "cell 3 7 7 1");

                //---- label3 ----
                label3.setText("Age");
                contentPanel.add(label3, "cell 0 10 1 3");

                //---- textField2 ----
                textField2.addActionListener(e -> textField2(e));
                textField2.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        textField2KeyTyped(e);
                    }
                });
                contentPanel.add(textField2, "cell 3 11 4 1");

                //---- label4 ----
                label4.setText("Address");
                contentPanel.add(label4, "cell 0 14");

                //---- textField3 ----
                textField3.addActionListener(e -> textField3(e));
                contentPanel.add(textField3, "cell 3 14 7 1");
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setLayout(new MigLayout(
                    "insets dialog,alignx right",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[button,fill]",
                    // rows
                    null));

                //---- radioButton1 ----
                radioButton1.setText("Male");
                radioButton1.addItemListener(e -> radioButton1ItemStateChanged(e));
                buttonBar.add(radioButton1, "cell 0 0");

                //---- radioButton2 ----
                radioButton2.setText("Female");
                radioButton2.addItemListener(e -> radioButton2ItemStateChanged(e));
                buttonBar.add(radioButton2, "cell 1 0");

                //---- button1 ----
                button1.setText("Register");
                button1.addActionListener(e -> {
                    try {
                        RegisterConfirmed(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                buttonBar.add(button1, "cell 11 0");
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField3;
    private JPanel buttonBar;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
