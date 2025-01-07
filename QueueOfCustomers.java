import java.util.LinkedList;
import java.util.Queue;

public class QueueOfCustomers {
    private Queue<Customer> customerQueue;

    public QueueOfCustomers() {
        this.customerQueue = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        customerQueue.add(customer);
    }

    public Customer removeCustomer() {
        return customerQueue.poll();
    }

    public Queue<Customer> getCustomers() {
        return customerQueue;
    }

    public boolean isEmpty() {
        return customerQueue.isEmpty();
    }
}
