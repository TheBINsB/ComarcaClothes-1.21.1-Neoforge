package net.elbin.comarcaclothes;

import com.mojang.logging.LogUtils;
import net.elbin.comarcaclothes.client.model.dragonskull;
import net.elbin.comarcaclothes.client.renderer.DragonSkullRenderer;
import net.elbin.comarcaclothes.clothes.ModClothes;
import net.minecraft.world.item.CreativeModeTabs;
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

        // 2. Registro de tus ítems (ModClothes)
        ModClothes.register(modEventBus);

        // 3. Configuración y eventos de servidor
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            // Asegúrate que el nombre del ítem coincida con el de tu clase ModClothes
            event.accept(ModClothes.Dragon_Skull);
        }
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
            // Registra la geometría del cráneo de dragón
            event.registerLayerDefinition(dragonskull.LAYER_LOCATION, dragonskull::createBodyLayer);
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // 1. Obtenemos el set de modelos desde Minecraft
            net.minecraft.client.model.geom.EntityModelSet modelSet =
                    net.minecraft.client.Minecraft.getInstance().getEntityModels();

            // 2. Vinculamos el ítem pasando el modelSet al constructor
            event.enqueueWork(() -> {
                CuriosRendererRegistry.register(ModClothes.Dragon_Skull.get(),
                        () -> new DragonSkullRenderer(modelSet));
            });
        }
    }
}