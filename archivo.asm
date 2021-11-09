signo_suma macro numsum1,numsum2,contsum             ;Macro con 3 argumentos(numsum1,numsum2,contsum)  
                                                     ;Hace la operacion de resta para el signo y lo imprime
    LOCAL sumareserror1,sumareserror2                ;Asigna la etiqueta local para sumareserror1,sumareserror2
    LOCAL puntosum5,sumareserror3                    ;Asigna la etiqueta local para puntosum5,sumareserror3
    LOCAL sumareserror4                              ;Asigna la etiqueta local para sumareserror4
    LOCAL restaprestamossum1                         ;Asigna la etiqueta local para restaprestamossum1
    LOCAL norestaprestamossum1                       ;Asigna la etiqueta local para norestaprestamossum1
    mov al,numsum1                                   ;asigna el contenido de numsum1 a AL
    cmp al,2eh                                       ;compara AL con 2eh (.)
    jz  puntosum5                                    ;salta si es cero a  puntosum5  
    cmp al,0dh                                       ;compara AL con 0d (salto)
    jz  sumareserror1                                ;salta si es cero  a sumareserror1
    jnz sumareserror2                                ;salta no es a sumareserror2
sumareserror1:                                       ;Etiqueta que pone 0 si es 2eh o 0dh
    mov al,0h                                        ;asigna 0h a AL
sumareserror2:                                       ;Etiqueta que no pone 0 si es 0dh 
    mov sumgua1,al                                   ;asignael contenido de AL  a sumgua1
    mov al,numsum2                                   ;asigna el contenido de la direccion de memoria de numsum2 a AL
    cmp al,2eh                                       ;compara AL  con 2eh (.)
    jz  puntosum5                                    ;salta si es cero a puntosum5
    cmp al,0dh                                       ;compara AL  con 0dh (salto)
    jz  sumareserror3                                ;salta si es cero  a sumareserror3 
    jnz sumareserror4                                ;salta no si es cero  a sumareserror4 
sumareserror3:                                       ;Etiqueta que pone 0 si es 2eh o 0dh
    mov al,0h                                        ;asigna 0h a AL
sumareserror4:                                       ;Etiqueta que no pone 0 si es 0dh 
    cmp ah,-1h                                       ;compara AL con -1h para el signo
    jz  restaprestamossum1                           ;salta si es cero a restaprestamossum1
    jnz norestaprestamossum1                         ;salta si no es cero a norestaprestamossum1
restaprestamossum1:                                  ;Etiqueta que indica que se tiene un prestamo
    sub al,1                                         ;resta 1 a AL y lo guarda en AL
    mov ah,0                                         ;asigna 0 a AH 
    aas                                              ;ajuste de la resta
    add al,30h                                       ;suma 30h a AL y lo guarda en AL
norestaprestamossum1:                                ;Etiqueta que indica que no se tiene un prestamo  
    sub al,sumgua1                                   ;resta sumgua1 a AL y lo guarda en AL
    aas                                              ;ajuste dela resta
    add al,30h                                       ;suma 30h a AL y lo guarda en AL
puntosum5:                                           ;Etiqueta que guarda el punto en resula
    mov resula+contsum,al                            ;Asigna a AL la direccion de memoria de resula+contsum
endm                                                 ;fin de la macro signo_suma 

sumaprint1 macro                                      ;Macro que imprime resula                      
    LOCAL excepcisum1,excepcisum2                     ;Asigna la etiqueta local para excepcisum1,excepcisum2
    LOCAL excepcisum3,excepcisum4                     ;Asigna la etiqueta local para excepcisum3,excepcisum4
    LOCAL quitacerosum1,excepsumpunto                 ;Asigna la etiqueta local para quitacerosum1,excepsumpunto
    LOCAL excepsumpunto0,excepsumpunto1               ;Asigna la etiqueta local para excepsumpunto0,excepsumpunto1
    LOCAL excepsumpunto2,puntosum0                    ;Asigna la etiqueta local para excepsumpunto2,puntosum0  
    LOCAL puntosum1,puntosum2,sinpunto3               ;Asigna la etiqueta local para puntosum1,puntosum2,sinpunto3
    LOCAL sumapr,puntosum3,sinpunto2                  ;Asigna la etiqueta local para sumapr,puntosum3,sinpunto2
    mov cx,4                                          ;asigna 4 a CX
    mov bx,3                                          ;asigna 3 a BX
sumapr:                                               ;Ciclo que imprime el contenido de resula                                                                                   
    mov al,[resula+bx]                                ;asigna el contenido de la direccion de memoria dada  por 
                                                      ;el desplazamiento de resula mas BX a AL
    cmp bx,0                                          ;compara BX con 0                                         
    jz  excepcisum1                                   ;salta si BX es cero a excepcisum1
    jnz excepcisum2                                   ;salta si BX  no es cero a excepcisum2  
