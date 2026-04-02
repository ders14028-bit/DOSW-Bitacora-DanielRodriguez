package edu.dosw.bitacora.Corte2.Semana8.Ejercicio1;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class NotificationServiceTest {

    @Test
    void shouldKeepSingleInstanceAndAllowDynamicChannelChanges() {
        NotificationService firstInstance = NotificationService.getInstance();
        NotificationService secondInstance = NotificationService.getInstance();

        assertSame(firstInstance, secondInstance);

        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output));

            firstInstance.send("ana@example.com", "Mensaje por defecto");
            firstInstance.setStrategy("sms");
            firstInstance.send("3001234567", "Mensaje por SMS");
            firstInstance.registerChannel("fax", (to, message) -> System.out.println("[FAX] Para: " + to + " | Mensaje: " + message));
            firstInstance.send("fax", "5551234", "Mensaje por fax");
        } finally {
            System.setOut(originalOut);
        }

        String consoleOutput = output.toString();
        assertTrue(consoleOutput.contains("[EMAIL] Para: ana@example.com | Mensaje: Mensaje por defecto"));
        assertTrue(consoleOutput.contains("[SMS] Para: 3001234567 | Mensaje: Mensaje por SMS"));
        assertTrue(consoleOutput.contains("[FAX] Para: 5551234 | Mensaje: Mensaje por fax"));
    }
}

