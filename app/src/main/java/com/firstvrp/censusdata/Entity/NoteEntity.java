package com.firstvrp.censusdata.Entity;

/**
 * Created by chenyuan on 16/6/13.
 */
public class NoteEntity {
    private int id;
    private String index_explanation;
    private int index_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndex_explanation() {
        return index_explanation;
    }

    public void setIndex_explanation(String index_explanation) {
        this.index_explanation = index_explanation;
    }

    public int getIndex_id() {
        return index_id;
    }

    public void setIndex_id(int index_id) {
        this.index_id = index_id;
    }

    @Override
    public String toString() {
        return "NoteEntity{" +
                "id=" + id +
                ", index_explanation='" + index_explanation + '\'' +
                ", index_id=" + index_id +
                '}';
    }
}
