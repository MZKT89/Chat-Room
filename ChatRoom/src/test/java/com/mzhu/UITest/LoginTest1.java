/*
 * Created by JFormDesigner on Mon Feb 20 18:27:56 CST 2023
 */

package com.mzhu.UITest;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author zrh
 */
public class LoginTest1 extends JFrame {
    public LoginTest1() {
        initComponents();
    }

    private void button3MouseClicked(MouseEvent e) throws IOException {
        // Forget password
        new ForgetPasswordJDialogTest1();
    }

    private void button1MouseClicked(MouseEvent e) {
        // Register
        new RegisterTest1().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        button3 = new JButton();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setForeground(SystemColor.inactiveCaption);
        setTitle("Chat Room Login");
        setType(Window.Type.UTILITY);
        setAlwaysOnTop(true);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[125,fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[153,fill]" +
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
            "[]"));

        //---- label1 ----
        label1.setText("Username");
        contentPane.add(label1, "cell 2 2");
        contentPane.add(textField1, "cell 3 2 5 1");

        //---- label2 ----
        label2.setText("Password");
        contentPane.add(label2, "cell 2 4");
        contentPane.add(passwordField1, "cell 3 4 5 1");

        //---- button3 ----
        button3.setText("Forget Password");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    button3MouseClicked(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        contentPane.add(button3, "cell 7 5");

        //---- button1 ----
        button1.setText("Register");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1, "cell 5 8 2 1");

        //---- button2 ----
        button2.setText("Login");
        contentPane.add(button2, "cell 7 8");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JButton button3;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
