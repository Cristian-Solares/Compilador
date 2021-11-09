/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import static java.lang.Float.isNaN;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Charly Ponce
 */
public class FrmPrincipal extends javax.swing.JFrame {

    private String[] valor1 = new String[]{null,null};
    private String[] valor2 = new String[]{null,null};
    private String[] operacion = new String[]{null,null};
    private LinkedList cola = new LinkedList();
    private float t1=0,t2=0,t3=0,t4=0,t5=0,t6=0,t7=0,t8=0,t9=0;
    private boolean decimal=false;
    private float n1=0,n2=0;

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public void finalasm(){
        
        
    }
public void archivoasm() throws FileNotFoundException, UnsupportedEncodingException, IOException{
    FileWriter archivo = new FileWriter("C:/Users/crizs/Desktop/Analizador03/archivo.asm");
            String Texto=".model small\n" +
".stack\n" +
".data\n" +
                   
".code\n" ;
        try (BufferedWriter archivobf = new BufferedWriter(archivo)) {
            archivo.write(Texto);
        }
}

public void mayor_decien_asm(String num) throws IOException{
    FileWriter archivo = new FileWriter("C:/Users/crizs/Desktop/Analizador03/archivo.asm");
            String Texto= "signo_suma macro numsum1,numsum2,contsum             ;Macro con 3 argumentos(numsum1,numsum2,contsum)  \n" +
"                                                     ;Hace la operacion de resta para el signo y lo imprime\n" +
"    LOCAL sumareserror1,sumareserror2                ;Asigna la etiqueta local para sumareserror1,sumareserror2\n" +
"    LOCAL puntosum5,sumareserror3                    ;Asigna la etiqueta local para puntosum5,sumareserror3\n" +
"    LOCAL sumareserror4                              ;Asigna la etiqueta local para sumareserror4\n" +
"    LOCAL restaprestamossum1                         ;Asigna la etiqueta local para restaprestamossum1\n" +
"    LOCAL norestaprestamossum1                       ;Asigna la etiqueta local para norestaprestamossum1\n" +
"    mov al,numsum1                                   ;asigna el contenido de numsum1 a AL\n" +
"    cmp al,2eh                                       ;compara AL con 2eh (.)\n" +
"    jz  puntosum5                                    ;salta si es cero a  puntosum5  \n" +
"    cmp al,0dh                                       ;compara AL con 0d (salto)\n" +
"    jz  sumareserror1                                ;salta si es cero  a sumareserror1\n" +
"    jnz sumareserror2                                ;salta no es a sumareserror2\n" +
"sumareserror1:                                       ;Etiqueta que pone 0 si es 2eh o 0dh\n" +
"    mov al,0h                                        ;asigna 0h a AL\n" +
"sumareserror2:                                       ;Etiqueta que no pone 0 si es 0dh \n" +
"    mov sumgua1,al                                   ;asignael contenido de AL  a sumgua1\n" +
"    mov al,numsum2                                   ;asigna el contenido de la direccion de memoria de numsum2 a AL\n" +
"    cmp al,2eh                                       ;compara AL  con 2eh (.)\n" +
"    jz  puntosum5                                    ;salta si es cero a puntosum5\n" +
"    cmp al,0dh                                       ;compara AL  con 0dh (salto)\n" +
"    jz  sumareserror3                                ;salta si es cero  a sumareserror3 \n" +
"    jnz sumareserror4                                ;salta no si es cero  a sumareserror4 \n" +
"sumareserror3:                                       ;Etiqueta que pone 0 si es 2eh o 0dh\n" +
"    mov al,0h                                        ;asigna 0h a AL\n" +
"sumareserror4:                                       ;Etiqueta que no pone 0 si es 0dh \n" +
"    cmp ah,-1h                                       ;compara AL con -1h para el signo\n" +
"    jz  restaprestamossum1                           ;salta si es cero a restaprestamossum1\n" +
"    jnz norestaprestamossum1                         ;salta si no es cero a norestaprestamossum1\n" +
"restaprestamossum1:                                  ;Etiqueta que indica que se tiene un prestamo\n" +
"    sub al,1                                         ;resta 1 a AL y lo guarda en AL\n" +
"    mov ah,0                                         ;asigna 0 a AH \n" +
"    aas                                              ;ajuste de la resta\n" +
"    add al,30h                                       ;suma 30h a AL y lo guarda en AL\n" +
"norestaprestamossum1:                                ;Etiqueta que indica que no se tiene un prestamo  \n" +
"    sub al,sumgua1                                   ;resta sumgua1 a AL y lo guarda en AL\n" +
"    aas                                              ;ajuste dela resta\n" +
"    add al,30h                                       ;suma 30h a AL y lo guarda en AL\n" +
"puntosum5:                                           ;Etiqueta que guarda el punto en resula\n" +
"    mov resula+contsum,al                            ;Asigna a AL la direccion de memoria de resula+contsum\n" +
"endm                                                 ;fin de la macro signo_suma \n" +
"\n" +
"sumaprint1 macro                                      ;Macro que imprime resula                      \n" +
"    LOCAL excepcisum1,excepcisum2                     ;Asigna la etiqueta local para excepcisum1,excepcisum2\n" +
"    LOCAL excepcisum3,excepcisum4                     ;Asigna la etiqueta local para excepcisum3,excepcisum4\n" +
"    LOCAL quitacerosum1,excepsumpunto                 ;Asigna la etiqueta local para quitacerosum1,excepsumpunto\n" +
"    LOCAL excepsumpunto0,excepsumpunto1               ;Asigna la etiqueta local para excepsumpunto0,excepsumpunto1\n" +
"    LOCAL excepsumpunto2,puntosum0                    ;Asigna la etiqueta local para excepsumpunto2,puntosum0  \n" +
"    LOCAL puntosum1,puntosum2,sinpunto3               ;Asigna la etiqueta local para puntosum1,puntosum2,sinpunto3\n" +
"    LOCAL sumapr,puntosum3,sinpunto2                  ;Asigna la etiqueta local para sumapr,puntosum3,sinpunto2\n" +
"    mov cx,4                                          ;asigna 4 a CX\n" +
"    mov bx,3                                          ;asigna 3 a BX\n" +
"sumapr:                                               ;Ciclo que imprime el contenido de resula                                                                                   \n" +
"    mov al,[resula+bx]                                ;asigna el contenido de la direccion de memoria dada  por \n" +
"                                                      ;el desplazamiento de resula mas BX a AL\n" +
"    cmp bx,0                                          ;compara BX con 0                                         \n" +
"    jz  excepcisum1                                   ;salta si BX es cero a excepcisum1\n" +
"    jnz excepcisum2                                   ;salta si BX  no es cero a excepcisum2  \n" +
"excepcisum2:                                          ;Etiqueta para BX no es cero\n" +
"    cmp bx,3                                          ;compara BX con 3\n" +
"    jz  excepcisum3                                   ;salta si BX es tres a excepcisum3 \n" +
"    jnz excepcisum4                                   ;salta si BX no es tres a excepcisum4\n" +
"excepcisum1:                                          ;Etiqueta para BX es cero como posicion\n" +
"excepcisum3:                                          ;Etiqueta para BX es tres como posicion\n" +
"    cmp al,30h                                        ;compara AL con 30h para eliminar el primer 0 y el ultimo \n" +
"    jz  quitacerosum1                                 ;salta si AL es cero a quitacerosum1\n" +
"excepcisum4:                                          ;Etiqueta para BX no es tres como posicion\n" +
"    mov dl,al                                         ;asigna AL a DL                       \n" +
"    mov ah,02h                                        ;con la funcion 02h                            \n" +
"    int 21h                                           ;de la int 21h (se imprime el numero) \n" +
"    cmp al,2eh                                        ;compara AL con 2eh(punto) \n" +
"    jz  excepsumpunto                                 ;salta si AL  es 2eh a excepsumpunto\n" +
"    jnz excepsumpunto0                                ;salta si AL  es 2eh a excepsumpunto0\n" +
"excepsumpunto0:                                       ;Etiqueta para AL  no es 2eh\n" +
"    cmp bx,2                                          ;compara BX  con 2\n" +
"    jz  excepsumpunto1                                ;salta si BX es dos a excepsumpunto1\n" +
"    jnz excepsumpunto2                                ;salta si BX no es dos a excepsumpunto2\n" +
"excepsumpunto1:                                       ;Etiqueta si BX=2 para poner punto en medio\n" +
"    cmp al,30h                                        ;compara AL con 30h\n" +
"    jz  puntosum0                                     ;salta si AL es 30h a  puntosum0 \n" +
"    jnz puntosum1                                     ;salta si AL no es 30h a puntosum1\n" +
"puntosum1:                                            ;Etiqueta si AL es 30h\n" +
"puntosum0:                                            ;Etiqueta si no es 30h\n" +
"    cmp resula+1,30h                                  ;Compara la direcion de memoria de resula+1 con 30h\n" +
"    jz  puntosum2                                     ;salta si resula+1 es 30h a puntosum2\n" +
"    jnz puntosum3                                     ;salta si resula+1 no es 30h a puntosum3\n" +
"puntosum2:                                            ;Etiqueta para resula+1 es 30h\n" +
"    cmp resula+0,30h                                  ;Compara la direcion de memoria de resula+0 con 30h\n" +
"    jz  sinpunto2                                     ;salta si resula+0 es 30h a sinpunto2\n" +
"    jnz sinpunto3                                     ;salta si resula+0 no es 30h a sinpunto3      \n" +
"sinpunto3:                                            ;Etiqueta si resula+1 no es 30h a puntosum\n" +
"puntosum3:                                            ;Etiqueta si resula+1 no es 30h a puntosum\n" +
"    printmsj punto                                    ;Invoca a la macro para imprimir el contenido de punto                       \n" +
"excepsumpunto2:                                       ;Etiqueta para BX no es posicion dos de la tabla resula \n" +
"excepsumpunto:                                        ;Etiqueta si AL  es 2eh, decrementa a bx en 1\n" +
"quitacerosum1:                                        ;Etiqueta para BX=3,BX=0 no imprime nada y decrementa)\n" +
"    dec bx                                            ;decrementa BX en 1\n" +
"    loop sumapr                                       ;Ciclo que imprime el contenido de resula  \n" +
"sinpunto2:                                            ;Etiqueta que sale del ciclo sin imprimi punto\n" +
"endm                                                  ;fin de la macro sumaprint1 \n" +
"\n" +
"                                                                                       \n" +
"                                                                                       \n" +
";--------------------------------------------------------\n" +
";INICIO                                                 :\n" +
";--------------------------------------------------------\n" +
"inicio macro                                            ;macro que asigna datos a DS \n" +
"    mov ax,data                                         ;asigna la direccion del segmento de datos a AX \n" +
"    mov ds,ax                                           ;y atravesde AX se asigna a DS\n" +
"endm                                                    ;fin de la macro inicio        \n" +
";--------------------------------------------------------\n" +
";FIN                                                    :\n" +
";--------------------------------------------------------\n" +
"fin macro                                               ;macro que devuelve el control al DOS\n" +
"    mov ax,4c00h                                        ;asigna la funcion 4c00 de la\n" +
"    int 21h                                             ;INT 21h a AX y se devuelve el control al DOS\n" +
"endm                                                    ;fin de la macro fin    \n" +
";--------------------------------------------------------\n" +
";LIMPIAR                                                :\n" +
";--------------------------------------------------------\n" +
"limpant MACRO                                           ;macro que limpia la pantalla\n" +
"    mov ah,0Fh                                          ;funcion 0f (obtiene modo de video)\n" +
"    int 10h                                             ;de la int 10h \n" +
"    mov ah,0                                            ;funcion 0 (cambia el modo video) de la\n" +
"    int 10h                                             ;int 10h (es decir las 4 instrucciones borran la pantalla)\n" +
"ENDM                                                    ;fin de la macro limpant   \n" +
";--------------------------------------------------------\n" +
";IMPRIMIR                                               :\n" +
";--------------------------------------------------------\n" +
"printmsj MACRO mensa                                    ;macro que imprime mensaje\n" +
"    lea dx,mensa                                        ;asigna la direccion inicial de desplazamiento\n" +
"                                                        ;de la localidad de memoria mensa al registro DX(DS:DX)\n" +
"    mov ah,09                                           ;asigna la funcion 09 de la INT 21h\n" +
"    int 21h                                             ;a AH(aparece mensaje en pantalla)\n" +
"ENDM                                                    ;fin de la macro printmsj \n" +
"                                                                                       \n" +
"\n" +
";--------------------------------------------------------                                     \n" +
"    .model small                                        ;define el modelo de memoria\n" +
"	.stack                                              ;define area de pila\n" +
"	.data                                               ;define el area de datos\n" +
";--------------------------------------------------------\n" +
";SEGMENTO DE DATOS                                      :\n" +
";--------------------------------------------------------\n" +
"numero1 db   1,2,3,5                                      ;se define la tabla numero1\n" +
"numero2 db    1,3,6,4                                             ;se define la tabla numero2\n" +
"resula  db  0,0,0,0                                     ;se define la tabla resula\n" +
"resres  db  30,30,30,30                                 ;se define la tabla resres\n" +
"signo1  db  02,00,00,02                                           ;se define la variable signo1\n" +
"signo2  db  ?                                           ;se define la variable signo2\n" +
"signor  db  ?                                           ;se define la variable signor\n" +
"signo   db  '-$'                                        ;asigna la cadena a la variable signo\n" +
"punto   db  '"+num+"$'                                        ;asigna la cadena a la variable punto\n" +
"me_nos  db '-$'\n" +
"sumgua1 db  0                                           ;se define la variable sumgua1\n" +
"sumgua2 db  0                                           ;se define la variable sumgua2\n" +
".code                                               ;define area de codigo                      \n" +
"inicia: \n" +
"inicio  \n" +

"printmsj punto    \n" +
"fin\n" +
"\n" +
"endp inicia        \n" +
"        \n" +
"        \n" +
"suma proc                                       ;Procedimiento para Suma\n" +
"                            ;Invoca a la macro que imprime mensaje \n" +
"SALTO_DE_LA_RES:                                ;Salto que viene de la resta\n" +
";------------------------------------------------\n" +
";COMPARA SIGNOS                                 |\n" +
";------------------------------------------------   \n" +
"    mov ax,0h                                   ;Asigna 0 a AX        \n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo2 sea signo negativo \n" +
"    jz  tienesignonegativosum                   ;Salta si signo2 tiene signo negativo\n" +
"    jnz notienesignonegsum                      ;Salta si signo2 no tiene signo negativo\n" +
"tienesignonegativosum:                          ;Etiqueta para sign2 es negativo\n" +
"    cmp signo1,'-'                              ;Compara el contenido de signo1 sea signo negativo\n" +
"    jz  tiene2signonegativosum                  ;Salta si signo1 tiene signo negativo\n" +
"    jnz notiene2signonegsum                     ;Salta si signo1 no tiene signo negativo\n" +
"tiene2signonegativosum:                         ;Etiqueta para cuando signo1 no tiene signo negativo\n" +
"    printmsj signo                              ;Invoca a la marco para imprimir signo\n" +
"    jmp tiene2signonegativosum2                 ;Salta a suma normal por que no hay negativos\n" +
"notienesignonegsum:                             ;Etiqueta para signo2 no es negativo\n" +
"    cmp signo1,'-'                              ;Compara el contenido de signo1 sea signo negativo\n" +
"    jz  tienesignonegativosum1                  ;Salta si signo1 tiene signo negativo\n" +
"    jnz notienesignoneg1                        ;Salta si signo1 no tiene signo negativo\n" +
"notiene2signonegsum:                            ;Etiqeuta para cuando signo1 no es negativo\n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo2 con '-'\n" +
"    jz  tienesignonegativosum1                  ;Salta si el contenido de signo2 es negativo\n" +
"    jnz notienesignoneg1                        ;Salta si el contnenido de signo2 no es negativo\n" +
"tienesignonegativosum1:                         ;Etiqueta para cuando signo2 es negativo\n" +
"    mov al,numero1+3                            ;Asigna el contenido de la direccion de memoira de numero1+3 a AL\n" +
"    cmp al,numero2+3                            ;Compara el contenido de numero1+3 con AL\n" +
"    ja  mayorsum                                ;Salta si AL es mayor y numero2+3 es menor\n" +
"    jb  menorsum                                ;Salta  si AL es menor y numero2+3 es mayor\n" +
"    je  verificarsegnumero                      ;Salta si son iguales \n" +
"verificarsegnumero:                             ;Etiqueta si son iguales va verifcando numero por numero\n" +
"    mov al,numero1+2                            ;Asigna el contenido de la direccion de memoira de numero1+2 a AL\n" +
"    cmp al,numero2+2 ;                          ;Compara el contenido de numero1+2 con AL\n" +
"    ja  mayorsum                                ;Salta si AL es mayor y numero2+2 es menor\n" +
"    jb  menorsum                                ;Salta  si AL es menor y numero2+2 es mayor\n" +
"    je  verificarsegnumero1                     ;Salta si son iguales     \n" +
"verificarsegnumero1:                            ;Etiqueta si son iguales va verifcando numero por numero\n" +
"    mov al,numero1+1                            ;Asigna el contenido de la direccion de memoira de numero1+1 a AL\n" +
"    cmp al,numero2+1                            ;Compara el contenido de numero1+1 con AL\n" +
"    ja  mayorsum                                ;Salta si AL es mayor y numero2+1 es menor\n" +
"    jb  menorsum                                ;Salta  si AL es menor y numero2+1 es mayor\n" +
"    je  verificarssegnumero2                    ;Salta si son iguales \n" +
"verificarssegnumero2:                           ;Etiqueta si son iguales va verifcando numero por numero\n" +
"    mov al,numero1+0                            ;Asigna el contenido de la direccion de memoira de numero1+0 a AL\n" +
"    cmp al,numero2+0                            ;Compara el contenido de numero1+0 con AL\n" +
"    ja  mayorsum                                ;Salta si AL es mayor y numero2+0 es menor\n" +
"    jb  menorsum                                ;Salta  si AL es menor y numero2+0 es mayor\n" +
"    je  igualsum                                ;Salta si son iguales  \n" +
";------------------------------------------------\n" +
";NUMEROS IGUALES                                 |\n" +
";------------------------------------------------ \n" +
"igualsum:                                       ;Etiqueta si son numeros iguales \n" +
"    cmp signo1,'-'                              ;Compara el contenido de signo1 con '-'\n" +
"    jz  tienesigno00                            ;Salta si signo1 es negativo\n" +
"    jnz notienesigno00                          ;Salta si signo1 no es negativo\n" +
"tienesigno00:                                   ;Etiqueta si signo1 es negativo\n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum00:                                   ;Etiqueta de Ciclo que resta cuando numero 1 tiene signpo negativo  \n" +
"    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incrementa BX en 1\n" +
"    loop sisignosum00                           ;Ciclo que resta cuando los numeros son iguales\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion\n" +
"notienesigno00:                                 ;Etiqueta si el signo1 no es negativo\n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo2 con '-'\n" +
"    jz  tienesigno0                             ;Salta si signo2 es negativo \n" +
"    jnz notienesigno0                           ;Salta si signo2 no es negativo\n" +
"tienesigno0:                                    ;Etiqueta si signo2 es negativo           \n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum0:                                    ;Etiqueta de ciclo que resta cuando numero2 tiene signo negativo \n" +
"    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incrementa bx en 1\n" +
"    loop sisignosum0                            ;Ciclo para restar  \n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion     \n" +
";------------------------------------------------\n" +
";NUMERO MAYOR                                |\n" +
";------------------------------------------------     \n" +
"mayorsum:                                       ;Etiqueta AL es mayor y numero2+0 es menor    \n" +
"    cmp signo1,'-'                              ;Compara el contenido de signo1 con '-'\n" +
"    jz  tienesigno1                             ;Salta a tieneigno1 cuando signo1 es el mayor y es negativo\n" +
"    jnz notienesigno1                           ;Salta a notienesigno1 cuando signo1 es el mayor y no es negativo\n" +
"tienesigno1:                                    ;Etiqueta si signo1 es negativo  y mayor\n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum1:                                    ;Etiqueta de ciclo que resta cuando numero1 tiene signo negativo\n" +
"    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incremeta bx en 1\n" +
"    loop sisignosum1                            ;Ciclo para restar\n" +
"    printmsj signo                              ;Invoca a la macro printmsj para imprimir signo\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion\n" +
"notienesigno1:                                  ;Etiqueta si signo1 es mayor pero no es negativo \n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo2 con '-'\n" +
"    jz  tienesigno3                             ;Salta si signo2 es el menor y es negativo\n" +
"    jnz notienesigno3                           ;Salta cuando signo2 es el menor y no es negativo\n" +
"tienesigno3:                                    ;Etiqueta cuando signo2 es el menor y  es negativo\n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum2:                                    ;Etiqueta de ciclo que resta cuando numero2 tiene signo negativo\n" +
"    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incremeta bx en 1\n" +
"    loop sisignosum2                            ;Ciclo para restar\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion  \n" +
";------------------------------------------------\n" +
";NUMERO MENOR                                 |\n" +
";------------------------------------------------ \n" +
"menorsum:                                       ;Salta si AL es menor y numero2+0 es mayor\n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo1 con '-'\n" +
"    jz  tienesigno2                             ;Salta si signo2 es negativo\n" +
"    jnz notienesigno2                           ;Salta si signo2 no es negativo\n" +
"tienesigno2:                                    ;Etiqueta si signo21 es negativo y mayor\n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum3:                                    ;Etiqueta de ciclo que resta cuando numero1 tiene signo negativo\n" +
"    signo_suma numero1+bx,numero2+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incremeta bx en 1\n" +
"    loop sisignosum3                            ;Ciclo para restar\n" +
"    printmsj signo                              ;Invoca a la macro printmsj para imprimir signo\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion\n" +
"notienesigno2:                                  ;Salta si signo1 es negativo y es menor \n" +
"    cmp signo1,'-'                              ;Comapra el contenido de signo1 con '-'\n" +
"    jz  tienesigno4                             ;Salta si signo1 es negativo y es menor \n" +
"    jnz notienesigno4                           ;Salta si signo1 no es negativo y es menor \n" +
"tienesigno4:                                    ;Etiqueta para  signo1 es negativo y es menor \n" +
"    mov cx,4                                    ;Asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum4:                                    ;Etiqueta de ciclo que resta cuando numero2 tiene signo negativo\n" +
"    signo_suma numero1+bx,numero2+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;Incrementa BX en 1\n" +
"    loop sisignosum4                            ;Ciclo para restar\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion \n" +
"notienesigno0:                                  ;Etiqueta cuando signo1 y signo2 no son negativo\n" +
"notienesigno4:                                  ;Etiqueta cuando signo1 y signo2 no son negativo\n" +
"notienesigno3:                                  ;Etiqueta cuando signo1 y signo2 no son negativo\n" +
"notienesignoneg1:                               ;Etiqueta para cuando signo2 no es negativo\n" +
"tiene2signonegativosum2:                        ;Etiqueta par cuandon ninguno de los 2 numeros tiene signo   \n" +
";------------------------------------------------\n" +
";SUMA NORMAL                                    |\n" +
";------------------------------------------------ \n" +
"	mov cx,4                                    ;Asigna 4 a CX     \n" +
"	mov bx,0                                    ;Asigna 0 a BX\n" +
"	mov ax,0                                    ;Asigna 0 a AX\n" +
"sumaciclo1:                                     ;Ciclo que hace la operacion de sumar\n" +
"    mov al,[numero1+bx]                         ;asigna el contenido de la direccion de memoria dada  por \n" +
"                                                ;el desplazamiento de numero1 mas BX a AL\n" +
"    cmp al,0dh                                  ;Compara AL con 0dh(salto)\n" +
"    jz  sumerror1                               ;Salta a sumerror1 si AL es 0dh\n" +
"    jnz sumerror2                               ;Salta a sumerror2 si AL no es 0dh\n" +
"    cmp al,6bh                                  ;Compara AL con 6bh\n" +
"    jz  sumerror3                               ;Salta a sumerror3 si AL es 6bh\n" +
"    jnz sumerror4                               ;Salta a sumerror4 si AL no es 6bh  \n" +
"sumerror1:                                      ;Etiqueta para AL es 0dh, asigna 0h a AL\n" +
"    mov al,0h                                   ;Asigna 0h a AL \n" +
"sumerror2:                                      ;Etiqueta para AL no es 0dh, no asigna 0h a AL\n" +
"    cmp al,2eh                                  ;Compara AL con 2eh(punto)\n" +
"    jz  puntosum_sa                             ;Salta a puntosum_sa, si AL es 2eh\n" +
"    jnz nopuntosum_sa                           ;Salta a nopuntosum_sa, si AL no es 2eh\n" +
"nopuntosum_sa:                                  ;Etiqueta para AL no es 2eh, no hay punto       \n" +
"    mov sumgua1,al                              ;Asigna el contenido de al a sumgual1                              \n" +
"    mov al,[numero2+bx]                         ;asigna el contenido de la direccion de memoria dada  por \n" +
"                                                ;el desplazamiento de numero2 mas BX a AL\n" +
"    cmp al,2eh                                  ;Compara AL con 2eh(punto)\n" +
"    jz  puntosum_sa1                            ;Salta a puntosum_sa1, si AL es 2eh\n" +
"    jnz nopuntosum_sa1                          ;Salta a nopuntosum_sa1, si AL no es 2eh\n" +
"nopuntosum_sa1:                                 ;Etiqueta para AL no es 2eh, no hay punto\n" +
"    cmp al,0dh                                  ;Compara AL con 0dh(salto)\n" +
"    jz  sumerror3                               ;Salta a sumerror3, si AL es 0dh\n" +
"    jnz sumerror4                               ;Salta a sumerror4, si AL no es 0dh\n" +
"    cmp al,6bh                                  ;Compara AL con 6bh\n" +
"    jz  sumerror3                               ;Salta a sumerror3, si AL es 6bh\n" +
"    jnz sumerror4                               ;Salta a sumerror4, si AL no es 6bh\n" +
"sumerror3:                                      ;Etiqueta para AL es 0dh, asigna 0h a AL\n" +
"    mov al,0h                                   ;Asigna 0h a AL\n" +
"sumerror4:                                      ;Etiqueta para AL no es 0dh, no asigna 0h a AL\n" +
"    add al,ah                                   ;suma AH a AL y lo guarda en AL \n" +
"    mov ah,0h                                   ;Asigna 0h a AH\n" +
"    add al,sumgua1                              ;suma sumgua1 a AL y lo guarda en AL\n" +
"	aaa                                         ;ajuste ascii de la suma \n" +
"	add ax,30h                                  ;suma 30h a AL y lo guarda en AL	 \n" +
"puntosum_sa1:                                   ;Etiqueta para AL es 2eh, hay punto y lo guardamos en resula\n" +
"puntosum_sa:                                    ;Etiqueta para AL es 2eh, hay punto y lo guardamos en resula\n" +
"	mov resula+bx,al                            ;Se asigna AL a la direccion de memoria de resula + bx \n" +
"	inc bx                                      ;Incrementa BX en uno\n" +
"    loop sumaciclo1                             ;Ciclo que hace la operacion de sumar  \n" +
"    salirsignosum:                              ;Etiqueta que termina las operaciones con signo\n" +
"    sumaprint1                                  ;Invoca a la macro sumaprint para imprimir la tabal resula        \n" +
"    ret                                         ;retorna a donde fue llamado el procedimiento\n" +
"suma endp                                       ;finaliza el procedimiento sum\n" +
"\n" +
"resta proc                                 ;procedimiento que efectua la resta\n" +
";-----------------------------------------\n" +
";IMPRIME Y PIDE DATOS                   ||\n" +
";-----------------------------------------    \n" +
";------------------------------------------\n" +
";COMPARA SIGNOS                           |\n" +
";------------------------------------------\n" +
"COMPARA_SIGNOS:                            ;etiqueta que compara los signos\n" +
"    mov dh,[signo1]                        ;mueve el contenido de la direccion de memoria\n" +
"                                           ;dada por signo1\n" +
"    mov dl,[signo2]                        ;mueve el contenido de la direccion de memoria\n" +
"                                           ;dada por signo1\n" +
"    cmp dh,dl                              ;compara dh con dl (los signos) para saltar a\n" +
"    jz  SIH_IGUAL                          ;la etiueta de signos iguales\n" +
"    JMP SIH_DIFE                           ;en caso contario salta a signos diferentes\n" +
"SIH_DIFE:                                  ;etiqueta de signos diferentes\n" +
"    cmp dh,'-'                             ;compara si los signos son positivos o negativos\n" +
"    jz  c_sig1                             ;salta si el premer signo es nehativo\n" +
"    jmp c_sig2                             ;salta si el segundo signo es negativo\n" +
"c_sig2:                                    ;etiqueta cambia el signo de numero2\n" +
"    mov signo2,00h                         ;asigna un signo positivo al numero 2\n" +
"    jmp SALTO_DE_LA_RES                    ;etiqueta que salta a la suma\n" +
"c_sig1:                                    ;etiqueta cambia signo numero1\n" +
"    mov signo2,'-'                         ;asigna un signo negativo al numero2\n" +
"    jmp SALTO_DE_LA_RES                    ;etiqueta que salta a la suma\n" +
"SIH_IGUAL:                                 ;etiqueta si los signos son iguales\n" +
"    cmp dh,'-'                             ;compara signo de numero1 para saltar a la\n" +
"    jz COMPARA_MAYOR                       ;etiqueta que compara el numero mayor\n" +
"    jmp COMPARA_NUMEROS                    ;en caso contrario salta a comparar(para resta)\n" +
"IMPRIME_MENOS:                             ;etiqueta que imprime un sino negativo\n" +
"     printmsj   me_nos                     ;invoca a la macro para imprimir un signo negativo\n" +
"     JMP COMPARA_NUMEROS                   ;salta para comparar numeros(para resta)\n" +
";------------------------------------------\n" +
";COMPARA NUMERO MAYOR                     |\n" +
";------------------------------------------\n" +
"COMPARA_MAYOR:                             ;etiqueta que compara numeros (saber mayor)\n" +
"    mov bx,03h                             ;asigna 03h a bx(repite 3 veces)\n" +
"COM_DEN2:                                  ;etiqueta para comparar de nuevo    \n" +
"    mov dh,[numero1+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a dh dado por numero1+bx (bx=3,2,1,0)\n" +
"    mov dl,[numero2+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a dl dado por numero2+bx (bx=3,2,1,0)\n" +
"    cmp dh,dl                              ;compara dh con dl para saltar a la etiqueta\n" +
"    jg  IMPRIME_MENOS                      ;salta si es mas grande DH(numero1)\n" +
"    jb  RESTA_ALREVES                      ;salta si es mas grande DL(numero2)\n" +
"    dec bx                                 ;decrementa en uno bx(bx=3,2,1,0)\n" +
"    jmp COM_DEN2                           ;salta(regresa) si los numeros son iguales\n" +
"COMPARA_NUMEROS:                           ;compara numeros(para resta invertida)\n" +
"    mov bx,03h                             ;asigna 03h a bx(repite 3 veces)\n" +
"COM_DEN:                                   ;etiqueta para comparar de nuevo\n" +
"    mov dh,[numero1+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a dh dado por numero1+bx (bx=3,2,1,0)\n" +
"    mov dl,[numero2+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a dl dado por numero2+bx (bx=3,2,1,0)\n" +
"    cmp dh,dl                              ;compara dh con dl para saltar a la etiqueta\n" +
"    jg  RESTANOR                           ;salta si es mas grande DH(numero1)(resta normal)\n" +
"    jb  RESTA_ALREVES_S                    ;salta si es mas grande DL(numero2)(resta invertida)\n" +
"    cmp bx,00h                             ;compara si bx es cero(numeros iguales)\n" +
"    jz  RESTANOR                           ;si BX es cero salta a resta normal\n" +
"    dec bx                                 ;decrementa BX en uno\n" +
"    jmp COM_DEN                            ;salta para comparar el sigiente digito\n" +
"RESTANOR:                                  ;etiqueta de resta normal\n" +
"    LEA si,numero1                         ;asigna la direccion de mamoria al registro SI(indice fuente)\n" +
"    LEA dI,numero2                         ;asigna la direcion de memoria al registro DI[indice destino]\n" +
"    mov bx,00h                             ;restablese en ceros a bx\n" +
"    jmp COM_N                              ;salta para comparar numeros\n" +
"RESTA_ALREVES_S:                           ;etiqueta para resta inversa(imprime menos)\n" +
"    printmsj me_nos                        ;invoca a la macro para imptimir un signo menos\n" +
"    JMP RESTA_ALREVES                      ;salta a la resta al incerza\n" +
";------------------------------------------\n" +
";CAMBIA DE ORDEN LOS NUMEROS              |\n" +
";------------------------------------------\n" +
"RESTA_ALREVES:                             ;resta iinverza cambia numeros de pocicion\n" +
"    mov bx,00h                             ;restablese bx en cero\n" +
"repite_al:                                 ;etiqueta que repite 3 veces\n" +
"    mov al,[numero1+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a al dado por numero1+bx(BX=0,1,2,3)\n" +
"    mov [resula+bx],al                     ;mueve el contenido de AL a la direccion de memoria \n" +
"                                           ;dada por resula+bx (BX=0,1,2,3)\n" +
"    mov al,[numero2+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a al dado por numero2+bx(BX=0,1,2,3)\n" +
"    mov [numero1+bx],al                    ;mueve el contenido de AL a la direccion de memoria \n" +
"                                           ;dada por numero1+bx (BX=0,1,2,3)\n" +
"    mov al,[resula+bx]                     ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a al dado por resula+bx(BX=0,1,2,3)\n" +
"    mov [numero2+bx],al                    ;mueve el contenido de AL a la direccion de memoria \n" +
"                                           ;dada por numero2+bx (BX=0,1,2,3)\n" +
"    inc bx                                 ;incrementa bx en uno\n" +
"    cmp bx,04h                             ;compara si bx es igual a 04h para saltar a la \n" +
"    jz  RESTANOR                           ;etiqueta de resta normal\n" +
"    jmp repite_al                          ;salta para repetir 3 veces\n" +
";------------------------------------------\n" +
";COMPARA PARA RESTAR                      |\n" +
";------------------------------------------\n" +
"COM_N:                                     ;etiqueta que compara numeros(acarreo o no)\n" +
"    mov dh,[numero1+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a DH dado por numero1+bx(BX=0,1,2,3)\n" +
"    mov dl,[numero2+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a DL dado por numero2+bx(BX=0,1,2,3)\n" +
"    cmp dh,dl                              ;compara dh con dl\n" +
"    jb RES_INV                             ;salta a la resta con acarreo si dh(numero1) es mayor\n" +
"    jmp  OPE_RESN                          ;salta a la resta normal si DL es mayor(numero2)  \n" +
"    INC bx                                 ;incrementa en uno al registro bx\n" +
"    cmp bx,03H                             ;compara si BX es igual a 03h\n" +
"    jz  RES_CERO                           ;si bx es 03h salta aa imprimir cero(numeros iguales)\n" +
"    cmp dh,dl                              ;compara si dh y dl son iguales\n" +
"    jz  COM_N                              ;si son iguales repite la comparacion\n" +
";------------------------------------------\n" +
";RESULTADO CERO\n" +
";------------------------------------------\n" +
"RES_CERO:                                  ;etiqueta que da resultado cero\n" +
"     JMP IMP_RES2                          ;salta para imprimir resultado\n" +
";------------------------------------------            \n" +
";RESTA NORMAL                             |\n" +
";------------------------------------------ \n" +
"OPE_RESN:                                  ;etiqueta que resta numero 1- numero2\n" +
"    mov ax,00h                             ;restablece AX a cero\n" +
"    mov al,[SI]                            ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por SI\n" +
"    sbb al,[DI]                            ;resta el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por DI\n" +
"    AAS                                    ;ajusta el resultado despues de la resta\n" +
"    mov [resres+bx],AL                     ;mueve el conteniado de AL a la direccion de memoria\n" +
"                                           ;dado por resres+bx(BX=0,1,2,3)\n" +
"    cmp bx,03h                             ;compara el contenido de bx con 03h para saltar a la \n" +
"    jz  IMP_RES2                           ;etiqueta que imprime el resultado\n" +
"    INC SI                                 ;invcrementa en uno a SI(apunta a la siguente pocicon)\n" +
"    INC DI                                 ;invcrementa en uno a DI(apunta a la siguente pocicon)\n" +
"    INC bx                                 ;invcrementa en uno a DX(apunta a la siguente pocicon)\n" +
"    jmp COM_N                              ;repite el proceso tres veces\n" +
";------------------------------------------    \n" +
";RESTA INVERTIDA                          |\n" +
";------------------------------------------    \n" +
"RES_INV:                                   ;etiqueta que efectua resta inverida (acarreo)\n" +
"    mov ax,00h                             ;restablece AX a cero\n" +
"    mov al,[SI]                            ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por SI\n" +
"    ADD AL,10H                             ;suma 10h al contenido de AL\n" +
"    sbb al,[DI]                            ;resta el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por DI\n" +
"    AAS                                    ;ajusta el resultado despues de la resta\n" +
"    mov [resres+bx],AL                     ;mueve el conteniado de AL a la direccion de memoria\n" +
"                                           ;dado por resres+bx(BX=0,1,2,3)\n" +
"    jmp ACARREO_RES                        ;salta para efectuar acarreo\n" +
";------------------------------------------\n" +
";ACARREO                                  |\n" +
";------------------------------------------\n" +
"ACARREO_RES:                               ;etiqueta que efectua acarreo\n" +
"    mov dx,00h                             ;restablece a cero bx\n" +
"    mov dl,[NUMERO1+bx+1]                  ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por numero1+bx+1\n" +
"    cmp dl,00h                             ;compara el contenido de dl con cero pasa altar a la \n" +
"    jz  ACARREO_RES2:                      ;etiqueta que suma una al minuendo\n" +
"    dec dl                                 ;decrementa dl para efectuar acarreo\n" +
"    mov [numero1+bx+1],dl                  ;mueve el conteniado de DL a la direccion de memoria\n" +
"                                           ;dado por numero1+bx+1(BX=0,1,2,3)\n" +
"    cmp bx,03H                             ;compara el contenido de bx con 03h para saltar a la\n" +
"    jz  IMP_RES2                           ;etiqueta que imprime el resultado\n" +
"    inc bx                                 ;invcrementa en uno a BX(apunta a la siguente pocicon)\n" +
"    INC SI                                 ;invcrementa en uno a SI(apunta a la siguente pocicon)\n" +
"    INC DI                                 ;invcrementa en uno a DI(apunta a la siguente pocicon)\n" +
"    jmp COM_N                              ;salta para repetir el proceso 3 veces        \n" +
"ACARREO_RES2:                              ;etiqueta de acarreo que suma al minuendo\n" +
"    MOV dx,00h                             ;restitulle en cero al contenido del registro dx\n" +
"    mov dl,[numero2+bx+1]                  ;asigna a dl el contenido de la direccion de memoria dado\n" +
"                                           ;por el desplasamiento de numero2+bx+1\n" +
"    inc dl                                 ;incrementa en 1 al contenido del registro dl\n" +
"    mov [numero2+bx+1],dl                  ;aigna el contenido de dl en la direccion de memoria \n" +
"                                           ;dada por el desplasamiento de la suma de numero2+bx+1 \n" +
"    cmp bx,03H                             ;compara el contenido de bx con 03h para saltar a la\n" +
"    jz  IMP_RES2                           ;etiqueta que imprime el resultado\n" +
"    inc bx                                 ;invcrementa en uno a BX(apunta a la siguente pocicon)\n" +
"    INC SI                                 ;invcrementa en uno a SI(apunta a la siguente pocicon)\n" +
"    INC DI                                 ;invcrementa en uno a DI(apunta a la siguente pocicon)\n" +
"    jmp COM_N\n" +
"    \n" +
";------------------------------------------\n" +
";IMPRIME EL RESULTADO                     |\n" +
";------------------------------------------        \n" +
"IMP_RES2:                                  ;etiqueta que imprime el resultado\n" +
"   mov  bx,00h                             ;restablece en ceros a BX\n" +
"REPITE_IM:                                 ;etiqueta para mover de resres a resula\n" +
"   mov  dx,00h                             ;restablece en cero a DX\n" +
"   mov  dl,[resres+bx]                     ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a DL dado por resres+bx(BX=0,2,3)\n" +
"   add  dl,30h                             ;suma 30h al contenido de DL(pasa a ASCII)\n" +
"   mov  [resula+bx],dl                     ;mueve el conteniado de DL a la direccion de memoria\n" +
"                                           ;dado por resula+bx(BX=0,1,2,3)\n" +
"   inc  bx                                 ;incrementa bx en uno(BX=0,1,2,3)\n" +
"   cmp  bx,04h                             ;compara en contenido de BX con 04h\n" +
"   jz   MANDAR                             ;si bx es cuatro manda a llamar a la macro\n" +
"   jmp  REPITE_IM                          ;en caso contrario repite el proceso\n" +
";------------------------------------------\n" +
";MANDA A IMPRIMIR                       |||\n" +
";------------------------------------------   \n" +
"MANDAR:                                    ;etiqueta que llama a la macro para imprimir\n" +
"sumaprint1                                 ;invoca a ala macro que imprime el resultado    \n" +
";------------------------------------------\n" +
";BORRA EL CONTENIDO DE LAS VARIABLES  |||||\n" +
";------------------------------------------\n" +
"BORRAR:                                    ;etiqueta que borra el contenido de las variebles\n" +
"    mov signo1,00h                         ;restablece el contenido de signo1 a cero\n" +
"    mov signo2,00h                         ;restablece el contenido de signo2 a cero\n" +
"    mov  bx,00h                            ;restablcece el contenido de bx en cero\n" +
"REPI_CLEAR:                                ;etiqueta que repite el proceso de borrar\n" +
"   mov  dx,00h                             ;restablece en cero el contenido de dx\n" +
"   mov  [resres+bx],00h                    ;mueve 00h a la direccion de memoria\n" +
"                                           ;dado por resres+bx(BX=0,1,2,3)\n" +
"   mov  [resula+bx],00h                    ;mueve 00h a la direccion de memoria\n" +
"                                           ;dado por resula+bx(BX=0,1,2,3)\n" +
"   inc  bx                                 ;incrementa en uno el contenido de BX\n" +
"   cmp  bx,4                               ;compara se es 04h el contenido de BX si lo es\n" +
"   jz   FIN                                ;salta a la etiqueta fin\n" +
"   jmp  REPI_CLEAR                         ;en caso contrario repite el proceso de borrado\n" +
";------------------------------------------\n" +
";FINALIZA LA RESTA                       ||\n" +
";------------------------------------------       \n" +
"FIN:                                       ;etiqueta que finaliza la resta\n" +
"    ret                                    ;retorna a donde fue llamado el procedimiento\n" +
"resta endp        " ;
        try (BufferedWriter archivobf = new BufferedWriter(archivo)) {
            archivo.write(Texto);
        }

}
public void suma_asm_decimal(String in11,String in12,String in13,String in14,String in21,String in22,String in23,String in24) throws FileNotFoundException, UnsupportedEncodingException, IOException{
    FileWriter archivo = new FileWriter("C:/Users/crizs/Desktop/Analizador03/archivo.asm");
            String Texto= "signo_suma macro numsum1,numsum2,contsum             ;Macro con 3 argumentos(numsum1,numsum2,contsum)  \n" +
"                                                     ;Hace la operacion de resta para el signo y lo imprime\n" +
"    LOCAL sumareserror1,sumareserror2                ;Asigna la etiqueta local para sumareserror1,sumareserror2\n" +
"    LOCAL puntosum5,sumareserror3                    ;Asigna la etiqueta local para puntosum5,sumareserror3\n" +
"    LOCAL sumareserror4                              ;Asigna la etiqueta local para sumareserror4\n" +
"    LOCAL restaprestamossum1                         ;Asigna la etiqueta local para restaprestamossum1\n" +
"    LOCAL norestaprestamossum1                       ;Asigna la etiqueta local para norestaprestamossum1\n" +
"    mov al,numsum1                                   ;asigna el contenido de numsum1 a AL\n" +
"    cmp al,2eh                                       ;compara AL con 2eh (.)\n" +
"    jz  puntosum5                                    ;salta si es cero a  puntosum5  \n" +
"    cmp al,0dh                                       ;compara AL con 0d (salto)\n" +
"    jz  sumareserror1                                ;salta si es cero  a sumareserror1\n" +
"    jnz sumareserror2                                ;salta no es a sumareserror2\n" +
"sumareserror1:                                       ;Etiqueta que pone 0 si es 2eh o 0dh\n" +
"    mov al,0h                                        ;asigna 0h a AL\n" +
"sumareserror2:                                       ;Etiqueta que no pone 0 si es 0dh \n" +
"    mov sumgua1,al                                   ;asignael contenido de AL  a sumgua1\n" +
"    mov al,numsum2                                   ;asigna el contenido de la direccion de memoria de numsum2 a AL\n" +
"    cmp al,2eh                                       ;compara AL  con 2eh (.)\n" +
"    jz  puntosum5                                    ;salta si es cero a puntosum5\n" +
"    cmp al,0dh                                       ;compara AL  con 0dh (salto)\n" +
"    jz  sumareserror3                                ;salta si es cero  a sumareserror3 \n" +
"    jnz sumareserror4                                ;salta no si es cero  a sumareserror4 \n" +
"sumareserror3:                                       ;Etiqueta que pone 0 si es 2eh o 0dh\n" +
"    mov al,0h                                        ;asigna 0h a AL\n" +
"sumareserror4:                                       ;Etiqueta que no pone 0 si es 0dh \n" +
"    cmp ah,-1h                                       ;compara AL con -1h para el signo\n" +
"    jz  restaprestamossum1                           ;salta si es cero a restaprestamossum1\n" +
"    jnz norestaprestamossum1                         ;salta si no es cero a norestaprestamossum1\n" +
"restaprestamossum1:                                  ;Etiqueta que indica que se tiene un prestamo\n" +
"    sub al,1                                         ;resta 1 a AL y lo guarda en AL\n" +
"    mov ah,0                                         ;asigna 0 a AH \n" +
"    aas                                              ;ajuste de la resta\n" +
"    add al,30h                                       ;suma 30h a AL y lo guarda en AL\n" +
"norestaprestamossum1:                                ;Etiqueta que indica que no se tiene un prestamo  \n" +
"    sub al,sumgua1                                   ;resta sumgua1 a AL y lo guarda en AL\n" +
"    aas                                              ;ajuste dela resta\n" +
"    add al,30h                                       ;suma 30h a AL y lo guarda en AL\n" +
"puntosum5:                                           ;Etiqueta que guarda el punto en resula\n" +
"    mov resula+contsum,al                            ;Asigna a AL la direccion de memoria de resula+contsum\n" +
"endm                                                 ;fin de la macro signo_suma \n" +
"\n" +
"sumaprint1 macro                                      ;Macro que imprime resula                      \n" +
"    LOCAL excepcisum1,excepcisum2                     ;Asigna la etiqueta local para excepcisum1,excepcisum2\n" +
"    LOCAL excepcisum3,excepcisum4                     ;Asigna la etiqueta local para excepcisum3,excepcisum4\n" +
"    LOCAL quitacerosum1,excepsumpunto                 ;Asigna la etiqueta local para quitacerosum1,excepsumpunto\n" +
"    LOCAL excepsumpunto0,excepsumpunto1               ;Asigna la etiqueta local para excepsumpunto0,excepsumpunto1\n" +
"    LOCAL excepsumpunto2,puntosum0                    ;Asigna la etiqueta local para excepsumpunto2,puntosum0  \n" +
"    LOCAL puntosum1,puntosum2,sinpunto3               ;Asigna la etiqueta local para puntosum1,puntosum2,sinpunto3\n" +
"    LOCAL sumapr,puntosum3,sinpunto2                  ;Asigna la etiqueta local para sumapr,puntosum3,sinpunto2\n" +
"    mov cx,4                                          ;asigna 4 a CX\n" +
"    mov bx,3                                          ;asigna 3 a BX\n" +
"sumapr:                                               ;Ciclo que imprime el contenido de resula                                                                                   \n" +
"    mov al,[resula+bx]                                ;asigna el contenido de la direccion de memoria dada  por \n" +
"                                                      ;el desplazamiento de resula mas BX a AL\n" +
"    cmp bx,0                                          ;compara BX con 0                                         \n" +
"    jz  excepcisum1                                   ;salta si BX es cero a excepcisum1\n" +
"    jnz excepcisum2                                   ;salta si BX  no es cero a excepcisum2  \n" +
"excepcisum2:                                          ;Etiqueta para BX no es cero\n" +
"    cmp bx,3                                          ;compara BX con 3\n" +
"    jz  excepcisum3                                   ;salta si BX es tres a excepcisum3 \n" +
"    jnz excepcisum4                                   ;salta si BX no es tres a excepcisum4\n" +
"excepcisum1:                                          ;Etiqueta para BX es cero como posicion\n" +
"excepcisum3:                                          ;Etiqueta para BX es tres como posicion\n" +
"    cmp al,30h                                        ;compara AL con 30h para eliminar el primer 0 y el ultimo \n" +
"    jz  quitacerosum1                                 ;salta si AL es cero a quitacerosum1\n" +
"excepcisum4:                                          ;Etiqueta para BX no es tres como posicion\n" +
"    mov dl,al                                         ;asigna AL a DL                       \n" +
"    mov ah,02h                                        ;con la funcion 02h                            \n" +
"    int 21h                                           ;de la int 21h (se imprime el numero) \n" +
"    cmp al,2eh                                        ;compara AL con 2eh(punto) \n" +
"    jz  excepsumpunto                                 ;salta si AL  es 2eh a excepsumpunto\n" +
"    jnz excepsumpunto0                                ;salta si AL  es 2eh a excepsumpunto0\n" +
"excepsumpunto0:                                       ;Etiqueta para AL  no es 2eh\n" +
"    cmp bx,2                                          ;compara BX  con 2\n" +
"    jz  excepsumpunto1                                ;salta si BX es dos a excepsumpunto1\n" +
"    jnz excepsumpunto2                                ;salta si BX no es dos a excepsumpunto2\n" +
"excepsumpunto1:                                       ;Etiqueta si BX=2 para poner punto en medio\n" +
"    cmp al,30h                                        ;compara AL con 30h\n" +
"    jz  puntosum0                                     ;salta si AL es 30h a  puntosum0 \n" +
"    jnz puntosum1                                     ;salta si AL no es 30h a puntosum1\n" +
"puntosum1:                                            ;Etiqueta si AL es 30h\n" +
"puntosum0:                                            ;Etiqueta si no es 30h\n" +
"    cmp resula+1,30h                                  ;Compara la direcion de memoria de resula+1 con 30h\n" +
"    jz  puntosum2                                     ;salta si resula+1 es 30h a puntosum2\n" +
"    jnz puntosum3                                     ;salta si resula+1 no es 30h a puntosum3\n" +
"puntosum2:                                            ;Etiqueta para resula+1 es 30h\n" +
"    cmp resula+0,30h                                  ;Compara la direcion de memoria de resula+0 con 30h\n" +
"    jz  sinpunto2                                     ;salta si resula+0 es 30h a sinpunto2\n" +
"    jnz sinpunto3                                     ;salta si resula+0 no es 30h a sinpunto3      \n" +
"sinpunto3:                                            ;Etiqueta si resula+1 no es 30h a puntosum\n" +
"puntosum3:                                            ;Etiqueta si resula+1 no es 30h a puntosum\n" +
"    printmsj punto                                    ;Invoca a la macro para imprimir el contenido de punto                       \n" +
"excepsumpunto2:                                       ;Etiqueta para BX no es posicion dos de la tabla resula \n" +
"excepsumpunto:                                        ;Etiqueta si AL  es 2eh, decrementa a bx en 1\n" +
"quitacerosum1:                                        ;Etiqueta para BX=3,BX=0 no imprime nada y decrementa)\n" +
"    dec bx                                            ;decrementa BX en 1\n" +
"    loop sumapr                                       ;Ciclo que imprime el contenido de resula  \n" +
"sinpunto2:                                            ;Etiqueta que sale del ciclo sin imprimi punto\n" +
"endm                                                  ;fin de la macro sumaprint1 \n" +
"\n" +
"                                                                                       \n" +
"                                                                                       \n" +
";--------------------------------------------------------\n" +
";INICIO                                                 :\n" +
";--------------------------------------------------------\n" +
"inicio macro                                            ;macro que asigna datos a DS \n" +
"    mov ax,data                                         ;asigna la direccion del segmento de datos a AX \n" +
"    mov ds,ax                                           ;y atravesde AX se asigna a DS\n" +
"endm                                                    ;fin de la macro inicio        \n" +
";--------------------------------------------------------\n" +
";FIN                                                    :\n" +
";--------------------------------------------------------\n" +
"fin macro                                               ;macro que devuelve el control al DOS\n" +
"    mov ax,4c00h                                        ;asigna la funcion 4c00 de la\n" +
"    int 21h                                             ;INT 21h a AX y se devuelve el control al DOS\n" +
"endm                                                    ;fin de la macro fin    \n" +
";--------------------------------------------------------\n" +
";LIMPIAR                                                :\n" +
";--------------------------------------------------------\n" +
"limpant MACRO                                           ;macro que limpia la pantalla\n" +
"    mov ah,0Fh                                          ;funcion 0f (obtiene modo de video)\n" +
"    int 10h                                             ;de la int 10h \n" +
"    mov ah,0                                            ;funcion 0 (cambia el modo video) de la\n" +
"    int 10h                                             ;int 10h (es decir las 4 instrucciones borran la pantalla)\n" +
"ENDM                                                    ;fin de la macro limpant   \n" +
";--------------------------------------------------------\n" +
";IMPRIMIR                                               :\n" +
";--------------------------------------------------------\n" +
"printmsj MACRO mensa                                    ;macro que imprime mensaje\n" +
"    lea dx,mensa                                        ;asigna la direccion inicial de desplazamiento\n" +
"                                                        ;de la localidad de memoria mensa al registro DX(DS:DX)\n" +
"    mov ah,09                                           ;asigna la funcion 09 de la INT 21h\n" +
"    int 21h                                             ;a AH(aparece mensaje en pantalla)\n" +
"ENDM                                                    ;fin de la macro printmsj \n" +
"                                                                                       \n" +
"\n" +
";--------------------------------------------------------                                     \n" +
"    .model small                                        ;define el modelo de memoria\n" +
"	.stack                                              ;define area de pila\n" +
"	.data                                               ;define el area de datos\n" +
";--------------------------------------------------------\n" +
";SEGMENTO DE DATOS                                      :\n" +
";--------------------------------------------------------\n" +
"numero1 db  "+in14+","+in13+","+in12+","+in11        + ";se define la tabla numero1\n" +
"numero2 db  " +in24+","+in23+","+in22+","+in21+                                 ";se define la tabla numero2\n" +
"resula  db  0,0,0,0                                     ;se define la tabla resula\n" +
"resres  db  30,30,30,30                                 ;se define la tabla resres\n" +
"signo1  db  02,00,00,02                                           ;se define la variable signo1\n" +
"signo2  db  ?                                           ;se define la variable signo2\n" +
"signor  db  ?                                           ;se define la variable signor\n" +
"signo   db  '-$'                                        ;asigna la cadena a la variable signo\n" +
"punto   db  '.$'                                        ;asigna la cadena a la variable punto\n" +
"me_nos  db '-$'\n" +
"sumgua1 db  0                                           ;se define la variable sumgua1\n" +
"sumgua2 db  0                                           ;se define la variable sumgua2\n" +
".code                                               ;define area de codigo                      \n" +
"inicia: \n" +
"inicio  \n" +

"call suma    \n" +
"fin\n" +
"\n" +
"endp inicia        \n" +
"        \n" +
"        \n" +
"suma proc                                       ;Procedimiento para Suma\n" +
"                            ;Invoca a la macro que imprime mensaje \n" +
"SALTO_DE_LA_RES:                                ;Salto que viene de la resta\n" +
";------------------------------------------------\n" +
";COMPARA SIGNOS                                 |\n" +
";------------------------------------------------   \n" +
"    mov ax,0h                                   ;Asigna 0 a AX        \n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo2 sea signo negativo \n" +
"    jz  tienesignonegativosum                   ;Salta si signo2 tiene signo negativo\n" +
"    jnz notienesignonegsum                      ;Salta si signo2 no tiene signo negativo\n" +
"tienesignonegativosum:                          ;Etiqueta para sign2 es negativo\n" +
"    cmp signo1,'-'                              ;Compara el contenido de signo1 sea signo negativo\n" +
"    jz  tiene2signonegativosum                  ;Salta si signo1 tiene signo negativo\n" +
"    jnz notiene2signonegsum                     ;Salta si signo1 no tiene signo negativo\n" +
"tiene2signonegativosum:                         ;Etiqueta para cuando signo1 no tiene signo negativo\n" +
"    printmsj signo                              ;Invoca a la marco para imprimir signo\n" +
"    jmp tiene2signonegativosum2                 ;Salta a suma normal por que no hay negativos\n" +
"notienesignonegsum:                             ;Etiqueta para signo2 no es negativo\n" +
"    cmp signo1,'-'                              ;Compara el contenido de signo1 sea signo negativo\n" +
"    jz  tienesignonegativosum1                  ;Salta si signo1 tiene signo negativo\n" +
"    jnz notienesignoneg1                        ;Salta si signo1 no tiene signo negativo\n" +
"notiene2signonegsum:                            ;Etiqeuta para cuando signo1 no es negativo\n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo2 con '-'\n" +
"    jz  tienesignonegativosum1                  ;Salta si el contenido de signo2 es negativo\n" +
"    jnz notienesignoneg1                        ;Salta si el contnenido de signo2 no es negativo\n" +
"tienesignonegativosum1:                         ;Etiqueta para cuando signo2 es negativo\n" +
"    mov al,numero1+3                            ;Asigna el contenido de la direccion de memoira de numero1+3 a AL\n" +
"    cmp al,numero2+3                            ;Compara el contenido de numero1+3 con AL\n" +
"    ja  mayorsum                                ;Salta si AL es mayor y numero2+3 es menor\n" +
"    jb  menorsum                                ;Salta  si AL es menor y numero2+3 es mayor\n" +
"    je  verificarsegnumero                      ;Salta si son iguales \n" +
"verificarsegnumero:                             ;Etiqueta si son iguales va verifcando numero por numero\n" +
"    mov al,numero1+2                            ;Asigna el contenido de la direccion de memoira de numero1+2 a AL\n" +
"    cmp al,numero2+2 ;                          ;Compara el contenido de numero1+2 con AL\n" +
"    ja  mayorsum                                ;Salta si AL es mayor y numero2+2 es menor\n" +
"    jb  menorsum                                ;Salta  si AL es menor y numero2+2 es mayor\n" +
"    je  verificarsegnumero1                     ;Salta si son iguales     \n" +
"verificarsegnumero1:                            ;Etiqueta si son iguales va verifcando numero por numero\n" +
"    mov al,numero1+1                            ;Asigna el contenido de la direccion de memoira de numero1+1 a AL\n" +
"    cmp al,numero2+1                            ;Compara el contenido de numero1+1 con AL\n" +
"    ja  mayorsum                                ;Salta si AL es mayor y numero2+1 es menor\n" +
"    jb  menorsum                                ;Salta  si AL es menor y numero2+1 es mayor\n" +
"    je  verificarssegnumero2                    ;Salta si son iguales \n" +
"verificarssegnumero2:                           ;Etiqueta si son iguales va verifcando numero por numero\n" +
"    mov al,numero1+0                            ;Asigna el contenido de la direccion de memoira de numero1+0 a AL\n" +
"    cmp al,numero2+0                            ;Compara el contenido de numero1+0 con AL\n" +
"    ja  mayorsum                                ;Salta si AL es mayor y numero2+0 es menor\n" +
"    jb  menorsum                                ;Salta  si AL es menor y numero2+0 es mayor\n" +
"    je  igualsum                                ;Salta si son iguales  \n" +
";------------------------------------------------\n" +
";NUMEROS IGUALES                                 |\n" +
";------------------------------------------------ \n" +
"igualsum:                                       ;Etiqueta si son numeros iguales \n" +
"    cmp signo1,'-'                              ;Compara el contenido de signo1 con '-'\n" +
"    jz  tienesigno00                            ;Salta si signo1 es negativo\n" +
"    jnz notienesigno00                          ;Salta si signo1 no es negativo\n" +
"tienesigno00:                                   ;Etiqueta si signo1 es negativo\n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum00:                                   ;Etiqueta de Ciclo que resta cuando numero 1 tiene signpo negativo  \n" +
"    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incrementa BX en 1\n" +
"    loop sisignosum00                           ;Ciclo que resta cuando los numeros son iguales\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion\n" +
"notienesigno00:                                 ;Etiqueta si el signo1 no es negativo\n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo2 con '-'\n" +
"    jz  tienesigno0                             ;Salta si signo2 es negativo \n" +
"    jnz notienesigno0                           ;Salta si signo2 no es negativo\n" +
"tienesigno0:                                    ;Etiqueta si signo2 es negativo           \n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum0:                                    ;Etiqueta de ciclo que resta cuando numero2 tiene signo negativo \n" +
"    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incrementa bx en 1\n" +
"    loop sisignosum0                            ;Ciclo para restar  \n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion     \n" +
";------------------------------------------------\n" +
";NUMERO MAYOR                                |\n" +
";------------------------------------------------     \n" +
"mayorsum:                                       ;Etiqueta AL es mayor y numero2+0 es menor    \n" +
"    cmp signo1,'-'                              ;Compara el contenido de signo1 con '-'\n" +
"    jz  tienesigno1                             ;Salta a tieneigno1 cuando signo1 es el mayor y es negativo\n" +
"    jnz notienesigno1                           ;Salta a notienesigno1 cuando signo1 es el mayor y no es negativo\n" +
"tienesigno1:                                    ;Etiqueta si signo1 es negativo  y mayor\n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum1:                                    ;Etiqueta de ciclo que resta cuando numero1 tiene signo negativo\n" +
"    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incremeta bx en 1\n" +
"    loop sisignosum1                            ;Ciclo para restar\n" +
"    printmsj signo                              ;Invoca a la macro printmsj para imprimir signo\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion\n" +
"notienesigno1:                                  ;Etiqueta si signo1 es mayor pero no es negativo \n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo2 con '-'\n" +
"    jz  tienesigno3                             ;Salta si signo2 es el menor y es negativo\n" +
"    jnz notienesigno3                           ;Salta cuando signo2 es el menor y no es negativo\n" +
"tienesigno3:                                    ;Etiqueta cuando signo2 es el menor y  es negativo\n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum2:                                    ;Etiqueta de ciclo que resta cuando numero2 tiene signo negativo\n" +
"    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incremeta bx en 1\n" +
"    loop sisignosum2                            ;Ciclo para restar\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion  \n" +
";------------------------------------------------\n" +
";NUMERO MENOR                                 |\n" +
";------------------------------------------------ \n" +
"menorsum:                                       ;Salta si AL es menor y numero2+0 es mayor\n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo1 con '-'\n" +
"    jz  tienesigno2                             ;Salta si signo2 es negativo\n" +
"    jnz notienesigno2                           ;Salta si signo2 no es negativo\n" +
"tienesigno2:                                    ;Etiqueta si signo21 es negativo y mayor\n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum3:                                    ;Etiqueta de ciclo que resta cuando numero1 tiene signo negativo\n" +
"    signo_suma numero1+bx,numero2+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incremeta bx en 1\n" +
"    loop sisignosum3                            ;Ciclo para restar\n" +
"    printmsj signo                              ;Invoca a la macro printmsj para imprimir signo\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion\n" +
"notienesigno2:                                  ;Salta si signo1 es negativo y es menor \n" +
"    cmp signo1,'-'                              ;Comapra el contenido de signo1 con '-'\n" +
"    jz  tienesigno4                             ;Salta si signo1 es negativo y es menor \n" +
"    jnz notienesigno4                           ;Salta si signo1 no es negativo y es menor \n" +
"tienesigno4:                                    ;Etiqueta para  signo1 es negativo y es menor \n" +
"    mov cx,4                                    ;Asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum4:                                    ;Etiqueta de ciclo que resta cuando numero2 tiene signo negativo\n" +
"    signo_suma numero1+bx,numero2+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;Incrementa BX en 1\n" +
"    loop sisignosum4                            ;Ciclo para restar\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion \n" +
"notienesigno0:                                  ;Etiqueta cuando signo1 y signo2 no son negativo\n" +
"notienesigno4:                                  ;Etiqueta cuando signo1 y signo2 no son negativo\n" +
"notienesigno3:                                  ;Etiqueta cuando signo1 y signo2 no son negativo\n" +
"notienesignoneg1:                               ;Etiqueta para cuando signo2 no es negativo\n" +
"tiene2signonegativosum2:                        ;Etiqueta par cuandon ninguno de los 2 numeros tiene signo   \n" +
";------------------------------------------------\n" +
";SUMA NORMAL                                    |\n" +
";------------------------------------------------ \n" +
"	mov cx,4                                    ;Asigna 4 a CX     \n" +
"	mov bx,0                                    ;Asigna 0 a BX\n" +
"	mov ax,0                                    ;Asigna 0 a AX\n" +
"sumaciclo1:                                     ;Ciclo que hace la operacion de sumar\n" +
"    mov al,[numero1+bx]                         ;asigna el contenido de la direccion de memoria dada  por \n" +
"                                                ;el desplazamiento de numero1 mas BX a AL\n" +
"    cmp al,0dh                                  ;Compara AL con 0dh(salto)\n" +
"    jz  sumerror1                               ;Salta a sumerror1 si AL es 0dh\n" +
"    jnz sumerror2                               ;Salta a sumerror2 si AL no es 0dh\n" +
"    cmp al,6bh                                  ;Compara AL con 6bh\n" +
"    jz  sumerror3                               ;Salta a sumerror3 si AL es 6bh\n" +
"    jnz sumerror4                               ;Salta a sumerror4 si AL no es 6bh  \n" +
"sumerror1:                                      ;Etiqueta para AL es 0dh, asigna 0h a AL\n" +
"    mov al,0h                                   ;Asigna 0h a AL \n" +
"sumerror2:                                      ;Etiqueta para AL no es 0dh, no asigna 0h a AL\n" +
"    cmp al,2eh                                  ;Compara AL con 2eh(punto)\n" +
"    jz  puntosum_sa                             ;Salta a puntosum_sa, si AL es 2eh\n" +
"    jnz nopuntosum_sa                           ;Salta a nopuntosum_sa, si AL no es 2eh\n" +
"nopuntosum_sa:                                  ;Etiqueta para AL no es 2eh, no hay punto       \n" +
"    mov sumgua1,al                              ;Asigna el contenido de al a sumgual1                              \n" +
"    mov al,[numero2+bx]                         ;asigna el contenido de la direccion de memoria dada  por \n" +
"                                                ;el desplazamiento de numero2 mas BX a AL\n" +
"    cmp al,2eh                                  ;Compara AL con 2eh(punto)\n" +
"    jz  puntosum_sa1                            ;Salta a puntosum_sa1, si AL es 2eh\n" +
"    jnz nopuntosum_sa1                          ;Salta a nopuntosum_sa1, si AL no es 2eh\n" +
"nopuntosum_sa1:                                 ;Etiqueta para AL no es 2eh, no hay punto\n" +
"    cmp al,0dh                                  ;Compara AL con 0dh(salto)\n" +
"    jz  sumerror3                               ;Salta a sumerror3, si AL es 0dh\n" +
"    jnz sumerror4                               ;Salta a sumerror4, si AL no es 0dh\n" +
"    cmp al,6bh                                  ;Compara AL con 6bh\n" +
"    jz  sumerror3                               ;Salta a sumerror3, si AL es 6bh\n" +
"    jnz sumerror4                               ;Salta a sumerror4, si AL no es 6bh\n" +
"sumerror3:                                      ;Etiqueta para AL es 0dh, asigna 0h a AL\n" +
"    mov al,0h                                   ;Asigna 0h a AL\n" +
"sumerror4:                                      ;Etiqueta para AL no es 0dh, no asigna 0h a AL\n" +
"    add al,ah                                   ;suma AH a AL y lo guarda en AL \n" +
"    mov ah,0h                                   ;Asigna 0h a AH\n" +
"    add al,sumgua1                              ;suma sumgua1 a AL y lo guarda en AL\n" +
"	aaa                                         ;ajuste ascii de la suma \n" +
"	add ax,30h                                  ;suma 30h a AL y lo guarda en AL	 \n" +
"puntosum_sa1:                                   ;Etiqueta para AL es 2eh, hay punto y lo guardamos en resula\n" +
"puntosum_sa:                                    ;Etiqueta para AL es 2eh, hay punto y lo guardamos en resula\n" +
"	mov resula+bx,al                            ;Se asigna AL a la direccion de memoria de resula + bx \n" +
"	inc bx                                      ;Incrementa BX en uno\n" +
"    loop sumaciclo1                             ;Ciclo que hace la operacion de sumar  \n" +
"    salirsignosum:                              ;Etiqueta que termina las operaciones con signo\n" +
"    sumaprint1                                  ;Invoca a la macro sumaprint para imprimir la tabal resula        \n" +
"    ret                                         ;retorna a donde fue llamado el procedimiento\n" +
"suma endp                                       ;finaliza el procedimiento sum\n" +
"\n" +
"resta proc                                 ;procedimiento que efectua la resta\n" +
";-----------------------------------------\n" +
";IMPRIME Y PIDE DATOS                   ||\n" +
";-----------------------------------------    \n" +
";------------------------------------------\n" +
";COMPARA SIGNOS                           |\n" +
";------------------------------------------\n" +
"COMPARA_SIGNOS:                            ;etiqueta que compara los signos\n" +
"    mov dh,[signo1]                        ;mueve el contenido de la direccion de memoria\n" +
"                                           ;dada por signo1\n" +
"    mov dl,[signo2]                        ;mueve el contenido de la direccion de memoria\n" +
"                                           ;dada por signo1\n" +
"    cmp dh,dl                              ;compara dh con dl (los signos) para saltar a\n" +
"    jz  SIH_IGUAL                          ;la etiueta de signos iguales\n" +
"    JMP SIH_DIFE                           ;en caso contario salta a signos diferentes\n" +
"SIH_DIFE:                                  ;etiqueta de signos diferentes\n" +
"    cmp dh,'-'                             ;compara si los signos son positivos o negativos\n" +
"    jz  c_sig1                             ;salta si el premer signo es nehativo\n" +
"    jmp c_sig2                             ;salta si el segundo signo es negativo\n" +
"c_sig2:                                    ;etiqueta cambia el signo de numero2\n" +
"    mov signo2,00h                         ;asigna un signo positivo al numero 2\n" +
"    jmp SALTO_DE_LA_RES                    ;etiqueta que salta a la suma\n" +
"c_sig1:                                    ;etiqueta cambia signo numero1\n" +
"    mov signo2,'-'                         ;asigna un signo negativo al numero2\n" +
"    jmp SALTO_DE_LA_RES                    ;etiqueta que salta a la suma\n" +
"SIH_IGUAL:                                 ;etiqueta si los signos son iguales\n" +
"    cmp dh,'-'                             ;compara signo de numero1 para saltar a la\n" +
"    jz COMPARA_MAYOR                       ;etiqueta que compara el numero mayor\n" +
"    jmp COMPARA_NUMEROS                    ;en caso contrario salta a comparar(para resta)\n" +
"IMPRIME_MENOS:                             ;etiqueta que imprime un sino negativo\n" +
"     printmsj   me_nos                     ;invoca a la macro para imprimir un signo negativo\n" +
"     JMP COMPARA_NUMEROS                   ;salta para comparar numeros(para resta)\n" +
";------------------------------------------\n" +
";COMPARA NUMERO MAYOR                     |\n" +
";------------------------------------------\n" +
"COMPARA_MAYOR:                             ;etiqueta que compara numeros (saber mayor)\n" +
"    mov bx,03h                             ;asigna 03h a bx(repite 3 veces)\n" +
"COM_DEN2:                                  ;etiqueta para comparar de nuevo    \n" +
"    mov dh,[numero1+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a dh dado por numero1+bx (bx=3,2,1,0)\n" +
"    mov dl,[numero2+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a dl dado por numero2+bx (bx=3,2,1,0)\n" +
"    cmp dh,dl                              ;compara dh con dl para saltar a la etiqueta\n" +
"    jg  IMPRIME_MENOS                      ;salta si es mas grande DH(numero1)\n" +
"    jb  RESTA_ALREVES                      ;salta si es mas grande DL(numero2)\n" +
"    dec bx                                 ;decrementa en uno bx(bx=3,2,1,0)\n" +
"    jmp COM_DEN2                           ;salta(regresa) si los numeros son iguales\n" +
"COMPARA_NUMEROS:                           ;compara numeros(para resta invertida)\n" +
"    mov bx,03h                             ;asigna 03h a bx(repite 3 veces)\n" +
"COM_DEN:                                   ;etiqueta para comparar de nuevo\n" +
"    mov dh,[numero1+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a dh dado por numero1+bx (bx=3,2,1,0)\n" +
"    mov dl,[numero2+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a dl dado por numero2+bx (bx=3,2,1,0)\n" +
"    cmp dh,dl                              ;compara dh con dl para saltar a la etiqueta\n" +
"    jg  RESTANOR                           ;salta si es mas grande DH(numero1)(resta normal)\n" +
"    jb  RESTA_ALREVES_S                    ;salta si es mas grande DL(numero2)(resta invertida)\n" +
"    cmp bx,00h                             ;compara si bx es cero(numeros iguales)\n" +
"    jz  RESTANOR                           ;si BX es cero salta a resta normal\n" +
"    dec bx                                 ;decrementa BX en uno\n" +
"    jmp COM_DEN                            ;salta para comparar el sigiente digito\n" +
"RESTANOR:                                  ;etiqueta de resta normal\n" +
"    LEA si,numero1                         ;asigna la direccion de mamoria al registro SI(indice fuente)\n" +
"    LEA dI,numero2                         ;asigna la direcion de memoria al registro DI[indice destino]\n" +
"    mov bx,00h                             ;restablese en ceros a bx\n" +
"    jmp COM_N                              ;salta para comparar numeros\n" +
"RESTA_ALREVES_S:                           ;etiqueta para resta inversa(imprime menos)\n" +
"    printmsj me_nos                        ;invoca a la macro para imptimir un signo menos\n" +
"    JMP RESTA_ALREVES                      ;salta a la resta al incerza\n" +
";------------------------------------------\n" +
";CAMBIA DE ORDEN LOS NUMEROS              |\n" +
";------------------------------------------\n" +
"RESTA_ALREVES:                             ;resta iinverza cambia numeros de pocicion\n" +
"    mov bx,00h                             ;restablese bx en cero\n" +
"repite_al:                                 ;etiqueta que repite 3 veces\n" +
"    mov al,[numero1+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a al dado por numero1+bx(BX=0,1,2,3)\n" +
"    mov [resula+bx],al                     ;mueve el contenido de AL a la direccion de memoria \n" +
"                                           ;dada por resula+bx (BX=0,1,2,3)\n" +
"    mov al,[numero2+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a al dado por numero2+bx(BX=0,1,2,3)\n" +
"    mov [numero1+bx],al                    ;mueve el contenido de AL a la direccion de memoria \n" +
"                                           ;dada por numero1+bx (BX=0,1,2,3)\n" +
"    mov al,[resula+bx]                     ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a al dado por resula+bx(BX=0,1,2,3)\n" +
"    mov [numero2+bx],al                    ;mueve el contenido de AL a la direccion de memoria \n" +
"                                           ;dada por numero2+bx (BX=0,1,2,3)\n" +
"    inc bx                                 ;incrementa bx en uno\n" +
"    cmp bx,04h                             ;compara si bx es igual a 04h para saltar a la \n" +
"    jz  RESTANOR                           ;etiqueta de resta normal\n" +
"    jmp repite_al                          ;salta para repetir 3 veces\n" +
";------------------------------------------\n" +
";COMPARA PARA RESTAR                      |\n" +
";------------------------------------------\n" +
"COM_N:                                     ;etiqueta que compara numeros(acarreo o no)\n" +
"    mov dh,[numero1+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a DH dado por numero1+bx(BX=0,1,2,3)\n" +
"    mov dl,[numero2+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a DL dado por numero2+bx(BX=0,1,2,3)\n" +
"    cmp dh,dl                              ;compara dh con dl\n" +
"    jb RES_INV                             ;salta a la resta con acarreo si dh(numero1) es mayor\n" +
"    jmp  OPE_RESN                          ;salta a la resta normal si DL es mayor(numero2)  \n" +
"    INC bx                                 ;incrementa en uno al registro bx\n" +
"    cmp bx,03H                             ;compara si BX es igual a 03h\n" +
"    jz  RES_CERO                           ;si bx es 03h salta aa imprimir cero(numeros iguales)\n" +
"    cmp dh,dl                              ;compara si dh y dl son iguales\n" +
"    jz  COM_N                              ;si son iguales repite la comparacion\n" +
";------------------------------------------\n" +
";RESULTADO CERO\n" +
";------------------------------------------\n" +
"RES_CERO:                                  ;etiqueta que da resultado cero\n" +
"     JMP IMP_RES2                          ;salta para imprimir resultado\n" +
";------------------------------------------            \n" +
";RESTA NORMAL                             |\n" +
";------------------------------------------ \n" +
"OPE_RESN:                                  ;etiqueta que resta numero 1- numero2\n" +
"    mov ax,00h                             ;restablece AX a cero\n" +
"    mov al,[SI]                            ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por SI\n" +
"    sbb al,[DI]                            ;resta el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por DI\n" +
"    AAS                                    ;ajusta el resultado despues de la resta\n" +
"    mov [resres+bx],AL                     ;mueve el conteniado de AL a la direccion de memoria\n" +
"                                           ;dado por resres+bx(BX=0,1,2,3)\n" +
"    cmp bx,03h                             ;compara el contenido de bx con 03h para saltar a la \n" +
"    jz  IMP_RES2                           ;etiqueta que imprime el resultado\n" +
"    INC SI                                 ;invcrementa en uno a SI(apunta a la siguente pocicon)\n" +
"    INC DI                                 ;invcrementa en uno a DI(apunta a la siguente pocicon)\n" +
"    INC bx                                 ;invcrementa en uno a DX(apunta a la siguente pocicon)\n" +
"    jmp COM_N                              ;repite el proceso tres veces\n" +
";------------------------------------------    \n" +
";RESTA INVERTIDA                          |\n" +
";------------------------------------------    \n" +
"RES_INV:                                   ;etiqueta que efectua resta inverida (acarreo)\n" +
"    mov ax,00h                             ;restablece AX a cero\n" +
"    mov al,[SI]                            ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por SI\n" +
"    ADD AL,10H                             ;suma 10h al contenido de AL\n" +
"    sbb al,[DI]                            ;resta el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por DI\n" +
"    AAS                                    ;ajusta el resultado despues de la resta\n" +
"    mov [resres+bx],AL                     ;mueve el conteniado de AL a la direccion de memoria\n" +
"                                           ;dado por resres+bx(BX=0,1,2,3)\n" +
"    jmp ACARREO_RES                        ;salta para efectuar acarreo\n" +
";------------------------------------------\n" +
";ACARREO                                  |\n" +
";------------------------------------------\n" +
"ACARREO_RES:                               ;etiqueta que efectua acarreo\n" +
"    mov dx,00h                             ;restablece a cero bx\n" +
"    mov dl,[NUMERO1+bx+1]                  ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por numero1+bx+1\n" +
"    cmp dl,00h                             ;compara el contenido de dl con cero pasa altar a la \n" +
"    jz  ACARREO_RES2:                      ;etiqueta que suma una al minuendo\n" +
"    dec dl                                 ;decrementa dl para efectuar acarreo\n" +
"    mov [numero1+bx+1],dl                  ;mueve el conteniado de DL a la direccion de memoria\n" +
"                                           ;dado por numero1+bx+1(BX=0,1,2,3)\n" +
"    cmp bx,03H                             ;compara el contenido de bx con 03h para saltar a la\n" +
"    jz  IMP_RES2                           ;etiqueta que imprime el resultado\n" +
"    inc bx                                 ;invcrementa en uno a BX(apunta a la siguente pocicon)\n" +
"    INC SI                                 ;invcrementa en uno a SI(apunta a la siguente pocicon)\n" +
"    INC DI                                 ;invcrementa en uno a DI(apunta a la siguente pocicon)\n" +
"    jmp COM_N                              ;salta para repetir el proceso 3 veces        \n" +
"ACARREO_RES2:                              ;etiqueta de acarreo que suma al minuendo\n" +
"    MOV dx,00h                             ;restitulle en cero al contenido del registro dx\n" +
"    mov dl,[numero2+bx+1]                  ;asigna a dl el contenido de la direccion de memoria dado\n" +
"                                           ;por el desplasamiento de numero2+bx+1\n" +
"    inc dl                                 ;incrementa en 1 al contenido del registro dl\n" +
"    mov [numero2+bx+1],dl                  ;aigna el contenido de dl en la direccion de memoria \n" +
"                                           ;dada por el desplasamiento de la suma de numero2+bx+1 \n" +
"    cmp bx,03H                             ;compara el contenido de bx con 03h para saltar a la\n" +
"    jz  IMP_RES2                           ;etiqueta que imprime el resultado\n" +
"    inc bx                                 ;invcrementa en uno a BX(apunta a la siguente pocicon)\n" +
"    INC SI                                 ;invcrementa en uno a SI(apunta a la siguente pocicon)\n" +
"    INC DI                                 ;invcrementa en uno a DI(apunta a la siguente pocicon)\n" +
"    jmp COM_N\n" +
"    \n" +
";------------------------------------------\n" +
";IMPRIME EL RESULTADO                     |\n" +
";------------------------------------------        \n" +
"IMP_RES2:                                  ;etiqueta que imprime el resultado\n" +
"   mov  bx,00h                             ;restablece en ceros a BX\n" +
"REPITE_IM:                                 ;etiqueta para mover de resres a resula\n" +
"   mov  dx,00h                             ;restablece en cero a DX\n" +
"   mov  dl,[resres+bx]                     ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a DL dado por resres+bx(BX=0,2,3)\n" +
"   add  dl,30h                             ;suma 30h al contenido de DL(pasa a ASCII)\n" +
"   mov  [resula+bx],dl                     ;mueve el conteniado de DL a la direccion de memoria\n" +
"                                           ;dado por resula+bx(BX=0,1,2,3)\n" +
"   inc  bx                                 ;incrementa bx en uno(BX=0,1,2,3)\n" +
"   cmp  bx,04h                             ;compara en contenido de BX con 04h\n" +
"   jz   MANDAR                             ;si bx es cuatro manda a llamar a la macro\n" +
"   jmp  REPITE_IM                          ;en caso contrario repite el proceso\n" +
";------------------------------------------\n" +
";MANDA A IMPRIMIR                       |||\n" +
";------------------------------------------   \n" +
"MANDAR:                                    ;etiqueta que llama a la macro para imprimir\n" +
"sumaprint1                                 ;invoca a ala macro que imprime el resultado    \n" +
";------------------------------------------\n" +
";BORRA EL CONTENIDO DE LAS VARIABLES  |||||\n" +
";------------------------------------------\n" +
"BORRAR:                                    ;etiqueta que borra el contenido de las variebles\n" +
"    mov signo1,00h                         ;restablece el contenido de signo1 a cero\n" +
"    mov signo2,00h                         ;restablece el contenido de signo2 a cero\n" +
"    mov  bx,00h                            ;restablcece el contenido de bx en cero\n" +
"REPI_CLEAR:                                ;etiqueta que repite el proceso de borrar\n" +
"   mov  dx,00h                             ;restablece en cero el contenido de dx\n" +
"   mov  [resres+bx],00h                    ;mueve 00h a la direccion de memoria\n" +
"                                           ;dado por resres+bx(BX=0,1,2,3)\n" +
"   mov  [resula+bx],00h                    ;mueve 00h a la direccion de memoria\n" +
"                                           ;dado por resula+bx(BX=0,1,2,3)\n" +
"   inc  bx                                 ;incrementa en uno el contenido de BX\n" +
"   cmp  bx,4                               ;compara se es 04h el contenido de BX si lo es\n" +
"   jz   FIN                                ;salta a la etiqueta fin\n" +
"   jmp  REPI_CLEAR                         ;en caso contrario repite el proceso de borrado\n" +
";------------------------------------------\n" +
";FINALIZA LA RESTA                       ||\n" +
";------------------------------------------       \n" +
"FIN:                                       ;etiqueta que finaliza la resta\n" +
"    ret                                    ;retorna a donde fue llamado el procedimiento\n" +
"resta endp        " ;
        try (BufferedWriter archivobf = new BufferedWriter(archivo)) {
            archivo.write(Texto);
        }
}
public void resta_asm_decimal(String in11,String in12,String in13,String in14,String in21,String in22,String in23,String in24) throws FileNotFoundException, UnsupportedEncodingException, IOException{
    FileWriter archivo = new FileWriter("C:/Users/crizs/Desktop/Analizador03/archivo.asm");
            String Texto= "signo_suma macro numsum1,numsum2,contsum             ;Macro con 3 argumentos(numsum1,numsum2,contsum)  \n" +
"                                                     ;Hace la operacion de resta para el signo y lo imprime\n" +
"    LOCAL sumareserror1,sumareserror2                ;Asigna la etiqueta local para sumareserror1,sumareserror2\n" +
"    LOCAL puntosum5,sumareserror3                    ;Asigna la etiqueta local para puntosum5,sumareserror3\n" +
"    LOCAL sumareserror4                              ;Asigna la etiqueta local para sumareserror4\n" +
"    LOCAL restaprestamossum1                         ;Asigna la etiqueta local para restaprestamossum1\n" +
"    LOCAL norestaprestamossum1                       ;Asigna la etiqueta local para norestaprestamossum1\n" +
"    mov al,numsum1                                   ;asigna el contenido de numsum1 a AL\n" +
"    cmp al,2eh                                       ;compara AL con 2eh (.)\n" +
"    jz  puntosum5                                    ;salta si es cero a  puntosum5  \n" +
"    cmp al,0dh                                       ;compara AL con 0d (salto)\n" +
"    jz  sumareserror1                                ;salta si es cero  a sumareserror1\n" +
"    jnz sumareserror2                                ;salta no es a sumareserror2\n" +
"sumareserror1:                                       ;Etiqueta que pone 0 si es 2eh o 0dh\n" +
"    mov al,0h                                        ;asigna 0h a AL\n" +
"sumareserror2:                                       ;Etiqueta que no pone 0 si es 0dh \n" +
"    mov sumgua1,al                                   ;asignael contenido de AL  a sumgua1\n" +
"    mov al,numsum2                                   ;asigna el contenido de la direccion de memoria de numsum2 a AL\n" +
"    cmp al,2eh                                       ;compara AL  con 2eh (.)\n" +
"    jz  puntosum5                                    ;salta si es cero a puntosum5\n" +
"    cmp al,0dh                                       ;compara AL  con 0dh (salto)\n" +
"    jz  sumareserror3                                ;salta si es cero  a sumareserror3 \n" +
"    jnz sumareserror4                                ;salta no si es cero  a sumareserror4 \n" +
"sumareserror3:                                       ;Etiqueta que pone 0 si es 2eh o 0dh\n" +
"    mov al,0h                                        ;asigna 0h a AL\n" +
"sumareserror4:                                       ;Etiqueta que no pone 0 si es 0dh \n" +
"    cmp ah,-1h                                       ;compara AL con -1h para el signo\n" +
"    jz  restaprestamossum1                           ;salta si es cero a restaprestamossum1\n" +
"    jnz norestaprestamossum1                         ;salta si no es cero a norestaprestamossum1\n" +
"restaprestamossum1:                                  ;Etiqueta que indica que se tiene un prestamo\n" +
"    sub al,1                                         ;resta 1 a AL y lo guarda en AL\n" +
"    mov ah,0                                         ;asigna 0 a AH \n" +
"    aas                                              ;ajuste de la resta\n" +
"    add al,30h                                       ;suma 30h a AL y lo guarda en AL\n" +
"norestaprestamossum1:                                ;Etiqueta que indica que no se tiene un prestamo  \n" +
"    sub al,sumgua1                                   ;resta sumgua1 a AL y lo guarda en AL\n" +
"    aas                                              ;ajuste dela resta\n" +
"    add al,30h                                       ;suma 30h a AL y lo guarda en AL\n" +
"puntosum5:                                           ;Etiqueta que guarda el punto en resula\n" +
"    mov resula+contsum,al                            ;Asigna a AL la direccion de memoria de resula+contsum\n" +
"endm                                                 ;fin de la macro signo_suma \n" +
"\n" +
"sumaprint1 macro                                      ;Macro que imprime resula                      \n" +
"    LOCAL excepcisum1,excepcisum2                     ;Asigna la etiqueta local para excepcisum1,excepcisum2\n" +
"    LOCAL excepcisum3,excepcisum4                     ;Asigna la etiqueta local para excepcisum3,excepcisum4\n" +
"    LOCAL quitacerosum1,excepsumpunto                 ;Asigna la etiqueta local para quitacerosum1,excepsumpunto\n" +
"    LOCAL excepsumpunto0,excepsumpunto1               ;Asigna la etiqueta local para excepsumpunto0,excepsumpunto1\n" +
"    LOCAL excepsumpunto2,puntosum0                    ;Asigna la etiqueta local para excepsumpunto2,puntosum0  \n" +
"    LOCAL puntosum1,puntosum2,sinpunto3               ;Asigna la etiqueta local para puntosum1,puntosum2,sinpunto3\n" +
"    LOCAL sumapr,puntosum3,sinpunto2                  ;Asigna la etiqueta local para sumapr,puntosum3,sinpunto2\n" +
"    mov cx,4                                          ;asigna 4 a CX\n" +
"    mov bx,3                                          ;asigna 3 a BX\n" +
"sumapr:                                               ;Ciclo que imprime el contenido de resula                                                                                   \n" +
"    mov al,[resula+bx]                                ;asigna el contenido de la direccion de memoria dada  por \n" +
"                                                      ;el desplazamiento de resula mas BX a AL\n" +
"    cmp bx,0                                          ;compara BX con 0                                         \n" +
"    jz  excepcisum1                                   ;salta si BX es cero a excepcisum1\n" +
"    jnz excepcisum2                                   ;salta si BX  no es cero a excepcisum2  \n" +
"excepcisum2:                                          ;Etiqueta para BX no es cero\n" +
"    cmp bx,3                                          ;compara BX con 3\n" +
"    jz  excepcisum3                                   ;salta si BX es tres a excepcisum3 \n" +
"    jnz excepcisum4                                   ;salta si BX no es tres a excepcisum4\n" +
"excepcisum1:                                          ;Etiqueta para BX es cero como posicion\n" +
"excepcisum3:                                          ;Etiqueta para BX es tres como posicion\n" +
"    cmp al,30h                                        ;compara AL con 30h para eliminar el primer 0 y el ultimo \n" +
"    jz  quitacerosum1                                 ;salta si AL es cero a quitacerosum1\n" +
"excepcisum4:                                          ;Etiqueta para BX no es tres como posicion\n" +
"    mov dl,al                                         ;asigna AL a DL                       \n" +
"    mov ah,02h                                        ;con la funcion 02h                            \n" +
"    int 21h                                           ;de la int 21h (se imprime el numero) \n" +
"    cmp al,2eh                                        ;compara AL con 2eh(punto) \n" +
"    jz  excepsumpunto                                 ;salta si AL  es 2eh a excepsumpunto\n" +
"    jnz excepsumpunto0                                ;salta si AL  es 2eh a excepsumpunto0\n" +
"excepsumpunto0:                                       ;Etiqueta para AL  no es 2eh\n" +
"    cmp bx,2                                          ;compara BX  con 2\n" +
"    jz  excepsumpunto1                                ;salta si BX es dos a excepsumpunto1\n" +
"    jnz excepsumpunto2                                ;salta si BX no es dos a excepsumpunto2\n" +
"excepsumpunto1:                                       ;Etiqueta si BX=2 para poner punto en medio\n" +
"    cmp al,30h                                        ;compara AL con 30h\n" +
"    jz  puntosum0                                     ;salta si AL es 30h a  puntosum0 \n" +
"    jnz puntosum1                                     ;salta si AL no es 30h a puntosum1\n" +
"puntosum1:                                            ;Etiqueta si AL es 30h\n" +
"puntosum0:                                            ;Etiqueta si no es 30h\n" +
"    cmp resula+1,30h                                  ;Compara la direcion de memoria de resula+1 con 30h\n" +
"    jz  puntosum2                                     ;salta si resula+1 es 30h a puntosum2\n" +
"    jnz puntosum3                                     ;salta si resula+1 no es 30h a puntosum3\n" +
"puntosum2:                                            ;Etiqueta para resula+1 es 30h\n" +
"    cmp resula+0,30h                                  ;Compara la direcion de memoria de resula+0 con 30h\n" +
"    jz  sinpunto2                                     ;salta si resula+0 es 30h a sinpunto2\n" +
"    jnz sinpunto3                                     ;salta si resula+0 no es 30h a sinpunto3      \n" +
"sinpunto3:                                            ;Etiqueta si resula+1 no es 30h a puntosum\n" +
"puntosum3:                                            ;Etiqueta si resula+1 no es 30h a puntosum\n" +
"    printmsj punto                                    ;Invoca a la macro para imprimir el contenido de punto                       \n" +
"excepsumpunto2:                                       ;Etiqueta para BX no es posicion dos de la tabla resula \n" +
"excepsumpunto:                                        ;Etiqueta si AL  es 2eh, decrementa a bx en 1\n" +
"quitacerosum1:                                        ;Etiqueta para BX=3,BX=0 no imprime nada y decrementa)\n" +
"    dec bx                                            ;decrementa BX en 1\n" +
"    loop sumapr                                       ;Ciclo que imprime el contenido de resula  \n" +
"sinpunto2:                                            ;Etiqueta que sale del ciclo sin imprimi punto\n" +
"endm                                                  ;fin de la macro sumaprint1 \n" +
"\n" +
"                                                                                       \n" +
"                                                                                       \n" +
";--------------------------------------------------------\n" +
";INICIO                                                 :\n" +
";--------------------------------------------------------\n" +
"inicio macro                                            ;macro que asigna datos a DS \n" +
"    mov ax,data                                         ;asigna la direccion del segmento de datos a AX \n" +
"    mov ds,ax                                           ;y atravesde AX se asigna a DS\n" +
"endm                                                    ;fin de la macro inicio        \n" +
";--------------------------------------------------------\n" +
";FIN                                                    :\n" +
";--------------------------------------------------------\n" +
"fin macro                                               ;macro que devuelve el control al DOS\n" +
"    mov ax,4c00h                                        ;asigna la funcion 4c00 de la\n" +
"    int 21h                                             ;INT 21h a AX y se devuelve el control al DOS\n" +
"endm                                                    ;fin de la macro fin    \n" +
";--------------------------------------------------------\n" +
";LIMPIAR                                                :\n" +
";--------------------------------------------------------\n" +
"limpant MACRO                                           ;macro que limpia la pantalla\n" +
"    mov ah,0Fh                                          ;funcion 0f (obtiene modo de video)\n" +
"    int 10h                                             ;de la int 10h \n" +
"    mov ah,0                                            ;funcion 0 (cambia el modo video) de la\n" +
"    int 10h                                             ;int 10h (es decir las 4 instrucciones borran la pantalla)\n" +
"ENDM                                                    ;fin de la macro limpant   \n" +
";--------------------------------------------------------\n" +
";IMPRIMIR                                               :\n" +
";--------------------------------------------------------\n" +
"printmsj MACRO mensa                                    ;macro que imprime mensaje\n" +
"    lea dx,mensa                                        ;asigna la direccion inicial de desplazamiento\n" +
"                                                        ;de la localidad de memoria mensa al registro DX(DS:DX)\n" +
"    mov ah,09                                           ;asigna la funcion 09 de la INT 21h\n" +
"    int 21h                                             ;a AH(aparece mensaje en pantalla)\n" +
"ENDM                                                    ;fin de la macro printmsj \n" +
"                                                                                       \n" +
"\n" +
";--------------------------------------------------------                                     \n" +
"    .model small                                        ;define el modelo de memoria\n" +
"	.stack                                              ;define area de pila\n" +
"	.data                                               ;define el area de datos\n" +
";--------------------------------------------------------\n" +
";SEGMENTO DE DATOS                                      :\n" +
";--------------------------------------------------------\n" +
"numero1 db  "+in14+","+in13+","+in12+","+in11        + ";se define la tabla numero1\n" +
"numero2 db  " +in24+","+in23+","+in22+","+in21+                                 ";se define la tabla numero2\n" +
"resula  db  0,0,0,0                                     ;se define la tabla resula\n" +
"resres  db  30,30,30,30                                 ;se define la tabla resres\n" +
"signo1  db  02,00,00,02                                           ;se define la variable signo1\n" +
"signo2  db  ?                                           ;se define la variable signo2\n" +
"signor  db  ?                                           ;se define la variable signor\n" +
"signo   db  '-$'                                        ;asigna la cadena a la variable signo\n" +
"punto   db  '.$'                                        ;asigna la cadena a la variable punto\n" +
"me_nos  db '-$'\n" +
"sumgua1 db  0                                           ;se define la variable sumgua1\n" +
"sumgua2 db  0                                           ;se define la variable sumgua2\n" +
".code                                               ;define area de codigo                      \n" +
"inicia: \n" +
"inicio  \n" +
"mov signo2,2DH \n"+
"call suma    \n" +
"fin\n" +
"\n" +
"endp inicia        \n" +
"        \n" +
"        \n" +
"suma proc                                       ;Procedimiento para Suma\n" +
"                            ;Invoca a la macro que imprime mensaje \n" +
"SALTO_DE_LA_RES:                                ;Salto que viene de la resta\n" +
";------------------------------------------------\n" +
";COMPARA SIGNOS                                 |\n" +
";------------------------------------------------   \n" +
"    mov ax,0h                                   ;Asigna 0 a AX        \n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo2 sea signo negativo \n" +
"    jz  tienesignonegativosum                   ;Salta si signo2 tiene signo negativo\n" +
"    jnz notienesignonegsum                      ;Salta si signo2 no tiene signo negativo\n" +
"tienesignonegativosum:                          ;Etiqueta para sign2 es negativo\n" +
"    cmp signo1,'-'                              ;Compara el contenido de signo1 sea signo negativo\n" +
"    jz  tiene2signonegativosum                  ;Salta si signo1 tiene signo negativo\n" +
"    jnz notiene2signonegsum                     ;Salta si signo1 no tiene signo negativo\n" +
"tiene2signonegativosum:                         ;Etiqueta para cuando signo1 no tiene signo negativo\n" +
"    printmsj signo                              ;Invoca a la marco para imprimir signo\n" +
"    jmp tiene2signonegativosum2                 ;Salta a suma normal por que no hay negativos\n" +
"notienesignonegsum:                             ;Etiqueta para signo2 no es negativo\n" +
"    cmp signo1,'-'                              ;Compara el contenido de signo1 sea signo negativo\n" +
"    jz  tienesignonegativosum1                  ;Salta si signo1 tiene signo negativo\n" +
"    jnz notienesignoneg1                        ;Salta si signo1 no tiene signo negativo\n" +
"notiene2signonegsum:                            ;Etiqeuta para cuando signo1 no es negativo\n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo2 con '-'\n" +
"    jz  tienesignonegativosum1                  ;Salta si el contenido de signo2 es negativo\n" +
"    jnz notienesignoneg1                        ;Salta si el contnenido de signo2 no es negativo\n" +
"tienesignonegativosum1:                         ;Etiqueta para cuando signo2 es negativo\n" +
"    mov al,numero1+3                            ;Asigna el contenido de la direccion de memoira de numero1+3 a AL\n" +
"    cmp al,numero2+3                            ;Compara el contenido de numero1+3 con AL\n" +
"    ja  mayorsum                                ;Salta si AL es mayor y numero2+3 es menor\n" +
"    jb  menorsum                                ;Salta  si AL es menor y numero2+3 es mayor\n" +
"    je  verificarsegnumero                      ;Salta si son iguales \n" +
"verificarsegnumero:                             ;Etiqueta si son iguales va verifcando numero por numero\n" +
"    mov al,numero1+2                            ;Asigna el contenido de la direccion de memoira de numero1+2 a AL\n" +
"    cmp al,numero2+2 ;                          ;Compara el contenido de numero1+2 con AL\n" +
"    ja  mayorsum                                ;Salta si AL es mayor y numero2+2 es menor\n" +
"    jb  menorsum                                ;Salta  si AL es menor y numero2+2 es mayor\n" +
"    je  verificarsegnumero1                     ;Salta si son iguales     \n" +
"verificarsegnumero1:                            ;Etiqueta si son iguales va verifcando numero por numero\n" +
"    mov al,numero1+1                            ;Asigna el contenido de la direccion de memoira de numero1+1 a AL\n" +
"    cmp al,numero2+1                            ;Compara el contenido de numero1+1 con AL\n" +
"    ja  mayorsum                                ;Salta si AL es mayor y numero2+1 es menor\n" +
"    jb  menorsum                                ;Salta  si AL es menor y numero2+1 es mayor\n" +
"    je  verificarssegnumero2                    ;Salta si son iguales \n" +
"verificarssegnumero2:                           ;Etiqueta si son iguales va verifcando numero por numero\n" +
"    mov al,numero1+0                            ;Asigna el contenido de la direccion de memoira de numero1+0 a AL\n" +
"    cmp al,numero2+0                            ;Compara el contenido de numero1+0 con AL\n" +
"    ja  mayorsum                                ;Salta si AL es mayor y numero2+0 es menor\n" +
"    jb  menorsum                                ;Salta  si AL es menor y numero2+0 es mayor\n" +
"    je  igualsum                                ;Salta si son iguales  \n" +
";------------------------------------------------\n" +
";NUMEROS IGUALES                                 |\n" +
";------------------------------------------------ \n" +
"igualsum:                                       ;Etiqueta si son numeros iguales \n" +
"    cmp signo1,'-'                              ;Compara el contenido de signo1 con '-'\n" +
"    jz  tienesigno00                            ;Salta si signo1 es negativo\n" +
"    jnz notienesigno00                          ;Salta si signo1 no es negativo\n" +
"tienesigno00:                                   ;Etiqueta si signo1 es negativo\n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum00:                                   ;Etiqueta de Ciclo que resta cuando numero 1 tiene signpo negativo  \n" +
"    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incrementa BX en 1\n" +
"    loop sisignosum00                           ;Ciclo que resta cuando los numeros son iguales\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion\n" +
"notienesigno00:                                 ;Etiqueta si el signo1 no es negativo\n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo2 con '-'\n" +
"    jz  tienesigno0                             ;Salta si signo2 es negativo \n" +
"    jnz notienesigno0                           ;Salta si signo2 no es negativo\n" +
"tienesigno0:                                    ;Etiqueta si signo2 es negativo           \n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum0:                                    ;Etiqueta de ciclo que resta cuando numero2 tiene signo negativo \n" +
"    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incrementa bx en 1\n" +
"    loop sisignosum0                            ;Ciclo para restar  \n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion     \n" +
";------------------------------------------------\n" +
";NUMERO MAYOR                                |\n" +
";------------------------------------------------     \n" +
"mayorsum:                                       ;Etiqueta AL es mayor y numero2+0 es menor    \n" +
"    cmp signo1,'-'                              ;Compara el contenido de signo1 con '-'\n" +
"    jz  tienesigno1                             ;Salta a tieneigno1 cuando signo1 es el mayor y es negativo\n" +
"    jnz notienesigno1                           ;Salta a notienesigno1 cuando signo1 es el mayor y no es negativo\n" +
"tienesigno1:                                    ;Etiqueta si signo1 es negativo  y mayor\n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum1:                                    ;Etiqueta de ciclo que resta cuando numero1 tiene signo negativo\n" +
"    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incremeta bx en 1\n" +
"    loop sisignosum1                            ;Ciclo para restar\n" +
"    printmsj signo                              ;Invoca a la macro printmsj para imprimir signo\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion\n" +
"notienesigno1:                                  ;Etiqueta si signo1 es mayor pero no es negativo \n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo2 con '-'\n" +
"    jz  tienesigno3                             ;Salta si signo2 es el menor y es negativo\n" +
"    jnz notienesigno3                           ;Salta cuando signo2 es el menor y no es negativo\n" +
"tienesigno3:                                    ;Etiqueta cuando signo2 es el menor y  es negativo\n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum2:                                    ;Etiqueta de ciclo que resta cuando numero2 tiene signo negativo\n" +
"    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incremeta bx en 1\n" +
"    loop sisignosum2                            ;Ciclo para restar\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion  \n" +
";------------------------------------------------\n" +
";NUMERO MENOR                                 |\n" +
";------------------------------------------------ \n" +
"menorsum:                                       ;Salta si AL es menor y numero2+0 es mayor\n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo1 con '-'\n" +
"    jz  tienesigno2                             ;Salta si signo2 es negativo\n" +
"    jnz notienesigno2                           ;Salta si signo2 no es negativo\n" +
"tienesigno2:                                    ;Etiqueta si signo21 es negativo y mayor\n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum3:                                    ;Etiqueta de ciclo que resta cuando numero1 tiene signo negativo\n" +
"    signo_suma numero1+bx,numero2+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incremeta bx en 1\n" +
"    loop sisignosum3                            ;Ciclo para restar\n" +
"    printmsj signo                              ;Invoca a la macro printmsj para imprimir signo\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion\n" +
"notienesigno2:                                  ;Salta si signo1 es negativo y es menor \n" +
"    cmp signo1,'-'                              ;Comapra el contenido de signo1 con '-'\n" +
"    jz  tienesigno4                             ;Salta si signo1 es negativo y es menor \n" +
"    jnz notienesigno4                           ;Salta si signo1 no es negativo y es menor \n" +
"tienesigno4:                                    ;Etiqueta para  signo1 es negativo y es menor \n" +
"    mov cx,4                                    ;Asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum4:                                    ;Etiqueta de ciclo que resta cuando numero2 tiene signo negativo\n" +
"    signo_suma numero1+bx,numero2+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;Incrementa BX en 1\n" +
"    loop sisignosum4                            ;Ciclo para restar\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion \n" +
"notienesigno0:                                  ;Etiqueta cuando signo1 y signo2 no son negativo\n" +
"notienesigno4:                                  ;Etiqueta cuando signo1 y signo2 no son negativo\n" +
"notienesigno3:                                  ;Etiqueta cuando signo1 y signo2 no son negativo\n" +
"notienesignoneg1:                               ;Etiqueta para cuando signo2 no es negativo\n" +
"tiene2signonegativosum2:                        ;Etiqueta par cuandon ninguno de los 2 numeros tiene signo   \n" +
";------------------------------------------------\n" +
";SUMA NORMAL                                    |\n" +
";------------------------------------------------ \n" +
"	mov cx,4                                    ;Asigna 4 a CX     \n" +
"	mov bx,0                                    ;Asigna 0 a BX\n" +
"	mov ax,0                                    ;Asigna 0 a AX\n" +
"sumaciclo1:                                     ;Ciclo que hace la operacion de sumar\n" +
"    mov al,[numero1+bx]                         ;asigna el contenido de la direccion de memoria dada  por \n" +
"                                                ;el desplazamiento de numero1 mas BX a AL\n" +
"    cmp al,0dh                                  ;Compara AL con 0dh(salto)\n" +
"    jz  sumerror1                               ;Salta a sumerror1 si AL es 0dh\n" +
"    jnz sumerror2                               ;Salta a sumerror2 si AL no es 0dh\n" +
"    cmp al,6bh                                  ;Compara AL con 6bh\n" +
"    jz  sumerror3                               ;Salta a sumerror3 si AL es 6bh\n" +
"    jnz sumerror4                               ;Salta a sumerror4 si AL no es 6bh  \n" +
"sumerror1:                                      ;Etiqueta para AL es 0dh, asigna 0h a AL\n" +
"    mov al,0h                                   ;Asigna 0h a AL \n" +
"sumerror2:                                      ;Etiqueta para AL no es 0dh, no asigna 0h a AL\n" +
"    cmp al,2eh                                  ;Compara AL con 2eh(punto)\n" +
"    jz  puntosum_sa                             ;Salta a puntosum_sa, si AL es 2eh\n" +
"    jnz nopuntosum_sa                           ;Salta a nopuntosum_sa, si AL no es 2eh\n" +
"nopuntosum_sa:                                  ;Etiqueta para AL no es 2eh, no hay punto       \n" +
"    mov sumgua1,al                              ;Asigna el contenido de al a sumgual1                              \n" +
"    mov al,[numero2+bx]                         ;asigna el contenido de la direccion de memoria dada  por \n" +
"                                                ;el desplazamiento de numero2 mas BX a AL\n" +
"    cmp al,2eh                                  ;Compara AL con 2eh(punto)\n" +
"    jz  puntosum_sa1                            ;Salta a puntosum_sa1, si AL es 2eh\n" +
"    jnz nopuntosum_sa1                          ;Salta a nopuntosum_sa1, si AL no es 2eh\n" +
"nopuntosum_sa1:                                 ;Etiqueta para AL no es 2eh, no hay punto\n" +
"    cmp al,0dh                                  ;Compara AL con 0dh(salto)\n" +
"    jz  sumerror3                               ;Salta a sumerror3, si AL es 0dh\n" +
"    jnz sumerror4                               ;Salta a sumerror4, si AL no es 0dh\n" +
"    cmp al,6bh                                  ;Compara AL con 6bh\n" +
"    jz  sumerror3                               ;Salta a sumerror3, si AL es 6bh\n" +
"    jnz sumerror4                               ;Salta a sumerror4, si AL no es 6bh\n" +
"sumerror3:                                      ;Etiqueta para AL es 0dh, asigna 0h a AL\n" +
"    mov al,0h                                   ;Asigna 0h a AL\n" +
"sumerror4:                                      ;Etiqueta para AL no es 0dh, no asigna 0h a AL\n" +
"    add al,ah                                   ;suma AH a AL y lo guarda en AL \n" +
"    mov ah,0h                                   ;Asigna 0h a AH\n" +
"    add al,sumgua1                              ;suma sumgua1 a AL y lo guarda en AL\n" +
"	aaa                                         ;ajuste ascii de la suma \n" +
"	add ax,30h                                  ;suma 30h a AL y lo guarda en AL	 \n" +
"puntosum_sa1:                                   ;Etiqueta para AL es 2eh, hay punto y lo guardamos en resula\n" +
"puntosum_sa:                                    ;Etiqueta para AL es 2eh, hay punto y lo guardamos en resula\n" +
"	mov resula+bx,al                            ;Se asigna AL a la direccion de memoria de resula + bx \n" +
"	inc bx                                      ;Incrementa BX en uno\n" +
"    loop sumaciclo1                             ;Ciclo que hace la operacion de sumar  \n" +
"    salirsignosum:                              ;Etiqueta que termina las operaciones con signo\n" +
"    sumaprint1                                  ;Invoca a la macro sumaprint para imprimir la tabal resula        \n" +
"    ret                                         ;retorna a donde fue llamado el procedimiento\n" +
"suma endp                                       ;finaliza el procedimiento sum\n" +
"\n" +
"resta proc                                 ;procedimiento que efectua la resta\n" +
";-----------------------------------------\n" +
";IMPRIME Y PIDE DATOS                   ||\n" +
";-----------------------------------------    \n" +
";------------------------------------------\n" +
";COMPARA SIGNOS                           |\n" +
";------------------------------------------\n" +
"COMPARA_SIGNOS:                            ;etiqueta que compara los signos\n" +
"    mov dh,[signo1]                        ;mueve el contenido de la direccion de memoria\n" +
"                                           ;dada por signo1\n" +
"    mov dl,[signo2]                        ;mueve el contenido de la direccion de memoria\n" +
"                                           ;dada por signo1\n" +
"    cmp dh,dl                              ;compara dh con dl (los signos) para saltar a\n" +
"    jz  SIH_IGUAL                          ;la etiueta de signos iguales\n" +
"    JMP SIH_DIFE                           ;en caso contario salta a signos diferentes\n" +
"SIH_DIFE:                                  ;etiqueta de signos diferentes\n" +
"    cmp dh,'-'                             ;compara si los signos son positivos o negativos\n" +
"    jz  c_sig1                             ;salta si el premer signo es nehativo\n" +
"    jmp c_sig2                             ;salta si el segundo signo es negativo\n" +
"c_sig2:                                    ;etiqueta cambia el signo de numero2\n" +
"    mov signo2,00h                         ;asigna un signo positivo al numero 2\n" +
"    jmp SALTO_DE_LA_RES                    ;etiqueta que salta a la suma\n" +
"c_sig1:                                    ;etiqueta cambia signo numero1\n" +
"    mov signo2,'-'                         ;asigna un signo negativo al numero2\n" +
"    jmp SALTO_DE_LA_RES                    ;etiqueta que salta a la suma\n" +
"SIH_IGUAL:                                 ;etiqueta si los signos son iguales\n" +
"    cmp dh,'-'                             ;compara signo de numero1 para saltar a la\n" +
"    jz COMPARA_MAYOR                       ;etiqueta que compara el numero mayor\n" +
"    jmp COMPARA_NUMEROS                    ;en caso contrario salta a comparar(para resta)\n" +
"IMPRIME_MENOS:                             ;etiqueta que imprime un sino negativo\n" +
"     printmsj   me_nos                     ;invoca a la macro para imprimir un signo negativo\n" +
"     JMP COMPARA_NUMEROS                   ;salta para comparar numeros(para resta)\n" +
";------------------------------------------\n" +
";COMPARA NUMERO MAYOR                     |\n" +
";------------------------------------------\n" +
"COMPARA_MAYOR:                             ;etiqueta que compara numeros (saber mayor)\n" +
"    mov bx,03h                             ;asigna 03h a bx(repite 3 veces)\n" +
"COM_DEN2:                                  ;etiqueta para comparar de nuevo    \n" +
"    mov dh,[numero1+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a dh dado por numero1+bx (bx=3,2,1,0)\n" +
"    mov dl,[numero2+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a dl dado por numero2+bx (bx=3,2,1,0)\n" +
"    cmp dh,dl                              ;compara dh con dl para saltar a la etiqueta\n" +
"    jg  IMPRIME_MENOS                      ;salta si es mas grande DH(numero1)\n" +
"    jb  RESTA_ALREVES                      ;salta si es mas grande DL(numero2)\n" +
"    dec bx                                 ;decrementa en uno bx(bx=3,2,1,0)\n" +
"    jmp COM_DEN2                           ;salta(regresa) si los numeros son iguales\n" +
"COMPARA_NUMEROS:                           ;compara numeros(para resta invertida)\n" +
"    mov bx,03h                             ;asigna 03h a bx(repite 3 veces)\n" +
"COM_DEN:                                   ;etiqueta para comparar de nuevo\n" +
"    mov dh,[numero1+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a dh dado por numero1+bx (bx=3,2,1,0)\n" +
"    mov dl,[numero2+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a dl dado por numero2+bx (bx=3,2,1,0)\n" +
"    cmp dh,dl                              ;compara dh con dl para saltar a la etiqueta\n" +
"    jg  RESTANOR                           ;salta si es mas grande DH(numero1)(resta normal)\n" +
"    jb  RESTA_ALREVES_S                    ;salta si es mas grande DL(numero2)(resta invertida)\n" +
"    cmp bx,00h                             ;compara si bx es cero(numeros iguales)\n" +
"    jz  RESTANOR                           ;si BX es cero salta a resta normal\n" +
"    dec bx                                 ;decrementa BX en uno\n" +
"    jmp COM_DEN                            ;salta para comparar el sigiente digito\n" +
"RESTANOR:                                  ;etiqueta de resta normal\n" +
"    LEA si,numero1                         ;asigna la direccion de mamoria al registro SI(indice fuente)\n" +
"    LEA dI,numero2                         ;asigna la direcion de memoria al registro DI[indice destino]\n" +
"    mov bx,00h                             ;restablese en ceros a bx\n" +
"    jmp COM_N                              ;salta para comparar numeros\n" +
"RESTA_ALREVES_S:                           ;etiqueta para resta inversa(imprime menos)\n" +
"    printmsj me_nos                        ;invoca a la macro para imptimir un signo menos\n" +
"    JMP RESTA_ALREVES                      ;salta a la resta al incerza\n" +
";------------------------------------------\n" +
";CAMBIA DE ORDEN LOS NUMEROS              |\n" +
";------------------------------------------\n" +
"RESTA_ALREVES:                             ;resta iinverza cambia numeros de pocicion\n" +
"    mov bx,00h                             ;restablese bx en cero\n" +
"repite_al:                                 ;etiqueta que repite 3 veces\n" +
"    mov al,[numero1+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a al dado por numero1+bx(BX=0,1,2,3)\n" +
"    mov [resula+bx],al                     ;mueve el contenido de AL a la direccion de memoria \n" +
"                                           ;dada por resula+bx (BX=0,1,2,3)\n" +
"    mov al,[numero2+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a al dado por numero2+bx(BX=0,1,2,3)\n" +
"    mov [numero1+bx],al                    ;mueve el contenido de AL a la direccion de memoria \n" +
"                                           ;dada por numero1+bx (BX=0,1,2,3)\n" +
"    mov al,[resula+bx]                     ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a al dado por resula+bx(BX=0,1,2,3)\n" +
"    mov [numero2+bx],al                    ;mueve el contenido de AL a la direccion de memoria \n" +
"                                           ;dada por numero2+bx (BX=0,1,2,3)\n" +
"    inc bx                                 ;incrementa bx en uno\n" +
"    cmp bx,04h                             ;compara si bx es igual a 04h para saltar a la \n" +
"    jz  RESTANOR                           ;etiqueta de resta normal\n" +
"    jmp repite_al                          ;salta para repetir 3 veces\n" +
";------------------------------------------\n" +
";COMPARA PARA RESTAR                      |\n" +
";------------------------------------------\n" +
"COM_N:                                     ;etiqueta que compara numeros(acarreo o no)\n" +
"    mov dh,[numero1+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a DH dado por numero1+bx(BX=0,1,2,3)\n" +
"    mov dl,[numero2+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a DL dado por numero2+bx(BX=0,1,2,3)\n" +
"    cmp dh,dl                              ;compara dh con dl\n" +
"    jb RES_INV                             ;salta a la resta con acarreo si dh(numero1) es mayor\n" +
"    jmp  OPE_RESN                          ;salta a la resta normal si DL es mayor(numero2)  \n" +
"    INC bx                                 ;incrementa en uno al registro bx\n" +
"    cmp bx,03H                             ;compara si BX es igual a 03h\n" +
"    jz  RES_CERO                           ;si bx es 03h salta aa imprimir cero(numeros iguales)\n" +
"    cmp dh,dl                              ;compara si dh y dl son iguales\n" +
"    jz  COM_N                              ;si son iguales repite la comparacion\n" +
";------------------------------------------\n" +
";RESULTADO CERO\n" +
";------------------------------------------\n" +
"RES_CERO:                                  ;etiqueta que da resultado cero\n" +
"     JMP IMP_RES2                          ;salta para imprimir resultado\n" +
";------------------------------------------            \n" +
";RESTA NORMAL                             |\n" +
";------------------------------------------ \n" +
"OPE_RESN:                                  ;etiqueta que resta numero 1- numero2\n" +
"    mov ax,00h                             ;restablece AX a cero\n" +
"    mov al,[SI]                            ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por SI\n" +
"    sbb al,[DI]                            ;resta el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por DI\n" +
"    AAS                                    ;ajusta el resultado despues de la resta\n" +
"    mov [resres+bx],AL                     ;mueve el conteniado de AL a la direccion de memoria\n" +
"                                           ;dado por resres+bx(BX=0,1,2,3)\n" +
"    cmp bx,03h                             ;compara el contenido de bx con 03h para saltar a la \n" +
"    jz  IMP_RES2                           ;etiqueta que imprime el resultado\n" +
"    INC SI                                 ;invcrementa en uno a SI(apunta a la siguente pocicon)\n" +
"    INC DI                                 ;invcrementa en uno a DI(apunta a la siguente pocicon)\n" +
"    INC bx                                 ;invcrementa en uno a DX(apunta a la siguente pocicon)\n" +
"    jmp COM_N                              ;repite el proceso tres veces\n" +
";------------------------------------------    \n" +
";RESTA INVERTIDA                          |\n" +
";------------------------------------------    \n" +
"RES_INV:                                   ;etiqueta que efectua resta inverida (acarreo)\n" +
"    mov ax,00h                             ;restablece AX a cero\n" +
"    mov al,[SI]                            ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por SI\n" +
"    ADD AL,10H                             ;suma 10h al contenido de AL\n" +
"    sbb al,[DI]                            ;resta el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por DI\n" +
"    AAS                                    ;ajusta el resultado despues de la resta\n" +
"    mov [resres+bx],AL                     ;mueve el conteniado de AL a la direccion de memoria\n" +
"                                           ;dado por resres+bx(BX=0,1,2,3)\n" +
"    jmp ACARREO_RES                        ;salta para efectuar acarreo\n" +
";------------------------------------------\n" +
";ACARREO                                  |\n" +
";------------------------------------------\n" +
"ACARREO_RES:                               ;etiqueta que efectua acarreo\n" +
"    mov dx,00h                             ;restablece a cero bx\n" +
"    mov dl,[NUMERO1+bx+1]                  ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por numero1+bx+1\n" +
"    cmp dl,00h                             ;compara el contenido de dl con cero pasa altar a la \n" +
"    jz  ACARREO_RES2:                      ;etiqueta que suma una al minuendo\n" +
"    dec dl                                 ;decrementa dl para efectuar acarreo\n" +
"    mov [numero1+bx+1],dl                  ;mueve el conteniado de DL a la direccion de memoria\n" +
"                                           ;dado por numero1+bx+1(BX=0,1,2,3)\n" +
"    cmp bx,03H                             ;compara el contenido de bx con 03h para saltar a la\n" +
"    jz  IMP_RES2                           ;etiqueta que imprime el resultado\n" +
"    inc bx                                 ;invcrementa en uno a BX(apunta a la siguente pocicon)\n" +
"    INC SI                                 ;invcrementa en uno a SI(apunta a la siguente pocicon)\n" +
"    INC DI                                 ;invcrementa en uno a DI(apunta a la siguente pocicon)\n" +
"    jmp COM_N                              ;salta para repetir el proceso 3 veces        \n" +
"ACARREO_RES2:                              ;etiqueta de acarreo que suma al minuendo\n" +
"    MOV dx,00h                             ;restitulle en cero al contenido del registro dx\n" +
"    mov dl,[numero2+bx+1]                  ;asigna a dl el contenido de la direccion de memoria dado\n" +
"                                           ;por el desplasamiento de numero2+bx+1\n" +
"    inc dl                                 ;incrementa en 1 al contenido del registro dl\n" +
"    mov [numero2+bx+1],dl                  ;aigna el contenido de dl en la direccion de memoria \n" +
"                                           ;dada por el desplasamiento de la suma de numero2+bx+1 \n" +
"    cmp bx,03H                             ;compara el contenido de bx con 03h para saltar a la\n" +
"    jz  IMP_RES2                           ;etiqueta que imprime el resultado\n" +
"    inc bx                                 ;invcrementa en uno a BX(apunta a la siguente pocicon)\n" +
"    INC SI                                 ;invcrementa en uno a SI(apunta a la siguente pocicon)\n" +
"    INC DI                                 ;invcrementa en uno a DI(apunta a la siguente pocicon)\n" +
"    jmp COM_N\n" +
"    \n" +
";------------------------------------------\n" +
";IMPRIME EL RESULTADO                     |\n" +
";------------------------------------------        \n" +
"IMP_RES2:                                  ;etiqueta que imprime el resultado\n" +
"   mov  bx,00h                             ;restablece en ceros a BX\n" +
"REPITE_IM:                                 ;etiqueta para mover de resres a resula\n" +
"   mov  dx,00h                             ;restablece en cero a DX\n" +
"   mov  dl,[resres+bx]                     ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a DL dado por resres+bx(BX=0,2,3)\n" +
"   add  dl,30h                             ;suma 30h al contenido de DL(pasa a ASCII)\n" +
"   mov  [resula+bx],dl                     ;mueve el conteniado de DL a la direccion de memoria\n" +
"                                           ;dado por resula+bx(BX=0,1,2,3)\n" +
"   inc  bx                                 ;incrementa bx en uno(BX=0,1,2,3)\n" +
"   cmp  bx,04h                             ;compara en contenido de BX con 04h\n" +
"   jz   MANDAR                             ;si bx es cuatro manda a llamar a la macro\n" +
"   jmp  REPITE_IM                          ;en caso contrario repite el proceso\n" +
";------------------------------------------\n" +
";MANDA A IMPRIMIR                       |||\n" +
";------------------------------------------   \n" +
"MANDAR:                                    ;etiqueta que llama a la macro para imprimir\n" +
"sumaprint1                                 ;invoca a ala macro que imprime el resultado    \n" +
";------------------------------------------\n" +
";BORRA EL CONTENIDO DE LAS VARIABLES  |||||\n" +
";------------------------------------------\n" +
"BORRAR:                                    ;etiqueta que borra el contenido de las variebles\n" +
"    mov signo1,00h                         ;restablece el contenido de signo1 a cero\n" +
"    mov signo2,00h                         ;restablece el contenido de signo2 a cero\n" +
"    mov  bx,00h                            ;restablcece el contenido de bx en cero\n" +
"REPI_CLEAR:                                ;etiqueta que repite el proceso de borrar\n" +
"   mov  dx,00h                             ;restablece en cero el contenido de dx\n" +
"   mov  [resres+bx],00h                    ;mueve 00h a la direccion de memoria\n" +
"                                           ;dado por resres+bx(BX=0,1,2,3)\n" +
"   mov  [resula+bx],00h                    ;mueve 00h a la direccion de memoria\n" +
"                                           ;dado por resula+bx(BX=0,1,2,3)\n" +
"   inc  bx                                 ;incrementa en uno el contenido de BX\n" +
"   cmp  bx,4                               ;compara se es 04h el contenido de BX si lo es\n" +
"   jz   FIN                                ;salta a la etiqueta fin\n" +
"   jmp  REPI_CLEAR                         ;en caso contrario repite el proceso de borrado\n" +
";------------------------------------------\n" +
";FINALIZA LA RESTA                       ||\n" +
";------------------------------------------       \n" +
"FIN:                                       ;etiqueta que finaliza la resta\n" +
"    ret                                    ;retorna a donde fue llamado el procedimiento\n" +
"resta endp        " ;
        try (BufferedWriter archivobf = new BufferedWriter(archivo)) {
            archivo.write(Texto);
        }
}
public void doble_negativo(String in11,String in12,String in13,String in14,String in21,String in22,String in23,String in24) throws FileNotFoundException, UnsupportedEncodingException, IOException{
    FileWriter archivo = new FileWriter("C:/Users/crizs/Desktop/Analizador03/archivo.asm");
            String Texto= "signo_suma macro numsum1,numsum2,contsum             ;Macro con 3 argumentos(numsum1,numsum2,contsum)  \n" +
"                                                     ;Hace la operacion de resta para el signo y lo imprime\n" +
"    LOCAL sumareserror1,sumareserror2                ;Asigna la etiqueta local para sumareserror1,sumareserror2\n" +
"    LOCAL puntosum5,sumareserror3                    ;Asigna la etiqueta local para puntosum5,sumareserror3\n" +
"    LOCAL sumareserror4                              ;Asigna la etiqueta local para sumareserror4\n" +
"    LOCAL restaprestamossum1                         ;Asigna la etiqueta local para restaprestamossum1\n" +
"    LOCAL norestaprestamossum1                       ;Asigna la etiqueta local para norestaprestamossum1\n" +
"    mov al,numsum1                                   ;asigna el contenido de numsum1 a AL\n" +
"    cmp al,2eh                                       ;compara AL con 2eh (.)\n" +
"    jz  puntosum5                                    ;salta si es cero a  puntosum5  \n" +
"    cmp al,0dh                                       ;compara AL con 0d (salto)\n" +
"    jz  sumareserror1                                ;salta si es cero  a sumareserror1\n" +
"    jnz sumareserror2                                ;salta no es a sumareserror2\n" +
"sumareserror1:                                       ;Etiqueta que pone 0 si es 2eh o 0dh\n" +
"    mov al,0h                                        ;asigna 0h a AL\n" +
"sumareserror2:                                       ;Etiqueta que no pone 0 si es 0dh \n" +
"    mov sumgua1,al                                   ;asignael contenido de AL  a sumgua1\n" +
"    mov al,numsum2                                   ;asigna el contenido de la direccion de memoria de numsum2 a AL\n" +
"    cmp al,2eh                                       ;compara AL  con 2eh (.)\n" +
"    jz  puntosum5                                    ;salta si es cero a puntosum5\n" +
"    cmp al,0dh                                       ;compara AL  con 0dh (salto)\n" +
"    jz  sumareserror3                                ;salta si es cero  a sumareserror3 \n" +
"    jnz sumareserror4                                ;salta no si es cero  a sumareserror4 \n" +
"sumareserror3:                                       ;Etiqueta que pone 0 si es 2eh o 0dh\n" +
"    mov al,0h                                        ;asigna 0h a AL\n" +
"sumareserror4:                                       ;Etiqueta que no pone 0 si es 0dh \n" +
"    cmp ah,-1h                                       ;compara AL con -1h para el signo\n" +
"    jz  restaprestamossum1                           ;salta si es cero a restaprestamossum1\n" +
"    jnz norestaprestamossum1                         ;salta si no es cero a norestaprestamossum1\n" +
"restaprestamossum1:                                  ;Etiqueta que indica que se tiene un prestamo\n" +
"    sub al,1                                         ;resta 1 a AL y lo guarda en AL\n" +
"    mov ah,0                                         ;asigna 0 a AH \n" +
"    aas                                              ;ajuste de la resta\n" +
"    add al,30h                                       ;suma 30h a AL y lo guarda en AL\n" +
"norestaprestamossum1:                                ;Etiqueta que indica que no se tiene un prestamo  \n" +
"    sub al,sumgua1                                   ;resta sumgua1 a AL y lo guarda en AL\n" +
"    aas                                              ;ajuste dela resta\n" +
"    add al,30h                                       ;suma 30h a AL y lo guarda en AL\n" +
"puntosum5:                                           ;Etiqueta que guarda el punto en resula\n" +
"    mov resula+contsum,al                            ;Asigna a AL la direccion de memoria de resula+contsum\n" +
"endm                                                 ;fin de la macro signo_suma \n" +
"\n" +
"sumaprint1 macro                                      ;Macro que imprime resula                      \n" +
"    LOCAL excepcisum1,excepcisum2                     ;Asigna la etiqueta local para excepcisum1,excepcisum2\n" +
"    LOCAL excepcisum3,excepcisum4                     ;Asigna la etiqueta local para excepcisum3,excepcisum4\n" +
"    LOCAL quitacerosum1,excepsumpunto                 ;Asigna la etiqueta local para quitacerosum1,excepsumpunto\n" +
"    LOCAL excepsumpunto0,excepsumpunto1               ;Asigna la etiqueta local para excepsumpunto0,excepsumpunto1\n" +
"    LOCAL excepsumpunto2,puntosum0                    ;Asigna la etiqueta local para excepsumpunto2,puntosum0  \n" +
"    LOCAL puntosum1,puntosum2,sinpunto3               ;Asigna la etiqueta local para puntosum1,puntosum2,sinpunto3\n" +
"    LOCAL sumapr,puntosum3,sinpunto2                  ;Asigna la etiqueta local para sumapr,puntosum3,sinpunto2\n" +
"    mov cx,4                                          ;asigna 4 a CX\n" +
"    mov bx,3                                          ;asigna 3 a BX\n" +
"sumapr:                                               ;Ciclo que imprime el contenido de resula                                                                                   \n" +
"    mov al,[resula+bx]                                ;asigna el contenido de la direccion de memoria dada  por \n" +
"                                                      ;el desplazamiento de resula mas BX a AL\n" +
"    cmp bx,0                                          ;compara BX con 0                                         \n" +
"    jz  excepcisum1                                   ;salta si BX es cero a excepcisum1\n" +
"    jnz excepcisum2                                   ;salta si BX  no es cero a excepcisum2  \n" +
"excepcisum2:                                          ;Etiqueta para BX no es cero\n" +
"    cmp bx,3                                          ;compara BX con 3\n" +
"    jz  excepcisum3                                   ;salta si BX es tres a excepcisum3 \n" +
"    jnz excepcisum4                                   ;salta si BX no es tres a excepcisum4\n" +
"excepcisum1:                                          ;Etiqueta para BX es cero como posicion\n" +
"excepcisum3:                                          ;Etiqueta para BX es tres como posicion\n" +
"    cmp al,30h                                        ;compara AL con 30h para eliminar el primer 0 y el ultimo \n" +
"    jz  quitacerosum1                                 ;salta si AL es cero a quitacerosum1\n" +
"excepcisum4:                                          ;Etiqueta para BX no es tres como posicion\n" +
"    mov dl,al                                         ;asigna AL a DL                       \n" +
"    mov ah,02h                                        ;con la funcion 02h                            \n" +
"    int 21h                                           ;de la int 21h (se imprime el numero) \n" +
"    cmp al,2eh                                        ;compara AL con 2eh(punto) \n" +
"    jz  excepsumpunto                                 ;salta si AL  es 2eh a excepsumpunto\n" +
"    jnz excepsumpunto0                                ;salta si AL  es 2eh a excepsumpunto0\n" +
"excepsumpunto0:                                       ;Etiqueta para AL  no es 2eh\n" +
"    cmp bx,2                                          ;compara BX  con 2\n" +
"    jz  excepsumpunto1                                ;salta si BX es dos a excepsumpunto1\n" +
"    jnz excepsumpunto2                                ;salta si BX no es dos a excepsumpunto2\n" +
"excepsumpunto1:                                       ;Etiqueta si BX=2 para poner punto en medio\n" +
"    cmp al,30h                                        ;compara AL con 30h\n" +
"    jz  puntosum0                                     ;salta si AL es 30h a  puntosum0 \n" +
"    jnz puntosum1                                     ;salta si AL no es 30h a puntosum1\n" +
"puntosum1:                                            ;Etiqueta si AL es 30h\n" +
"puntosum0:                                            ;Etiqueta si no es 30h\n" +
"    cmp resula+1,30h                                  ;Compara la direcion de memoria de resula+1 con 30h\n" +
"    jz  puntosum2                                     ;salta si resula+1 es 30h a puntosum2\n" +
"    jnz puntosum3                                     ;salta si resula+1 no es 30h a puntosum3\n" +
"puntosum2:                                            ;Etiqueta para resula+1 es 30h\n" +
"    cmp resula+0,30h                                  ;Compara la direcion de memoria de resula+0 con 30h\n" +
"    jz  sinpunto2                                     ;salta si resula+0 es 30h a sinpunto2\n" +
"    jnz sinpunto3                                     ;salta si resula+0 no es 30h a sinpunto3      \n" +
"sinpunto3:                                            ;Etiqueta si resula+1 no es 30h a puntosum\n" +
"puntosum3:                                            ;Etiqueta si resula+1 no es 30h a puntosum\n" +
"    printmsj punto                                    ;Invoca a la macro para imprimir el contenido de punto                       \n" +
"excepsumpunto2:                                       ;Etiqueta para BX no es posicion dos de la tabla resula \n" +
"excepsumpunto:                                        ;Etiqueta si AL  es 2eh, decrementa a bx en 1\n" +
"quitacerosum1:                                        ;Etiqueta para BX=3,BX=0 no imprime nada y decrementa)\n" +
"    dec bx                                            ;decrementa BX en 1\n" +
"    loop sumapr                                       ;Ciclo que imprime el contenido de resula  \n" +
"sinpunto2:                                            ;Etiqueta que sale del ciclo sin imprimi punto\n" +
"endm                                                  ;fin de la macro sumaprint1 \n" +
"\n" +
"                                                                                       \n" +
"                                                                                       \n" +
";--------------------------------------------------------\n" +
";INICIO                                                 :\n" +
";--------------------------------------------------------\n" +
"inicio macro                                            ;macro que asigna datos a DS \n" +
"    mov ax,data                                         ;asigna la direccion del segmento de datos a AX \n" +
"    mov ds,ax                                           ;y atravesde AX se asigna a DS\n" +
"endm                                                    ;fin de la macro inicio        \n" +
";--------------------------------------------------------\n" +
";FIN                                                    :\n" +
";--------------------------------------------------------\n" +
"fin macro                                               ;macro que devuelve el control al DOS\n" +
"    mov ax,4c00h                                        ;asigna la funcion 4c00 de la\n" +
"    int 21h                                             ;INT 21h a AX y se devuelve el control al DOS\n" +
"endm                                                    ;fin de la macro fin    \n" +
";--------------------------------------------------------\n" +
";LIMPIAR                                                :\n" +
";--------------------------------------------------------\n" +
"limpant MACRO                                           ;macro que limpia la pantalla\n" +
"    mov ah,0Fh                                          ;funcion 0f (obtiene modo de video)\n" +
"    int 10h                                             ;de la int 10h \n" +
"    mov ah,0                                            ;funcion 0 (cambia el modo video) de la\n" +
"    int 10h                                             ;int 10h (es decir las 4 instrucciones borran la pantalla)\n" +
"ENDM                                                    ;fin de la macro limpant   \n" +
";--------------------------------------------------------\n" +
";IMPRIMIR                                               :\n" +
";--------------------------------------------------------\n" +
"printmsj MACRO mensa                                    ;macro que imprime mensaje\n" +
"    lea dx,mensa                                        ;asigna la direccion inicial de desplazamiento\n" +
"                                                        ;de la localidad de memoria mensa al registro DX(DS:DX)\n" +
"    mov ah,09                                           ;asigna la funcion 09 de la INT 21h\n" +
"    int 21h                                             ;a AH(aparece mensaje en pantalla)\n" +
"ENDM                                                    ;fin de la macro printmsj \n" +
"                                                                                       \n" +
"\n" +
";--------------------------------------------------------                                     \n" +
"    .model small                                        ;define el modelo de memoria\n" +
"	.stack                                              ;define area de pila\n" +
"	.data                                               ;define el area de datos\n" +
";--------------------------------------------------------\n" +
";SEGMENTO DE DATOS                                      :\n" +
";--------------------------------------------------------\n" +
"numero1 db  "+in14+","+in13+","+in12+","+in11        + ";se define la tabla numero1\n" +
"numero2 db  " +in24+","+in23+","+in22+","+in21+                                 ";se define la tabla numero2\n" +
"resula  db  0,0,0,0                                     ;se define la tabla resula\n" +
"resres  db  30,30,30,30                                 ;se define la tabla resres\n" +
"signo1  db  ?                                           ;se define la variable signo1\n" +
"signo2  db  ?                                           ;se define la variable signo2\n" +
"signor  db  ?                                           ;se define la variable signor\n" +
"signo   db  '-$'                                        ;asigna la cadena a la variable signo\n" +
"punto   db  '.$'                                        ;asigna la cadena a la variable punto\n" +
"me_nos  db '-$'\n" +
"sumgua1 db  0                                           ;se define la variable sumgua1\n" +
"sumgua2 db  0                                           ;se define la variable sumgua2\n" +
".code                                               ;define area de codigo                      \n" +
"inicia: \n" +
"inicio  \n" +
"mov signo2,2DH \n"+
                    
"mov signo1,2DH \n"+
"call suma    \n" +
"fin\n" +
"\n" +
"endp inicia        \n" +
"        \n" +
"        \n" +
"suma proc                                       ;Procedimiento para Suma\n" +
"                            ;Invoca a la macro que imprime mensaje \n" +
"SALTO_DE_LA_RES:                                ;Salto que viene de la resta\n" +
";------------------------------------------------\n" +
";COMPARA SIGNOS                                 |\n" +
";------------------------------------------------   \n" +
"    mov ax,0h                                   ;Asigna 0 a AX        \n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo2 sea signo negativo \n" +
"    jz  tienesignonegativosum                   ;Salta si signo2 tiene signo negativo\n" +
"    jnz notienesignonegsum                      ;Salta si signo2 no tiene signo negativo\n" +
"tienesignonegativosum:                          ;Etiqueta para sign2 es negativo\n" +
"    cmp signo1,'-'                              ;Compara el contenido de signo1 sea signo negativo\n" +
"    jz  tiene2signonegativosum                  ;Salta si signo1 tiene signo negativo\n" +
"    jnz notiene2signonegsum                     ;Salta si signo1 no tiene signo negativo\n" +
"tiene2signonegativosum:                         ;Etiqueta para cuando signo1 no tiene signo negativo\n" +
"    printmsj signo                              ;Invoca a la marco para imprimir signo\n" +
"    jmp tiene2signonegativosum2                 ;Salta a suma normal por que no hay negativos\n" +
"notienesignonegsum:                             ;Etiqueta para signo2 no es negativo\n" +
"    cmp signo1,'-'                              ;Compara el contenido de signo1 sea signo negativo\n" +
"    jz  tienesignonegativosum1                  ;Salta si signo1 tiene signo negativo\n" +
"    jnz notienesignoneg1                        ;Salta si signo1 no tiene signo negativo\n" +
"notiene2signonegsum:                            ;Etiqeuta para cuando signo1 no es negativo\n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo2 con '-'\n" +
"    jz  tienesignonegativosum1                  ;Salta si el contenido de signo2 es negativo\n" +
"    jnz notienesignoneg1                        ;Salta si el contnenido de signo2 no es negativo\n" +
"tienesignonegativosum1:                         ;Etiqueta para cuando signo2 es negativo\n" +
"    mov al,numero1+3                            ;Asigna el contenido de la direccion de memoira de numero1+3 a AL\n" +
"    cmp al,numero2+3                            ;Compara el contenido de numero1+3 con AL\n" +
"    ja  mayorsum                                ;Salta si AL es mayor y numero2+3 es menor\n" +
"    jb  menorsum                                ;Salta  si AL es menor y numero2+3 es mayor\n" +
"    je  verificarsegnumero                      ;Salta si son iguales \n" +
"verificarsegnumero:                             ;Etiqueta si son iguales va verifcando numero por numero\n" +
"    mov al,numero1+2                            ;Asigna el contenido de la direccion de memoira de numero1+2 a AL\n" +
"    cmp al,numero2+2 ;                          ;Compara el contenido de numero1+2 con AL\n" +
"    ja  mayorsum                                ;Salta si AL es mayor y numero2+2 es menor\n" +
"    jb  menorsum                                ;Salta  si AL es menor y numero2+2 es mayor\n" +
"    je  verificarsegnumero1                     ;Salta si son iguales     \n" +
"verificarsegnumero1:                            ;Etiqueta si son iguales va verifcando numero por numero\n" +
"    mov al,numero1+1                            ;Asigna el contenido de la direccion de memoira de numero1+1 a AL\n" +
"    cmp al,numero2+1                            ;Compara el contenido de numero1+1 con AL\n" +
"    ja  mayorsum                                ;Salta si AL es mayor y numero2+1 es menor\n" +
"    jb  menorsum                                ;Salta  si AL es menor y numero2+1 es mayor\n" +
"    je  verificarssegnumero2                    ;Salta si son iguales \n" +
"verificarssegnumero2:                           ;Etiqueta si son iguales va verifcando numero por numero\n" +
"    mov al,numero1+0                            ;Asigna el contenido de la direccion de memoira de numero1+0 a AL\n" +
"    cmp al,numero2+0                            ;Compara el contenido de numero1+0 con AL\n" +
"    ja  mayorsum                                ;Salta si AL es mayor y numero2+0 es menor\n" +
"    jb  menorsum                                ;Salta  si AL es menor y numero2+0 es mayor\n" +
"    je  igualsum                                ;Salta si son iguales  \n" +
";------------------------------------------------\n" +
";NUMEROS IGUALES                                 |\n" +
";------------------------------------------------ \n" +
"igualsum:                                       ;Etiqueta si son numeros iguales \n" +
"    cmp signo1,'-'                              ;Compara el contenido de signo1 con '-'\n" +
"    jz  tienesigno00                            ;Salta si signo1 es negativo\n" +
"    jnz notienesigno00                          ;Salta si signo1 no es negativo\n" +
"tienesigno00:                                   ;Etiqueta si signo1 es negativo\n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum00:                                   ;Etiqueta de Ciclo que resta cuando numero 1 tiene signpo negativo  \n" +
"    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incrementa BX en 1\n" +
"    loop sisignosum00                           ;Ciclo que resta cuando los numeros son iguales\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion\n" +
"notienesigno00:                                 ;Etiqueta si el signo1 no es negativo\n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo2 con '-'\n" +
"    jz  tienesigno0                             ;Salta si signo2 es negativo \n" +
"    jnz notienesigno0                           ;Salta si signo2 no es negativo\n" +
"tienesigno0:                                    ;Etiqueta si signo2 es negativo           \n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum0:                                    ;Etiqueta de ciclo que resta cuando numero2 tiene signo negativo \n" +
"    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incrementa bx en 1\n" +
"    loop sisignosum0                            ;Ciclo para restar  \n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion     \n" +
";------------------------------------------------\n" +
";NUMERO MAYOR                                |\n" +
";------------------------------------------------     \n" +
"mayorsum:                                       ;Etiqueta AL es mayor y numero2+0 es menor    \n" +
"    cmp signo1,'-'                              ;Compara el contenido de signo1 con '-'\n" +
"    jz  tienesigno1                             ;Salta a tieneigno1 cuando signo1 es el mayor y es negativo\n" +
"    jnz notienesigno1                           ;Salta a notienesigno1 cuando signo1 es el mayor y no es negativo\n" +
"tienesigno1:                                    ;Etiqueta si signo1 es negativo  y mayor\n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum1:                                    ;Etiqueta de ciclo que resta cuando numero1 tiene signo negativo\n" +
"    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incremeta bx en 1\n" +
"    loop sisignosum1                            ;Ciclo para restar\n" +
"    printmsj signo                              ;Invoca a la macro printmsj para imprimir signo\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion\n" +
"notienesigno1:                                  ;Etiqueta si signo1 es mayor pero no es negativo \n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo2 con '-'\n" +
"    jz  tienesigno3                             ;Salta si signo2 es el menor y es negativo\n" +
"    jnz notienesigno3                           ;Salta cuando signo2 es el menor y no es negativo\n" +
"tienesigno3:                                    ;Etiqueta cuando signo2 es el menor y  es negativo\n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum2:                                    ;Etiqueta de ciclo que resta cuando numero2 tiene signo negativo\n" +
"    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incremeta bx en 1\n" +
"    loop sisignosum2                            ;Ciclo para restar\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion  \n" +
";------------------------------------------------\n" +
";NUMERO MENOR                                 |\n" +
";------------------------------------------------ \n" +
"menorsum:                                       ;Salta si AL es menor y numero2+0 es mayor\n" +
"    cmp signo2,'-'                              ;Compara el contenido de signo1 con '-'\n" +
"    jz  tienesigno2                             ;Salta si signo2 es negativo\n" +
"    jnz notienesigno2                           ;Salta si signo2 no es negativo\n" +
"tienesigno2:                                    ;Etiqueta si signo21 es negativo y mayor\n" +
"    mov cx,4                                    ;asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum3:                                    ;Etiqueta de ciclo que resta cuando numero1 tiene signo negativo\n" +
"    signo_suma numero1+bx,numero2+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;incremeta bx en 1\n" +
"    loop sisignosum3                            ;Ciclo para restar\n" +
"    printmsj signo                              ;Invoca a la macro printmsj para imprimir signo\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion\n" +
"notienesigno2:                                  ;Salta si signo1 es negativo y es menor \n" +
"    cmp signo1,'-'                              ;Comapra el contenido de signo1 con '-'\n" +
"    jz  tienesigno4                             ;Salta si signo1 es negativo y es menor \n" +
"    jnz notienesigno4                           ;Salta si signo1 no es negativo y es menor \n" +
"tienesigno4:                                    ;Etiqueta para  signo1 es negativo y es menor \n" +
"    mov cx,4                                    ;Asigna 4 a CX\n" +
"    mov bx,0                                    ;Asigna 0 a BX\n" +
"sisignosum4:                                    ;Etiqueta de ciclo que resta cuando numero2 tiene signo negativo\n" +
"    signo_suma numero1+bx,numero2+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion\n" +
"    inc bx                                      ;Incrementa BX en 1\n" +
"    loop sisignosum4                            ;Ciclo para restar\n" +
"    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion \n" +
"notienesigno0:                                  ;Etiqueta cuando signo1 y signo2 no son negativo\n" +
"notienesigno4:                                  ;Etiqueta cuando signo1 y signo2 no son negativo\n" +
"notienesigno3:                                  ;Etiqueta cuando signo1 y signo2 no son negativo\n" +
"notienesignoneg1:                               ;Etiqueta para cuando signo2 no es negativo\n" +
"tiene2signonegativosum2:                        ;Etiqueta par cuandon ninguno de los 2 numeros tiene signo   \n" +
";------------------------------------------------\n" +
";SUMA NORMAL                                    |\n" +
";------------------------------------------------ \n" +
"	mov cx,4                                    ;Asigna 4 a CX     \n" +
"	mov bx,0                                    ;Asigna 0 a BX\n" +
"	mov ax,0                                    ;Asigna 0 a AX\n" +
"sumaciclo1:                                     ;Ciclo que hace la operacion de sumar\n" +
"    mov al,[numero1+bx]                         ;asigna el contenido de la direccion de memoria dada  por \n" +
"                                                ;el desplazamiento de numero1 mas BX a AL\n" +
"    cmp al,0dh                                  ;Compara AL con 0dh(salto)\n" +
"    jz  sumerror1                               ;Salta a sumerror1 si AL es 0dh\n" +
"    jnz sumerror2                               ;Salta a sumerror2 si AL no es 0dh\n" +
"    cmp al,6bh                                  ;Compara AL con 6bh\n" +
"    jz  sumerror3                               ;Salta a sumerror3 si AL es 6bh\n" +
"    jnz sumerror4                               ;Salta a sumerror4 si AL no es 6bh  \n" +
"sumerror1:                                      ;Etiqueta para AL es 0dh, asigna 0h a AL\n" +
"    mov al,0h                                   ;Asigna 0h a AL \n" +
"sumerror2:                                      ;Etiqueta para AL no es 0dh, no asigna 0h a AL\n" +
"    cmp al,2eh                                  ;Compara AL con 2eh(punto)\n" +
"    jz  puntosum_sa                             ;Salta a puntosum_sa, si AL es 2eh\n" +
"    jnz nopuntosum_sa                           ;Salta a nopuntosum_sa, si AL no es 2eh\n" +
"nopuntosum_sa:                                  ;Etiqueta para AL no es 2eh, no hay punto       \n" +
"    mov sumgua1,al                              ;Asigna el contenido de al a sumgual1                              \n" +
"    mov al,[numero2+bx]                         ;asigna el contenido de la direccion de memoria dada  por \n" +
"                                                ;el desplazamiento de numero2 mas BX a AL\n" +
"    cmp al,2eh                                  ;Compara AL con 2eh(punto)\n" +
"    jz  puntosum_sa1                            ;Salta a puntosum_sa1, si AL es 2eh\n" +
"    jnz nopuntosum_sa1                          ;Salta a nopuntosum_sa1, si AL no es 2eh\n" +
"nopuntosum_sa1:                                 ;Etiqueta para AL no es 2eh, no hay punto\n" +
"    cmp al,0dh                                  ;Compara AL con 0dh(salto)\n" +
"    jz  sumerror3                               ;Salta a sumerror3, si AL es 0dh\n" +
"    jnz sumerror4                               ;Salta a sumerror4, si AL no es 0dh\n" +
"    cmp al,6bh                                  ;Compara AL con 6bh\n" +
"    jz  sumerror3                               ;Salta a sumerror3, si AL es 6bh\n" +
"    jnz sumerror4                               ;Salta a sumerror4, si AL no es 6bh\n" +
"sumerror3:                                      ;Etiqueta para AL es 0dh, asigna 0h a AL\n" +
"    mov al,0h                                   ;Asigna 0h a AL\n" +
"sumerror4:                                      ;Etiqueta para AL no es 0dh, no asigna 0h a AL\n" +
"    add al,ah                                   ;suma AH a AL y lo guarda en AL \n" +
"    mov ah,0h                                   ;Asigna 0h a AH\n" +
"    add al,sumgua1                              ;suma sumgua1 a AL y lo guarda en AL\n" +
"	aaa                                         ;ajuste ascii de la suma \n" +
"	add ax,30h                                  ;suma 30h a AL y lo guarda en AL	 \n" +
"puntosum_sa1:                                   ;Etiqueta para AL es 2eh, hay punto y lo guardamos en resula\n" +
"puntosum_sa:                                    ;Etiqueta para AL es 2eh, hay punto y lo guardamos en resula\n" +
"	mov resula+bx,al                            ;Se asigna AL a la direccion de memoria de resula + bx \n" +
"	inc bx                                      ;Incrementa BX en uno\n" +
"    loop sumaciclo1                             ;Ciclo que hace la operacion de sumar  \n" +
"    salirsignosum:                              ;Etiqueta que termina las operaciones con signo\n" +
"    sumaprint1                                  ;Invoca a la macro sumaprint para imprimir la tabal resula        \n" +
"    ret                                         ;retorna a donde fue llamado el procedimiento\n" +
"suma endp                                       ;finaliza el procedimiento sum\n" +
"\n" +
"resta proc                                 ;procedimiento que efectua la resta\n" +
";-----------------------------------------\n" +
";IMPRIME Y PIDE DATOS                   ||\n" +
";-----------------------------------------    \n" +
";------------------------------------------\n" +
";COMPARA SIGNOS                           |\n" +
";------------------------------------------\n" +
"COMPARA_SIGNOS:                            ;etiqueta que compara los signos\n" +
"    mov dh,[signo1]                        ;mueve el contenido de la direccion de memoria\n" +
"                                           ;dada por signo1\n" +
"    mov dl,[signo2]                        ;mueve el contenido de la direccion de memoria\n" +
"                                           ;dada por signo1\n" +
"    cmp dh,dl                              ;compara dh con dl (los signos) para saltar a\n" +
"    jz  SIH_IGUAL                          ;la etiueta de signos iguales\n" +
"    JMP SIH_DIFE                           ;en caso contario salta a signos diferentes\n" +
"SIH_DIFE:                                  ;etiqueta de signos diferentes\n" +
"    cmp dh,'-'                             ;compara si los signos son positivos o negativos\n" +
"    jz  c_sig1                             ;salta si el premer signo es nehativo\n" +
"    jmp c_sig2                             ;salta si el segundo signo es negativo\n" +
"c_sig2:                                    ;etiqueta cambia el signo de numero2\n" +
"    mov signo2,00h                         ;asigna un signo positivo al numero 2\n" +
"    jmp SALTO_DE_LA_RES                    ;etiqueta que salta a la suma\n" +
"c_sig1:                                    ;etiqueta cambia signo numero1\n" +
"    mov signo2,'-'                         ;asigna un signo negativo al numero2\n" +
"    jmp SALTO_DE_LA_RES                    ;etiqueta que salta a la suma\n" +
"SIH_IGUAL:                                 ;etiqueta si los signos son iguales\n" +
"    cmp dh,'-'                             ;compara signo de numero1 para saltar a la\n" +
"    jz COMPARA_MAYOR                       ;etiqueta que compara el numero mayor\n" +
"    jmp COMPARA_NUMEROS                    ;en caso contrario salta a comparar(para resta)\n" +
"IMPRIME_MENOS:                             ;etiqueta que imprime un sino negativo\n" +
"     printmsj   me_nos                     ;invoca a la macro para imprimir un signo negativo\n" +
"     JMP COMPARA_NUMEROS                   ;salta para comparar numeros(para resta)\n" +
";------------------------------------------\n" +
";COMPARA NUMERO MAYOR                     |\n" +
";------------------------------------------\n" +
"COMPARA_MAYOR:                             ;etiqueta que compara numeros (saber mayor)\n" +
"    mov bx,03h                             ;asigna 03h a bx(repite 3 veces)\n" +
"COM_DEN2:                                  ;etiqueta para comparar de nuevo    \n" +
"    mov dh,[numero1+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a dh dado por numero1+bx (bx=3,2,1,0)\n" +
"    mov dl,[numero2+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a dl dado por numero2+bx (bx=3,2,1,0)\n" +
"    cmp dh,dl                              ;compara dh con dl para saltar a la etiqueta\n" +
"    jg  IMPRIME_MENOS                      ;salta si es mas grande DH(numero1)\n" +
"    jb  RESTA_ALREVES                      ;salta si es mas grande DL(numero2)\n" +
"    dec bx                                 ;decrementa en uno bx(bx=3,2,1,0)\n" +
"    jmp COM_DEN2                           ;salta(regresa) si los numeros son iguales\n" +
"COMPARA_NUMEROS:                           ;compara numeros(para resta invertida)\n" +
"    mov bx,03h                             ;asigna 03h a bx(repite 3 veces)\n" +
"COM_DEN:                                   ;etiqueta para comparar de nuevo\n" +
"    mov dh,[numero1+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a dh dado por numero1+bx (bx=3,2,1,0)\n" +
"    mov dl,[numero2+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a dl dado por numero2+bx (bx=3,2,1,0)\n" +
"    cmp dh,dl                              ;compara dh con dl para saltar a la etiqueta\n" +
"    jg  RESTANOR                           ;salta si es mas grande DH(numero1)(resta normal)\n" +
"    jb  RESTA_ALREVES_S                    ;salta si es mas grande DL(numero2)(resta invertida)\n" +
"    cmp bx,00h                             ;compara si bx es cero(numeros iguales)\n" +
"    jz  RESTANOR                           ;si BX es cero salta a resta normal\n" +
"    dec bx                                 ;decrementa BX en uno\n" +
"    jmp COM_DEN                            ;salta para comparar el sigiente digito\n" +
"RESTANOR:                                  ;etiqueta de resta normal\n" +
"    LEA si,numero1                         ;asigna la direccion de mamoria al registro SI(indice fuente)\n" +
"    LEA dI,numero2                         ;asigna la direcion de memoria al registro DI[indice destino]\n" +
"    mov bx,00h                             ;restablese en ceros a bx\n" +
"    jmp COM_N                              ;salta para comparar numeros\n" +
"RESTA_ALREVES_S:                           ;etiqueta para resta inversa(imprime menos)\n" +
"    printmsj me_nos                        ;invoca a la macro para imptimir un signo menos\n" +
"    JMP RESTA_ALREVES                      ;salta a la resta al incerza\n" +
";------------------------------------------\n" +
";CAMBIA DE ORDEN LOS NUMEROS              |\n" +
";------------------------------------------\n" +
"RESTA_ALREVES:                             ;resta iinverza cambia numeros de pocicion\n" +
"    mov bx,00h                             ;restablese bx en cero\n" +
"repite_al:                                 ;etiqueta que repite 3 veces\n" +
"    mov al,[numero1+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a al dado por numero1+bx(BX=0,1,2,3)\n" +
"    mov [resula+bx],al                     ;mueve el contenido de AL a la direccion de memoria \n" +
"                                           ;dada por resula+bx (BX=0,1,2,3)\n" +
"    mov al,[numero2+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a al dado por numero2+bx(BX=0,1,2,3)\n" +
"    mov [numero1+bx],al                    ;mueve el contenido de AL a la direccion de memoria \n" +
"                                           ;dada por numero1+bx (BX=0,1,2,3)\n" +
"    mov al,[resula+bx]                     ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a al dado por resula+bx(BX=0,1,2,3)\n" +
"    mov [numero2+bx],al                    ;mueve el contenido de AL a la direccion de memoria \n" +
"                                           ;dada por numero2+bx (BX=0,1,2,3)\n" +
"    inc bx                                 ;incrementa bx en uno\n" +
"    cmp bx,04h                             ;compara si bx es igual a 04h para saltar a la \n" +
"    jz  RESTANOR                           ;etiqueta de resta normal\n" +
"    jmp repite_al                          ;salta para repetir 3 veces\n" +
";------------------------------------------\n" +
";COMPARA PARA RESTAR                      |\n" +
";------------------------------------------\n" +
"COM_N:                                     ;etiqueta que compara numeros(acarreo o no)\n" +
"    mov dh,[numero1+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a DH dado por numero1+bx(BX=0,1,2,3)\n" +
"    mov dl,[numero2+bx]                    ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a DL dado por numero2+bx(BX=0,1,2,3)\n" +
"    cmp dh,dl                              ;compara dh con dl\n" +
"    jb RES_INV                             ;salta a la resta con acarreo si dh(numero1) es mayor\n" +
"    jmp  OPE_RESN                          ;salta a la resta normal si DL es mayor(numero2)  \n" +
"    INC bx                                 ;incrementa en uno al registro bx\n" +
"    cmp bx,03H                             ;compara si BX es igual a 03h\n" +
"    jz  RES_CERO                           ;si bx es 03h salta aa imprimir cero(numeros iguales)\n" +
"    cmp dh,dl                              ;compara si dh y dl son iguales\n" +
"    jz  COM_N                              ;si son iguales repite la comparacion\n" +
";------------------------------------------\n" +
";RESULTADO CERO\n" +
";------------------------------------------\n" +
"RES_CERO:                                  ;etiqueta que da resultado cero\n" +
"     JMP IMP_RES2                          ;salta para imprimir resultado\n" +
";------------------------------------------            \n" +
";RESTA NORMAL                             |\n" +
";------------------------------------------ \n" +
"OPE_RESN:                                  ;etiqueta que resta numero 1- numero2\n" +
"    mov ax,00h                             ;restablece AX a cero\n" +
"    mov al,[SI]                            ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por SI\n" +
"    sbb al,[DI]                            ;resta el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por DI\n" +
"    AAS                                    ;ajusta el resultado despues de la resta\n" +
"    mov [resres+bx],AL                     ;mueve el conteniado de AL a la direccion de memoria\n" +
"                                           ;dado por resres+bx(BX=0,1,2,3)\n" +
"    cmp bx,03h                             ;compara el contenido de bx con 03h para saltar a la \n" +
"    jz  IMP_RES2                           ;etiqueta que imprime el resultado\n" +
"    INC SI                                 ;invcrementa en uno a SI(apunta a la siguente pocicon)\n" +
"    INC DI                                 ;invcrementa en uno a DI(apunta a la siguente pocicon)\n" +
"    INC bx                                 ;invcrementa en uno a DX(apunta a la siguente pocicon)\n" +
"    jmp COM_N                              ;repite el proceso tres veces\n" +
";------------------------------------------    \n" +
";RESTA INVERTIDA                          |\n" +
";------------------------------------------    \n" +
"RES_INV:                                   ;etiqueta que efectua resta inverida (acarreo)\n" +
"    mov ax,00h                             ;restablece AX a cero\n" +
"    mov al,[SI]                            ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por SI\n" +
"    ADD AL,10H                             ;suma 10h al contenido de AL\n" +
"    sbb al,[DI]                            ;resta el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por DI\n" +
"    AAS                                    ;ajusta el resultado despues de la resta\n" +
"    mov [resres+bx],AL                     ;mueve el conteniado de AL a la direccion de memoria\n" +
"                                           ;dado por resres+bx(BX=0,1,2,3)\n" +
"    jmp ACARREO_RES                        ;salta para efectuar acarreo\n" +
";------------------------------------------\n" +
";ACARREO                                  |\n" +
";------------------------------------------\n" +
"ACARREO_RES:                               ;etiqueta que efectua acarreo\n" +
"    mov dx,00h                             ;restablece a cero bx\n" +
"    mov dl,[NUMERO1+bx+1]                  ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a AL dado por numero1+bx+1\n" +
"    cmp dl,00h                             ;compara el contenido de dl con cero pasa altar a la \n" +
"    jz  ACARREO_RES2:                      ;etiqueta que suma una al minuendo\n" +
"    dec dl                                 ;decrementa dl para efectuar acarreo\n" +
"    mov [numero1+bx+1],dl                  ;mueve el conteniado de DL a la direccion de memoria\n" +
"                                           ;dado por numero1+bx+1(BX=0,1,2,3)\n" +
"    cmp bx,03H                             ;compara el contenido de bx con 03h para saltar a la\n" +
"    jz  IMP_RES2                           ;etiqueta que imprime el resultado\n" +
"    inc bx                                 ;invcrementa en uno a BX(apunta a la siguente pocicon)\n" +
"    INC SI                                 ;invcrementa en uno a SI(apunta a la siguente pocicon)\n" +
"    INC DI                                 ;invcrementa en uno a DI(apunta a la siguente pocicon)\n" +
"    jmp COM_N                              ;salta para repetir el proceso 3 veces        \n" +
"ACARREO_RES2:                              ;etiqueta de acarreo que suma al minuendo\n" +
"    MOV dx,00h                             ;restitulle en cero al contenido del registro dx\n" +
"    mov dl,[numero2+bx+1]                  ;asigna a dl el contenido de la direccion de memoria dado\n" +
"                                           ;por el desplasamiento de numero2+bx+1\n" +
"    inc dl                                 ;incrementa en 1 al contenido del registro dl\n" +
"    mov [numero2+bx+1],dl                  ;aigna el contenido de dl en la direccion de memoria \n" +
"                                           ;dada por el desplasamiento de la suma de numero2+bx+1 \n" +
"    cmp bx,03H                             ;compara el contenido de bx con 03h para saltar a la\n" +
"    jz  IMP_RES2                           ;etiqueta que imprime el resultado\n" +
"    inc bx                                 ;invcrementa en uno a BX(apunta a la siguente pocicon)\n" +
"    INC SI                                 ;invcrementa en uno a SI(apunta a la siguente pocicon)\n" +
"    INC DI                                 ;invcrementa en uno a DI(apunta a la siguente pocicon)\n" +
"    jmp COM_N\n" +
"    \n" +
";------------------------------------------\n" +
";IMPRIME EL RESULTADO                     |\n" +
";------------------------------------------        \n" +
"IMP_RES2:                                  ;etiqueta que imprime el resultado\n" +
"   mov  bx,00h                             ;restablece en ceros a BX\n" +
"REPITE_IM:                                 ;etiqueta para mover de resres a resula\n" +
"   mov  dx,00h                             ;restablece en cero a DX\n" +
"   mov  dl,[resres+bx]                     ;mueve el contenido de la direccion de memoria\n" +
"                                           ;a DL dado por resres+bx(BX=0,2,3)\n" +
"   add  dl,30h                             ;suma 30h al contenido de DL(pasa a ASCII)\n" +
"   mov  [resula+bx],dl                     ;mueve el conteniado de DL a la direccion de memoria\n" +
"                                           ;dado por resula+bx(BX=0,1,2,3)\n" +
"   inc  bx                                 ;incrementa bx en uno(BX=0,1,2,3)\n" +
"   cmp  bx,04h                             ;compara en contenido de BX con 04h\n" +
"   jz   MANDAR                             ;si bx es cuatro manda a llamar a la macro\n" +
"   jmp  REPITE_IM                          ;en caso contrario repite el proceso\n" +
";------------------------------------------\n" +
";MANDA A IMPRIMIR                       |||\n" +
";------------------------------------------   \n" +
"MANDAR:                                    ;etiqueta que llama a la macro para imprimir\n" +
"sumaprint1                                 ;invoca a ala macro que imprime el resultado    \n" +
";------------------------------------------\n" +
";BORRA EL CONTENIDO DE LAS VARIABLES  |||||\n" +
";------------------------------------------\n" +
"BORRAR:                                    ;etiqueta que borra el contenido de las variebles\n" +
"    mov signo1,00h                         ;restablece el contenido de signo1 a cero\n" +
"    mov signo2,00h                         ;restablece el contenido de signo2 a cero\n" +
"    mov  bx,00h                            ;restablcece el contenido de bx en cero\n" +
"REPI_CLEAR:                                ;etiqueta que repite el proceso de borrar\n" +
"   mov  dx,00h                             ;restablece en cero el contenido de dx\n" +
"   mov  [resres+bx],00h                    ;mueve 00h a la direccion de memoria\n" +
"                                           ;dado por resres+bx(BX=0,1,2,3)\n" +
"   mov  [resula+bx],00h                    ;mueve 00h a la direccion de memoria\n" +
"                                           ;dado por resula+bx(BX=0,1,2,3)\n" +
"   inc  bx                                 ;incrementa en uno el contenido de BX\n" +
"   cmp  bx,4                               ;compara se es 04h el contenido de BX si lo es\n" +
"   jz   FIN                                ;salta a la etiqueta fin\n" +
"   jmp  REPI_CLEAR                         ;en caso contrario repite el proceso de borrado\n" +
";------------------------------------------\n" +
";FINALIZA LA RESTA                       ||\n" +
";------------------------------------------       \n" +
"FIN:                                       ;etiqueta que finaliza la resta\n" +
"    ret                                    ;retorna a donde fue llamado el procedimiento\n" +
"resta endp        " ;
        try (BufferedWriter archivobf = new BufferedWriter(archivo)) {
            archivo.write(Texto);
        }
}
public void imprime_asm(String ultimo_t) throws IOException{
    FileWriter archivoa = null;
    archivoa = new FileWriter("C:/Users/crizs/Desktop/Analizador03/archivo.asm",true);
        try (BufferedWriter archivobf = new BufferedWriter(archivoa)) {
            String Texto="\nMOV AX,"+ultimo_t+"\nMOV ah,0\n"+
                    "MOV ch,10\n"
                    +"DIV ch\n"
                    +"mov dh,ah\n"
                    +"add al,30h\n"
                    +"mov dl,al\n"
                    +"mov ah,02\n"
                    +"INT 21H\n"
                    +"mov al,dh\n"
                    +"add al,30h\n"
                    +"mov dl,al\n"
                    +"mov ah,02\n"
                    +"INT 21H\n";
            archivoa.write(Texto);
        }
    
}
public void final_asm() throws IOException{
    FileWriter archivoa = null;
    archivoa = new FileWriter("C:/Users/crizs/Desktop/Analizador03/archivo.asm",true);
        try (BufferedWriter archivobf = new BufferedWriter(archivoa)) {
            String Texto="\nEND INI";
            archivoa.write(Texto);
        }
}
public void agrega_multi(String valor1, String valor2,String temporal) throws IOException{
     FileWriter archivoa = null;
    archivoa = new FileWriter("C:/Users/crizs/Desktop/Analizador03/archivo.asm",true);
        try (BufferedWriter archivobf = new BufferedWriter(archivoa)) {
            String Texto="\nSUB AX,AX"+"\nMOV AX,"+valor1+"\n"+"MOV BX,"+valor2+"\n"+"MUL BL"+"\n"+"MOV "+temporal+",AX";
            
            archivoa.write(Texto);
        }
}
public void agrega_div(String valor1, String valor2,String temporal) throws IOException{
     FileWriter archivoa = null;
    archivoa = new FileWriter("C:/Users/crizs/Desktop/Analizador03/archivo.asm",true);
        try (BufferedWriter archivobf = new BufferedWriter(archivoa)) {
            String Texto="\nSUB AX,AX"+"\nMOV AX,"+valor1+"\n"+"MOV BL,"+valor2+"\n"+"DIV BL"+"\n"+"MOV "+temporal+",AX";
            
            archivoa.write(Texto);
        }
}
public void agrega_suma(String valor1,String valor2,String temporal ) throws IOException{
     FileWriter archivoa = null;
    archivoa = new FileWriter("C:/Users/crizs/Desktop/Analizador03/archivo.asm",true);
        try (BufferedWriter archivobf = new BufferedWriter(archivoa)) {
            String Texto="\nSUB AX,AX"+"\nMOV AX,"+valor1+"\n"+"ADD"+" "+"AX,"+valor2+"\n"+"MOV "+temporal+",AX";
            
            archivoa.write(Texto);
        }
    
}
public void agrega_resta(String valor1,String valor2,String temporal) throws IOException{
     FileWriter archivoa = null;
    archivoa = new FileWriter("C:/Users/crizs/Desktop/Analizador03/archivo.asm",true);
        try (BufferedWriter archivobf = new BufferedWriter(archivoa)) {
            String Texto="\nSUB AX,AX"+"\n SUB BX,BX"+"\nMOV AX,"+valor1+"\n"+"MOV BX,"+valor2+"\n" +
"SUB AX,BX\n"+"MOV "+temporal+",AX";
            
            archivoa.write(Texto);
        }
}
public void crea_t_x(String tx) throws IOException{
     FileWriter archivoa = null;
    archivoa = new FileWriter("C:/Users/crizs/Desktop/Analizador03/archivo.asm",true);
        try (BufferedWriter archivobf = new BufferedWriter(archivoa)) {
            String Texto="\n"+ tx +" dw 0\n";
            archivoa.write(Texto);
        }
}
public void inicializa_asm() throws IOException{
      FileWriter archivoa = null;
    archivoa = new FileWriter("C:/Users/crizs/Desktop/Analizador03/archivo.asm",true);
        try (BufferedWriter archivobf = new BufferedWriter(archivoa)) {
            String Texto=
"\n" +
"INI:\n" +
"    MOV AX,@data\n" +
"    MOV DS,AX\n";
            archivoa.write(Texto);
        }   
    
}
  public void multiplica(String valor1,String valor2,String temporal){
      if("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1)
              ||"t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)){
          //tx,num
            if(("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1))&&(!("t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)))){
                    switch(valor1){
                        case "t1":
                            switch(temporal){
                                case"t1":
                                    
                                    t1=t1*Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t1*Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t1*Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t1*Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t1*Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t1*Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t1*Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t1*Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t1*Float.parseFloat(valor2);
                                    break;    
                            }break; 
                        case "t2":
                            switch(temporal){
                                case"t1":
                                    t1=t2*Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t2*Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t2*Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t2*Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t2*Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t2*Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t2*Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t2*Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t2*Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t3":
                            switch(temporal){
                                case"t1":
                                    t1=t3*Float.parseFloat(valor2);;
                                    break;
                                case"t2":
                                   t2=t3*Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t3*Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t3*Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t3*Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t3*Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t3*Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t3*Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t3*Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t4":
                            switch(temporal){
                                case"t1":
                                    t1=t4*Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t4*Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t4*Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t4*Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t4*Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t4*Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t4*Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t4*Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t4*Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t5":
                            switch(temporal){
                                case"t1":
                                    t1=t5*Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t5*Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t5*Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t5*Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t5*Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t5*Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t5*Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t5*Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t5*Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t6":
                            switch(temporal){
                                case"t1":
                                    t1=t6*Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t6*Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t6*Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t6*Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t6*Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t6*Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t6*Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t6*Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t6*Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t7":
                           switch(temporal){
                                case"t1":
                                    t1=t7*Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t7*Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t7*Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t7*Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t7*Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t7*Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t7*Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t7*Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t7*Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t8":
                     switch(temporal){
                                case"t1":
                                    t1=t8*Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t8*Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t8*Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t8*Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t8*Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t8*Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t8*Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t8*Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t8*Float.parseFloat(valor2);
                                    break;    
                            }break;
                         }
                    }
            //num,tx
            if(!(("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1)))&&(("t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)))){
                    switch(valor2){
                        case "t1":
                            switch(temporal){
                                case"t1":
                                    t1=t1*Float.parseFloat(valor1);
                                    break;
                                case"t2":
                                   t2=t1*Float.parseFloat(valor1);
                                    break;
                                case"t3":
                                   t3=t1*Float.parseFloat(valor1);
                                    break;
                                case"t4":
                                   t4=t1*Float.parseFloat(valor1);
                                    break;
                                case"t5":
                                   t5=t1*Float.parseFloat(valor1);
                                    break;
                                case"t6":
                                   t6=t1*Float.parseFloat(valor1);
                                    break;
                                case"t7":
                                   t7=t1*Float.parseFloat(valor1);
                                    break; 
                                case"t8":
                                   t8=t1*Float.parseFloat(valor1);
                                    break; 
                                case"t9":
                                   t9=t1*Float.parseFloat(valor1);
                                    break;    
                            }break; 
                        case "t2":
                            switch(temporal){
                                case"t1":
                                    t1=t2*Float.parseFloat(valor1);
                                    break;
                                case"t2":
                                   t2=t2*Float.parseFloat(valor1);
                                    break;
                                case"t3":
                                   t3=t2*Float.parseFloat(valor1);
                                    break;
                                case"t4":
                                   t4=t2*Float.parseFloat(valor1);
                                    break;
                                case"t5":
                                   t5=t2*Float.parseFloat(valor1);
                                    break;
                                case"t6":
                                   t6=t2*Float.parseFloat(valor1);
                                    break;
                                case"t7":
                                   t7=t2*Float.parseFloat(valor1);
                                    break; 
                                case"t8":
                                   t8=t2*Float.parseFloat(valor1);
                                    break; 
                                case"t9":
                                   t9=t2*Float.parseFloat(valor1);
                                    break;    
                            }break;
                        case "t3":
                            switch(temporal){
                                case"t1":
                                    t1=t3*Float.parseFloat(valor1);
                                    break;
                                case"t2":
                                   t2=t3*Float.parseFloat(valor1);
                                    break;
                                case"t3":
                                   t3=t3*Float.parseFloat(valor1);
                                    break;
                                case"t4":
                                   t4=t3*Float.parseFloat(valor1);
                                    break;
                                case"t5":
                                   t5=t3*Float.parseFloat(valor1);
                                    break;
                                case"t6":
                                   t6=t3*Float.parseFloat(valor1);
                                    break;
                                case"t7":
                                   t7=t3*Float.parseFloat(valor1);
                                    break; 
                                case"t8":
                                   t8=t3*Float.parseFloat(valor1);
                                    break; 
                                case"t9":
                                   t9=t3*Float.parseFloat(valor1);
                                    break;    
                            }break;
                        case "t4":
                            switch(temporal){
                                case"t1":
                                    t1=t4*Float.parseFloat(valor1);
                                    break;
                                case"t2":
                                   t2=t4*Float.parseFloat(valor1);
                                    break;
                                case"t3":
                                   t3=t4*Float.parseFloat(valor1);
                                    break;
                                case"t4":
                                   t4=t4*Float.parseFloat(valor1);
                                    break;
                                case"t5":
                                   t5=t4*Float.parseFloat(valor1);
                                    break;
                                case"t6":
                                   t6=t4*Float.parseFloat(valor1);
                                    break;
                                case"t7":
                                   t7=t4*Float.parseFloat(valor1);
                                    break; 
                                case"t8":
                                   t8=t4*Float.parseFloat(valor1);
                                    break; 
                                case"t9":
                                   t9=t4*Float.parseFloat(valor1);
                                    break;    
                            }break;
                        case "t5":
                            switch(temporal){
                                case"t1":
                                    t1=t5*Float.parseFloat(valor1);
                                    break;
                                case"t2":
                                   t2=t5*Float.parseFloat(valor1);
                                    break;
                                case"t3":
                                   t3=t5*Float.parseFloat(valor1);
                                    break;
                                case"t4":
                                   t4=t5*Float.parseFloat(valor1);
                                    break;
                                case"t5":
                                   t5=t5*Float.parseFloat(valor1);
                                    break;
                                case"t6":
                                   t6=t5*Float.parseFloat(valor1);
                                    break;
                                case"t7":
                                   t7=t5*Float.parseFloat(valor1);
                                    break; 
                                case"t8":
                                   t8=t5*Float.parseFloat(valor1);
                                    break; 
                                case"t9":
                                   t9=t5*Float.parseFloat(valor1);
                                    break;    
                            }break;
                        case "t6":
                            switch(temporal){
                                case"t1":
                                    t1=t6*Float.parseFloat(valor1);
                                    break;
                                case"t2":
                                   t2=t6*Float.parseFloat(valor1);
                                    break;
                                case"t3":
                                   t3=t6*Float.parseFloat(valor1);
                                    break;
                                case"t4":
                                   t4=t6*Float.parseFloat(valor1);
                                    break;
                                case"t5":
                                   t5=t6*Float.parseFloat(valor1);
                                    break;
                                case"t6":
                                   t6=t6*Float.parseFloat(valor1);
                                    break;
                                case"t7":
                                   t7=t6*Float.parseFloat(valor1);
                                    break; 
                                case"t8":
                                   t8=t6*Float.parseFloat(valor1);
                                    break; 
                                case"t9":
                                   t9=t6*Float.parseFloat(valor1);
                                    break;    
                            }break;
                        case "t7":
                            switch(temporal){
                                case"t1":
                                    t1=t7*Float.parseFloat(valor1);
                                    break;
                                case"t2":
                                   t2=t7*Float.parseFloat(valor1);
                                    break;
                                case"t3":
                                   t3=t7*Float.parseFloat(valor1);
                                    break;
                                case"t4":
                                   t4=t7*Float.parseFloat(valor1);
                                    break;
                                case"t5":
                                   t5=t7*Float.parseFloat(valor1);
                                    break;
                                case"t6":
                                   t6=t7*Float.parseFloat(valor1);
                                    break;
                                case"t7":
                                   t7=t7*Float.parseFloat(valor1);
                                    break; 
                                case"t8":
                                   t8=t7*Float.parseFloat(valor1);
                                    break; 
                                case"t9":
                                   t9=t7*Float.parseFloat(valor1);
                                    break;    
                            }break;
                        case "t8":
                            switch(temporal){
                                case"t1":
                                    t1=t8*Float.parseFloat(valor1);
                                    break;
                                case"t2":
                                   t2=t8*Float.parseFloat(valor1);
                                    break;
                                case"t3":
                                   t3=t8*Float.parseFloat(valor1);
                                    break;
                                case"t4":
                                   t4=t8*Float.parseFloat(valor1);
                                    break;
                                case"t5":
                                   t5=t8*Float.parseFloat(valor1);
                                    break;
                                case"t6":
                                   t6=t8*Float.parseFloat(valor1);
                                    break;
                                case"t7":
                                   t7=t8*Float.parseFloat(valor1);
                                    break; 
                                case"t8":
                                   t8=t8*Float.parseFloat(valor1);
                                    break; 
                                case"t9":
                                   t9=t8*Float.parseFloat(valor1);
                                    break;    
                            }break;
                         }
                
                
                    }
            //tx,tx
            if(("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1))&&(("t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)))){
                    //temporal=valor1*valor2
                switch(valor1){
                    case "t1":
                        switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t1;
                                        break;
                                    case"t2":
                                        t2=t1*t1;
                                        break;
                                    case"t3":
                                        t3=t1*t1;
                                    case"t4":
                                        t4=t1*t1;
                                        break;
                                    case"t5":
                                        t5=t1*t1;
                                        break;
                                    case"t6":
                                        t6=t1*t1;
                                        break;
                                    case"t7":
                                        t7=t1*t1;
                                        break;
                                    case"t8":
                                        t8=t1*t1;
                                        break;
                                    case"t9":
                                        t9=t1*t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t2;
                                        break;
                                    case"t2":
                                        t2=t1*t2;
                                        break;
                                    case"t3":
                                        t3=t1*t2;
                                    case"t4":
                                        t4=t1*t2;
                                        break;
                                    case"t5":
                                        t5=t1*t2;
                                        break;
                                    case"t6":
                                        t6=t1*t2;
                                        break;
                                    case"t7":
                                        t7=t1*t2;
                                        break;
                                    case"t8":
                                        t8=t1*t2;
                                        break;
                                    case"t9":
                                        t9=t1*t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t3;
                                        break;
                                    case"t2":
                                        t2=t1*t3;
                                        break;
                                    case"t3":
                                        t3=t1*t3;
                                    case"t4":
                                        t4=t1*t3;
                                        break;
                                    case"t5":
                                        t5=t1*t3;
                                        break;
                                    case"t6":
                                        t6=t1*t3;
                                        break;
                                    case"t7":
                                        t7=t1*t3;
                                        break;
                                    case"t8":
                                        t8=t1*t3;
                                        break;
                                    case"t9":
                                        t9=t1*t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t4;
                                        break;
                                    case"t2":
                                        t2=t1*t4;
                                        break;
                                    case"t3":
                                        t3=t1*t4;
                                    case"t4":
                                        t4=t1*t4;
                                        break;
                                    case"t5":
                                        t5=t1*t4;
                                        break;
                                    case"t6":
                                        t6=t1*t4;
                                        break;
                                    case"t7":
                                        t7=t1*t4;
                                        break;
                                    case"t8":
                                        t8=t1*t4;
                                        break;
                                    case"t9":
                                        t9=t1*t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t5;
                                        break;
                                    case"t2":
                                        t2=t1*t5;
                                        break;
                                    case"t3":
                                        t3=t1*t5;
                                    case"t4":
                                        t4=t1*t5;
                                        break;
                                    case"t5":
                                        t5=t1*t5;
                                        break;
                                    case"t6":
                                        t6=t1*t5;
                                        break;
                                    case"t7":
                                        t7=t1*t5;
                                        break;
                                    case"t8":
                                        t8=t1*t5;
                                        break;
                                    case"t9":
                                        t9=t1*t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t6;
                                        break;
                                    case"t2":
                                        t2=t1*t6;
                                        break;
                                    case"t3":
                                        t3=t1*t6;
                                    case"t4":
                                        t4=t1*t6;
                                        break;
                                    case"t5":
                                        t5=t1*t6;
                                        break;
                                    case"t6":
                                        t6=t1*t6;
                                        break;
                                    case"t7":
                                        t7=t1*t6;
                                        break;
                                    case"t8":
                                        t8=t1*t6;
                                        break;
                                    case"t9":
                                        t9=t1*t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t7;
                                        break;
                                    case"t2":
                                        t2=t1*t7;
                                        break;
                                    case"t3":
                                        t3=t1*t7;
                                    case"t4":
                                        t4=t1*t7;
                                        break;
                                    case"t5":
                                        t5=t1*t7;
                                        break;
                                    case"t6":
                                        t6=t1*t7;
                                        break;
                                    case"t7":
                                        t7=t1*t7;
                                        break;
                                    case"t8":
                                        t8=t1*t7;
                                        break;
                                    case"t9":
                                        t9=t1*t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t8;
                                        break;
                                    case"t2":
                                        t2=t1*t8;
                                        break;
                                    case"t3":
                                        t3=t1*t8;
                                    case"t4":
                                        t4=t1*t8;
                                        break;
                                    case"t5":
                                        t5=t1*t8;
                                        break;
                                    case"t6":
                                        t6=t1*t8;
                                        break;
                                    case"t7":
                                        t7=t1*t8;
                                        break;
                                    case"t8":
                                        t8=t1*t8;
                                        break;
                                    case"t9":
                                        t9=t1*t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t9;
                                        break;
                                    case"t2":
                                        t2=t1*t9;
                                        break;
                                    case"t3":
                                        t3=t1*t9;
                                    case"t4":
                                        t4=t1*t9;
                                        break;
                                    case"t5":
                                        t5=t1*t9;
                                        break;
                                    case"t6":
                                        t6=t1*t9;
                                        break;
                                    case"t7":
                                        t7=t1*t9;
                                        break;
                                    case"t8":
                                        t8=t1*t9;
                                        break;
                                    case"t9":
                                        t9=t1*t9;
                                        break;
                                } break;
                        }break;
                    case "t2":
                        switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t1;
                                        break;
                                    case"t2":
                                        t2=t2*t1;
                                        break;
                                    case"t3":
                                        t3=t2*t1;
                                    case"t4":
                                        t4=t2*t1;
                                        break;
                                    case"t5":
                                        t5=t2*t1;
                                        break;
                                    case"t6":
                                        t6=t2*t1;
                                        break;
                                    case"t7":
                                        t7=t2*t1;
                                        break;
                                    case"t8":
                                        t8=t2*t1;
                                        break;
                                    case"t9":
                                        t9=t2*t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t2;
                                        break;
                                    case"t2":
                                        t2=t2*t2;
                                        break;
                                    case"t3":
                                        t3=t2*t2;
                                    case"t4":
                                        t4=t2*t2;
                                        break;
                                    case"t5":
                                        t5=t2*t2;
                                        break;
                                    case"t6":
                                        t6=t2*t2;
                                        break;
                                    case"t7":
                                        t7=t2*t2;
                                        break;
                                    case"t8":
                                        t8=t2*t2;
                                        break;
                                    case"t9":
                                        t9=t2*t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t3;
                                        break;
                                    case"t2":
                                        t2=t2*t3;
                                        break;
                                    case"t3":
                                        t3=t2*t3;
                                    case"t4":
                                        t4=t2*t3;
                                        break;
                                    case"t5":
                                        t5=t2*t3;
                                        break;
                                    case"t6":
                                        t6=t2*t3;
                                        break;
                                    case"t7":
                                        t7=t2*t3;
                                        break;
                                    case"t8":
                                        t8=t2*t3;
                                        break;
                                    case"t9":
                                        t9=t2*t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t4;
                                        break;
                                    case"t2":
                                        t2=t2*t4;
                                        break;
                                    case"t3":
                                        t3=t2*t4;
                                    case"t4":
                                        t4=t2*t4;
                                        break;
                                    case"t5":
                                        t5=t2*t4;
                                        break;
                                    case"t6":
                                        t6=t2*t4;
                                        break;
                                    case"t7":
                                        t7=t2*t4;
                                        break;
                                    case"t8":
                                        t8=t2*t4;
                                        break;
                                    case"t9":
                                        t9=t2*t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t5;
                                        break;
                                    case"t2":
                                        t2=t2*t5;
                                        break;
                                    case"t3":
                                        t3=t2*t5;
                                    case"t4":
                                        t4=t2*t5;
                                        break;
                                    case"t5":
                                        t5=t2*t5;
                                        break;
                                    case"t6":
                                        t6=t2*t5;
                                        break;
                                    case"t7":
                                        t7=t2*t5;
                                        break;
                                    case"t8":
                                        t8=t2*t5;
                                        break;
                                    case"t9":
                                        t9=t2*t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t6;
                                        break;
                                    case"t2":
                                        t2=t2*t6;
                                        break;
                                    case"t3":
                                        t3=t2*t6;
                                    case"t4":
                                        t4=t2*t6;
                                        break;
                                    case"t5":
                                        t5=t2*t6;
                                        break;
                                    case"t6":
                                        t6=t2*t6;
                                        break;
                                    case"t7":
                                        t7=t2*t6;
                                        break;
                                    case"t8":
                                        t8=t2*t6;
                                        break;
                                    case"t9":
                                        t9=t2*t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t7;
                                        break;
                                    case"t2":
                                        t2=t2*t7;
                                        break;
                                    case"t3":
                                        t3=t2*t7;
                                    case"t4":
                                        t4=t2*t7;
                                        break;
                                    case"t5":
                                        t5=t2*t7;
                                        break;
                                    case"t6":
                                        t6=t2*t7;
                                        break;
                                    case"t7":
                                        t7=t2*t7;
                                        break;
                                    case"t8":
                                        t8=t2*t7;
                                        break;
                                    case"t9":
                                        t9=t2*t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t8;
                                        break;
                                    case"t2":
                                        t2=t2*t8;
                                        break;
                                    case"t3":
                                        t3=t2*t8;
                                    case"t4":
                                        t4=t2*t8;
                                        break;
                                    case"t5":
                                        t5=t2*t8;
                                        break;
                                    case"t6":
                                        t6=t2*t8;
                                        break;
                                    case"t7":
                                        t7=t2*t8;
                                        break;
                                    case"t8":
                                        t8=t2*t8;
                                        break;
                                    case"t9":
                                        t9=t2*t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t9;
                                        break;
                                    case"t2":
                                        t2=t2*t9;
                                        break;
                                    case"t3":
                                        t3=t2*t9;
                                    case"t4":
                                        t4=t2*t9;
                                        break;
                                    case"t5":
                                        t5=t2*t9;
                                        break;
                                    case"t6":
                                        t6=t2*t9;
                                        break;
                                    case"t7":
                                        t7=t2*t9;
                                        break;
                                    case"t8":
                                        t8=t2*t9;
                                        break;
                                    case"t9":
                                        t9=t2*t9;
                                        break;
                                } break;
                        }break;
                  case"t3":    
                      switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t1;
                                        break;
                                    case"t2":
                                        t2=t3*t1;
                                        break;
                                    case"t3":
                                        t3=t3*t1;
                                    case"t4":
                                        t4=t3*t1;
                                        break;
                                    case"t5":
                                        t5=t3*t1;
                                        break;
                                    case"t6":
                                        t6=t3*t1;
                                        break;
                                    case"t7":
                                        t7=t3*t1;
                                        break;
                                    case"t8":
                                        t8=t3*t1;
                                        break;
                                    case"t9":
                                        t9=t3*t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t2;
                                        break;
                                    case"t2":
                                        t2=t3*t2;
                                        break;
                                    case"t3":
                                        t3=t3*t2;
                                    case"t4":
                                        t4=t3*t2;
                                        break;
                                    case"t5":
                                        t5=t3*t2;
                                        break;
                                    case"t6":
                                        t6=t3*t2;
                                        break;
                                    case"t7":
                                        t7=t3*t2;
                                        break;
                                    case"t8":
                                        t8=t3*t2;
                                        break;
                                    case"t9":
                                        t9=t3*t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t3;
                                        break;
                                    case"t2":
                                        t2=t3*t3;
                                        break;
                                    case"t3":
                                        t3=t3*t3;
                                    case"t4":
                                        t4=t3*t3;
                                        break;
                                    case"t5":
                                        t5=t3*t3;
                                        break;
                                    case"t6":
                                        t6=t3*t3;
                                        break;
                                    case"t7":
                                        t7=t3*t3;
                                        break;
                                    case"t8":
                                        t8=t3*t3;
                                        break;
                                    case"t9":
                                        t9=t3*t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t4;
                                        break;
                                    case"t2":
                                        t2=t3*t4;
                                        break;
                                    case"t3":
                                        t3=t3*t4;
                                    case"t4":
                                        t4=t3*t4;
                                        break;
                                    case"t5":
                                        t5=t3*t4;
                                        break;
                                    case"t6":
                                        t6=t3*t4;
                                        break;
                                    case"t7":
                                        t7=t3*t4;
                                        break;
                                    case"t8":
                                        t8=t3*t4;
                                        break;
                                    case"t9":
                                        t9=t3*t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t5;
                                        break;
                                    case"t2":
                                        t2=t3*t5;
                                        break;
                                    case"t3":
                                        t3=t3*t5;
                                    case"t4":
                                        t4=t3*t5;
                                        break;
                                    case"t5":
                                        t5=t3*t5;
                                        break;
                                    case"t6":
                                        t6=t3*t5;
                                        break;
                                    case"t7":
                                        t7=t3*t5;
                                        break;
                                    case"t8":
                                        t8=t3*t5;
                                        break;
                                    case"t9":
                                        t9=t3*t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t6;
                                        break;
                                    case"t2":
                                        t2=t3*t6;
                                        break;
                                    case"t3":
                                        t3=t3*t6;
                                    case"t4":
                                        t4=t3*t6;
                                        break;
                                    case"t5":
                                        t5=t3*t6;
                                        break;
                                    case"t6":
                                        t6=t3*t6;
                                        break;
                                    case"t7":
                                        t7=t3*t6;
                                        break;
                                    case"t8":
                                        t8=t3*t6;
                                        break;
                                    case"t9":
                                        t9=t3*t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t7;
                                        break;
                                    case"t2":
                                        t2=t3*t7;
                                        break;
                                    case"t3":
                                        t3=t3*t7;
                                    case"t4":
                                        t4=t3*t7;
                                        break;
                                    case"t5":
                                        t5=t3*t7;
                                        break;
                                    case"t6":
                                        t6=t3*t7;
                                        break;
                                    case"t7":
                                        t7=t3*t7;
                                        break;
                                    case"t8":
                                        t8=t3*t7;
                                        break;
                                    case"t9":
                                        t9=t3*t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t8;
                                        break;
                                    case"t2":
                                        t2=t3*t8;
                                        break;
                                    case"t3":
                                        t3=t3*t8;
                                    case"t4":
                                        t4=t3*t8;
                                        break;
                                    case"t5":
                                        t5=t3*t8;
                                        break;
                                    case"t6":
                                        t6=t3*t8;
                                        break;
                                    case"t7":
                                        t7=t3*t8;
                                        break;
                                    case"t8":
                                        t8=t3*t8;
                                        break;
                                    case"t9":
                                        t9=t3*t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t9;
                                        break;
                                    case"t2":
                                        t2=t3*t9;
                                        break;
                                    case"t3":
                                        t3=t3*t9;
                                    case"t4":
                                        t4=t3*t9;
                                        break;
                                    case"t5":
                                        t5=t3*t9;
                                        break;
                                    case"t6":
                                        t6=t3*t9;
                                        break;
                                    case"t7":
                                        t7=t3*t9;
                                        break;
                                    case"t8":
                                        t8=t3*t9;
                                        break;
                                    case"t9":
                                        t9=t3*t9;
                                        break;
                                } break;
                        }break;
              case"t4":
                  switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t1;
                                        break;
                                    case"t2":
                                        t2=t4*t1;
                                        break;
                                    case"t3":
                                        t3=t4*t1;
                                    case"t4":
                                        t4=t4*t1;
                                        break;
                                    case"t5":
                                        t5=t4*t1;
                                        break;
                                    case"t6":
                                        t6=t4*t1;
                                        break;
                                    case"t7":
                                        t7=t4*t1;
                                        break;
                                    case"t8":
                                        t8=t4*t1;
                                        break;
                                    case"t9":
                                        t9=t4*t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t2;
                                        break;
                                    case"t2":
                                        t2=t4*t2;
                                        break;
                                    case"t3":
                                        t3=t4*t2;
                                    case"t4":
                                        t4=t4*t2;
                                        break;
                                    case"t5":
                                        t5=t4*t2;
                                        break;
                                    case"t6":
                                        t6=t4*t2;
                                        break;
                                    case"t7":
                                        t7=t4*t2;
                                        break;
                                    case"t8":
                                        t8=t4*t2;
                                        break;
                                    case"t9":
                                        t9=t4*t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t3;
                                        break;
                                    case"t2":
                                        t2=t4*t3;
                                        break;
                                    case"t3":
                                        t3=t4*t3;
                                    case"t4":
                                        t4=t4*t3;
                                        break;
                                    case"t5":
                                        t5=t4*t3;
                                        break;
                                    case"t6":
                                        t6=t4*t3;
                                        break;
                                    case"t7":
                                        t7=t4*t3;
                                        break;
                                    case"t8":
                                        t8=t4*t3;
                                        break;
                                    case"t9":
                                        t9=t4*t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t4;
                                        break;
                                    case"t2":
                                        t2=t4*t4;
                                        break;
                                    case"t3":
                                        t3=t4*t4;
                                    case"t4":
                                        t4=t4*t4;
                                        break;
                                    case"t5":
                                        t5=t4*t4;
                                        break;
                                    case"t6":
                                        t6=t4*t4;
                                        break;
                                    case"t7":
                                        t7=t4*t4;
                                        break;
                                    case"t8":
                                        t8=t4*t4;
                                        break;
                                    case"t9":
                                        t9=t4*t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t5;
                                        break;
                                    case"t2":
                                        t2=t4*t5;
                                        break;
                                    case"t3":
                                        t3=t4*t5;
                                    case"t4":
                                        t4=t4*t5;
                                        break;
                                    case"t5":
                                        t5=t4*t5;
                                        break;
                                    case"t6":
                                        t6=t4*t5;
                                        break;
                                    case"t7":
                                        t7=t4*t5;
                                        break;
                                    case"t8":
                                        t8=t4*t5;
                                        break;
                                    case"t9":
                                        t9=t4*t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t6;
                                        break;
                                    case"t2":
                                        t2=t4*t6;
                                        break;
                                    case"t3":
                                        t3=t4*t6;
                                    case"t4":
                                        t4=t4*t6;
                                        break;
                                    case"t5":
                                        t5=t4*t6;
                                        break;
                                    case"t6":
                                        t6=t4*t6;
                                        break;
                                    case"t7":
                                        t7=t4*t6;
                                        break;
                                    case"t8":
                                        t8=t4*t6;
                                        break;
                                    case"t9":
                                        t9=t4*t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t7;
                                        break;
                                    case"t2":
                                        t2=t4*t7;
                                        break;
                                    case"t3":
                                        t3=t4*t7;
                                    case"t4":
                                        t4=t4*t7;
                                        break;
                                    case"t5":
                                        t5=t4*t7;
                                        break;
                                    case"t6":
                                        t6=t4*t7;
                                        break;
                                    case"t7":
                                        t7=t4*t7;
                                        break;
                                    case"t8":
                                        t8=t4*t7;
                                        break;
                                    case"t9":
                                        t9=t4*t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t8;
                                        break;
                                    case"t2":
                                        t2=t4*t8;
                                        break;
                                    case"t3":
                                        t3=t4*t8;
                                    case"t4":
                                        t4=t4*t8;
                                        break;
                                    case"t5":
                                        t5=t4*t8;
                                        break;
                                    case"t6":
                                        t6=t4*t8;
                                        break;
                                    case"t7":
                                        t7=t4*t8;
                                        break;
                                    case"t8":
                                        t8=t4*t8;
                                        break;
                                    case"t9":
                                        t9=t4*t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t9;
                                        break;
                                    case"t2":
                                        t2=t4*t9;
                                        break;
                                    case"t3":
                                        t3=t4*t9;
                                    case"t4":
                                        t4=t4*t9;
                                        break;
                                    case"t5":
                                        t5=t4*t9;
                                        break;
                                    case"t6":
                                        t6=t4*t9;
                                        break;
                                    case"t7":
                                        t7=t4*t9;
                                        break;
                                    case"t8":
                                        t8=t4*t9;
                                        break;
                                    case"t9":
                                        t9=t4*t9;
                                        break;
                                } break;
                        }break;
                      
              case"t5":
                  switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t1;
                                        break;
                                    case"t2":
                                        t2=t5*t1;
                                        break;
                                    case"t3":
                                        t3=t5*t1;
                                    case"t4":
                                        t4=t5*t1;
                                        break;
                                    case"t5":
                                        t5=t5*t1;
                                        break;
                                    case"t6":
                                        t6=t5*t1;
                                        break;
                                    case"t7":
                                        t7=t5*t1;
                                        break;
                                    case"t8":
                                        t8=t5*t1;
                                        break;
                                    case"t9":
                                        t9=t5*t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t2;
                                        break;
                                    case"t2":
                                        t2=t5*t2;
                                        break;
                                    case"t3":
                                        t3=t5*t2;
                                    case"t4":
                                        t4=t5*t2;
                                        break;
                                    case"t5":
                                        t5=t5*t2;
                                        break;
                                    case"t6":
                                        t6=t5*t2;
                                        break;
                                    case"t7":
                                        t7=t5*t2;
                                        break;
                                    case"t8":
                                        t8=t5*t2;
                                        break;
                                    case"t9":
                                        t9=t5*t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t3;
                                        break;
                                    case"t2":
                                        t2=t5*t3;
                                        break;
                                    case"t3":
                                        t3=t5*t3;
                                    case"t4":
                                        t4=t5*t3;
                                        break;
                                    case"t5":
                                        t5=t5*t3;
                                        break;
                                    case"t6":
                                        t6=t5*t3;
                                        break;
                                    case"t7":
                                        t7=t5*t3;
                                        break;
                                    case"t8":
                                        t8=t5*t3;
                                        break;
                                    case"t9":
                                        t9=t5*t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t4;
                                        break;
                                    case"t2":
                                        t2=t5*t4;
                                        break;
                                    case"t3":
                                        t3=t5*t4;
                                    case"t4":
                                        t4=t5*t4;
                                        break;
                                    case"t5":
                                        t5=t5*t4;
                                        break;
                                    case"t6":
                                        t6=t5*t4;
                                        break;
                                    case"t7":
                                        t7=t5*t4;
                                        break;
                                    case"t8":
                                        t8=t5*t4;
                                        break;
                                    case"t9":
                                        t9=t5*t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t5;
                                        break;
                                    case"t2":
                                        t2=t5*t5;
                                        break;
                                    case"t3":
                                        t3=t5*t5;
                                    case"t4":
                                        t4=t5*t5;
                                        break;
                                    case"t5":
                                        t5=t5*t5;
                                        break;
                                    case"t6":
                                        t6=t5*t5;
                                        break;
                                    case"t7":
                                        t7=t5*t5;
                                        break;
                                    case"t8":
                                        t8=t5*t5;
                                        break;
                                    case"t9":
                                        t9=t5*t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t6;
                                        break;
                                    case"t2":
                                        t2=t5*t6;
                                        break;
                                    case"t3":
                                        t3=t5*t6;
                                    case"t4":
                                        t4=t5*t6;
                                        break;
                                    case"t5":
                                        t5=t5*t6;
                                        break;
                                    case"t6":
                                        t6=t5*t6;
                                        break;
                                    case"t7":
                                        t7=t5*t6;
                                        break;
                                    case"t8":
                                        t8=t5*t6;
                                        break;
                                    case"t9":
                                        t9=t5*t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t7;
                                        break;
                                    case"t2":
                                        t2=t5*t7;
                                        break;
                                    case"t3":
                                        t3=t5*t7;
                                    case"t4":
                                        t4=t5*t7;
                                        break;
                                    case"t5":
                                        t5=t5*t7;
                                        break;
                                    case"t6":
                                        t6=t5*t7;
                                        break;
                                    case"t7":
                                        t7=t5*t7;
                                        break;
                                    case"t8":
                                        t8=t5*t7;
                                        break;
                                    case"t9":
                                        t9=t5*t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t8;
                                        break;
                                    case"t2":
                                        t2=t5*t8;
                                        break;
                                    case"t3":
                                        t3=t5*t8;
                                    case"t4":
                                        t4=t5*t8;
                                        break;
                                    case"t5":
                                        t5=t5*t8;
                                        break;
                                    case"t6":
                                        t6=t5*t8;
                                        break;
                                    case"t7":
                                        t7=t5*t8;
                                        break;
                                    case"t8":
                                        t8=t5*t8;
                                        break;
                                    case"t9":
                                        t9=t5*t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t9;
                                        break;
                                    case"t2":
                                        t2=t5*t9;
                                        break;
                                    case"t3":
                                        t3=t5*t9;
                                    case"t4":
                                        t4=t5*t9;
                                        break;
                                    case"t5":
                                        t5=t5*t9;
                                        break;
                                    case"t6":
                                        t6=t5*t9;
                                        break;
                                    case"t7":
                                        t7=t5*t9;
                                        break;
                                    case"t8":
                                        t8=t5*t9;
                                        break;
                                    case"t9":
                                        t9=t5*t9;
                                        break;
                                } break;
                        }break;
            case"t6":
                switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t1;
                                        break;
                                    case"t2":
                                        t2=t6*t1;
                                        break;
                                    case"t3":
                                        t3=t6*t1;
                                    case"t4":
                                        t4=t6*t1;
                                        break;
                                    case"t5":
                                        t5=t6*t1;
                                        break;
                                    case"t6":
                                        t6=t6*t1;
                                        break;
                                    case"t7":
                                        t7=t6*t1;
                                        break;
                                    case"t8":
                                        t8=t6*t1;
                                        break;
                                    case"t9":
                                        t9=t6*t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t2;
                                        break;
                                    case"t2":
                                        t2=t6*t2;
                                        break;
                                    case"t3":
                                        t3=t6*t2;
                                    case"t4":
                                        t4=t6*t2;
                                        break;
                                    case"t5":
                                        t5=t6*t2;
                                        break;
                                    case"t6":
                                        t6=t6*t2;
                                        break;
                                    case"t7":
                                        t7=t6*t2;
                                        break;
                                    case"t8":
                                        t8=t6*t2;
                                        break;
                                    case"t9":
                                        t9=t6*t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t3;
                                        break;
                                    case"t2":
                                        t2=t6*t3;
                                        break;
                                    case"t3":
                                        t3=t6*t3;
                                    case"t4":
                                        t4=t6*t3;
                                        break;
                                    case"t5":
                                        t5=t6*t3;
                                        break;
                                    case"t6":
                                        t6=t6*t3;
                                        break;
                                    case"t7":
                                        t7=t6*t3;
                                        break;
                                    case"t8":
                                        t8=t6*t3;
                                        break;
                                    case"t9":
                                        t9=t6*t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t4;
                                        break;
                                    case"t2":
                                        t2=t6*t4;
                                        break;
                                    case"t3":
                                        t3=t6*t4;
                                    case"t4":
                                        t4=t6*t4;
                                        break;
                                    case"t5":
                                        t5=t6*t4;
                                        break;
                                    case"t6":
                                        t6=t6*t4;
                                        break;
                                    case"t7":
                                        t7=t6*t4;
                                        break;
                                    case"t8":
                                        t8=t6*t4;
                                        break;
                                    case"t9":
                                        t9=t6*t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t5;
                                        break;
                                    case"t2":
                                        t2=t6*t5;
                                        break;
                                    case"t3":
                                        t3=t6*t5;
                                    case"t4":
                                        t4=t6*t5;
                                        break;
                                    case"t5":
                                        t5=t6*t5;
                                        break;
                                    case"t6":
                                        t6=t6*t5;
                                        break;
                                    case"t7":
                                        t7=t6*t5;
                                        break;
                                    case"t8":
                                        t8=t6*t5;
                                        break;
                                    case"t9":
                                        t9=t6*t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t6;
                                        break;
                                    case"t2":
                                        t2=t6*t6;
                                        break;
                                    case"t3":
                                        t3=t6*t6;
                                    case"t4":
                                        t4=t6*t6;
                                        break;
                                    case"t5":
                                        t5=t6*t6;
                                        break;
                                    case"t6":
                                        t6=t6*t6;
                                        break;
                                    case"t7":
                                        t7=t6*t6;
                                        break;
                                    case"t8":
                                        t8=t6*t6;
                                        break;
                                    case"t9":
                                        t9=t6*t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t7;
                                        break;
                                    case"t2":
                                        t2=t6*t7;
                                        break;
                                    case"t3":
                                        t3=t6*t7;
                                    case"t4":
                                        t4=t6*t7;
                                        break;
                                    case"t5":
                                        t5=t6*t7;
                                        break;
                                    case"t6":
                                        t6=t6*t7;
                                        break;
                                    case"t7":
                                        t7=t6*t7;
                                        break;
                                    case"t8":
                                        t8=t6*t7;
                                        break;
                                    case"t9":
                                        t9=t6*t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t8;
                                        break;
                                    case"t2":
                                        t2=t6*t8;
                                        break;
                                    case"t3":
                                        t3=t6*t8;
                                    case"t4":
                                        t4=t6*t8;
                                        break;
                                    case"t5":
                                        t5=t6*t8;
                                        break;
                                    case"t6":
                                        t6=t6*t8;
                                        break;
                                    case"t7":
                                        t7=t6*t8;
                                        break;
                                    case"t8":
                                        t8=t6*t8;
                                        break;
                                    case"t9":
                                        t9=t6*t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t9;
                                        break;
                                    case"t2":
                                        t2=t6*t9;
                                        break;
                                    case"t3":
                                        t3=t6*t9;
                                    case"t4":
                                        t4=t6*t9;
                                        break;
                                    case"t5":
                                        t5=t6*t9;
                                        break;
                                    case"t6":
                                        t6=t6*t9;
                                        break;
                                    case"t7":
                                        t7=t6*t9;
                                        break;
                                    case"t8":
                                        t8=t6*t9;
                                        break;
                                    case"t9":
                                        t9=t6*t9;
                                        break;
                                } break;
                        }break;
                      
                      
                      
                
                }
                
                    }
      
      }else{
          switch(temporal){
         case "t1":
                t1= Float.parseFloat(valor1)* Float.parseFloat(valor2);
                
                break; 
         case "t2":
                t2=Float.parseFloat(valor1)* Float.parseFloat(valor2);
                 break; 
         case "t3":        
             t3=Float.parseFloat(valor1)* Float.parseFloat(valor2);
                 break; 
         case "t4":        
             t4=Float.parseFloat(valor1)* Float.parseFloat(valor2);
                 break;
         case "t5":        
             t5=Float.parseFloat(valor1)* Float.parseFloat(valor2);
                 break;
         case "t6":        
             t6=Float.parseFloat(valor1)* Float.parseFloat(valor2);
                 break;
         case "t7":        
             t7=Float.parseFloat(valor1)* Float.parseFloat(valor2);
                 break;
         case "t8":        
             t8=Float.parseFloat(valor1)* Float.parseFloat(valor2);
                 break;  
         case "t9":        
             t9=Float.parseFloat(valor1)* Float.parseFloat(valor2);
                 break;        
     }
      
      }
     
  
  }
  public void suma(String valor1,String valor2,String temporal){
  if("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1)
              ||"t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)){
          //tx,num
            if(("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1))&&(!("t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)))){
                    switch(valor1){
                        case "t1":
                            switch(temporal){
                                case"t1":
                                    
                                    t1=t1+Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t1+Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t1+Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t1+Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t1+Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t1+Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t1+Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t1+Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t1+Float.parseFloat(valor2);
                                    break;    
                            }break; 
                        case "t2":
                            switch(temporal){
                                case"t1":
                                    t1=t2+Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t2+Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t2+Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t2+Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t2+Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t2+Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t2+Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t2+Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t2+Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t3":
                            switch(temporal){
                                case"t1":
                                    t1=t3+Float.parseFloat(valor2);;
                                    break;
                                case"t2":
                                   t2=t3+Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t3+Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t3+Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t3+Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t3+Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t3+Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t3+Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t3+Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t4":
                            switch(temporal){
                                case"t1":
                                    t1=t4+Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t4+Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t4+Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t4+Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t4+Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t4+Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t4+Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t4+Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t4+Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t5":
                            switch(temporal){
                                case"t1":
                                    t1=t5+Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t5+Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t5+Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t5+Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t5+Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t5+Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t5+Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t5+Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t5+Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t6":
                            switch(temporal){
                                case"t1":
                                    t1=t6+Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t6+Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t6+Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t6+Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t6+Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t6+Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t6+Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t6+Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t6+Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t7":
                           switch(temporal){
                                case"t1":
                                    t1=t7+Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t7+Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t7+Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t7+Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t7+Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t7+Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t7+Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t7+Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t7+Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t8":
                     switch(temporal){
                                case"t1":
                                    t1=t8+Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t8+Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t8+Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t8+Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t8+Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t8+Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t8+Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t8+Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t8+Float.parseFloat(valor2);
                                    break;    
                            }break;
                         }
                    }
            //num,tx
            if(!(("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1)))&&(("t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)))){
                    switch(valor2){
                        case "t1":
                            switch(temporal){
                                case"t1":
                                    t1=t1+Float.parseFloat(valor1);
                                    break;
                                case"t2":
                                   t2=t1+Float.parseFloat(valor1);
                                    break;
                                case"t3":
                                   t3=t1+Float.parseFloat(valor1);
                                    break;
                                case"t4":
                                   t4=t1+Float.parseFloat(valor1);
                                    break;
                                case"t5":
                                   t5=t1+Float.parseFloat(valor1);
                                    break;
                                case"t6":
                                   t6=t1+Float.parseFloat(valor1);
                                    break;
                                case"t7":
                                   t7=t1+Float.parseFloat(valor1);
                                    break; 
                                case"t8":
                                   t8=t1+Float.parseFloat(valor1);
                                    break; 
                                case"t9":
                                   t9=t1+Float.parseFloat(valor1);
                                    break;    
                            }break; 
                        case "t2":
                            switch(temporal){
                                case"t1":
                                    t1=t2+Float.parseFloat(valor1);
                                    break;
                                case"t2":
                                   t2=t2+Float.parseFloat(valor1);
                                    break;
                                case"t3":
                                   t3=t2+Float.parseFloat(valor1);
                                    break;
                                case"t4":
                                   t4=t2+Float.parseFloat(valor1);
                                    break;
                                case"t5":
                                   t5=t2+Float.parseFloat(valor1);
                                    break;
                                case"t6":
                                   t6=t2+Float.parseFloat(valor1);
                                    break;
                                case"t7":
                                   t7=t2+Float.parseFloat(valor1);
                                    break; 
                                case"t8":
                                   t8=t2+Float.parseFloat(valor1);
                                    break; 
                                case"t9":
                                   t9=t2+Float.parseFloat(valor1);
                                    break;    
                            }break;
                        case "t3":
                            switch(temporal){
                                case"t1":
                                    t1=t3+Float.parseFloat(valor1);
                                    break;
                                case"t2":
                                   t2=t3+Float.parseFloat(valor1);
                                    break;
                                case"t3":
                                   t3=t3+Float.parseFloat(valor1);
                                    break;
                                case"t4":
                                   t4=t3+Float.parseFloat(valor1);
                                    break;
                                case"t5":
                                   t5=t3+Float.parseFloat(valor1);
                                    break;
                                case"t6":
                                   t6=t3+Float.parseFloat(valor1);
                                    break;
                                case"t7":
                                   t7=t3+Float.parseFloat(valor1);
                                    break; 
                                case"t8":
                                   t8=t3+Float.parseFloat(valor1);
                                    break; 
                                case"t9":
                                   t9=t3+Float.parseFloat(valor1);
                                    break;    
                            }break;
                        case "t4":
                            switch(temporal){
                                case"t1":
                                    t1=t4+Float.parseFloat(valor1);
                                    break;
                                case"t2":
                                   t2=t4+Float.parseFloat(valor1);
                                    break;
                                case"t3":
                                   t3=t4+Float.parseFloat(valor1);
                                    break;
                                case"t4":
                                   t4=t4+Float.parseFloat(valor1);
                                    break;
                                case"t5":
                                   t5=t4+Float.parseFloat(valor1);
                                    break;
                                case"t6":
                                   t6=t4+Float.parseFloat(valor1);
                                    break;
                                case"t7":
                                   t7=t4+Float.parseFloat(valor1);
                                    break; 
                                case"t8":
                                   t8=t4+Float.parseFloat(valor1);
                                    break; 
                                case"t9":
                                   t9=t4+Float.parseFloat(valor1);
                                    break;    
                            }break;
                        case "t5":
                            switch(temporal){
                                case"t1":
                                    t1=t5+Float.parseFloat(valor1);
                                    break;
                                case"t2":
                                   t2=t5+Float.parseFloat(valor1);
                                    break;
                                case"t3":
                                   t3=t5+Float.parseFloat(valor1);
                                    break;
                                case"t4":
                                   t4=t5+Float.parseFloat(valor1);
                                    break;
                                case"t5":
                                   t5=t5+Float.parseFloat(valor1);
                                    break;
                                case"t6":
                                   t6=t5+Float.parseFloat(valor1);
                                    break;
                                case"t7":
                                   t7=t5+Float.parseFloat(valor1);
                                    break; 
                                case"t8":
                                   t8=t5+Float.parseFloat(valor1);
                                    break; 
                                case"t9":
                                   t9=t5+Float.parseFloat(valor1);
                                    break;    
                            }break;
                        case "t6":
                            switch(temporal){
                                case"t1":
                                    t1=t6+Float.parseFloat(valor1);
                                    break;
                                case"t2":
                                   t2=t6+Float.parseFloat(valor1);
                                    break;
                                case"t3":
                                   t3=t6+Float.parseFloat(valor1);
                                    break;
                                case"t4":
                                   t4=t6+Float.parseFloat(valor1);
                                    break;
                                case"t5":
                                   t5=t6+Float.parseFloat(valor1);
                                    break;
                                case"t6":
                                   t6=t6+Float.parseFloat(valor1);
                                    break;
                                case"t7":
                                   t7=t6+Float.parseFloat(valor1);
                                    break; 
                                case"t8":
                                   t8=t6+Float.parseFloat(valor1);
                                    break; 
                                case"t9":
                                   t9=t6+Float.parseFloat(valor1);
                                    break;    
                            }break;
                        case "t7":
                            switch(temporal){
                                case"t1":
                                    t1=t7+Float.parseFloat(valor1);
                                    break;
                                case"t2":
                                   t2=t7+Float.parseFloat(valor1);
                                    break;
                                case"t3":
                                   t3=t7+Float.parseFloat(valor1);
                                    break;
                                case"t4":
                                   t4=t7+Float.parseFloat(valor1);
                                    break;
                                case"t5":
                                   t5=t7+Float.parseFloat(valor1);
                                    break;
                                case"t6":
                                   t6=t7+Float.parseFloat(valor1);
                                    break;
                                case"t7":
                                   t7=t7+Float.parseFloat(valor1);
                                    break; 
                                case"t8":
                                   t8=t7+Float.parseFloat(valor1);
                                    break; 
                                case"t9":
                                   t9=t7+Float.parseFloat(valor1);
                                    break;    
                            }break;
                        case "t8":
                            switch(temporal){
                                case"t1":
                                    t1=t8+Float.parseFloat(valor1);
                                    break;
                                case"t2":
                                   t2=t8+Float.parseFloat(valor1);
                                    break;
                                case"t3":
                                   t3=t8+Float.parseFloat(valor1);
                                    break;
                                case"t4":
                                   t4=t8+Float.parseFloat(valor1);
                                    break;
                                case"t5":
                                   t5=t8+Float.parseFloat(valor1);
                                    break;
                                case"t6":
                                   t6=t8+Float.parseFloat(valor1);
                                    break;
                                case"t7":
                                   t7=t8+Float.parseFloat(valor1);
                                    break; 
                                case"t8":
                                   t8=t8+Float.parseFloat(valor1);
                                    break; 
                                case"t9":
                                   t9=t8+Float.parseFloat(valor1);
                                    break;    
                            }break;
                         }
                
                
                    }
            //tx,tx
            if(("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1))&&(("t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)))){
                    //temporal=valor1*valor2
                switch(valor1){
                    case "t1":
                        switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t1+t1;
                                        break;
                                    case"t2":
                                        t2=t1*t1;
                                        break;
                                    case"t3":
                                        t3=t1*t1;
                                    case"t4":
                                        t4=t1*t1;
                                        break;
                                    case"t5":
                                        t5=t1*t1;
                                        break;
                                    case"t6":
                                        t6=t1*t1;
                                        break;
                                    case"t7":
                                        t7=t1*t1;
                                        break;
                                    case"t8":
                                        t8=t1*t1;
                                        break;
                                    case"t9":
                                        t9=t1*t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t1+t2;
                                        break;
                                    case"t2":
                                        t2=t1+t2;
                                        break;
                                    case"t3":
                                        t3=t1+t2;
                                    case"t4":
                                        t4=t1+t2;
                                        break;
                                    case"t5":
                                        t5=t1+t2;
                                        break;
                                    case"t6":
                                        t6=t1+t2;
                                        break;
                                    case"t7":
                                        t7=t1+t2;
                                        break;
                                    case"t8":
                                        t8=t1+t2;
                                        break;
                                    case"t9":
                                        t9=t1+t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t1+t3;
                                        break;
                                    case"t2":
                                        t2=t1+t3;
                                        break;
                                    case"t3":
                                        t3=t1+t3;
                                    case"t4":
                                        t4=t1+t3;
                                        break;
                                    case"t5":
                                        t5=t1+t3;
                                        break;
                                    case"t6":
                                        t6=t1+t3;
                                        break;
                                    case"t7":
                                        t7=t1+t3;
                                        break;
                                    case"t8":
                                        t8=t1+t3;
                                        break;
                                    case"t9":
                                        t9=t1*t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t4;
                                        break;
                                    case"t2":
                                        t2=t1*t4;
                                        break;
                                    case"t3":
                                        t3=t1*t4;
                                    case"t4":
                                        t4=t1*t4;
                                        break;
                                    case"t5":
                                        t5=t1*t4;
                                        break;
                                    case"t6":
                                        t6=t1*t4;
                                        break;
                                    case"t7":
                                        t7=t1*t4;
                                        break;
                                    case"t8":
                                        t8=t1*t4;
                                        break;
                                    case"t9":
                                        t9=t1*t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t5;
                                        break;
                                    case"t2":
                                        t2=t1*t5;
                                        break;
                                    case"t3":
                                        t3=t1*t5;
                                    case"t4":
                                        t4=t1*t5;
                                        break;
                                    case"t5":
                                        t5=t1*t5;
                                        break;
                                    case"t6":
                                        t6=t1*t5;
                                        break;
                                    case"t7":
                                        t7=t1*t5;
                                        break;
                                    case"t8":
                                        t8=t1*t5;
                                        break;
                                    case"t9":
                                        t9=t1*t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t6;
                                        break;
                                    case"t2":
                                        t2=t1*t6;
                                        break;
                                    case"t3":
                                        t3=t1*t6;
                                    case"t4":
                                        t4=t1*t6;
                                        break;
                                    case"t5":
                                        t5=t1*t6;
                                        break;
                                    case"t6":
                                        t6=t1*t6;
                                        break;
                                    case"t7":
                                        t7=t1*t6;
                                        break;
                                    case"t8":
                                        t8=t1*t6;
                                        break;
                                    case"t9":
                                        t9=t1*t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t7;
                                        break;
                                    case"t2":
                                        t2=t1*t7;
                                        break;
                                    case"t3":
                                        t3=t1*t7;
                                    case"t4":
                                        t4=t1*t7;
                                        break;
                                    case"t5":
                                        t5=t1*t7;
                                        break;
                                    case"t6":
                                        t6=t1*t7;
                                        break;
                                    case"t7":
                                        t7=t1*t7;
                                        break;
                                    case"t8":
                                        t8=t1*t7;
                                        break;
                                    case"t9":
                                        t9=t1*t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t8;
                                        break;
                                    case"t2":
                                        t2=t1*t8;
                                        break;
                                    case"t3":
                                        t3=t1*t8;
                                    case"t4":
                                        t4=t1*t8;
                                        break;
                                    case"t5":
                                        t5=t1*t8;
                                        break;
                                    case"t6":
                                        t6=t1*t8;
                                        break;
                                    case"t7":
                                        t7=t1*t8;
                                        break;
                                    case"t8":
                                        t8=t1*t8;
                                        break;
                                    case"t9":
                                        t9=t1*t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t9;
                                        break;
                                    case"t2":
                                        t2=t1*t9;
                                        break;
                                    case"t3":
                                        t3=t1*t9;
                                    case"t4":
                                        t4=t1*t9;
                                        break;
                                    case"t5":
                                        t5=t1*t9;
                                        break;
                                    case"t6":
                                        t6=t1*t9;
                                        break;
                                    case"t7":
                                        t7=t1*t9;
                                        break;
                                    case"t8":
                                        t8=t1*t9;
                                        break;
                                    case"t9":
                                        t9=t1*t9;
                                        break;
                                } break;
                        }break;
                    case "t2":
                        switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t1;
                                        break;
                                    case"t2":
                                        t2=t2*t1;
                                        break;
                                    case"t3":
                                        t3=t2*t1;
                                    case"t4":
                                        t4=t2*t1;
                                        break;
                                    case"t5":
                                        t5=t2*t1;
                                        break;
                                    case"t6":
                                        t6=t2*t1;
                                        break;
                                    case"t7":
                                        t7=t2*t1;
                                        break;
                                    case"t8":
                                        t8=t2*t1;
                                        break;
                                    case"t9":
                                        t9=t2*t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t2;
                                        break;
                                    case"t2":
                                        t2=t2*t2;
                                        break;
                                    case"t3":
                                        t3=t2*t2;
                                    case"t4":
                                        t4=t2*t2;
                                        break;
                                    case"t5":
                                        t5=t2*t2;
                                        break;
                                    case"t6":
                                        t6=t2*t2;
                                        break;
                                    case"t7":
                                        t7=t2*t2;
                                        break;
                                    case"t8":
                                        t8=t2*t2;
                                        break;
                                    case"t9":
                                        t9=t2*t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t3;
                                        break;
                                    case"t2":
                                        t2=t2*t3;
                                        break;
                                    case"t3":
                                        t3=t2*t3;
                                    case"t4":
                                        t4=t2*t3;
                                        break;
                                    case"t5":
                                        t5=t2*t3;
                                        break;
                                    case"t6":
                                        t6=t2*t3;
                                        break;
                                    case"t7":
                                        t7=t2*t3;
                                        break;
                                    case"t8":
                                        t8=t2*t3;
                                        break;
                                    case"t9":
                                        t9=t2*t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t4;
                                        break;
                                    case"t2":
                                        t2=t2*t4;
                                        break;
                                    case"t3":
                                        t3=t2*t4;
                                    case"t4":
                                        t4=t2*t4;
                                        break;
                                    case"t5":
                                        t5=t2*t4;
                                        break;
                                    case"t6":
                                        t6=t2*t4;
                                        break;
                                    case"t7":
                                        t7=t2*t4;
                                        break;
                                    case"t8":
                                        t8=t2*t4;
                                        break;
                                    case"t9":
                                        t9=t2*t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t5;
                                        break;
                                    case"t2":
                                        t2=t2*t5;
                                        break;
                                    case"t3":
                                        t3=t2*t5;
                                    case"t4":
                                        t4=t2*t5;
                                        break;
                                    case"t5":
                                        t5=t2*t5;
                                        break;
                                    case"t6":
                                        t6=t2*t5;
                                        break;
                                    case"t7":
                                        t7=t2*t5;
                                        break;
                                    case"t8":
                                        t8=t2*t5;
                                        break;
                                    case"t9":
                                        t9=t2*t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t6;
                                        break;
                                    case"t2":
                                        t2=t2*t6;
                                        break;
                                    case"t3":
                                        t3=t2*t6;
                                    case"t4":
                                        t4=t2*t6;
                                        break;
                                    case"t5":
                                        t5=t2*t6;
                                        break;
                                    case"t6":
                                        t6=t2*t6;
                                        break;
                                    case"t7":
                                        t7=t2*t6;
                                        break;
                                    case"t8":
                                        t8=t2*t6;
                                        break;
                                    case"t9":
                                        t9=t2*t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t7;
                                        break;
                                    case"t2":
                                        t2=t2*t7;
                                        break;
                                    case"t3":
                                        t3=t2*t7;
                                    case"t4":
                                        t4=t2*t7;
                                        break;
                                    case"t5":
                                        t5=t2*t7;
                                        break;
                                    case"t6":
                                        t6=t2*t7;
                                        break;
                                    case"t7":
                                        t7=t2*t7;
                                        break;
                                    case"t8":
                                        t8=t2*t7;
                                        break;
                                    case"t9":
                                        t9=t2*t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t8;
                                        break;
                                    case"t2":
                                        t2=t2*t8;
                                        break;
                                    case"t3":
                                        t3=t2*t8;
                                    case"t4":
                                        t4=t2*t8;
                                        break;
                                    case"t5":
                                        t5=t2*t8;
                                        break;
                                    case"t6":
                                        t6=t2*t8;
                                        break;
                                    case"t7":
                                        t7=t2*t8;
                                        break;
                                    case"t8":
                                        t8=t2*t8;
                                        break;
                                    case"t9":
                                        t9=t2*t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t9;
                                        break;
                                    case"t2":
                                        t2=t2*t9;
                                        break;
                                    case"t3":
                                        t3=t2*t9;
                                    case"t4":
                                        t4=t2*t9;
                                        break;
                                    case"t5":
                                        t5=t2*t9;
                                        break;
                                    case"t6":
                                        t6=t2*t9;
                                        break;
                                    case"t7":
                                        t7=t2*t9;
                                        break;
                                    case"t8":
                                        t8=t2*t9;
                                        break;
                                    case"t9":
                                        t9=t2*t9;
                                        break;
                                } break;
                        }break;
                  case"t3":    
                      switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t3+t1;
                                        break;
                                    case"t2":
                                        t2=t3+t1;
                                        break;
                                    case"t3":
                                        t3=t3+t1;
                                    case"t4":
                                        t4=t3+t1;
                                        break;
                                    case"t5":
                                        t5=t3+t1;
                                        break;
                                    case"t6":
                                        t6=t3+t1;
                                        break;
                                    case"t7":
                                        t7=t3+t1;
                                        break;
                                    case"t8":
                                        t8=t3+t1;
                                        break;
                                    case"t9":
                                        t9=t3+t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t3+t2;
                                        break;
                                    case"t2":
                                        t2=t3+t2;
                                        break;
                                    case"t3":
                                        t3=t3+t2;
                                    case"t4":
                                        t4=t3+t2;
                                        break;
                                    case"t5":
                                        t5=t3+t2;
                                        break;
                                    case"t6":
                                        t6=t3+t2;
                                        break;
                                    case"t7":
                                        t7=t3+t2;
                                        break;
                                    case"t8":
                                        t8=t3+t2;
                                        break;
                                    case"t9":
                                        t9=t3+t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t3+t3;
                                        break;
                                    case"t2":
                                        t2=t3+t3;
                                        break;
                                    case"t3":
                                        t3=t3+t3;
                                    case"t4":
                                        t4=t3*t3;
                                        break;
                                    case"t5":
                                        t5=t3*t3;
                                        break;
                                    case"t6":
                                        t6=t3*t3;
                                        break;
                                    case"t7":
                                        t7=t3*t3;
                                        break;
                                    case"t8":
                                        t8=t3*t3;
                                        break;
                                    case"t9":
                                        t9=t3*t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t3+t4;
                                        break;
                                    case"t2":
                                        t2=t3+t4;
                                        break;
                                    case"t3":
                                        t3=t3+t4;
                                    case"t4":
                                        t4=t3+t4;
                                        break;
                                    case"t5":
                                        t5=t3+t4;
                                        break;
                                    case"t6":
                                        t6=t3+t4;
                                        break;
                                    case"t7":
                                        t7=t3+t4;
                                        break;
                                    case"t8":
                                        t8=t3+t4;
                                        break;
                                    case"t9":
                                        t9=t3+t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t3+t5;
                                        break;
                                    case"t2":
                                        t2=t3+t5;
                                        break;
                                    case"t3":
                                        t3=t3+t5;
                                    case"t4":
                                        t4=t3+t5;
                                        break;
                                    case"t5":
                                        t5=t3+t5;
                                        break;
                                    case"t6":
                                        t6=t3+t5;
                                        break;
                                    case"t7":
                                        t7=t3+t5;
                                        break;
                                    case"t8":
                                        t8=t3+t5;
                                        break;
                                    case"t9":
                                        t9=t3+t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t3+t6;
                                        break;
                                    case"t2":
                                        t2=t3+t6;
                                        break;
                                    case"t3":
                                        t3=t3+t6;
                                    case"t4":
                                        t4=t3+t6;
                                        break;
                                    case"t5":
                                        t5=t3+t6;
                                        break;
                                    case"t6":
                                        t6=t3+t6;
                                        break;
                                    case"t7":
                                        t7=t3+t6;
                                        break;
                                    case"t8":
                                        t8=t3+t6;
                                        break;
                                    case"t9":
                                        t9=t3+t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t3+t7;
                                        break;
                                    case"t2":
                                        t2=t3+t7;
                                        break;
                                    case"t3":
                                        t3=t3+t7;
                                    case"t4":
                                        t4=t3+t7;
                                        break;
                                    case"t5":
                                        t5=t3+t7;
                                        break;
                                    case"t6":
                                        t6=t3+t7;
                                        break;
                                    case"t7":
                                        t7=t3+t7;
                                        break;
                                    case"t8":
                                        t8=t3+t7;
                                        break;
                                    case"t9":
                                        t9=t3+t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t3+t8;
                                        break;
                                    case"t2":
                                        t2=t3+t8;
                                        break;
                                    case"t3":
                                        t3=t3+t8;
                                    case"t4":
                                        t4=t3+t8;
                                        break;
                                    case"t5":
                                        t5=t3+t8;
                                        break;
                                    case"t6":
                                        t6=t3+t8;
                                        break;
                                    case"t7":
                                        t7=t3+t8;
                                        break;
                                    case"t8":
                                        t8=t3+t8;
                                        break;
                                    case"t9":
                                        t9=t3+t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t3+t9;
                                        break;
                                    case"t2":
                                        t2=t3+t9;
                                        break;
                                    case"t3":
                                        t3=t3+t9;
                                    case"t4":
                                        t4=t3+t9;
                                        break;
                                    case"t5":
                                        t5=t3+t9;
                                        break;
                                    case"t6":
                                        t6=t3+t9;
                                        break;
                                    case"t7":
                                        t7=t3+t9;
                                        break;
                                    case"t8":
                                        t8=t3+t9;
                                        break;
                                    case"t9":
                                        t9=t3+t9;
                                        break;
                                } break;
                        }break;
              case"t4":
                  switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t4+t1;
                                        break;
                                    case"t2":
                                        t2=t4+t1;
                                        break;
                                    case"t3":
                                        t3=t4+t1;
                                    case"t4":
                                        t4=t4+t1;
                                        break;
                                    case"t5":
                                        t5=t4+t1;
                                        break;
                                    case"t6":
                                        t6=t4+t1;
                                        break;
                                    case"t7":
                                        t7=t4+t1;
                                        break;
                                    case"t8":
                                        t8=t4+t1;
                                        break;
                                    case"t9":
                                        t9=t4+t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t4+t2;
                                        break;
                                    case"t2":
                                        t2=t4+t2;
                                        break;
                                    case"t3":
                                        t3=t4+t2;
                                    case"t4":
                                        t4=t4+t2;
                                        break;
                                    case"t5":
                                        t5=t4+t2;
                                        break;
                                    case"t6":
                                        t6=t4+t2;
                                        break;
                                    case"t7":
                                        t7=t4+t2;
                                        break;
                                    case"t8":
                                        t8=t4+t2;
                                        break;
                                    case"t9":
                                        t9=t4+t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t4+t3;
                                        break;
                                    case"t2":
                                        t2=t4+t3;
                                        break;
                                    case"t3":
                                        t3=t4+t3;
                                    case"t4":
                                        t4=t4+t3;
                                        break;
                                    case"t5":
                                        t5=t4+t3;
                                        break;
                                    case"t6":
                                        t6=t4+t3;
                                        break;
                                    case"t7":
                                        t7=t4+t3;
                                        break;
                                    case"t8":
                                        t8=t4+t3;
                                        break;
                                    case"t9":
                                        t9=t4+t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t4+t4;
                                        break;
                                    case"t2":
                                        t2=t4+t4;
                                        break;
                                    case"t3":
                                        t3=t4*t4;
                                    case"t4":
                                        t4=t4*t4;
                                        break;
                                    case"t5":
                                        t5=t4*t4;
                                        break;
                                    case"t6":
                                        t6=t4*t4;
                                        break;
                                    case"t7":
                                        t7=t4*t4;
                                        break;
                                    case"t8":
                                        t8=t4*t4;
                                        break;
                                    case"t9":
                                        t9=t4*t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t4+t5;
                                        break;
                                    case"t2":
                                        t2=t4+t5;
                                        break;
                                    case"t3":
                                        t3=t4+t5;
                                    case"t4":
                                        t4=t4+t5;
                                        break;
                                    case"t5":
                                        t5=t4+t5;
                                        break;
                                    case"t6":
                                        t6=t4+t5;
                                        break;
                                    case"t7":
                                        t7=t4+t5;
                                        break;
                                    case"t8":
                                        t8=t4+t5;
                                        break;
                                    case"t9":
                                        t9=t4+t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t4+t6;
                                        break;
                                    case"t2":
                                        t2=t4+t6;
                                        break;
                                    case"t3":
                                        t3=t4+t6;
                                    case"t4":
                                        t4=t4+t6;
                                        break;
                                    case"t5":
                                        t5=t4+t6;
                                        break;
                                    case"t6":
                                        t6=t4+t6;
                                        break;
                                    case"t7":
                                        t7=t4+t6;
                                        break;
                                    case"t8":
                                        t8=t4+t6;
                                        break;
                                    case"t9":
                                        t9=t4+t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t4+t7;
                                        break;
                                    case"t2":
                                        t2=t4+t7;
                                        break;
                                    case"t3":
                                        t3=t4+t7;
                                    case"t4":
                                        t4=t4+t7;
                                        break;
                                    case"t5":
                                        t5=t4+t7;
                                        break;
                                    case"t6":
                                        t6=t4+t7;
                                        break;
                                    case"t7":
                                        t7=t4+t7;
                                        break;
                                    case"t8":
                                        t8=t4+t7;
                                        break;
                                    case"t9":
                                        t9=t4+t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t4+t8;
                                        break;
                                    case"t2":
                                        t2=t4+t8;
                                        break;
                                    case"t3":
                                        t3=t4+t8;
                                    case"t4":
                                        t4=t4+t8;
                                        break;
                                    case"t5":
                                        t5=t4+t8;
                                        break;
                                    case"t6":
                                        t6=t4+t8;
                                        break;
                                    case"t7":
                                        t7=t4+t8;
                                        break;
                                    case"t8":
                                        t8=t4+t8;
                                        break;
                                    case"t9":
                                        t9=t4+t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t4+t9;
                                        break;
                                    case"t2":
                                        t2=t4+t9;
                                        break;
                                    case"t3":
                                        t3=t4+t9;
                                    case"t4":
                                        t4=t4+t9;
                                        break;
                                    case"t5":
                                        t5=t4+t9;
                                        break;
                                    case"t6":
                                        t6=t4+t9;
                                        break;
                                    case"t7":
                                        t7=t4+t9;
                                        break;
                                    case"t8":
                                        t8=t4+t9;
                                        break;
                                    case"t9":
                                        t9=t4+t9;
                                        break;
                                } break;
                        }break;
                      
              case"t5":
                  switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t5+t1;
                                        break;
                                    case"t2":
                                        t2=t5+t1;
                                        break;
                                    case"t3":
                                        t3=t5+t1;
                                    case"t4":
                                        t4=t5+t1;
                                        break;
                                    case"t5":
                                        t5=t5+t1;
                                        break;
                                    case"t6":
                                        t6=t5+t1;
                                        break;
                                    case"t7":
                                        t7=t5+t1;
                                        break;
                                    case"t8":
                                        t8=t5+t1;
                                        break;
                                    case"t9":
                                        t9=t5+t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t5+t2;
                                        break;
                                    case"t2":
                                        t2=t5+t2;
                                        break;
                                    case"t3":
                                        t3=t5+t2;
                                    case"t4":
                                        t4=t5+t2;
                                        break;
                                    case"t5":
                                        t5=t5+t2;
                                        break;
                                    case"t6":
                                        t6=t5+t2;
                                        break;
                                    case"t7":
                                        t7=t5+t2;
                                        break;
                                    case"t8":
                                        t8=t5+t2;
                                        break;
                                    case"t9":
                                        t9=t5+t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t5+t3;
                                        break;
                                    case"t2":
                                        t2=t5+t3;
                                        break;
                                    case"t3":
                                        t3=t5+t3;
                                    case"t4":
                                        t4=t5+t3;
                                        break;
                                    case"t5":
                                        t5=t5+t3;
                                        break;
                                    case"t6":
                                        t6=t5+t3;
                                        break;
                                    case"t7":
                                        t7=t5+t3;
                                        break;
                                    case"t8":
                                        t8=t5+t3;
                                        break;
                                    case"t9":
                                        t9=t5+t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t5+t4;
                                        break;
                                    case"t2":
                                        t2=t5+t4;
                                        break;
                                    case"t3":
                                        t3=t5+t4;
                                    case"t4":
                                        t4=t5+t4;
                                        break;
                                    case"t5":
                                        t5=t5+t4;
                                        break;
                                    case"t6":
                                        t6=t5+t4;
                                        break;
                                    case"t7":
                                        t7=t5+t4;
                                        break;
                                    case"t8":
                                        t8=t5+t4;
                                        break;
                                    case"t9":
                                        t9=t5+t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t5;
                                        break;
                                    case"t2":
                                        t2=t5+t5;
                                        break;
                                    case"t3":
                                        t3=t5+t5;
                                    case"t4":
                                        t4=t5+t5;
                                        break;
                                    case"t5":
                                        t5=t5+t5;
                                        break;
                                    case"t6":
                                        t6=t5+t5;
                                        break;
                                    case"t7":
                                        t7=t5+t5;
                                        break;
                                    case"t8":
                                        t8=t5+t5;
                                        break;
                                    case"t9":
                                        t9=t5+t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t5+t6;
                                        break;
                                    case"t2":
                                        t2=t5+t6;
                                        break;
                                    case"t3":
                                        t3=t5+t6;
                                    case"t4":
                                        t4=t5+t6;
                                        break;
                                    case"t5":
                                        t5=t5+t6;
                                        break;
                                    case"t6":
                                        t6=t5+t6;
                                        break;
                                    case"t7":
                                        t7=t5+t6;
                                        break;
                                    case"t8":
                                        t8=t5+t6;
                                        break;
                                    case"t9":
                                        t9=t5+t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t5+t7;
                                        break;
                                    case"t2":
                                        t2=t5+t7;
                                        break;
                                    case"t3":
                                        t3=t5+t7;
                                    case"t4":
                                        t4=t5+t7;
                                        break;
                                    case"t5":
                                        t5=t5+t7;
                                        break;
                                    case"t6":
                                        t6=t5+t7;
                                        break;
                                    case"t7":
                                        t7=t5+t7;
                                        break;
                                    case"t8":
                                        t8=t5+t7;
                                        break;
                                    case"t9":
                                        t9=t5+t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t5+t8;
                                        break;
                                    case"t2":
                                        t2=t5+t8;
                                        break;
                                    case"t3":
                                        t3=t5+t8;
                                    case"t4":
                                        t4=t5+t8;
                                        break;
                                    case"t5":
                                        t5=t5+t8;
                                        break;
                                    case"t6":
                                        t6=t5+t8;
                                        break;
                                    case"t7":
                                        t7=t5+t8;
                                        break;
                                    case"t8":
                                        t8=t5+t8;
                                        break;
                                    case"t9":
                                        t9=t5+t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t5+t9;
                                        break;
                                    case"t2":
                                        t2=t5+t9;
                                        break;
                                    case"t3":
                                        t3=t5+t9;
                                    case"t4":
                                        t4=t5+t9;
                                        break;
                                    case"t5":
                                        t5=t5+t9;
                                        break;
                                    case"t6":
                                        t6=t5+t9;
                                        break;
                                    case"t7":
                                        t7=t5+t9;
                                        break;
                                    case"t8":
                                        t8=t5+t9;
                                        break;
                                    case"t9":
                                        t9=t5+t9;
                                        break;
                                } break;
                        }break;
            case"t6":
                switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t1;
                                        break;
                                    case"t2":
                                        t2=t6+t1;
                                        break;
                                    case"t3":
                                        t3=t6+t1;
                                    case"t4":
                                        t4=t6+t1;
                                        break;
                                    case"t5":
                                        t5=t6+t1;
                                        break;
                                    case"t6":
                                        t6=t6+t1;
                                        break;
                                    case"t7":
                                        t7=t6+t1;
                                        break;
                                    case"t8":
                                        t8=t6+t1;
                                        break;
                                    case"t9":
                                        t9=t6+t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t2;
                                        break;
                                    case"t2":
                                        t2=t6+t2;
                                        break;
                                    case"t3":
                                        t3=t6+t2;
                                    case"t4":
                                        t4=t6+t2;
                                        break;
                                    case"t5":
                                        t5=t6+t2;
                                        break;
                                    case"t6":
                                        t6=t6+t2;
                                        break;
                                    case"t7":
                                        t7=t6+t2;
                                        break;
                                    case"t8":
                                        t8=t6+t2;
                                        break;
                                    case"t9":
                                        t9=t6+t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t3;
                                        break;
                                    case"t2":
                                        t2=t6+t3;
                                        break;
                                    case"t3":
                                        t3=t6+t3;
                                    case"t4":
                                        t4=t6+t3;
                                        break;
                                    case"t5":
                                        t5=t6+t3;
                                        break;
                                    case"t6":
                                        t6=t6+t3;
                                        break;
                                    case"t7":
                                        t7=t6+t3;
                                        break;
                                    case"t8":
                                        t8=t6+t3;
                                        break;
                                    case"t9":
                                        t9=t6+t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t4;
                                        break;
                                    case"t2":
                                        t2=t6+t4;
                                        break;
                                    case"t3":
                                        t3=t6+t4;
                                    case"t4":
                                        t4=t6+t4;
                                        break;
                                    case"t5":
                                        t5=t6+t4;
                                        break;
                                    case"t6":
                                        t6=t6+t4;
                                        break;
                                    case"t7":
                                        t7=t6+t4;
                                        break;
                                    case"t8":
                                        t8=t6+t4;
                                        break;
                                    case"t9":
                                        t9=t6+t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t5;
                                        break;
                                    case"t2":
                                        t2=t6+t5;
                                        break;
                                    case"t3":
                                        t3=t6+t5;
                                    case"t4":
                                        t4=t6+t5;
                                        break;
                                    case"t5":
                                        t5=t6+t5;
                                        break;
                                    case"t6":
                                        t6=t6+t5;
                                        break;
                                    case"t7":
                                        t7=t6+t5;
                                        break;
                                    case"t8":
                                        t8=t6+t5;
                                        break;
                                    case"t9":
                                        t9=t6+t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t6;
                                        break;
                                    case"t2":
                                        t2=t6+t6;
                                        break;
                                    case"t3":
                                        t3=t6+t6;
                                    case"t4":
                                        t4=t6+t6;
                                        break;
                                    case"t5":
                                        t5=t6+t6;
                                        break;
                                    case"t6":
                                        t6=t6+t6;
                                        break;
                                    case"t7":
                                        t7=t6+t6;
                                        break;
                                    case"t8":
                                        t8=t6+t6;
                                        break;
                                    case"t9":
                                        t9=t6+t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t7;
                                        break;
                                    case"t2":
                                        t2=t6+t7;
                                        break;
                                    case"t3":
                                        t3=t6+t7;
                                    case"t4":
                                        t4=t6+t7;
                                        break;
                                    case"t5":
                                        t5=t6+t7;
                                        break;
                                    case"t6":
                                        t6=t6+t7;
                                        break;
                                    case"t7":
                                        t7=t6+t7;
                                        break;
                                    case"t8":
                                        t8=t6+t7;
                                        break;
                                    case"t9":
                                        t9=t6+t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t8;
                                        break;
                                    case"t2":
                                        t2=t6+t8;
                                        break;
                                    case"t3":
                                        t3=t6+t8;
                                    case"t4":
                                        t4=t6+t8;
                                        break;
                                    case"t5":
                                        t5=t6+t8;
                                        break;
                                    case"t6":
                                        t6=t6+t8;
                                        break;
                                    case"t7":
                                        t7=t6+t8;
                                        break;
                                    case"t8":
                                        t8=t6+t8;
                                        break;
                                    case"t9":
                                        t9=t6+t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t9;
                                        break;
                                    case"t2":
                                        t2=t6+t9;
                                        break;
                                    case"t3":
                                        t3=t6+t9;
                                    case"t4":
                                        t4=t6+t9;
                                        break;
                                    case"t5":
                                        t5=t6+t9;
                                        break;
                                    case"t6":
                                        t6=t6*t9;
                                        break;
                                    case"t7":
                                        t7=t6+t9;
                                        break;
                                    case"t8":
                                        t8=t6+t9;
                                        break;
                                    case"t9":
                                        t9=t6+t9;
                                        break;
                                } break;
                        }break;
            case "t7":
                switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t1;
                                        break;
                                    case"t2":
                                        t2=t6+t1;
                                        break;
                                    case"t3":
                                        t3=t6+t1;
                                    case"t4":
                                        t4=t6+t1;
                                        break;
                                    case"t5":
                                        t5=t6+t1;
                                        break;
                                    case"t6":
                                        t6=t6+t1;
                                        break;
                                    case"t7":
                                        t7=t6+t1;
                                        break;
                                    case"t8":
                                        t8=t6+t1;
                                        break;
                                    case"t9":
                                        t9=t6+t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t2;
                                        break;
                                    case"t2":
                                        t2=t6+t2;
                                        break;
                                    case"t3":
                                        t3=t6+t2;
                                    case"t4":
                                        t4=t6+t2;
                                        break;
                                    case"t5":
                                        t5=t6+t2;
                                        break;
                                    case"t6":
                                        t6=t6+t2;
                                        break;
                                    case"t7":
                                        t7=t6+t2;
                                        break;
                                    case"t8":
                                        t8=t6+t2;
                                        break;
                                    case"t9":
                                        t9=t6+t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t3;
                                        break;
                                    case"t2":
                                        t2=t6+t3;
                                        break;
                                    case"t3":
                                        t3=t6+t3;
                                    case"t4":
                                        t4=t6+t3;
                                        break;
                                    case"t5":
                                        t5=t6+t3;
                                        break;
                                    case"t6":
                                        t6=t6+t3;
                                        break;
                                    case"t7":
                                        t7=t6+t3;
                                        break;
                                    case"t8":
                                        t8=t6+t3;
                                        break;
                                    case"t9":
                                        t9=t6+t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t4;
                                        break;
                                    case"t2":
                                        t2=t6+t4;
                                        break;
                                    case"t3":
                                        t3=t6+t4;
                                    case"t4":
                                        t4=t6+t4;
                                        break;
                                    case"t5":
                                        t5=t6+t4;
                                        break;
                                    case"t6":
                                        t6=t6+t4;
                                        break;
                                    case"t7":
                                        t7=t6+t4;
                                        break;
                                    case"t8":
                                        t8=t6+t4;
                                        break;
                                    case"t9":
                                        t9=t6+t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t5;
                                        break;
                                    case"t2":
                                        t2=t6+t5;
                                        break;
                                    case"t3":
                                        t3=t6+t5;
                                    case"t4":
                                        t4=t6+t5;
                                        break;
                                    case"t5":
                                        t5=t6+t5;
                                        break;
                                    case"t6":
                                        t6=t6+t5;
                                        break;
                                    case"t7":
                                        t7=t7+t5;
                                        break;
                                    case"t8":
                                        t8=t7+t5;
                                        break;
                                    case"t9":
                                        t9=t7+t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t6;
                                        break;
                                    case"t2":
                                        t2=t6+t6;
                                        break;
                                    case"t3":
                                        t3=t6+t6;
                                    case"t4":
                                        t4=t6+t6;
                                        break;
                                    case"t5":
                                        t5=t6+t6;
                                        break;
                                    case"t6":
                                        t6=t6+t6;
                                        break;
                                    case"t7":
                                        t7=t6+t6;
                                        break;
                                    case"t8":
                                        t8=t7+t6;
                                        break;
                                    case"t9":
                                        t9=t7+t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t7;
                                        break;
                                    case"t2":
                                        t2=t6+t7;
                                        break;
                                    case"t3":
                                        t3=t6+t7;
                                    case"t4":
                                        t4=t6+t7;
                                        break;
                                    case"t5":
                                        t5=t6+t7;
                                        break;
                                    case"t6":
                                        t6=t6+t7;
                                        break;
                                    case"t7":
                                        t7=t6+t7;
                                        break;
                                    case"t8":
                                        t8=t7+t7;
                                        break;
                                    case"t9":
                                        t9=t7+t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t8;
                                        break;
                                    case"t2":
                                        t2=t6+t8;
                                        break;
                                    case"t3":
                                        t3=t6+t8;
                                    case"t4":
                                        t4=t6+t8;
                                        break;
                                    case"t5":
                                        t5=t6+t8;
                                        break;
                                    case"t6":
                                        t6=t6+t8;
                                        break;
                                    case"t7":
                                        t7=t7+t8;
                                        break;
                                    case"t8":
                                        t8=t7+t8;
                                        break;
                                    case"t9":
                                        t9=t7+t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t9;
                                        break;
                                    case"t2":
                                        t2=t6+t9;
                                        break;
                                    case"t3":
                                        t3=t6+t9;
                                    case"t4":
                                        t4=t6+t9;
                                        break;
                                    case"t5":
                                        t5=t6+t9;
                                        break;
                                    case"t6":
                                        t6=t6*t9;
                                        break;
                                    case"t7":
                                        t7=t6+t9;
                                        break;
                                    case"t8":
                                        t8=t7+t9;
                                        break;
                                    case"t9":
                                        t9=t7+t9;
                                        break;
                                } break;
                        }break;
                case"t8":
                    switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t1;
                                        break;
                                    case"t2":
                                        t2=t6+t1;
                                        break;
                                    case"t3":
                                        t3=t6+t1;
                                    case"t4":
                                        t4=t6+t1;
                                        break;
                                    case"t5":
                                        t5=t6+t1;
                                        break;
                                    case"t6":
                                        t6=t6+t1;
                                        break;
                                    case"t7":
                                        t7=t6+t1;
                                        break;
                                    case"t8":
                                        t8=t6+t1;
                                        break;
                                    case"t9":
                                        t9=t8+t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t2;
                                        break;
                                    case"t2":
                                        t2=t6+t2;
                                        break;
                                    case"t3":
                                        t3=t6+t2;
                                    case"t4":
                                        t4=t6+t2;
                                        break;
                                    case"t5":
                                        t5=t6+t2;
                                        break;
                                    case"t6":
                                        t6=t6+t2;
                                        break;
                                    case"t7":
                                        t7=t6+t2;
                                        break;
                                    case"t8":
                                        t8=t6+t2;
                                        break;
                                    case"t9":
                                        t9=t8+t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t3;
                                        break;
                                    case"t2":
                                        t2=t6+t3;
                                        break;
                                    case"t3":
                                        t3=t6+t3;
                                    case"t4":
                                        t4=t6+t3;
                                        break;
                                    case"t5":
                                        t5=t6+t3;
                                        break;
                                    case"t6":
                                        t6=t6+t3;
                                        break;
                                    case"t7":
                                        t7=t6+t3;
                                        break;
                                    case"t8":
                                        t8=t6+t3;
                                        break;
                                    case"t9":
                                        t9=t8+t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t4;
                                        break;
                                    case"t2":
                                        t2=t6+t4;
                                        break;
                                    case"t3":
                                        t3=t6+t4;
                                    case"t4":
                                        t4=t6+t4;
                                        break;
                                    case"t5":
                                        t5=t6+t4;
                                        break;
                                    case"t6":
                                        t6=t6+t4;
                                        break;
                                    case"t7":
                                        t7=t6+t4;
                                        break;
                                    case"t8":
                                        t8=t6+t4;
                                        break;
                                    case"t9":
                                        t9=t8+t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t5;
                                        break;
                                    case"t2":
                                        t2=t6+t5;
                                        break;
                                    case"t3":
                                        t3=t6+t5;
                                    case"t4":
                                        t4=t6+t5;
                                        break;
                                    case"t5":
                                        t5=t6+t5;
                                        break;
                                    case"t6":
                                        t6=t6+t5;
                                        break;
                                    case"t7":
                                        t7=t6+t5;
                                        break;
                                    case"t8":
                                        t8=t6+t5;
                                        break;
                                    case"t9":
                                        t9=t8+t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t6;
                                        break;
                                    case"t2":
                                        t2=t6+t6;
                                        break;
                                    case"t3":
                                        t3=t6+t6;
                                    case"t4":
                                        t4=t6+t6;
                                        break;
                                    case"t5":
                                        t5=t6+t6;
                                        break;
                                    case"t6":
                                        t6=t6+t6;
                                        break;
                                    case"t7":
                                        t7=t6+t6;
                                        break;
                                    case"t8":
                                        t8=t6+t6;
                                        break;
                                    case"t9":
                                        t9=t8+t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t6+t7;
                                        break;
                                    case"t2":
                                        t2=t6+t7;
                                        break;
                                    case"t3":
                                        t3=t6+t7;
                                    case"t4":
                                        t4=t6+t7;
                                        break;
                                    case"t5":
                                        t5=t6+t7;
                                        break;
                                    case"t6":
                                        t6=t6+t7;
                                        break;
                                    case"t7":
                                        t7=t6+t7;
                                        break;
                                    case"t8":
                                        t8=t8+t7;
                                        break;
                                    case"t9":
                                        t9=t8+t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t8+t8;
                                        break;
                                    case"t2":
                                        t2=t8+t8;
                                        break;
                                    case"t3":
                                        t3=t8+t8;
                                    case"t4":
                                        t4=t8+t8;
                                        break;
                                    case"t5":
                                        t5=t8+t8;
                                        break;
                                    case"t6":
                                        t6=t8+t8;
                                        break;
                                    case"t7":
                                        t7=t8+t8;
                                        break;
                                    case"t8":
                                        t8=t8+t8;
                                        break;
                                    case"t9":
                                        t9=t8+t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t8+t9;
                                        break;
                                    case"t2":
                                        t2=t8+t9;
                                        break;
                                    case"t3":
                                        t3=t8+t9;
                                    case"t4":
                                        t4=t8+t9;
                                        break;
                                    case"t5":
                                        t5=t8+t9;
                                        break;
                                    case"t6":
                                        t6=t8*t9;
                                        break;
                                    case"t7":
                                        t7=t8+t9;
                                        break;
                                    case"t8":
                                        t8=t8+t9;
                                        break;
                                    case"t9":
                                        t9=t8+t9;
                                        break;
                                } break;
                        }break;
                      
                      
                
                }
                
                    }
      
      }else{
          switch(temporal){
         case "t1":
                t1= Float.parseFloat(valor1)+Float.parseFloat(valor2);
                
                break; 
         case "t2":
                t2=Float.parseFloat(valor1)+Float.parseFloat(valor2);
                 break; 
         case "t3":        
             t3=Float.parseFloat(valor1)+Float.parseFloat(valor2);
                 break; 
         case "t4":        
             t4=Float.parseFloat(valor1)+Float.parseFloat(valor2);
                 break;
         case "t5":        
             t5=Float.parseFloat(valor1)+Float.parseFloat(valor2);
                 break;
         case "t6":        
             t6=Float.parseFloat(valor1)+Float.parseFloat(valor2);
                 break;
         case "t7":        
             t7=Float.parseFloat(valor1)+Float.parseFloat(valor2);
                 break;
         case "t8":        
             t8=Float.parseFloat(valor1)+Float.parseFloat(valor2);
                 break;  
         case "t9":        
             t9=Float.parseFloat(valor1)+Float.parseFloat(valor2);
                 break;        
     }
      
      }
     
  
  
  }
  public void resta(String valor1,String valor2,String temporal){
  
  if("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1)
              ||"t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)){
          //tx,num
            if(("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1))&&(!("t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)))){
                    switch(valor1){
                        case "t1":
                            switch(temporal){
                                case"t1":
                                    
                                    t1=t1-Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t1-Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t1-Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t1-Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t1-Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t1-Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t1-Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t1-Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t1-Float.parseFloat(valor2);
                                    break;    
                            }break; 
                        case "t2":
                            switch(temporal){
                                case"t1":
                                    t1=t2-Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t2-Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t2-Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t2-Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t2-Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t2-Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t2-Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t2-Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t2-Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t3":
                            switch(temporal){
                                case"t1":
                                    t1=t3-Float.parseFloat(valor2);;
                                    break;
                                case"t2":
                                   t2=t3-Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t3-Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t3-Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t3-Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t3-Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t3-Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t3-Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t3-Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t4":
                            switch(temporal){
                                case"t1":
                                    t1=t4-Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t4-Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t4-Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t4-Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t4-Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t4-Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t4-Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t4-Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t4-Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t5":
                            switch(temporal){
                                case"t1":
                                    t1=t5-Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t5-Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t5-Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t5-Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t5-Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t5-Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t5-Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t5-Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t5-Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t6":
                            switch(temporal){
                                case"t1":
                                    t1=t6-Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t6-Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t6-Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t6-Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t6-Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t6-Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t6-Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t6-Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t6-Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t7":
                           switch(temporal){
                                case"t1":
                                    t1=t7-Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t7-Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t7-Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t7-Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t7-Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t7-Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t7-Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t7-Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t7-Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t8":
                     switch(temporal){
                                case"t1":
                                    t1=t8-Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t8-Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t8-Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t8-Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t8-Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t8-Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t8-Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t8-Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t8-Float.parseFloat(valor2);
                                    break;    
                            }break;
                         }
                    }
            //num,tx
            if(!(("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1)))&&(("t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)))){
                    switch(valor2){
                        case "t1":
                            switch(temporal){
                                case"t1":
                                    t1=Float.parseFloat(valor1)-t1;
                                    break;
                                case"t2":
                                   t2=Float.parseFloat(valor1)-t1;
                                    break;
                                case"t3":
                                   t3=Float.parseFloat(valor1)-t1;
                                    break;
                                case"t4":
                                   t4=Float.parseFloat(valor1)-t1;
                                    break;
                                case"t5":
                                   t5=Float.parseFloat(valor1)-t1;
                                    break;
                                case"t6":
                                   t6=Float.parseFloat(valor1)-t1;
                                    break;
                                case"t7":
                                   t7=Float.parseFloat(valor1)-t1;
                                    break; 
                                case"t8":
                                   t8=Float.parseFloat(valor1)-t1;
                                    break; 
                                case"t9":
                                   t9=Float.parseFloat(valor1)-t1;
                                    break;    
                            }break; 
                        case "t2":
                            switch(temporal){
                                case"t1":
                                    t1=Float.parseFloat(valor1)-t2;
                                    break;
                                case"t2":
                                   t2=Float.parseFloat(valor1)-t2;
                                    break;
                                case"t3":
                                   t3=Float.parseFloat(valor1)-t2;
                                    break;
                                case"t4":
                                   t4=Float.parseFloat(valor1)-t2;
                                    break;
                                case"t5":
                                   t5=Float.parseFloat(valor1)-t2;
                                    break;
                                case"t6":
                                   t6=Float.parseFloat(valor1)-t2;
                                    break;
                                case"t7":
                                   t7=Float.parseFloat(valor1)-t2;
                                    break; 
                                case"t8":
                                   t8=Float.parseFloat(valor1)-t2;
                                    break; 
                                case"t9":
                                   t9=Float.parseFloat(valor1)-t2;
                                    break;    
                            }break;
                        case "t3":
                            switch(temporal){
                                case"t1":
                                    t1=Float.parseFloat(valor1)-t3;
                                    break;
                                case"t2":
                                   t2=Float.parseFloat(valor1)-t3;
                                    break;
                                case"t3":
                                   t3=Float.parseFloat(valor1)-t3;
                                    break;
                                case"t4":
                                   t4=Float.parseFloat(valor1)-t3;
                                    break;
                                case"t5":
                                   t5=Float.parseFloat(valor1)-t3;
                                    break;
                                case"t6":
                                   t6=Float.parseFloat(valor1)-t3;
                                    break;
                                case"t7":
                                   t7=Float.parseFloat(valor1)-t3;
                                    break; 
                                case"t8":
                                   t8=Float.parseFloat(valor1)-t3;
                                    break; 
                                case"t9":
                                   t9=Float.parseFloat(valor1)-t3;
                                    break;    
                            }break;
                        case "t4":
                            switch(temporal){
                                case"t1":
                                    t1=Float.parseFloat(valor1)-t4;
                                    break;
                                case"t2":
                                   t2=Float.parseFloat(valor1)-t4;
                                    break;
                                case"t3":
                                   t3=Float.parseFloat(valor1)-t4;
                                    break;
                                case"t4":
                                   t4=Float.parseFloat(valor1)-t4;
                                    break;
                                case"t5":
                                   t5=Float.parseFloat(valor1)-t4;
                                    break;
                                case"t6":
                                   t6=Float.parseFloat(valor1)-t4;
                                    break;
                                case"t7":
                                   t7=Float.parseFloat(valor1)-t4;
                                    break; 
                                case"t8":
                                   t8=Float.parseFloat(valor1)-t4;
                                    break; 
                                case"t9":
                                   t9=Float.parseFloat(valor1)-t4;
                                    break;    
                            }break;
                        case "t5":
                            switch(temporal){
                                case"t1":
                                    t1=Float.parseFloat(valor1)-t5;
                                    break;
                                case"t2":
                                   t2=Float.parseFloat(valor1)-t5;
                                    break;
                                case"t3":
                                   t3=Float.parseFloat(valor1)-t5;
                                    break;
                                case"t4":
                                   t4=Float.parseFloat(valor1)-t5;
                                    break;
                                case"t5":
                                   t5=Float.parseFloat(valor1)-t5;
                                    break;
                                case"t6":
                                   t6=Float.parseFloat(valor1)-t5;
                                    break;
                                case"t7":
                                   t7=Float.parseFloat(valor1)-t5;
                                    break; 
                                case"t8":
                                   t8=Float.parseFloat(valor1)-t5;
                                    break; 
                                case"t9":
                                   t9=Float.parseFloat(valor1)-t5;
                                    break;    
                            }break;
                        case "t6":
                            switch(temporal){
                                case"t1":
                                    t1=Float.parseFloat(valor1)-t6;
                                    break;
                                case"t2":
                                   t2=Float.parseFloat(valor1)-t6;
                                    break;
                                case"t3":
                                   t3=Float.parseFloat(valor1)-t6;
                                    break;
                                case"t4":
                                   t4=Float.parseFloat(valor1)-t6;
                                    break;
                                case"t5":
                                   t5=Float.parseFloat(valor1)-t6;
                                    break;
                                case"t6":
                                   t6=Float.parseFloat(valor1)-t6;
                                    break;
                                case"t7":
                                   t7=Float.parseFloat(valor1)-t6;
                                    break; 
                                case"t8":
                                   t8=Float.parseFloat(valor1)-t6;
                                    break; 
                                case"t9":
                                   t9=Float.parseFloat(valor1)-t6;
                                    break;    
                            }break;
                        case "t7":
                            switch(temporal){
                                case"t1":
                                    t1=Float.parseFloat(valor1)-t7;
                                    break;
                                case"t2":
                                   t2=Float.parseFloat(valor1)-t7;
                                    break;
                                case"t3":
                                   t3=Float.parseFloat(valor1)-t7;
                                    break;
                                case"t4":
                                   t4=Float.parseFloat(valor1)-t7;
                                    break;
                                case"t5":
                                   t5=Float.parseFloat(valor1)-t7;
                                    break;
                                case"t6":
                                   t6=Float.parseFloat(valor1)-t7;
                                    break;
                                case"t7":
                                   t7=Float.parseFloat(valor1)-t7;
                                    break; 
                                case"t8":
                                   t8=Float.parseFloat(valor1)-t7;
                                    break; 
                                case"t9":
                                   t9=Float.parseFloat(valor1)-t7;
                                    break;    
                            }break;
                        case "t8":
                            switch(temporal){
                                case"t1":
                                    t1=Float.parseFloat(valor1)-t8;
                                    break;
                                case"t2":
                                   t2=Float.parseFloat(valor1)-t8;
                                    break;
                                case"t3":
                                   t3=Float.parseFloat(valor1)-t8;
                                    break;
                                case"t4":
                                   t4=Float.parseFloat(valor1)-t8;
                                    break;
                                case"t5":
                                   t5=Float.parseFloat(valor1)-t8;
                                    break;
                                case"t6":
                                   t6=Float.parseFloat(valor1)-t8;
                                    break;
                                case"t7":
                                   t7=Float.parseFloat(valor1)-t8;
                                    break; 
                                case"t8":
                                   t8=Float.parseFloat(valor1)-t8;
                                    break; 
                                case"t9":
                                   t9=Float.parseFloat(valor1)-t8;
                                    break;    
                            }break;
                         }
                
                
                    }
            //tx,tx
            if(("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1))&&(("t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)))){
                    //temporal=valor1*valor2
                switch(valor1){
                    case "t1":
                        switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t1-t1;
                                        break;
                                    case"t2":
                                        t2=t1-t1;
                                        break;
                                    case"t3":
                                        t3=t1-t1;
                                    case"t4":
                                        t4=t1-t1;
                                        break;
                                    case"t5":
                                        t5=t1-t1;
                                        break;
                                    case"t6":
                                        t6=t1-t1;
                                        break;
                                    case"t7":
                                        t7=t1-t1;
                                        break;
                                    case"t8":
                                        t8=t1-t1;
                                        break;
                                    case"t9":
                                        t9=t1-t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t1-t2;
                                        break;
                                    case"t2":
                                        t2=t1-t2;
                                        break;
                                    case"t3":
                                        t3=t1-t2;
                                    case"t4":
                                        t4=t1-t2;
                                        break;
                                    case"t5":
                                        t5=t1-t2;
                                        break;
                                    case"t6":
                                        t6=t1-t2;
                                        break;
                                    case"t7":
                                        t7=t1-t2;
                                        break;
                                    case"t8":
                                        t8=t1-t2;
                                        break;
                                    case"t9":
                                        t9=t1-t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t1-t3;
                                        break;
                                    case"t2":
                                        t2=t1-t3;
                                        break;
                                    case"t3":
                                        t3=t1-t3;
                                    case"t4":
                                        t4=t1-t3;
                                        break;
                                    case"t5":
                                        t5=t1-t3;
                                        break;
                                    case"t6":
                                        t6=t1-t3;
                                        break;
                                    case"t7":
                                        t7=t1-t3;
                                        break;
                                    case"t8":
                                        t8=t1-t3;
                                        break;
                                    case"t9":
                                        t9=t1-t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t1-t4;
                                        break;
                                    case"t2":
                                        t2=t1-t4;
                                        break;
                                    case"t3":
                                        t3=t1-t4;
                                    case"t4":
                                        t4=t1-t4;
                                        break;
                                    case"t5":
                                        t5=t1-t4;
                                        break;
                                    case"t6":
                                        t6=t1-t4;
                                        break;
                                    case"t7":
                                        t7=t1-t4;
                                        break;
                                    case"t8":
                                        t8=t1-t4;
                                        break;
                                    case"t9":
                                        t9=t1-t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t1-t5;
                                        break;
                                    case"t2":
                                        t2=t1-t5;
                                        break;
                                    case"t3":
                                        t3=t1-t5;
                                    case"t4":
                                        t4=t1-t5;
                                        break;
                                    case"t5":
                                        t5=t1-t5;
                                        break;
                                    case"t6":
                                        t6=t1-t5;
                                        break;
                                    case"t7":
                                        t7=t1-t5;
                                        break;
                                    case"t8":
                                        t8=t1-t5;
                                        break;
                                    case"t9":
                                        t9=t1-t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t1-t6;
                                        break;
                                    case"t2":
                                        t2=t1-t6;
                                        break;
                                    case"t3":
                                        t3=t1-t6;
                                    case"t4":
                                        t4=t1-t6;
                                        break;
                                    case"t5":
                                        t5=t1-t6;
                                        break;
                                    case"t6":
                                        t6=t1-t6;
                                        break;
                                    case"t7":
                                        t7=t1-t6;
                                        break;
                                    case"t8":
                                        t8=t1-t6;
                                        break;
                                    case"t9":
                                        t9=t1-t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t1-t7;
                                        break;
                                    case"t2":
                                        t2=t1-t7;
                                        break;
                                    case"t3":
                                        t3=t1-t7;
                                    case"t4":
                                        t4=t1-t7;
                                        break;
                                    case"t5":
                                        t5=t1-t7;
                                        break;
                                    case"t6":
                                        t6=t1-t7;
                                        break;
                                    case"t7":
                                        t7=t1-t7;
                                        break;
                                    case"t8":
                                        t8=t1-t7;
                                        break;
                                    case"t9":
                                        t9=t1-t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t1-t8;
                                        break;
                                    case"t2":
                                        t2=t1-t8;
                                        break;
                                    case"t3":
                                        t3=t1-t8;
                                    case"t4":
                                        t4=t1-t8;
                                        break;
                                    case"t5":
                                        t5=t1-t8;
                                        break;
                                    case"t6":
                                        t6=t1-t8;
                                        break;
                                    case"t7":
                                        t7=t1-t8;
                                        break;
                                    case"t8":
                                        t8=t1-t8;
                                        break;
                                    case"t9":
                                        t9=t1-t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t1-t9;
                                        break;
                                    case"t2":
                                        t2=t1-t9;
                                        break;
                                    case"t3":
                                        t3=t1-t9;
                                    case"t4":
                                        t4=t1-t9;
                                        break;
                                    case"t5":
                                        t5=t1-t9;
                                        break;
                                    case"t6":
                                        t6=t1-t9;
                                        break;
                                    case"t7":
                                        t7=t1-t9;
                                        break;
                                    case"t8":
                                        t8=t1-t9;
                                        break;
                                    case"t9":
                                        t9=t1-t9;
                                        break;
                                } break;
                        }break;
                    case "t2":
                        switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t2-t1;
                                        break;
                                    case"t2":
                                        t2=t2-t1;
                                        break;
                                    case"t3":
                                        t3=t2-t1;
                                    case"t4":
                                        t4=t2-t1;
                                        break;
                                    case"t5":
                                        t5=t2-t1;
                                        break;
                                    case"t6":
                                        t6=t2-t1;
                                        break;
                                    case"t7":
                                        t7=t2-t1;
                                        break;
                                    case"t8":
                                        t8=t2-t1;
                                        break;
                                    case"t9":
                                        t9=t2-t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t2-t2;
                                        break;
                                    case"t2":
                                        t2=t2-t2;
                                        break;
                                    case"t3":
                                        t3=t2-t2;
                                    case"t4":
                                        t4=t2-t2;
                                        break;
                                    case"t5":
                                        t5=t2-t2;
                                        break;
                                    case"t6":
                                        t6=t2-t2;
                                        break;
                                    case"t7":
                                        t7=t2-t2;
                                        break;
                                    case"t8":
                                        t8=t2-t2;
                                        break;
                                    case"t9":
                                        t9=t2-t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t2-t3;
                                        break;
                                    case"t2":
                                        t2=t2-t3;
                                        break;
                                    case"t3":
                                        t3=t2-t3;
                                    case"t4":
                                        t4=t2-t3;
                                        break;
                                    case"t5":
                                        t5=t2-t3;
                                        break;
                                    case"t6":
                                        t6=t2-t3;
                                        break;
                                    case"t7":
                                        t7=t2-t3;
                                        break;
                                    case"t8":
                                        t8=t2-t3;
                                        break;
                                    case"t9":
                                        t9=t2-t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t2-t4;
                                        break;
                                    case"t2":
                                        t2=t2-t4;
                                        break;
                                    case"t3":
                                        t3=t2-t4;
                                    case"t4":
                                        t4=t2-t4;
                                        break;
                                    case"t5":
                                        t5=t2-t4;
                                        break;
                                    case"t6":
                                        t6=t2-t4;
                                        break;
                                    case"t7":
                                        t7=t2-t4;
                                        break;
                                    case"t8":
                                        t8=t2-t4;
                                        break;
                                    case"t9":
                                        t9=t2-t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t2-t5;
                                        break;
                                    case"t2":
                                        t2=t2-t5;
                                        break;
                                    case"t3":
                                        t3=t2-t5;
                                    case"t4":
                                        t4=t2-t5;
                                        break;
                                    case"t5":
                                        t5=t2-t5;
                                        break;
                                    case"t6":
                                        t6=t2-t5;
                                        break;
                                    case"t7":
                                        t7=t2-t5;
                                        break;
                                    case"t8":
                                        t8=t2-t5;
                                        break;
                                    case"t9":
                                        t9=t2-t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t2-t6;
                                        break;
                                    case"t2":
                                        t2=t2-t6;
                                        break;
                                    case"t3":
                                        t3=t2-t6;
                                    case"t4":
                                        t4=t2-t6;
                                        break;
                                    case"t5":
                                        t5=t2-t6;
                                        break;
                                    case"t6":
                                        t6=t2-t6;
                                        break;
                                    case"t7":
                                        t7=t2-t6;
                                        break;
                                    case"t8":
                                        t8=t2-t6;
                                        break;
                                    case"t9":
                                        t9=t2-t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t2-t7;
                                        break;
                                    case"t2":
                                        t2=t2-t7;
                                        break;
                                    case"t3":
                                        t3=t2-t7;
                                    case"t4":
                                        t4=t2-t7;
                                        break;
                                    case"t5":
                                        t5=t2-t7;
                                        break;
                                    case"t6":
                                        t6=t2-t7;
                                        break;
                                    case"t7":
                                        t7=t2-t7;
                                        break;
                                    case"t8":
                                        t8=t2-t7;
                                        break;
                                    case"t9":
                                        t9=t2-t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t2-t8;
                                        break;
                                    case"t2":
                                        t2=t2-t8;
                                        break;
                                    case"t3":
                                        t3=t2-t8;
                                    case"t4":
                                        t4=t2-t8;
                                        break;
                                    case"t5":
                                        t5=t2-t8;
                                        break;
                                    case"t6":
                                        t6=t2-t8;
                                        break;
                                    case"t7":
                                        t7=t2-t8;
                                        break;
                                    case"t8":
                                        t8=t2-t8;
                                        break;
                                    case"t9":
                                        t9=t2-t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t2-t9;
                                        break;
                                    case"t2":
                                        t2=t2-t9;
                                        break;
                                    case"t3":
                                        t3=t2-t9;
                                    case"t4":
                                        t4=t2-t9;
                                        break;
                                    case"t5":
                                        t5=t2-t9;
                                        break;
                                    case"t6":
                                        t6=t2-t9;
                                        break;
                                    case"t7":
                                        t7=t2-t9;
                                        break;
                                    case"t8":
                                        t8=t2-t9;
                                        break;
                                    case"t9":
                                        t9=t2-t9;
                                        break;
                                } break;
                        }break;
                  case"t3":    
                      switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t3-t1;
                                        break;
                                    case"t2":
                                        t2=t3-t1;
                                        break;
                                    case"t3":
                                        t3=t3-t1;
                                    case"t4":
                                        t4=t3-t1;
                                        break;
                                    case"t5":
                                        t5=t3-t1;
                                        break;
                                    case"t6":
                                        t6=t3-t1;
                                        break;
                                    case"t7":
                                        t7=t3-t1;
                                        break;
                                    case"t8":
                                        t8=t3-t1;
                                        break;
                                    case"t9":
                                        t9=t3-t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t3-t2;
                                        break;
                                    case"t2":
                                        t2=t3-t2;
                                        break;
                                    case"t3":
                                        t3=t3-t2;
                                    case"t4":
                                        t4=t3-t2;
                                        break;
                                    case"t5":
                                        t5=t3-t2;
                                        break;
                                    case"t6":
                                        t6=t3-t2;
                                        break;
                                    case"t7":
                                        t7=t3-t2;
                                        break;
                                    case"t8":
                                        t8=t3-t2;
                                        break;
                                    case"t9":
                                        t9=t3-t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t3-t3;
                                        break;
                                    case"t2":
                                        t2=t3-t3;
                                        break;
                                    case"t3":
                                        t3=t3-t3;
                                    case"t4":
                                        t4=t3-t3;
                                        break;
                                    case"t5":
                                        t5=t3-t3;
                                        break;
                                    case"t6":
                                        t6=t3-t3;
                                        break;
                                    case"t7":
                                        t7=t3-t3;
                                        break;
                                    case"t8":
                                        t8=t3-t3;
                                        break;
                                    case"t9":
                                        t9=t3-t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t3-t4;
                                        break;
                                    case"t2":
                                        t2=t3-t4;
                                        break;
                                    case"t3":
                                        t3=t3-t4;
                                    case"t4":
                                        t4=t3-t4;
                                        break;
                                    case"t5":
                                        t5=t3-t4;
                                        break;
                                    case"t6":
                                        t6=t3-t4;
                                        break;
                                    case"t7":
                                        t7=t3-t4;
                                        break;
                                    case"t8":
                                        t8=t3-t4;
                                        break;
                                    case"t9":
                                        t9=t3-t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t3-t5;
                                        break;
                                    case"t2":
                                        t2=t3-t5;
                                        break;
                                    case"t3":
                                        t3=t3-t5;
                                    case"t4":
                                        t4=t3-t5;
                                        break;
                                    case"t5":
                                        t5=t3-t5;
                                        break;
                                    case"t6":
                                        t6=t3-t5;
                                        break;
                                    case"t7":
                                        t7=t3-t5;
                                        break;
                                    case"t8":
                                        t8=t3-t5;
                                        break;
                                    case"t9":
                                        t9=t3-t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t3-t6;
                                        break;
                                    case"t2":
                                        t2=t3-t6;
                                        break;
                                    case"t3":
                                        t3=t3-t6;
                                    case"t4":
                                        t4=t3-t6;
                                        break;
                                    case"t5":
                                        t5=t3-t6;
                                        break;
                                    case"t6":
                                        t6=t3-t6;
                                        break;
                                    case"t7":
                                        t7=t3-t6;
                                        break;
                                    case"t8":
                                        t8=t3-t6;
                                        break;
                                    case"t9":
                                        t9=t3-t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t3-t7;
                                        break;
                                    case"t2":
                                        t2=t3-t7;
                                        break;
                                    case"t3":
                                        t3=t3-t7;
                                    case"t4":
                                        t4=t3-t7;
                                        break;
                                    case"t5":
                                        t5=t3-t7;
                                        break;
                                    case"t6":
                                        t6=t3-t7;
                                        break;
                                    case"t7":
                                        t7=t3-t7;
                                        break;
                                    case"t8":
                                        t8=t3-t7;
                                        break;
                                    case"t9":
                                        t9=t3-t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t3-t8;
                                        break;
                                    case"t2":
                                        t2=t3-t8;
                                        break;
                                    case"t3":
                                        t3=t3-t8;
                                    case"t4":
                                        t4=t3-t8;
                                        break;
                                    case"t5":
                                        t5=t3-t8;
                                        break;
                                    case"t6":
                                        t6=t3-t8;
                                        break;
                                    case"t7":
                                        t7=t3-t8;
                                        break;
                                    case"t8":
                                        t8=t3-t8;
                                        break;
                                    case"t9":
                                        t9=t3-t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t3-t9;
                                        break;
                                    case"t2":
                                        t2=t3-t9;
                                        break;
                                    case"t3":
                                        t3=t3-t9;
                                    case"t4":
                                        t4=t3-t9;
                                        break;
                                    case"t5":
                                        t5=t3-t9;
                                        break;
                                    case"t6":
                                        t6=t3-t9;
                                        break;
                                    case"t7":
                                        t7=t3-t9;
                                        break;
                                    case"t8":
                                        t8=t3-t9;
                                        break;
                                    case"t9":
                                        t9=t3-t9;
                                        break;
                                } break;
                        }break;
              case"t4":
                  switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t4-t1;
                                        break;
                                    case"t2":
                                        t2=t4-t1;
                                        break;
                                    case"t3":
                                        t3=t4-t1;
                                    case"t4":
                                        t4=t4-t1;
                                        break;
                                    case"t5":
                                        t5=t4-t1;
                                        break;
                                    case"t6":
                                        t6=t4-t1;
                                        break;
                                    case"t7":
                                        t7=t4-t1;
                                        break;
                                    case"t8":
                                        t8=t4-t1;
                                        break;
                                    case"t9":
                                        t9=t4-t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t4-t2;
                                        break;
                                    case"t2":
                                        t2=t4-t2;
                                        break;
                                    case"t3":
                                        t3=t4-t2;
                                    case"t4":
                                        t4=t4-t2;
                                        break;
                                    case"t5":
                                        t5=t4-t2;
                                        break;
                                    case"t6":
                                        t6=t4-t2;
                                        break;
                                    case"t7":
                                        t7=t4-t2;
                                        break;
                                    case"t8":
                                        t8=t4-t2;
                                        break;
                                    case"t9":
                                        t9=t4-t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t4-t3;
                                        break;
                                    case"t2":
                                        t2=t4-t3;
                                        break;
                                    case"t3":
                                        t3=t4-t3;
                                    case"t4":
                                        t4=t4-t3;
                                        break;
                                    case"t5":
                                        t5=t4-t3;
                                        break;
                                    case"t6":
                                        t6=t4-t3;
                                        break;
                                    case"t7":
                                        t7=t4-t3;
                                        break;
                                    case"t8":
                                        t8=t4-t3;
                                        break;
                                    case"t9":
                                        t9=t4-t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t4-t4;
                                        break;
                                    case"t2":
                                        t2=t4-t4;
                                        break;
                                    case"t3":
                                        t3=t4-t4;
                                    case"t4":
                                        t4=t4-t4;
                                        break;
                                    case"t5":
                                        t5=t4-t4;
                                        break;
                                    case"t6":
                                        t6=t4-t4;
                                        break;
                                    case"t7":
                                        t7=t4-t4;
                                        break;
                                    case"t8":
                                        t8=t4-t4;
                                        break;
                                    case"t9":
                                        t9=t4-t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t4-t5;
                                        break;
                                    case"t2":
                                        t2=t4-t5;
                                        break;
                                    case"t3":
                                        t3=t4-t5;
                                    case"t4":
                                        t4=t4-t5;
                                        break;
                                    case"t5":
                                        t5=t4-t5;
                                        break;
                                    case"t6":
                                        t6=t4-t5;
                                        break;
                                    case"t7":
                                        t7=t4-t5;
                                        break;
                                    case"t8":
                                        t8=t4-t5;
                                        break;
                                    case"t9":
                                        t9=t4-t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t4-t6;
                                        break;
                                    case"t2":
                                        t2=t4-t6;
                                        break;
                                    case"t3":
                                        t3=t4-t6;
                                    case"t4":
                                        t4=t4-t6;
                                        break;
                                    case"t5":
                                        t5=t4-t6;
                                        break;
                                    case"t6":
                                        t6=t4-t6;
                                        break;
                                    case"t7":
                                        t7=t4-t6;
                                        break;
                                    case"t8":
                                        t8=t4-t6;
                                        break;
                                    case"t9":
                                        t9=t4-t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t4-t7;
                                        break;
                                    case"t2":
                                        t2=t4-t7;
                                        break;
                                    case"t3":
                                        t3=t4-t7;
                                    case"t4":
                                        t4=t4-t7;
                                        break;
                                    case"t5":
                                        t5=t4-t7;
                                        break;
                                    case"t6":
                                        t6=t4-t7;
                                        break;
                                    case"t7":
                                        t7=t4-t7;
                                        break;
                                    case"t8":
                                        t8=t4-t7;
                                        break;
                                    case"t9":
                                        t9=t4-t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t4-t8;
                                        break;
                                    case"t2":
                                        t2=t4-t8;
                                        break;
                                    case"t3":
                                        t3=t4-t8;
                                    case"t4":
                                        t4=t4-t8;
                                        break;
                                    case"t5":
                                        t5=t4-t8;
                                        break;
                                    case"t6":
                                        t6=t4-t8;
                                        break;
                                    case"t7":
                                        t7=t4-t8;
                                        break;
                                    case"t8":
                                        t8=t4-t8;
                                        break;
                                    case"t9":
                                        t9=t4-t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t4-t9;
                                        break;
                                    case"t2":
                                        t2=t4-t9;
                                        break;
                                    case"t3":
                                        t3=t4-t9;
                                    case"t4":
                                        t4=t4-t9;
                                        break;
                                    case"t5":
                                        t5=t4-t9;
                                        break;
                                    case"t6":
                                        t6=t4-t9;
                                        break;
                                    case"t7":
                                        t7=t4-t9;
                                        break;
                                    case"t8":
                                        t8=t4-t9;
                                        break;
                                    case"t9":
                                        t9=t4-t9;
                                        break;
                                } break;
                        }break;
                      
              case"t5":
                  switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t5-t1;
                                        break;
                                    case"t2":
                                        t2=t5-t1;
                                        break;
                                    case"t3":
                                        t3=t5-t1;
                                    case"t4":
                                        t4=t5-t1;
                                        break;
                                    case"t5":
                                        t5=t5-t1;
                                        break;
                                    case"t6":
                                        t6=t5-t1;
                                        break;
                                    case"t7":
                                        t7=t5-t1;
                                        break;
                                    case"t8":
                                        t8=t5-t1;
                                        break;
                                    case"t9":
                                        t9=t5-t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t5-t2;
                                        break;
                                    case"t2":
                                        t2=t5-t2;
                                        break;
                                    case"t3":
                                        t3=t5-t2;
                                    case"t4":
                                        t4=t5-t2;
                                        break;
                                    case"t5":
                                        t5=t5-t2;
                                        break;
                                    case"t6":
                                        t6=t5-t2;
                                        break;
                                    case"t7":
                                        t7=t5-t2;
                                        break;
                                    case"t8":
                                        t8=t5-t2;
                                        break;
                                    case"t9":
                                        t9=t5-t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t5-t3;
                                        break;
                                    case"t2":
                                        t2=t5-t3;
                                        break;
                                    case"t3":
                                        t3=t5-t3;
                                    case"t4":
                                        t4=t5-t3;
                                        break;
                                    case"t5":
                                        t5=t5-t3;
                                        break;
                                    case"t6":
                                        t6=t5-t3;
                                        break;
                                    case"t7":
                                        t7=t5-t3;
                                        break;
                                    case"t8":
                                        t8=t5-t3;
                                        break;
                                    case"t9":
                                        t9=t5-t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t5-t4;
                                        break;
                                    case"t2":
                                        t2=t5-t4;
                                        break;
                                    case"t3":
                                        t3=t5-t4;
                                    case"t4":
                                        t4=t5-t4;
                                        break;
                                    case"t5":
                                        t5=t5-t4;
                                        break;
                                    case"t6":
                                        t6=t5-t4;
                                        break;
                                    case"t7":
                                        t7=t5-t4;
                                        break;
                                    case"t8":
                                        t8=t5-t4;
                                        break;
                                    case"t9":
                                        t9=t5-t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t5;
                                        break;
                                    case"t2":
                                        t2=t5*t5;
                                        break;
                                    case"t3":
                                        t3=t5-t5;
                                    case"t4":
                                        t4=t5-t5;
                                        break;
                                    case"t5":
                                        t5=t5-t5;
                                        break;
                                    case"t6":
                                        t6=t5-t5;
                                        break;
                                    case"t7":
                                        t7=t5-t5;
                                        break;
                                    case"t8":
                                        t8=t5-t5;
                                        break;
                                    case"t9":
                                        t9=t5-t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t5-t6;
                                        break;
                                    case"t2":
                                        t2=t5-t6;
                                        break;
                                    case"t3":
                                        t3=t5-t6;
                                    case"t4":
                                        t4=t5-t6;
                                        break;
                                    case"t5":
                                        t5=t5-t6;
                                        break;
                                    case"t6":
                                        t6=t5-t6;
                                        break;
                                    case"t7":
                                        t7=t5-t6;
                                        break;
                                    case"t8":
                                        t8=t5-t6;
                                        break;
                                    case"t9":
                                        t9=t5-t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t5-t7;
                                        break;
                                    case"t2":
                                        t2=t5-t7;
                                        break;
                                    case"t3":
                                        t3=t5-t7;
                                    case"t4":
                                        t4=t5-t7;
                                        break;
                                    case"t5":
                                        t5=t5-t7;
                                        break;
                                    case"t6":
                                        t6=t5-t7;
                                        break;
                                    case"t7":
                                        t7=t5-t7;
                                        break;
                                    case"t8":
                                        t8=t5-t7;
                                        break;
                                    case"t9":
                                        t9=t5-t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t5-t8;
                                        break;
                                    case"t2":
                                        t2=t5-t8;
                                        break;
                                    case"t3":
                                        t3=t5-t8;
                                    case"t4":
                                        t4=t5-t8;
                                        break;
                                    case"t5":
                                        t5=t5-t8;
                                        break;
                                    case"t6":
                                        t6=t5-t8;
                                        break;
                                    case"t7":
                                        t7=t5-t8;
                                        break;
                                    case"t8":
                                        t8=t5-t8;
                                        break;
                                    case"t9":
                                        t9=t5-t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t5-t9;
                                        break;
                                    case"t2":
                                        t2=t5-t9;
                                        break;
                                    case"t3":
                                        t3=t5-t9;
                                    case"t4":
                                        t4=t5-t9;
                                        break;
                                    case"t5":
                                        t5=t5-t9;
                                        break;
                                    case"t6":
                                        t6=t5-t9;
                                        break;
                                    case"t7":
                                        t7=t5-t9;
                                        break;
                                    case"t8":
                                        t8=t5-t9;
                                        break;
                                    case"t9":
                                        t9=t5-t9;
                                        break;
                                } break;
                        }break;
            case"t6":
                switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t1;
                                        break;
                                    case"t2":
                                        t2=t6-t1;
                                        break;
                                    case"t3":
                                        t3=t6-t1;
                                    case"t4":
                                        t4=t6-t1;
                                        break;
                                    case"t5":
                                        t5=t6-t1;
                                        break;
                                    case"t6":
                                        t6=t6-t1;
                                        break;
                                    case"t7":
                                        t7=t6-t1;
                                        break;
                                    case"t8":
                                        t8=t6-t1;
                                        break;
                                    case"t9":
                                        t9=t6-t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t2;
                                        break;
                                    case"t2":
                                        t2=t6-t2;
                                        break;
                                    case"t3":
                                        t3=t6-t2;
                                    case"t4":
                                        t4=t6-t2;
                                        break;
                                    case"t5":
                                        t5=t6-t2;
                                        break;
                                    case"t6":
                                        t6=t6-t2;
                                        break;
                                    case"t7":
                                        t7=t6-t2;
                                        break;
                                    case"t8":
                                        t8=t6-t2;
                                        break;
                                    case"t9":
                                        t9=t6-t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t3;
                                        break;
                                    case"t2":
                                        t2=t6-t3;
                                        break;
                                    case"t3":
                                        t3=t6-t3;
                                    case"t4":
                                        t4=t6-t3;
                                        break;
                                    case"t5":
                                        t5=t6-t3;
                                        break;
                                    case"t6":
                                        t6=t6-t3;
                                        break;
                                    case"t7":
                                        t7=t6-t3;
                                        break;
                                    case"t8":
                                        t8=t6-t3;
                                        break;
                                    case"t9":
                                        t9=t6-t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t4;
                                        break;
                                    case"t2":
                                        t2=t6-t4;
                                        break;
                                    case"t3":
                                        t3=t6-t4;
                                    case"t4":
                                        t4=t6-t4;
                                        break;
                                    case"t5":
                                        t5=t6-t4;
                                        break;
                                    case"t6":
                                        t6=t6-t4;
                                        break;
                                    case"t7":
                                        t7=t6-t4;
                                        break;
                                    case"t8":
                                        t8=t6-t4;
                                        break;
                                    case"t9":
                                        t9=t6-t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t5;
                                        break;
                                    case"t2":
                                        t2=t6-t5;
                                        break;
                                    case"t3":
                                        t3=t6-t5;
                                    case"t4":
                                        t4=t6-t5;
                                        break;
                                    case"t5":
                                        t5=t6-t5;
                                        break;
                                    case"t6":
                                        t6=t6-t5;
                                        break;
                                    case"t7":
                                        t7=t6-t5;
                                        break;
                                    case"t8":
                                        t8=t6-t5;
                                        break;
                                    case"t9":
                                        t9=t6-t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t6;
                                        break;
                                    case"t2":
                                        t2=t6-t6;
                                        break;
                                    case"t3":
                                        t3=t6-t6;
                                    case"t4":
                                        t4=t6-t6;
                                        break;
                                    case"t5":
                                        t5=t6-t6;
                                        break;
                                    case"t6":
                                        t6=t6-t6;
                                        break;
                                    case"t7":
                                        t7=t6-t6;
                                        break;
                                    case"t8":
                                        t8=t6-t6;
                                        break;
                                    case"t9":
                                        t9=t6-t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t7;
                                        break;
                                    case"t2":
                                        t2=t6*t7;
                                        break;
                                    case"t3":
                                        t3=t6*t7;
                                    case"t4":
                                        t4=t6*t7;
                                        break;
                                    case"t5":
                                        t5=t6*t7;
                                        break;
                                    case"t6":
                                        t6=t6*t7;
                                        break;
                                    case"t7":
                                        t7=t6-t7;
                                        break;
                                    case"t8":
                                        t8=t6-t7;
                                        break;
                                    case"t9":
                                        t9=t6-t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t8;
                                        break;
                                    case"t2":
                                        t2=t6*t8;
                                        break;
                                    case"t3":
                                        t3=t6*t8;
                                    case"t4":
                                        t4=t6*t8;
                                        break;
                                    case"t5":
                                        t5=t6*t8;
                                        break;
                                    case"t6":
                                        t6=t6*t8;
                                        break;
                                    case"t7":
                                        t7=t6*t8;
                                        break;
                                    case"t8":
                                        t8=t6*t8;
                                        break;
                                    case"t9":
                                        t9=t6-t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t9;
                                        break;
                                    case"t2":
                                        t2=t6*t9;
                                        break;
                                    case"t3":
                                        t3=t6*t9;
                                    case"t4":
                                        t4=t6*t9;
                                        break;
                                    case"t5":
                                        t5=t6*t9;
                                        break;
                                    case"t6":
                                        t6=t6*t9;
                                        break;
                                    case"t7":
                                        t7=t6*t9;
                                        break;
                                    case"t8":
                                        t8=t6*t9;
                                        break;
                                    case"t9":
                                        t9=t6-t9;
                                        break;
                                } break;
                        }break;
            case "t7":
                        switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t1;
                                        break;
                                    case"t2":
                                        t2=t6-t1;
                                        break;
                                    case"t3":
                                        t3=t6-t1;
                                    case"t4":
                                        t4=t6-t1;
                                        break;
                                    case"t5":
                                        t5=t6-t1;
                                        break;
                                    case"t6":
                                        t6=t6-t1;
                                        break;
                                    case"t7":
                                        t7=t6-t1;
                                        break;
                                    case"t8":
                                        t8=t6-t1;
                                        break;
                                    case"t9":
                                        t9=t6-t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t2;
                                        break;
                                    case"t2":
                                        t2=t6-t2;
                                        break;
                                    case"t3":
                                        t3=t6-t2;
                                    case"t4":
                                        t4=t6-t2;
                                        break;
                                    case"t5":
                                        t5=t6-t2;
                                        break;
                                    case"t6":
                                        t6=t6-t2;
                                        break;
                                    case"t7":
                                        t7=t6-t2;
                                        break;
                                    case"t8":
                                        t8=t6-t2;
                                        break;
                                    case"t9":
                                        t9=t6-t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t3;
                                        break;
                                    case"t2":
                                        t2=t6-t3;
                                        break;
                                    case"t3":
                                        t3=t6-t3;
                                    case"t4":
                                        t4=t6-t3;
                                        break;
                                    case"t5":
                                        t5=t6-t3;
                                        break;
                                    case"t6":
                                        t6=t6-t3;
                                        break;
                                    case"t7":
                                        t7=t6-t3;
                                        break;
                                    case"t8":
                                        t8=t6-t3;
                                        break;
                                    case"t9":
                                        t9=t6-t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t4;
                                        break;
                                    case"t2":
                                        t2=t6-t4;
                                        break;
                                    case"t3":
                                        t3=t6-t4;
                                    case"t4":
                                        t4=t6-t4;
                                        break;
                                    case"t5":
                                        t5=t6-t4;
                                        break;
                                    case"t6":
                                        t6=t6-t4;
                                        break;
                                    case"t7":
                                        t7=t6-t4;
                                        break;
                                    case"t8":
                                        t8=t6-t4;
                                        break;
                                    case"t9":
                                        t9=t6-t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t5;
                                        break;
                                    case"t2":
                                        t2=t6-t5;
                                        break;
                                    case"t3":
                                        t3=t6-t5;
                                    case"t4":
                                        t4=t6-t5;
                                        break;
                                    case"t5":
                                        t5=t6-t5;
                                        break;
                                    case"t6":
                                        t6=t6-t5;
                                        break;
                                    case"t7":
                                        t7=t6-t5;
                                        break;
                                    case"t8":
                                        t8=t6-t5;
                                        break;
                                    case"t9":
                                        t9=t6-t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t6;
                                        break;
                                    case"t2":
                                        t2=t6-t6;
                                        break;
                                    case"t3":
                                        t3=t6-t6;
                                    case"t4":
                                        t4=t6-t6;
                                        break;
                                    case"t5":
                                        t5=t6-t6;
                                        break;
                                    case"t6":
                                        t6=t6-t6;
                                        break;
                                    case"t7":
                                        t7=t6-t6;
                                        break;
                                    case"t8":
                                        t8=t6-t6;
                                        break;
                                    case"t9":
                                        t9=t6-t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t7;
                                        break;
                                    case"t2":
                                        t2=t6*t7;
                                        break;
                                    case"t3":
                                        t3=t6*t7;
                                    case"t4":
                                        t4=t6*t7;
                                        break;
                                    case"t5":
                                        t5=t6*t7;
                                        break;
                                    case"t6":
                                        t6=t6*t7;
                                        break;
                                    case"t7":
                                        t7=t6-t7;
                                        break;
                                    case"t8":
                                        t8=t6-t7;
                                        break;
                                    case"t9":
                                        t9=t6-t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t8;
                                        break;
                                    case"t2":
                                        t2=t6*t8;
                                        break;
                                    case"t3":
                                        t3=t6*t8;
                                    case"t4":
                                        t4=t6*t8;
                                        break;
                                    case"t5":
                                        t5=t6*t8;
                                        break;
                                    case"t6":
                                        t6=t6*t8;
                                        break;
                                    case"t7":
                                        t7=t6*t8;
                                        break;
                                    case"t8":
                                        t8=t6*t8;
                                        break;
                                    case"t9":
                                        t9=t6-t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t9;
                                        break;
                                    case"t2":
                                        t2=t6*t9;
                                        break;
                                    case"t3":
                                        t3=t6*t9;
                                    case"t4":
                                        t4=t6*t9;
                                        break;
                                    case"t5":
                                        t5=t6*t9;
                                        break;
                                    case"t6":
                                        t6=t6*t9;
                                        break;
                                    case"t7":
                                        t7=t6*t9;
                                        break;
                                    case"t8":
                                        t8=t6*t9;
                                        break;
                                    case"t9":
                                        t9=t6-t9;
                                        break;
                                } break;
                        }break;
            case "t8":
                switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t1;
                                        break;
                                    case"t2":
                                        t2=t6-t1;
                                        break;
                                    case"t3":
                                        t3=t6-t1;
                                    case"t4":
                                        t4=t6-t1;
                                        break;
                                    case"t5":
                                        t5=t6-t1;
                                        break;
                                    case"t6":
                                        t6=t6-t1;
                                        break;
                                    case"t7":
                                        t7=t6-t1;
                                        break;
                                    case"t8":
                                        t8=t6-t1;
                                        break;
                                    case"t9":
                                        t9=t6-t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t2;
                                        break;
                                    case"t2":
                                        t2=t6-t2;
                                        break;
                                    case"t3":
                                        t3=t6-t2;
                                    case"t4":
                                        t4=t6-t2;
                                        break;
                                    case"t5":
                                        t5=t6-t2;
                                        break;
                                    case"t6":
                                        t6=t6-t2;
                                        break;
                                    case"t7":
                                        t7=t6-t2;
                                        break;
                                    case"t8":
                                        t8=t6-t2;
                                        break;
                                    case"t9":
                                        t9=t6-t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t3;
                                        break;
                                    case"t2":
                                        t2=t6-t3;
                                        break;
                                    case"t3":
                                        t3=t6-t3;
                                    case"t4":
                                        t4=t6-t3;
                                        break;
                                    case"t5":
                                        t5=t6-t3;
                                        break;
                                    case"t6":
                                        t6=t6-t3;
                                        break;
                                    case"t7":
                                        t7=t6-t3;
                                        break;
                                    case"t8":
                                        t8=t6-t3;
                                        break;
                                    case"t9":
                                        t9=t6-t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t4;
                                        break;
                                    case"t2":
                                        t2=t6-t4;
                                        break;
                                    case"t3":
                                        t3=t6-t4;
                                    case"t4":
                                        t4=t6-t4;
                                        break;
                                    case"t5":
                                        t5=t6-t4;
                                        break;
                                    case"t6":
                                        t6=t6-t4;
                                        break;
                                    case"t7":
                                        t7=t6-t4;
                                        break;
                                    case"t8":
                                        t8=t6-t4;
                                        break;
                                    case"t9":
                                        t9=t6-t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t5;
                                        break;
                                    case"t2":
                                        t2=t6-t5;
                                        break;
                                    case"t3":
                                        t3=t6-t5;
                                    case"t4":
                                        t4=t6-t5;
                                        break;
                                    case"t5":
                                        t5=t6-t5;
                                        break;
                                    case"t6":
                                        t6=t6-t5;
                                        break;
                                    case"t7":
                                        t7=t6-t5;
                                        break;
                                    case"t8":
                                        t8=t6-t5;
                                        break;
                                    case"t9":
                                        t9=t6-t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t6;
                                        break;
                                    case"t2":
                                        t2=t6-t6;
                                        break;
                                    case"t3":
                                        t3=t6-t6;
                                    case"t4":
                                        t4=t6-t6;
                                        break;
                                    case"t5":
                                        t5=t6-t6;
                                        break;
                                    case"t6":
                                        t6=t6-t6;
                                        break;
                                    case"t7":
                                        t7=t6-t6;
                                        break;
                                    case"t8":
                                        t8=t6-t6;
                                        break;
                                    case"t9":
                                        t9=t6-t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t6-t7;
                                        break;
                                    case"t2":
                                        t2=t6*t7;
                                        break;
                                    case"t3":
                                        t3=t6*t7;
                                    case"t4":
                                        t4=t6*t7;
                                        break;
                                    case"t5":
                                        t5=t6*t7;
                                        break;
                                    case"t6":
                                        t6=t6*t7;
                                        break;
                                    case"t7":
                                        t7=t6-t7;
                                        break;
                                    case"t8":
                                        t8=t6-t7;
                                        break;
                                    case"t9":
                                        t9=t6-t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t8;
                                        break;
                                    case"t2":
                                        t2=t6*t8;
                                        break;
                                    case"t3":
                                        t3=t6*t8;
                                    case"t4":
                                        t4=t6*t8;
                                        break;
                                    case"t5":
                                        t5=t6*t8;
                                        break;
                                    case"t6":
                                        t6=t6*t8;
                                        break;
                                    case"t7":
                                        t7=t6*t8;
                                        break;
                                    case"t8":
                                        t8=t6*t8;
                                        break;
                                    case"t9":
                                        t9=t6-t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t9;
                                        break;
                                    case"t2":
                                        t2=t6*t9;
                                        break;
                                    case"t3":
                                        t3=t6*t9;
                                    case"t4":
                                        t4=t6*t9;
                                        break;
                                    case"t5":
                                        t5=t6*t9;
                                        break;
                                    case"t6":
                                        t6=t6*t9;
                                        break;
                                    case"t7":
                                        t7=t6*t9;
                                        break;
                                    case"t8":
                                        t8=t6*t9;
                                        break;
                                    case"t9":
                                        t9=t6-t9;
                                        break;
                                } break;
                        }break;
                
                      
                
                }
                
                    }
      
      }else{
          switch(temporal){
         case "t1":
                t1= Float.parseFloat(valor1)- Float.parseFloat(valor2);
                
                break; 
         case "t2":
                t2=Float.parseFloat(valor1)- Float.parseFloat(valor2);
                 break; 
         case "t3":        
             t3=Float.parseFloat(valor1)- Float.parseFloat(valor2);
                 break; 
         case "t4":        
             t4=Float.parseFloat(valor1)- Float.parseFloat(valor2);
                 break;
         case "t5":        
             t5=Float.parseFloat(valor1)- Float.parseFloat(valor2);
                 break;
         case "t6":        
             t6=Float.parseFloat(valor1)- Float.parseFloat(valor2);
                 break;
         case "t7":        
             t7=Float.parseFloat(valor1)- Float.parseFloat(valor2);
                 break;
         case "t8":        
             t8=Float.parseFloat(valor1)- Float.parseFloat(valor2);
                 break;  
         case "t9":        
             t9=Float.parseFloat(valor1)- Float.parseFloat(valor2);
                 break;        
     }
      
      }
  }
  public void divide(String valor1,String valor2,String temporal){
  if("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1)
              ||"t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)){
          //tx,num
            if(("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1))&&(!("t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)))){
                    switch(valor1){
                        case "t1":
                            switch(temporal){
                                case"t1":
                                    
                                    t1=t1/Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t1/Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t1/Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t1/Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t1/Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t1/Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t1/Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t1/Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t1/Float.parseFloat(valor2);
                                    break;    
                            }break; 
                        case "t2":
                            switch(temporal){
                                case"t1":
                                    t1=t2/Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t2/Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t2/Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t2/Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t2/Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t2/Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t2/Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t2/Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t2/Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t3":
                            switch(temporal){
                                case"t1":
                                    t1=t3/Float.parseFloat(valor2);;
                                    break;
                                case"t2":
                                   t2=t3/Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t3/Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t3/Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t3/Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t3/Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t3/Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t3/Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t3/Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t4":
                            switch(temporal){
                                case"t1":
                                    t1=t4/Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t4/Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t4/Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t4/Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t4/Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t4/Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t4/Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t4/Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t4/Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t5":
                            switch(temporal){
                                case"t1":
                                    t1=t5/Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t5/Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t5/Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t5/Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t5/Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t5/Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t5/Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t5/Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t5/Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t6":
                            switch(temporal){
                                case"t1":
                                    t1=t6/Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t6/Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t6/Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t6/Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t6/Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t6/Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t6/Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t6/Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t6/Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t7":
                           switch(temporal){
                                case"t1":
                                    t1=t7/Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t7/Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t7/Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t7/Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t7/Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t7/Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t7/Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t7/Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t7/Float.parseFloat(valor2);
                                    break;    
                            }break;
                        case "t8":
                     switch(temporal){
                                case"t1":
                                    t1=t8/Float.parseFloat(valor2);
                                    break;
                                case"t2":
                                   t2=t8/Float.parseFloat(valor2);
                                    break;
                                case"t3":
                                   t3=t8/Float.parseFloat(valor2);
                                    break;
                                case"t4":
                                   t4=t8/Float.parseFloat(valor2);
                                    break;
                                case"t5":
                                   t5=t8/Float.parseFloat(valor2);
                                    break;
                                case"t6":
                                   t6=t8/Float.parseFloat(valor2);
                                    break;
                                case"t7":
                                   t7=t8/Float.parseFloat(valor2);
                                    break; 
                                case"t8":
                                   t8=t8/Float.parseFloat(valor2);
                                    break; 
                                case"t9":
                                   t9=t8/Float.parseFloat(valor2);
                                    break;    
                            }break;
                         }
                    }
            //num,tx
            if(!(("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1)))&&(("t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)))){
                    switch(valor2){
                        case "t1":
                            switch(temporal){
                                case"t1":
                                    t1=Float.parseFloat(valor1)/t1;
                                    break;
                                case"t2":
                                   t2=Float.parseFloat(valor1)/t1;
                                    break;
                                case"t3":
                                   t3=Float.parseFloat(valor1)/t1;
                                    break;
                                case"t4":
                                   t4=Float.parseFloat(valor1)/t1;
                                    break;
                                case"t5":
                                   t5=Float.parseFloat(valor1)/t1;
                                    break;
                                case"t6":
                                   t6=Float.parseFloat(valor1)/t1;
                                    break;
                                case"t7":
                                   t7=Float.parseFloat(valor1)/t1;
                                    break; 
                                case"t8":
                                   t8=Float.parseFloat(valor1)/t1;
                                    break; 
                                case"t9":
                                   t9=Float.parseFloat(valor1)/t1;
                                    break;    
                            }break; 
                        case "t2":
                            switch(temporal){
                                case"t1":
                                    t1=Float.parseFloat(valor1)/t2;
                                    break;
                                case"t2":
                                   t2=Float.parseFloat(valor1)/t2;
                                    break;
                                case"t3":
                                   t3=Float.parseFloat(valor1)/t2;
                                    break;
                                case"t4":
                                   t4=Float.parseFloat(valor1)/t2;
                                    break;
                                case"t5":
                                   t5=Float.parseFloat(valor1)/t2;
                                    break;
                                case"t6":
                                   t6=Float.parseFloat(valor1)/t2;
                                    break;
                                case"t7":
                                   t7=Float.parseFloat(valor1)/t2;
                                    break; 
                                case"t8":
                                   t8=Float.parseFloat(valor1)/t2;
                                    break; 
                                case"t9":
                                   t9=Float.parseFloat(valor1)/t2;
                                    break;    
                            }break;
                        case "t3":
                            switch(temporal){
                                case"t1":
                                    t1=Float.parseFloat(valor1)/t3;
                                    break;
                                case"t2":
                                   t2=Float.parseFloat(valor1)/t3;
                                    break;
                                case"t3":
                                   t3=Float.parseFloat(valor1)/t3;
                                    break;
                                case"t4":
                                   t4=Float.parseFloat(valor1)/t3;
                                    break;
                                case"t5":
                                   t5=Float.parseFloat(valor1)/t3;
                                    break;
                                case"t6":
                                   t6=Float.parseFloat(valor1)/t3;
                                    break;
                                case"t7":
                                   t7=Float.parseFloat(valor1)/t3;
                                    break; 
                                case"t8":
                                   t8=Float.parseFloat(valor1)/t3;
                                    break; 
                                case"t9":
                                   t9=Float.parseFloat(valor1)/t3;
                                    break;    
                            }break;
                        case "t4":
                            switch(temporal){
                                case"t1":
                                    t1=Float.parseFloat(valor1)/t4;
                                    break;
                                case"t2":
                                   t2=Float.parseFloat(valor1)/t4;
                                    break;
                                case"t3":
                                   t3=Float.parseFloat(valor1)/t4;
                                    break;
                                case"t4":
                                   t4=Float.parseFloat(valor1)/t4;
                                    break;
                                case"t5":
                                   t5=Float.parseFloat(valor1)/t4;
                                    break;
                                case"t6":
                                   t6=Float.parseFloat(valor1)/t4;
                                    break;
                                case"t7":
                                   t7=Float.parseFloat(valor1)/t4;
                                    break; 
                                case"t8":
                                   t8=Float.parseFloat(valor1)/t4;
                                    break; 
                                case"t9":
                                   t9=Float.parseFloat(valor1)/t4;
                                    break;    
                            }break;
                        case "t5":
                            switch(temporal){
                                case"t1":
                                    t1=Float.parseFloat(valor1)/t5;
                                    break;
                                case"t2":
                                   t2=Float.parseFloat(valor1)/t5;
                                    break;
                                case"t3":
                                   t3=Float.parseFloat(valor1)/t5;
                                    break;
                                case"t4":
                                   t4=Float.parseFloat(valor1)/t5;
                                    break;
                                case"t5":
                                   t5=Float.parseFloat(valor1)/t5;
                                    break;
                                case"t6":
                                   t6=Float.parseFloat(valor1)/t5;
                                    break;
                                case"t7":
                                   t7=Float.parseFloat(valor1)/t5;
                                    break; 
                                case"t8":
                                   t8=Float.parseFloat(valor1)/t5;
                                    break; 
                                case"t9":
                                   t9=Float.parseFloat(valor1)/t5;
                                    break;    
                            }break;
                        case "t6":
                            switch(temporal){
                                case"t1":
                                    t1=Float.parseFloat(valor1)/t6;
                                    break;
                                case"t2":
                                   t2=Float.parseFloat(valor1)/t6;
                                    break;
                                case"t3":
                                   t3=Float.parseFloat(valor1)/t6;
                                    break;
                                case"t4":
                                   t4=Float.parseFloat(valor1)/t6;
                                    break;
                                case"t5":
                                   t5=Float.parseFloat(valor1)/t6;
                                    break;
                                case"t6":
                                   t6=Float.parseFloat(valor1)/t6;
                                    break;
                                case"t7":
                                   t7=Float.parseFloat(valor1)/t6;
                                    break; 
                                case"t8":
                                   t8=Float.parseFloat(valor1)/t6;
                                    break; 
                                case"t9":
                                   t9=Float.parseFloat(valor1)/t6;
                                    break;    
                            }break;
                        case "t7":
                            switch(temporal){
                                case"t1":
                                    t1=Float.parseFloat(valor1)/t7;
                                    break;
                                case"t2":
                                   t2=Float.parseFloat(valor1)/t7;
                                    break;
                                case"t3":
                                   t3=Float.parseFloat(valor1)/t7;
                                    break;
                                case"t4":
                                   t4=Float.parseFloat(valor1)/t7;
                                    break;
                                case"t5":
                                   t5=Float.parseFloat(valor1)/t7;
                                    break;
                                case"t6":
                                   t6=Float.parseFloat(valor1)/t7;
                                    break;
                                case"t7":
                                   t7=Float.parseFloat(valor1)/t7;
                                    break; 
                                case"t8":
                                   t8=Float.parseFloat(valor1)/t7;
                                    break; 
                                case"t9":
                                   t9=Float.parseFloat(valor1)/t7;
                                    break;    
                            }break;
                        case "t8":
                            switch(temporal){
                                case"t1":
                                    t1=Float.parseFloat(valor1)/t8;
                                    break;
                                case"t2":
                                   t2=Float.parseFloat(valor1)/t8;
                                    break;
                                case"t3":
                                   t3=Float.parseFloat(valor1)/t8;
                                    break;
                                case"t4":
                                   t4=Float.parseFloat(valor1)/t8;
                                    break;
                                case"t5":
                                   t5=Float.parseFloat(valor1)/t8;
                                    break;
                                case"t6":
                                   t6=Float.parseFloat(valor1)/t8;
                                    break;
                                case"t7":
                                   t7=Float.parseFloat(valor1)/t8;
                                    break; 
                                case"t8":
                                   t8=Float.parseFloat(valor1)/t8;
                                    break; 
                                case"t9":
                                   t9=Float.parseFloat(valor1)/t8;
                                    break;    
                            }break;
                         }
                
                
                    }
            //tx,tx
            if(("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1))&&(("t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)))){
                    //temporal=valor1*valor2
                switch(valor1){
                    case "t1":
                        switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t1;
                                        break;
                                    case"t2":
                                        t2=t1*t1;
                                        break;
                                    case"t3":
                                        t3=t1*t1;
                                    case"t4":
                                        t4=t1*t1;
                                        break;
                                    case"t5":
                                        t5=t1*t1;
                                        break;
                                    case"t6":
                                        t6=t1*t1;
                                        break;
                                    case"t7":
                                        t7=t1*t1;
                                        break;
                                    case"t8":
                                        t8=t1*t1;
                                        break;
                                    case"t9":
                                        t9=t1*t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t2;
                                        break;
                                    case"t2":
                                        t2=t1*t2;
                                        break;
                                    case"t3":
                                        t3=t1*t2;
                                    case"t4":
                                        t4=t1*t2;
                                        break;
                                    case"t5":
                                        t5=t1*t2;
                                        break;
                                    case"t6":
                                        t6=t1*t2;
                                        break;
                                    case"t7":
                                        t7=t1*t2;
                                        break;
                                    case"t8":
                                        t8=t1*t2;
                                        break;
                                    case"t9":
                                        t9=t1*t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t3;
                                        break;
                                    case"t2":
                                        t2=t1*t3;
                                        break;
                                    case"t3":
                                        t3=t1*t3;
                                    case"t4":
                                        t4=t1*t3;
                                        break;
                                    case"t5":
                                        t5=t1*t3;
                                        break;
                                    case"t6":
                                        t6=t1*t3;
                                        break;
                                    case"t7":
                                        t7=t1*t3;
                                        break;
                                    case"t8":
                                        t8=t1*t3;
                                        break;
                                    case"t9":
                                        t9=t1*t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t4;
                                        break;
                                    case"t2":
                                        t2=t1*t4;
                                        break;
                                    case"t3":
                                        t3=t1*t4;
                                    case"t4":
                                        t4=t1*t4;
                                        break;
                                    case"t5":
                                        t5=t1*t4;
                                        break;
                                    case"t6":
                                        t6=t1*t4;
                                        break;
                                    case"t7":
                                        t7=t1*t4;
                                        break;
                                    case"t8":
                                        t8=t1*t4;
                                        break;
                                    case"t9":
                                        t9=t1*t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t5;
                                        break;
                                    case"t2":
                                        t2=t1*t5;
                                        break;
                                    case"t3":
                                        t3=t1*t5;
                                    case"t4":
                                        t4=t1*t5;
                                        break;
                                    case"t5":
                                        t5=t1*t5;
                                        break;
                                    case"t6":
                                        t6=t1*t5;
                                        break;
                                    case"t7":
                                        t7=t1*t5;
                                        break;
                                    case"t8":
                                        t8=t1*t5;
                                        break;
                                    case"t9":
                                        t9=t1*t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t6;
                                        break;
                                    case"t2":
                                        t2=t1*t6;
                                        break;
                                    case"t3":
                                        t3=t1*t6;
                                    case"t4":
                                        t4=t1*t6;
                                        break;
                                    case"t5":
                                        t5=t1*t6;
                                        break;
                                    case"t6":
                                        t6=t1*t6;
                                        break;
                                    case"t7":
                                        t7=t1*t6;
                                        break;
                                    case"t8":
                                        t8=t1*t6;
                                        break;
                                    case"t9":
                                        t9=t1*t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t7;
                                        break;
                                    case"t2":
                                        t2=t1*t7;
                                        break;
                                    case"t3":
                                        t3=t1*t7;
                                    case"t4":
                                        t4=t1*t7;
                                        break;
                                    case"t5":
                                        t5=t1*t7;
                                        break;
                                    case"t6":
                                        t6=t1*t7;
                                        break;
                                    case"t7":
                                        t7=t1*t7;
                                        break;
                                    case"t8":
                                        t8=t1*t7;
                                        break;
                                    case"t9":
                                        t9=t1*t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t8;
                                        break;
                                    case"t2":
                                        t2=t1*t8;
                                        break;
                                    case"t3":
                                        t3=t1*t8;
                                    case"t4":
                                        t4=t1*t8;
                                        break;
                                    case"t5":
                                        t5=t1*t8;
                                        break;
                                    case"t6":
                                        t6=t1*t8;
                                        break;
                                    case"t7":
                                        t7=t1*t8;
                                        break;
                                    case"t8":
                                        t8=t1*t8;
                                        break;
                                    case"t9":
                                        t9=t1*t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t1*t9;
                                        break;
                                    case"t2":
                                        t2=t1*t9;
                                        break;
                                    case"t3":
                                        t3=t1*t9;
                                    case"t4":
                                        t4=t1*t9;
                                        break;
                                    case"t5":
                                        t5=t1*t9;
                                        break;
                                    case"t6":
                                        t6=t1*t9;
                                        break;
                                    case"t7":
                                        t7=t1*t9;
                                        break;
                                    case"t8":
                                        t8=t1*t9;
                                        break;
                                    case"t9":
                                        t9=t1*t9;
                                        break;
                                } break;
                        }break;
                    case "t2":
                        switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t1;
                                        break;
                                    case"t2":
                                        t2=t2*t1;
                                        break;
                                    case"t3":
                                        t3=t2*t1;
                                    case"t4":
                                        t4=t2*t1;
                                        break;
                                    case"t5":
                                        t5=t2*t1;
                                        break;
                                    case"t6":
                                        t6=t2*t1;
                                        break;
                                    case"t7":
                                        t7=t2*t1;
                                        break;
                                    case"t8":
                                        t8=t2*t1;
                                        break;
                                    case"t9":
                                        t9=t2*t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t2;
                                        break;
                                    case"t2":
                                        t2=t2*t2;
                                        break;
                                    case"t3":
                                        t3=t2*t2;
                                    case"t4":
                                        t4=t2*t2;
                                        break;
                                    case"t5":
                                        t5=t2*t2;
                                        break;
                                    case"t6":
                                        t6=t2*t2;
                                        break;
                                    case"t7":
                                        t7=t2*t2;
                                        break;
                                    case"t8":
                                        t8=t2*t2;
                                        break;
                                    case"t9":
                                        t9=t2*t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t3;
                                        break;
                                    case"t2":
                                        t2=t2*t3;
                                        break;
                                    case"t3":
                                        t3=t2*t3;
                                    case"t4":
                                        t4=t2*t3;
                                        break;
                                    case"t5":
                                        t5=t2*t3;
                                        break;
                                    case"t6":
                                        t6=t2*t3;
                                        break;
                                    case"t7":
                                        t7=t2*t3;
                                        break;
                                    case"t8":
                                        t8=t2*t3;
                                        break;
                                    case"t9":
                                        t9=t2*t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t4;
                                        break;
                                    case"t2":
                                        t2=t2*t4;
                                        break;
                                    case"t3":
                                        t3=t2*t4;
                                    case"t4":
                                        t4=t2*t4;
                                        break;
                                    case"t5":
                                        t5=t2*t4;
                                        break;
                                    case"t6":
                                        t6=t2*t4;
                                        break;
                                    case"t7":
                                        t7=t2*t4;
                                        break;
                                    case"t8":
                                        t8=t2*t4;
                                        break;
                                    case"t9":
                                        t9=t2*t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t5;
                                        break;
                                    case"t2":
                                        t2=t2*t5;
                                        break;
                                    case"t3":
                                        t3=t2*t5;
                                    case"t4":
                                        t4=t2*t5;
                                        break;
                                    case"t5":
                                        t5=t2*t5;
                                        break;
                                    case"t6":
                                        t6=t2*t5;
                                        break;
                                    case"t7":
                                        t7=t2*t5;
                                        break;
                                    case"t8":
                                        t8=t2*t5;
                                        break;
                                    case"t9":
                                        t9=t2*t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t6;
                                        break;
                                    case"t2":
                                        t2=t2*t6;
                                        break;
                                    case"t3":
                                        t3=t2*t6;
                                    case"t4":
                                        t4=t2*t6;
                                        break;
                                    case"t5":
                                        t5=t2*t6;
                                        break;
                                    case"t6":
                                        t6=t2*t6;
                                        break;
                                    case"t7":
                                        t7=t2*t6;
                                        break;
                                    case"t8":
                                        t8=t2*t6;
                                        break;
                                    case"t9":
                                        t9=t2*t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t7;
                                        break;
                                    case"t2":
                                        t2=t2*t7;
                                        break;
                                    case"t3":
                                        t3=t2*t7;
                                    case"t4":
                                        t4=t2*t7;
                                        break;
                                    case"t5":
                                        t5=t2*t7;
                                        break;
                                    case"t6":
                                        t6=t2*t7;
                                        break;
                                    case"t7":
                                        t7=t2*t7;
                                        break;
                                    case"t8":
                                        t8=t2*t7;
                                        break;
                                    case"t9":
                                        t9=t2*t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t8;
                                        break;
                                    case"t2":
                                        t2=t2*t8;
                                        break;
                                    case"t3":
                                        t3=t2*t8;
                                    case"t4":
                                        t4=t2*t8;
                                        break;
                                    case"t5":
                                        t5=t2*t8;
                                        break;
                                    case"t6":
                                        t6=t2*t8;
                                        break;
                                    case"t7":
                                        t7=t2*t8;
                                        break;
                                    case"t8":
                                        t8=t2*t8;
                                        break;
                                    case"t9":
                                        t9=t2*t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t2*t9;
                                        break;
                                    case"t2":
                                        t2=t2*t9;
                                        break;
                                    case"t3":
                                        t3=t2*t9;
                                    case"t4":
                                        t4=t2*t9;
                                        break;
                                    case"t5":
                                        t5=t2*t9;
                                        break;
                                    case"t6":
                                        t6=t2*t9;
                                        break;
                                    case"t7":
                                        t7=t2*t9;
                                        break;
                                    case"t8":
                                        t8=t2*t9;
                                        break;
                                    case"t9":
                                        t9=t2*t9;
                                        break;
                                } break;
                        }break;
                  case"t3":    
                      switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t1;
                                        break;
                                    case"t2":
                                        t2=t3*t1;
                                        break;
                                    case"t3":
                                        t3=t3*t1;
                                    case"t4":
                                        t4=t3*t1;
                                        break;
                                    case"t5":
                                        t5=t3*t1;
                                        break;
                                    case"t6":
                                        t6=t3*t1;
                                        break;
                                    case"t7":
                                        t7=t3*t1;
                                        break;
                                    case"t8":
                                        t8=t3*t1;
                                        break;
                                    case"t9":
                                        t9=t3*t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t2;
                                        break;
                                    case"t2":
                                        t2=t3*t2;
                                        break;
                                    case"t3":
                                        t3=t3*t2;
                                    case"t4":
                                        t4=t3*t2;
                                        break;
                                    case"t5":
                                        t5=t3*t2;
                                        break;
                                    case"t6":
                                        t6=t3*t2;
                                        break;
                                    case"t7":
                                        t7=t3*t2;
                                        break;
                                    case"t8":
                                        t8=t3*t2;
                                        break;
                                    case"t9":
                                        t9=t3*t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t3;
                                        break;
                                    case"t2":
                                        t2=t3*t3;
                                        break;
                                    case"t3":
                                        t3=t3*t3;
                                    case"t4":
                                        t4=t3*t3;
                                        break;
                                    case"t5":
                                        t5=t3*t3;
                                        break;
                                    case"t6":
                                        t6=t3*t3;
                                        break;
                                    case"t7":
                                        t7=t3*t3;
                                        break;
                                    case"t8":
                                        t8=t3*t3;
                                        break;
                                    case"t9":
                                        t9=t3*t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t4;
                                        break;
                                    case"t2":
                                        t2=t3*t4;
                                        break;
                                    case"t3":
                                        t3=t3*t4;
                                    case"t4":
                                        t4=t3*t4;
                                        break;
                                    case"t5":
                                        t5=t3*t4;
                                        break;
                                    case"t6":
                                        t6=t3*t4;
                                        break;
                                    case"t7":
                                        t7=t3*t4;
                                        break;
                                    case"t8":
                                        t8=t3*t4;
                                        break;
                                    case"t9":
                                        t9=t3*t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t5;
                                        break;
                                    case"t2":
                                        t2=t3*t5;
                                        break;
                                    case"t3":
                                        t3=t3*t5;
                                    case"t4":
                                        t4=t3*t5;
                                        break;
                                    case"t5":
                                        t5=t3*t5;
                                        break;
                                    case"t6":
                                        t6=t3*t5;
                                        break;
                                    case"t7":
                                        t7=t3*t5;
                                        break;
                                    case"t8":
                                        t8=t3*t5;
                                        break;
                                    case"t9":
                                        t9=t3*t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t6;
                                        break;
                                    case"t2":
                                        t2=t3*t6;
                                        break;
                                    case"t3":
                                        t3=t3*t6;
                                    case"t4":
                                        t4=t3*t6;
                                        break;
                                    case"t5":
                                        t5=t3*t6;
                                        break;
                                    case"t6":
                                        t6=t3*t6;
                                        break;
                                    case"t7":
                                        t7=t3*t6;
                                        break;
                                    case"t8":
                                        t8=t3*t6;
                                        break;
                                    case"t9":
                                        t9=t3*t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t7;
                                        break;
                                    case"t2":
                                        t2=t3*t7;
                                        break;
                                    case"t3":
                                        t3=t3*t7;
                                    case"t4":
                                        t4=t3*t7;
                                        break;
                                    case"t5":
                                        t5=t3*t7;
                                        break;
                                    case"t6":
                                        t6=t3*t7;
                                        break;
                                    case"t7":
                                        t7=t3*t7;
                                        break;
                                    case"t8":
                                        t8=t3*t7;
                                        break;
                                    case"t9":
                                        t9=t3*t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t8;
                                        break;
                                    case"t2":
                                        t2=t3*t8;
                                        break;
                                    case"t3":
                                        t3=t3*t8;
                                    case"t4":
                                        t4=t3*t8;
                                        break;
                                    case"t5":
                                        t5=t3*t8;
                                        break;
                                    case"t6":
                                        t6=t3*t8;
                                        break;
                                    case"t7":
                                        t7=t3*t8;
                                        break;
                                    case"t8":
                                        t8=t3*t8;
                                        break;
                                    case"t9":
                                        t9=t3*t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t3*t9;
                                        break;
                                    case"t2":
                                        t2=t3*t9;
                                        break;
                                    case"t3":
                                        t3=t3*t9;
                                    case"t4":
                                        t4=t3*t9;
                                        break;
                                    case"t5":
                                        t5=t3*t9;
                                        break;
                                    case"t6":
                                        t6=t3*t9;
                                        break;
                                    case"t7":
                                        t7=t3*t9;
                                        break;
                                    case"t8":
                                        t8=t3*t9;
                                        break;
                                    case"t9":
                                        t9=t3*t9;
                                        break;
                                } break;
                        }break;
              case"t4":
                  switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t1;
                                        break;
                                    case"t2":
                                        t2=t4*t1;
                                        break;
                                    case"t3":
                                        t3=t4*t1;
                                    case"t4":
                                        t4=t4*t1;
                                        break;
                                    case"t5":
                                        t5=t4*t1;
                                        break;
                                    case"t6":
                                        t6=t4*t1;
                                        break;
                                    case"t7":
                                        t7=t4*t1;
                                        break;
                                    case"t8":
                                        t8=t4*t1;
                                        break;
                                    case"t9":
                                        t9=t4*t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t2;
                                        break;
                                    case"t2":
                                        t2=t4*t2;
                                        break;
                                    case"t3":
                                        t3=t4*t2;
                                    case"t4":
                                        t4=t4*t2;
                                        break;
                                    case"t5":
                                        t5=t4*t2;
                                        break;
                                    case"t6":
                                        t6=t4*t2;
                                        break;
                                    case"t7":
                                        t7=t4*t2;
                                        break;
                                    case"t8":
                                        t8=t4*t2;
                                        break;
                                    case"t9":
                                        t9=t4*t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t3;
                                        break;
                                    case"t2":
                                        t2=t4*t3;
                                        break;
                                    case"t3":
                                        t3=t4*t3;
                                    case"t4":
                                        t4=t4*t3;
                                        break;
                                    case"t5":
                                        t5=t4*t3;
                                        break;
                                    case"t6":
                                        t6=t4*t3;
                                        break;
                                    case"t7":
                                        t7=t4*t3;
                                        break;
                                    case"t8":
                                        t8=t4*t3;
                                        break;
                                    case"t9":
                                        t9=t4*t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t4;
                                        break;
                                    case"t2":
                                        t2=t4*t4;
                                        break;
                                    case"t3":
                                        t3=t4*t4;
                                    case"t4":
                                        t4=t4*t4;
                                        break;
                                    case"t5":
                                        t5=t4*t4;
                                        break;
                                    case"t6":
                                        t6=t4*t4;
                                        break;
                                    case"t7":
                                        t7=t4*t4;
                                        break;
                                    case"t8":
                                        t8=t4*t4;
                                        break;
                                    case"t9":
                                        t9=t4*t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t5;
                                        break;
                                    case"t2":
                                        t2=t4*t5;
                                        break;
                                    case"t3":
                                        t3=t4*t5;
                                    case"t4":
                                        t4=t4*t5;
                                        break;
                                    case"t5":
                                        t5=t4*t5;
                                        break;
                                    case"t6":
                                        t6=t4*t5;
                                        break;
                                    case"t7":
                                        t7=t4*t5;
                                        break;
                                    case"t8":
                                        t8=t4*t5;
                                        break;
                                    case"t9":
                                        t9=t4*t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t6;
                                        break;
                                    case"t2":
                                        t2=t4*t6;
                                        break;
                                    case"t3":
                                        t3=t4*t6;
                                    case"t4":
                                        t4=t4*t6;
                                        break;
                                    case"t5":
                                        t5=t4*t6;
                                        break;
                                    case"t6":
                                        t6=t4*t6;
                                        break;
                                    case"t7":
                                        t7=t4*t6;
                                        break;
                                    case"t8":
                                        t8=t4*t6;
                                        break;
                                    case"t9":
                                        t9=t4*t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t7;
                                        break;
                                    case"t2":
                                        t2=t4*t7;
                                        break;
                                    case"t3":
                                        t3=t4*t7;
                                    case"t4":
                                        t4=t4*t7;
                                        break;
                                    case"t5":
                                        t5=t4*t7;
                                        break;
                                    case"t6":
                                        t6=t4*t7;
                                        break;
                                    case"t7":
                                        t7=t4*t7;
                                        break;
                                    case"t8":
                                        t8=t4*t7;
                                        break;
                                    case"t9":
                                        t9=t4*t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t8;
                                        break;
                                    case"t2":
                                        t2=t4*t8;
                                        break;
                                    case"t3":
                                        t3=t4*t8;
                                    case"t4":
                                        t4=t4*t8;
                                        break;
                                    case"t5":
                                        t5=t4*t8;
                                        break;
                                    case"t6":
                                        t6=t4*t8;
                                        break;
                                    case"t7":
                                        t7=t4*t8;
                                        break;
                                    case"t8":
                                        t8=t4*t8;
                                        break;
                                    case"t9":
                                        t9=t4*t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t4*t9;
                                        break;
                                    case"t2":
                                        t2=t4*t9;
                                        break;
                                    case"t3":
                                        t3=t4*t9;
                                    case"t4":
                                        t4=t4*t9;
                                        break;
                                    case"t5":
                                        t5=t4*t9;
                                        break;
                                    case"t6":
                                        t6=t4*t9;
                                        break;
                                    case"t7":
                                        t7=t4*t9;
                                        break;
                                    case"t8":
                                        t8=t4*t9;
                                        break;
                                    case"t9":
                                        t9=t4*t9;
                                        break;
                                } break;
                        }break;
                      
              case"t5":
                  switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t1;
                                        break;
                                    case"t2":
                                        t2=t5*t1;
                                        break;
                                    case"t3":
                                        t3=t5*t1;
                                    case"t4":
                                        t4=t5*t1;
                                        break;
                                    case"t5":
                                        t5=t5*t1;
                                        break;
                                    case"t6":
                                        t6=t5*t1;
                                        break;
                                    case"t7":
                                        t7=t5*t1;
                                        break;
                                    case"t8":
                                        t8=t5*t1;
                                        break;
                                    case"t9":
                                        t9=t5*t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t2;
                                        break;
                                    case"t2":
                                        t2=t5*t2;
                                        break;
                                    case"t3":
                                        t3=t5*t2;
                                    case"t4":
                                        t4=t5*t2;
                                        break;
                                    case"t5":
                                        t5=t5*t2;
                                        break;
                                    case"t6":
                                        t6=t5*t2;
                                        break;
                                    case"t7":
                                        t7=t5*t2;
                                        break;
                                    case"t8":
                                        t8=t5*t2;
                                        break;
                                    case"t9":
                                        t9=t5*t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t3;
                                        break;
                                    case"t2":
                                        t2=t5*t3;
                                        break;
                                    case"t3":
                                        t3=t5*t3;
                                    case"t4":
                                        t4=t5*t3;
                                        break;
                                    case"t5":
                                        t5=t5*t3;
                                        break;
                                    case"t6":
                                        t6=t5*t3;
                                        break;
                                    case"t7":
                                        t7=t5*t3;
                                        break;
                                    case"t8":
                                        t8=t5*t3;
                                        break;
                                    case"t9":
                                        t9=t5*t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t4;
                                        break;
                                    case"t2":
                                        t2=t5*t4;
                                        break;
                                    case"t3":
                                        t3=t5*t4;
                                    case"t4":
                                        t4=t5*t4;
                                        break;
                                    case"t5":
                                        t5=t5*t4;
                                        break;
                                    case"t6":
                                        t6=t5*t4;
                                        break;
                                    case"t7":
                                        t7=t5*t4;
                                        break;
                                    case"t8":
                                        t8=t5*t4;
                                        break;
                                    case"t9":
                                        t9=t5*t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t5;
                                        break;
                                    case"t2":
                                        t2=t5*t5;
                                        break;
                                    case"t3":
                                        t3=t5*t5;
                                    case"t4":
                                        t4=t5*t5;
                                        break;
                                    case"t5":
                                        t5=t5*t5;
                                        break;
                                    case"t6":
                                        t6=t5*t5;
                                        break;
                                    case"t7":
                                        t7=t5*t5;
                                        break;
                                    case"t8":
                                        t8=t5*t5;
                                        break;
                                    case"t9":
                                        t9=t5*t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t6;
                                        break;
                                    case"t2":
                                        t2=t5*t6;
                                        break;
                                    case"t3":
                                        t3=t5*t6;
                                    case"t4":
                                        t4=t5*t6;
                                        break;
                                    case"t5":
                                        t5=t5*t6;
                                        break;
                                    case"t6":
                                        t6=t5*t6;
                                        break;
                                    case"t7":
                                        t7=t5*t6;
                                        break;
                                    case"t8":
                                        t8=t5*t6;
                                        break;
                                    case"t9":
                                        t9=t5*t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t7;
                                        break;
                                    case"t2":
                                        t2=t5*t7;
                                        break;
                                    case"t3":
                                        t3=t5*t7;
                                    case"t4":
                                        t4=t5*t7;
                                        break;
                                    case"t5":
                                        t5=t5*t7;
                                        break;
                                    case"t6":
                                        t6=t5*t7;
                                        break;
                                    case"t7":
                                        t7=t5*t7;
                                        break;
                                    case"t8":
                                        t8=t5*t7;
                                        break;
                                    case"t9":
                                        t9=t5*t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t8;
                                        break;
                                    case"t2":
                                        t2=t5*t8;
                                        break;
                                    case"t3":
                                        t3=t5*t8;
                                    case"t4":
                                        t4=t5*t8;
                                        break;
                                    case"t5":
                                        t5=t5*t8;
                                        break;
                                    case"t6":
                                        t6=t5*t8;
                                        break;
                                    case"t7":
                                        t7=t5*t8;
                                        break;
                                    case"t8":
                                        t8=t5*t8;
                                        break;
                                    case"t9":
                                        t9=t5*t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t5*t9;
                                        break;
                                    case"t2":
                                        t2=t5*t9;
                                        break;
                                    case"t3":
                                        t3=t5*t9;
                                    case"t4":
                                        t4=t5*t9;
                                        break;
                                    case"t5":
                                        t5=t5*t9;
                                        break;
                                    case"t6":
                                        t6=t5*t9;
                                        break;
                                    case"t7":
                                        t7=t5*t9;
                                        break;
                                    case"t8":
                                        t8=t5*t9;
                                        break;
                                    case"t9":
                                        t9=t5*t9;
                                        break;
                                } break;
                        }break;
            case"t6":
                switch(valor2){
                            case"t1":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t1;
                                        break;
                                    case"t2":
                                        t2=t6*t1;
                                        break;
                                    case"t3":
                                        t3=t6*t1;
                                    case"t4":
                                        t4=t6*t1;
                                        break;
                                    case"t5":
                                        t5=t6*t1;
                                        break;
                                    case"t6":
                                        t6=t6*t1;
                                        break;
                                    case"t7":
                                        t7=t6*t1;
                                        break;
                                    case"t8":
                                        t8=t6*t1;
                                        break;
                                    case"t9":
                                        t9=t6*t1;
                                        break;
                                } break;
                            case "t2":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t2;
                                        break;
                                    case"t2":
                                        t2=t6*t2;
                                        break;
                                    case"t3":
                                        t3=t6*t2;
                                    case"t4":
                                        t4=t6*t2;
                                        break;
                                    case"t5":
                                        t5=t6*t2;
                                        break;
                                    case"t6":
                                        t6=t6*t2;
                                        break;
                                    case"t7":
                                        t7=t6*t2;
                                        break;
                                    case"t8":
                                        t8=t6*t2;
                                        break;
                                    case"t9":
                                        t9=t6*t2;
                                        break;
                                } break;
                            case"t3":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t3;
                                        break;
                                    case"t2":
                                        t2=t6*t3;
                                        break;
                                    case"t3":
                                        t3=t6*t3;
                                    case"t4":
                                        t4=t6*t3;
                                        break;
                                    case"t5":
                                        t5=t6*t3;
                                        break;
                                    case"t6":
                                        t6=t6*t3;
                                        break;
                                    case"t7":
                                        t7=t6*t3;
                                        break;
                                    case"t8":
                                        t8=t6*t3;
                                        break;
                                    case"t9":
                                        t9=t6*t3;
                                        break;
                                } break;
                            case"t4":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t4;
                                        break;
                                    case"t2":
                                        t2=t6*t4;
                                        break;
                                    case"t3":
                                        t3=t6*t4;
                                    case"t4":
                                        t4=t6*t4;
                                        break;
                                    case"t5":
                                        t5=t6*t4;
                                        break;
                                    case"t6":
                                        t6=t6*t4;
                                        break;
                                    case"t7":
                                        t7=t6*t4;
                                        break;
                                    case"t8":
                                        t8=t6*t4;
                                        break;
                                    case"t9":
                                        t9=t6*t4;
                                        break;
                                } break;
                            case"t5":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t5;
                                        break;
                                    case"t2":
                                        t2=t6*t5;
                                        break;
                                    case"t3":
                                        t3=t6*t5;
                                    case"t4":
                                        t4=t6*t5;
                                        break;
                                    case"t5":
                                        t5=t6*t5;
                                        break;
                                    case"t6":
                                        t6=t6*t5;
                                        break;
                                    case"t7":
                                        t7=t6*t5;
                                        break;
                                    case"t8":
                                        t8=t6*t5;
                                        break;
                                    case"t9":
                                        t9=t6*t5;
                                        break;
                                } break;
                            case"t6":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t6;
                                        break;
                                    case"t2":
                                        t2=t6*t6;
                                        break;
                                    case"t3":
                                        t3=t6*t6;
                                    case"t4":
                                        t4=t6*t6;
                                        break;
                                    case"t5":
                                        t5=t6*t6;
                                        break;
                                    case"t6":
                                        t6=t6*t6;
                                        break;
                                    case"t7":
                                        t7=t6*t6;
                                        break;
                                    case"t8":
                                        t8=t6*t6;
                                        break;
                                    case"t9":
                                        t9=t6*t6;
                                        break;
                                } break;
                            case"t7":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t7;
                                        break;
                                    case"t2":
                                        t2=t6*t7;
                                        break;
                                    case"t3":
                                        t3=t6*t7;
                                    case"t4":
                                        t4=t6*t7;
                                        break;
                                    case"t5":
                                        t5=t6*t7;
                                        break;
                                    case"t6":
                                        t6=t6*t7;
                                        break;
                                    case"t7":
                                        t7=t6*t7;
                                        break;
                                    case"t8":
                                        t8=t6*t7;
                                        break;
                                    case"t9":
                                        t9=t6*t7;
                                        break;
                                } break;
                            case"t8":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t8;
                                        break;
                                    case"t2":
                                        t2=t6*t8;
                                        break;
                                    case"t3":
                                        t3=t6*t8;
                                    case"t4":
                                        t4=t6*t8;
                                        break;
                                    case"t5":
                                        t5=t6*t8;
                                        break;
                                    case"t6":
                                        t6=t6*t8;
                                        break;
                                    case"t7":
                                        t7=t6*t8;
                                        break;
                                    case"t8":
                                        t8=t6*t8;
                                        break;
                                    case"t9":
                                        t9=t6/t8;
                                        break;
                                } break;
                            case"t9":
                                switch(temporal){
                                    case"t1":
                                        t1=t6*t9;
                                        break;
                                    case"t2":
                                        t2=t6*t9;
                                        break;
                                    case"t3":
                                        t3=t6*t9;
                                    case"t4":
                                        t4=t6*t9;
                                        break;
                                    case"t5":
                                        t5=t6*t9;
                                        break;
                                    case"t6":
                                        t6=t6*t9;
                                        break;
                                    case"t7":
                                        t7=t6/t9;
                                        break;
                                    case"t8":
                                        t8=t6/t9;
                                        break;
                                    case"t9":
                                        t9=t6*t9;
                                        break;
                                } break;
                        }break;
                      
                      
                      
                
                }
                
                    }
      
      }else{
          switch(temporal){
         case "t1":
                t1= Float.parseFloat(valor1)/ Float.parseFloat(valor2);
                
                break; 
         case "t2":
                t2=Float.parseFloat(valor1)/ Float.parseFloat(valor2);
                 break; 
         case "t3":        
             t3=Float.parseFloat(valor1)/ Float.parseFloat(valor2);
                 break; 
         case "t4":        
             t4=Float.parseFloat(valor1)/ Float.parseFloat(valor2);
                 break;
         case "t5":        
             t5=Float.parseFloat(valor1)/ Float.parseFloat(valor2);
                 break;
         case "t6":        
             t6=Float.parseFloat(valor1)/ Float.parseFloat(valor2);
                 break;
         case "t7":        
             t7=Float.parseFloat(valor1)/ Float.parseFloat(valor2);
                 break;
         case "t8":        
             t8=Float.parseFloat(valor1)/ Float.parseFloat(valor2);
                 break;  
         case "t9":        
             t9=Float.parseFloat(valor1)/ Float.parseFloat(valor2);
                 break;        
     }
      
      }
  
  }
 //tabla..................
  
  ///
 public void ultima_final(String valor1,String valor2,String temporal){
     
    //tx,num
     if(("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1))&&(!("t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)))){
     switch(valor1){
            case"t1":
                n1=t1;
                n2=Float.parseFloat(valor2);
                break;
            case"t2":
                n1=t2;
                n2=Float.parseFloat(valor2);
                break;
            case"t3":
                n1=t3;
                n2=Float.parseFloat(valor2);
                break;
            case"t4":
                n1=t4;
                n2=Float.parseFloat(valor2);
                break;
            case"t5":
                n1=t5;
                n2=Float.parseFloat(valor2);
                break;
            case"t6":
                n1=t6;
                n2=Float.parseFloat(valor2);
                break;
            case"t7":
                n1=t7;
                n2=Float.parseFloat(valor2);
                break;
            case"t8":
                n1=t8;
                n2=Float.parseFloat(valor2);
                break;
     
     }
     
     }
     //num+tx
     if(!("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1))&&(("t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)))){
     switch(valor2){
            case"t1":
                n2=t1;
                n1=Float.parseFloat(valor1);
                break;
            case"t2":
                n2=t2;
                n1=Float.parseFloat(valor1);
                break;
            case"t3":
                n2=t3;
                n1=Float.parseFloat(valor1);
                break;
            case"t4":
                n2=t4;
                n1=Float.parseFloat(valor1);
                break;
            case"t5":
                n2=t5;
                n1=Float.parseFloat(valor1);
                break;
            case"t6":
                n2=t6;
                n1=Float.parseFloat(valor1);
                break;
            case"t7":
                n2=t7;
                n1=Float.parseFloat(valor1);
                break;
            case"t8":
                n2=t8;
                n1=Float.parseFloat(valor1);
                break;
     
     }
     
     }
     
 //num+num
     if(!("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1))&&(!("t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)))){
         n1=Float.parseFloat(valor1);
         
         n2=Float.parseFloat(valor2);
         
     
     }
     
 //tx+tx    
 
     if(("t1".equals(valor1)||"t2".equals(valor1)||"t3".equals(valor1)||"t4".equals(valor1)||"t5".equals(valor1)||"t6".equals(valor1)||"t7".equals(valor1)||"t8".equals(valor1))&&(("t1".equals(valor2)||"t2".equals(valor2)||"t3".equals(valor2)||"t4".equals(valor2)||"t5".equals(valor2)||"t6".equals(valor2)||"t7".equals(valor2)||"t8".equals(valor2)))){
     switch(valor1){
            case"t1":
                switch(valor2){
                     case"t1":
                         n1=t1;
                         n2=t1;
                        break;
                     case"t2":
                         n1=t1;
                         n2=t2;
                        break;
                     case"t3":
                         n1=t1;
                         n2=t3;
                        break;
                     case"t4":
                         n1=t1;
                         n2=t4;
                        break;
                     case"t5":
                         n1=t1;
                         n2=t5;
                        break;
                     case"t6":
                         n1=t1;
                         n2=t6;
                        break;
                     case"t7":
                         n1=t1;
                         n2=t7;
                        break;
                     case"t8":
                         n1=t1;
                         n2=t8;
                        break;
                }
                break;
            case"t2":
                switch(valor2){
                     case"t1":
                         n1=t2;
                         n2=t1;
                        break;
                     case"t2":
                         n1=t2;
                         n2=t2;
                        break;
                     case"t3":
                         n1=t2;
                         n2=t3;
                        break;
                     case"t4":
                         n1=t2;
                         n2=t4;
                        break;
                     case"t5":
                         n1=t2;
                         n2=t5;
                        break;
                     case"t6":
                         n1=t2;
                         n2=t6;
                        break;
                     case"t7":
                         n1=t2;
                         n2=t7;
                        break;
                     case"t8":
                         n1=t2;
                         n2=t8;
                        break;
                }
                break;
            case"t3":
                switch(valor2){
                     case"t1":
                         n1=t3;
                         n2=t1;
                        break;
                     case"t2":
                         n1=t3;
                         n2=t2;
                        break;
                     case"t3":
                         n1=t3;
                         n2=t3;
                        break;
                     case"t4":
                         n1=t3;
                         n2=t4;
                        break;
                     case"t5":
                         n1=t3;
                         n2=t5;
                        break;
                     case"t6":
                         n1=t3;
                         n2=t6;
                        break;
                     case"t7":
                         n1=t3;
                         n2=t7;
                        break;
                     case"t8":
                         n1=t3;
                         n2=t8;
                        break;
                }
                break;
            case"t4":
                switch(valor2){
                     case"t1":
                         n1=t4;
                         n2=t1;
                        break;
                     case"t2":
                         n1=t4;
                         n2=t2;
                        break;
                     case"t3":
                         n1=t4;
                         n2=t3;
                        break;
                     case"t4":
                         n1=t4;
                         n2=t4;
                        break;
                     case"t5":
                         n1=t4;
                         n2=t5;
                        break;
                     case"t6":
                         n1=t4;
                         n2=t6;
                        break;
                     case"t7":
                         n1=t4;
                         n2=t7;
                        break;
                     case"t8":
                         n1=t4;
                         n2=t8;
                        break;
                }
                break;
            case"t5":
                switch(valor2){
                     case"t1":
                         n1=t5;
                         n2=t1;
                        break;
                     case"t2":
                         n1=t5;
                         n2=t2;
                        break;
                     case"t3":
                         n1=t5;
                         n2=t3;
                        break;
                     case"t4":
                         n1=t5;
                         n2=t4;
                        break;
                     case"t5":
                         n1=t5;
                         n2=t5;
                        break;
                     case"t6":
                         n1=t5;
                         n2=t6;
                        break;
                     case"t7":
                         n1=t5;
                         n2=t7;
                        break;
                     case"t8":
                         n1=t5;
                         n2=t8;
                        break;
                }
                break;
            case"t6":
                switch(valor2){
                     case"t1":
                         n1=t6;
                         n2=t1;
                        break;
                     case"t2":
                         n1=t6;
                         n2=t2;
                        break;
                     case"t3":
                         n1=t6;
                         n2=t3;
                        break;
                     case"t4":
                         n1=t6;
                         n2=t4;
                        break;
                     case"t5":
                         n1=t6;
                         n2=t5;
                        break;
                     case"t6":
                         n1=t6;
                         n2=t6;
                        break;
                     case"t7":
                         n1=t6;
                         n2=t7;
                        break;
                     case"t8":
                         n1=t6;
                         n2=t8;
                        break;
                }
                break;
            case"t7":
                switch(valor2){
                     case"t1":
                         n1=t7;
                         n2=t1;
                        break;
                     case"t2":
                         n1=t7;
                         n2=t2;
                        break;
                     case"t3":
                         n1=t7;
                         n2=t3;
                        break;
                     case"t4":
                         n1=t7;
                         n2=t4;
                        break;
                     case"t5":
                         n1=t7;
                         n2=t5;
                        break;
                     case"t6":
                         n1=t7;
                         n2=t6;
                        break;
                     case"t7":
                         n1=t7;
                         n2=t7;
                        break;
                     case"t8":
                         n1=t7;
                         n2=t8;
                        break;
                }
                break;
            case"t8":
                switch(valor2){
                     case"t1":
                         n1=t8;
                         n2=t1;
                        break;
                     case"t2":
                         n1=t8;
                         n2=t2;
                        break;
                     case"t3":
                         n1=t8;
                         n2=t3;
                        break;
                     case"t4":
                         n1=t8;
                         n2=t4;
                        break;
                     case"t5":
                         n1=t8;
                         n2=t5;
                        break;
                     case"t6":
                         n1=t8;
                         n2=t6;
                        break;
                     case"t7":
                         n1=t8;
                         n2=t7;
                        break;
                     case"t8":
                         n1=t8;
                         n2=t8;
                        break;
                }
                break;
     }
 }
 }
 
  //7
  public void es_entero(float numero){
    if (isNaN(numero)){
        System.out.println("Ups... " + numero + " no es un número.");
    } else {
        if (numero % 1 == 0) {
           
        } else {
           decimal=true;
        }
    }
}
  public void es_decimal(){
      es_entero(t1);
      es_entero(t2);
      es_entero(t3);
      es_entero(t4);
      es_entero(t5);
      es_entero(t6);
      es_entero(t7);
      es_entero(t8);
      es_entero(t9);
      if(n2<0||n1<0){
          decimal = true;
      }
  }
  public float ultimot(){
      float salida=0;
      if(t9==0){
          salida=t8;
      }
      if(t9!=0){
          salida=t9;
      }
      if(t8==0){
          salida=t7;
      }
      if(t7==0){
          salida=t6;
      }
      if(t6==0){
          salida=t5;
      }
      if(t5==0){
          salida=t4;
      }
      if(t4==0){
          salida=t3;
      }
      if(t3==0){
          salida=t2;
      }
      if(t2==0){
          salida=t1;
      }
      
      
      return salida;
  }
  public void analizarLexico() throws IOException{
        
         DefaultTableModel modelo;
          DefaultTableModel tabla2;
          DefaultTableModel tabla_tem;
          DefaultTableModel tabla_p;
        tabla_p=new DefaultTableModel();    
        modelo = new DefaultTableModel();
        tabla2 = new DefaultTableModel();
        tabla_tem = new DefaultTableModel();
        
        tabla_tem.addColumn("operacion");
        tabla_tem.addColumn("numero 1");
        tabla_tem.addColumn("Numero 2");
        tabla_tem.addColumn("temporal");
        
        modelo.addColumn("Lexema");
        modelo.addColumn("Token");
        modelo.addColumn("Ind");
        
        tabla_p.addColumn("Lexema");
        tabla_p.addColumn("Token");
        tabla_p.addColumn("Ind");
        
        tabla2.addColumn("Lexema");
        tabla2.addColumn("Token");
        tabla2.addColumn("Ind");
        
        this.tabla_de_si.setModel(modelo);
        this.tabla_para_borrar.setModel(tabla2);
        this.t_temporales.setModel(tabla_tem);
        this.tabla_parentesis.setModel(tabla_p);
        //fin tabla
        int ind_num=0,ind_id=101,ind_op=201;
        String ind_num1,ind_id1,ind_op1;
        int cont = 1;
        
        
        
        String expr = (String) txtResultado.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        int tam_cad = expr.length();
        while (tam_cad>0) {
            Tokens token = lexer.yylex();
            if (token == null) {
                //txtAnalizarLex.setText(resultado);
                return;
            }
            switch (token) {
                case Linea:
                    cont++;
                    resultado += "LINEA " + cont + "\n";
                    break;
                case Suma:
                    resultado += "  <Operador_sum>\t" + lexer.lexeme + "\n";
                    
                    String[]t1={lexer.lexeme,"suma",ind_op+""};
                    modelo.addRow(t1);
                    tabla2.addRow(t1);
                    ind_op++;
                    break;
                
                case numero:
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    String[]t7={lexer.lexeme,"Num",ind_num+""};
                    modelo.addRow(t7);
                    tabla2.addRow(t7);
                    ind_num++;
                    break;
                case Multiplicacion:
                    resultado += "  <Operador multiplicacion>\t" + lexer.lexeme + "\n";
                    String[]t3={lexer.lexeme,"mul",ind_op+""};
                    modelo.addRow(t3);
                    tabla2.addRow(t3);
                    ind_op++;
                    break;
                case Division:
                    resultado += "  <Operador division>\t" + lexer.lexeme + "\n";
                    String[]t4={lexer.lexeme,"div",ind_op+""};
                    modelo.addRow(t4);
                    tabla2.addRow(t4);
                    ind_op++;
                    break;
 
                case Parentesis_a:
                    resultado += "  <Parentesis de apertura>\t" + lexer.lexeme + "\n";
                    String[]t5={lexer.lexeme,"P_A","na"};
                    modelo.addRow(t5);
                    tabla2.addRow(t5);
                    break;
                case Parentesis_c:
                    resultado += "  <Parentesis de cierre>\t" + lexer.lexeme + "\n";
                    String[]t6={lexer.lexeme,"P_C","na"};
                    modelo.addRow(t6);
                    tabla2.addRow(t6);
                    break;
               
                case Resta:
                    resultado += "  <Operador resta>\t" + lexer.lexeme + "\n";
                    String[]t22={lexer.lexeme,"resta",ind_op+""};
                    modelo.addRow(t22);
                    tabla2.addRow(t22);
                    ind_op++;
                    break;
                case Id:  
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    resultado = JOptionPane.showInputDialog("Introduzca un valor para",lexer.lexeme);
                    String[]t8={resultado,"Id",ind_id+""};
                    modelo.addRow(t8);
                    tabla2.addRow(t8);
                    ind_id++;
                    break;
                case ERROR:
                    resultado += "  <Simbolo no definido>\n";
                    break;
                case Numero_dec:
                    resultado += "  <Numero_dec>\t\t" + lexer.lexeme + "\n";
                    String[]t9={lexer.lexeme,"num_dec","nada"};
                    modelo.addRow(t9);
                    tabla2.addRow(t9);
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;
            }
            
            tam_cad=tam_cad-lexer.lexeme.length();
      
        }
        
            
            //writer.println("MOV AL,09H");
        int pa=0,pc=0;
        int vart=1;
      int filas =tabla2.getRowCount();
      for(int i=0;filas>i;i++){
           String p_a="";
           String num="";
           String lexema1 =tabla2.getValueAt(i, 1)+""; //(fila,columna)
           if(i>0&&filas>(i+1)){
            p_a=tabla2.getValueAt(i-1, 1)+"";
            num=tabla2.getValueAt(i+1, 1)+"";}
           if("resta".equals(lexema1)&&"P_A".equals(p_a)&&"Num".equals(num)){
               String aux=tabla2.getValueAt(i+1, 0)+"";
               tabla2.setValueAt("-"+aux, i+1, 0);
               tabla2.removeRow(i);
               i=-1;
           }
           filas=tabla2.getRowCount();
       }
       for(int i=0;filas>i;i++){
           
           String lexema1 =tabla2.getValueAt(i, 1)+""; //(fila,columna)  
            
           if("P_A".equals(lexema1)){
               pa=i;
           }
           if("P_C".equals(lexema1)){
               pc=i;
           }
       }
       if(pc!=0){
           
             for(int i=pa+1;pa<i&&i<pc;i++){
                 String []agrega={tabla2.getValueAt(i, 0)+"",tabla2.getValueAt(i, 1)+"",tabla2.getValueAt(i, 2)+""};
                 tabla_p.addRow(agrega);
             } 
            
             int filas_t_P=tabla_p.getRowCount();
             int cuanto_borro=filas_t_P;
             for(int i=0;filas_t_P>i;i++){
                 String lexema_p=tabla_p.getValueAt(i, 1)+"";
                 if("mul".equals(lexema_p)||"div".equals(lexema_p)){
                     String[]t={tabla_p.getValueAt(i, 1)+"",tabla_p.getValueAt(i-1, 0)+"",tabla_p.getValueAt(i+1, 0)+"","t"+vart};
                     tabla_tem.addRow(t);
                     tabla_p.setValueAt("t"+vart, i, 0);
                     tabla_p.setValueAt(null, i, 1);
                      vart++;
                     tabla_p.removeRow(i-1);
                     tabla_p.removeRow(i);
                     i=0;
                 }
                 filas_t_P =tabla_p.getRowCount();
                 
             }
        //.....................................
        //for paera la suma y resta     
       filas_t_P =tabla_p.getRowCount();
       
       for(int i=0;filas_t_P>i;i++){
           String lexema1_p =tabla_p.getValueAt(i, 1)+""; //(fila,columna)  
    
      if("suma".equals(lexema1_p)||"resta".equals(lexema1_p)){
          String[]t={tabla_p.getValueAt(i, 1)+"",tabla_p.getValueAt(i-1, 0)+"",tabla_p.getValueAt(i+1, 0)+"","t"+vart};
          tabla_tem.addRow(t);
              
              tabla_p.setValueAt("t"+vart, i, 0);
              tabla_p.setValueAt(null, i, 1);
              vart++;
              tabla_p.removeRow(i-1);
              tabla_p.removeRow(i);
              i=0;
      }
           filas_t_P=tabla_p.getRowCount();
           

       
       }
      
       for(int i=cuanto_borro;i>0;i--){
                 tabla2.removeRow(pa+1);
             }
       filas =tabla2.getRowCount();
       for(int i=0;filas>i;i++){
           
           String lexema1 =tabla2.getValueAt(i, 1)+""; //(fila,columna)  
            
           if("P_A".equals(lexema1)){
               pa=i;
           }
           if("P_C".equals(lexema1)){
               pc=i;
           }
       }
       int tama_t_tem=tabla_tem.getColumnCount();
       
       tabla2.setValueAt("t"+(vart-1), pc, 0);
       tabla2.setValueAt("num", pc, 1);
       tabla2.removeRow(pa);
       tabla_p.removeRow(0);
       } 
       
       //final parentesis
      //---------------------------------------------------------
       pc=0;pa=0;
       filas =tabla2.getRowCount();
       for(int i=0;filas>i;i++){
           
           String lexema1 =tabla2.getValueAt(i, 1)+""; //(fila,columna)  
            
           if("P_A".equals(lexema1)){
               pa=i;
           }
           if("P_C".equals(lexema1)){
               pc=i;
           }
       }
       if(pc!=0){
           
             for(int i=pa+1;pa<i&&i<pc;i++){
                 String []agrega={tabla2.getValueAt(i, 0)+"",tabla2.getValueAt(i, 1)+"",tabla2.getValueAt(i, 2)+""};
                 tabla_p.addRow(agrega);
             } 
            
             int filas_t_P=tabla_p.getRowCount();
             int cuanto_borro=filas_t_P;
             for(int i=0;filas_t_P>i;i++){
                 String lexema_p=tabla_p.getValueAt(i, 1)+"";
                 if("mul".equals(lexema_p)||"div".equals(lexema_p)){
                     String[]t={tabla_p.getValueAt(i, 1)+"",tabla_p.getValueAt(i-1, 0)+"",tabla_p.getValueAt(i+1, 0)+"","t"+vart};
                     tabla_tem.addRow(t);
                     tabla_p.setValueAt("t"+vart, i, 0);
                     tabla_p.setValueAt(null, i, 1);
                      vart++;
                     tabla_p.removeRow(i-1);
                     tabla_p.removeRow(i);
                     i=0;
                 }
                 filas_t_P =tabla_p.getRowCount();
                 
             }
        //.....................................
        //for paera la suma y resta     
       filas_t_P =tabla_p.getRowCount();
       
       for(int i=0;filas_t_P>i;i++){
           String lexema1_p =tabla_p.getValueAt(i, 1)+""; //(fila,columna)  
      
      if("suma".equals(lexema1_p)||"resta".equals(lexema1_p)){
          String[]t={tabla_p.getValueAt(i, 1)+"",tabla_p.getValueAt(i-1, 0)+"",tabla_p.getValueAt(i+1, 0)+"","t"+vart};
          tabla_tem.addRow(t);
              
              tabla_p.setValueAt("t"+vart, i, 0);
              tabla_p.setValueAt(null, i, 1);
              vart++;
              tabla_p.removeRow(i-1);
              tabla_p.removeRow(i);
              i=0;
      }
           filas_t_P=tabla_p.getRowCount();
           

       
       }
      
       for(int i=cuanto_borro;i>0;i--){
                 tabla2.removeRow(pa+1);
             }
       filas =tabla2.getRowCount();
       for(int i=0;filas>i;i++){
           
           String lexema1 =tabla2.getValueAt(i, 1)+""; //(fila,columna)  
            
           if("P_A".equals(lexema1)){
               pa=i;
           }
           if("P_C".equals(lexema1)){
               pc=i;
           }
       }
       int tama_t_tem=tabla_tem.getColumnCount();
       
       tabla2.setValueAt("t"+(vart-1), pc, 0);
       tabla2.setValueAt("num", pc, 1);
       tabla2.removeRow(pa);
       tabla_p.removeRow(0);
       } 
       //------------------------------------
      //for para multiplicacion y divicion
       for(int i=0;filas>i;i++){    
      String lexema1 =tabla2.getValueAt(i, 1)+""; //(fila,columna)  
      
      if("mul".equals(lexema1)||"div".equals(lexema1)){
          String[]t={tabla2.getValueAt(i, 1)+"",tabla2.getValueAt(i-1, 0)+"",tabla2.getValueAt(i+1, 0)+"","t"+vart};
          tabla_tem.addRow(t);
              
              tabla2.setValueAt("t"+vart, i, 0);
              tabla2.setValueAt(null, i, 1);
              vart++;
              tabla2.removeRow(i-1);
              tabla2.removeRow(i);
              i=0;
      }
           filas =tabla2.getRowCount();
          

       }
       //-------------------------------------------------------
       //for para suma y resta
              filas =tabla2.getRowCount();
       
       for(int i=0;filas>i;i++){
           String lexema1 =tabla2.getValueAt(i, 1)+""; //(fila,columna)  
      
      if("suma".equals(lexema1)||"resta".equals(lexema1)){
          String[]t={tabla2.getValueAt(i, 1)+"",tabla2.getValueAt(i-1, 0)+"",tabla2.getValueAt(i+1, 0)+"","t"+vart};
          tabla_tem.addRow(t);
              
              tabla2.setValueAt("t"+vart, i, 0);
              tabla2.setValueAt(null, i, 1);
              vart++;
              tabla2.removeRow(i-1);
              tabla2.removeRow(i);
              i=0;
      }
           filas =tabla2.getRowCount();
          

       
       }
        //createmporales en asm
       String temporal_x="t1";
       int filas_temporales=tabla_tem.getRowCount();
       
       
       //creacion de codigo
       String ultimotem="t1";
       //filas_temporales=tabla_tem.getRowCount();
       for(int i=0;i<filas_temporales;i++){
           String operacion =tabla_tem.getValueAt(i, 0)+""; //(fila,columna)  
               switch (operacion){
                   case "mul":
                       multiplica(tabla_tem.getValueAt(i, 1)+"",tabla_tem.getValueAt(i, 2)+"",tabla_tem.getValueAt(i, 3)+"");
                       break;
                   case "suma":
                       suma(tabla_tem.getValueAt(i, 1)+"",tabla_tem.getValueAt(i, 2)+"",tabla_tem.getValueAt(i, 3)+"");
                       break;
                   case "resta":
                       resta(tabla_tem.getValueAt(i, 1)+"",tabla_tem.getValueAt(i, 2)+"",tabla_tem.getValueAt(i, 3)+"");
                       break;
                    case "div":
                       divide(tabla_tem.getValueAt(i, 1)+"",tabla_tem.getValueAt(i, 2)+"",tabla_tem.getValueAt(i, 3)+"");
                       break;   
               }
       ultimotem=tabla_tem.getValueAt(i, 3)+"";
       
       }
        String ultima_op2= tabla_tem.getValueAt(filas_temporales-1, 0)+"";
        
       ultima_final(tabla_tem.getValueAt(filas_temporales-1, 1)+"",tabla_tem.getValueAt(filas_temporales-1, 2)+"",tabla_tem.getValueAt(filas_temporales-1, 3)+"");
       if("resta".equals(ultima_op2)&&n1<n2){
        decimal=true;}
       filas =tabla2.getRowCount();
       for(int i=0;filas>i;i++){
        String lexema1 =tabla2.getValueAt(i, 1)+""; //(fila,columna)
        if("numero_dec".equals(lexema1)){
            decimal=true;    
        }
       }
       es_decimal();
       
       if(decimal==false){
           archivoasm();
           for(int i=0;i<filas_temporales;i++){
           temporal_x=tabla_tem.getValueAt(i, 3)+"";
           crea_t_x(temporal_x);
       }
           inicializa_asm();
       for(int i=0;i<filas_temporales;i++){
           String operacion =tabla_tem.getValueAt(i, 0)+""; //(fila,columna)  
               switch (operacion){
                   case "mul":
                       agrega_multi(tabla_tem.getValueAt(i, 1)+"",tabla_tem.getValueAt(i, 2)+"",tabla_tem.getValueAt(i, 3)+"");
                       break;
                   case "suma":
                       agrega_suma(tabla_tem.getValueAt(i, 1)+"",tabla_tem.getValueAt(i, 2)+"",tabla_tem.getValueAt(i, 3)+"");
                       
                       break;
                   case "resta":
                       agrega_resta(tabla_tem.getValueAt(i, 1)+"",tabla_tem.getValueAt(i, 2)+"",tabla_tem.getValueAt(i, 3)+"");
                       
                       break;
                    case "div":
                       agrega_div(tabla_tem.getValueAt(i, 1)+"",tabla_tem.getValueAt(i, 2)+"",tabla_tem.getValueAt(i, 3)+"");
                       
                       break;   
               }
       ultimotem=tabla_tem.getValueAt(i, 3)+"";
       
       }
       imprime_asm(ultimotem);
       final_asm();
       }
       
       
       
       
       es_decimal();
       
       
       if(decimal==true){
           String n1p1="0",n1p2="0",n1p3="0",n1p4="0",n2p1="0",n2p2="0",n2p3="0",n2p4="0";
             String ultima_op= tabla_tem.getValueAt(filas_temporales-1, 0)+"";
             
           if(n1>0&&n2>0){
            
           if("suma".equals(ultima_op)){
                    String num1=String.format("%.2f", n1);
                    String num2=String.format("%.2f", n2);
                    if(num1.length()==4){
                        n1p2=num1.charAt(0)+"";
                        n1p3=num1.charAt(2)+"";
                        n1p4=num1.charAt(3)+"";
                    }else if(num1.length()==5){
                        n1p1=num1.charAt(0)+"";
                        n1p2=num1.charAt(1)+"";
                        n1p3=num1.charAt(3)+"";
                        n1p4=num1.charAt(4)+"";
                        
                    }
                    if(num2.length()==4){
                         n2p2=num2.charAt(0)+"";
                       
                        n2p3=num2.charAt(2)+"";
                       
                        n2p4=num2.charAt(3)+"";
                        
                    }else if(num2.length()==5){
                         n2p1=num2.charAt(0)+"";
                        n2p2=num2.charAt(1)+"";
                        n2p3=num2.charAt(3)+"";
                        n2p4=num2.charAt(4)+"";
                    }
                    
                    suma_asm_decimal(n1p1,n1p2,n1p3,n1p4,n2p1,n2p2,n2p3,n2p4);
                
           }
           if(("resta".equals(ultima_op)&&n2>n1)||"resta".equals(ultima_op)){
             {
                    String num1=String.format("%.2f", n1);
                    String num2=String.format("%.2f", n2);
                    if(num1.length()==4){
                        n1p2=num1.charAt(0)+"";
                        n1p3=num1.charAt(2)+"";
                        n1p4=num1.charAt(3)+"";
                    }else if(num1.length()==5){
                        n1p1=num1.charAt(0)+"";
                        n1p2=num1.charAt(1)+"";
                        n1p3=num1.charAt(3)+"";
                        n1p4=num1.charAt(4)+"";
                        
                    }
                    if(num2.length()==4){
                         n2p2=num2.charAt(0)+"";                         
                        n2p3=num2.charAt(2)+"";
                        n2p4=num2.charAt(3)+"";                       
                    }else if(num2.length()==5){
                         n2p1=num2.charAt(0)+"";
                        n2p2=num2.charAt(1)+"";
                        n2p3=num2.charAt(3)+"";
                        n2p4=num2.charAt(4)+"";
                    }
                    
                    resta_asm_decimal(n1p1,n1p2,n1p3,n1p4,n2p1,n2p2,n2p3,n2p4);
                    
                
           }
           }
          }
           if(n1<0&&n2>0){
               
                if("suma".equals(ultima_op)){
                    String num1=String.format("%.2f", n1);
                    String num2=String.format("%.2f", n2);
                    if(num1.length()==5){
                        n1p2=num1.charAt(1)+"";
                        n1p3=num1.charAt(3)+"";
                        n1p4=num1.charAt(4)+"";
                    }else if(num1.length()==6){
                        n1p1=num1.charAt(1)+"";
                        n1p2=num1.charAt(2)+"";
                        n1p3=num1.charAt(4)+"";
                        n1p4=num1.charAt(5)+"";
                    } 
                    if(num2.length()==4){
                         n2p2=num2.charAt(0)+"";                         
                        n2p3=num2.charAt(2)+"";
                        n2p4=num2.charAt(3)+"";                       
                    }else if(num2.length()==5){
                         n2p1=num2.charAt(0)+"";
                        n2p2=num2.charAt(1)+"";
                        n2p3=num2.charAt(3)+"";
                        n2p4=num2.charAt(4)+"";
                    }
                    resta_asm_decimal(n2p1,n2p2,n2p3,n2p4,n1p1,n1p2,n1p3,n1p4);
                }
                if("resta".equals(ultima_op)){
                    String num1=String.format("%.2f", n1);
                    String num2=String.format("%.2f", n2);
                    if(num1.length()==5){
                        n1p2=num1.charAt(1)+"";
                        n1p3=num1.charAt(3)+"";
                        n1p4=num1.charAt(4)+"";
                    }else if(num1.length()==6){
                        n1p1=num1.charAt(1)+"";
                        n1p2=num1.charAt(2)+"";
                        n1p3=num1.charAt(4)+"";
                        n1p4=num1.charAt(5)+"";
                    } 
                    if(num2.length()==4){
                         n2p2=num2.charAt(0)+"";                         
                        n2p3=num2.charAt(2)+"";
                        n2p4=num2.charAt(3)+"";                       
                    }else if(num2.length()==5){
                         n2p1=num2.charAt(0)+"";
                        n2p2=num2.charAt(1)+"";
                        n2p3=num2.charAt(3)+"";
                        n2p4=num2.charAt(4)+"";
                    }
                    
                    doble_negativo(n1p1,n1p2,n1p3,n1p4,n2p1,n2p2,n2p3,n2p4);
                    
                }
           }
           
       } 
       
      float res=ultimot();
       if(res>99.99||res<-99.99){
           mayor_decien_asm(res+"");
       }
       String imprime="t1="+t1+",t2="+t2+",t3="+t3+",t4="+t4+",t5="+t5+",t6="+t6+",t7="+t7+",t8="+t8+",t9="+t9;
       
       String num1=String.format("%.2f", n1);
       String num2=String.format("%.2f", n2);
       
       t1=0;t2=0;t2=0;t3=0;t4=0;t5=0;t6=0;t7=0;t8=0;t9=0;n1=0;n2=0;
       
  }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        btnAnalizarSin = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla_para_borrar = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabla_parentesis = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        t_temporales = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_de_si = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizador", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        jPanel1.setName("analizador "); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtResultado.setBackground(new java.awt.Color(0, 0, 0));
        txtResultado.setColumns(20);
        txtResultado.setForeground(new java.awt.Color(204, 0, 153));
        txtResultado.setRows(5);
        txtResultado.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtResultadoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(txtResultado);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 164, 403, -1));

        btnAnalizarSin.setBackground(new java.awt.Color(0, 0, 0));
        btnAnalizarSin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnalizarSin.setForeground(new java.awt.Color(204, 0, 204));
        btnAnalizarSin.setText("Analizar");
        btnAnalizarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSinActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnalizarSin, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 278, -1, -1));

        txtAnalizarSin.setEditable(false);
        txtAnalizarSin.setBackground(new java.awt.Color(0, 0, 0));
        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setForeground(new java.awt.Color(204, 0, 102));
        txtAnalizarSin.setRows(5);
        jScrollPane3.setViewportView(txtAnalizarSin);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 327, 376, -1));

        jScrollPane4.setViewportView(tabla_para_borrar);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 30, 20));

        jScrollPane6.setViewportView(tabla_parentesis);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 20, 20));

        jScrollPane5.setViewportView(t_temporales);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 242, 251));

        jScrollPane2.setViewportView(tabla_de_si);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 250, 250));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\crizs\\Desktop\\Analizador03\\300px-Logo_Instituto_Politécnico_Nacional.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 210, 210));

        jLabel2.setText("Tabla se Sinbolos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, -1, -1));

        jLabel3.setText("Tabla de Temporales");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSinActionPerformed
        try {
            // TODO add your handling code here:
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        String ST = txtResultado.getText();
        
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        
        try {
            ArrayList<String> tokens = new ArrayList<String>();
            tokens.add("holaXD");
            tokens.get(0);
            s.parse();
            //txtAnalizarSin.setText("g"+tokens.get(0));
            txtAnalizarSin.setText("Analisis realizado correctamente XD");
            txtAnalizarSin.setForeground(new Color(25, 111, 61));
            
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtAnalizarSin.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            txtAnalizarSin.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnAnalizarSinActionPerformed

    private void txtResultadoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtResultadoAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResultadoAncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizarSin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable t_temporales;
    private javax.swing.JTable tabla_de_si;
    private javax.swing.JTable tabla_para_borrar;
    private javax.swing.JTable tabla_parentesis;
    private javax.swing.JTextArea txtAnalizarSin;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
