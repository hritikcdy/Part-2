import javax.swing.*;
import java.awt.*;

public class Manager {
    private QueueOfCustomers customerQueue;
    private ParcelMap parcelMap;
    private Worker worker;

    public Manager() {
        customerQueue = new QueueOfCustomers();
        parcelMap = new ParcelMap();
        worker = new Worker(parcelMap, customerQueue);
    }

    public void loadData() {
        // Simulate loading customer and parcel data
        customerQueue.addCustomer(new Customer("John Doe", "C001"));
        customerQueue.addCustomer(new Customer("Jane Smith", "C002"));

        parcelMap.addParcel(new Parcel("P001", 5.0));
        parcelMap.addParcel(new Parcel("P002", 3.2));
    }

    public void launchGUI() {
        JFrame frame = new JFrame("Depot System");
        frame.setLayout(new BorderLayout());
        JTextArea logArea = new JTextArea(10, 40);
        logArea.setEditable(false);
        frame.add(new JScrollPane(logArea), BorderLayout.CENTER);

        JButton processButton = new JButton("Process Customer");
        processButton.addActionListener(e -> {
            worker.processCustomer();
            logArea.setText(Log.getInstance().getLog());
        });
        frame.add(processButton, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.loadData();
        manager.launchGUI();
    }
}
