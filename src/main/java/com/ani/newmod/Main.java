package com.ani.newmod;
import com.ani.newmod.proxy.CommonProxy;
import com.ani.newmod.util.Reference;
import com.ani.newmod.util.handlers.ItemTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.Mod_ID,name = Reference.NAME,version = Reference.VERSION)

public class Main
{
    @Mod.Instance
    public static Main instance;
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS,serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void PreInit(FMLPreInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public static void Init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public static void PostInit(FMLPostInitializationEvent event)
    {

    }
    public static CreativeTabs ITEM_TAB = new ItemTab( );

}
