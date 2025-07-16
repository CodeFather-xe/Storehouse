package UI_Storehouse;

import Shapes.PanelBackground;
import Shapes.RoundedTextField;

import javax.swing.*;
import java.awt.*;

public class ShowItemDetails {

    /*This Class To View item's Details When User Click on item's Photo*/
    Dialog frame;
    JPanel ColorBackground;
    JPanel ItemBackground;
    PanelBackground LogoBackground;

    JLabel Title = new JLabel();
    JLabel nameLabel = new JLabel();
    JLabel idLabel = new JLabel();
    JLabel priceLabel = new JLabel();
    JLabel quantityLabel = new JLabel();
    RoundedTextField nameField;
    RoundedTextField idField;
    RoundedTextField priceField;
    RoundedTextField quantityField;
    JButton SaveButton = new JButton();

    Font fontLabels = new Font("Arial", Font.BOLD, 24);
    Font fontFields = new Font("Arial", Font.PLAIN, 18);


    /*This Class For Show items Detail On The Menu Frame*/
    public ShowItemDetails(JFrame parentFrame, ShowAllProducts.ItemMiniImage item, String check) {
        frame = new Dialog(parentFrame, "Products Details", true);
        idField = new RoundedTextField(String.valueOf(item.id), 20);
        nameField = new RoundedTextField(item.name, 20);
        priceField = new RoundedTextField(item.price + " $", 20);
        quantityField = new RoundedTextField(String.valueOf(item.totalQuantity), 20);

        /*-------frame Modifies-------*/
        frame.setSize(600, 350);
        frame.setTitle("Products Details");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        /*-------TitleChooseOperation Modifies-------*/
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        Title.setPreferredSize(new Dimension(300, 40));
        Title.setText("- Products Details -");
        Title.setHorizontalAlignment(JLabel.CENTER);
        Title.setAlignmentX(Component.CENTER_ALIGNMENT);
        Title.setForeground(Color.WHITE);
        Title.setFont(new Font("Serif", Font.BOLD, 35));
        titlePanel.add(Title);


        /*-------Labels Modifies-------*/
        idLabel.setText("item's ID: ");
        idLabel.setPreferredSize(new Dimension(250, 25));
        idLabel.setForeground(Color.WHITE);
        idLabel.setFont(fontLabels);

        nameLabel.setText("item's Name: ");
        nameLabel.setPreferredSize(new Dimension(250, 25));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(fontLabels);

        priceLabel.setText("item's Price: ");
        priceLabel.setPreferredSize(new Dimension(250, 25));
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setFont(fontLabels);

        quantityLabel.setText("item's Quantity: ");
        quantityLabel.setPreferredSize(new Dimension(250, 25));
        quantityLabel.setForeground(Color.WHITE);
        quantityLabel.setFont(fontLabels);

        /*-------Field Modifies-------*/
        idField.setPreferredSize(new Dimension(300, 40));
        idField.setBackground(new Color(250, 250, 250, 100));
        idField.setOpaque(false);
        idField.setFont(fontFields);
        idField.setEditable(false);

        nameField.setPreferredSize(new Dimension(300, 40));
        nameField.setBackground(new Color(250, 250, 250, 100));
        nameField.setOpaque(false);
        nameField.setFont(fontFields);
        nameField.setEditable(false);

        priceField.setPreferredSize(new Dimension(300, 40));
        priceField.setBackground(new Color(250, 250, 250, 100));
        priceField.setOpaque(false);
        priceField.setFont(fontFields);
        priceField.setEditable(false);

        quantityField.setPreferredSize(new Dimension(300, 40));
        quantityField.setBackground(new Color(250, 250, 250, 100));
        quantityField.setOpaque(false);
        quantityField.setEditable(false);
        quantityField.setFont(fontFields);

        SaveButton.setText("Close");

        /*-------Button Modifies-------*/
        JPanel SavePanel = new JPanel();
        SavePanel.setOpaque(false);
        SavePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        SaveButton.setPreferredSize(new Dimension(100, 33));
        SaveButton.setFont(fontLabels);
        SaveButton.setForeground(new Color(0x728c89));
        SaveButton.setFocusable(false);
        SavePanel.add(SaveButton);
        SaveButton.addActionListener(_ -> {
            frame.dispose();
        });
        /*-------Panels Modifies-------*/
        ItemBackground = new JPanel();
        ItemBackground.setOpaque(false);
        ItemBackground.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 6));

        LogoBackground = new PanelBackground("src/Resources/SearchForBackground.jpg");
        LogoBackground.setLayout(new BorderLayout(5, 5));
        LogoBackground.setOpaque(false);
        ColorBackground = new JPanel();
        ColorBackground.setBackground(new Color(0x343434));
        ColorBackground.setLayout(new GridLayout());

        /*-------Add Components-------*/
        ItemBackground.add(idLabel);
        ItemBackground.add(idField);
        //--------------//
        ItemBackground.add(nameLabel);
        ItemBackground.add(nameField);
        //--------------//
        ItemBackground.add(priceLabel);
        ItemBackground.add(priceField);
        //--------------//
        ItemBackground.add(quantityLabel);
        ItemBackground.add(quantityField);
        //--------------//
        LogoBackground.add(titlePanel, BorderLayout.NORTH);
        LogoBackground.add(ItemBackground, BorderLayout.CENTER);
        LogoBackground.add(SavePanel, BorderLayout.SOUTH);
        //--------------//
        ColorBackground.add(LogoBackground);
        frame.add(ColorBackground);
        frame.setVisible(true);
    }
}
