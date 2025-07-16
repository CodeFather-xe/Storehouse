package UI_Storehouse;

import LogicalClasses.DialogMSG;
import LogicalClasses.Products;
import Shapes.PanelBackground;
import Shapes.RoundedTextField;
import javax.swing.*;
import java.awt.*;

// The Small frame that show when use popup
public class AddEdit_Item {
    JDialog frame;
    String oldItemName;
    JPanel ColorBackground;
    JPanel ItemBackground;
    PanelBackground LogoBackground;

    JLabel Title = new JLabel();
    JLabel nameLabel = new JLabel();
    JLabel priceLabel = new JLabel();
    JLabel quantityLabel = new JLabel();
    JLabel pathLabel = new JLabel();
    RoundedTextField nameField;
    RoundedTextField priceField;
    RoundedTextField quantityField;
    RoundedTextField pathField;
    JButton SaveButton = new JButton();
    JButton CloseButton = new JButton();

    Font fontLabels = new Font("Arial", Font.BOLD, 24);
    Font fontFields = new Font("Arial", Font.PLAIN, 18);
    private boolean isClosed = false;

    /*Add A new Products*/
    public AddEdit_Item(JFrame mainframe, String typeItem) {
        nameField = new RoundedTextField("", 20);
        priceField = new RoundedTextField("", 20);
        quantityField = new RoundedTextField("", 20);

        /*-------frame Modifies-------*/
        frame = new JDialog(mainframe, "Products Modify", true);
        frame.setSize(600, 350);
        frame.setTitle("Products Modify");
        frame.setResizable(false);
        frame.setLocationRelativeTo(mainframe);

        /*-------TitleChooseOperation Modifies-------*/
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        Title.setPreferredSize(new Dimension(300, 40));
        Title.setText("- Products Modify -");
        Title.setForeground(Color.WHITE);
        Title.setFont(new Font("Serif", Font.BOLD, 35));
        titlePanel.add(Title);

        /*-------Labels Modifies-------*/
        nameLabel.setText("Products's Name: ");
        nameLabel.setPreferredSize(new Dimension(250, 25));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(fontLabels);

        priceLabel.setText("Products's Price: ");
        priceLabel.setPreferredSize(new Dimension(250, 25));
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setFont(fontLabels);

        quantityLabel.setText("Products's Quantity: ");
        quantityLabel.setPreferredSize(new Dimension(250, 25));
        quantityLabel.setForeground(Color.WHITE);
        quantityLabel.setFont(fontLabels);

        pathLabel.setText("Products's Image: ");
        pathLabel.setPreferredSize(new Dimension(250, 25));
        pathLabel.setForeground(Color.WHITE);
        pathLabel.setFont(fontLabels);

        /*-------Field Modifies-------*/
        nameField.setPreferredSize(new Dimension(300, 40));
        nameField.setBackground(new Color(250, 250, 250, 100));
        nameField.setOpaque(false);
        nameField.setFont(fontFields);

        priceField.setPreferredSize(new Dimension(300, 40));
        priceField.setBackground(new Color(250, 250, 250, 100));
        priceField.setOpaque(false);
        priceField.setFont(fontFields);

        quantityField.setPreferredSize(new Dimension(300, 40));
        quantityField.setBackground(new Color(250, 250, 250, 100));
        quantityField.setOpaque(false);
        quantityField.setFont(fontFields);

        pathField.setPreferredSize(new Dimension(300, 40));
        pathField.setBackground(new Color(250, 250, 250, 100));
        pathField.setOpaque(false);
        pathField.setFont(fontFields);

        /*-------Button Modifies-------*/
        JPanel SavePanel = new JPanel();
        SavePanel.setOpaque(false);
        SavePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        // *************************//
        CloseButton.setPreferredSize(new Dimension(100, 30));
        CloseButton.setText("Close");
        CloseButton.setFont(fontLabels);
        CloseButton.setForeground(new Color(0x8d6e63));
        CloseButton.setFocusable(false);
        CloseButton.addActionListener(_ -> {
            isClosed = true;
            frame.dispose();
        });
        // *************************//
        SaveButton.setPreferredSize(new Dimension(100, 30));
        SaveButton.setText("Save");
        SaveButton.setFont(fontLabels);
        SaveButton.setForeground(new Color(0x8d6e63));
        SaveButton.setFocusable(false);
        SavePanel.add(SaveButton);
        SavePanel.add(CloseButton);
        SaveButton.addActionListener(_ -> {
            if (validateFields()) {
                return ;
            } else {
                DialogMSG.ConfirmActionForItem("Add", nameField.getText());
            }
        });

        /*-------Panels Modifies-------*/
        ItemBackground = new JPanel();
        ItemBackground.setOpaque(false);
        ItemBackground.setLayout(new FlowLayout(FlowLayout.LEFT, 7, 7));

        LogoBackground = new PanelBackground("src\\Images\\Backgrounds\\Restaurant Logo.png");
        LogoBackground.setLayout(new BorderLayout(5, 5));
        LogoBackground.setOpaque(false);

        ColorBackground = new JPanel();
        ColorBackground.setBackground(new Color(0x343434));
        ColorBackground.setLayout(new GridLayout());

        /*-------Add Components-------*/
        ItemBackground.add(nameLabel);
        ItemBackground.add(nameField);
        //--------------//
        ItemBackground.add(priceLabel);
        ItemBackground.add(priceField);
        //--------------//
        ItemBackground.add(quantityLabel);
        ItemBackground.add(quantityField);
        //--------------//
        ItemBackground.add(pathLabel);
        ItemBackground.add(pathField);
        //--------------//
        LogoBackground.add(titlePanel, BorderLayout.NORTH);
        LogoBackground.add(ItemBackground, BorderLayout.CENTER);
        LogoBackground.add(SavePanel, BorderLayout.SOUTH);
        //--------------//
        ColorBackground.add(LogoBackground);
        frame.add(ColorBackground);
        frame.setVisible(true);
    }


