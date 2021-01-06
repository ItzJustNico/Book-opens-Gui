package com.nico.skillgroups.objects.items;

import com.nico.skillgroups.SkillGroups;
import com.nico.skillgroups.init.ModBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class SkillgroupsManual extends Item {

    public SkillgroupsManual() {
        super(new Properties()
                .group(SkillGroups.TAB)
                .maxStackSize(1)

        );
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, @Nonnull Hand hand) {
        if (world.isRemote) {
            SkillGroups.proxy.openManual();
        }

        return new ActionResult(ActionResultType.SUCCESS, player.getHeldItem(hand));
    }
}