excepcisum2:                                          ;Etiqueta para BX no es cero
    cmp bx,3                                          ;compara BX con 3
    jz  excepcisum3                                   ;salta si BX es tres a excepcisum3 
    jnz excepcisum4                                   ;salta si BX no es tres a excepcisum4
excepcisum1:                                          ;Etiqueta para BX es cero como posicion
excepcisum3:                                          ;Etiqueta para BX es tres como posicion
    cmp al,30h                                        ;compara AL con 30h para eliminar el primer 0 y el ultimo 
    jz  quitacerosum1                                 ;salta si AL es cero a quitacerosum1
excepcisum4:                                          ;Etiqueta para BX no es tres como posicion
    mov dl,al                                         ;asigna AL a DL                       
    mov ah,02h                                        ;con la funcion 02h                            
    int 21h                                           ;de la int 21h (se imprime el numero) 
    cmp al,2eh                                        ;compara AL con 2eh(punto) 
    jz  excepsumpunto                                 ;salta si AL  es 2eh a excepsumpunto
    jnz excepsumpunto0                                ;salta si AL  es 2eh a excepsumpunto0
excepsumpunto0:                                       ;Etiqueta para AL  no es 2eh
    cmp bx,2                                          ;compara BX  con 2
    jz  excepsumpunto1                                ;salta si BX es dos a excepsumpunto1
    jnz excepsumpunto2                                ;salta si BX no es dos a excepsumpunto2
excepsumpunto1:                                       ;Etiqueta si BX=2 para poner punto en medio
    cmp al,30h                                        ;compara AL con 30h
    jz  puntosum0                                     ;salta si AL es 30h a  puntosum0 
    jnz puntosum1                                     ;salta si AL no es 30h a puntosum1
puntosum1:                                            ;Etiqueta si AL es 30h
puntosum0:                                            ;Etiqueta si no es 30h
    cmp resula+1,30h                                  ;Compara la direcion de memoria de resula+1 con 30h
    jz  puntosum2                                     ;salta si resula+1 es 30h a puntosum2
    jnz puntosum3                                     ;salta si resula+1 no es 30h a puntosum3
puntosum2:                                            ;Etiqueta para resula+1 es 30h
    cmp resula+0,30h                                  ;Compara la direcion de memoria de resula+0 con 30h
    jz  sinpunto2                                     ;salta si resula+0 es 30h a sinpunto2
    jnz sinpunto3                                     ;salta si resula+0 no es 30h a sinpunto3      
sinpunto3:                                            ;Etiqueta si resula+1 no es 30h a puntosum
puntosum3:                                            ;Etiqueta si resula+1 no es 30h a puntosum
    printmsj punto                                    ;Invoca a la macro para imprimir el contenido de punto                       
excepsumpunto2:                                       ;Etiqueta para BX no es posicion dos de la tabla resula 
excepsumpunto:                                        ;Etiqueta si AL  es 2eh, decrementa a bx en 1
quitacerosum1:                                        ;Etiqueta para BX=3,BX=0 no imprime nada y decrementa)
    dec bx                                            ;decrementa BX en 1
    loop sumapr                                       ;Ciclo que imprime el contenido de resula  
sinpunto2:                                            ;Etiqueta que sale del ciclo sin imprimi punto
endm                                                  ;fin de la macro sumaprint1 

                                                                                       
                                                                                       
;--------------------------------------------------------
;INICIO                                                 :
;--------------------------------------------------------
inicio macro                                            ;macro que asigna datos a DS 
    mov ax,data                                         ;asigna la direccion del segmento de datos a AX 
    mov ds,ax                                           ;y atravesde AX se asigna a DS
endm                                                    ;fin de la macro inicio        
;--------------------------------------------------------
;FIN                                                    :
;--------------------------------------------------------
fin macro                                               ;macro que devuelve el control al DOS
    mov ax,4c00h                                        ;asigna la funcion 4c00 de la
    int 21h                                             ;INT 21h a AX y se devuelve el control al DOS
endm                                                    ;fin de la macro fin    
;--------------------------------------------------------
;LIMPIAR                                                :
;--------------------------------------------------------
limpant MACRO                                           ;macro que limpia la pantalla
    mov ah,0Fh                                          ;funcion 0f (obtiene modo de video)
    int 10h                                             ;de la int 10h 
    mov ah,0                                            ;funcion 0 (cambia el modo video) de la
    int 10h                                             ;int 10h (es decir las 4 instrucciones borran la pantalla)
ENDM                                                    ;fin de la macro limpant   
;--------------------------------------------------------
;IMPRIMIR                                               :
;--------------------------------------------------------
printmsj MACRO mensa                                    ;macro que imprime mensaje
    lea dx,mensa                                        ;asigna la direccion inicial de desplazamiento
                                                        ;de la localidad de memoria mensa al registro DX(DS:DX)
    mov ah,09                                           ;asigna la funcion 09 de la INT 21h
    int 21h                                             ;a AH(aparece mensaje en pantalla)
