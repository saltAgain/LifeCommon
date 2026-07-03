package dev.saltt.common.api.types.base;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public abstract class MatchBase {

    protected final UUID matchId;
    protected final List<UUID> players;
    protected UUID winner;
    protected LocalTime startTime;
    protected LocalTime endTime;

    protected MatchBase(UUID matchId, List<UUID> players, LocalTime startTime) {
        this.matchId = matchId;
        this.players = players;
    }

    public UUID getMatchId()        { return matchId; }
    public List<UUID> getPlayers()    { return players; }
    public UUID getWinner()           { return winner; }
    public LocalTime getStartTime()   { return startTime; }
    public LocalTime getEndTime()     { return endTime; }

    public void setWinner(UUID winner)         { this.winner = winner; }
    public void setEndTime(LocalTime end)      { this.endTime = end; }
}