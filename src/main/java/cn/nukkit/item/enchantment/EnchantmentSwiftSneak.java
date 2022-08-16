package cn.nukkit.item.enchantment;

/**
 * @author Kaooot
 * @version 1.0
 */
public class EnchantmentSwiftSneak extends Enchantment {

    protected EnchantmentSwiftSneak() {
        super(Enchantment.ID_SWIFT_SNEAK, "swift_sneak", Rarity.VERY_RARE, EnchantmentType.ARMOR_LEGS);
    }

    @Override
    public int getMinEnchantAbility(int level) {
        return level * 10;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}