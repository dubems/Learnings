package com.nriagudubem.learnings.hashMap

import com.nriagudubem.learnings.hasMap.CustomKey
import com.nriagudubem.learnings.hasMap.MyHashMap
import spock.lang.Specification

class SolutionSpec extends Specification {

    def "when there is no collision"() {
        given:
        MyHashMap<Integer, String> map = new MyHashMap<>();

        when:
        Integer name = 20;
        String value = "Gilbert";
        map.put(name, value)

        then:
        String expectedValue = map.get(name)
        assert expectedValue.equals(value)
    }

    def "test map returns null when values does not exist"() {
        given:
        MyHashMap<Integer, String> map = new MyHashMap<>();

        when:
        Integer name = 20;
        String value = "Gilbert";
        map.put(name, value)

        then:
        String nonExistent = map.get(25);
        assert nonExistent == null
    }

    def "test map gets an illegalArgumentException when a null value is passed"() {
        given:
        MyHashMap<Integer, String> map = new MyHashMap<>();

        when:
        Integer name = null;
        String value = "Gilbert";
        map.put(name, value)

        then:
        thrown(IllegalArgumentException)
    }

    def "when collision occurs"() {
        given:
        MyHashMap<CustomKey, String> map = new MyHashMap<>();

        when:
        CustomKey key1 = new CustomKey(5)
        String value1 = 'Gilbert'
        map.put(key1, value1)
        map.put(key1, value1)

        and:
        CustomKey key2 = new CustomKey(10)
        String value2 = 'Gilbertee'
        map.put(key2, value2)

        then:
        String expectedValue1 = map.get(key1)
        assert expectedValue1.equals(value1)

        String expectedValue2 = map.get(key2)
        assert expectedValue2.equals(value2)
    }
}
