package UI_Storehouse;

import Shapes.PanelBackground;
import Shapes.RoundedTextField;

import javax.swing.*;
import java.awt.*;

public class SearchForFrame {

    JFrame frame = new JFrame();
    JPanel MainBackground = new JPanel();
    PanelBackground ImageBackground;

    RoundedTextField fieldSearch = new RoundedTextField("", 20);
    JButton buttonSearch = new JButton();

    JButton GoBack = new JButton();

    JLabel setNumber = new JLabel();
    JLabel setName = new JLabel();
    JLabel getName = new JLabel();
    JLabel setType = new JLabel();
    JLabel getType = new JLabel();
    JLabel setPrice = new JLabel();
    JLabel getPrice = new JLabel();
    JLabel setQuantity = new JLabel();
    JLabel getQuantity = new JLabel();

    PanelBackground ImageProduct;

    Font fontSet = new Font("Serif", Font.BOLD, 20);
    Font fontGet = new Font("", Font.BOLD, 18);

    public SearchForFrame() {

        /*-------Frame-------*/
        frame.setTitle("G.S.S.A Storehouse");
        frame.setSize(600, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon frameLogo = new ImageIcon("src\\Resources\\Storehouse Logo.png");
        Image frameImage = frameLogo.getImage();
        frame.setIconImage(frameImage);

        /*-------Search Modifies-------*/
        ImageIcon IconSearch = new ImageIcon("src\\Resources\\SearchIcon.png");
        Image imageSearch = IconSearch.getImage();
        Image scaledImageOpen = imageSearch.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        IconSearch = new ImageIcon(scaledImageOpen);
        buttonSearch.setIcon(IconSearch);
        buttonSearch.setFocusable(false);

        fieldSearch.setText("Enter The Id Please");
        fieldSearch.setFont(new Font("Serif", Font.BOLD, 18));
        fieldSearch.setMaximumSize(new Dimension(300, 30));
        fieldSearch.setPreferredSize(new Dimension(300, 30));
        fieldSearch.setBackground(new Color(0xdaa662));
        fieldSearch.setHorizontalAlignment(SwingConstants.CENTER);

        GoBack.setText("X");
        GoBack.setForeground(Color.WHITE);
        GoBack.setBackground(Color.RED);
        GoBack.setFocusable(false);
        GoBack.addActionListener(_ -> {
            frame.dispose();
            SwingUtilities.invokeLater(MainFrame::new);
        });

        /*-------Information-------*/
        setNumber.setText("- 34 -");
        setNumber.setMaximumSize(new Dimension(50, 15));
        setNumber.setForeground(new Color(0xdaa662));
        setNumber.setFont(fontSet);
        setNumber.setBounds(265, 10, 100, 25);
        //--------------//
        setName.setText("Product Name: ");
        setName.setForeground(new Color(0xdaa662));
        setName.setFont(fontSet);
        setName.setBounds(10, 50, 200, 25);
        //--------------//
        getName.setText("Asus Vivobook");
        getName.setForeground(Color.WHITE);
        getName.setFont(fontGet);
        getName.setBounds(150, 50, 500, 25);
        //--------------//
        setType.setText("Type: ");
        setType.setForeground(new Color(0xdaa662));
        setType.setFont(fontSet);
        setType.setBounds(10, 100, 200, 25);
        //--------------//
        getType.setForeground(Color.WHITE);
        getType.setText("Laptop");
        getType.setFont(fontGet);
        getType.setBounds(65, 100, 300, 25);
        //--------------//
        setPrice.setText("Product Price: ");
        setPrice.setForeground(new Color(0xdaa662));
        setPrice.setFont(fontSet);
        setPrice.setBounds(10, 150, 200, 25);
        //--------------//
        getPrice.setText("443.53$");
        getPrice.setForeground(Color.WHITE);
        getPrice.setFont(fontGet);
        getPrice.setBounds(150, 150, 500, 25);
        //--------------//
        setQuantity.setText("Current Quantity: ");
        setQuantity.setForeground(new Color(0xdaa662));
        setQuantity.setFont(fontSet);
        setQuantity.setBounds(10, 200, 200, 25);
        //--------------//
        getQuantity.setText("35 Pisces");
        getQuantity.setForeground(Color.WHITE);
        getQuantity.setFont(fontGet);
        getQuantity.setBounds(175, 200, 500, 25);

        JPanel panelSearch = new JPanel();
        panelSearch.setOpaque(false);
        panelSearch.setLayout(new BoxLayout(panelSearch, BoxLayout.X_AXIS));
        panelSearch.add(Box.createVerticalStrut(50));
        panelSearch.add(GoBack);
        panelSearch.add(Box.createVerticalStrut(50));
        panelSearch.add(fieldSearch);
        panelSearch.add(Box.createVerticalStrut(30));
        panelSearch.add(buttonSearch);
        panelSearch.add(Box.createVerticalStrut(10));

        ImageProduct = new PanelBackground("src\\Resources\\Asus Tuf Laptop.png");
        ImageProduct.setBounds(25, 230, 500, 430);
        ImageProduct.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0xdaa662)), "Image Product"));


        /*-------Panel Modifies-------*/
        MainBackground.setBackground(new Color(0, 0, 0, 140));
        MainBackground.setLayout(null);
        MainBackground.setBackground(new Color(0, 0, 0, 140));
        //--------------//
        ImageBackground = new PanelBackground("src\\Resources\\SearchForBackground.jpg");
        ImageBackground.setLayout(new BorderLayout());
        ImageBackground.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        //--------------//
        MainBackground.add(setNumber);
        MainBackground.add(setName);
        MainBackground.add(getName);
        MainBackground.add(setType);
        MainBackground.add(getType);
        MainBackground.add(setPrice);
        MainBackground.add(getPrice);
        MainBackground.add(setQuantity);
        MainBackground.add(getQuantity);
        MainBackground.add(ImageProduct);
        //--------------//
        ImageBackground.add(panelSearch, BorderLayout.NORTH);
        ImageBackground.add(MainBackground, BorderLayout.CENTER);
        //--------------//
        frame.add(ImageBackground);
        frame.setVisible(true);
    }
}
