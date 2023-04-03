package org.example;

import org.example.System.Controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;


public class App {

    public void run() {
        System.out.println("== 명언 앱 =="); //실행시 명언 앱 출력

        SystemController systemController = new SystemController(); // SystemController 클래스 사용 선언
        WiseSayingController wiseSayingController = new WiseSayingController(); // WiseSayingController 클래스 사용 선언

        while (true) { // 반복문이 true일때
            String command = Container.getScanner().nextLine().trim();  // 문자 command는 컨테이너 클래스에서 스캐너 함수 안에 sc에 문자를 입력받는다.

            Rq rq = new Rq(command);

            switch (rq.getActionCode()){
                case "종료":
                    systemController.exit();              // 시스템 컨트롤러 안에있는 exit함수 로직 실행 (명언앱을 종료합니다. 출력됨)
                    return;
                case "등록":
                    wiseSayingController.write();         // wiseSayingController클래스 안에 있는 write 함수 실행
                    break;
                case "목록":
                    wiseSayingController.list();          // wiseSayingController클래스 안에 있는 list 함수 실행
                    break;
                case "삭제":
                    wiseSayingController.remove(rq);
                    break;
                case "수정":
                    wiseSayingController.modify(rq);
                    break;
            }




        }
    }
}

