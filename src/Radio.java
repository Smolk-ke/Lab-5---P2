public class Radio{
    private Estacao[] estacoes;
    private int estacaoAtual = 0;
    private int musicaAtual = 0;
    private int volume = 50;
    private boolean ligado = false;
    private boolean tocando = false;

    public Radio(Estacao[] estacoes){
        this.estacoes = estacoes;
    }

    public void ligar(){
        if (ligado == false){
            ligado = true;
        }else{
            System.out.println("O rádio já está ligado.");
        }
    }

    public void desligar(){
        if(ligado == true){
            tocando = false;
            ligado = false;
        }else{
            System.out.println("O rádio já está desligado.");
        }
    }

    public void tocar(){
        if(ligado == false){
            System.out.println("É necessário ligar o rádio.");
        }else{
            tocando = true;
            Musica musica = estacoes[estacaoAtual].playlist[musicaAtual];
            System.out.println("Título: " + musica.titulo);
            System.out.println("Artista: " + musica.artista);
            System.out.println("Título: " + musica.getDuracaoFormatada());
        }
    }

    public void pausar(){
        if(ligado == false || tocando == false){
            System.out.println("Já desligado ou pausado.");
        }else{
            tocando = false;
            System.out.println("Rádio pausado!");
        }
    }

    public void aumentarVolume(int incremento){
        if (incremento >= 0){
            volume = Math.min(100, volume + incremento);
        }else{
            System.out.println("Não é possível realizar incrementos negativos.");
        }
    }

    public void diminuirVolume(int incremento){
        if (incremento >= 0){
            volume = Math.max(0, volume - incremento);
        }else{
            System.out.println("Erro ao diminuir volume.");
        }
    }

    public void trocarEstacao(int numeroEstacao){
        if (numeroEstacao < 0 || numeroEstacao >= estacoes.length){
            System.out.println("Estação inválida!");
        }else{
            estacaoAtual = numeroEstacao;
            musicaAtual = 0;
            if(tocando == true){
                Musica musica = estacoes[estacaoAtual].playlist[musicaAtual];
                System.out.println("Título: " + musica.titulo);
                System.out.println("Artista: " + musica.artista);
                System.out.println("Duração: " + musica.getDuracaoFormatada());
            }
        }
    }

    public void proximaMusica(){
        if(ligado == false){
            System.out.println("Ligue o rádio primeiro.");
        }else{
            Musica[] playlist = estacoes[estacaoAtual].playlist;
            int tamanho = playlist.length;

            musicaAtual = (musicaAtual + 1) % playlist.length;
            System.out.println("A música atual é: " + musicaAtual);

            Musica musica = estacoes[estacaoAtual].playlist[musicaAtual];
            System.out.println("Título: " + musica.titulo);
            System.out.println("Artista: " + musica.artista);
            System.out.println("Duração: " + musica.getDuracaoFormatada());
        }
    }

    public String getStatus() {
        StringBuilder sb = new StringBuilder();

        if (ligado) {
            Estacao estacao = estacoes[estacaoAtual];
            Musica musica = estacao.playlist[musicaAtual];

            sb.append("Estado de Energia: Ligado\n");
            sb.append("Estação: ").append(estacao.frequencia).append("\n");
            sb.append("Gênero: ").append(estacao.genero).append("\n");

            if (tocando) {
                sb.append("Faixa Atual: ").append(musica.titulo).append(" - ").append(musica.artista).append("\n");
            } else {
                sb.append("Faixa Pausada: ").append(musica.titulo).append(" - ").append(musica.artista).append("\n");
            }

            sb.append("Volume: ").append(volume);
        } else {
            sb.append("Estado de Energia: Desligado\n");
            sb.append("Volume: ").append(volume);
        }

        return sb.toString();
    } //fiz este método usando IA. Não consegui fazer usando esse StringBuilder.

    public boolean isLigado(){
        return ligado;
    }

    public boolean isTocando(){
        return tocando;
    }
}

