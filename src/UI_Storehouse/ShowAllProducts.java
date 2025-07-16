package UI_Storehouse;

import LogicalClasses.Administrator;
import LogicalClasses.Products;
import Shapes.PanelBackground;

import javax.swing.*;
import java.awt.*;

public class ShowAllProducts {

    JFrame frame = new JFrame();
    JPanel TransparentBackground = new JPanel();
    JLabel title = new JLabel();
    JPanel collectionPanel = new JPanel();
    JScrollPane ItemsScrollPanel = new JScrollPane(collectionPanel);
    JButton GoBack = new JButton();


    public ShowAllProducts() {
        //********************************************************//
        Administrator.readItem("Computers.txt");
        Administrator.readItem("Accessories.txt");
        Administrator.readItem("Office Furniture.txt");
        for (Products x : Administrator.computers) {
            collectionPanel.add(new ItemMiniImage(x));
        }
        for (Products x : Administrator.accessories) {
            collectionPanel.add(new ItemMiniImage(x));
        }
        for (Products x : Administrator.officeFurniture) {
            collectionPanel.add(new ItemMiniImage(x));
        }
        //********************************************************//

        frame.setTitle("GSSA StoreHouse");
        frame.setSize(600, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        ImageIcon frameLogo = new ImageIcon("src\\Resources\\Storehouse Logo.png");
        Image frameImage = frameLogo.getImage();
        frame.setIconImage(frameImage);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        GoBack.setText("X");
        GoBack.setForeground(Color.WHITE);
        GoBack.setBackground(Color.RED);
        GoBack.setFocusable(false);
        GoBack.setBounds(25, 30, 45, 30);
        GoBack.addActionListener(_ -> {
            frame.dispose();
            SwingUtilities.invokeLater(MainFrame::new);
        });

        /*-------Modifies Title-------*/
        title.setText("ITEMS");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Serif", Font.BOLD, 50));
        title.setBounds(215,25,250,50);

        collectionPanel.setLayout(new GridLayout(0, 2, 10, 10));
        collectionPanel.setOpaque(false);

        ItemsScrollPanel.setBounds(20,100,525,620);
        ItemsScrollPanel.setPreferredSize(new Dimension(450, 440));
        ItemsScrollPanel.setMaximumSize(new Dimension(450, 440));
        ItemsScrollPanel.setBackground(new Color(0, 0, 0, 0));
        ItemsScrollPanel.getViewport().setOpaque(false);
        JScrollBar verticalBar = ItemsScrollPanel.getVerticalScrollBar();
        verticalBar.addAdjustmentListener(e -> {  /*To Solve Shadow Problem When Scrolled*/
            if (!e.getValueIsAdjusting()) {
                collectionPanel.revalidate();
                collectionPanel.repaint();
                frame.revalidate();
                frame.repaint();
            }
        });


        /*-------Modifies Panels-------*/
        TransparentBackground.setBackground(new Color(0, 0, 0, 150));
        TransparentBackground.setLayout(null);
        TransparentBackground.setBounds(10, 10, 565, 745);
        //--------------//
        PanelBackground MainBackground = new PanelBackground("src\\Resources\\BackgroundLogin.jpg");
        MainBackground.setBackground(new Color(0x2c384a));
        MainBackground.setLayout(null);

        TransparentBackground.add(title, BorderLayout.NORTH);
        TransparentBackground.add(ItemsScrollPanel, BorderLayout.CENTER);


        frame.add(GoBack);
        frame.add(TransparentBackground);
        frame.add(MainBackground);
        frame.setVisible(true);
    }

    public class ItemMiniImage extends JPanel {
        int id ;
        String name;
        double price;
        String image;
        int totalQuantity;
        JButton DetailsButton = new JButton();
        JLabel NameLabel = new JLabel();
        JLabel PriceLabel = new JLabel();
        JPanel InfoPanel = new JPanel();

        public ItemMiniImage(Products products) {
            this.id = products.getId();
            this.name = products.getName();
            this.price = products.getPrice();
            this.image = products.getImagePath();
            this.totalQuantity = products.getQuantity();
            this.setLayout(new BorderLayout());

            /*-------------Details Button--------------*/
            ImageIcon imageIcon = new ImageIcon(products.getImagePath());
            Image imgButton = imageIcon.getImage();
            Image scaledImgDetails = imgButton.getScaledInstance(275, 200, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImgDetails);
            DetailsButton.setIcon(imageIcon);
            DetailsButton.setPreferredSize(new Dimension(205, 175));
            DetailsButton.setFocusPainted(true);
            DetailsButton.setContentAreaFilled(false);
            DetailsButton.addActionListener(_ -> SwingUtilities.invokeLater(() -> new ShowItemDetails(frame, ItemMiniImage.this, "Details")));

            /*-------------Name & Price--------------*/
            NameLabel.setForeground(Color.WHITE);
            NameLabel.setFont(new Font("Arial", Font.BOLD, 14));
            NameLabel.setText(name);
            PriceLabel.setForeground(Color.WHITE);
            PriceLabel.setText(String.valueOf(price) + '$');
            PriceLabel.setFont(new Font("Arial", Font.BOLD, 14));

            /*-----Their Panel------*/
            InfoPanel.setLayout(new BorderLayout());
            InfoPanel.setPreferredSize(new Dimension(100, 33));
            InfoPanel.setBackground(new Color(0x728c89));
            InfoPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 5));

            /*-------------Add Component--------------*/
            InfoPanel.add(PriceLabel, BorderLayout.EAST);
            InfoPanel.add(NameLabel, BorderLayout.CENTER);
            this.add(InfoPanel, BorderLayout.SOUTH);
            this.add(DetailsButton, BorderLayout.NORTH);
        }

    }


}