ENDM                                                    ;fin de la macro printmsj 
                                                                                       

;--------------------------------------------------------                                     
    .model small                                        ;define el modelo de memoria
	.stack                                              ;define area de pila
	.data                                               ;define el area de datos
;--------------------------------------------------------
;SEGMENTO DE DATOS                                      :
;--------------------------------------------------------
numero1 db  0,0,7,0;se define la tabla numero1
numero2 db  0,0,9,0;se define la tabla numero2
resula  db  0,0,0,0                                     ;se define la tabla resula
resres  db  30,30,30,30                                 ;se define la tabla resres
signo1  db  02,00,00,02                                           ;se define la variable signo1
signo2  db  ?                                           ;se define la variable signo2
signor  db  ?                                           ;se define la variable signor
signo   db  '-$'                                        ;asigna la cadena a la variable signo
punto   db  '.$'                                        ;asigna la cadena a la variable punto
me_nos  db '-$'
sumgua1 db  0                                           ;se define la variable sumgua1
sumgua2 db  0                                           ;se define la variable sumgua2
.code                                               ;define area de codigo                      
inicia: 
inicio  
mov signo2,2DH 
call suma    
fin

endp inicia        
        
        
suma proc                                       ;Procedimiento para Suma
                            ;Invoca a la macro que imprime mensaje 
SALTO_DE_LA_RES:                                ;Salto que viene de la resta
;------------------------------------------------
;COMPARA SIGNOS                                 |
;------------------------------------------------   
    mov ax,0h                                   ;Asigna 0 a AX        
    cmp signo2,'-'                              ;Compara el contenido de signo2 sea signo negativo 
    jz  tienesignonegativosum                   ;Salta si signo2 tiene signo negativo
    jnz notienesignonegsum                      ;Salta si signo2 no tiene signo negativo
tienesignonegativosum:                          ;Etiqueta para sign2 es negativo
    cmp signo1,'-'                              ;Compara el contenido de signo1 sea signo negativo
    jz  tiene2signonegativosum                  ;Salta si signo1 tiene signo negativo
    jnz notiene2signonegsum                     ;Salta si signo1 no tiene signo negativo
tiene2signonegativosum:                         ;Etiqueta para cuando signo1 no tiene signo negativo
    printmsj signo                              ;Invoca a la marco para imprimir signo
    jmp tiene2signonegativosum2                 ;Salta a suma normal por que no hay negativos
notienesignonegsum:                             ;Etiqueta para signo2 no es negativo
    cmp signo1,'-'                              ;Compara el contenido de signo1 sea signo negativo
    jz  tienesignonegativosum1                  ;Salta si signo1 tiene signo negativo
    jnz notienesignoneg1                        ;Salta si signo1 no tiene signo negativo
notiene2signonegsum:                            ;Etiqeuta para cuando signo1 no es negativo
    cmp signo2,'-'                              ;Compara el contenido de signo2 con '-'
    jz  tienesignonegativosum1                  ;Salta si el contenido de signo2 es negativo
    jnz notienesignoneg1                        ;Salta si el contnenido de signo2 no es negativo
tienesignonegativosum1:                         ;Etiqueta para cuando signo2 es negativo
    mov al,numero1+3                            ;Asigna el contenido de la direccion de memoira de numero1+3 a AL
    cmp al,numero2+3                            ;Compara el contenido de numero1+3 con AL
    ja  mayorsum                                ;Salta si AL es mayor y numero2+3 es menor
    jb  menorsum                                ;Salta  si AL es menor y numero2+3 es mayor
    je  verificarsegnumero                      ;Salta si son iguales 
verificarsegnumero:                             ;Etiqueta si son iguales va verifcando numero por numero
    mov al,numero1+2                            ;Asigna el contenido de la direccion de memoira de numero1+2 a AL
    cmp al,numero2+2 ;                          ;Compara el contenido de numero1+2 con AL
    ja  mayorsum                                ;Salta si AL es mayor y numero2+2 es menor
    jb  menorsum                                ;Salta  si AL es menor y numero2+2 es mayor
    je  verificarsegnumero1                     ;Salta si son iguales     
verificarsegnumero1:                            ;Etiqueta si son iguales va verifcando numero por numero
    mov al,numero1+1                            ;Asigna el contenido de la direccion de memoira de numero1+1 a AL
    cmp al,numero2+1                            ;Compara el contenido de numero1+1 con AL
    ja  mayorsum                                ;Salta si AL es mayor y numero2+1 es menor
    jb  menorsum                                ;Salta  si AL es menor y numero2+1 es mayor
    je  verificarssegnumero2                    ;Salta si son iguales 
