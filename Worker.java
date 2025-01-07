public class Worker {
    public double calculateFee(Parcel parcel) {
        return parcel.getWeight() * 2.5; // Example fee calculation
    }

    public void processCustomer(Customer customer, Parcel parcel) {
        double fee = calculateFee(parcel);
        System.out.println("Processed Customer: " + customer.getName());
        System.out.println("Parcel: " + parcel.getDetails());
        System.out.println("Fee: £" + fee);
        Log.getInstance().addEntry("Processed Customer: " + customer.getName() +
                ", Parcel: " + parcel.getDetails() + ", Fee: £" + fee);
    }
}
