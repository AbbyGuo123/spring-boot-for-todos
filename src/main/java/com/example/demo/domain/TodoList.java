package com.example.demo.domain;

import java.util.UUID;

public class TodoList {

    private String id;

    private String title;

    private Boolean finished;

    public TodoList() {
    }

    public TodoList(String title, Boolean finished) {
        this.id=UUID.randomUUID().toString();
        this.title = title;
        this.finished = finished;
    }

    public TodoList(String id, String title, Boolean finished) {
        this.id = id;
        this.title = title;
        this.finished = finished;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }
}
