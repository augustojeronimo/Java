import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // consertar o bug da fruta
        // implementar fim se ficar preso
        // melhorar interface

        telaInicio();

        criarCobra(3 , 4);

        criarFruta();
        do {

            exibirCampo();

            jogada();
            
        } while (pontos < 5);

        exibirCampo();

        telaVitoria();
    }


    static Scanner input = new Scanner(System.in);

    /* Declaração das constantes de cor para o terminal */
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String PURPLE = "\u001B[35m";
    static final String CIAN = "\u001B[36m";
    static final String RESET = "\u001B[m";

    /* Declaração da variáveis */
    static int larg = 7, alt = 11, tam = 5, pontos = 0;
    static int[][] campo = new int[alt][larg];
    static int[][] cobra = new int[2][tam];
    /* Y -> [0][0] <- Cabeça | X -> [1][0] <- Cabeça */

    public static void telaInicio() {
        System.out.print("\n\n\n\n\n\n");
        System.out.printf("%s+-----------------------------+%s%n", CIAN, RESET);
        System.out.printf("%s|   %sJOGO DA COBRINHA%s - %sJAVA%s   |%s%n", CIAN, YELOW, CIAN, BLUE, CIAN, RESET);
        System.out.printf("%s+-----------------------------+%s%n", CIAN, RESET);
        System.out.printf("\t%soooo@%s    %s$%s%n%n%n", PURPLE, RESET, RED, RESET);

        System.out.printf("%s(Digite qualquer coisa para começar)%s%n", YELOW, RESET);

        System.out.print(":");

        input.next();
    }

    public static void telaVitoria() {
        System.out.print("\n\n\n");
        System.out.printf("%s+-----------------------------+%s%n", CIAN, RESET);
        System.out.printf("%s|        %sFIM DE JOGO          %s|%s%n", CIAN, YELOW, CIAN, RESET);
        System.out.printf("%s+-----------------------------+%s%n", CIAN, RESET);
    }


    public static void exibirCampo() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
        for (int i = 0; i < alt; i++) {
            for (int j = 0; j < larg; j++) {

                switch (campo[i][j]) {
                    case -1: /* Fruta */
                        System.out.printf("%s(%s$%s)%s", GREEN, RED, GREEN, RESET);
                        break;
                    case 0: /* Limpo */
                        System.out.printf("%s( )%s", GREEN, RESET);
                        break;
                    case 1: /* Cabeça */
                        System.out.printf("%s(%s@%s)%s", GREEN, PURPLE, GREEN, RESET);
                        break;
                    default: /* Corpo */
                        System.out.printf("%s(%so%s)%s", GREEN, PURPLE, GREEN, RESET);
                        break;
                }

            }System.out.println();
        }
        System.out.printf("%sPontuação: %s%d%s", CIAN, pontos>0?BLUE:RED, pontos, RESET);

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        
    }

    public static void criarCobra(int x, int y) {

        /* Define a posição que a cobra vai ocupar inicialmente */
        for (int i = 0; i < tam; i++) {
            cobra[0][i] = y; cobra[1][i] = x;
            y++;
        }

        setCobra();
    }

    public static void setCobra() {
        /* variável de controle da fruta */
        boolean cf = false;

        /* Conta a pontuação quando come */
        if (campo[cobra[0][0]][cobra[1][0]] == -1) {
            pontos++;
            /* Cria a fruta futuramente */
            cf = true;
        }

        /* Marca no campo a posição definida da cobra */
        for (int i = 0; i < tam; i++) {
            campo[cobra[0][i]][cobra[1][i]] = i+1;    
        }

        /* E a fruta foi comida, gera novamente evitando a colisão */
        if (cf) {
            criarFruta();
        }

    }

    public static void criarFruta() {
        Random r = new Random();

        /* Variáveis de posicionamento da fruta no campo */
        int fx, fy;
        
        do { /* repete se o lugar está ocupado */
            fx = r.nextInt(larg-1);
            fy = r.nextInt(alt-1);
        } while (campo[fy][fx] != 0); 

        /* Define o lugar como fruta */
        campo[fy][fx] = -1; 
    }

    public static void jogada() {
        boolean erro;
        
        do {
            System.out.printf("%s    +---+    %s%n", BLUE, RESET);
            System.out.printf("%s    | W |    %s%n", BLUE, RESET);
            System.out.printf("%s+---+---+---+%s%n", BLUE, RESET);
            System.out.printf("%s| A | S | D |%s%n", BLUE, RESET);
            System.out.printf("%s+-----------+%s%n", BLUE, RESET);

            System.out.printf("%sdireção: %s", PURPLE, RED);
            String direcao = input.next().toLowerCase();

            erro = false;

            switch (direcao.substring(direcao.length()-1, direcao.length())) {
                case "a":
                    /* Se o headX é 0, ela vai bater indo para a esquerda*/
                    if (cobra[1][0] == 0) {
                        erro = true;
                    }
                    /* Se a posição seginte é > 1, é o corpo ou a parede */
                    else if (campo[cobra[0][0]][cobra[1][0] - 1] > 1) {
                        erro = true;
                    } else {
                        moverCobra(1);
                    }

                    break;
                case "d":

                    if (cobra[1][0] == larg-1) {
                        erro = true;
                    } else if (campo[cobra[0][0]][cobra[1][0] + 1] > 1) {
                        erro = true;
                    } else {
                        moverCobra(2);
                    }
                    
                    break;
                case "w":

                    if (cobra[0][0] == 0) {
                        erro = true;
                    } else if (campo[cobra[0][0] - 1][cobra[1][0]] > 1) {
                        erro = true;
                    } else {
                        moverCobra(3);
                    }
                    
                    break;
                case "s":

                    if (cobra[0][0] == alt-1) {
                        erro = true;
                    } else if (campo[cobra[0][0] + 1][cobra[1][0]] > 1) {
                        erro = true;
                    } else {
                        moverCobra(4);
                    }
                    
                    break;
                default:
                    break;
            }

            if (erro) {

                exibirCampo();

                System.out.printf("%n%s[ERRO] Direção inválida!%s%n%n", RED, RESET);
;
            }
            
        } while (erro);
    }

    public static void moverCobra(int dir) {

        for (int i = tam-1; i > 0; i--) {
            cobra[0][i] = cobra[0][i-1]; cobra[1][i] = cobra[1][i-1];
            
        }

        switch (dir) {
            case 1: // Esquerda
                cobra[1][0]--;
                break;
            case 2: // Direita
                cobra[1][0]++;
                break;
            case 3: // Cima
                cobra[0][0]--;
                break;
            case 4: // Baixo
                cobra[0][0]++;
                break;
            default: // O erro impossível...
                System.out.printf("%sMas não é possível...%s", RED, RESET);
                break;
        }

        limparCampo();

        setCobra();
    }

    public static void limparCampo() {
        for (int i = 0; i < alt; i++) {
            for (int j = 0; j < larg; j++) {
                if (campo[i][j] != -1) {
                    campo[i][j] = 0;
                }
            }
        }
    }


}