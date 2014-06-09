package com.ijunes.laundrytimer.core;

public class TimerPausedEvent {

    private final boolean timerIsPaused;

    public TimerPausedEvent(boolean timerIsPaused) {
        this.timerIsPaused = timerIsPaused;
    }

    public boolean isTimerIsPaused() {
        return timerIsPaused;
    }
}
