package me.werl.moretorches.data;

import net.minecraft.util.IStringSerializable;

/**
 * Created by PeterLewis on 2016-08-06.
 */
public enum EnumStickType1 implements IStringSerializable {
    BONE("bone"),
    JUNGLE("jungle");

    private final String name;

    EnumStickType1(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
