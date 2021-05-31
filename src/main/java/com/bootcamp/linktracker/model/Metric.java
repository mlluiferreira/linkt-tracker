package com.bootcamp.linktracker.model;

public class Metric {
    private Integer counter;

    public Metric() {
        counter = 0;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public void addOne() {
        counter++;
    }
}
