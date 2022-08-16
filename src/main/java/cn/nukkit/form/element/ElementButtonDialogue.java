package cn.nukkit.form.element;

import lombok.Value;
import lombok.experimental.Accessors;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
@Accessors(fluent = true)
public class ElementButtonDialogue {

    String text;
    Runnable click;
}