public class Parcel {
    private String parcelId;
    private double weight;
    private String destination;

    public Parcel(String parcelId, double weight, String destination) {
        this.parcelId = parcelId;
        this.weight = weight;
        this.destination = destination;
    }

    public String getParcelId() {
        return parcelId;
    }

    public double getWeight() {
        return weight;
    }

    public String getDestination() {
        return destination;
    }

    public String getDetails() {
        return "Parcel ID: " + parcelId + ", Weight: " + weight + " kg, Destination: " + destination;
    }
}
