package ComputerShop;

/**
 * Created by student on 26/08/2016.
 */
public abstract class Computer {

    private String CPUtype;
    private double CPUSpeed;
    private int harddiskCap;
    private String graphicCardType;
    private String model;
    private String operatingSystem;
    private double price;

    public String getCPUtype() {
        return CPUtype;
    }

    public void setCPUtype(String CPUtype) {
        this.CPUtype = CPUtype;
    }

    public double getCPUSpeed() {
        return CPUSpeed;
    }

    public void setCPUSpeed(double CPUSpeed) {
        this.CPUSpeed = CPUSpeed;
    }

    public int getHarddiskCap() {
        return harddiskCap;
    }

    public void setHarddiskCap(int harddiskCap) {
        this.harddiskCap = harddiskCap;
    }

    public String getGraphicCardType() {
        return graphicCardType;
    }

    public void setGraphicCardType(String graphicCardType) {
        this.graphicCardType = graphicCardType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    Computer(){}

    public Computer(String model, String CPUtype, double CPUSpeed, int harddiskCap, String graphicCardType, String operatingSystem, double price){
        this.model = model;
        this.CPUtype = CPUtype;
        this.CPUSpeed = CPUSpeed;
        this.harddiskCap = harddiskCap;
        this.graphicCardType = graphicCardType;
        this.operatingSystem = operatingSystem;
        this.price = price;
    }
}