    /*Edit Products*/
    public AddEdit_Item(JFrame mainframe, Products products, String tabTitle) {
        nameField = new RoundedTextField(products.getName(), 20);
        priceField = new RoundedTextField(String.valueOf(products.getPrice()) + '$', 20);
        quantityField = new RoundedTextField(products.getQuantity() + " Pieces", 20);
        pathField = new RoundedTextField(products.getImagePath(), 20);

        oldItemName = nameField.getText();

        /*-------frame Modifies-------*/
        frame = new JDialog(mainframe, "Products Modify", true);
        frame.setSize(600, 350);
        frame.setTitle("Products Modify");
        frame.setResizable(false);
        frame.setLocationRelativeTo(mainframe);

        /*-------TitleChooseOperation Modifies-------*/
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        Title.setPreferredSize(new Dimension(300, 40));
        Title.setText("- Products Modify -");
        Title.setForeground(Color.WHITE);
        Title.setFont(new Font("Serif", Font.BOLD, 35));
        titlePanel.add(Title);


        /*-------Labels Modifies-------*/
        nameLabel.setText("Products's Name: ");
        nameLabel.setPreferredSize(new Dimension(250, 25));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(fontLabels);

        priceLabel.setText("Products's Price: ");
        priceLabel.setPreferredSize(new Dimension(250, 25));
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setFont(fontLabels);

        quantityLabel.setText("Products's Quantity: ");
        quantityLabel.setPreferredSize(new Dimension(250, 25));
        quantityLabel.setForeground(Color.WHITE);
        quantityLabel.setFont(fontLabels);

        pathLabel.setText("Products's Image: ");
        pathLabel.setPreferredSize(new Dimension(250, 25));
        pathLabel.setForeground(Color.WHITE);
        pathLabel.setFont(fontLabels);


        /*-------Field Modifies-------*/
        nameField.setPreferredSize(new Dimension(300, 40));
        nameField.setBackground(new Color(250, 250, 250, 100));
        nameField.setOpaque(false);
        nameField.setFont(fontFields);

        priceField.setPreferredSize(new Dimension(300, 40));
        priceField.setBackground(new Color(250, 250, 250, 100));
        priceField.setOpaque(false);
        priceField.setFont(fontFields);


        quantityField.setPreferredSize(new Dimension(300, 40));
        quantityField.setBackground(new Color(250, 250, 250, 100));
        quantityField.setOpaque(false);
        quantityField.setFont(fontFields);


        pathField.setPreferredSize(new Dimension(300, 40));
        pathField.setBackground(new Color(250, 250, 250, 100));
        pathField.setOpaque(false);
        pathField.setFont(fontFields);





        /*-------Button Modifies-------*/
        JPanel SavePanel = new JPanel();
        SavePanel.setOpaque(false);
        SavePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //--------------//
        CloseButton.setPreferredSize(new Dimension(100, 30));
        CloseButton.setText("Close");
        CloseButton.setFont(fontLabels);
        CloseButton.setForeground(new Color(0x8d6e63));
        CloseButton.setFocusable(false);
        CloseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        CloseButton.addActionListener(_ -> {
            isClosed = true;
            frame.dispose();
        });
        //--------------//
        SaveButton.setPreferredSize(new Dimension(100, 30));
        SaveButton.setText("Save");
        SaveButton.setFont(fontLabels);
        SaveButton.setForeground(new Color(0x8d6e63));
        SaveButton.setFocusable(false);
        SavePanel.add(SaveButton);
        SavePanel.add(CloseButton);
        SaveButton.addActionListener(_ -> {
            if (validateFields()) {
                return;
            }
            frame.dispose();
        });


        /*-------Panels Modifies-------*/
        ItemBackground = new JPanel();
        ItemBackground.setOpaque(false);
        ItemBackground.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 6));

        LogoBackground = new PanelBackground("src\\Images\\Backgrounds\\Restaurant Logo.png");
        LogoBackground.setLayout(new BorderLayout(5, 5));
        LogoBackground.setOpaque(false);

        ColorBackground = new JPanel();
        ColorBackground.setBackground(new Color(0x343434));
        ColorBackground.setLayout(new GridLayout());

        /*-------Add Components-------*/
        ItemBackground.add(nameLabel);
        ItemBackground.add(nameField);
        //--------------//
        ItemBackground.add(priceLabel);
        ItemBackground.add(priceField);
        //--------------//
        ItemBackground.add(quantityLabel);
        ItemBackground.add(quantityField);
        //--------------//
        ItemBackground.add(pathLabel);
        ItemBackground.add(pathField);
        //--------------//
        LogoBackground.add(titlePanel, BorderLayout.NORTH);
        LogoBackground.add(ItemBackground, BorderLayout.CENTER);
        LogoBackground.add(SavePanel, BorderLayout.SOUTH);
        //--------------//
        ColorBackground.add(LogoBackground);
        frame.add(ColorBackground);
        frame.setVisible(true);
    }

    private boolean validateFields() {
        // We use Trim() method to Ignore spaces
        if (nameField.getText().isEmpty()) {
            DialogMSG.EmptyFieldError("Products Name");
            return true;
        }
        if (priceField.getText().trim().isEmpty()) {
            DialogMSG.EmptyFieldError("Products Price");
            return true;
        }
        if (!priceField.getText().trim().matches("\\d+(\\.\\d+)?")) {DialogMSG.EnterValidData("Products Price");
            return true;
        }
//        if (!priceField.getText().matches("\\d+")) { // this allow admin to enter only integer
//            Logical_Class.DialogMSG.EnterValidData("Products Price");
//            return true;
//        }
        if (quantityField.getText().trim().isEmpty()) {
           DialogMSG.EmptyFieldError("Products Quantity");
            return true;
        }
        if (!quantityField.getText().trim().matches("\\d+")) {
            DialogMSG.EnterValidData("Products Quantity");
            return true;
        }
        return false;
    }

    public boolean isClosed() {
        return !isClosed;
    }

}