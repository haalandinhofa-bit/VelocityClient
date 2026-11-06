package com.velocityclient.hud;

import java.util.ArrayDeque;
import java.util.Deque;

public class ClickCounter {
    private final Deque<Long> clicks = new ArrayDeque<Long>();
    public void click() { clicks.addLast(System.currentTimeMillis()); clean(); }
    public int getCps() { clean(); return clicks.size(); }
    private void clean() { long now = System.currentTimeMillis(); while (!clicks.isEmpty() && now - clicks.peekFirst() > 1000L) clicks.removeFirst(); }
}
