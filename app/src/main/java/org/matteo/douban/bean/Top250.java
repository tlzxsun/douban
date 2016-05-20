package org.matteo.douban.bean;

import java.io.Serializable;

/**
 * Created by matteo on 2016/4/7.
 */
public class Top250  implements Serializable {

    private int start;
    private int count;
    private int total;
    private String title;
    private Subject[] subjects;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }
}
