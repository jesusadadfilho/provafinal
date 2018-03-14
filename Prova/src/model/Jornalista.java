package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Jornalista extends Pessoa {
    private List<Noticia> noticiaList = new ArrayList<>();
    Date hoje = new Date();

    public List<Noticia> getNoticiaList() {
        return noticiaList;
    }

    public void setNoticiaList(List<Noticia> noticiaList) {
        this.noticiaList = noticiaList;
    }

    public Jornalista(String nome, String email, String senha) {
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);

    }

    public void novaNoticia(String corpo, String resumo, String titulo, String genero){
        if(resumo.length() > 140){
            throw new TamanhoException();
        }
        Noticia nova = new Noticia(corpo,titulo,resumo,genero);
        nova.setAutor(this.getNome());
        if(genero == "esporte"){
            nova.setCor("verde");
        }else if(genero == "entreterimento"){
            nova.setCor("laranga");
        }else{
            nova.setCor("vermelha");
        }
        nova.addRegistro("Criada por :" + this.nome + " em " + hoje);
        nova.setEstado("Criada");
        nova.addRegistro("Pronta para revisão por :" + this.nome + " em " + hoje);
        nova.setEstado("Pronta para revisão");
        noticiaList.add(nova);
    }

}
