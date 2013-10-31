package sabercraft.lib;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;

public class ToolHelper {
	public static Random random = new Random();

	// Handle weapon attack, returns false if nothing happens
	public static boolean onLeftClickEntity(ItemStack stack, EntityLivingBase player,
			Entity entity, int basedamage) {
		if (entity.canAttackWithItem() && stack.hasTagCompound()) {
			NBTTagCompound tags = stack.getTagCompound();
			// charge = durability
			int weaponcharge = tags.getInteger("charge");
			if (weaponcharge > 0) {
				int damage = basedamage;
				float knockback = 0;
				// Is player sprinting
				if (player.isSprinting()) {
					knockback++;
				}
				// TODO: damage modifiers
				if (damage > 0) {
					// Check critical hit
					boolean critical = player.fallDistance > 0.0F && !player.onGround
							&& !player.isOnLadder() && !player.isInWater()
							&& !player.isPotionActive(Potion.blindness)
							&& player.ridingEntity == null && entity instanceof EntityLivingBase;
					if (critical) {
						damage += random.nextInt(damage / 2 + 2);
					}

					boolean causedDamage;
					// Damage the entity
					if (player instanceof EntityPlayer) {
						causedDamage = entity.attackEntityFrom(
								DamageSource.causePlayerDamage((EntityPlayer) player), damage);
						if (critical) {
							((EntityPlayer) player).onCriticalHit(entity);
						}
					}
					else {
						causedDamage = entity.attackEntityFrom(DamageSource.causeMobDamage(player),
								damage);
					}

					// did we inflict damage
					if (entity instanceof EntityPlayer) {
						((EntityPlayer) player).addExhaustion(0.3F);
					}
					if (causedDamage) {
						dischargeTool(stack, 1, player);
						return true;
					}

				}
			}
		}
		return false;
	}

	public static void dischargeTool(ItemStack stack, int amount, EntityLivingBase entity) {
		if (stack.hasTagCompound()) {
			NBTTagCompound tags = stack.getTagCompound();
			int charge = tags.getInteger("charge") - amount;
			if (charge <= 0) {
				charge = 0;
			}
			tags.setInteger("charge", charge);
		}
	}
	
	public void toggleSaber(ItemStack stack){
		
	}
	
	//Handle player dropping the tool
	public static void onDropTool(ItemStack stack, EntityPlayer player){
		if(stack.getItem().itemID == SabercraftIds.lightSaberId){
			
		}
	}

}
