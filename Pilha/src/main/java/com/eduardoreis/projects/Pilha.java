package com.eduardoreis.projects;

import java.util.Objects;

public class Pilha {

    private No refNoEntradaPilha;

    public Pilha() {
        this.refNoEntradaPilha = null;
    }

    public No top(){
        return refNoEntradaPilha;
    }

    public void push(No novoNo){
        No refAuxiliar = refNoEntradaPilha;
        refNoEntradaPilha = novoNo;
        refNoEntradaPilha.setReferenciaNo(refAuxiliar);
    }

    public No pop(){
        if(!this.isEmpty()){
            No noPoped = refNoEntradaPilha;
            refNoEntradaPilha = refNoEntradaPilha.getReferenciaNo();

            return noPoped;
        }

        return null;
    }

    public boolean isEmpty(){
        return Objects.isNull(refNoEntradaPilha) ? true : false;
    }

    @Override
    public String toString() {

        StringBuilder retorno = new StringBuilder();

        retorno.append("-------------------------\n");
        retorno.append("    Pilha:\n");
        retorno.append("-------------------------\n");


        No noAuxiliar = refNoEntradaPilha;

        while(true){
            if(Objects.nonNull(noAuxiliar)){
                retorno.append("[No { dado="+ noAuxiliar.getDado() + " }]\n");
                noAuxiliar = noAuxiliar.getReferenciaNo();
            }else{
                break;
            }
        }

        retorno.append("=========================\n");

        return retorno.toString();
    }
}
