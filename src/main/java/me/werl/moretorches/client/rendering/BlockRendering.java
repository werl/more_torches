package me.werl.moretorches.client.rendering;

import me.werl.moretorches.data.EnumStickType;
import me.werl.moretorches.data.ModData;
import me.werl.moretorches.init.BlocksInit;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * Created by PeterLewis on 2016-08-10.
 */
public class BlockRendering {

    public static void init () {
        ModelLoader.setCustomStateMapper(BlocksInit.newTorch, new StateMap.Builder().build());
        //ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlocksInit.newTorch), 0,
                //new ModelResourceLocation(BlocksInit.newTorch.getRegistryName(), "inventory"));
        //ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlocksInit.newTorch), 1,
                //new ModelResourceLocation(ModData.ID + ":" + EnumStickType.JUNGLE.getName(), "inventory"));
        for (EnumStickType stick : EnumStickType.values()) {
            ModelResourceLocation location = new ModelResourceLocation(ModData.ID + ":" + stick.getName(), "inventory");
            Item item = Item.getItemFromBlock(BlocksInit.newTorch);
            ModelLoader.setCustomModelResourceLocation(item, stick.getMeta(), location);
        }
    }

}
