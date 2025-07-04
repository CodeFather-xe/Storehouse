package UI_Storehouse;

import Shapes.PanelBackground;
import Shapes.RoundLabel;
import Shapes.RoundedTextField;
import Shapes.RoundedPasswordField;

import javax.swing.*;
import java.awt.*;

public class CreateAccount {


    JFrame frame = new JFrame();
    JPanel TransparentBackground = new JPanel();
    JLabel WelcomeText = new JLabel();
    RoundLabel ImageLabel = new RoundLabel();
    JLabel UsernameText = new JLabel();
    JLabel PasswordText = new JLabel();
    JLabel ConfirmPasswordText = new JLabel();
    RoundedTextField UsernameField = new RoundedTextField("", 20);
    RoundedPasswordField PasswordField = new RoundedPasswordField(20, 20);
    RoundedPasswordField ConfirmPasswordField = new RoundedPasswordField(20, 20);
    JRadioButton ShowPasswordButton = new JRadioButton();
    JButton loginButton = new JButton();
    JButton GoBack = new JButton();
    ImageIcon imageProfile = new ImageIcon("src");
    JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);

    public CreateAccount() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(frame);
            frame.revalidate();
            frame.repaint();
        } catch (Exception _) {
        }
        JFrame.setDefaultLookAndFeelDecorated(true);

        frame.setTitle("GSSA StoreHouse");
        frame.setSize(600, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        ImageIcon frameLogo = new ImageIcon("src\\Resources\\Storehouse Logo.png");
        Image frameImage = frameLogo.getImage();
        frame.setIconImage(frameImage);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*-------Modifies Panels-------*/
        TransparentBackground.setBackground(new Color(0, 0, 0, 150));
        TransparentBackground.setLayout(null);
        TransparentBackground.setBounds(10, 10, 565, 745);
        //--------------//
        PanelBackground MainBackground = new PanelBackground("src\\Resources\\BackgroundLogin.jpg");
        MainBackground.setBackground(new Color(0x2c384a));
        MainBackground.setLayout(null);

        /*-------Labels Modifies-------*/
        WelcomeText.setText("GSSA Company");
        WelcomeText.setFont(new Font("Arial", Font.BOLD, 30));
        WelcomeText.setForeground(new Color(0x956d49));
        WelcomeText.setHorizontalAlignment(SwingConstants.CENTER);
        WelcomeText.setVerticalAlignment(SwingConstants.CENTER);
        WelcomeText.setBounds(125, 355, 300, 30);

        /*-------Image Closed Modifies-------*/
        //Todo: Search for Images
        Image imagePro = imageProfile.getImage();
        Image scaledImageOpen = imagePro.getScaledInstance(195, 195, Image.SCALE_SMOOTH);
        imageProfile = new ImageIcon(scaledImageOpen);


        /*--------------*/
        ImageLabel.setIcon(imageProfile);
        ImageLabel.setBounds(165, 100, 250, 250);
        ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ImageLabel.setVerticalAlignment(SwingConstants.CENTER);


        /*------- Label Text Modifies-------*/
        UsernameText.setText("Username: ");
        UsernameText.setFont(new Font("Arial", Font.ITALIC, 18));
        UsernameText.setForeground(Color.WHITE);
        UsernameText.setBounds(80, 400, 220, 65);

        PasswordText.setText("Password: ");
        PasswordText.setFont(new Font("Arial", Font.ITALIC, 18));
        PasswordText.setBounds(80, 450, 220, 65);
        PasswordText.setForeground(Color.WHITE);

        ConfirmPasswordText.setText("Confirm Password:");
        ConfirmPasswordText.setFont(new Font("Arial", Font.ITALIC, 18));
        ConfirmPasswordText.setForeground(Color.WHITE);
        ConfirmPasswordText.setBounds(9, 500, 220, 65);

        /*-------Username Field Modifies-------*/
        UsernameField.setBounds(190, 428, 225, 30);
        UsernameField.setBackground(new Color(0xcabcad));
        UsernameField.setFont(new Font("Arial", Font.BOLD, 16));
        UsernameField.setBorder(null);


        /*-------Password Field Modifies-------*/
        PasswordField.setBounds(190, 478, 225, 30);
        PasswordField.setBackground(new Color(0xc2b8b0));
        PasswordField.setFont(new Font("Arial", Font.BOLD, 16));
        PasswordField.setBorder(null);

        ConfirmPasswordField.setBounds(190, 528, 225, 30);
        ConfirmPasswordField.setBackground(new Color(0xc2b8b0));
        ConfirmPasswordField.setFont(new Font("Arial", Font.BOLD, 16));
        ConfirmPasswordField.setBorder(null);

        /*-------Show Password DetailsButton Modifies-------*/
        ImageIcon closedEyeIcon = new ImageIcon("src/Resources/cargo-truck (1).png");
        Image closedEyeScaled = closedEyeIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon closedEye = new ImageIcon(closedEyeScaled);

        ImageIcon openEyeIcon = new ImageIcon("src/Resources/cargo-truck (1).png");
        Image openEyeScaled = openEyeIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon openEye = new ImageIcon(openEyeScaled);

        ShowPasswordButton.setFocusable(false);
        ShowPasswordButton.setBackground(Color.WHITE);
        ShowPasswordButton.setIcon(closedEye);
        ShowPasswordButton.setBorderPainted(false);
        ShowPasswordButton.setContentAreaFilled(false);
        ShowPasswordButton.setFocusPainted(false);
        ShowPasswordButton.setBounds(435, 440, 100, 100);


        /*-------Show Button Event Modifies-------*/
        ShowPasswordButton.addActionListener(e -> {
            if (PasswordField.getEchoChar() == '•') {
                PasswordField.setEchoChar((char) 0);
                ConfirmPasswordField.setEchoChar((char) 0);
                ShowPasswordButton.setIcon(openEye);
            } else {
                PasswordField.setEchoChar('•');
                ConfirmPasswordField.setEchoChar('•');
                ShowPasswordButton.setIcon(closedEye);
            }
        });

        /*-------Submit DetailsButton Modifies-------*/
        loginButton.setText("Register");
        loginButton.setBackground(new Color(0xc2b8b0));
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setFocusable(false);
        loginButton.setBounds(240, 575, 100, 30);

        /*-------Go Back Button Modifies-------*/
        GoBack.setText("X");
        GoBack.setForeground(Color.WHITE);
        GoBack.setBackground(Color.RED);
        GoBack.setFocusable(false);
        GoBack.setBounds(10, 10, 45, 30);

        /*-------Progress Bar Modifies-------*/
        bar.setFont(new Font("Arial", Font.BOLD, 25));
        bar.setString("Please Wait a Second");
        bar.setIndeterminate(true);
        bar.setStringPainted(true);
        bar.setBounds(110, 340, 400, 100);
        bar.setVisible(false);

        /*-------Buttons Event Modifies-------*/

        loginButton.addActionListener(_ -> {
            String username = UsernameField.getText();
            String password = new String(PasswordField.getPassword());
            String ConfirmPass = new String(ConfirmPasswordField.getPassword());
            if (username.isEmpty()) {
                DialogMSG.EmptyFieldError("Username");
            } else if (password.isEmpty() || ConfirmPass.isEmpty()) {
                DialogMSG.EmptyFieldError("Password");
            } else if (!password.equals(ConfirmPass)) {
                DialogMSG.Mismatch();
            } else {
                GeneralClass.createAccount(username, password, "src/Admins.txt");
                frame.dispose();
//                SwingUtilities.invokeLater(UserLoginFrame::new);
            }
        });
        GoBack.addActionListener(_ -> {
            SwingUtilities.invokeLater(LoginFrame::new);
            frame.dispose();
        });


        /*-------Adding Components-------*/
        frame.add(PasswordField);
        frame.add(ConfirmPasswordField);
        TransparentBackground.add(loginButton);
        frame.add(ShowPasswordButton);
        TransparentBackground.add(PasswordText);
        TransparentBackground.add(ConfirmPasswordText);
        TransparentBackground.add(WelcomeText);
        TransparentBackground.add(UsernameText);
        TransparentBackground.add(GoBack);
        frame.add(UsernameField);
        frame.add(ImageLabel);
        frame.add(TransparentBackground);
        frame.add(MainBackground);
        frame.setVisible(true);

    }
}
