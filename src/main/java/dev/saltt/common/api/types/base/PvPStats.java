package dev.saltt.common.api.types.base;

import java.util.UUID;

public class PvPStats {

    private final UUID uuid;
    private final UUID matchId;

    public PvPStats(UUID uuid, UUID matchId) {
        this.uuid = uuid;
        this.matchId = matchId;
    }

    private int kills;
    private int assists;
    private long damageDealt;
    private long damageTaken;

    // --- getters ---
    public int getKills()        { return kills; }
    public int getAssists()      { return assists; }
    public long getDamageDealt() { return damageDealt; }
    public long getDamageTaken() { return damageTaken; }
    public UUID getUuid()        { return uuid; }
    public UUID getMatchId()     { return matchId; }

    // --- incrementors ---
    public void addKill()                   { this.kills++; }
    public void addAssist()                 { this.assists++; }
    public void addDamageDealt(long amount) { this.damageDealt += amount; }
    public void addDamageTaken(long amount) { this.damageTaken += amount; }
}