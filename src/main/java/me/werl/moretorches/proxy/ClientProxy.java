package me.werl.moretorches.proxy;

import me.werl.moretorches.client.rendering.BlockRendering;

/**
 * Created by PeterLewis on 2016-08-06.
 */
public class ClientProxy implements IMainProxy{

    @Override
    public void registerRenderer() {
        BlockRendering.init();
    }

}
