package me.werl.moretorches.proxy;

import me.werl.moretorches.init.BlocksInit;

/**
 * Created by PeterLewis on 2016-08-06.
 */
public class ClientProxy implements IMainProxy{

    @Override
    public void registerRenderer() {
        BlocksInit.registerBlockRenderer();
    }

}