verificarssegnumero2:                           ;Etiqueta si son iguales va verifcando numero por numero
    mov al,numero1+0                            ;Asigna el contenido de la direccion de memoira de numero1+0 a AL
    cmp al,numero2+0                            ;Compara el contenido de numero1+0 con AL
    ja  mayorsum                                ;Salta si AL es mayor y numero2+0 es menor
    jb  menorsum                                ;Salta  si AL es menor y numero2+0 es mayor
    je  igualsum                                ;Salta si son iguales  
;------------------------------------------------
;NUMEROS IGUALES                                 |
;------------------------------------------------ 
igualsum:                                       ;Etiqueta si son numeros iguales 
    cmp signo1,'-'                              ;Compara el contenido de signo1 con '-'
    jz  tienesigno00                            ;Salta si signo1 es negativo
    jnz notienesigno00                          ;Salta si signo1 no es negativo
tienesigno00:                                   ;Etiqueta si signo1 es negativo
    mov cx,4                                    ;asigna 4 a CX
    mov bx,0                                    ;Asigna 0 a BX
sisignosum00:                                   ;Etiqueta de Ciclo que resta cuando numero 1 tiene signpo negativo  
    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion
    inc bx                                      ;incrementa BX en 1
    loop sisignosum00                           ;Ciclo que resta cuando los numeros son iguales
    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion
notienesigno00:                                 ;Etiqueta si el signo1 no es negativo
    cmp signo2,'-'                              ;Compara el contenido de signo2 con '-'
    jz  tienesigno0                             ;Salta si signo2 es negativo 
    jnz notienesigno0                           ;Salta si signo2 no es negativo
tienesigno0:                                    ;Etiqueta si signo2 es negativo           
    mov cx,4                                    ;asigna 4 a CX
    mov bx,0                                    ;Asigna 0 a BX
sisignosum0:                                    ;Etiqueta de ciclo que resta cuando numero2 tiene signo negativo 
    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion
    inc bx                                      ;incrementa bx en 1
    loop sisignosum0                            ;Ciclo para restar  
    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion     
;------------------------------------------------
;NUMERO MAYOR                                |
;------------------------------------------------     
mayorsum:                                       ;Etiqueta AL es mayor y numero2+0 es menor    
    cmp signo1,'-'                              ;Compara el contenido de signo1 con '-'
    jz  tienesigno1                             ;Salta a tieneigno1 cuando signo1 es el mayor y es negativo
    jnz notienesigno1                           ;Salta a notienesigno1 cuando signo1 es el mayor y no es negativo
tienesigno1:                                    ;Etiqueta si signo1 es negativo  y mayor
    mov cx,4                                    ;asigna 4 a CX
    mov bx,0                                    ;Asigna 0 a BX
sisignosum1:                                    ;Etiqueta de ciclo que resta cuando numero1 tiene signo negativo
    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion
    inc bx                                      ;incremeta bx en 1
    loop sisignosum1                            ;Ciclo para restar
    printmsj signo                              ;Invoca a la macro printmsj para imprimir signo
    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion
notienesigno1:                                  ;Etiqueta si signo1 es mayor pero no es negativo 
    cmp signo2,'-'                              ;Compara el contenido de signo2 con '-'
    jz  tienesigno3                             ;Salta si signo2 es el menor y es negativo
    jnz notienesigno3                           ;Salta cuando signo2 es el menor y no es negativo
tienesigno3:                                    ;Etiqueta cuando signo2 es el menor y  es negativo
    mov cx,4                                    ;asigna 4 a CX
    mov bx,0                                    ;Asigna 0 a BX
sisignosum2:                                    ;Etiqueta de ciclo que resta cuando numero2 tiene signo negativo
    signo_suma numero2+bx,numero1+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion
    inc bx                                      ;incremeta bx en 1
    loop sisignosum2                            ;Ciclo para restar
    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion  
;------------------------------------------------
;NUMERO MENOR                                 |
;------------------------------------------------ 
menorsum:                                       ;Salta si AL es menor y numero2+0 es mayor
    cmp signo2,'-'                              ;Compara el contenido de signo1 con '-'
    jz  tienesigno2                             ;Salta si signo2 es negativo
    jnz notienesigno2                           ;Salta si signo2 no es negativo
tienesigno2:                                    ;Etiqueta si signo21 es negativo y mayor
    mov cx,4                                    ;asigna 4 a CX
    mov bx,0                                    ;Asigna 0 a BX
sisignosum3:                                    ;Etiqueta de ciclo que resta cuando numero1 tiene signo negativo
    signo_suma numero1+bx,numero2+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion
    inc bx                                      ;incremeta bx en 1
    loop sisignosum3                            ;Ciclo para restar
    printmsj signo                              ;Invoca a la macro printmsj para imprimir signo
    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion
notienesigno2:                                  ;Salta si signo1 es negativo y es menor 
    cmp signo1,'-'                              ;Comapra el contenido de signo1 con '-'
    jz  tienesigno4                             ;Salta si signo1 es negativo y es menor 
    jnz notienesigno4                           ;Salta si signo1 no es negativo y es menor 
