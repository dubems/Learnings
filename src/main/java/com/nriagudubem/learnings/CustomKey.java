package com.nriagudubem.learnings;

public class CustomKey {

    private Integer key;

    CustomKey(Integer key){
        this.key = key;
    }

    @Override
    public int hashCode(){
        return 1;
    }
}
