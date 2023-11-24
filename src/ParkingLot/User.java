package ParkingLot;

public class User {
    private String userId;
    private String userName;
    private String drivingLicense;

    public User(String userId, String userName, String drivingLicense) {
        this.userId = userId;
        this.userName = userName;
        this.drivingLicense = drivingLicense;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }
}
