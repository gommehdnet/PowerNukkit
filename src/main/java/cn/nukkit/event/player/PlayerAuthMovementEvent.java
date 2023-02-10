package cn.nukkit.event.player;

import cn.nukkit.Player;
import cn.nukkit.event.HandlerList;
import cn.nukkit.math.Vector3;

/**
 * @author Kaooot
 * @version 1.0
 */
public class PlayerAuthMovementEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();

    private final Vector3 clientPosition;

    private double maximumHorizontalDistance;
    private double maximumVerticalDistance;

    public PlayerAuthMovementEvent(Player player, Vector3 clientPosition) {
        this.player = player;
        this.clientPosition = clientPosition;
    }

    public Vector3 getClientPosition() {
        return this.clientPosition;
    }

    public double getMaximumHorizontalDistance() {
        return this.maximumHorizontalDistance;
    }

    public double getMaximumVerticalDistance() {
        return this.maximumVerticalDistance;
    }

    public void setMaximumHorizontalDistance(double maximumHorizontalDistance) {
        this.maximumHorizontalDistance = maximumHorizontalDistance;
    }

    public void setMaximumVerticalDistance(double maximumVerticalDistance) {
        this.maximumVerticalDistance = maximumVerticalDistance;
    }

    public static HandlerList getHandlers() {
        return PlayerAuthMovementEvent.handlers;
    }
}