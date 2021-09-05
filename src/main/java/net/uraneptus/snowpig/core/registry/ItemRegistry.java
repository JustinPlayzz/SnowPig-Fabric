package net.uraneptus.snowpig.core.registry;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.registry.Registry;
import net.uraneptus.snowpig.SnowPig;
import net.uraneptus.snowpig.common.items.FrozenHam;
import net.uraneptus.snowpig.core.ModIntegrations;

public class ItemRegistry {
    public static final Item FROZEN_PORKCHOP = register("frozen_porkchop", new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.3f).meat().statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 2), 1.0f).build())));
    public static final Item FROZEN_HAM = register("frozen_ham", new FrozenHam(2, -1.2F, new Item.Settings().group(ModIntegrations.isFDLoaded() ? ModIntegrations.getFdItemGroup() : ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 2), 1.0f).build())));
    public static final SpawnEggItem SNOW_PIG_EGG = register("snow_pig_spawn_egg", new SpawnEggItem(EntityRegistry.SNOW_PIG, 0x70CFF3, 0xE2FBFA, new Item.Settings().group(ItemGroup.MISC)));

    public static <T extends Item> T register(String path, T item) {
        Registry.register(Registry.ITEM, SnowPig.id(path), item);

        return item;
    }
}
