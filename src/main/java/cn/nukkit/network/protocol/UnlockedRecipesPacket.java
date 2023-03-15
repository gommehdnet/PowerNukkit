package cn.nukkit.network.protocol;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public class UnlockedRecipesPacket extends DataPacket {

    public boolean unlockedNotification;
    public final List<String> unlockedRecipes = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.UNLOCKED_RECIPES_PACKET;
    }

    @Override
    public void decode() {
        this.unlockedNotification = this.getBoolean();

        final int unlockedRecipesLength = (int) this.getUnsignedVarInt();

        for (int i = 0; i < unlockedRecipesLength; i++) {
            this.unlockedRecipes.add(this.getString());
        }
    }

    @Override
    public void encode() {
        this.reset();

        this.putBoolean(this.unlockedNotification);
        this.putUnsignedVarInt(this.unlockedRecipes.size());

        for (String unlockedRecipe : this.unlockedRecipes) {
            this.putString(unlockedRecipe);
        }
    }
}