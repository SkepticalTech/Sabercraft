package sabercraft.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sabercraft.lib.ToolHelper;
import net.machinemuse.api.IModularItem;
import net.machinemuse.numina.item.ModeChangingItem;
import net.machinemuse.powersuits.item.ItemElectricTool;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class Lightsaber extends ItemElectricTool implements IModularItem{

	/*
	 * NBT attributes: color: int, matches wool IDs inherits charge from
	 * ChargeableTool activated: boolean, whether blade is extended
	 */

	private int weaponDamage;

	public Lightsaber(int id) {
		super(id, 0, EnumToolMaterial.EMERALD, null);
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName("lightsaber");
		setMaxDamage(0);
		weaponDamage = Math.round(5.0F + EnumToolMaterial.EMERALD.getDamageVsEntity());
	}

	// Blocking action on right click
	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.block;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getRenderPasses(int metadata) {
		return 2;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(ItemStack stack, int renderPass) {
		if (renderPass == 0) {

		}
		else if(renderPass == 1){
			//If being held
			//stack.
		}
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		ToolHelper.onLeftClickEntity(stack, player, entity, weaponDamage);
		return true;
	}

	// Slow the animation down?
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 96000;
	}

	@Override
	public void onCreated(ItemStack stack, World par2World, EntityPlayer par3EntityPlayer) {
		super.onCreated(stack, par2World, par3EntityPlayer);
		NBTTagCompound tags = stack.getTagCompound();
		tags.setBoolean("activated", false);
		// Grab the damage and put it in an NBT tag, then set the damage back to
		// 0
		tags.setInteger("color", stack.getItemDamage());
		stack.setItemDamage(0);
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {

		return true;
	}

}
