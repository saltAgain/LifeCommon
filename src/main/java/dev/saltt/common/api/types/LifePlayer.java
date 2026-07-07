package dev.saltt.common.api.types;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class LifePlayer {

    private static final int MAX_HISTORY = 25;

    private final UUID uuid;
    private String displayName;
    private final Instant firstJoin;
    private Instant lastJoined;
    private final List<String> pastNames;
    private final List<String> usedIps;

    public LifePlayer(UUID uuid, String displayName, Instant firstJoin, Instant lastJoined,
                      List<String> pastNames, List<String> usedIps) {
        this.uuid = uuid;
        this.displayName = displayName;
        this.firstJoin = firstJoin;
        this.lastJoined = lastJoined;
        this.pastNames = new ArrayList<>(pastNames);
        this.usedIps = new ArrayList<>(usedIps);
    }

    public static LifePlayer create(UUID uuid) {
        Instant now = Instant.now();
        return new LifePlayer(uuid, null, now, now, new ArrayList<>(), new ArrayList<>());

    }

    public UUID uuid() { return uuid; }
    public String displayName() { return displayName; }
    public Instant firstJoin() { return firstJoin; }
    public Instant lastJoined() { return lastJoined; }
    public List<String> pastNames() { return Collections.unmodifiableList(pastNames); }
    public List<String> usedIps() { return Collections.unmodifiableList(usedIps); }

    public void setDisplayName(String displayName) { this.displayName = displayName; }
    public void setLastJoined(Instant lastJoined) { this.lastJoined = lastJoined; }

    public void addPastName(String name) {
        if (name != null && !pastNames.contains(name)) {
            pastNames.add(name);
            while (pastNames.size() > MAX_HISTORY) pastNames.remove(0);
        }
    }

    public void addUsedIp(String ip) {
        if (ip != null && !usedIps.contains(ip)) {
            usedIps.add(ip);
            while (usedIps.size() > MAX_HISTORY) usedIps.remove(0);
        }

    }

    /** @return true — lastJoined always advances, so a login is always a real change to persist. */
    public boolean recordLogin(String currentName, String ip) {
        if (currentName != null && !currentName.equals(displayName)) {
            addPastName(displayName);
            displayName = currentName;
        }
        addUsedIp(ip);
        lastJoined = Instant.now();
        return true;
    }

}
