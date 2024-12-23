import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CoffeeOrderingApp {

    // Class to store coffee details
    static class Coffee {
        String name;
        String price;
        ImageIcon image;

        public Coffee(String name, String price, ImageIcon image) {
            this.name = name;
            this.price = price;
            this.image = image;
        }
    }

    private JFrame frame;
    private JPanel menuPanel;
    private JPanel orderPanel;
    private DefaultListModel<String> orderListModel;
    private JLabel totalLabel;
    private ArrayList<Coffee> coffeeMenu;
    private double totalPrice = 0.0;

    public CoffeeOrderingApp() {
        frame = new JFrame("Coffee Ordering App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Menu Panel
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(0, 2, 10, 10));

        // Order Panel
        orderPanel = new JPanel();
        orderPanel.setLayout(new BorderLayout());

        orderListModel = new DefaultListModel<>();
        JList<String> orderList = new JList<>(orderListModel);
        JScrollPane orderScrollPane = new JScrollPane(orderList);

        totalLabel = new JLabel("Total: Rp0", JLabel.RIGHT);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> checkout());

        orderPanel.add(orderScrollPane, BorderLayout.CENTER);
        orderPanel.add(totalLabel, BorderLayout.NORTH);
        orderPanel.add(checkoutButton, BorderLayout.SOUTH);

        // Load menu items
        loadCoffeeMenu();

        // Add menu to frame
        frame.add(new JScrollPane(menuPanel), BorderLayout.CENTER);
        frame.add(orderPanel, BorderLayout.EAST);

        frame.setVisible(true);
    }

    private void loadCoffeeMenu() {
        coffeeMenu = new ArrayList<>();

        // Example items (these can be replaced with data from an API)
        coffeeMenu.add(new Coffee("FOURever KOPI SUSU AREN", "Rp79.000", new ImageIcon("path/to/image1.jpg")));
        coffeeMenu.add(new Coffee("FOURever TOMORO Aren Latte", "Rp87.000", new ImageIcon("path/to/image2.jpg")));
        coffeeMenu.add(new Coffee("Duo Cheese Series", "Rp57.000", new ImageIcon("path/to/image3.jpg")));
        coffeeMenu.add(new Coffee("FOURever Cheese Series", "Rp108.000", new ImageIcon("path/to/image4.jpg")));

        for (Coffee coffee : coffeeMenu) {
            JPanel coffeePanel = new JPanel();
            coffeePanel.setLayout(new BorderLayout());

            JLabel imageLabel = new JLabel(coffee.image);
            JLabel nameLabel = new JLabel(coffee.name, JLabel.CENTER);
            JLabel priceLabel = new JLabel(coffee.price, JLabel.CENTER);

            JButton addButton = new JButton("Add to Order");
            addButton.addActionListener(e -> addToOrder(coffee));

            coffeePanel.add(imageLabel, BorderLayout.CENTER);
            coffeePanel.add(nameLabel, BorderLayout.NORTH);
            coffeePanel.add(priceLabel, BorderLayout.SOUTH);
            coffeePanel.add(addButton, BorderLayout.EAST);

            menuPanel.add(coffeePanel);
        }
    }

    private void addToOrder(Coffee coffee) {
        orderListModel.addElement(coffee.name + " - " + coffee.price);
        totalPrice += Double.parseDouble(coffee.price.replace("Rp", "").replace(".", ""));
        totalLabel.setText("Total: Rp" + totalPrice);
    }

    private void checkout() {
        JOptionPane.showMessageDialog(frame, "Thank you for your order! Total: Rp" + totalPrice);
        orderListModel.clear();
        totalPrice = 0.0;
        totalLabel.setText("Total: Rp0");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CoffeeOrderingApp::new);
    }
}
