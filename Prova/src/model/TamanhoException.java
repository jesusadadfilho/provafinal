package model;

public class TamanhoException extends RuntimeException {
    public TamanhoException(){
        super("Tamanho do resumo mior que o aceitavel!!");
    }
}
