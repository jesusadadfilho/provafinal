package model;

public class Usuario extends Pessoa{
    public Usuario(String nome, String email, String senha ) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public void visualizandoNoticia(Noticia noticia){
        noticia.vizualizar();

    }
}
