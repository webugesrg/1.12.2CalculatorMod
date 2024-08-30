package com.ani.newmod.init;

import java.util.ArrayList;
import java.util.List;

import com.ani.newmod.CalculatorScreen;
import com.ani.newmod.Main;
import com.ani.newmod.items.ItemBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;



public class ModItems
{
    public static final List<Item> ITEMS = new ArrayList<Item>();
//    public  static final Item LABOR_SHOVEL = new ItemBase("labor_shovel", Main.ITEM_TAB);
    public  static final Item CALCULATOR = new ItemBase("calculator", CreativeTabs.REDSTONE);
//    @SideOnly(Side.CLIENT)
//    @SubscribeEvent
//    public static void onModelReg(ModelRegistryEvent event)
//    {
//        ModelLoader.setCustomModelResourceLocation(CALCULATOR,0,new ModelResourceLocation(CALCULATOR.getRegistryName(),"inventory"));
//    }

}