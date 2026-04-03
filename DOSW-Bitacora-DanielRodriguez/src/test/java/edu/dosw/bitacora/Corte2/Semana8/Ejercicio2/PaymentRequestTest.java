package edu.dosw.bitacora.Corte2.Semana8.Ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class PaymentRequestTest {

    @Test
    void shouldExposeFieldsAndProtectMetadataMap() {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("key", "value");

        PaymentRequest request = new PaymentRequest("cliente", 75.0, 100.0, false, 0, 3, metadata);
        metadata.put("key", "updated");

        assertEquals("cliente", request.getCustomerId());
        assertEquals(75.0, request.getAmount());
        assertEquals(100.0, request.getAvailableBalance());
        assertEquals(false, request.isFraudFlagged());
        assertEquals(0, request.getTransactionCount());
        assertEquals(3, request.getTransactionLimit());
        assertEquals("value", request.getMetadata("key"));
        assertNotNull(request.getMetadata());
        assertThrows(UnsupportedOperationException.class, () -> request.getMetadata().put("x", "y"));
    }

    @Test
    void shouldRejectNullCustomerOrMetadata() {
        assertThrows(NullPointerException.class, () -> new PaymentRequest(null, 1.0, 1.0, false, 0, 1, Map.of()));
        assertThrows(NullPointerException.class, () -> new PaymentRequest("cliente", 1.0, 1.0, false, 0, 1, null));
    }
}

