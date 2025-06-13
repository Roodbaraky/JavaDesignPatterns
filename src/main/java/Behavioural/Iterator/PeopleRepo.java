/*
 * (c) Midland Software Limited 2025
 * Name     : PeopleRepo.java
 * Author   : RoodbarakyK
 * Date     : 13 Jun 2025
 */
package Behavioural.Iterator;

import java.util.Iterator;

public class PeopleRepo implements Iterable<String> {
    private String[] names;
    private int index;

    public PeopleRepo() {
        this.names = new String[10];
        this.index = 0;
    }

    public void addName(String name) {
        if (index == names.length) {
            String[] newNames = new String[names.length * 2];
            System.arraycopy(names, 0, newNames, 0, names.length);
            names = newNames;
        }
        names[index] = name;
        index++;
    }

    @Override
    public Iterator<String> iterator() {
        Iterator<String> it = new Iterator<String>() {

            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < names.length && names[i] != null;
            }

            @Override
            public String next() {
                return names[i++];
            }
        };
        return it;
    }
}
