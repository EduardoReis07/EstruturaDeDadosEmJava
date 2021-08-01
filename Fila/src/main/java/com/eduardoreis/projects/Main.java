package com.eduardoreis.projects;

public class Main {

    public static void main(String[] args) {

        Fila fila = new Fila();

        fila.enqueue("primeiro");
        fila.enqueue("segundo");
        fila.enqueue("terceiro");
        fila.enqueue("quarto");

        System.out.println(fila);

        System.out.println(fila.dequeue());

        fila.enqueue(new No("ultimo"));

        System.out.println(fila);

        System.out.println(fila.first());
    }
}
