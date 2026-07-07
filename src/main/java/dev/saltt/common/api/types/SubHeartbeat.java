package dev.saltt.common.api.types;

import dev.saltt.common.api.LifeGameType;

import java.util.Collection;
import java.util.UUID;

public record SubHeartbeat(String matchId, LifeGameType gameType,
                            Collection<UUID> players, GameStatus status
                            ) {

}
