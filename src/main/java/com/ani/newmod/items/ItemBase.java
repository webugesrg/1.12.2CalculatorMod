package com.ani.newmod.items;
import com.ani.newmod.CalculatorScreen;
import  com.ani.newmod.Main;
import  com.ani.newmod.init.ModItems;
import  com.ani.newmod.util.IHasModel;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBase extends  Item implements IHasModel
{
    public ItemBase(String name,CreativeTabs tab)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
        ModItems.ITEMS.add(this);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        //
        if (!world.isRemote) {
            //
            return new ActionResult<>(EnumActionResult.PASS, player.getHeldItem(hand));
        }

        //
        Minecraft.getMinecraft().displayGuiScreen(new CalculatorScreen());

        // 返回成功并保留物品在玩家手中
        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this,0,"inventory");
    }
}
