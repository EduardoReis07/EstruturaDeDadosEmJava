package com.eduardoreis.projects;

import java.util.Objects;

public class ListaEncadeada<T> {

    private No<T> referenciaEntrada;

    public ListaEncadeada() {
        this.referenciaEntrada = null;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);

        if(this.isEmpty()){
            referenciaEntrada = novoNo;
            return;
        }

        No<T> noAuxiliar = referenciaEntrada;
        for(int i=0; i < this.size()-1; i++){
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        noAuxiliar.setProximoNo(novoNo);
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    private No<T> getNo(int index){
        validaIndice(index);

        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;

        for(int i=0; i <= index; i++){
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return noRetorno;
    }

    public T remove(int index){
        No<T> noPivor = this.getNo(index);

        if(index == 0){
            referenciaEntrada = noPivor.getProximoNo();
            return noPivor.getConteudo();
        }

        No<T> noAnterior = getNo(index - 1);
        noAnterior.setProximoNo(noPivor.getProximoNo());

        return noPivor.getConteudo();
    }

    private void validaIndice(int index) {
        if(index >= size()){
            int ultimoIndice = size() - 1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + index + " desta lista." +
            " Esta lista possui somente " + ultimoIndice + " elementos.");
        }
    }

    public int size() {
        int tamanhoLista = 0;

        No<T> referenciaAux = referenciaEntrada;

        while(true){
            if(Objects.nonNull(referenciaAux)) {
                tamanhoLista++;

                if(Objects.nonNull(referenciaAux.getProximoNo())){
                    referenciaAux = referenciaAux.getProximoNo();

                } else {
                    break;
                }
            } else {
                break;
            }
        }

        return tamanhoLista;
    }

    public boolean isEmpty() {
        return Objects.isNull(this.referenciaEntrada);
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        No<T> noAuxiliar = referenciaEntrada;

        for(int i=0; i < this.size(); i++){
            retorno.append("[No{conteudo=").append(noAuxiliar.getConteudo()).append("}]-->");
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        retorno.append("null");
        return retorno.toString();
    }
}
