package com.eduardoreis.projects;

public class Main {
    public static void main(String[] args) {

        Pilha pilha = new Pilha();

        pilha.push(new No(1));
        pilha.push(new No(2));
        pilha.push(new No(3));
        pilha.push(new No(4));
        pilha.push(new No(5));

        System.out.println(pilha);

        System.out.println(pilha.top());

        pilha.pop();

        System.out.println(pilha);
    }
}
