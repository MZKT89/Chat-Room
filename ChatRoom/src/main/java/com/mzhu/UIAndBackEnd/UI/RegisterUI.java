/*
 * Created by JFormDesigner on Sat Apr 01 16:14:19 CST 2023
 */

package com.mzhu.UIAndBackEnd.UI;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

import com.mzhu.UIAndBackEnd.BackEnd.OperationOnDatabase;
import com.mzhu.UIAndBackEnd.UI.JDialog.JDialogForAll;
import com.mzhu.pojo.User;
import net.miginfocom.swing.*;

/**
 * @author zrh
 */
public class RegisterUI extends JFrame implements MouseListener{
    public RegisterUI() {
        initComponents();
    }

    User user = new User();

    private void textField2KeyTyped(KeyEvent e) {
        //限制年龄只能输入数字
        String key="0123456789"+(char)8;
        if(key.indexOf(e.getKeyChar())<0){
            e.consume();//如果不是数字则取消
        }
    }

    private void radioButton1ItemStateChanged(ItemEvent e) {
        // male
        user.setGender("Male");
    }

    private void radioButton2ItemStateChanged(ItemEvent e) {
        // Female
        user.setGender("Female");
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
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        buttonBar = new JPanel();
        okButton = new JButton();

        //======== this ========
        setResizable(false);
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
                    "[65,fill]" +
                    "[44,fill]" +
                    "[fill]" +
                    "[62,fill]" +
                    "[190,fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[124,fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[54]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[33]" +
                    "[50]" +
                    "[]"));

                //---- label1 ----
                label1.setText("Username");
                label1.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD | Font.ITALIC, 20));
                label1.setForeground(new Color(0x9999ff));
                contentPanel.add(label1, "cell 1 1 3 1");
                contentPanel.add(textField1, "cell 4 1 5 1");

                //---- label2 ----
                label2.setText("Password");
                label2.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD | Font.ITALIC, 20));
                label2.setForeground(new Color(0x9966ff));
                contentPanel.add(label2, "cell 1 3 3 1");
                contentPanel.add(passwordField1, "cell 4 3 5 1");

                //---- label3 ----
                label3.setText("Age");
                label3.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD | Font.ITALIC, 20));
                label3.setForeground(new Color(0x990099));
                contentPanel.add(label3, "cell 1 5 3 1");

                //---- textField2 ----
                textField2.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        textField2KeyTyped(e);
                    }
                });
                contentPanel.add(textField2, "cell 4 5");

                //---- label4 ----
                label4.setText("Address");
                label4.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD | Font.ITALIC, 20));
                label4.setForeground(new Color(0x330033));
                contentPanel.add(label4, "cell 1 7 3 1");
                contentPanel.add(textField3, "cell 4 7 5 1");

                //---- radioButton1 ----
                radioButton1.setText("Male");
                radioButton1.addItemListener(e -> radioButton1ItemStateChanged(e));
                contentPanel.add(radioButton1, "cell 1 9");

                //---- radioButton2 ----
                radioButton2.setText("Female");
                radioButton2.addItemListener(e -> radioButton2ItemStateChanged(e));
                contentPanel.add(radioButton2, "cell 3 9");
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setLayout(new MigLayout(
                    "insets dialog,alignx right",
                    // columns
                    "[button,fill]",
                    // rows
                    "[]" +
                    "[]"));

                //---- okButton ----
                okButton.setText("Register");
                buttonBar.add(okButton, "cell 0 0");
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(700, 482);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        okButton.addMouseListener(this);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
        OperationOnDatabase operation = new OperationOnDatabase();
    @Override
    public void mouseReleased(MouseEvent e) {
        JComponent component = (JComponent) e.getSource();
        if(component == this.okButton){
            System.out.println("用户注册");
            user.setUsername(textField1.getText());
            user.setPassword(new String(passwordField1.getPassword()));
            user.setAge(Integer.parseInt(textField2.getText()));
            user.setAddress(textField3.getText());
            System.out.println(user);
            if(user.getUsername() != null && user.getPassword() != null){
                try{
                    //先查用户是否存在
                    boolean checkResult = operation.checkUsernameExistence(user.getUsername());
                    if(checkResult){
                        //用户名存在
                        System.out.println("用户名已存在重新输入");
                        //加载提示弹窗...
                        new JDialogForAll(this,JDialogForAll.USER_ENTERED_EXIST);
                    }else{
                        // 调用operation中的addUser
                        boolean addResult = operation.addUser(user);
                        if(addResult){
                            //添加成功
                            System.out.println("添加成功");
                            this.setVisible(false);
                            new LoginUI();
                        }else{
                            //添加失败，加载提示弹窗
                            System.out.println("添加失败");
                            new JDialogForAll(this,JDialogForAll.REGISTER_FAILURE);
                        }
                    }
                }catch (IOException exception){
                    exception.getStackTrace();
                }
            }
            else{
                //注册失败
                System.out.println("注册失败");
                new JDialogForAll(this,JDialogForAll.REGISTER_FAILURE);
               }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

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
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JPanel buttonBar;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
