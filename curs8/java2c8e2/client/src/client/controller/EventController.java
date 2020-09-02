package client.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class EventController {

    private final ScheduledExecutorService service;

    private final Map<String, List<EventListener>> listeners = new ConcurrentHashMap<>();

    private EventController() {
        service = Executors.newSingleThreadScheduledExecutor();
    }

    private static final class SingletonHolder {
        public static final EventController INSTANCE = new EventController();
    }

    public static EventController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void listenForEvents(String user) {
        var task = (Runnable) () -> {
            var unseenEvents = MessageController.getInstance().getEvents(user);

            if (!unseenEvents.isEmpty()) {
                listeners.get(user).forEach(listener ->
                        unseenEvents.forEach(listener::newEvent)
                );
            }
        };

        service.scheduleWithFixedDelay(task, 0, 3, TimeUnit.SECONDS);
    }

    public void addListener(String user, EventListener listener) {
        listeners.computeIfAbsent(user, username -> new CopyOnWriteArrayList<>())
                .add(listener);
    }

    public void removeListener(String user, EventListener listener) {
        if (listeners.containsKey(user)) {
            listeners.get(user).remove(listener);
        }
    }
}
