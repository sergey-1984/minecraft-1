package com.mrcrayfish.tutorial;

import com.mrcrayfish.tutorial.handlers.BlockHandler;
import com.mrcrayfish.tutorial.handlers.EmptyBlockRightClickHandler;
import com.mrcrayfish.tutorial.handlers.MinecartHandler;
import com.mrcrayfish.tutorial.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSION)
public class Tutorial {
	
	@Instance(Reference.MOD_ID)
	public static Tutorial instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new MinecartHandler());
		MinecraftForge.EVENT_BUS.register(new BlockHandler());
		MinecraftForge.EVENT_BUS.register(new EmptyBlockRightClickHandler());
		proxy.init();
	}	
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}	
}
