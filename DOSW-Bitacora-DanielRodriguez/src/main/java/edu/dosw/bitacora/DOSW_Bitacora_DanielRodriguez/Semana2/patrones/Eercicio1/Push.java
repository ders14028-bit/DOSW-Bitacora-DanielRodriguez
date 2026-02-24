public class Push implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando PUSH: " + mensaje);
    }
}
