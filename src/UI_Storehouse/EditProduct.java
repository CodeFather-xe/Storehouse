package UI_Storehouse;
import Shapes.PanelBackground;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditProduct {

    JFrame frame = new JFrame();

    JPanel InformationPanel = new JPanel();

    JPanel computersPanel = new JPanel();
    JScrollPane computersScroll = new JScrollPane(computersPanel);
    JPanel accessoriesPanel = new JPanel();
    JScrollPane accessoriesScroll = new JScrollPane(accessoriesPanel);
    JPanel furniturePanel = new JPanel();
    JScrollPane furnitureScroll = new JScrollPane(furniturePanel);
    
    JPanel productDetailsPanel = new JPanel();

    PanelBackground MainBackground;

    JLabel Details = new JLabel();
    JPopupMenu popupMenu;
    JTabbedPane tabbedPane = new JTabbedPane();

    /***************************************/
    JLabel productNameLabel = new JLabel();
    JLabel getName = new JLabel();

    JLabel productPriceLabel = new JLabel();
    JLabel getPrice = new JLabel();

    JLabel productQuantityLabel = new JLabel();
    JLabel getQuantity = new JLabel();
    JLabel productDetailsLabel = new JLabel();
    JTextArea getDetails = new JTextArea();

    Font minefont = new Font("Arial", Font.BOLD, 24);
    Font secfont = new Font("Arial", Font.BOLD + Font.ITALIC, 20);

    //    public EditProduct(AdminClass Admin) {
    public EditProduct() {

        //********************************************************//
//        AdminClass.readMeals("Appetizers.txt");
//        AdminClass.readMeals("Main Meals.txt");
//        AdminClass.readMeals("furnitures.txt");
//        for (MealClass x : AdminClass.AppetizerMeals) {
//            addCookingButton(computersPanel, x);
//        }
//        for (MealClass x : AdminClass.MainMealMeals) {
//            addCookingButton(accessoriesPanel, x);
//        }
//        for (MealClass x : AdminClass.furnitureMeals) {
//            addCookingButton(furniturePanel, x);
//        }
        //********************************************************//        frame.setTitle("Bite Byte Restaurant");
        frame.setSize(1200, 800);
        frame.setTitle("Edit Menu");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*-------Popup Menu Modifiers-------*/
        popupMenu = new JPopupMenu();
        JMenuItem EditProduct = new JMenuItem("Edit");
        JMenuItem AddProduct = new JMenuItem("Add");
        JMenuItem DeleteProduct = new JMenuItem("Delete");
        popupMenu.add(EditProduct);
        popupMenu.addSeparator();
        popupMenu.add(AddProduct);
        popupMenu.addSeparator();
        popupMenu.add(DeleteProduct);
        //--------------//
        tabbedPane.addChangeListener(_ -> {
            int selectedIndex = tabbedPane.getSelectedIndex();
            String tabTitle = tabbedPane.getTitleAt(selectedIndex);
            String path, array;
            if (tabTitle.equals("Computers")) {
                path = "Computers.txt";
                array = "Computers";
            } else if (tabTitle.equals("Accessories")) {
                path = "Accessories.txt";
                array = "Accessories";
            } else {
                path = "furnitures.txt";
                array = "Furnitures";
            }

            AddProduct.addActionListener(_ -> {
                Component invoker = popupMenu.getInvoker();
                Container parent = invoker.getParent();
                AddEdit_Meal AddFrame = new AddEdit_Meal(frame, array);
                if (AddFrame.isClosed()) { // if the user click on (close button) we will not do anything
//                    refreshMealPanel(array, path, parent);
                }
            });
            EditProduct.addActionListener(_ -> {
                Component invoker = popupMenu.getInvoker();
                Container parent = invoker.getParent();
                if (invoker instanceof ButtonForMeals_EditFrame) {
//                    AddEdit_Meal EditFrame = new AddEdit_Meal(frame, ((ButtonForMeals_EditFrame) invoker).currMeal, array);
//                    if (EditFrame.isClosed()) {// if the user click on close button we will not do anything
//                        refreshMealPanel(array, path, parent);
//                    }
                }
            });
            DeleteProduct.addActionListener(_ -> {
                Component invoker = popupMenu.getInvoker();
                Container parent = invoker.getParent();
                if (invoker instanceof ButtonForMeals_EditFrame) {
//                    String MealName = String.valueOf(((ButtonForMeals_EditFrame) invoker).currMeal.getNameMeal());
//                    if (DialogMSG.ConfirmDeletion(MealName)) {
//                        AdminClass.removeMealFromFile(MealName, path);
//                        DialogMSG.DeletionSuccess(MealName);
//                        refreshMealPanel(array, path, parent);
//                    }
                }
            });
        });

        /*-------Information Modifiers-------*/
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Details.setText("<html><body style='width: 300px; line-height: 10;'>" + "Admin: " +" Admin.getUsername()" + "<br>" + formatter.format(today)    // Because You print Label Not String :)
                + "</body></html>");
        Details.setFont(new Font("Arial", Font.BOLD, 20));
        Details.setForeground(Color.WHITE);

        ImageIcon imageIcon = new ImageIcon("src\\Images\\Backgrounds\\OriRestaurant Logo.png");
        Image image = imageIcon.getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel RestaurantLogo = new JLabel(scaledIcon);

        /*-------Backgrounds Panel-------*/
        InformationPanel.setLayout(new BorderLayout(10, 10));
        InformationPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        InformationPanel.setOpaque(true);
        InformationPanel.setBackground(new Color(0, 0, 0, 150));
        InformationPanel.setBounds(10, 15, 330, 738);
        //--------------//
        computersScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        computersScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        computersPanel.setLayout(new GridLayout(0, 3, 10, 10));
        computersPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        computersPanel.setOpaque(true);
        computersPanel.setBackground(new Color(0, 0, 0, 150));
        //--------------//
        accessoriesPanel.setLayout(new GridLayout(0, 3, 10, 10));
        accessoriesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        accessoriesPanel.setOpaque(true);
        accessoriesPanel.setBackground(new Color(0, 0, 0, 150));

        accessoriesScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        accessoriesScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //--------------//
        furniturePanel.setLayout(new GridLayout(0, 3, 10, 10));
        furniturePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        furniturePanel.setOpaque(true);
        furniturePanel.setBackground(new Color(0, 0, 0, 150));

        furnitureScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        furnitureScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //--------------//
        tabbedPane.setBounds(350, 0, 825, 750);
        tabbedPane.setOpaque(false);
        //--------------//
        MainBackground = new PanelBackground("src\\Images\\Backgrounds\\Edit Menu Background.jpg");
        MainBackground.setLayout(null);
        /*-------productDetailsPanel-------*/
        productDetailsPanel.setOpaque(false);
        productDetailsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 15));
        productDetailsPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createBevelBorder(BevelBorder.RAISED),
                new EmptyBorder(4, 4, 4, 4)
        ));
        productNameLabel.setText("Meal's Name:");
        productNameLabel.setFont(minefont);
        productNameLabel.setForeground(new Color(0x8d6e63));
        productNameLabel.setPreferredSize(new Dimension(250, 20));

        getName.setFont(secfont);
        getName.setPreferredSize(new Dimension(250, 30));
        getName.setForeground(Color.white);

        productPriceLabel.setText("Meal's Price:");
        productPriceLabel.setFont(minefont);
        productPriceLabel.setForeground(new Color(0x8d6e63));
        productPriceLabel.setPreferredSize(new Dimension(250, 20));


        getPrice.setFont(secfont);
        getPrice.setForeground(Color.white);
        getPrice.setPreferredSize(new Dimension(250, 30));

        productQuantityLabel.setText("Meal's Quantity:");
        productQuantityLabel.setFont(minefont);
        productQuantityLabel.setForeground(new Color(0x8d6e63));
        productQuantityLabel.setPreferredSize(new Dimension(250, 20));

        getQuantity.setFont(secfont);
        getQuantity.setForeground(Color.white);
        getQuantity.setPreferredSize(new Dimension(250, 30));

        productDetailsLabel.setText("Meal's Details:");
        productDetailsLabel.setFont(minefont);
        productDetailsLabel.setForeground(new Color(0x8d6e63));
        productDetailsLabel.setPreferredSize(new Dimension(250, 20));

        getDetails.setFont(secfont);
        getDetails.setLineWrap(true);
        getDetails.setWrapStyleWord(true);
        getDetails.setOpaque(true);
        getDetails.setBackground(new Color(0, 0, 0, 100));
        getDetails.setEditable(false);
        getDetails.setForeground(Color.white);
        getDetails.setPreferredSize(new Dimension(285, 150));
        getDetails.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.repaint();
            }
        });
        getDetails.addCaretListener(_ -> frame.repaint());

        productDetailsPanel.add(productNameLabel);
        productDetailsPanel.add(getName);
        productDetailsPanel.add(productPriceLabel);
        productDetailsPanel.add(getPrice);
        productDetailsPanel.add(productQuantityLabel);
        productDetailsPanel.add(getQuantity);
        productDetailsPanel.add(productDetailsLabel);
        productDetailsPanel.add(getDetails);
        productDetailsPanel.setVisible(true);


        /*-------Adding Components-------*/
        InformationPanel.add(RestaurantLogo, BorderLayout.NORTH);
        InformationPanel.add(productDetailsPanel, BorderLayout.CENTER);
        InformationPanel.add(Details, BorderLayout.SOUTH);
        //--------------//
        tabbedPane.addTab("Appetizers", computersScroll);
        tabbedPane.addTab("Main Meals", accessoriesScroll);
        tabbedPane.addTab("furnitures", furnitureScroll);
        //--------------//
        MainBackground.add(InformationPanel);
        MainBackground.add(tabbedPane);
        //--------------//
        frame.add(MainBackground);
        frame.setVisible(true);
    }

    /* *****This Panel is every meal inside the tapped panels******* */
    public class ButtonForMeals_EditFrame extends JPanel {
        JButton DetailsButton = new JButton();
        JLabel NameLabel = new JLabel();
        JLabel PriceLabel = new JLabel();
        JPanel InfoPanel = new JPanel();
//        MealClass currMeal;

        //        public ButtonForMeals_EditFrame(MealClass meal) {
        public ButtonForMeals_EditFrame() {
//            currMeal = meal;
            this.setLayout(new BorderLayout());
            this.setPreferredSize(new Dimension(250, 160));
            this.setMaximumSize(new Dimension(250, 160));

            /*---------Details Button----------*/
            ImageIcon imageIcon = new ImageIcon(); //~ obj.getImage
            Image imgButton = imageIcon.getImage();
            Image scaledImgDetails = imgButton.getScaledInstance(250, 130, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImgDetails);
            DetailsButton.setIcon(imageIcon);
            DetailsButton.setContentAreaFilled(false);   // for solving image on info panel
            DetailsButton.setPreferredSize(new Dimension(100, 100));
            DetailsButton.setMaximumSize(new Dimension(100, 100));
            DetailsButton.addActionListener(_ -> {
//                getName.setText(/* obj.getName*/);
//                getPrice.setText(String.valueOf(/* obj.getPrice*/+ '$');
//                getDetails.setText(/* obj.getDeails*/);
//                getQuantity.setText(/* obj.getQuantity*/ + " Pieces");
                frame.repaint();
            });

            /*---------Name & Price----------*/
            InfoPanel.setLayout(new BorderLayout());
            InfoPanel.setPreferredSize(new Dimension(100, 31));
            InfoPanel.setBackground(new Color(0xdaa662));
            InfoPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));

            NameLabel.setForeground(Color.WHITE);
            NameLabel.setFont(new Font("Arial", Font.BOLD, 15));
