package edu.dosw.bitacora.Corte2.Semana8.Ejercicio1;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

final class NotificationService {

    private static final NotificationService INSTANCE = new NotificationService();

    private final Map<String, Notification> strategies = new ConcurrentHashMap<>();

    private volatile Notification strategy;

    private NotificationService() {
        registerChannel("email", new Email());
        registerChannel("sms", new Sms());
        registerChannel("push", new Push());
        this.strategy = strategies.get("email");
    }

    public static NotificationService getInstance() {
        return INSTANCE;
    }

    public void registerChannel(String channel, Notification strategy) {
        String key = normalizeChannel(channel);
        strategies.put(key, Objects.requireNonNull(strategy, "La estrategia de notificación no puede ser nula."));
    }

    public void setStrategy(Notification strategy) {
        this.strategy = Objects.requireNonNull(strategy, "La estrategia de notificación no puede ser nula.");
    }

    public void setStrategy(String channel) {
        this.strategy = getStrategy(channel);
    }

    public void send(String to, String message) {
        currentStrategy().send(to, message);
    }

    public void send(String channel, String to, String message) {
        getStrategy(channel).send(to, message);
    }

    private Notification currentStrategy() {
        Notification current = strategy;
        if (current == null) {
            throw new IllegalStateException("No hay una estrategia de notificación configurada.");
        }
        return current;
    }

    private Notification getStrategy(String channel) {
        Notification selected = strategies.get(normalizeChannel(channel));
        if (selected == null) {
            throw new IllegalArgumentException("Canal de notificación no registrado: " + channel);
        }
        return selected;
    }

    private String normalizeChannel(String channel) {
        return Objects.requireNonNull(channel, "El canal no puede ser nulo.").trim().toLowerCase();
    }
}
