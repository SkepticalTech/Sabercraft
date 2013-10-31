package sabercraft;

import java.util.Collections;
import java.util.List;

import net.machinemuse.api.IModularItem;
import net.machinemuse.powersuits.common.ModularPowersuits;
import net.minecraft.item.Item;
import sabercraft.lib.Reference;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class SabercraftMod {
	
	
	List<IModularItem> TOOLONLY = Collections.singletonList((IModularItem) ModularPowersuits.powerTool);

}
