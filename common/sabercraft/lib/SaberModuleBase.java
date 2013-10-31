package sabercraft.lib;

import java.util.List;

import net.machinemuse.api.IModularItem;
import net.machinemuse.general.gui.MuseIcon;
import net.machinemuse.powersuits.powermodule.PowerModuleBase;
import net.minecraft.client.renderer.texture.IconRegister;

//Used to change some of the paths to fit this mod
public abstract class SaberModuleBase extends PowerModuleBase {

	public SaberModuleBase(String name, List<IModularItem> validItems){
		super(name, validItems);
	}
	
	public SaberModuleBase(List<IModularItem> validItems){
		super(validItems);
	}
	
	@Override
	public void registerIcon(IconRegister register) {
		if (getTextureFile() != null) {
			this.icon = register.registerIcon(Reference.MOD_PREFIX + getTextureFile());
		}
	}
}
