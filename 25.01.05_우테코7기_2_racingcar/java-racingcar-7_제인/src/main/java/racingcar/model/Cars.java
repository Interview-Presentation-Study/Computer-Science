package racingcar.model;

import racingcar.service.RandomNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
   private final List<Car> cars = new ArrayList<>();

   public Cars(String[] carNames){
       for(String name : carNames){
           cars.add(new Car(name));
       }
   }

   public void play(int count){
       for(int i = 0; i < count; i++){
           for(Car car : cars){
               if(RandomNumber.getRandomNumber()>=4)
                   car.move();
               car.presentDistance();
           }
           System.out.println();
       }
   }

   public String winners(){
        Collections.sort(cars, (o1, o2) -> o2.distance.length() - o1.distance.length());
        int maxDistance = cars.get(0).distance.length();
        StringBuilder sb = new StringBuilder(cars.get(0).name);
        for(int i=1;i<cars.size();i++){
            if(maxDistance==cars.get(i).distance.length())
                sb.append(",").append(cars.get(i).name);
        }
        return sb.toString();
   }
}
