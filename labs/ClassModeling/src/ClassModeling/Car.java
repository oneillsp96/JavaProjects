package ClassModeling;

public class Car {

    private String carMake;
    private String carModel;
    private int horsePower;

    private String p;

    public String soundMadeAt(String input) {

        if (input.equals("low")) {

            p = "Purr";

        }

        return p;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

}
