import javax.swing.*;
import java.awt.*;
import java.util.stream.Collectors;

public class ParcelManagementGUI extends JFrame {
    private Manager manager;

    // GUI Components
    private JList<Customer> customerList;
    private JList<Parcel> parcelList;
    private JTextArea currentParcelArea;
    private JTextArea logArea;

    // Buttons
    private JButton addCustomerButton;
    private JButton removeCustomerButton;
    private JButton processParcelButton;
    private JButton addParcelButton;
    private JButton exitButton;

    public ParcelManagementGUI(Manager manager) {
        this.manager = manager;
        setTitle("Parcel Management System");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initComponents();
        updateLists();
    }

    private void initComponents() {
        // Panels
        JPanel customerPanel = new JPanel(new BorderLayout());
        JPanel parcelPanel = new JPanel(new BorderLayout());
        JPanel processingPanel = new JPanel(new BorderLayout());
        JPanel logPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Customer Panel
        customerPanel.setBorder(BorderFactory.createTitledBorder("Customer Queue"));
        customerList = new JList<>();
        customerPanel.add(new JScrollPane(customerList), BorderLayout.CENTER);

        // Parcel Panel
        parcelPanel.setBorder(BorderFactory.createTitledBorder("Parcel List"));
        parcelList = new JList<>();
        parcelPanel.add(new JScrollPane(parcelList), BorderLayout.CENTER);

        // Processing Panel
        processingPanel.setBorder(BorderFactory.createTitledBorder("Current Processing"));
        currentParcelArea = new JTextArea(10, 30);
        currentParcelArea.setEditable(false);
        processingPanel.add(new JScrollPane(currentParcelArea), BorderLayout.CENTER);

        // Log Panel
        logPanel.setBorder(BorderFactory.createTitledBorder("Log"));
        logArea = new JTextArea(10, 30);
        logArea.setEditable(false);
        logPanel.add(new JScrollPane(logArea), BorderLayout.CENTER);

        // Buttons
        addCustomerButton = new JButton("Add Customer");
        removeCustomerButton = new JButton("Remove Customer");
        processParcelButton = new JButton("Process Parcel");
        addParcelButton = new JButton("Add Parcel");
        exitButton = new JButton("Exit");

        buttonPanel.add(addCustomerButton);
        buttonPanel.add(removeCustomerButton);
        buttonPanel.add(processParcelButton);
        buttonPanel.add(addParcelButton);
        buttonPanel.add(exitButton);

        // Add panels to frame
        add(customerPanel, BorderLayout.WEST);
        add(parcelPanel, BorderLayout.EAST);
        add(processingPanel, BorderLayout.CENTER);
        add(logPanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.NORTH);

        // Button Actions
        addCustomerButton.addActionListener(e -> addCustomer());
        removeCustomerButton.addActionListener(e -> removeCustomer());
        processParcelButton.addActionListener(e -> processParcel());
        addParcelButton.addActionListener(e -> addParcel());
        exitButton.addActionListener(e -> System.exit(0));
    }

    public void updateLists() {
        // Update customer list
        Customer[] customers = manager.getCustomerQueue().getCustomers()
                .stream()
                .toArray(Customer[]::new);
        customerList.setListData(customers);

        // Update parcel list
        Parcel[] parcels = manager.getParcelMap().getParcels()
                .stream()
                .toArray(Parcel[]::new);
        parcelList.setListData(parcels);

        // Clear the current parcel area if no customers or parcels remain
        if (customers.length == 0 && parcels.length == 0) {
            currentParcelArea.setText("No customers or parcels available for processing.");
        }
    }

    private void addCustomer() {
        String id = JOptionPane.showInputDialog(this, "Enter Customer ID:");
        String name = JOptionPane.showInputDialog(this, "Enter Customer Name:");
        String contact = JOptionPane.showInputDialog(this, "Enter Customer Contact:");
        if (id != null && name != null && contact != null) {
            Customer customer = new Customer(id, name, contact);
            manager.getCustomerQueue().addCustomer(customer);
            Log.getInstance().addEntry("Customer added: " + customer.getDetails());
            updateLists();
        }
    }

    private void removeCustomer() {
        Customer customer = manager.getCustomerQueue().removeCustomer();
        if (customer != null) {
            Log.getInstance().addEntry("Customer removed: " + customer.getDetails());
            updateLists();
        } else {
            JOptionPane.showMessageDialog(this, "No customers in the queue!");
        }
    }

    private void processParcel() {
        Customer customer = manager.getCustomerQueue().removeCustomer();
        if (customer != null) {
            Parcel parcel = manager.getParcelMap().getParcel(customer.getId());
            if (parcel != null) {
                // Remove the parcel from the map
                manager.getParcelMap().removeParcel(parcel.getParcelId());

                // Process the customer and parcel
                manager.getWorker().processCustomer(customer, parcel);

                // Update the log
                Log.getInstance().addEntry("Processed Customer: " + customer.getDetails() +
                        " with Parcel: " + parcel.getDetails());

                // Update the GUI
                currentParcelArea.setText("Processing:\n" + customer.getDetails() + "\n" + parcel.getDetails());
                updateLists();
            } else {
                JOptionPane.showMessageDialog(this, "No matching parcel found for Customer: " + customer.getName());
            }
        } else {
            JOptionPane.showMessageDialog(this, "No customers in the queue!");
        }
    }

    private void addParcel() {
        String id = JOptionPane.showInputDialog(this, "Enter Parcel ID:");
        String destination = JOptionPane.showInputDialog(this, "Enter Parcel Destination:");
        String weightInput = JOptionPane.showInputDialog(this, "Enter Parcel Weight (kg):");
        if (id != null && destination != null && weightInput != null) {
            try {
                double weight = Double.parseDouble(weightInput);
                Parcel parcel = new Parcel(id, weight, destination);
                manager.getParcelMap().addParcel(parcel);
                Log.getInstance().addEntry("Parcel added: " + parcel.getDetails());
                updateLists();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid weight format!");
            }
        }
    }
}
