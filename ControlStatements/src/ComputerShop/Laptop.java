package ComputerShop;

/**
 * Created by student on 26/08/2016.
 */
public class Laptop extends Computer {
    private String batteryType;
    private double weight;

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    Laptop(){

    }

    public Laptop(String model, String CPUtype, double CPUSpeed, int harddiskCap, String graphicCardType, String operatingSystem, double price, String batteryType, double weight){
        super(model,CPUtype, CPUSpeed, harddiskCap, graphicCardType, operatingSystem, price);
        this.batteryType = batteryType;
        this.weight = weight;


    }

    @Override
    public String toString(){

        return  String.format(" %s %s %s %s %s %s %s %s %s ", this.getModel(), this.getCPUtype(), this.getCPUSpeed(), this.getHarddiskCap(), this.getGraphicCardType(), this.getOperatingSystem(), this.getPrice(), this.batteryType, this.weight);

    }
}
