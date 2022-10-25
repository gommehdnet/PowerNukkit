package cn.nukkit.network.protocol.types;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import lombok.Value;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class EntityProperties {

    List<IntEntityProperty> intProperties = new ObjectArrayList<>();
    List<FloatEntityProperty> floatProperties = new ObjectArrayList<>();
}