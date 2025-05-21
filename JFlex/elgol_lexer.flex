%%
%public
%class ElgolLexer
%unicode
%line
%column
%type String

%%

// Palavras-chave
"elgio"             { return "PALAVRA-RESERVADA: elgio"; }
"inteiro"           { return "PALAVRA-RESERVADA: inteiro"; }
"enquanto"          { return "PALAVRA-RESERVADA: enquanto"; }
"se"                { return "PALAVRA-RESERVADA: se"; }
"entao"             { return "PALAVRA-RESERVADA: entao"; }
"senao"             { return "PALAVRA-RESERVADA: senao"; }
"inicio"            { return "PALAVRA-RESERVADA: inicio"; }
"fim"               { return "PALAVRA-RESERVADA: fim"; }
"maior"             { return "PALAVRA-RESERVADA: maior"; }
"menor"             { return "PALAVRA-RESERVADA: menor"; }
"igual"             { return "PALAVRA-RESERVADA: igual"; }
"diferente"         { return "PALAVRA-RESERVADA: diferente"; }

// Operadores especiais
"zero"              { return "OPERADOR: zero"; }
"comp"              { return "OPERADOR: comp"; }

// Operadores comuns
"="                 { return "OPERADOR: ="; }
"+"                 { return "OPERADOR: +"; }
"-"                 { return "OPERADOR: -"; }
"x"                 { return "OPERADOR: x"; }
"/"                 { return "OPERADOR: /"; }

// Identificadores e funções
_[A-Z][a-zA-Z]{2,}  { return "ID_FUNCAO: " + yytext(); }
[A-Z][a-zA-Z]{2,}   { return "IDENTIFICADOR: " + yytext(); }

// Números
[1-9][0-9]*         { return "NUMERO: " + yytext(); }

// Parênteses e ponto
"("                 { return "PARENTESE: ("; }
")"                 { return "PARENTESE: )"; }
"."                 { return "FIM_COMANDO: ."; }

// Comentário
"#".*               { /* ignora comentário */ }

// Espaços em branco
[\t\r\n ]+          { /* ignora espaço */ }

// Qualquer outro caractere é inválido
.                   { return "TOKEN INVÁLIDO: " + yytext(); }
