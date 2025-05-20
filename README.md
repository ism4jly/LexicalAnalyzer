# Analisador Léxico para Elgol

## Sobre

Este projeto consiste em um **analisador léxico** desenvolvido em Java para a linguagem fictícia **Elgol**.  
Seu objetivo é identificar tokens válidos de acordo com as regras léxicas da linguagem e reportar erros quando encontrados.  
Ele é parte fundamental do processo de compilação ou interpretação de código, realizando a análise inicial do texto fonte.

---

## Definições da linguagem Elgol

A linguagem **Elgol** possui as seguintes regras léxicas para formação de tokens:

- **Palavras Reservadas:**  
  `elgio`, `inteiro`, `zero`, `comp`, `enquanto`, `se`, `entao`, `senao`, `inicio`, `fim`, `maior`, `menor`, `igual`, `diferente`

- **Funções:**  
  Começam com um sublinhado `_` seguido de uma letra maiúscula e ao menos duas letras.  
  Exemplo: `_Funcao`, `_Calculo`

- **Identificadores:**  
  Devem começar com uma letra maiúscula e conter pelo menos três letras.  
  Exemplo: `Variavel`, `Contador`

- **Números:**  
  Inteiros positivos sem zeros à esquerda. O número `0` deve ser representado pela palavra `zero`.

- **Operadores:**  
  `+`, `-`, `x`, `/`, `=`, além dos operadores reservados `comp` e `zero`

- **Parênteses:**  
  `(` e `)`

- **Fim de comando:**  
  Representado por um ponto final `.`

- **Comentários:**  
  Começam com `#` e se estendem até o final da linha.  
  São ignorados na análise.

Tokens inválidos (símbolos desconhecidos, formatos incorretos, etc.) são detectados e relatados com a tag **TOKEN INVÁLIDO**.

## Integrantes

Ismael Freitas
