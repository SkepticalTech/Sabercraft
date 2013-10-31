package sabercraft.modules;

import java.util.List;

import sabercraft.lib.SaberModuleBase;
import net.machinemuse.api.IModularItem;
import net.machinemuse.powersuits.powermodule.PowerModule;
import net.machinemuse.powersuits.powermodule.PowerModuleBase;
import net.machinemuse.utils.MuseCommonStrings;
import net.machinemuse.utils.MuseItemUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class SaberCrystal extends SaberModuleBase {

	public static final String MODULE_SABERCRYSTAL = "Sabercrystal";

	public SaberCrystal(List<IModularItem> validItems) {
		super(validItems);
		addInstallCost(new ItemStack(Item.diamond, 1));
	}

	@Override
    public String getCategory() {
        return MuseCommonStrings.CATEGORY_WEAPON;
    }
	
	@Override
	public String getDataName() {
		return MODULE_SABERCRYSTAL;
	}

	@Override
	public String getLocalizedName() {
		return StatCollector.translateToLocal("module.plasmaCannon.name");
	}
	
	@Override
    public String getDescription() {
        return "A sabercrystal (TODO: more info).";
    }

	@Override
	public String getTextureFile() {
		return "sabercrystal";
	}
	
	

}
