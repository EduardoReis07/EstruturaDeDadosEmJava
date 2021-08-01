package com.eduardoreis.projects;

public class Main {

    public static void main(String[] args) {

        ListaEncadeada<Integer> list = new ListaEncadeada<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list.get(0));

        System.out.println("A lista possui " + list.size() + " elementos.");

        System.out.println(list.remove(3));

        System.out.println(list);
    }
}
