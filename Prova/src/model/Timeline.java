package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Timeline {
    Date hoje = new Date();
    private List<Noticia> noticiasPublicadas = new ArrayList<>();
    private List<Noticia> destaques = new ArrayList<>();
    private List<Noticia> esportes = new ArrayList<>();
    private List<Noticia> maisVistas = new ArrayList<>();
    private List<Noticia> entreterimento = new ArrayList<>();
    private List<Noticia> outros = new ArrayList<>();
    private Noticia principal;
    private Editor editorChefe;

    public Timeline(Editor editorChefe) {
        this.editorChefe = editorChefe;
    }

    public List<Noticia> getNoticiasPublicadas() {
        return noticiasPublicadas;
    }

    public void setNoticiasPublicadas(List<Noticia> noticiasPublicadas) {
        this.noticiasPublicadas = noticiasPublicadas;
    }

    public List<Noticia> getDestaques() {
        return destaques;
    }

    public List<Noticia> getEsportes() {
        return esportes;
    }

    public void setEsportes(List<Noticia> esportes) {
        this.esportes = esportes;
    }

    public List<Noticia> getEntreterimento() {
        return entreterimento;
    }

    public void setEntreterimento(List<Noticia> entreterimento) {
        this.entreterimento = entreterimento;
    }

    public List<Noticia> getOutros() {
        return outros;
    }

    public void setOutros(List<Noticia> outros) {
        this.outros = outros;
    }

    public Noticia getPrincipal() {
        return principal;
    }


    public Editor getEditorChefe() {
        return editorChefe;
    }

    public void setEditorChefe(Editor editorChefe) {
        this.editorChefe = editorChefe;
        editorChefe.setChefe(true);
    }

    public List<Noticia> getMaisVistas() {
        Collections.sort(noticiasPublicadas);
        for(int i = 0; i < noticiasPublicadas.size()-1; i++){
            if(maisVistas.size() < 5){
                maisVistas.add(noticiasPublicadas.get(i));
            }
        }
        return maisVistas;
    }

    public void publicaNotica(Editor editor){
        for(Noticia noticia : editor.getNoticiasAprovadas()){
            noticia.addRegistro("Publicada por :" + editor.getNome() + " em " + hoje);
            noticia.setEstado("Publicada");
            if(noticia.getGenero().equals("esporte")){
                esportes.add(noticia);
            }else if(noticia.getGenero().equals("entreterimento")){
                entreterimento.add(noticia);
            }else{
                outros.add(noticia);
            }
            noticiasPublicadas.add(noticia);
        }
    }

    public void setDestaques(){
        for(Noticia noticia : noticiasPublicadas){
            if(destaques.size() < 5){
                destaques.add(noticia);
            }
        }
    }

    public void setPrincipal(Editor editor, Noticia noticia){
        if (editorChefe.equals(editor)){
            this.principal = noticia;
        }
    }

    public void excluiNoticia(Noticia noticia){
        editorChefe.getNoticiasAprovadas().remove(noticia);
        noticiasPublicadas.remove(noticia);
        if(noticia.getGenero().equals("esporte")){
            esportes.remove(noticia);
        }else if(noticia.getGenero().equals("entreterimento")){
            entreterimento.remove(noticia);
        }else{
            outros.remove(noticia);
        }
        noticia.setEstado("desativada");
        noticia.addRegistro("Desativada por :" + editorChefe.getNome() + "em " + hoje);

    }


}
