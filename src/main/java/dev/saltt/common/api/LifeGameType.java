package dev.saltt.common.api;

import java.util.UUID;

public enum LifeGameType {
    SURVIVAL_GAMES("sg");

    private final String prefix;

    LifeGameType(String prefix) {
        this.prefix = prefix;
    }

    public String prefix() {
        return this.prefix;
    }

    public String createMatchId() {
        return this.prefix + "_" + UUID.randomUUID();
    }
}