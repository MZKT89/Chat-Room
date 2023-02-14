

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginUITest1 extends JFrame{

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


    public LoginUITest1() {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Chat Room Login");
        jFrame.setBackground(Color.black);
        jFrame.setResizable(false);

/*
        jFrame.setBounds((int) ((screenSize.getWidth() - (int)(screenSize.getWidth() / 4)) / 2),
                (int) ((screenSize.getHeight() - (int)(screenSize.getHeight() / 4)) / 2), (int)(screenSize.getWidth() / 4), (int)(screenSize.getHeight() / 4));
 */
         jFrame.setLocation((int)(screenSize.getWidth()/3),(int)(screenSize.getHeight())/3);
        //分别创建标签面板，文本框面板
        JPanel pLabel = new JPanel();
        JLabel userName = new JLabel("Username");
        JLabel password = new JLabel("Password");
        pLabel.setLayout(new GridLayout(2, 0));
        pLabel.add(userName);
        pLabel.add(password);
        jFrame.add(pLabel, BorderLayout.WEST);
        JPanel pTextField = new JPanel();
        JTextField userNameText = new JTextField(30);
        JPasswordField passwordText = new JPasswordField(30);
        passwordText.setEchoChar((char)0);
        pTextField.setLayout(new GridLayout(2, 0));
        pTextField.add(userNameText);
        pTextField.add(passwordText);
        //将勾选框和登录按钮放在同一个面板中
        JPanel pOther = new JPanel();
        JCheckBox hidePassword = new JCheckBox("Hide Password",false);
        hidePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox checkbox = (JCheckBox) e.getSource();
                if(checkbox.isSelected()){
                    passwordText.setEchoChar('*');
                }else {
                    //明文显示
                    passwordText.setEchoChar((char)0);
                }
            }
        });

        jFrame.add(pTextField, BorderLayout.EAST);
        JButton loginButton = new JButton("Login");
        pOther.add(hidePassword,BorderLayout.NORTH);
        pOther.add(loginButton,BorderLayout.SOUTH);
        jFrame.add(pOther,BorderLayout.SOUTH);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

}
