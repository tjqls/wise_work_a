package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Container.init();     //컨테이너 클래스에서 init 함수에서 스캐너를 선언해놨기 때문에 main에서 스캐너를 사용할수 있게 함

        new App().run();      // App클래스에서 run()함수를 실행한다.

        Container.close();    //컨테이너 클래스에서 close 함수에 스캐너 sc를 종료하는 로직을 실행하게함
    }
}