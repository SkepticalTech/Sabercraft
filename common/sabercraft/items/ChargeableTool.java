package sabercraft.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public abstract class ChargeableTool extends Item {

	private int basecharge;

	public ChargeableTool(int id, int basecharge) {
		super(id);
		setHasSubtypes(true);
		setMaxStackSize(1);
		this.basecharge = basecharge;
		canRepair = false;
	}

	public int getBaseCharge() {
		return basecharge;
	}

	@Override
	public int getDisplayDamage(ItemStack stack) {
		NBTTagCompound tags = stack.getTagCompound();
		if (tags != null && tags.hasKey("charge")) {
			int charge = tags.getInteger("charge");
			if (charge > 0)
				return getBaseCharge() - charge;
		}
		return 0;
	}

	// Set the starting NBT value on crafting
	@Override
	public void onCreated(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		NBTTagCompound tags = par1ItemStack.getTagCompound();
		tags.setInteger("charge", basecharge);
	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World,
			Entity par3Entity, int par4, boolean par5) {
		
	}

}
