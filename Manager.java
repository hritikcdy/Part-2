public class Manager {
    private QueueOfCustomers customerQueue;
    private ParcelMap parcelMap;
    private Worker worker;
    private Log log;

    public Manager() {
        this.customerQueue = new QueueOfCustomers();
        this.parcelMap = new ParcelMap();
        this.worker = new Worker();
        this.log = Log.getInstance();
    }

    public void initializeData() {
        // Adding customers
        customerQueue.addCustomer(new Customer("X919", "Andrew Robertson", "andrew@example.com"));
        customerQueue.addCustomer(new Customer("X064", "Ann Jones", "ann@example.com"));
        customerQueue.addCustomer(new Customer("X682", "Blair Foster", "blair@example.com"));
        customerQueue.addCustomer(new Customer("X780", "Bob Dawson", "bob@example.com"));
        customerQueue.addCustomer(new Customer("X782", "Chris Smith", "chris@example.com"));
        customerQueue.addCustomer(new Customer("X316", "Dave Jackson", "dave@example.com"));
        customerQueue.addCustomer(new Customer("X278", "David Hunter", "david@example.com"));
        customerQueue.addCustomer(new Customer("X720", "Donald Murray", "donald@example.com"));
        customerQueue.addCustomer(new Customer("X475", "Fiona Thoms", "fiona@example.com"));
        customerQueue.addCustomer(new Customer("X386", "Gillian Hamilton", "gillian@example.com"));
        customerQueue.addCustomer(new Customer("X857", "Harry Johnston", "harry@example.com"));
        customerQueue.addCustomer(new Customer("X309", "Helen Webster", "helen@example.com"));
        customerQueue.addCustomer(new Customer("X733", "Jack Houston", "jack@example.com"));
        customerQueue.addCustomer(new Customer("X285", "Jo Hill", "jo@example.com"));
        customerQueue.addCustomer(new Customer("X213", "Joe Woods", "joe@example.com"));
        customerQueue.addCustomer(new Customer("X009", "John Brown", "john@example.com"));
        customerQueue.addCustomer(new Customer("X904", "Judy Hilman", "judy@example.com"));
        customerQueue.addCustomer(new Customer("X552", "Keith Burns", "keith@example.com"));
        customerQueue.addCustomer(new Customer("X121", "Lily Watson", "lily@example.com"));
        customerQueue.addCustomer(new Customer("X025", "Lucy Grey", "lucy@example.com"));
        customerQueue.addCustomer(new Customer("X198", "Mary Brown", "mary@example.com"));
        customerQueue.addCustomer(new Customer("X521", "Pamela Field", "pamela@example.com"));
        customerQueue.addCustomer(new Customer("X036", "Peter White", "peter@example.com"));
        customerQueue.addCustomer(new Customer("X606", "Robert Murray", "robert@example.com"));
        customerQueue.addCustomer(new Customer("X214", "Susan Turner", "susan@example.com"));
        customerQueue.addCustomer(new Customer("X507", "Thomas Young", "thomas@example.com"));
        customerQueue.addCustomer(new Customer("X020", "Tim Smith", "tim@example.com"));
        customerQueue.addCustomer(new Customer("X086", "Tony Lawson", "tony@example.com"));
        customerQueue.addCustomer(new Customer("X746", "Ursula Milton", "ursula@example.com"));
        customerQueue.addCustomer(new Customer("X540", "Viola Nicholson", "viola@example.com"));

        // Adding parcels with matching weights, IDs, and destinations
        parcelMap.addParcel(new Parcel("X009", 9.7, "Destination 919"));
        parcelMap.addParcel(new Parcel("X020", 11.4, "Destination 14"));
        parcelMap.addParcel(new Parcel("X025", 7.9, "Destination 9"));
        parcelMap.addParcel(new Parcel("X036", 8.12, "Destination 12"));
        parcelMap.addParcel(new Parcel("X064", 8.15, "Destination 15"));
        parcelMap.addParcel(new Parcel("X086", 7.13, "Destination 13"));
        parcelMap.addParcel(new Parcel("X121", 3.6, "Destination 6"));
        parcelMap.addParcel(new Parcel("X198", 9.10, "Destination 10"));
        parcelMap.addParcel(new Parcel("X213", 4.15, "Destination 15"));
        parcelMap.addParcel(new Parcel("X214", 1.15, "Destination 15"));
        parcelMap.addParcel(new Parcel("X278", 5.11, "Destination 11"));
        parcelMap.addParcel(new Parcel("X285", 1.10, "Destination 10"));
        parcelMap.addParcel(new Parcel("X309", 1.11, "Destination 11"));
        parcelMap.addParcel(new Parcel("X316", 9.11, "Destination 11"));
        parcelMap.addParcel(new Parcel("X386", 9.9, "Destination 9"));
        parcelMap.addParcel(new Parcel("X475", 4.11, "Destination 11"));
        parcelMap.addParcel(new Parcel("X507", 5.13, "Destination 13"));
        parcelMap.addParcel(new Parcel("X521", 6.8, "Destination 8"));
        parcelMap.addParcel(new Parcel("X540", 9.5, "Destination 5"));
        parcelMap.addParcel(new Parcel("X552", 4.12, "Destination 12"));
        parcelMap.addParcel(new Parcel("X606", 8.13, "Destination 13"));
        parcelMap.addParcel(new Parcel("X682", 3.12, "Destination 12"));
        parcelMap.addParcel(new Parcel("X720", 4.8, "Destination 8"));
        parcelMap.addParcel(new Parcel("X733", 6.11, "Destination 11"));
        parcelMap.addParcel(new Parcel("X746", 4.7, "Destination 7"));
        parcelMap.addParcel(new Parcel("X780", 4.12, "Destination 12"));
        parcelMap.addParcel(new Parcel("X782", 5.12, "Destination 12"));
        parcelMap.addParcel(new Parcel("X857", 2.9, "Destination 9"));
        parcelMap.addParcel(new Parcel("X904", 4.15, "Destination 15"));
        parcelMap.addParcel(new Parcel("X919", 5.10, "Destination 1"));
    }

    public QueueOfCustomers getCustomerQueue() {
        return customerQueue;
    }

    public ParcelMap getParcelMap() {
        return parcelMap;
    }

    public Worker getWorker() {
        return worker;
    }

    public void start() {
        System.out.println("Starting Parcel Management System...");
        initializeData();
    }
}
