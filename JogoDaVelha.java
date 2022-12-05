import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        char[][] tabuleiro = new char[3][3];
        boolean jogoFinalizado = false;
        boolean velha = false;
        char jogador = 'o';
        int qtdJogadas = 0;

        for(int i = 0; i < tabuleiro.length; i++){
            for(int j = 0; j < tabuleiro[i].length; j++){
                tabuleiro[i][j] = '_';
            }
        }
        do{
            System.out.printf("O jogador da vez é o %s.\n", jogador);
            System.out.println("Digite a posição que quer jogar: (ex: a1) ");

            System.out.print("     a   b   c   \n");
            for(int i = 0; i < 3; i++){
                System.out.printf("%d | %s | %s | %s \n", i + 1, tabuleiro[i][0], tabuleiro[i][1], tabuleiro[i][2]);
            }
            String entrada = ler.nextLine().trim();
            int horizontal;
            int vertical;

            horizontal = switch(entrada.charAt(0)){
                case 'a' -> 0;
                case 'b' -> 1;
                case 'c' -> 2;
                default -> -1;
            };
            vertical = switch(entrada.charAt(1)){
                case '1' -> 0;
                case '2' -> 1;
                case '3' -> 2;
                default -> -1;
            };
            if(horizontal == -1 || vertical == -1){
                System.out.printf("Posição inválida!");
            } else if(tabuleiro[vertical][horizontal] != '_') {
                System.out.printf("Esse espaço já está ocupado!");
            } else {
                qtdJogadas++;
                tabuleiro[vertical][horizontal] = jogador;
                if(tabuleiro[0][0] != '_' && tabuleiro[0][0] == tabuleiro[0][1] &&
                        tabuleiro[0][1] == tabuleiro[0][2]){
                    System.out.println("Vitória na primeira linha.");
                    jogoFinalizado = true;
                } else if(tabuleiro[1][0] != '_' && tabuleiro[1][0] == tabuleiro[1][1] &&
                        tabuleiro[1][1] == tabuleiro[1][2]){
                    System.out.println("Vitória na segunda linha.");
                    jogoFinalizado = true;
                } else if(tabuleiro[2][0] != '_' && tabuleiro[2][0] == tabuleiro[2][1] &&
                        tabuleiro[2][1] == tabuleiro[2][2]){
                    System.out.println("Vitória na terceira linha.");
                    jogoFinalizado = true;
                } else if(tabuleiro[0][0] != '_' && tabuleiro[0][0] == tabuleiro[1][1] &&
                        tabuleiro[1][1] == tabuleiro[2][2]){
                    System.out.println("Vitória na primeira diagonal.");
                    jogoFinalizado = true;
                } else if(tabuleiro[0][2] != '_' && tabuleiro[0][2] == tabuleiro[2][2] &&
                        tabuleiro[2][2] == tabuleiro[2][0]){
                    System.out.println("Vitória na segunda diagonal.");
                    jogoFinalizado = true;
                } else if(tabuleiro[2][0] != '_' && tabuleiro[2][2] == tabuleiro[1][1] &&
                        tabuleiro[1][1] == tabuleiro[0][0]) {
                    System.out.println("Vitória na segunda diagonal.");
                    jogoFinalizado = true;
                }
                else if(qtdJogadas == 9){
                    System.out.println("Velha! Não houveram vencedores.");
                    jogoFinalizado = true;
                    velha = true;
                } else{
                    if(jogador == 'o'){
                        jogador = 'x';
                    } else{
                        jogador = 'o';
                    }
                }
            }
        } while(!jogoFinalizado);
            System.out.println();
            if(!velha){
                System.out.printf("o jogador foi %s.", jogador);
            }
    }
}