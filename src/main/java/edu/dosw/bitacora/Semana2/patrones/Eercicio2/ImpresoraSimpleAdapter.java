package edu.dosw.bitacora.Semana2.patrones.Eercicio2;

public class ImpresoraSimpleAdapter implements Impresora  {
    private ImpresoraSimple impresoraSimple;

    public ImpresoraSimpleAdapter(ImpresoraSimple impresoraSimple) {
        this.impresoraSimple = impresoraSimple;
    }

    @Override
    public void imprimir(Mensaje mensaje) {
        impresoraSimple.imprimirTexto(mensaje.getTexto());
    }
}
