import java.util.Scanner;
public class Musica {

    public String titulo;
    public String artista;
    public String genero;
    private int duracaoSegundos;

    public Musica(String titulo, String artista, String genero, int duracaoSegundos){
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.duracaoSegundos = duracaoSegundos;
    }

    public String getDuracaoFormatada(){
        int min = duracaoSegundos / 60;
        int seg = duracaoSegundos % 60;
        return String.format("%02d:%02d", min, seg);
    }

}

