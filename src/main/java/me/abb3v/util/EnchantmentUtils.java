package me.abb3v.util;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;

public class EnchantmentUtils {
    public static boolean hasEnchant(RegistryKey<Enchantment> enchantment, ItemStack stack) {
        ItemEnchantmentsComponent itemEnchantmentsComponent = stack.getOrDefault(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT);
        for (RegistryEntry<Enchantment> entry : itemEnchantmentsComponent.getEnchantments()) {
            if (entry.matchesKey(enchantment)) {
                int level = itemEnchantmentsComponent.getLevel(entry);
                if (level > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasSilkTouch(ItemStack stack) {
        return hasEnchant(Enchantments.SILK_TOUCH, stack);
    }
    public static boolean hasFortune(ItemStack stack) {
        return hasEnchant(Enchantments.FORTUNE, stack);
    }
}
