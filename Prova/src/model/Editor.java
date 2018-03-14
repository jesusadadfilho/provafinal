package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Editor extends Pessoa {
    private boolean chefe;
    private String genero;
    private Noticia principal;
    Date hoje = new Date();
    private List<Noticia> noticiasAprovadas = new ArrayList<>();

    public Editor(String genero,String nome, String email, String senha){
        this.genero = genero;
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
    }

    public List<Noticia> getNoticiasAprovadas() {
        return noticiasAprovadas;
    }

    public void setNoticiasAprovadas(List<Noticia> noticiasAprovadas) {
        this.noticiasAprovadas = noticiasAprovadas;
    }

    public void aprovaNoticia(Jornalista jornalista){
        for (Noticia noticia : jornalista.getNoticiaList()){
            if(this.genero.equals(noticia.getGenero())){
                noticia.setAprovada(true);
                noticia.addRegistro("Aprovada por :" + this.nome + "em " + hoje);
                noticia.setEstado("Aprovada");
                noticiasAprovadas.add(noticia);
            }
        }
    }

    public List<Noticia> destaques(){
        List<Noticia> destaques = new ArrayList<>();
        if(this.chefe){
            for(int i = 0; i < 5; i++){
               if(noticiasAprovadas.size() > 0){
                   destaques.add(noticiasAprovadas.get(noticiasAprovadas.size()-1-i));
               }
            }
            return destaques;
        }
        return null;
    }

    public boolean isChefe() {
        return chefe;
    }

    public void setChefe(boolean chefe) {
        this.chefe = chefe;
    }

    public Noticia setPrincipal(){
       return noticiasAprovadas.get(noticiasAprovadas.size()-1);
    }


}
