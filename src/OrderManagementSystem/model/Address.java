package OrderManagementSystem.model;

public class Address {
    private final String address;
    private final String pincode;
    private final String city;
    private final String state;

    public Address(String address, String pincode, String city, String state) {
        this.address = address;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public String getPincode() {
        return pincode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
