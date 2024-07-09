package me.abb3v.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "anvil")
public class ModConfig implements ConfigData {
    public boolean preventSpawnerBreaking = true;
}
