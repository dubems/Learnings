package com.nriagudubem.learnings.hasMap;

public class CustomKey {

    private Integer key;

    public CustomKey(Integer key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
