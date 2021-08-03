package com.eduardoreis.projects;

import java.util.Objects;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamanhoLista;

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    public void add(T elemento) {
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setProximoNo(null);
        novoNo.setNoAnterior(ultimoNo);

        if (Objects.isNull(primeiroNo)) {
            primeiroNo = novoNo;
        }

        if (Objects.nonNull(ultimoNo)) {
            ultimoNo.setProximoNo(novoNo);
        }

        ultimoNo = novoNo;
        tamanhoLista++;
    }

    public void add(int index, T elemento) {
        NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setProximoNo(noAuxiliar);

        if (Objects.nonNull(novoNo.getProximoNo())) {
            novoNo.setNoAnterior(noAuxiliar.getNoAnterior());
            novoNo.getProximoNo().setNoAnterior(novoNo);
        } else {
            novoNo.setNoAnterior(ultimoNo);
            ultimoNo = novoNo;
        }

        if (index == 0) {
            primeiroNo = novoNo;
        } else {
            novoNo.getNoAnterior().setProximoNo(novoNo);
        }

        tamanhoLista++;
    }

    public void remove(int index) {
        if (index == 0) {
            primeiroNo = primeiroNo.getProximoNo();

            if (Objects.nonNull(primeiroNo)) {
                primeiroNo.setNoAnterior(null);
            }

        } else {
            NoDuplo<T> noAuxiliar = getNo(index);
            noAuxiliar.getNoAnterior().setProximoNo(noAuxiliar.getProximoNo());

            if (noAuxiliar != ultimoNo) {
                noAuxiliar.getProximoNo().setNoAnterior(noAuxiliar.getNoAnterior());
            } else {
                ultimoNo = noAuxiliar;
            }
        }

        this.tamanhoLista--;
    }

    private NoDuplo<T> getNo(int index) {
        NoDuplo<T> noAuxiliar = primeiroNo;

        for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return noAuxiliar;
    }

    public int size() {
        return this.tamanhoLista;
    }

    @Override
    public String toString() {
        String retorno = "";

        NoDuplo<T> noAuxiliar = primeiroNo;

        for(int i=0; i < this.size(); i++){
            retorno += "[No { conteudo = " + noAuxiliar.getConteudo() + " }] --> ";
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        retorno += "null";
        return retorno;
    }
}
