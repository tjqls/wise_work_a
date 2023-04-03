package org.example;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String actionCode;                                           // actionCode를 문자로 선언
    private Map<String,String> params;                                  // params를 HashMap으로 선언

    public Rq(String command){
        String[] commandBits = command.split("\\?", 2);      // 문자열 commandBits는 command에 입력 받은 것을 ?를 기준으로 두개로 나눈다.



        this.actionCode = commandBits[0];                                 // 문자 actionCode는 commandBits의 인덱스 0번이다.

        if(commandBits.length == 1) return;
        params = new HashMap<>();                // HashMap params 선언 문자열과 문자열로 받을것.
        String[] paramsBits = commandBits[1].split("&");            // 문자열 paramsBits는 commandBits 인덱스 1번을 &를 기준으로 나눈다.


        for(String paramStr : paramsBits){                                 //향산된 for문 paramsBits를 문자 paramStr 변수로 반복시킨다.
            String[] paramsStrBits = paramStr.split("=",2);   // 변수 parStr에 있는 문자열에 =을 기준으로 두개로 나눈다.

            if(paramsStrBits.length == 1) continue;


            String key = paramsStrBits[0];                                // key 값 = paramsStrBits 인덱스 0번
            String value = paramsStrBits[1];                              // value값 = paramsStrBits 인덱스 1번
            params.put(key,value);                                        // HashMap params에 키값 밸류 값 넣는다.
        }
    }


    public String getActionCode() {
        return this.actionCode;
    }

    public String getParams(String name) {
            return params.get(name);

    }

    public int getIntParam(String name, int defaultValue){

        try{
            return Integer.parseInt(getParams(name));
        }catch (NumberFormatException e){
            System.out.println("숫자가 아닌 값이 들어와서 에러가 발생하고있습니다.");
        }
        return defaultValue;
    }
}

