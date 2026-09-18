import java.util.Scanner;

public class RadioApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Musica m1 = new Musica("Música A", "Artista A", "Pop", 180);
        Musica m2 = new Musica("Música B", "Artista B", "Pop", 200);
        Estacao e1 = new Estacao("101.5", "Pop", new Musica[]{m1, m2});

        Musica m3 = new Musica("Música C", "Artista C", "Rock", 220);
        Estacao e2 = new Estacao("98.3", "Rock", new Musica[]{m3});

        Estacao[] estacoes = new Estacao[]{e1, e2};
        Radio radio = new Radio(estacoes);

        int opcao;
        do {
            System.out.println("\n===== MENU RÁDIO =====");
            System.out.println("1 - Ligar/Desligar rádio");
            System.out.println("2 - Tocar/Pausar");
            System.out.println("3 - Aumentar volume");
            System.out.println("4 - Diminuir volume");
            System.out.println("5 - Trocar estação");
            System.out.println("6 - Próxima música");
            System.out.println("7 - Ver status");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    if (radio.isLigado()) {
                        radio.desligar();
                    } else {
                        radio.ligar();
                    }
                    break;

                case 2:
                    if (radio.isTocando()) {
                        radio.pausar();
                    } else {
                        radio.tocar();
                    }
                    break;

                case 3:
                    System.out.print("Incremento de volume: ");
                    int incremento = scanner.nextInt();
                    radio.aumentarVolume(incremento);
                    break;

                case 4:
                    System.out.print("Decremento de volume: ");
                    int decremento = scanner.nextInt();
                    radio.diminuirVolume(decremento);
                    break;

                case 5:
                    System.out.println("Estações disponíveis:");
                    for (int i = 0; i < estacoes.length; i++) {
                        System.out.println((i + 1) + " - " + estacoes[i].frequencia + " (" + estacoes[i].genero + ")");
                    }
                    System.out.print("Escolha o número da estação: ");
                    int escolha = scanner.nextInt();
                    radio.trocarEstacao(escolha - 1);
                    break;

                case 6:
                    radio.proximaMusica();
                    break;

                case 7:
                    System.out.println(radio.getStatus());
                    break;

                case 8:
                    System.out.println("Encerrando o rádio...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 8);

        scanner.close();
    }
}