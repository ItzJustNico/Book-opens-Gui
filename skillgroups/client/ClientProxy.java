package com.nico.skillgroups.client;

import com.nico.skillgroups.SkillGroups;
import com.nico.skillgroups.client.gui.ManualScreen;
import com.nico.skillgroups.common.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(
        value = {Dist.CLIENT},
        modid = SkillGroups.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.MOD
)public class ClientProxy extends CommonProxy {

    public ClientProxy() {
    }

    @Override
    public void openManual() {
        Minecraft.getInstance().displayGuiScreen(new ManualScreen());
    }
}
