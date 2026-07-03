package dev.saltt.common.api.types;

import dev.saltt.common.api.types.base.MatchBase;
import dev.saltt.common.api.types.base.PvPStats;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SurvivalGamesMatch extends MatchBase {

    private final List<PvPStats> pvpStats = new ArrayList<>();

    protected SurvivalGamesMatch(UUID matchId, List<UUID> players, LocalTime startTime) {
        super(matchId, players, startTime);
        players.forEach(p -> {
            pvpStats.add(new PvPStats(p, matchId));
        });
    }

}
