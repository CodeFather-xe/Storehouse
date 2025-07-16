package UI_Storehouse;

import LogicalClasses.Products;
import Shapes.PanelBackground;
import Shapes.RoundedTextField;

import javax.swing.*;
import java.awt.*;

public class ProductSearch {

    JFrame frame = new JFrame();
    JPanel MainBackground = new JPanel();
    PanelBackground ImageBackground;

    RoundedTextField fieldSearch = new RoundedTextField("", 20);
    JButton buttonSearch = new JButton();

    JButton GoBack = new JButton();

    JLabel setName = new JLabel();
    JLabel getName = new JLabel();
    JLabel setId = new JLabel();
    JLabel getId = new JLabel();
    JLabel setPrice = new JLabel();
    JLabel getPrice = new JLabel();
    JLabel setQuantity = new JLabel();
    JLabel getQuantity = new JLabel();

    PanelBackground ImageProduct;

    Font fontSet = new Font("Serif", Font.BOLD, 20);
    Font fontGet = new Font("", Font.BOLD, 18);

    public ProductSearch() {

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
        buttonSearch.addActionListener(_ -> {
            int temp = Integer.parseInt(fieldSearch.getText());

        });
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

        setName.setText("Product Name: ");
        setName.setForeground(new Color(0xdaa662));
        setName.setFont(fontSet);
        setName.setBounds(10, 50, 200, 25);
        //--------------//
        getName.setText("");
        getName.setForeground(Color.WHITE);
        getName.setFont(fontGet);
        getName.setBounds(150, 50, 500, 25);
        //--------------//
        setId.setText("Product ID: ");
        setId.setForeground(new Color(0xdaa662));
        setId.setFont(fontSet);
        setId.setBounds(10, 100, 200, 25);
        //--------------//
        getId.setForeground(Color.WHITE);
        getId.setText("");
        getId.setFont(fontGet);
        getId.setBounds(65, 100, 300, 25);
        //--------------//
        setPrice.setText("Product Price: ");
        setPrice.setForeground(new Color(0xdaa662));
        setPrice.setFont(fontSet);
        setPrice.setBounds(10, 150, 200, 25);
        //--------------//
        getPrice.setText("");
        getPrice.setForeground(Color.WHITE);
        getPrice.setFont(fontGet);
        getPrice.setBounds(150, 150, 500, 25);
        //--------------//
        setQuantity.setText("Current Quantity: ");
        setQuantity.setForeground(new Color(0xdaa662));
        setQuantity.setFont(fontSet);
        setQuantity.setBounds(10, 200, 200, 25);
        //--------------//
        getQuantity.setText("");
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

        ImageProduct = new PanelBackground("");
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
        MainBackground.add(setName);
        MainBackground.add(getName);
        MainBackground.add(setId);
        MainBackground.add(getId);
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

    void setInformation(Products products) {
        getId.setText(String.valueOf(products.getId()));
        getName.setText(products.getName());
        getQuantity.setText(String.valueOf(products.getQuantity()));
        getPrice.setText(String.valueOf(products.getPrice()));
        ImageProduct = new PanelBackground(products.getImagePath());
        frame.repaint();
    }
}
