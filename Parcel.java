public class Parcel {
    private String id;
    private double weight;
    private boolean isProcessed;

    public Parcel(String id, double weight) {
        this.id = id;
        this.weight = weight;
        this.isProcessed = false;
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void markAsProcessed() {
        this.isProcessed = true;
    }

    @Override
    public String toString() {
        return "Parcel{id='" + id + "', weight=" + weight + ", processed=" + isProcessed + "}";
    }
}
