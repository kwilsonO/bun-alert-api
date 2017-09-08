package bun.model;

public class Bun {

    private String bunName;

    private BunType bunType;

    private Address address;

    private double shopLatitude;

    private double shopLongitude;

    public Bun(String bunName, BunType bunType, double shopLatitude, double shopLongitude){
        this.bunName = bunName;
        this.bunType = bunType;
        this.shopLatitude = shopLatitude;
        this.shopLongitude = shopLongitude;
    }

    public Address getAddress() {
        return address;
    }

    public double getBunLatitude() {
        return shopLatitude;
    }

    public double getBunLongitude() {
        return shopLongitude;
    }

    public BunType getBunType() {
        return bunType;
    }

    public String getBunName() {
        return bunName;
    }
}

