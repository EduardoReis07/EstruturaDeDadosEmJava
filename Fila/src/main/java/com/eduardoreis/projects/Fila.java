package com.eduardoreis.projects;

import java.util.Objects;

public class Fila<T> {

    private No<T> refNoEntradaFila;

    public Fila() {
        this.refNoEntradaFila = null;
    }

    public void enqueue(T object) {
        No novoNo = new No(object);
        novoNo.setReferenciaProximoNo(refNoEntradaFila);
        refNoEntradaFila = novoNo;
    }

    public T first() {
        if (!this.isEmpty()) {
            No primeiroNo = refNoEntradaFila;

            while (true) {
                if (Objects.nonNull(primeiroNo.getReferenciaProximoNo())) {
                    primeiroNo = primeiroNo.getReferenciaProximoNo();
                } else {
                    break;
                }
            }

            return (T) primeiroNo.getObject();
        }

        return null;
    }

    public T dequeue() {
        if (!this.isEmpty()) {
            No primeiroNo = refNoEntradaFila;
            No noAuxiliar = refNoEntradaFila;

            while (true) {
                if (Objects.nonNull(primeiroNo.getReferenciaProximoNo())) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getReferenciaProximoNo();
                } else {
                    noAuxiliar.setReferenciaProximoNo(null);
                    break;
                }
            }

            return (T) primeiroNo.getObject();
        }

        return null;
    }

    public boolean isEmpty() {
        return Objects.isNull(refNoEntradaFila) ? true : false;
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        No noAuxiliar = refNoEntradaFila;


        if (Objects.nonNull(refNoEntradaFila)) {

            while (true) {
                retorno.append("[No {objeto=" + noAuxiliar.getObject() + "}]-->");

                if (Objects.nonNull(noAuxiliar.getReferenciaProximoNo())) {
                    noAuxiliar = noAuxiliar.getReferenciaProximoNo();
                } else {
                    retorno.append("null");
                    break;
                }
            }

        } else {
            retorno.append("null");
        }

        return retorno.toString();
    }
}
