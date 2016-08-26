package ComputerShop;


import sun.security.krb5.internal.crypto.Des;

/**
 * Created by student on 26/08/2016.
 */
public class Desktop extends Computer{

    private String monitor;
    private String keyboard;
    private String speakers;

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getSpeakers() {
        return speakers;
    }

    public void setSpeakers(String speakers) {
        this.speakers = speakers;
    }

    Desktop(){}

    public Desktop(String model, String CPUtype, double CPUSpeed, int harddiskCap, String graphicCardType, String operatingSystem, double price, String monitor, String keyboard, String speakers){
        super(model,CPUtype, CPUSpeed, harddiskCap, graphicCardType, operatingSystem, price);
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.speakers = speakers;
    }

    @Override
    public String toString(){

        return  String.format(" %s %s %s %s %s %s %s %s %s %s", this.getModel(), this.getCPUtype(), this.getCPUSpeed(), this.getHarddiskCap(), this.getGraphicCardType(), this.getOperatingSystem(), this.getPrice(), this.monitor, this.keyboard, this.speakers);

    }



}
