package me.werl.moretorches.init;

import me.werl.moretorches.blocks.BlockNewTorch;
import me.werl.moretorches.data.ModData;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * Created by PeterLewis on 2016-08-06.
 */
public class BlocksInit {

    public static BlockNewTorch boneTorch;

    public static void preInit() {
        boneTorch = new BlockNewTorch("bone_torch");
    }

    public static void init() {
        boneTorch.init();
    }

    public static void postInit() {

    }

    public static void registerBlockRenderer() {
        ModelLoader.setCustomStateMapper(boneTorch, new StateMap.Builder().build());
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(boneTorch), 0,
                new ModelResourceLocation(ModData.ID + ":" + boneTorch.getRegistryName(), "inventory"));
    }

}
