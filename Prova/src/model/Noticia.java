package model;


import java.util.ArrayList;
import java.util.List;

public class Noticia implements Comparable<Noticia> {
	private String autor;
    private String corpo;
    private String titulo;
    private String resumo;
    private String genero;
    private boolean aprovada;
    private String estado;
    private String cor;
    private int visualizacao;
    private List<String> registro = new ArrayList<>();
    private List<Noticia> relacionadas = new ArrayList<>();


    public Noticia(String corpo, String titulo, String resumo, String genero) {
        this.corpo = corpo;
        this.titulo = titulo;
        this.resumo = resumo;

        this.genero = genero;
    }


    @Override
    public int compareTo(Noticia o) {
        if(this.getVisualizacao() > o.getVisualizacao()){
            return -1;
        }else if(o.getVisualizacao() > this.getVisualizacao()){
            return 1;
        }else {
            return 0;
        }
    }

    public List<String> getRegistro() {
        return registro;
    }

    public void setRegistro(List<String> registro) {
        this.registro = registro;
    }

    public int getVisualizacao() {
        return visualizacao;
    }

    public void addRegistro(String reg){
        registro.add(reg);
    }
    public void addRelacionadas(Editor editor){
        for(Noticia noticia : editor.destaques()){
            if(relacionadas.size() <= 10){
                if(noticia.getGenero().equals(this.genero)){
                    relacionadas.add(noticia);
                }
            }
        }
    }

    public void vizualizar(){
        this.visualizacao++;
    }

    public void setVisualizacao(int visualizacao) {
        this.visualizacao = visualizacao;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }

    public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
}
