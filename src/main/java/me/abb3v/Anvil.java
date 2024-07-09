package me.abb3v;

import me.abb3v.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Anvil implements ModInitializer {
	public static final String MOD_ID = "anvil";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static ModConfig CONFIG;

	@Override
	public void onInitialize() {
		LOGGER.info("Anvil Mod has been initialized.");

		// Register configuration
		AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
		CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

		// Register event callback
		AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
			return BlockAttackHandler.onAttackBlock(player, world, hand, pos, direction);
		});
	}
}
