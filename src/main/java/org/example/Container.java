package org.example;

import java.util.Scanner;

public class Container { // Container클래스 선언
    private static Scanner sc;  // Scanner 타입 sc 선언

    public static void init(){ //Container클래스 안에 init 함수 선언
        sc = new Scanner(System.in); // sc는 입력을 받는 스캐너 선언
    }

    public static void close(){  // Container클래스 안에 close 함수 선언
        sc.close(); // 스캐너 sc 종료
    }
    public static Scanner getScanner(){ //스캐너 타입을 스태틱으로 선언
        return sc;  //sc를 반환하는것
    }
}


