package client.controller;

import lib.dto.Event;

public interface EventListener {

    void newEvent(Event event);
}
