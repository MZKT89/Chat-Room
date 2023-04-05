/*
 * Created by JFormDesigner on Fri Mar 31 11:05:46 CST 2023
 */

package com.mzhu.UIAndBackEnd.UI.JDialog;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author zrh
 */
public class JDialogForAll extends JDialog implements MouseListener {
    public static final int  LOGIN_FAILURE = 0;
    public static final int  USER_FAIL_TO_EXIST = 1;
    public static final int  CHANGE_PASSWORD_FAILURE = 2;
    public static final int  USER_ENTERED_EXIST = 3;
    public static final int  REGISTER_FAILURE = 4;

    private int command;

    public JDialogForAll(Window owner,int command) {
        super(owner);
        this.command = command;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        buttonBar = new JPanel();
        okButton = new JButton();

        //======== this ========
        setTitle("title");
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
                    "[84,fill]" +
                    "[411,fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[5]" +
                    "[295]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //---- label1 ----
                label1.setText("text");
                label1.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD, 16));
                contentPanel.add(label1, "cell 1 1 1 2,grow");
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setLayout(new MigLayout(
                    "insets dialog,alignx right",
                    // columns
                    "[button,fill]",
                    // rows
                    null));

                //---- okButton ----
                okButton.setText("OK");
                buttonBar.add(okButton, "cell 0 0");
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        if(command == LOGIN_FAILURE){
            this.setTitle("Login Failure");
            label1.setText("The username or password provided is incorrect !!!");
            this.setVisible(true);
        } else if (command == USER_FAIL_TO_EXIST) {
            this.setTitle("User Fails To Exist");
            label1.setText("The user doesn't exist. Please enter the existed username.");
            this.setVisible(true);
        } else if (command == CHANGE_PASSWORD_FAILURE) {
            this.setTitle("Change Password Failure");
            label1.setText("Fail To Change The Password.");
            this.setVisible(true);
        } else if (command == USER_ENTERED_EXIST) {
            this.setTitle("User Entered Exist");
            label1.setText("The User Entered Existed. Please Change The Username.");
            this.setVisible(true);
        } else if (command == REGISTER_FAILURE) {
            this.setTitle("Register Failure");
            label1.setText("Fail To Register");
            this.setVisible(true);
        }
        okButton.addMouseListener(this);


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JPanel buttonBar;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
JComponent component = (JComponent) e.getSource();
if(component == this.okButton){
    this.setVisible(false);
}
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
