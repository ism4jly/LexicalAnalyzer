package JFlex;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ElgolLexer lexer = new ElgolLexer(reader);

        System.out.println("Digite seu código Elgol linha por linha.");
        System.out.println("Pressione Enter em uma linha vazia para encerrar.\n");

        while (true) {
            System.out.print("> ");
            String linha = reader.readLine();
            if (linha == null || linha.trim().isEmpty()) break;

            lexer.yyreset(new StringReader(linha));
            String token;
            while ((token = lexer.yylex()) != null) {
                System.out.println(token);
            }
        }

        System.out.println("\nAnálise léxica concluída.");
    }
}

