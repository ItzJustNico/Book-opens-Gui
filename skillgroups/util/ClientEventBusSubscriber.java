package com.nico.skillgroups.util;

import com.nico.skillgroups.SkillGroups;
import com.nico.skillgroups.client.gui.ExampleChestScreen;
import com.nico.skillgroups.client.render.HogRenderer;
import com.nico.skillgroups.init.ModCountainerTypes;
import com.nico.skillgroups.init.ModEntityType;
import com.nico.skillgroups.objects.items.ModSpawnEggItem;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SkillGroups.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.HOG.get(), HogRenderer::new); //copy line for new entity

        ScreenManager.registerFactory(ModCountainerTypes.EXAMPLE_CHEST.get(), ExampleChestScreen::new); //gui
    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }
}
