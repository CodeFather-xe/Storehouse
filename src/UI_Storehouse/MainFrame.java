package UI_Storehouse;

import Shapes.ArrowButton;
import Shapes.PanelBackground;
import Shapes.ToggleSwitch;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame {

    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
    ToggleSwitch switchAlgorithm = new ToggleSwitch();

    //! Right Items
    JPanel SecondaryButtonsPanel = new JPanel();
    JLabel rightHandle = new JLabel();
    /*--------- Product --------*/
    JPanel ProductSecondaryButtons = new JPanel();
    JButton searchProductButton = new JButton();
    JButton editRepositoryButton = new JButton();
    JButton ShowAllProductsButton = new JButton();
    /*--------- Order --------*/
    JPanel OrderSecondaryButtons = new JPanel();
    JButton searchForOrderButton = new JButton();
    JButton editOrdersButton = new JButton();
    JButton ShowAllOrdersButton = new JButton();
    /*--------- Shipment --------*/
    JPanel ShipmentSecondaryButtons = new JPanel();
    JButton searchForShipmentButton = new JButton();
    JButton editShipmentsButton = new JButton();
    JButton ShowAllShipmentsButton = new JButton();
    /*****************************************/

    //! Left Items
    JPanel ManageMainOperationPanel = new JPanel();
    JLabel leftHandle = new JLabel();

    JLabel ProductText = new JLabel();
    JButton ProductButton = new JButton();

    JButton OrderButton = new JButton();
    JLabel OrderText1 = new JLabel();
    JLabel OrderText2 = new JLabel();

    JButton ShipmentButton = new JButton();
    JLabel ShipmentText = new JLabel();

    ArrowButton NextButton = new ArrowButton(ArrowButton.RIGHT);
    JButton GoBack = new JButton();

    public MainFrame() {
        /*---------------------Frame---------------------*/
        frame.setTitle("G.S.S.A Storehouse");
        frame.setSize(1200, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon frameLogo = new ImageIcon("src\\Resources\\Storehouse Logo.png");
        Image frameImage = frameLogo.getImage();
        frame.setIconImage(frameImage);

        /*---------------------Titles Modifies---------------------*/
        leftHandle.setHorizontalAlignment(SwingConstants.CENTER);
        leftHandle.setText("Management");
        leftHandle.setFont(new Font("", Font.BOLD, 45));
        leftHandle.setForeground(new Color(0xdaa662));
        leftHandle.setBounds(130, 8, 300, 50);
        //--------------//
        rightHandle.setHorizontalAlignment(SwingConstants.CENTER);
        rightHandle.setFont(new Font("", Font.BOLD + Font.ITALIC, 50));
        rightHandle.setForeground(new Color(0xdaa662));
        rightHandle.setBounds(150, 10, 300, 50);
        /*--------Progress Bar Modifies--------*/
        bar.setString("Please Wait a Little");
        bar.setFont(new Font("Serif", Font.BOLD, 20));
        bar.setIndeterminate(true);
        bar.setStringPainted(true);
        bar.setBounds(400, 325, 300, 100);
        bar.setVisible(false);
        /*--------Next DetailsButton Modifies------------*/
        NextButton.setBackground(Color.GREEN);
        NextButton.setOpaque(false);
        NextButton.setFocusable(false);
        NextButton.setBounds(500, 15, 70, 65);
        NextButton.addActionListener(_ -> new Thread(() -> {
            try {
                frame.setEnabled(false);
                bar.setVisible(true);
                frame.repaint();
                Thread.sleep(2500);
                frame.dispose();
//                    SwingUtilities.invokeLater(() -> new OrderTypeFrame(Customer));
            } catch (InterruptedException _) {
            }
        }).start());
        // ------------//
        GoBack.setText("X");
        GoBack.setForeground(Color.WHITE);
        GoBack.setBackground(Color.RED);
        GoBack.setFocusable(false);
        GoBack.setBounds(25, 30, 45, 30);
        GoBack.addActionListener(_ -> {
            frame.dispose();
            SwingUtilities.invokeLater(LoginFrame::new);
        });

        /*---------------------Product Modifies---------------------*/
        //?Left Section
        ProductText.setText("Products");
        ProductText.setForeground(Color.WHITE);
        ProductText.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 40));
        ProductText.setVerticalAlignment(JLabel.CENTER);
        ProductText.setBounds(20, 240, 200, 50);
        //------------//
        ImageIcon iconProduct = new ImageIcon("src\\Images\\Images For Buttons\\Product.jpeg");
        Image imgProduct = iconProduct.getImage();
        Image scaledImgProduct = imgProduct.getScaledInstance(300, 120, Image.SCALE_SMOOTH);
        iconProduct = new ImageIcon(scaledImgProduct);
        ProductButton.setIcon(iconProduct);
        ProductButton.setBounds(250, 200, 300, 125);
        ProductButton.setBorder(BorderFactory.createLineBorder(new Color(0xdaa662), 2, true));

        //?  Right Section
        searchProductButton = createSecondaryButton(searchProductButton, "Search For Product");
        searchProductButton.addActionListener(_ -> {

            SwingUtilities.invokeLater(SearchForFrame::new);

            frame.dispose();
        });
        editRepositoryButton = createSecondaryButton(editRepositoryButton, "Edit The Repository");
        ShowAllProductsButton = createSecondaryButton(ShowAllProductsButton, " Show All Products ");

        ProductSecondaryButtons.setLayout(new BoxLayout(ProductSecondaryButtons, BoxLayout.Y_AXIS));
        ProductSecondaryButtons.setOpaque(false);
        ProductSecondaryButtons.add(Box.createVerticalStrut(150));
        ProductSecondaryButtons.add(searchProductButton);
        ProductSecondaryButtons.add(Box.createVerticalStrut(70));
        ProductSecondaryButtons.add(editRepositoryButton);
        ProductSecondaryButtons.add(Box.createVerticalStrut(70));
        ProductSecondaryButtons.add(ShowAllProductsButton);

        ProductButton.addActionListener(_ -> {
            rightHandle.setText("- Products -");
            SecondaryButtonsPanel.remove(OrderSecondaryButtons);
            SecondaryButtonsPanel.remove(ShipmentSecondaryButtons);
            SecondaryButtonsPanel.add(ProductSecondaryButtons, BorderLayout.CENTER);
            SecondaryButtonsPanel.setVisible(true);
            frame.repaint();
        });

        /*---------------------Order Modifies---------------------*/
        //?  left Section
        OrderText1.setText("Ord");
        OrderText1.setForeground(Color.WHITE);
        OrderText1.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 40));
        OrderText1.setVerticalAlignment(JLabel.CENTER);
        OrderText1.setBounds(20, 410, 200, 50);
        //------------//
        OrderText2.setText("ers");
        OrderText2.setForeground(Color.WHITE);
        OrderText2.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 40));
        OrderText2.setVerticalAlignment(JLabel.CENTER);
        OrderText2.setBounds(435, 410, 200, 50);
        //------------//
        ImageIcon iconMainMeal = new ImageIcon("src\\Images\\Images For Buttons\\Main Meal.jpeg");
        Image imgMainMeal = iconMainMeal.getImage();
        Image scaledImgMainMeal = imgMainMeal.getScaledInstance(300, 120, Image.SCALE_SMOOTH + Image.SCALE_AREA_AVERAGING);
        iconMainMeal = new ImageIcon(scaledImgMainMeal);
        OrderButton.setIcon(iconMainMeal);
        OrderButton.setBounds(125, 375, 300, 125);
        OrderButton.setBorder(BorderFactory.createLineBorder(new Color(0xdaa662), 2, true));
        //?  Right Section
        searchForOrderButton = createSecondaryButton(searchForOrderButton, "Search For Order");
        editOrdersButton = createSecondaryButton(editOrdersButton, "Edit The Orders");
        ShowAllOrdersButton = createSecondaryButton(ShowAllOrdersButton, " Show All Orders ");

        OrderSecondaryButtons.setLayout(new BoxLayout(OrderSecondaryButtons, BoxLayout.Y_AXIS));
        OrderSecondaryButtons.setOpaque(false);
        OrderSecondaryButtons.add(Box.createVerticalStrut(150));
        OrderSecondaryButtons.add(searchForOrderButton);
        OrderSecondaryButtons.add(Box.createVerticalStrut(70));
        OrderSecondaryButtons.add(editOrdersButton);
        OrderSecondaryButtons.add(Box.createVerticalStrut(70));
        OrderSecondaryButtons.add(ShowAllOrdersButton);

        OrderButton.addActionListener(_ -> {
            rightHandle.setText("- Orders -");
            SecondaryButtonsPanel.remove(ProductSecondaryButtons);
            SecondaryButtonsPanel.remove(ShipmentSecondaryButtons);
            SecondaryButtonsPanel.add(OrderSecondaryButtons, BorderLayout.CENTER);
            SecondaryButtonsPanel.setVisible(true);
            frame.repaint();
        });

        /*---------------------Shipment Modifies---------------------*/
        //?  Left Section
        ShipmentText.setText("Shipments");
        ShipmentText.setForeground(Color.WHITE);
        ShipmentText.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 40));
        ShipmentText.setVerticalAlignment(JLabel.CENTER);
        ShipmentText.setBounds(345, 590, 240, 50);
        //------------//
        ImageIcon iconShipment = new ImageIcon("src\\Images\\Images For Buttons\\Shipment.jpeg");
        Image imgShipment = iconShipment.getImage();
        Image scaledImgShipment = imgShipment.getScaledInstance(300, 121, Image.SCALE_SMOOTH);
        iconShipment = new ImageIcon(scaledImgShipment);
        ShipmentButton.setIcon(iconShipment);
        ShipmentButton.setBounds(20, 550, 300, 125);
        ShipmentButton.setBorder(BorderFactory.createLineBorder(new Color(0xdaa662), 2, true));
        //------------//
        JLabel status = new JLabel("Fast Mode OFF");
        status.setBounds(50, 100, 200, 50);
        switchAlgorithm.setBounds(100, 100, 200, 50);
        switchAlgorithm.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    frame.repaint();
                    status.setText(switchAlgorithm.isSelected() ? "Fast Mode ON" : "Fast Mode OFF");
                }
            });
