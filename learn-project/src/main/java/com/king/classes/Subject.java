package com.king.classes;

/**
 * Subject with scores
 * @author kingdomdong
 * @since 2020-06-14 16:28:56
 * @version 1.1
 */
public class Subject {

    public Integer math;
    public Integer physics;
    public Integer chemistry;
    public Integer history;
    public Integer economics;
    public Integer biology;

    public Subject(int m, int p, int c, int h, int e, int b) {
        math = m;
        physics = p;
        chemistry = c;
        history = h;
        economics = e;
        biology = b;
    }

}