tienesigno4:                                    ;Etiqueta para  signo1 es negativo y es menor 
    mov cx,4                                    ;Asigna 4 a CX
    mov bx,0                                    ;Asigna 0 a BX
sisignosum4:                                    ;Etiqueta de ciclo que resta cuando numero2 tiene signo negativo
    signo_suma numero1+bx,numero2+bx,bx         ;Invoca a la macro signo_suma para hacer la operacion
    inc bx                                      ;Incrementa BX en 1
    loop sisignosum4                            ;Ciclo para restar
    jmp salirsignosum                           ;Salta a la etiqueta salirsignonum que termina la operacion 
notienesigno0:                                  ;Etiqueta cuando signo1 y signo2 no son negativo
notienesigno4:                                  ;Etiqueta cuando signo1 y signo2 no son negativo
notienesigno3:                                  ;Etiqueta cuando signo1 y signo2 no son negativo
notienesignoneg1:                               ;Etiqueta para cuando signo2 no es negativo
tiene2signonegativosum2:                        ;Etiqueta par cuandon ninguno de los 2 numeros tiene signo   
;------------------------------------------------
;SUMA NORMAL                                    |
;------------------------------------------------ 
	mov cx,4                                    ;Asigna 4 a CX     
	mov bx,0                                    ;Asigna 0 a BX
	mov ax,0                                    ;Asigna 0 a AX
sumaciclo1:                                     ;Ciclo que hace la operacion de sumar
    mov al,[numero1+bx]                         ;asigna el contenido de la direccion de memoria dada  por 
                                                ;el desplazamiento de numero1 mas BX a AL
    cmp al,0dh                                  ;Compara AL con 0dh(salto)
    jz  sumerror1                               ;Salta a sumerror1 si AL es 0dh
    jnz sumerror2                               ;Salta a sumerror2 si AL no es 0dh
    cmp al,6bh                                  ;Compara AL con 6bh
    jz  sumerror3                               ;Salta a sumerror3 si AL es 6bh
    jnz sumerror4                               ;Salta a sumerror4 si AL no es 6bh  
sumerror1:                                      ;Etiqueta para AL es 0dh, asigna 0h a AL
    mov al,0h                                   ;Asigna 0h a AL 
sumerror2:                                      ;Etiqueta para AL no es 0dh, no asigna 0h a AL
    cmp al,2eh                                  ;Compara AL con 2eh(punto)
    jz  puntosum_sa                             ;Salta a puntosum_sa, si AL es 2eh
    jnz nopuntosum_sa                           ;Salta a nopuntosum_sa, si AL no es 2eh
nopuntosum_sa:                                  ;Etiqueta para AL no es 2eh, no hay punto       
    mov sumgua1,al                              ;Asigna el contenido de al a sumgual1                              
    mov al,[numero2+bx]                         ;asigna el contenido de la direccion de memoria dada  por 
                                                ;el desplazamiento de numero2 mas BX a AL
    cmp al,2eh                                  ;Compara AL con 2eh(punto)
    jz  puntosum_sa1                            ;Salta a puntosum_sa1, si AL es 2eh
    jnz nopuntosum_sa1                          ;Salta a nopuntosum_sa1, si AL no es 2eh
nopuntosum_sa1:                                 ;Etiqueta para AL no es 2eh, no hay punto
    cmp al,0dh                                  ;Compara AL con 0dh(salto)
    jz  sumerror3                               ;Salta a sumerror3, si AL es 0dh
    jnz sumerror4                               ;Salta a sumerror4, si AL no es 0dh
    cmp al,6bh                                  ;Compara AL con 6bh
    jz  sumerror3                               ;Salta a sumerror3, si AL es 6bh
    jnz sumerror4                               ;Salta a sumerror4, si AL no es 6bh
sumerror3:                                      ;Etiqueta para AL es 0dh, asigna 0h a AL
    mov al,0h                                   ;Asigna 0h a AL
sumerror4:                                      ;Etiqueta para AL no es 0dh, no asigna 0h a AL
    add al,ah                                   ;suma AH a AL y lo guarda en AL 
    mov ah,0h                                   ;Asigna 0h a AH
    add al,sumgua1                              ;suma sumgua1 a AL y lo guarda en AL
	aaa                                         ;ajuste ascii de la suma 
	add ax,30h                                  ;suma 30h a AL y lo guarda en AL	 
puntosum_sa1:                                   ;Etiqueta para AL es 2eh, hay punto y lo guardamos en resula
puntosum_sa:                                    ;Etiqueta para AL es 2eh, hay punto y lo guardamos en resula
	mov resula+bx,al                            ;Se asigna AL a la direccion de memoria de resula + bx 
	inc bx                                      ;Incrementa BX en uno
    loop sumaciclo1                             ;Ciclo que hace la operacion de sumar  
    salirsignosum:                              ;Etiqueta que termina las operaciones con signo
    sumaprint1                                  ;Invoca a la macro sumaprint para imprimir la tabal resula        
    ret                                         ;retorna a donde fue llamado el procedimiento
