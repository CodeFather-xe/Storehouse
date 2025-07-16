package UI_Storehouse;

import LogicalClasses.Administrator;
import LogicalClasses.Order;
import LogicalClasses.Products;
import Shapes.PanelBackground;
import Shapes.RoundedTextField;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class OrderSearch {

    JFrame frame = new JFrame();
    JPanel MainBackground = new JPanel();
    PanelBackground ImageBackground;

    RoundedTextField fieldSearch = new RoundedTextField("", 20);
    JButton buttonSearch = new JButton();

    JButton GoBack = new JButton();

    JLabel setNumber = new JLabel();
    JLabel setName = new JLabel();
    JLabel getName = new JLabel();
    JLabel setId = new JLabel();
    JLabel getId = new JLabel();
    JLabel setPrice = new JLabel();
    JLabel getPrice = new JLabel();
    JLabel setPriority = new JLabel();
    JLabel getPriority = new JLabel();

    JPanel collectionPanel = new JPanel();

    Font fontSet = new Font("Serif", Font.BOLD, 20);
    Font fontGet = new Font("", Font.BOLD, 18);

    public OrderSearch() {

        ArrayList<Products> products = new ArrayList<>();
        products.addAll(Administrator.computers);
        products.addAll(Administrator.accessories);
        products.addAll(Administrator.officeFurniture);

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
            for (Order x : Administrator.Orders) {
                if (x.getOrderID() == temp) {
                    setInformation(x);
                    break;
                }
            }

        });
        fieldSearch.setText("Enter Order ID Please");
        fieldSearch.setFont(new Font("Serif", Font.BOLD, 18));
        fieldSearch.setMaximumSize(new Dimension(300, 30));
        fieldSearch.setPreferredSize(new Dimension(300, 30));
        fieldSearch.setBackground(new Color(0xcdcdc9));
        fieldSearch.setHorizontalAlignment(SwingConstants.CENTER);

        GoBack.setText(" X ");
        GoBack.setForeground(Color.WHITE);
        GoBack.setBackground(Color.RED);
        GoBack.setFocusable(false);
        GoBack.addActionListener(_ -> {
            frame.dispose();
            SwingUtilities.invokeLater(MainFrame::new);
        });

        /*-------Information-------*/
        setNumber.setText('-' + String.valueOf(" ") + '-');
        setNumber.setBounds(275, 10, 100, 25);
        setNumber.setForeground(new Color(0xcdcdc9));
        setNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
        setNumber.setFont(fontSet);
        //--------------//
        setName.setText("Order's Owner: ");
        setName.setForeground(new Color(0xcdcdc9));
        setName.setFont(fontSet);
        setName.setBounds(10, 50, 200, 25);
        //--------------//
        getName.setText("");
        getName.setForeground(Color.WHITE);
        getName.setFont(fontGet);
        getName.setBounds(150, 50, 500, 25);
        //--------------//
        setId.setText("Order's ID: ");
        setId.setForeground(new Color(0xcdcdc9));
        setId.setFont(fontSet);
        setId.setBounds(10, 100, 200, 25);
        //--------------//
        getId.setForeground(Color.WHITE);
        getId.setText("");
        getId.setFont(fontGet);
        getId.setBounds(65, 100, 300, 25);
        //--------------//
        setPrice.setText("Order's Price: ");
        setPrice.setForeground(new Color(0xcdcdc9));
        setPrice.setFont(fontSet);
        setPrice.setBounds(10, 150, 200, 25);
        //--------------//
        getPrice.setText("");
        getPrice.setForeground(Color.WHITE);
        getPrice.setFont(fontGet);
        getPrice.setBounds(150, 150, 500, 25);
        //--------------//
        setPriority.setText("Order's Priority: ");
        setPriority.setForeground(new Color(0xcdcdc9));
        setPriority.setFont(fontSet);
        setPriority.setBounds(10, 200, 200, 25);
        //--------------//
        getPriority.setText("");
        getPriority.setForeground(Color.WHITE);
        getPriority.setFont(fontGet);
        getPriority.setBounds(175, 200, 500, 25);

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


        collectionPanel.setOpaque(false);
        collectionPanel.setBounds(27, 232, 498, 428);


        TitledBorder border = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0xdaa662)),
                "Order's Product",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                null,
                Color.WHITE
        );
//        ImageProduct.setBorder(border);

        /*-------Panel Modifies-------*/
        MainBackground.setBackground(new Color(0, 0, 0, 140));
        MainBackground.setLayout(null);
        MainBackground.setBackground(new Color(0, 0, 0, 140));
        //--------------//
        ImageBackground = new PanelBackground("src\\Resources\\SearchForBackground1.jpg");
        ImageBackground.setLayout(new BorderLayout());
        ImageBackground.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        //--------------//
        MainBackground.add(setNumber);
        MainBackground.add(setName);
        MainBackground.add(getName);
        MainBackground.add(setId);
        MainBackground.add(getId);
        MainBackground.add(setPrice);
        MainBackground.add(getPrice);
        MainBackground.add(setPriority);
        MainBackground.add(getPriority);
        //--------------//
        ImageBackground.add(panelSearch, BorderLayout.NORTH);
        ImageBackground.add(MainBackground, BorderLayout.CENTER);
        //--------------//
        frame.add(ImageBackground);
        frame.setVisible(true);
    }

    public class ProductPanel extends JPanel {
        JLabel itemName = new JLabel();
        JLabel itemPrice = new JLabel();

        public ProductPanel(Products item) {
            this.setBackground(new Color(0, 0, 0, 0));
            this.setLayout(new BorderLayout());
            this.setPreferredSize(new Dimension(530, 30));
            this.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 12));


            itemName.setFont(new Font("Serif", Font.BOLD, 24));
            itemName.setForeground(Color.LIGHT_GRAY);
            itemName.setHorizontalAlignment(JLabel.LEFT);

            itemPrice.setText("");
            itemPrice.setFont(new Font("Serif", Font.BOLD, 24));
            itemPrice.setForeground(Color.LIGHT_GRAY);
            itemPrice.setHorizontalAlignment(JLabel.RIGHT);


            itemName.setText("- " + item.getName() + "   × " + item.getCurrentQuantity());
            itemPrice.setText(String.format("%.2f", item.getPrice() * item.getPrice()) + '$');
            this.add(itemName, BorderLayout.WEST);
            this.add(itemPrice, BorderLayout.EAST);

        }
    }


    void setInformation(Order order) {
        setNumber.setText('-' + String.valueOf(order.getOrderID()) + '-');
        getName.setText(order.getOwner());
        if (order.getPriority() == 1) {
            getPriority.setForeground(Color.red);
            getPriority.setText("High");
        } else if (order.getPriority() == 0) {
            getPriority.setForeground(Color.BLUE);
            getPriority.setText("Normal");
        } else {
            getPriority.setForeground(Color.YELLOW);
            getPriority.setText("Not Important");
        }
        getPrice.setText(String.valueOf(order.getCost()));
        frame.repaint();
    }
}
