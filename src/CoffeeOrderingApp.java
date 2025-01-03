import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Aplikasi pemesanan kopi berbasis Java Swing yang memungkinkan pengguna untuk memilih menu,
 * mengelola pesanan, dan menyelesaikan pembayaran.
 */
public class CoffeeOrderingApp {

    private JFrame frame;
    private JPanel menuPanel;
    private JPanel orderPanel;
    private DefaultListModel<String> orderListModel;
    private JLabel totalLabel;
    private ArrayList<Coffee> coffeeMenu;
    private double totalPrice = 0.0;
    private String orderType = ""; // "Dine In" or "Take Away"

    /**
     * Konstruktor utama untuk memulai aplikasi dan mengatur antarmuka pengguna grafis.
     */
    public CoffeeOrderingApp() {
        frame = new JFrame("Coffee Ordering App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Category Panel
        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new GridLayout(1, 3));

        JButton coffeeButton = new JButton("Coffee");
        coffeeButton.addActionListener(e -> loadCategory("Coffee"));

        JButton nonCoffeeButton = new JButton("Non-Coffee");
        nonCoffeeButton.addActionListener(e -> loadCategory("Non-Coffee"));

        JButton snacksButton = new JButton("Snacks");
        snacksButton.addActionListener(e -> loadCategory("Snacks"));

        categoryPanel.add(coffeeButton);
        categoryPanel.add(nonCoffeeButton);
        categoryPanel.add(snacksButton);

        frame.add(categoryPanel, BorderLayout.NORTH);

        // Menu Panel
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(3, 3, 10, 10));
        menuPanel.setBackground(Color.WHITE);

        // Order Panel
        orderPanel = new JPanel();
        orderPanel.setLayout(new BorderLayout());
        orderPanel.setBackground(Color.WHITE);

        orderListModel = new DefaultListModel<>();
        JList<String> orderList = new JList<>(orderListModel);
        JScrollPane orderScrollPane = new JScrollPane(orderList);

        totalLabel = new JLabel("Total: Rp0", JLabel.RIGHT);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JButton removeButton = new JButton("Remove Item");
        removeButton.addActionListener(e -> removeItem(orderList));

        JButton clearButton = new JButton("Clear All");
        clearButton.addActionListener(e -> clearAllOrders());

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setBackground(new Color(46, 204, 113)); // Green
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.setFocusPainted(false);
        checkoutButton.addActionListener(e -> chooseOrderType()); // Choose "Dine In" or "Take Away"

        JPanel orderActionsPanel = new JPanel();
        orderActionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        orderActionsPanel.add(removeButton);
        orderActionsPanel.add(clearButton);
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

