package dev.saltt.common.api.domains.gamebase;

import dev.saltt.common.api.LifeGameType;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public abstract class MatchBase {

    private final UUID matchId;
    private final LocalTime startTime;
    private final List<UUID> players;   // identity, matches `repeated string players`

    protected MatchBase(UUID matchId, LocalTime startTime, List<UUID> players) {
        this.matchId = matchId;
        this.startTime = startTime;
        this.players = new ArrayList<>(players);   // defensive copy
    }

    public UUID matchId()          { return matchId; }
    public LocalTime startTime()   { return startTime; }
    public List<UUID> players()    { return Collections.unmodifiableList(players); }

    public abstract LifeGameType gameType();
}