suma endp                                       ;finaliza el procedimiento sum

resta proc                                 ;procedimiento que efectua la resta
;-----------------------------------------
;IMPRIME Y PIDE DATOS                   ||
;-----------------------------------------    
;------------------------------------------
;COMPARA SIGNOS                           |
;------------------------------------------
COMPARA_SIGNOS:                            ;etiqueta que compara los signos
    mov dh,[signo1]                        ;mueve el contenido de la direccion de memoria
                                           ;dada por signo1
    mov dl,[signo2]                        ;mueve el contenido de la direccion de memoria
                                           ;dada por signo1
    cmp dh,dl                              ;compara dh con dl (los signos) para saltar a
    jz  SIH_IGUAL                          ;la etiueta de signos iguales
    JMP SIH_DIFE                           ;en caso contario salta a signos diferentes
SIH_DIFE:                                  ;etiqueta de signos diferentes
    cmp dh,'-'                             ;compara si los signos son positivos o negativos
    jz  c_sig1                             ;salta si el premer signo es nehativo
    jmp c_sig2                             ;salta si el segundo signo es negativo
c_sig2:                                    ;etiqueta cambia el signo de numero2
    mov signo2,00h                         ;asigna un signo positivo al numero 2
    jmp SALTO_DE_LA_RES                    ;etiqueta que salta a la suma
c_sig1:                                    ;etiqueta cambia signo numero1
    mov signo2,'-'                         ;asigna un signo negativo al numero2
    jmp SALTO_DE_LA_RES                    ;etiqueta que salta a la suma
SIH_IGUAL:                                 ;etiqueta si los signos son iguales
    cmp dh,'-'                             ;compara signo de numero1 para saltar a la
    jz COMPARA_MAYOR                       ;etiqueta que compara el numero mayor
    jmp COMPARA_NUMEROS                    ;en caso contrario salta a comparar(para resta)
IMPRIME_MENOS:                             ;etiqueta que imprime un sino negativo
     printmsj   me_nos                     ;invoca a la macro para imprimir un signo negativo
     JMP COMPARA_NUMEROS                   ;salta para comparar numeros(para resta)
;------------------------------------------
;COMPARA NUMERO MAYOR                     |
;------------------------------------------
COMPARA_MAYOR:                             ;etiqueta que compara numeros (saber mayor)
    mov bx,03h                             ;asigna 03h a bx(repite 3 veces)
COM_DEN2:                                  ;etiqueta para comparar de nuevo    
    mov dh,[numero1+bx]                    ;mueve el contenido de la direccion de memoria
                                           ;a dh dado por numero1+bx (bx=3,2,1,0)
    mov dl,[numero2+bx]                    ;mueve el contenido de la direccion de memoria
                                           ;a dl dado por numero2+bx (bx=3,2,1,0)
    cmp dh,dl                              ;compara dh con dl para saltar a la etiqueta
    jg  IMPRIME_MENOS                      ;salta si es mas grande DH(numero1)
    jb  RESTA_ALREVES                      ;salta si es mas grande DL(numero2)
    dec bx                                 ;decrementa en uno bx(bx=3,2,1,0)
    jmp COM_DEN2                           ;salta(regresa) si los numeros son iguales
COMPARA_NUMEROS:                           ;compara numeros(para resta invertida)
    mov bx,03h                             ;asigna 03h a bx(repite 3 veces)
COM_DEN:                                   ;etiqueta para comparar de nuevo
    mov dh,[numero1+bx]                    ;mueve el contenido de la direccion de memoria
                                           ;a dh dado por numero1+bx (bx=3,2,1,0)
    mov dl,[numero2+bx]                    ;mueve el contenido de la direccion de memoria
                                           ;a dl dado por numero2+bx (bx=3,2,1,0)
    cmp dh,dl                              ;compara dh con dl para saltar a la etiqueta
    jg  RESTANOR                           ;salta si es mas grande DH(numero1)(resta normal)
    jb  RESTA_ALREVES_S                    ;salta si es mas grande DL(numero2)(resta invertida)
    cmp bx,00h                             ;compara si bx es cero(numeros iguales)
    jz  RESTANOR                           ;si BX es cero salta a resta normal
    dec bx                                 ;decrementa BX en uno
    jmp COM_DEN                            ;salta para comparar el sigiente digito
RESTANOR:                                  ;etiqueta de resta normal
    LEA si,numero1                         ;asigna la direccion de mamoria al registro SI(indice fuente)
    LEA dI,numero2                         ;asigna la direcion de memoria al registro DI[indice destino]
    mov bx,00h                             ;restablese en ceros a bx
    jmp COM_N                              ;salta para comparar numeros
