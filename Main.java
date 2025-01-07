import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.start();
        SwingUtilities.invokeLater(() -> new ParcelManagementGUI(manager).setVisible(true));
    }
}
