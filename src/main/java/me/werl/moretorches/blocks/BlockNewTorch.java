package me.werl.moretorches.blocks;

import me.werl.moretorches.data.EnumStickType;
import me.werl.moretorches.init.InitializableBlock;
import me.werl.moretorches.items.blocks.ItemNewTorch;
import me.werl.moretorches.tileentity.TileTorch;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PeterLewis on 2016-08-05.
 */
public class BlockNewTorch  extends BlockTorch implements InitializableBlock, ITileEntityProvider {

    public static final IProperty<EnumStickType> STICKTYPE = PropertyEnum.create("sticktype", EnumStickType.class);

    public BlockNewTorch (String uName) {
        super();
        this.setDefaultState(this.blockState.getBaseState().withProperty(STICKTYPE, EnumStickType.BONE));
        this.setHardness(0.0f);
        this.setLightLevel(0.9375F);
        this.setSoundType(SoundType.WOOD);
        this.setCreativeTab(CreativeTabs.DECORATIONS);

        this.setRegistryName(uName);
        this.setUnlocalizedName(getRegistryName().toString());
    }

    public boolean init(){
        GameRegistry.register(this);
        GameRegistry.register(new ItemNewTorch(this).setRegistryName(getRegistryName().toString()));
        return true;
    }

    @Override
    public List<ItemStack> getDrops (IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        return new ArrayList<ItemStack>();
    }

    @Override
    public boolean hasTileEntity (IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity (World worldIn, int meta) {
        return new TileTorch();
    }

    public TileTorch getTileEntity (IBlockAccess world, BlockPos pos) {
        return (TileTorch)world.getTileEntity(pos);
    }

    public EnumStickType getStickType (IBlockAccess world, BlockPos pos) {
        final TileTorch tileEntity = (TileTorch) world.getTileEntity(pos);
        return tileEntity != null ? tileEntity.getStick() : EnumStickType.BONE ;
    }

    public void setStickType(IBlockAccess world, BlockPos pos, EnumStickType stickType) {
        final TileTorch tileEntity = (TileTorch) world.getTileEntity(pos);
        if (tileEntity != null) {
            tileEntity.setStick(stickType);
        }
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        setStickType(worldIn, pos, ItemNewTorch.getStickType(stack));
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state.withProperty(STICKTYPE, getStickType(worldIn, pos));
    }

    @Override
    public void breakBlock (World worldIn, BlockPos pos, IBlockState state)
    {
        Block.spawnAsEntity(worldIn, pos, new ItemStack(this, 1, this.getStickType(worldIn, pos).getMeta()));
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public boolean eventReceived (IBlockState state, World worldIn, BlockPos pos, int id, int param)
    {
        super.eventReceived(state, worldIn, pos, id, param);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity != null && tileentity.receiveClientEvent(id, param);
    }

    protected BlockStateContainer createBlockState ()
    {
        return new BlockStateContainer(this, FACING, STICKTYPE);
    }
}
