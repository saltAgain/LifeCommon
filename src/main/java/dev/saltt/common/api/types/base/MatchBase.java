package dev.saltt.common.api.types.base;

import dev.saltt.common.api.LifeGameType;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public abstract class MatchBase {

    private final UUID matchId;
    private final List<UUID> players;
    private final LocalTime startTime;

    protected MatchBase(UUID matchId, List<UUID> players, LocalTime startTime) {
        this.matchId = matchId;
        this.players = new ArrayList<>(players);
        this.startTime = startTime;
    }

    public UUID matchId()        { return matchId; }
    public List<UUID> players()  { return Collections.unmodifiableList(players); }
    public LocalTime startTime() { return startTime; }

    public abstract LifeGameType gameType();
}