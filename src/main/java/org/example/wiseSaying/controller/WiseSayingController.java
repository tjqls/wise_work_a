package org.example.wiseSaying.controller;

import org.example.Container;
import org.example.Rq;
import org.example.wiseSaying.entity.WiseSaying;


import java.util.ArrayList;

public class WiseSayingController {  //WiseSayingController 클래스 선언

    private int count = 0; // int형 변수 count 초기화

    private ArrayList<WiseSaying> wiseSayings = new ArrayList<>(); // <WiseSaying>이라는 타입을 받는 wisesayings라는 리스트를 생성


    private WiseSaying findById(int id){
        for(WiseSaying wiseSaying : wiseSayings){  // 향산된 for문 wiseSayings 문자 wiseSaying 변수로 반복시킨다.
            if(wiseSaying.getId()== id){  // wiseSaying은 위에서 선언된 list 각 Id값이    WiseSaying wiseSaying = new WiseSaying(id, content, author);
                return wiseSaying;
            }
        }
        return null;
    }
    public void write() { // WiseSayingController클래스의 write함수 선언
        System.out.println("명언을 등록해주세요."); // 출력 - 명언을 등록해주세요
        String content = Container.getScanner().nextLine().trim(); //문자 content는 컨테이너 클래스의 스캐너안의 sc를 문자열로 받겠다. 공백제거하고
        System.out.println("작가를 입력해주세요."); // 출력 - 작가를 입력해주세요.
        String author = Container.getScanner().nextLine().trim(); // 문자 author은 컨테이너 클래스의 스캐너안의 sc를 문자열로 받겠다. 공백제거하고

        int id = count + 1; // int형 id 는 count +1
        WiseSaying wiseSaying = new WiseSaying(id, content, author); // WiseSaying 설계도

        wiseSayings.add(wiseSaying);

        System.out.println(count + "번 명언을 등록했습니다.");
        count = id;
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30));


        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getContent() + " / " + wiseSaying.getAuthor());
        }
        System.out.println("총 등록 갯수:" + wiseSayings.size());
    }

    public void remove(Rq rq) {
        int id = rq.getIntParam("id",-1);

        if(id == -1){
            System.out.println("정수를 입력하세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id);

        if(wiseSaying == null){
            System.out.println("삭제될 명언이 없습니다.");
        }



        // id값으로 저장된 데이터를 가져온다.
        //저장된 데이터로 전체데이터에서 삭제하는 매서드를 이요해서 삭제한다.
        wiseSayings.remove(wiseSaying);


        //멘트를 출력한다.
        System.out.printf("id번 명언이 삭제 되었습니다.\n", id);

    }



    public void modify(Rq rq) {
        int id = rq.getIntParam("id",-1);

        if(id == -1){
            System.out.println("정수를 입력하세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id);

        if(wiseSaying == null){
            System.out.println("수정할 명언이 없습니다.");
            return;
        }

        System.out.printf("기존 명언 $s",wiseSaying.getContent());
        System.out.printf("수정할 명언)");
        String content = Container.getScanner().nextLine().trim();

        System.out.printf("기존 작가 $s",wiseSaying.getContent());
        System.out.printf("수정할 작가)");
        String author = Container.getScanner().nextLine().trim();

        wiseSaying.setContent(content);
        wiseSaying.setContent(author);


        System.out.printf("id번 명언이 수정 되었습니다.\n", id);
    }
}
