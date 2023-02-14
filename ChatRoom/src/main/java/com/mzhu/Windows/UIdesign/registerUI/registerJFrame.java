package com.mzhu.Windows.UIdesign.registerUI;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class registerJFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public registerJFrame(){
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Chat Room Registry");
        jFrame.setBackground(Color.black);
        jFrame.setResizable(false);
        jFrame.setLocation((int)(screenSize.getWidth()/3),(int)(screenSize.getHeight())/3);
        JPanel pLabel = new JPanel();
        pLabel.setLayout(new GridLayout(4,0));
        JLabel userName = new JLabel("Username");
        JLabel password = new JLabel("Password");
        JLabel age  = new JLabel("Age");
        JLabel address  = new JLabel("Address");
        pLabel.add(userName);
        pLabel.add(password);
        pLabel.add(age);
        pLabel.add(address);
        JPanel pText = new JPanel();
        pText.setLayout(new GridLayout(4,0));
        JTextField userNameText = new JTextField(30);
        JTextField passwordText = new JTextField(30);
        JTextField ageText = new JTextField(30);
        JTextField addressText = new JTextField(30);
        pText.add(userNameText);
        pText.add(passwordText);
        pText.add(ageText);
        pText.add(addressText);
        jFrame.add(pText,BorderLayout.EAST);
        jFrame.add(pLabel,BorderLayout.WEST);



        //性别给出两个选项放入另一个面板中
        JPanel genderPanelAndButton = new JPanel();
        JPanel genderPanel = new JPanel();
        JPanel pButton = new JPanel();
        genderPanel.setLayout(new GridLayout(2,3));
        JLabel gender  = new JLabel("Gender");
        Checkbox male = new Checkbox("male");
        Checkbox female = new Checkbox("female");
        CheckboxGroup group = new CheckboxGroup();
        male.setCheckboxGroup(group);
        female.setCheckboxGroup(group);
        genderPanel.add(gender);
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanelAndButton.add(genderPanel,BorderLayout.NORTH);
        JButton registry = new JButton("register");
        JButton returnToLogin = new JButton("Return to Login");
        pButton.add(registry,BorderLayout.WEST);
        pButton.add(returnToLogin,BorderLayout.EAST);
        genderPanelAndButton.add(pButton,BorderLayout.SOUTH);
        jFrame.add(genderPanelAndButton,BorderLayout.SOUTH);


        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
