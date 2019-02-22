package sistema.analisis;
import java_cup.runtime.Symbol; 
import sistema.bean.Token;
import main.Main;
%%

%{
    StringBuffer string = new StringBuffer();

    public void addToken(String lexema, String tipo){
        main.Main.tokens.add(new Token(lexema, tipo, yyline, yycolumn));
    }

    public void addError(String lexema, String tipo){
        main.Main.errores.add(new Token(lexema, tipo, yyline, yycolumn));
    }
%}

%class scanner
%public
%unicode
%full
%char
%line
%column
%ignorecase
%cup
/*%standalone revisar al implementar CUp*/

finDeLinea = \r|\n|\r\n
caracterEntrada = [^\r\n]
espacioEnBlanco = {finDeLinea} | [ \t\f]
comentarioUnaLinea = "//" {caracterEntrada}* {finDeLinea}?
comentarioMultiLinea = "/*" [^*] ~"*/" | "/*" "*"+ "/"
comentario = {comentarioUnaLinea} | {comentarioMultiLinea}
identificador = [:jletter:] [:jletterdigit:]*
numero = 0 | [0-9][0-9]*
comilla = \" | “ | ”

%state STRING

%%

<YYINITIAL> {
    "definirglobales"               { addToken(yytext(), "definirglobales"); return new Symbol(sym.definirglobales , yyline , yychar , yytext()); }
    "int"                           { addToken(yytext(), "entero"); return new Symbol(sym.entero , yyline , yychar , yytext()); }
    "string"                        { addToken(yytext(), "str"); return new Symbol(sym.str , yyline , yychar , yytext()); }
    "graficabarras"                 { addToken(yytext(), "graficabarras"); return new Symbol(sym.graficabarras , yyline , yychar , yytext()); }
    "graficalineas"                 { addToken(yytext(), "graficalineas"); return new Symbol(sym.graficalineas , yyline , yychar , yytext()); }
    "galeria"                       { addToken(yytext(), "galeria"); return new Symbol(sym.galeria , yyline , yychar , yytext()); }
    "id"                            { addToken(yytext(), "id"); return new Symbol(sym.id , yyline , yychar , yytext()); }
    "titulo"                        { addToken(yytext(), "titulo"); return new Symbol(sym.titulo , yyline , yychar , yytext()); }
    "titulox"                       { addToken(yytext(), "titulox"); return new Symbol(sym.titulox , yyline , yychar , yytext()); }
    "tituloy"                       { addToken(yytext(), "tituloy"); return new Symbol(sym.tituloy , yyline , yychar , yytext()); }
    "ejex"                          { addToken(yytext(), "ejex"); return new Symbol(sym.ejex , yyline , yychar , yytext()); }
    "ejey"                          { addToken(yytext(), "ejey"); return new Symbol(sym.ejey , yyline , yychar , yytext()); }
    "puntosxy"                      { addToken(yytext(), "puntosxy"); return new Symbol(sym.puntosxy , yyline , yychar , yytext()); }
    "definirxyline"                 { addToken(yytext(), "definirxyline"); return new Symbol(sym.definirxyline , yyline , yychar , yytext()); }
    "nombre"                        { addToken(yytext(), "nombre"); return new Symbol(sym.nombre , yyline , yychar , yytext()); }
    "color"                         { addToken(yytext(), "color"); return new Symbol(sym.color , yyline , yychar , yytext()); }
    "grosor"                        { addToken(yytext(), "grosor"); return new Symbol(sym.grosor , yyline , yychar , yytext()); }
    "puntos"                        { addToken(yytext(), "puntos"); return new Symbol(sym.puntos , yyline , yychar , yytext()); }

    "="                             { addToken(yytext(), "igual"); return new Symbol(sym.igual , yyline , yychar , yytext()); }
    "$"                             { addToken(yytext(), "aceptacion"); return new Symbol(sym.aceptacion , yyline , yychar , yytext()); }
    ";"                             { addToken(yytext(), "puntoycoma"); return new Symbol(sym.puntoycoma , yyline , yychar , yytext()); }
    "{"                             { addToken(yytext(), "llaveabre"); return new Symbol(sym.llaveabre , yyline , yychar , yytext()); }
    "}"                             { addToken(yytext(), "llavecierra"); return new Symbol(sym.llavecierra , yyline , yychar , yytext()); }
    ":"                             { addToken(yytext(), "dospuntos"); return new Symbol(sym.dospuntos , yyline , yychar , yytext()); }
    "["                             { addToken(yytext(), "corcheteabre"); return new Symbol(sym.corcheteabre , yyline , yychar , yytext()); }
    "]"                             { addToken(yytext(), "corchetecierra"); return new Symbol(sym.corchetecierra , yyline , yychar , yytext()); }
    "¿"                             { addToken(yytext(), "interrogacionabre"); return new Symbol(sym.interrogacionabre , yyline , yychar , yytext()); }
    "?"                             { addToken(yytext(), "interrogacioncierra"); return new Symbol(sym.interrogacioncierra , yyline , yychar , yytext()); }
    ","                             { addToken(yytext(), "coma"); return new Symbol(sym.coma , yyline , yychar , yytext()); }
    "("                             { addToken(yytext(), "parentesisabre"); return new Symbol(sym.parentesisabre , yyline , yychar , yytext()); }
    ")"                             { addToken(yytext(), "parentesiscierra"); return new Symbol(sym.parentesiscierra , yyline , yychar , yytext()); }
    "+"                             { addToken(yytext(), "suma"); return new Symbol(sym.suma , yyline , yychar , yytext()); }
    "-"                             { addToken(yytext(), "resta"); return new Symbol(sym.resta , yyline , yychar , yytext()); }
    "*"                             { addToken(yytext(), "multiplicacion"); return new Symbol(sym.multiplicacion , yyline , yychar , yytext()); }
    "/"                             { addToken(yytext(), "division"); return new Symbol(sym.division , yyline , yychar , yytext()); }
    {comilla}                       { addToken(yytext(), "comillaabre"); string.setLength(0); yybegin(STRING); /*return new Symbol(sym.comilla , yyline , yychar , yytext());*/ }

    {identificador}                 { addToken(yytext(), "identificador"); return new Symbol(sym.identificador , yyline , yychar , yytext()); }
    {numero}                        { addToken(yytext(), "numero"+yytext()); return new Symbol(sym.numero , yyline , yychar , yytext()); }
    {finDeLinea}                    { yychar=1; }
    {espacioEnBlanco}               {  }
    {comentario}                    {  }
}

<STRING> {
    {comilla}                       { addToken(string.toString(), "cadena"); addToken(yytext(), "comillacierra"); yybegin(YYINITIAL); return new Symbol(sym.cadena , yyline , yychar , string.toString()); }
    [^\n\r\"\\]+                    { string.append( yytext() ); }
    \\t                             { string.append( '\t' ); }
    \\n                             { string.append( '\n' ); }
    \\r                             { string.append( '\r' ); }
    \\\"                            { string.append( '\"' ); }
    \\                              { string.append( '\\' ); }
}
    

.                                   { addError(yytext(), "NO RECONOCIDO"); return new Symbol(sym.identificador , yyline , yychar , yytext()); }




