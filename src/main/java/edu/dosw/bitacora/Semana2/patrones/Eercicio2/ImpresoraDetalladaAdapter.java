package edu.dosw.bitacora.Semana2.patrones.Eercicio2;

public class ImpresoraDetalladaAdapter implements Impresora {

    private ImpresoraDetallada impresoraDetallada;

    public ImpresoraDetalladaAdapter(ImpresoraDetallada impresoraDetallada) {
        this.impresoraDetallada = impresoraDetallada;
    }

    @Override
    public void imprimir(Mensaje mensaje) {

        impresoraDetallada.imprimirDetalle(
                mensaje.getTexto(),
                mensaje.getAutor(),
                mensaje.getFecha()
        );
    }
}
