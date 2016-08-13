package me.werl.moretorches.init;

import me.werl.moretorches.blocks.BlockNewTorch;
import me.werl.moretorches.data.BlockData;

/**
 * Created by PeterLewis on 2016-08-06.
 */
public class BlocksInit {

    public static BlockNewTorch newTorch;

    public static void preInit() {
        newTorch = new BlockNewTorch(BlockData.NEW_TORCH_NAME);
        newTorch.init();
    }

    public static void postInit() {

    }

}