RESTA_ALREVES_S:                           ;etiqueta para resta inversa(imprime menos)
    printmsj me_nos                        ;invoca a la macro para imptimir un signo menos
    JMP RESTA_ALREVES                      ;salta a la resta al incerza
;------------------------------------------
;CAMBIA DE ORDEN LOS NUMEROS              |
;------------------------------------------
RESTA_ALREVES:                             ;resta iinverza cambia numeros de pocicion
    mov bx,00h                             ;restablese bx en cero
repite_al:                                 ;etiqueta que repite 3 veces
    mov al,[numero1+bx]                    ;mueve el contenido de la direccion de memoria
                                           ;a al dado por numero1+bx(BX=0,1,2,3)
    mov [resula+bx],al                     ;mueve el contenido de AL a la direccion de memoria 
                                           ;dada por resula+bx (BX=0,1,2,3)
    mov al,[numero2+bx]                    ;mueve el contenido de la direccion de memoria
                                           ;a al dado por numero2+bx(BX=0,1,2,3)
    mov [numero1+bx],al                    ;mueve el contenido de AL a la direccion de memoria 
                                           ;dada por numero1+bx (BX=0,1,2,3)
    mov al,[resula+bx]                     ;mueve el contenido de la direccion de memoria
                                           ;a al dado por resula+bx(BX=0,1,2,3)
    mov [numero2+bx],al                    ;mueve el contenido de AL a la direccion de memoria 
                                           ;dada por numero2+bx (BX=0,1,2,3)
    inc bx                                 ;incrementa bx en uno
    cmp bx,04h                             ;compara si bx es igual a 04h para saltar a la 
    jz  RESTANOR                           ;etiqueta de resta normal
    jmp repite_al                          ;salta para repetir 3 veces
;------------------------------------------
;COMPARA PARA RESTAR                      |
;------------------------------------------
COM_N:                                     ;etiqueta que compara numeros(acarreo o no)
    mov dh,[numero1+bx]                    ;mueve el contenido de la direccion de memoria
                                           ;a DH dado por numero1+bx(BX=0,1,2,3)
    mov dl,[numero2+bx]                    ;mueve el contenido de la direccion de memoria
                                           ;a DL dado por numero2+bx(BX=0,1,2,3)
    cmp dh,dl                              ;compara dh con dl
    jb RES_INV                             ;salta a la resta con acarreo si dh(numero1) es mayor
    jmp  OPE_RESN                          ;salta a la resta normal si DL es mayor(numero2)  
    INC bx                                 ;incrementa en uno al registro bx
    cmp bx,03H                             ;compara si BX es igual a 03h
    jz  RES_CERO                           ;si bx es 03h salta aa imprimir cero(numeros iguales)
    cmp dh,dl                              ;compara si dh y dl son iguales
    jz  COM_N                              ;si son iguales repite la comparacion
;------------------------------------------
;RESULTADO CERO
;------------------------------------------
RES_CERO:                                  ;etiqueta que da resultado cero
     JMP IMP_RES2                          ;salta para imprimir resultado
;------------------------------------------            
;RESTA NORMAL                             |
;------------------------------------------ 
OPE_RESN:                                  ;etiqueta que resta numero 1- numero2
    mov ax,00h                             ;restablece AX a cero
    mov al,[SI]                            ;mueve el contenido de la direccion de memoria
                                           ;a AL dado por SI
    sbb al,[DI]                            ;resta el contenido de la direccion de memoria
                                           ;a AL dado por DI
    AAS                                    ;ajusta el resultado despues de la resta
    mov [resres+bx],AL                     ;mueve el conteniado de AL a la direccion de memoria
                                           ;dado por resres+bx(BX=0,1,2,3)
    cmp bx,03h                             ;compara el contenido de bx con 03h para saltar a la 
    jz  IMP_RES2                           ;etiqueta que imprime el resultado
    INC SI                                 ;invcrementa en uno a SI(apunta a la siguente pocicon)
    INC DI                                 ;invcrementa en uno a DI(apunta a la siguente pocicon)
    INC bx                                 ;invcrementa en uno a DX(apunta a la siguente pocicon)
    jmp COM_N                              ;repite el proceso tres veces
;------------------------------------------    
;RESTA INVERTIDA                          |
;------------------------------------------    
RES_INV:                                   ;etiqueta que efectua resta inverida (acarreo)
    mov ax,00h                             ;restablece AX a cero
    mov al,[SI]                            ;mueve el contenido de la direccion de memoria
                                           ;a AL dado por SI
    ADD AL,10H                             ;suma 10h al contenido de AL
    sbb al,[DI]                            ;resta el contenido de la direccion de memoria
                                           ;a AL dado por DI
    AAS                                    ;ajusta el resultado despues de la resta
    mov [resres+bx],AL                     ;mueve el conteniado de AL a la direccion de memoria
                                           ;dado por resres+bx(BX=0,1,2,3)
    jmp ACARREO_RES                        ;salta para efectuar acarreo
