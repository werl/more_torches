package me.werl.moretorches.init;

import me.werl.moretorches.tileentity.TileTorch;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by PeterLewis on 2016-08-08.
 */
public class TileEntityInit {

    public static void init () {
        GameRegistry.registerTileEntity(TileTorch.class, "tileTorch");
    }

}
