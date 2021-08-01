package com.eduardoreis.projects;

public class No<T> {

    private T object;
    private No referenciaProximoNo;

    public No(T object) {
        this.object = object;
        this.referenciaProximoNo = null;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public No getReferenciaProximoNo() {
        return referenciaProximoNo;
    }

    public void setReferenciaProximoNo(No referenciaProximoNo) {
        this.referenciaProximoNo = referenciaProximoNo;
    }

    @Override
    public String toString() {
        return "No{" +
                "object=" + object +
                '}';
    }
}
