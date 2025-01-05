package racingcar;
public class Car {
    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location=0;
    }
    public void move(){
        this.location++;
    }
    public String getName(){
        return name;
    }
    public int getLocation(){
        return location;
    }
    public void setLocation(int location){
        this.location=location;
    }
}