//

        //?  Right Section
        searchForShipmentButton = createSecondaryButton(searchForShipmentButton, "Search For Shipment");
        editShipmentsButton = createSecondaryButton(editShipmentsButton, "Edit The Shipment");
        ShowAllShipmentsButton = createSecondaryButton(ShowAllShipmentsButton, " Show All Shipment ");

        ShipmentSecondaryButtons.setLayout(new BoxLayout(ShipmentSecondaryButtons, BoxLayout.Y_AXIS));
        ShipmentSecondaryButtons.setOpaque(false);
        ShipmentSecondaryButtons.add(Box.createVerticalStrut(150));
        ShipmentSecondaryButtons.add(searchForShipmentButton);
        ShipmentSecondaryButtons.add(Box.createVerticalStrut(70));
        ShipmentSecondaryButtons.add(editShipmentsButton);
        ShipmentSecondaryButtons.add(Box.createVerticalStrut(70));
        ShipmentSecondaryButtons.add(ShowAllShipmentsButton);

        ShipmentButton.addActionListener(_ -> {
            rightHandle.setText("- Shipments -");
            SecondaryButtonsPanel.remove(ProductSecondaryButtons);
            SecondaryButtonsPanel.remove(OrderSecondaryButtons);
            SecondaryButtonsPanel.add(ShipmentSecondaryButtons, BorderLayout.CENTER);
            SecondaryButtonsPanel.setVisible(true);
            frame.repaint();
        });

        /*---------------------Panel Modifies---------------------*/
        //--------------//
        ManageMainOperationPanel.setBackground(new Color(0, 0, 0, 150));
        ManageMainOperationPanel.setBounds(10, 15, 570, 740);
        ManageMainOperationPanel.setLayout(null);
        /*-------------Menu Panels--------------*/
        //--------------//
        SecondaryButtonsPanel.setBounds(590, 15, 585, 740);
        SecondaryButtonsPanel.setLayout(new BorderLayout(10, 10));
        SecondaryButtonsPanel.setBackground(new Color(0, 0, 0, 140));
        SecondaryButtonsPanel.setOpaque(true);
        SecondaryButtonsPanel.setVisible(false);

        //--------------//
        /*-------------Background Panels--------------*/
        PanelBackground MainBackground = new PanelBackground("src\\Resources\\BackgroundLogin.jpg");
        MainBackground.setLayout(null);

        /*---------------------Adding Components---------------------*/
        ManageMainOperationPanel.add(leftHandle);
        ManageMainOperationPanel.add(ProductText);
        ManageMainOperationPanel.add(OrderText1);
        ManageMainOperationPanel.add(OrderText2);
        ManageMainOperationPanel.add(ShipmentText);
        ManageMainOperationPanel.add(ProductButton);
        ManageMainOperationPanel.add(OrderButton);
        ManageMainOperationPanel.add(ShipmentButton);
        //------------//
        SecondaryButtonsPanel.add(rightHandle, BorderLayout.NORTH);
        //------------//
        MainBackground.add(NextButton);
        MainBackground.add(GoBack);
        MainBackground.add(bar);
        MainBackground.add(status);
        MainBackground.add(switchAlgorithm);
        MainBackground.add(SecondaryButtonsPanel);
        MainBackground.add(ManageMainOperationPanel);
        //------------//
        frame.add(MainBackground);
        frame.setVisible(true);
    }

    public JButton createSecondaryButton(JButton button, String text) {
        button.setText(text);
        button.setForeground(Color.BLACK);
        button.setMaximumSize(new Dimension(400, 70));
        button.setFont(new Font("Arial", Font.BOLD, 30));
        button.setBackground(new Color(0x728c89));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);
        return button;
    }

}
