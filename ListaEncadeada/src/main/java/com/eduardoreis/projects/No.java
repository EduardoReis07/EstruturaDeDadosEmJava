package com.eduardoreis.projects;

import java.util.Objects;

public class No<T> {

    private T conteudo;
    private No proximoNo;

    public No() {
        this.proximoNo = null;
    }

    public No(T conteudo) {
        this.conteudo = conteudo;
        this.proximoNo = null;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(No proximoNo) {
        this.proximoNo = proximoNo;
    }

    @Override
    public String toString() {
        return "No{" +
                "conteudo=" + conteudo +
                '}';
    }

    public String toStringEncadeado() {
        StringBuilder str = new StringBuilder("No{" +
                "conteudo=" + conteudo +
                '}');

        if (Objects.nonNull(proximoNo)) {
            str.append(" -> " + proximoNo.toString());
        } else {
            str.append(" -> null");
        }

        return str.toString();
    }

}