    /**
     * Memuat kategori menu berdasarkan nama kategori yang diberikan.
     *
     * @param category nama kategori (contoh: "Coffee", "Non-Coffee", atau "Snacks")
     */
    private void loadCategory(String category) {
        menuPanel.removeAll();
        coffeeMenu = new ArrayList<>();

        // Example items for different categories
        if (category.equals("Coffee")) {
            coffeeMenu.add(new Coffee("Espresso", "25,000", new ImageIcon("D:\\JAVA MODUL\\SEMESTER 3\\UAP\\assets\\espresso.jpg")));
            coffeeMenu.add(new Coffee("Americano", "19,000", new ImageIcon("D:\\JAVA MODUL\\SEMESTER 3\\UAP\\assets\\americano.jpg")));
            coffeeMenu.add(new Coffee("Cappuccino", "24,000", new ImageIcon("D:\\JAVA MODUL\\SEMESTER 3\\UAP\\assets\\cappuccino.jpg")));
            coffeeMenu.add(new Coffee("Caramel Macchiato", "25,000", new ImageIcon("D:\\JAVA MODUL\\SEMESTER 3\\UAP\\assets\\Caramelmacchiato.jpg")));
            coffeeMenu.add(new Coffee("Charcoal Latte", "25,000", new ImageIcon("D:\\JAVA MODUL\\SEMESTER 3\\UAP\\assets\\charcoal latte.jpg")));
            coffeeMenu.add(new Coffee("Brown Sugar Latte", "20,000", new ImageIcon("D:\\JAVA MODUL\\SEMESTER 3\\UAP\\assets\\brown sugar latte.jpg")));

        } else if (category.equals("Non-Coffee")) {
            coffeeMenu.add(new Coffee("Green Tea Latte", "19,000", new ImageIcon("D:\\JAVA MODUL\\SEMESTER 3\\UAP\\assets\\greentea.jpg")));
            coffeeMenu.add(new Coffee("Milkshake Strawberry", "18,000", new ImageIcon("D:\\JAVA MODUL\\SEMESTER 3\\UAP\\assets\\milkshake.jpg")));
            coffeeMenu.add(new Coffee("Milkshake Vanilla", "18,000", new ImageIcon("D:\\JAVA MODUL\\SEMESTER 3\\UAP\\assets\\milkshake vanilla.jpg")));
            coffeeMenu.add(new Coffee("Milkshake Blackcurrant", "19,000", new ImageIcon("D:\\JAVA MODUL\\SEMESTER 3\\UAP\\assets\\milkshake blackcurrent.jpg")));
        } else if (category.equals("Snacks")) {
            coffeeMenu.add(new Coffee("French Fries", "17,000", new ImageIcon("D:\\JAVA MODUL\\SEMESTER 3\\UAP\\assets\\frenchfries.jpg")));
            coffeeMenu.add(new Coffee("Cheese Sticks", "23,000", new ImageIcon("D:\\JAVA MODUL\\SEMESTER 3\\UAP\\assets\\cheesesticks.jpg")));
            coffeeMenu.add(new Coffee("Onion Rings", "17,000", new ImageIcon("D:\\JAVA MODUL\\SEMESTER 3\\UAP\\assets\\onionrings.jpg")));
            coffeeMenu.add(new Coffee("Chocolate Cake", "20,000", new ImageIcon("D:\\JAVA MODUL\\SEMESTER 3\\UAP\\assets\\chocolatecake.jpg")));
            coffeeMenu.add(new Coffee("Donuts", "18,000", new ImageIcon("D:\\JAVA MODUL\\SEMESTER 3\\UAP\\assets\\donattttt.jpg")));
        }

        for (Coffee coffee : coffeeMenu) {
            JPanel coffeePanel = new JPanel();
            coffeePanel.setLayout(new BorderLayout());
            coffeePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            coffeePanel.setBackground(Color.LIGHT_GRAY);

            // Set image
            Image image = coffee.image.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(image));

            // Name and price
            JLabel nameLabel = new JLabel(coffee.name, JLabel.CENTER);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 14));

            JLabel priceLabel = new JLabel("Rp" + coffee.price, JLabel.CENTER);
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            priceLabel.setForeground(Color.GRAY);

            // Add button
            JButton addButton = new JButton("Pesan");
            addButton.setBackground(new Color(255, 165, 0)); // Orange
            addButton.setForeground(Color.WHITE);
            addButton.setFocusPainted(false);
            addButton.addActionListener(e -> addToOrder(coffee));

            // Add to panel
            coffeePanel.add(imageLabel, BorderLayout.CENTER);
            coffeePanel.add(nameLabel, BorderLayout.NORTH);
            coffeePanel.add(priceLabel, BorderLayout.SOUTH);
            coffeePanel.add(addButton, BorderLayout.EAST);

            menuPanel.add(coffeePanel);
        }

        menuPanel.revalidate();
        menuPanel.repaint();
    }

    /**
     * Menambahkan item ke daftar pesanan.
     *
     * @param coffee objek {@link Coffee} yang akan ditambahkan ke daftar pesanan
     */
    private void addToOrder(Coffee coffee) {
        String itemName = coffee.name;
        String itemPrice = coffee.price;

        orderListModel.addElement(itemName + " - Rp" + itemPrice);
        totalPrice += Double.parseDouble(itemPrice.replace(",", ""));
        totalLabel.setText("Total: Rp" + formatPrice(totalPrice));
    }

    /**
     * Menghapus item yang dipilih dari daftar pesanan.
     *
     * @param orderList daftar pesanan pengguna dalam format {@link JList}
     */
    private void removeItem(JList<String> orderList) {
        int selectedIndex = orderList.getSelectedIndex();
        if (selectedIndex != -1) {
            // Get selected item details
            String selectedItem = orderListModel.get(selectedIndex);
            String[] parts = selectedItem.split(" - Rp");
            String priceString = parts[1].replace(",", ""); // Get price
            double price = Double.parseDouble(priceString);

            // Subtract item price from total
            totalPrice -= price;

            // Remove item from order list
            orderListModel.remove(selectedIndex);

            // Update total label
            totalLabel.setText("Total: Rp" + formatPrice(totalPrice));
        } else {
            JOptionPane.showMessageDialog(frame, "Please select an item to remove.");
        }
    }

    /**
     * Menghapus semua item dari daftar pesanan.
     */
    private void clearAllOrders() {
        orderListModel.clear();
        totalPrice = 0.0;
        totalLabel.setText("Total: Rp0");
    }

    /**
     * Menampilkan dialog untuk memilih jenis pesanan (Dine In atau Take Away).
     */
    private void chooseOrderType() {
        if (orderListModel.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Pesanan Anda kosong! Silakan tambahkan item ke dalam pesanan terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] options = {"Dine In", "Take Away"};
        int choice = JOptionPane.showOptionDialog(frame, "Choose your order type:", "Order Type",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            orderType = "Dine In";
        } else if (choice == 1) {
            orderType = "Take Away";
        }

        if (!orderType.isEmpty()) {
            choosePaymentMethod();
        }
    }

    /**
     * Menampilkan dialog untuk memilih metode pembayaran dan menyelesaikan pembayaran.
     */
    private void choosePaymentMethod() {
        if (orderListModel.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Pesanan Anda kosong! Silakan tambahkan item ke dalam pesanan terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] paymentMethods = {"Cash", "Credit Card", "E-Wallet"};
        String paymentMethod = (String) JOptionPane.showInputDialog(frame, "Select Payment Method:\nOrder Type: " + orderType,
                "Payment", JOptionPane.PLAIN_MESSAGE, null, paymentMethods, paymentMethods[0]);

        if (paymentMethod != null) {
            double tax = totalPrice * 0.12;
            double finalTotal = totalPrice + tax;

            StringBuilder orderDetails = new StringBuilder();
            for (int i = 0; i < orderListModel.size(); i++) {
                orderDetails.append(orderListModel.getElementAt(i)).append("\n");
            }

            JOptionPane.showMessageDialog(frame, "Order Type: " + orderType + "\n" +
                    "Payment Method: " + paymentMethod + "\n\nOrder Details:\n" + orderDetails.toString() +
                    "Subtotal: Rp" + formatPrice(totalPrice) + "\nTax (12%): Rp" + formatPrice(tax) +
                    "\nTotal: Rp" + formatPrice(finalTotal));

            orderListModel.clear();
            totalPrice = 0.0;
            totalLabel.setText("Total: Rp0");
        }
    }

    /**
     * Memformat harga menjadi string yang sesuai dengan format Rupiah.
     *
     * @param price nilai harga dalam bentuk double
     * @return string harga yang terformat
     */
    private String formatPrice(double price) {
        return String.format("%,.0f", price).replace(',', '.');
    }

    /**
     * Metode utama untuk menjalankan aplikasi pemesanan kopi.
     *
     * @param args argumen baris perintah
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CoffeeOrderingApp::new);
    }
}
