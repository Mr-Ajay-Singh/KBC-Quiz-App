package com.Cyris.kbc2020.topscore;

public class FirebaseVariable {

    public FirebaseVariable()
    {}

    public TopEntity getEntity() {
        return entity;
    }

    public void setEntity(TopEntity entity) {
        this.entity = entity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    TopEntity entity;
    String date;
}
