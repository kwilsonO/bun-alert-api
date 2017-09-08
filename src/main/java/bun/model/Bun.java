package bun.model;

public class Bun {

    private String bunName;

    private BunType bunType;

    //private Address address;

    private double bunLatitude;

    private double bunLongitude;

    public Bun(){

    }

    public Bun(String bunName, BunType bunType, double bunLatitude, double bunLongitude){
        this.bunName = bunName;
        this.bunType = bunType;
        this.bunLatitude = bunLatitude;
        this.bunLongitude = bunLongitude;
    }

    /*public Address getAddress() {
        return address;
    }*/

    public void setBunLatitude(double bunLatitude){
        this.bunLatitude = bunLatitude;
    }

    public void setBunLongitude(double bunLongitude){
        this.bunLongitude = bunLongitude;
    }

    public void setBunName(String bunName){
        this.bunName = bunName;
    }

    public void setBunType(BunType bunType){
        this.bunType = bunType;
    }

    public double getBunLatitude() {
        return bunLatitude;
    }

    public double getBunLongitude() {
        return bunLongitude;
    }

    public BunType getBunType() {
        return bunType;
    }

    public String getBunName() {
        return bunName;
    }
}

