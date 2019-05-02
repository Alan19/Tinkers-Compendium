package lance5057.tDefense.core.modifiers;

import lance5057.tDefense.core.library.modifiers.ModifierTDTrait;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class ModNightVision extends ArmorModifierTrait {

	public ModNightVision() {
		super("nightvision", 0x00ff00);
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 500));
	}
	
	@Override
	public boolean canApplyCustom(ItemStack stack) {

		if (!(stack.getItem() instanceof ArmorCore)) {
			return false;
		}
		
		//Helmet only
		if(((ArmorCore)stack.getItem()).getEquipmentSlot() != EntityEquipmentSlot.HEAD)
			return false;
		
		// not present yet, ok
		if (super.canApplyCustom(stack)) {
			return true;
		}
		// no max level
		else if (maxLevel == 0) {
			return false;
		}

		// already present, limit by level
		NBTTagCompound tag = TinkerUtil.getModifierTag(stack, identifier);

		return ModifierNBT.readTag(tag).level <= maxLevel;
	}
}