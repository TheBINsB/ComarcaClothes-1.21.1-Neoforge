package net.elbin.comarcaclothes;

import com.mojang.logging.LogUtils;
import net.elbin.comarcaclothes.client.model.*;
import net.elbin.comarcaclothes.client.renderer.CosmeticBackRenderer;
import net.elbin.comarcaclothes.client.renderer.CosmeticBodyRenderer;
import net.elbin.comarcaclothes.client.renderer.CosmeticHeadRenderer;
import net.elbin.comarcaclothes.clothes.ModClothes;
import net.elbin.comarcaclothes.tab.ClothesCreativeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod(ComarcaClothes.MOD_ID)
public class ComarcaClothes {
    public static final String MOD_ID = "comarcaclothes";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ComarcaClothes(IEventBus modEventBus, ModContainer modContainer) {
        // 1. Registros comunes
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        ClothesCreativeTabs.register(modEventBus);

        // 2. Registro de tus ítems (ModClothes)
        ModClothes.register(modEventBus);

        // 3. Configuración y eventos de servidor
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // --- SECCIÓN DE CLIENTE (OPCIÓN 1) ---
    // Esta clase interna maneja todo lo visual.
    // Al tener 'value = Dist.CLIENT', NeoForge la ignorará en servidores.
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientEvents {

        @SubscribeEvent
        public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            // Registras la geometría de CADA ítem nuevo aquí
            event.registerLayerDefinition(dragonskull.LAYER_LOCATION, dragonskull::createBodyLayer);
            event.registerLayerDefinition(christmas_hat.LAYER_LOCATION, christmas_hat::createBodyLayer);
            event.registerLayerDefinition(captainhat.LAYER_LOCATION, captainhat::createBodyLayer);
            event.registerLayerDefinition(cowboyhat.LAYER_LOCATION, cowboyhat::createBodyLayer);
            event.registerLayerDefinition(crown.LAYER_LOCATION, crown::createBodyLayer);
            event.registerLayerDefinition(quiver.LAYER_LOCATION, quiver::createBodyLayer);
            event.registerLayerDefinition(wings.LAYER_LOCATION, wings::createBodyLayer);
            event.registerLayerDefinition(horns.LAYER_LOCATION, horns::createBodyLayer);
            event.registerLayerDefinition(sombrero.LAYER_LOCATION, sombrero::createBodyLayer);
            event.registerLayerDefinition(pickelhaube.LAYER_LOCATION, pickelhaube::createBodyLayer);
            event.registerLayerDefinition(wizardhat.LAYER_LOCATION, wizardhat::createBodyLayer);
            event.registerLayerDefinition(piratehat.LAYER_LOCATION, piratehat::createBodyLayer);
            event.registerLayerDefinition(tophat.LAYER_LOCATION, tophat::createBodyLayer);
            event.registerLayerDefinition(doubletophat.LAYER_LOCATION, doubletophat::createBodyLayer);
            event.registerLayerDefinition(kasahat.LAYER_LOCATION, kasahat::createBodyLayer);
            event.registerLayerDefinition(pumpkinhat.LAYER_LOCATION, pumpkinhat::createBodyLayer);
            event.registerLayerDefinition(katana.LAYER_LOCATION, katana::createBodyLayer);
            event.registerLayerDefinition(bodydef.LAYER_LOCATION, bodydef::createBodyLayer);
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            net.minecraft.client.model.geom.EntityModelSet modelSet =
                    net.minecraft.client.Minecraft.getInstance().getEntityModels();

            event.enqueueWork(() -> {
                // Registras TODOS tus ítems para que usen el MISMO renderer
                CuriosRendererRegistry.register(ModClothes.Dragon_Skull.get(), () -> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Christmas_Hat.get(), () -> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.CaptainHat.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.CowboyHat.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Crown.get(),()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Quiver.get(),()-> new CosmeticBackRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Wings.get(),()-> new CosmeticBackRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Horns.get(),()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Sombrero.get(),()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Pickelhaube.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Wizardhat.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Piratehat.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Tophat.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Doubletophat.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Kasahat.get(),()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Pumpkinhat.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Katana.get(), ()-> new CosmeticBackRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Bluetoga.get(), ()-> new CosmeticBodyRenderer(modelSet));
            });
        }
    }
}