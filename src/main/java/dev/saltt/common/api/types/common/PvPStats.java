package dev.saltt.common.api.types.common;

import java.util.UUID;

public class PvPStats {

    private final UUID uuid;
    private final UUID matchId;

    private int kills;
    private int assists;
    private long damageDealt;
    private long damageTaken;

    public PvPStats(UUID uuid, UUID matchId) {
        this.uuid = uuid;
        this.matchId = matchId;
    }

    /** Full-state hydration from a persisted row. */
    public static PvPStats fromStorage(UUID uuid, UUID matchId, int kills, int assists,
                                       long damageDealt, long damageTaken) {
        PvPStats s = new PvPStats(uuid, matchId);
        s.kills = kills;
        s.assists = assists;
        s.damageDealt = damageDealt;
        s.damageTaken = damageTaken;
        return s;
    }

    public int getKills()        { return kills; }
    public int getAssists()      { return assists; }
    public long getDamageDealt() { return damageDealt; }
    public long getDamageTaken() { return damageTaken; }
    public UUID getUuid()        { return uuid; }
    public UUID getMatchId()     { return matchId; }

    public void addKill()                   { this.kills++; }
    public void addAssist()                 { this.assists++; }
    public void addDamageDealt(long amount) { this.damageDealt += amount; }
    public void addDamageTaken(long amount) { this.damageTaken += amount; }
}