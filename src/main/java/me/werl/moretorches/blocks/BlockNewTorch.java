package me.werl.moretorches.blocks;

import me.werl.moretorches.init.InitializableBlock;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by PeterLewis on 2016-08-05.
 */
public class BlockNewTorch  extends BlockTorch implements InitializableBlock{

    public BlockNewTorch (String uName) {
        super();
        this.setHardness(0.0f);
        this.setLightLevel(0.9375F);
        this.setSoundType(SoundType.WOOD);
        this.setCreativeTab(CreativeTabs.DECORATIONS);

        this.setRegistryName(uName);
        this.setUnlocalizedName(getRegistryName().toString());
        System.out.println(this.getRegistryName());
    }

    public boolean init(){
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this).setRegistryName(getRegistryName()));
        return true;
    }

}
