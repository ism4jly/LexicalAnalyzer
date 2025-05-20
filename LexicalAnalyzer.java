import java.util.regex.*;
import java.util.*;

public class LexicalAnalyzer {

    private static final Set<String> PALAVRAS_RESERVADAS = new HashSet<>(Arrays.asList(
            "elgio", "inteiro", "enquanto", "se", "entao", "senao",
            "inicio", "fim", "maior", "menor", "igual", "diferente"
    ));

    // Expressões regulares separadas para legibilidade
    private static final String COMENTARIO = "(#.*)";
    private static final String ID_FUNCAO = "(_[A-Z][a-zA-Z]{2,})";
    private static final String IDENTIFICADOR = "([A-Z][a-zA-Z]{2,})";
    private static final String NUMERO = "([1-9][0-9]*)";
    private static final String ZERO = "(zero)";
    private static final String COMP = "(comp)";
    private static final String PALAVRAS_CHAVE = "(" + String.join("|", PALAVRAS_RESERVADAS) + ")";
    private static final String OPERADORES = "(=|\\+|\\-|x|/)";
    private static final String PARENTESES = "(\\(|\\))";
    private static final String FIM_COMANDO = "(\\.)";

    private static final Pattern PADRAO_TOKEN = Pattern.compile(String.join("|",
        COMENTARIO, ID_FUNCAO, IDENTIFICADOR, NUMERO, ZERO, COMP,
        PALAVRAS_CHAVE, OPERADORES, PARENTESES, FIM_COMANDO
    ));

    public void analisarLinha(String linha) {
        linha = linha.split("#", 2)[0].trim(); // remove comentário e espaços

        if (linha.isEmpty()) return;

        Matcher matcher = PADRAO_TOKEN.matcher(linha);
        System.out.println("Analisando linha: \"" + linha + "\"");

        int pos = 0;

        while (matcher.find()) {
            String token = matcher.group();

            if (matcher.start() > pos) {
                String erro = linha.substring(pos, matcher.start()).trim();
                if (!erro.isEmpty()) {
                    emitirToken("TOKEN INVÁLIDO", erro);
                }
            }

            if (token.startsWith("#")) {
                break; // ignora comentário
            } else if (token.equals("zero") || token.equals("comp")) {
                emitirToken("OPERADOR", token);
            } else if (PALAVRAS_RESERVADAS.contains(token)) {
                emitirToken("PALAVRA-RESERVADA", token);
            } else if (token.matches(ID_FUNCAO)) {
                emitirToken("ID_FUNCAO", token);
            } else if (token.matches(IDENTIFICADOR)) {
                emitirToken("IDENTIFICADOR", token);
            } else if (token.matches(NUMERO)) {
                emitirToken("NUMERO", token);
            } else if (token.matches(OPERADORES)) {
                emitirToken("OPERADOR", token);
            } else if (token.matches(PARENTESES)) {
                emitirToken("PARENTESE", token);
            } else if (token.equals(".")) {
                emitirToken("FIM_COMANDO", ".");
            }

            pos = matcher.end();
        }

        if (pos < linha.length()) {
            String erro = linha.substring(pos).trim();
            if (!erro.isEmpty()) {
                emitirToken("TOKEN INVÁLIDO", erro);
            }
        }
    }

    private void emitirToken(String tipo, String valor) {
        System.out.printf("%s: %s%n", tipo, valor);
    }
}
