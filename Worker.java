public class Worker {
    private ParcelMap parcelMap;
    private QueueOfCustomers customerQueue;

    public Worker(ParcelMap parcelMap, QueueOfCustomers customerQueue) {
        this.parcelMap = parcelMap;
        this.customerQueue = customerQueue;
    }

    public double calculateFee(Parcel parcel) {
        // Implement a basic fee calculation based on weight
        return parcel.getWeight() * 2.5; // Fee per weight unit
    }

    public void processCustomer() {
        if (!customerQueue.isEmpty()) {
            Customer customer = customerQueue.removeCustomer();
            Log.getInstance().logEvent("Processing customer: " + customer.getName());
            // Simulate processing a parcel
            Parcel parcel = parcelMap.getParcel("some_parcel_id"); // Example usage
            if (parcel != null && !parcel.isProcessed()) {
                double fee = calculateFee(parcel);
                Log.getInstance().logEvent("Parcel " + parcel.getId() + " processed with fee: " + fee);
                parcel.markAsProcessed();
            }
        }
    }
}
