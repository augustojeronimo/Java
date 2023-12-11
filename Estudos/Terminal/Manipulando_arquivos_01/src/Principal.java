import java.nio.file.*;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Path diretorio = Paths.get("./dirTestes/texto.txt");

        try {

            int n = 5;
            System.out.printf("Digite %d linhas:%n",n);

            String txt = "";

            for (int i = 0; i < 5; i++) {

                txt += input.nextLine()+"\n";

            }

            Files.writeString(diretorio, txt);


        } catch (Exception e) {
            System.out.println("ERRO");
        }

    }
}
