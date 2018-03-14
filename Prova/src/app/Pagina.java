package app;

import model.*;

public class Pagina {
    public static void main(String[] args) {
        Editor editor = new Editor("outros","jesus","jesus@yahoo.com","123");
        Jornalista jornalista = new Jornalista("jose","jose@gmail.com","123");
        try{
            jornalista.novaNoticia("tephen William Hawking, físico e pesquisador britânico, morreu aos 76 anos nesta quarta-feira (14) em sua casa na Inglaterra. " +
                            "Hawking se tornou um dos cientistas mais conhecidos do mundo ao abordar temas como a natureza da gravidade e a origem do universo. " +
                            "Também foi um exemplo de determinação por resistir muitos anos à esclerose lateral amiotrófica, uma doença degenerativa",
                    "Além de ser um dos cientistas mais conhecidos no mundo.",
                    "Stephen Hawking, físico britânico, morre ",
                    "outros");
        }catch (TamanhoException e){
            System.out.println(e.getMessage());
        }
        editor.aprovaNoticia(jornalista);
        Timeline timeline = new Timeline(editor);
        timeline.publicaNotica(editor);
        for(Noticia noticia : timeline.getNoticiasPublicadas()){
            System.out.println(noticia.getRegistro());
        }
    }
}
