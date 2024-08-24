package com.ani.newmod.util.handlers;

import com.ani.newmod.init.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.ani.newmod.init.ModItems.CALCULATOR;

public class ItemTab extends CreativeTabs
{

    public ItemTab( ) {
        super("item_tab" );
    }

    @Override
    public ItemStack getTabIconItem() {

//        return new ItemStack(ModItems.LABOR_SHOVEL);
        return new ItemStack(CALCULATOR);
    }


}