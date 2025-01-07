public class Customer {
    private String id;
    private String name;
    private String contactDetails;

    public Customer(String id, String name, String contactDetails) {
        this.id = id;
        this.name = name;
        this.contactDetails = contactDetails;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public String getDetails() {
        return "Customer ID: " + id + ", Name: " + name + ", Contact: " + contactDetails;
    }
}
