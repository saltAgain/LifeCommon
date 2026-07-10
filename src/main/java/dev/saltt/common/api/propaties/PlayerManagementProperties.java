package dev.saltt.common.api.propaties;

import java.nio.charset.StandardCharsets;

public class PlayerManagementProperties {

    //the time given for a player to connect to a server
    public static final int PLAYER_CONNECT_TIMEOUT_MS = 10000;


    private final String reason = "Player took too long to connect or doesn't have server auth";
    public byte[] playerNotAuthedReferMessageData = reason.getBytes(StandardCharsets.UTF_8);

}
