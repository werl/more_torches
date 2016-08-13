package me.werl.moretorches.items.blocks;

import me.werl.moretorches.data.EnumStickType;
import me.werl.moretorches.data.ModData;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by PeterLewis on 2016-08-08.
 */
public class ItemNewTorch extends ItemBlock {

    public ItemNewTorch (Block block) {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public static EnumStickType getStickType (ItemStack stackIn) {
        if (stackIn != null && stackIn.getItem() instanceof ItemNewTorch) {
            return EnumStickType.values()[stackIn.getItemDamage()];
        }
        return EnumStickType.BONE;
    }

    @Override
    public String getUnlocalizedName (ItemStack stack) {
        return ModData.ID + ":" + EnumStickType.values()[stack.getItemDamage()].getName();
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems (Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (int i = 0; i < EnumStickType.values().length; ++i)
        {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }
}
