package enviromine.core.proxies;

import enviromine.gui.UpdateNotification;
import enviromine.handlers.CamelPackRefillHandler;
import enviromine.handlers.EM_EventManager;
import enviromine.handlers.EM_ServerScheduledTickHandler;

import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class EM_CommonProxy
{
	public boolean isClient()
	{
		return false;
	}
	
	public boolean isOpenToLAN()
	{
		return false;
	}
	
	public void registerTickHandlers()
	{
		FMLCommonHandler.instance().bus().register(new EM_ServerScheduledTickHandler());
	}
	
	public void registerEventHandlers()
	{
		MinecraftForge.EVENT_BUS.register(new EM_EventManager());
		FMLCommonHandler.instance().bus().register(new UpdateNotification());
		
		CamelPackRefillHandler tmp = new CamelPackRefillHandler();
		CraftingManager.getInstance().getRecipeList().add(tmp);
		FMLCommonHandler.instance().bus().register(tmp);
	}
	
	public void preInit(FMLPreInitializationEvent event)
	{
		
	}
	
	public void init(FMLInitializationEvent event)
	{
		
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
