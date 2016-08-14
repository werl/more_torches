package me.werl.moretorches.data;

import net.minecraft.util.IStringSerializable;
import org.lwjgl.Sys;

/**
 * Created by PeterLewis on 2016-08-06.
 */
public enum EnumStickType implements IStringSerializable {
    BONE(0, "bone"),
    JUNGLE(1, "jungle"),
    CAKE(2,"cake");

    private final String name;
    private final int meta;

    EnumStickType (int meta, String name) {
        this.name = name;
        this.meta = meta;
    }

    public int getMeta () {
        return meta;
    }

    @Override
    public String getName () {
        return name.toLowerCase();
    }

    @Override
    public String toString () {
        return name;
    }
}
