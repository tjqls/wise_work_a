package org.example.wiseSaying.entity;  // DB관련한 것  / 데이터를 저장하는 장소

public class WiseSaying {
    private long id;
    private String content;
    private String author;
    public WiseSaying(long id, String content, String author){
        this.id=id;
        this.content=content;
        this.author=author;
    }

    public long getId(){
        return this.id;
    }
    public String getContent(){
        return this.content;
    }
    public String getAuthor(){
        return this.author;
    }
}
