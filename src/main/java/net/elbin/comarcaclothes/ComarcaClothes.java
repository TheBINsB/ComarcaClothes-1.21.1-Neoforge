package net.elbin.comarcaclothes;

import com.mojang.logging.LogUtils;
import net.elbin.comarcaclothes.client.model.back.*;
import net.elbin.comarcaclothes.client.model.belt.flotador;
import net.elbin.comarcaclothes.client.model.belt.tojiworm;
import net.elbin.comarcaclothes.client.model.body.bodydef;
import net.elbin.comarcaclothes.client.model.body.royal1;
import net.elbin.comarcaclothes.client.model.body.royalpads;
import net.elbin.comarcaclothes.client.model.face.cartographer;
import net.elbin.comarcaclothes.client.model.face.cigarro;
import net.elbin.comarcaclothes.client.model.head.*;
import net.elbin.comarcaclothes.client.renderer.CosmeticBackRenderer;
import net.elbin.comarcaclothes.client.renderer.CosmeticBeltRenderer;
import net.elbin.comarcaclothes.client.renderer.CosmeticBodyRenderer;
import net.elbin.comarcaclothes.client.renderer.CosmeticHeadRenderer;
import net.elbin.comarcaclothes.clothes.ModClothes;
import net.elbin.comarcaclothes.tab.ClothesCreativeTabs;
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
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        ClothesCreativeTabs.register(modEventBus);

        // Registro de ítems
        ModClothes.register(modEventBus);

        // Configuración y eventos de servidor
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

    // Esta clase interna maneja lo visual
    // Al tener 'value = Dist.CLIENT', NeoForge la ignorará en servidores.
    @EventBusSubscriber(modid = MOD_ID)
    public static class ClientEvents {

        @SubscribeEvent
        public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
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
            event.registerLayerDefinition(mahoraga_aro.LAYER_LOCATION, mahoraga_aro::createBodyLayer);
            event.registerLayerDefinition(pto.LAYER_LOCATION, pto::createBodyLayer);
            event.registerLayerDefinition(gorro1.LAYER_LOCATION, gorro1::createBodyLayer);
            event.registerLayerDefinition(choppa.LAYER_LOCATION, choppa::createBodyLayer);
            event.registerLayerDefinition(axolotl.LAYER_LOCATION, axolotl::createBodyLayer);
            event.registerLayerDefinition(ribbon.LAYER_LOCATION, ribbon::createBodyLayer);
            event.registerLayerDefinition(turtle.LAYER_LOCATION, turtle::createBodyLayer);
            event.registerLayerDefinition(swamp.LAYER_LOCATION, swamp::createBodyLayer);
            event.registerLayerDefinition(librarian.LAYER_LOCATION, librarian::createBodyLayer);
            event.registerLayerDefinition(cartographer.LAYER_LOCATION, cartographer::createBodyLayer);
            event.registerLayerDefinition(royalpads.LAYER_LOCATION, royalpads::createBodyLayer);
            event.registerLayerDefinition(royal1.LAYER_LOCATION, royal1::createBodyLayer);
            event.registerLayerDefinition(cono.LAYER_LOCATION, cono::createBodyLayer);
            event.registerLayerDefinition(foxtail1.LAYER_LOCATION, foxtail1::createBodyLayer);
            event.registerLayerDefinition(foxtail9.LAYER_LOCATION, foxtail9::createBodyLayer);
            event.registerLayerDefinition(flotador.LAYER_LOCATION, flotador::createBodyLayer);
            event.registerLayerDefinition(scara.LAYER_LOCATION, scara::createBodyLayer);
            event.registerLayerDefinition(teemohat.LAYER_LOCATION, teemohat::createBodyLayer);
            event.registerLayerDefinition(ornntrain.LAYER_LOCATION, ornntrain::createBodyLayer);
            event.registerLayerDefinition(cigarro.LAYER_LOCATION, cigarro::createBodyLayer);
            event.registerLayerDefinition(tojiworm.LAYER_LOCATION, tojiworm::createBodyLayer);
            event.registerLayerDefinition(chefhat.LAYER_LOCATION, chefhat::createBodyLayer);
            event.registerLayerDefinition(caja.LAYER_LOCATION, caja::createBodyLayer);
            event.registerLayerDefinition(caja2.LAYER_LOCATION, caja2::createBodyLayer);
            event.registerLayerDefinition(caja3.LAYER_LOCATION, caja3::createBodyLayer);
            event.registerLayerDefinition(crimson.LAYER_LOCATION, crimson::createBodyLayer);
            event.registerLayerDefinition(warped.LAYER_LOCATION, warped::createBodyLayer);
            event.registerLayerDefinition(mushroom.LAYER_LOCATION, mushroom::createBodyLayer);
            event.registerLayerDefinition(backchest.LAYER_LOCATION, backchest::createBodyLayer);
            event.registerLayerDefinition(magecape1.LAYER_LOCATION, magecape1::createBodyLayer);
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            net.minecraft.client.model.geom.EntityModelSet modelSet =
                    net.minecraft.client.Minecraft.getInstance().getEntityModels();

            event.enqueueWork(() -> {
                // Registrar ítems para que usen el MISMO renderer
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
                CuriosRendererRegistry.register(ModClothes.Mahoraga_aro.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Pto.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Gorro1.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Greenshirt.get(), ()-> new CosmeticBodyRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Choppa.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Axolotl.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Ribbon.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Turtle.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Swamp.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Librarian.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Cartographer.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Royalpads.get(), ()-> new CosmeticBodyRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Royal1.get(), ()-> new CosmeticBodyRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Cono.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Foxtail1.get(), ()-> new CosmeticBackRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Foxtail9.get(), ()-> new CosmeticBackRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Flotador.get(), ()-> new CosmeticBeltRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Scara.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Teemohat.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Ornntrain.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Cigarro.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Tojiworm.get(), ()-> new CosmeticBeltRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Chefhat.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Caja.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Caja2.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Caja3.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Crimson.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Warped.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Mushroom.get(), ()-> new CosmeticHeadRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Backchest.get(), ()-> new CosmeticBackRenderer(modelSet));
                CuriosRendererRegistry.register(ModClothes.Magecape1.get(), ()-> new CosmeticBackRenderer(modelSet));
            });
        }
    }
}