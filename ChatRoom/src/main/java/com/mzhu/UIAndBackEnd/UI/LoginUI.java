/*
 * Created by JFormDesigner on Thu Mar 30 22:05:59 CST 2023
 */

package com.mzhu.UIAndBackEnd.UI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.*;

import com.mzhu.UIAndBackEnd.BackEnd.Client;
import com.mzhu.UIAndBackEnd.BackEnd.OperationOnDatabase;
import com.mzhu.UIAndBackEnd.UI.JDialog.JDialogForAll;
import com.mzhu.pojo.User;
import net.miginfocom.swing.*;

/**
 * @author zrh
 */
public class LoginUI extends JFrame implements MouseListener {
    private User user = new User();
    private ChatRoomMain chatRoomMain;
    OperationOnDatabase operation = new OperationOnDatabase();

    public LoginUI() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setAlwaysOnTop(true);
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[98,fill]" +
            "[174,fill]" +
            "[fill]" +
            "[424,fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[59]" +
            "[32]" +
            "[14]" +
            "[63]" +
            "[0]" +
            "[72]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("USERNAME");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 16));
        label1.setForeground(new Color(0x666600));
        contentPane.add(label1, "cell 1 4");
        contentPane.add(textField1, "cell 3 4");

        //---- label2 ----
        label2.setText("PASSWORD");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 16));
        label2.setForeground(new Color(0x9999ff));
        contentPane.add(label2, "cell 1 6");
        contentPane.add(passwordField1, "cell 3 6");

        //---- button1 ----
        button1.setText("Forget Password");
        contentPane.add(button1, "cell 5 6 4 1");

        //---- button2 ----
        button2.setText("Login");
        contentPane.add(button2, "cell 5 7 4 1");

        //---- button3 ----
        button3.setText("Register");
        contentPane.add(button3, "cell 5 8 4 1");
        setSize(807, 512);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        button1.addMouseListener(this);
        button2.addMouseListener(this);
        button3.addMouseListener(this);

        this.setVisible(true);



    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JComponent component = (JComponent) e.getSource();
        if(component == this.button2){
            //登录
            String usernameText = textField1.getText();
            String passwordText = new String(passwordField1.getPassword());
            try {
                User auser = operation.checkingLoginInformation(usernameText,passwordText);
                if(auser != null){
                    if((auser.getUsername().equals(usernameText))&&(auser.getPassword().equals(passwordText))){
                        //登陆成功
                        this.setVisible(false);
                        //开启客户端
                        new Client(auser);
                    }else{
                        new JDialogForAll(this,JDialogForAll.LOGIN_FAILURE);
                        System.out.println("用户名密码不一致");
                    }
                }else{
                    new JDialogForAll(this,JDialogForAll.LOGIN_FAILURE);
                    System.out.println("用户名密码不一致");
                }
            } catch (IOException ex) {
//                throw new RuntimeException(ex);
                new JDialogForAll(this,JDialogForAll.LOGIN_FAILURE);
                System.out.println("用户名密码不一致");
            }
        } else if (component == this.button1) {
            //忘记密码
            System.out.println("点击忘记密码");
            new ForgetPasswordUI();
            this.setVisible(false);
        } else if (component == this.button3) {
            //注册
            System.out.println("注册按钮被点击");
            new RegisterUI();
            this.setVisible(false);

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