//            NameLabel.setText(/* obj.getName*/);

            PriceLabel.setForeground(Color.WHITE);
//            PriceLabel.setText( /* obj.getPrice */ + '$');
            PriceLabel.setFont(new Font("Arial", Font.BOLD, 15));

            /*-------------Add Component--------------*/
            InfoPanel.add(PriceLabel, BorderLayout.EAST);
            InfoPanel.add(NameLabel, BorderLayout.CENTER);
            this.add(InfoPanel, BorderLayout.SOUTH);
            this.add(DetailsButton, BorderLayout.CENTER);
        }
    }

    // to Read From The Array And Passing data in ButtonForMeals_EditFrame To Show It
//    public void addCookingButton(JPanel panel, Produt produt) {
    public void addCookingButton() {
//        ButtonForMeals_EditFrame newMeal = new ButtonForMeals_EditFrame(produt);
        ButtonForMeals_EditFrame newMeal = new ButtonForMeals_EditFrame();
        newMeal.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showPopupMenu(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopupMenu(e);
            }

            private void showPopupMenu(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(newMeal, e.getX(), e.getY());
                    popupMenu.setInvoker(newMeal);
                }
            }
        });
//        panel.add(newMeal);
//        panel.revalidate();
//        panel.repaint();
    }

    // to Refresh the Meals onn the panel after any operation(Add, Edit, delete)
//    private void refreshMealPanel(String array, String path, Container parent) {
//        if (array.equals("Appetizers")) {
//            AdminClass.AppetizerMeals.clear();
//            parent.removeAll();
//            AdminClass.readMeals(path);
//            for (MealClass x : AdminClass.AppetizerMeals) {
//                addCookingButton(computersPanel, x);
//            }
//        } else if (array.equals("Main Meals")) {
//            AdminClass.MainMealMeals.clear();
//            parent.removeAll();
//            AdminClass.readMeals(path);
//            for (MealClass x : AdminClass.MainMealMeals) {
//                addCookingButton(accessoriesPanel, x);
//            }
//        } else {
//            AdminClass.furnitureMeals.clear();
//            parent.removeAll();
//            AdminClass.readMeals(path);
//            for (MealClass x : AdminClass.furnitureMeals) {
//                addCookingButton(furniturePanel, x);
//            }
//        }
//        parent.revalidate();
//        parent.repaint();
//        frame.revalidate();
//        frame.repaint();
    }

