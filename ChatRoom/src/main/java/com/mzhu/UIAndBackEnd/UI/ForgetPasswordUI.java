/*
 * Created by JFormDesigner on Fri Mar 31 12:09:14 CST 2023
 */

package com.mzhu.UIAndBackEnd.UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.*;

import com.mzhu.UIAndBackEnd.BackEnd.OperationOnDatabase;
import com.mzhu.UIAndBackEnd.UI.JDialog.JDialogForAll;
import com.mzhu.pojo.User;
import net.miginfocom.swing.*;

/**
 * @author zrh
 */
public class ForgetPasswordUI extends JFrame implements MouseListener {
    public ForgetPasswordUI() {
        initComponents();
    }
    OperationOnDatabase operation = new OperationOnDatabase();
    User user = new User();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        buttonBar = new JPanel();
        okButton = new JButton();

        //======== this ========
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
                    "[245,fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[60]" +
                    "[]" +
                    "[]" +
                    "[58]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //---- label1 ----
                label1.setText("Username");
                label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
                contentPanel.add(label1, "cell 1 1 3 1");
                contentPanel.add(textField1, "cell 4 1 2 1");

                //---- label2 ----
                label2.setText("Password");
                label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
                contentPanel.add(label2, "cell 1 4 3 1");
                contentPanel.add(passwordField1, "cell 4 4 2 1");
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
        okButton.addMouseListener(this);
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

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JComponent component = (JComponent) e.getSource();
        if(component == this.okButton) {
            String usernameText = textField1.getText();
            String passwordText = new String(passwordField1.getPassword());
            System.out.println(usernameText + ": " + passwordText);
            if (usernameText != null && passwordText != null) {
                //先查用户是否存在
                System.out.println("准备执行修改密码的方法");

                try {
                    boolean checkResult = operation.checkUsernameExistence(user.getUsername());
                    if (checkResult) {
                        //用户名存在,可以修改
                        // 调用operation中的changePassword
                        try {
                            boolean  changeResult = operation.changePassword(user.getPassword(), user.getUsername());
                            if (changeResult) {
                                System.out.println("修改成功");
                                this.setVisible(false);
                                new LoginUI();
                            } else {
                                new JDialogForAll(this,JDialogForAll.CHANGE_PASSWORD_FAILURE);
                                System.out.println("修改失败");
                            }
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else {

                        new JDialogForAll(this,JDialogForAll.USER_FAIL_TO_EXIST);
                        System.out.println("用户名不存在，修改失败");
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }

        }
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
    private JPanel buttonBar;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
