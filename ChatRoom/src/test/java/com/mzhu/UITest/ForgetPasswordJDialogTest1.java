/*
 * Created by JFormDesigner on Mon Feb 20 18:37:29 CST 2023
 */

package com.mzhu.UITest;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.*;

import com.mzhu.pojo.User;
import net.miginfocom.swing.*;

/**
 * @author zrh
 */
public class ForgetPasswordJDialogTest1 extends JDialog {
    operationOnDatabaseTest1 operation = new operationOnDatabaseTest1();
    User user = new User();

    public ForgetPasswordJDialogTest1() throws IOException{

        initComponents();
    }

    private void changePassword(ActionEvent e) throws IOException {
        System.out.println(user);
        if(user.getUsername() != null&&user.getPassword()!= null){
            //先查用户是否存在
            System.out.println("准备执行修改密码的方法");
            boolean checkResult = operation.checkUsernameExistence(user.getUsername());
            if(checkResult){
                //用户名存在,可以修改
                // 调用operation中的changePassword
                boolean changeResult = operation.changePassword(user.getPassword(),user.getUsername());
                if(changeResult){
                    System.out.println("修改成功");
                }else{
                    System.out.println("修改失败");
                }

            }else{
                System.out.println("用户名不存在，修改失败");
            }
        }
    }

    private void textField1(ActionEvent e) {
        // username Text
        JTextField usernameField  = (JTextField)  e.getSource();
        user.setUsername(usernameField.getText());
    }

    private void passwordField1(ActionEvent e) {
        // password text
        JPasswordField passwordField = (JPasswordField) e.getSource();
        String password = new String(passwordField.getPassword());
        user.setPassword(password);
    }

    private void initComponents() throws IOException{
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialog1 = new JDialog();
        label3 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();

        //======== dialog1 ========
        {
            dialog1.setTitle("Forget Password");
            dialog1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var dialog1ContentPane = dialog1.getContentPane();
            dialog1ContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[146,fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[35,fill]" +
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
                "[]"));

            //---- label3 ----
            label3.setText("Username");
            dialog1ContentPane.add(label3, "cell 1 2");

            //---- textField1 ----
            textField1.addActionListener(e -> {
			textField1(e);
			textField1(e);
		});
            dialog1ContentPane.add(textField1, "cell 2 2 6 1");

            //---- label2 ----
            label2.setText("New Password");
            dialog1ContentPane.add(label2, "cell 1 5");

            //---- passwordField1 ----
            passwordField1.addActionListener(e -> passwordField1(e));
            dialog1ContentPane.add(passwordField1, "cell 2 5 6 1");

            //---- button1 ----
            button1.setText("Reset");
            button1.addActionListener(e -> {
                try {
                    changePassword(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            dialog1ContentPane.add(button1, "cell 7 8");
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        dialog1.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JDialog dialog1;
    private JLabel label3;
    private JTextField textField1;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
