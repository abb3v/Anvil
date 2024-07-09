package me.abb3v;

import me.abb3v.config.ModConfig;
import me.abb3v.util.EnchantmentUtils;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class BlockAttackHandler {
    public static ActionResult onAttackBlock(PlayerEntity player, World world, Hand hand, BlockPos pos, Direction direction) {
        if (!world.isClient) {
            return ActionResult.PASS;
        }

        ModConfig config = Anvil.CONFIG;

        if (config.preventSpawnerBreaking) {
            Block block = world.getBlockState(pos).getBlock();

            if (block == Blocks.SPAWNER) {
                ItemStack heldItem = player.getStackInHand(hand);
                if (!EnchantmentUtils.hasSilkTouch(heldItem)) {
                    player.sendMessage(Text.of("You need Silk Touch to break this spawner!"), true);
                    return ActionResult.FAIL;
                }
            }
        }

        return ActionResult.PASS;
    }
}