;------------------------------------------
;ACARREO                                  |
;------------------------------------------
ACARREO_RES:                               ;etiqueta que efectua acarreo
    mov dx,00h                             ;restablece a cero bx
    mov dl,[NUMERO1+bx+1]                  ;mueve el contenido de la direccion de memoria
                                           ;a AL dado por numero1+bx+1
    cmp dl,00h                             ;compara el contenido de dl con cero pasa altar a la 
    jz  ACARREO_RES2:                      ;etiqueta que suma una al minuendo
    dec dl                                 ;decrementa dl para efectuar acarreo
    mov [numero1+bx+1],dl                  ;mueve el conteniado de DL a la direccion de memoria
                                           ;dado por numero1+bx+1(BX=0,1,2,3)
    cmp bx,03H                             ;compara el contenido de bx con 03h para saltar a la
    jz  IMP_RES2                           ;etiqueta que imprime el resultado
    inc bx                                 ;invcrementa en uno a BX(apunta a la siguente pocicon)
    INC SI                                 ;invcrementa en uno a SI(apunta a la siguente pocicon)
    INC DI                                 ;invcrementa en uno a DI(apunta a la siguente pocicon)
    jmp COM_N                              ;salta para repetir el proceso 3 veces        
ACARREO_RES2:                              ;etiqueta de acarreo que suma al minuendo
    MOV dx,00h                             ;restitulle en cero al contenido del registro dx
    mov dl,[numero2+bx+1]                  ;asigna a dl el contenido de la direccion de memoria dado
                                           ;por el desplasamiento de numero2+bx+1
    inc dl                                 ;incrementa en 1 al contenido del registro dl
    mov [numero2+bx+1],dl                  ;aigna el contenido de dl en la direccion de memoria 
                                           ;dada por el desplasamiento de la suma de numero2+bx+1 
    cmp bx,03H                             ;compara el contenido de bx con 03h para saltar a la
    jz  IMP_RES2                           ;etiqueta que imprime el resultado
    inc bx                                 ;invcrementa en uno a BX(apunta a la siguente pocicon)
    INC SI                                 ;invcrementa en uno a SI(apunta a la siguente pocicon)
    INC DI                                 ;invcrementa en uno a DI(apunta a la siguente pocicon)
    jmp COM_N
    
;------------------------------------------
;IMPRIME EL RESULTADO                     |
;------------------------------------------        
IMP_RES2:                                  ;etiqueta que imprime el resultado
   mov  bx,00h                             ;restablece en ceros a BX
REPITE_IM:                                 ;etiqueta para mover de resres a resula
   mov  dx,00h                             ;restablece en cero a DX
   mov  dl,[resres+bx]                     ;mueve el contenido de la direccion de memoria
                                           ;a DL dado por resres+bx(BX=0,2,3)
   add  dl,30h                             ;suma 30h al contenido de DL(pasa a ASCII)
   mov  [resula+bx],dl                     ;mueve el conteniado de DL a la direccion de memoria
                                           ;dado por resula+bx(BX=0,1,2,3)
   inc  bx                                 ;incrementa bx en uno(BX=0,1,2,3)
   cmp  bx,04h                             ;compara en contenido de BX con 04h
   jz   MANDAR                             ;si bx es cuatro manda a llamar a la macro
   jmp  REPITE_IM                          ;en caso contrario repite el proceso
;------------------------------------------
;MANDA A IMPRIMIR                       |||
;------------------------------------------   
MANDAR:                                    ;etiqueta que llama a la macro para imprimir
sumaprint1                                 ;invoca a ala macro que imprime el resultado    
;------------------------------------------
;BORRA EL CONTENIDO DE LAS VARIABLES  |||||
;------------------------------------------
BORRAR:                                    ;etiqueta que borra el contenido de las variebles
    mov signo1,00h                         ;restablece el contenido de signo1 a cero
    mov signo2,00h                         ;restablece el contenido de signo2 a cero
    mov  bx,00h                            ;restablcece el contenido de bx en cero
REPI_CLEAR:                                ;etiqueta que repite el proceso de borrar
   mov  dx,00h                             ;restablece en cero el contenido de dx
   mov  [resres+bx],00h                    ;mueve 00h a la direccion de memoria
                                           ;dado por resres+bx(BX=0,1,2,3)
   mov  [resula+bx],00h                    ;mueve 00h a la direccion de memoria
                                           ;dado por resula+bx(BX=0,1,2,3)
   inc  bx                                 ;incrementa en uno el contenido de BX
   cmp  bx,4                               ;compara se es 04h el contenido de BX si lo es
   jz   FIN                                ;salta a la etiqueta fin
   jmp  REPI_CLEAR                         ;en caso contrario repite el proceso de borrado
;------------------------------------------
;FINALIZA LA RESTA                       ||
;------------------------------------------       
FIN:                                       ;etiqueta que finaliza la resta
    ret                                    ;retorna a donde fue llamado el procedimiento
resta endp        