package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r]+
%{
    public String lexeme;
%}
%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}



/* Salto de linea */
( "\n" ) {return Linea;}





/* Operador Suma */
( "+" ) {lexeme=yytext(); return Suma;}

/* Operador Resta */
( "-" ) {lexeme=yytext(); return Resta;}

/* Operador Multiplicacion */
( "*" ) {lexeme=yytext(); return Multiplicacion;}

/* Operador Division */
( "/" ) {lexeme=yytext(); return Division;}

/* Parentesis de apertura */
( "(" ) {lexeme=yytext(); return Parentesis_a;}

/* Parentesis de cierre */
( ")" ) {lexeme=yytext(); return Parentesis_c;}


/*id*/
{L}({L}|{D})* {lexeme=yytext(); return Id;}

/* Numero_dec */
({D}+"."{D}+) {lexeme=yytext(); return Numero_dec;}

/* numero */
("(-"{D}+")")|{D}+ {lexeme=yytext(); return numero;}

/* Error de analisis */
 . {return ERROR;}
