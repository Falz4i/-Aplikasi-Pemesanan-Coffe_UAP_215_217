import javax.swing.*;
import java.awt.*;
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

        // Category Panel
        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new GridLayout(1, 4));

        JButton coffeeButton = new JButton("Coffee");
        coffeeButton.addActionListener(e -> loadCategory("Coffee"));

        JButton nonCoffeeButton = new JButton("Non-Coffee");
        nonCoffeeButton.addActionListener(e -> loadCategory("Non-Coffee"));

        JButton snacksButton = new JButton("Snacks");
        snacksButton.addActionListener(e -> loadCategory("Snacks"));

        JButton promoButton = new JButton("Promo");
        promoButton.addActionListener(e -> loadCategory("Promo"));

        categoryPanel.add(coffeeButton);
        categoryPanel.add(nonCoffeeButton);
        categoryPanel.add(snacksButton);
        categoryPanel.add(promoButton);

        frame.add(categoryPanel, BorderLayout.NORTH);

        // Menu Panel
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(5, 2, 10, 10)); // 5 rows, 2 columns

        // Order Panel
        orderPanel = new JPanel();
        orderPanel.setLayout(new BorderLayout());

        orderListModel = new DefaultListModel<>();
        JList<String> orderList = new JList<>(orderListModel);
        JScrollPane orderScrollPane = new JScrollPane(orderList);

        totalLabel = new JLabel("Total: Rp0", JLabel.RIGHT);

        JButton editButton = new JButton("Edit Quantity");
        editButton.addActionListener(e -> editQuantity(orderList));

        JButton removeButton = new JButton("Remove Item");
        removeButton.addActionListener(e -> removeItem(orderList));

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> checkout());

        JPanel orderActionsPanel = new JPanel();
        orderActionsPanel.add(editButton);
        orderActionsPanel.add(removeButton);
        orderActionsPanel.add(checkoutButton);

        orderPanel.add(orderScrollPane, BorderLayout.CENTER);
        orderPanel.add(totalLabel, BorderLayout.NORTH);
        orderPanel.add(orderActionsPanel, BorderLayout.SOUTH);

        // Load initial menu items
        loadCategory("Coffee");

        // Add menu and order panels to frame
        frame.add(new JScrollPane(menuPanel), BorderLayout.CENTER);
        frame.add(orderPanel, BorderLayout.EAST);

        frame.setVisible(true);
    }

    private void loadCategory(String category) {
        menuPanel.removeAll();
        coffeeMenu = new ArrayList<>();

        // Example items for different categories (these can be replaced with API data)
        if (category.equals("Coffee")) {
            coffeeMenu.add(new Coffee("FOURever KOPI SUSU AREN", "79,000", new ImageIcon("path/to/image1.jpg")));
            coffeeMenu.add(new Coffee("FOURever TOMORO Aren Latte", "87,000", new ImageIcon("path/to/image2.jpg")));
            coffeeMenu.add(new Coffee("Espresso", "30,000", new ImageIcon("path/to/image3.jpg")));
            coffeeMenu.add(new Coffee("Cappuccino", "40,000", new ImageIcon("path/to/image4.jpg")));
            coffeeMenu.add(new Coffee("Latte", "35,000", new ImageIcon("path/to/image5.jpg")));
            coffeeMenu.add(new Coffee("Americano", "25,000", new ImageIcon("path/to/image6.jpg")));
            coffeeMenu.add(new Coffee("Mocha", "45,000", new ImageIcon("path/to/image7.jpg")));
            coffeeMenu.add(new Coffee("Macchiato", "50,000", new ImageIcon("path/to/image8.jpg")));
            coffeeMenu.add(new Coffee("Flat White", "55,000", new ImageIcon("path/to/image9.jpg")));
            coffeeMenu.add(new Coffee("Affogato", "60,000", new ImageIcon("path/to/image10.jpg")));
        } else if (category.equals("Non-Coffee")) {
            coffeeMenu.add(new Coffee("Green Tea Latte", "65,000", new ImageIcon("path/to/image11.jpg")));
            coffeeMenu.add(new Coffee("Milkshake Vanilla", "60,000", new ImageIcon("path/to/image12.jpg")));
        } else if (category.equals("Snacks")) {
            coffeeMenu.add(new Coffee("Cheese Croissant", "45,000", new ImageIcon("path/to/image13.jpg")));
            coffeeMenu.add(new Coffee("Chocolate Muffin", "35,000", new ImageIcon("path/to/image14.jpg")));
        } else if (category.equals("Promo")) {
            coffeeMenu.add(new Coffee("Duo Spanish Latte", "54,000", new ImageIcon("path/to/image15.jpg")));
            coffeeMenu.add(new Coffee("Special Combo", "105,000", new ImageIcon("path/to/image16.jpg")));
        }

        for (Coffee coffee : coffeeMenu) {
            JPanel coffeePanel = new JPanel();
            coffeePanel.setLayout(new BorderLayout());

            JLabel imageLabel = new JLabel(coffee.image);
            JLabel nameLabel = new JLabel(coffee.name, JLabel.CENTER);
            JLabel priceLabel = new JLabel("Rp" + coffee.price, JLabel.CENTER);

            JButton addButton = new JButton("Add to Order");
            addButton.addActionListener(e -> addToOrder(coffee));

            coffeePanel.add(imageLabel, BorderLayout.CENTER);
            coffeePanel.add(nameLabel, BorderLayout.NORTH);
            coffeePanel.add(priceLabel, BorderLayout.SOUTH);
            coffeePanel.add(addButton, BorderLayout.EAST);

            menuPanel.add(coffeePanel);
        }

        menuPanel.revalidate();
        menuPanel.repaint();
    }

    private void addToOrder(Coffee coffee) {
        String itemName = coffee.name;
        String itemPrice = coffee.price;

        // Check if the item is already in the order list
        boolean itemExists = false;
        for (int i = 0; i < orderListModel.size(); i++) {
            String orderItem = orderListModel.get(i);
            if (orderItem.startsWith(itemName)) {
                // Item exists, update the quantity
                String[] parts = orderItem.split(" x");
                int currentQuantity = Integer.parseInt(parts[1].split(" - Rp")[0]);
                currentQuantity++;
                double price = Double.parseDouble(parts[1].split(" - Rp")[1].replace(",", ""));
                totalPrice -= price; // Remove the old price
                totalPrice += Double.parseDouble(itemPrice.replace(",", "")); // Add the new price
                orderListModel.set(i, itemName + " x" + currentQuantity + " - Rp" + formatPrice(currentQuantity * Double.parseDouble(itemPrice.replace(",", ""))));
                itemExists = true;
                break;
            }
        }

        // If the item does not exist, add it to the order
        if (!itemExists) {
            orderListModel.addElement(itemName + " x1 - Rp" + itemPrice);
            totalPrice += Double.parseDouble(itemPrice.replace(",", ""));
        }

        totalLabel.setText("Total: Rp" + formatPrice(totalPrice));
    }

    private void editQuantity(JList<String> orderList) {
        int selectedIndex = orderList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(frame, "Please select an item to edit quantity.");
            return;
        }

        String selectedItem = orderListModel.get(selectedIndex);
        String[] parts = selectedItem.split(" x");
        String name = parts[0];
        double price = Double.parseDouble(parts[1].split(" - Rp")[1].replace(",", ""));

        String quantityStr = JOptionPane.showInputDialog(frame, "Enter new quantity for " + name + ":", "1");
        if (quantityStr == null || quantityStr.isEmpty()) {
            return;
        }

        try {
            int newQuantity = Integer.parseInt(quantityStr);
            if (newQuantity <= 0) {
                JOptionPane.showMessageDialog(frame, "Quantity must be greater than 0.");
                return;
            }

            totalPrice -= price; // Remove the old price
            totalPrice += price / (Integer.parseInt(parts[1].split(" - Rp")[0])) * newQuantity; // Update total price
            orderListModel.set(selectedIndex, name + " x" + newQuantity + " - Rp" + formatPrice(price / (Integer.parseInt(parts[1].split(" - Rp")[0])) * newQuantity));
            totalLabel.setText("Total: Rp" + formatPrice(totalPrice));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid quantity entered.");
        }
    }

    private void removeItem(JList<String> orderList) {
        int selectedIndex = orderList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(frame, "Please select an item to remove.");
            return;
        }

        // Get the selected item's details
        String selectedItem = orderListModel.get(selectedIndex);
        String[] parts = selectedItem.split(" x");
        String name = parts[0];
        String[] priceParts = parts[1].split(" - Rp");
        int quantity = Integer.parseInt(priceParts[0].trim());
        double pricePerUnit = Double.parseDouble(priceParts[1].replace(",", ""));
        double totalItemPrice = quantity * pricePerUnit;

        // Update the total price
        totalPrice -= totalItemPrice;

        // Remove the item from the order list
        orderListModel.remove(selectedIndex);

        // Refresh the total price label
        totalLabel.setText("Total: Rp" + formatPrice(totalPrice));
        totalLabel.repaint(); // Ensure the label is visually refreshed
    }



    private void checkout() {
        double tax = totalPrice * 0.12;
        double finalTotal = totalPrice + tax;
        String[] paymentMethods = {"Cash", "Credit Card", "E-Wallet"};
        String paymentMethod = (String) JOptionPane.showInputDialog(frame, "Select Payment Method:", "Payment", JOptionPane.PLAIN_MESSAGE, null, paymentMethods, paymentMethods[0]);

        if (paymentMethod != null) {
            JOptionPane.showMessageDialog(frame, "Payment Method: " + paymentMethod + "\nTotal: Rp" + formatPrice(finalTotal) + "\n(Including 12% Tax: Rp" + formatPrice(tax) + ")");
            orderListModel.clear();
            totalPrice = 0.0;
            totalLabel.setText("Total: Rp0");
        }
    }

    private String formatPrice(double price) {
        return String.format("%,.0f", price).replace(',', '.');
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CoffeeOrderingApp::new);
    }
}