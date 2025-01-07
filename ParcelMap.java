import java.util.Collection;
import java.util.HashMap;

public class ParcelMap {
    private HashMap<String, Parcel> parcelMap;

    public ParcelMap() {
        this.parcelMap = new HashMap<>();
    }

    public void addParcel(Parcel parcel) {
        parcelMap.put(parcel.getParcelId(), parcel);
    }

    public Parcel getParcel(String parcelId) {
        return parcelMap.get(parcelId);
    }

    public void removeParcel(String parcelId) {
        parcelMap.remove(parcelId);
    }

    public Collection<Parcel> getParcels() {
        return parcelMap.values();
    }
}
