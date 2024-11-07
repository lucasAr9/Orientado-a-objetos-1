package com.example;

import java.util.HashSet;

public class EvenNumberSet<E> extends HashSet<Integer> {

    @Override
    public boolean add(Integer e) {
        if (e != null && e % 2 == 0) {
            return super.add(e);
        }
        return false;
    }
}
