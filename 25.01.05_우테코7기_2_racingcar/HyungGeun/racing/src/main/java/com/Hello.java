package com;

import java.util.Scanner;


//이름은 5자 이하만 가능하다.

//사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

public class Hello {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String participants = scanner.nextLine();

            String[] participantsArr = participants.split(",");

            for (int i = 0; i < participantsArr.length; i++) {
                if (participantsArr[i].length() > 5) {
                    throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
                }
            }

            String[] countArr = new String[participantsArr.length];

            int count =0 ;
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                count = scanner.nextInt();
            }catch (Exception e){
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }


            for(int i=0; i<countArr.length; i++){
                countArr[i] = "";
            }

            System.out.println("실행 결과");
            for (int i = 1; i <= count; i++) {

                for (int j = 0; j < participantsArr.length; j++) {

                    if ((int) (Math.random() * 10) >= 4) {
                        countArr[j] += "-";
                    }
                    System.out.println(participantsArr[j] + " : " + countArr[j]);
                }

            }

            int max = -1;
            String winner = "";




            for (int i = 0; i < participantsArr.length; i++) {
                if (countArr[i].length() > max) {
                    max = countArr[i].length();
                }
                ;
            }

            for (int i = 0; i < participantsArr.length; i++) {

                if (countArr[i].length() == max && winner.equals("")) {
                    winner += participantsArr[i];
                } else if (countArr[i].length() == max && !winner.equals("")) {
                    winner += ", " + participantsArr[i];
                }

            }

            System.out.println("최종 우승자는 " + winner + "입니다.");
        }




}
