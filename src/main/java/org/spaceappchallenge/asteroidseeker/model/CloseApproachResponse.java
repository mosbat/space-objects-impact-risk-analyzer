package org.spaceappchallenge.asteroidseeker.model;

import java.util.List;

public class CloseApproachResponse {
    private int count;
    private List<String> fields;
    private List<String[]> data;

    public CloseApproachResponse() {
    }

    public CloseApproachResponse(int count, List<String> fields, List<String[]> data) {
        this.count = count;
        this.fields = fields;
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public List<String[]> getData() {
        return data;
    }

    public void setData(List<String[]> data) {
        this.data = data;
    }
}
