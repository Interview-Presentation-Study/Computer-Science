package racingcar.model;

public class Car {
    String name;
    StringBuilder distance;
    public Car(String name){
        this.name = name;
        this.distance = new StringBuilder();
    }

    void presentDistance(){
        System.out.println(name + " : " + distance);
    }

    void move(){
        distance.append("-");
    }

}
