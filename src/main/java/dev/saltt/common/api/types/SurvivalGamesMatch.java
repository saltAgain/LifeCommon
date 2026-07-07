package dev.saltt.common.api.types;

import dev.saltt.common.api.LifeGameType;
import dev.saltt.common.api.types.base.MatchBase;
import dev.saltt.common.api.types.common.PvPStats;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class SurvivalGamesMatch extends MatchBase {

    private final List<PvPStats> pvpStats = new ArrayList<>();

    private SurvivalGamesMatch(UUID matchId, List<UUID> players, LocalTime startTime) {
        super(matchId, players, startTime);
    }

    /** New match: one fresh PvPStats per player. */
    public static SurvivalGamesMatch create(UUID matchId, List<UUID> players, LocalTime startTime) {
        SurvivalGamesMatch m = new SurvivalGamesMatch(matchId, players, startTime);
        players.forEach(p -> m.pvpStats.add(new PvPStats(p, matchId)));
        return m;
    }

    /** Load from DB: attach persisted stats as-is. */
    public static SurvivalGamesMatch fromStorage(UUID matchId, List<UUID> players,
                                                 LocalTime startTime, List<PvPStats> stats) {
        SurvivalGamesMatch m = new SurvivalGamesMatch(matchId, players, startTime);
        m.pvpStats.addAll(stats);
        return m;
    }

    public List<PvPStats> pvpStats() { return Collections.unmodifiableList(pvpStats); }

    @Override public LifeGameType gameType() { return LifeGameType.SURVIVAL_GAMES; }
}