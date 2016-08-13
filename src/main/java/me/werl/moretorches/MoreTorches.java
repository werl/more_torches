package me.werl.moretorches;

import me.werl.moretorches.data.ModData;
import me.werl.moretorches.init.BlocksInit;
import me.werl.moretorches.init.TileEntityInit;
import me.werl.moretorches.proxy.IMainProxy;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModData.ID, version = ModData.VERSION, name = "More Torches")
public class MoreTorches {

    @Mod.Instance(ModData.ID)
    public static MoreTorches mod;

    @SidedProxy(clientSide = ModData.PROXY_CLIENT, serverSide = ModData.PROXY_SERVER)
    public static IMainProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        BlocksInit.preInit();
        proxy.registerRenderer();

        TileEntityInit.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
