package cn.nukkit.form.window;

import cn.nukkit.Player;
import cn.nukkit.entity.data.StringEntityData;
import cn.nukkit.entity.passive.EntityNPCEntity;
import cn.nukkit.form.element.ElementButtonDialogue;
import cn.nukkit.network.protocol.NPCDialoguePacket;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class FormWindowDialogue {

    private final String sceneName = UUID.randomUUID().toString();

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final ObjectArrayList<ElementButtonDialogue> buttons = new ObjectArrayList<>();

    private String title = "";
    private String dialogue = "";
    private EntityNPCEntity entity = null;
    private String actionJson = "";

    public FormWindowDialogue title(@NonNull String title) {
        this.title = title;

        return this;
    }

    public FormWindowDialogue dialogue(@NonNull String dialogue) {
        this.dialogue = dialogue;

        return this;
    }

    public FormWindowDialogue entity(@NonNull EntityNPCEntity entity) {
        this.entity = entity;

        return this;
    }

    public String sceneName() {
        return this.sceneName;
    }

    public FormWindowDialogue buttons(@NonNull ElementButtonDialogue... buttons) {
        String urlTag = this.entity.getDataPropertyString(EntityNPCEntity.DATA_URL_TAG);

        ObjectList<JsonObject> urlTags = this.gson.fromJson(urlTag, ObjectList.class) == null ?
                new ObjectArrayList<>() : this.gson.fromJson(urlTag, ObjectList.class);

        for (ElementButtonDialogue button : buttons) {
            JsonObject buttonJson = new JsonObject();
            buttonJson.addProperty("button_name", button.text());
            buttonJson.addProperty("mode", 0);
            buttonJson.addProperty("text", "");
            buttonJson.addProperty("type", 1);

            urlTags.add(buttonJson);
        }

        this.actionJson = this.gson.toJson(urlTags);

        this.buttons.addAll(Arrays.asList(buttons));

        return this;
    }

    public ElementButtonDialogue[] buttons() {
        return this.buttons.toArray(new ElementButtonDialogue[0]);
    }

    public void create(@NonNull Player player) {
        this.entity.setNameTag(this.title);
        this.entity.setDataProperty(new StringEntityData(EntityNPCEntity.DATA_INTERACTIVE_TAG, this.dialogue));

        NPCDialoguePacket npcDialoguePacket = new NPCDialoguePacket();
        npcDialoguePacket.setRuntimeEntityId(this.entity.getId());
        npcDialoguePacket.setAction(NPCDialoguePacket.NPCDialogAction.OPEN);
        npcDialoguePacket.setDialogue(this.dialogue);
        npcDialoguePacket.setNpcName(this.title);
        npcDialoguePacket.setSceneName(this.sceneName);
        npcDialoguePacket.setActionJson(this.actionJson);

        player.dataPacket(npcDialoguePacket);
        player.setOpenDialogue(Optional.of(this));
    }

    public void close(@NonNull Player player) {
        NPCDialoguePacket npcDialoguePacket = new NPCDialoguePacket();
        npcDialoguePacket.setRuntimeEntityId(this.entity.getId());
        npcDialoguePacket.setAction(NPCDialoguePacket.NPCDialogAction.CLOSE);
        npcDialoguePacket.setDialogue("");
        npcDialoguePacket.setNpcName("");
        npcDialoguePacket.setSceneName("");
        npcDialoguePacket.setActionJson("");

        player.dataPacket(npcDialoguePacket);
        player.setOpenDialogue(Optional.empty());
    }
}