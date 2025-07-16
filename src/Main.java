
import UI_Storehouse.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception _) {}
        SwingUtilities.invokeLater(OrderSearch::new);
//        SwingUtilities.invokeLater(CreateAccount::new);
//        SwingUtilities.invokeLater(MainFrame::new);
//        SwingUtilities.invokeLater(EditProduct::new);
//        SwingUtilities.invokeLater(EditProduct::new);


    }


}