package com.nico.skillgroups;

import com.nico.skillgroups.client.ClientProxy;
import com.nico.skillgroups.common.CommonProxy;
import com.nico.skillgroups.enchantments.leap.LeapEntityEvents;
import com.nico.skillgroups.entities.HogEntity;
import com.nico.skillgroups.init.*;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SkillGroups.MOD_ID)
public class SkillGroups {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "skillgroups";

    public static CommonProxy proxy = (CommonProxy)DistExecutor.safeRunForDist(() -> {
        return ClientProxy::new;
    }, () -> {
        return CommonProxy::new;
    });


    // Leap
    public static final String NAME = "SkillGroups";
    public static ResourceLocation locate(String name) {
        return new ResourceLocation("skillgroups", name);
    }
    public static String find(String name) {
        return "skillgroups:" + name;
    }



    public SkillGroups() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        ModBlocks.BLOCKS.register(modEventBus); // have to be first
        ModItems.ITEMS.register(modEventBus);
        ModEntityType.ENTITY_TYPES.register(modEventBus);
        ModCountainerTypes.CONTAINER_TYPES.register(modEventBus);
        ModEnchantments.ENCHANTMENT.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        //Leap
        MinecraftForge.EVENT_BUS.register(new LeapEntityEvents());

    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityType.HOG.get(), HogEntity.setCustomAttributes().create()); //copy this line for new entity
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    public static final ItemGroup TAB = new ItemGroup("skillgroupsTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.RUBY.get());
        }
    };




}
