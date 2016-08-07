package me.werl.moretorches.init;

import me.werl.moretorches.blocks.BlockNewTorch;

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

}
