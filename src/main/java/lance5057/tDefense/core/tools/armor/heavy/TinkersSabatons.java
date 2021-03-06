package lance5057.tDefense.core.tools.armor.heavy;

import java.util.List;

import lance5057.tDefense.core.library.ArmorNBT;
import lance5057.tDefense.core.library.ArmorTags;
import lance5057.tDefense.core.library.ArmorTextureBuilder;
import lance5057.tDefense.core.materials.stats.ArmorMaterialStats;
import lance5057.tDefense.core.materials.stats.ChestMaterialStats;
import lance5057.tDefense.core.materials.stats.FabricMaterialStats;
import lance5057.tDefense.core.materials.stats.FeetMaterialStats;
import lance5057.tDefense.core.parts.TDParts;
import lance5057.tDefense.core.tools.armor.renderers.ArmorRenderer;
import lance5057.tDefense.core.tools.armor.renderers.heavy.ModelTinkersSabatons;
import lance5057.tDefense.core.tools.bases.ArmorCore;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.utils.TagUtil;

public class TinkersSabatons extends ArmorCore {
	public TinkersSabatons() {
		super(EntityEquipmentSlot.FEET,new PartMaterialType(TDParts.armorPlate, FeetMaterialStats.TYPE),
				new PartMaterialType(TDParts.armorPlate, FeetMaterialStats.TYPE),
				PartMaterialType.handle(TDParts.filigree),
				PartMaterialType.extra(TDParts.rivets),
				new PartMaterialType(TDParts.fabric, FabricMaterialStats.TYPE));
		setUnlocalizedName("tinkerssabatons");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public NBTTagCompound setupTexture(List<Material> materials)
	{
		NBTTagCompound base = new NBTTagCompound();

		ResourceLocation rc = ArmorTextureBuilder.createArmorTexture("sabatons", new String[] { "plates", "caps", "trim", "rivets", "soles" }, materials);

		if (rc != null)
		{
			base.setString(ArmorTags.TexLoc, rc.toString());
			return base;
		}
		return null;
	}
	

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default)
	{
		return new ModelTinkersSabatons(itemStack);
	}

	@Override
	public NBTTagCompound buildTag(List<Material> materials) {
		ArmorNBT data = buildDefaultTag(materials);
		return data.get();
	}

	@Override
	public EntityEquipmentSlot getArmorSlot(ItemStack stack, EntityEquipmentSlot armorType) {
		return EntityEquipmentSlot.FEET;
	}

	@Override
	public float damagePotential()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double attackSpeed()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	protected ArmorNBT buildDefaultTag(List<Material> materials) {
		ArmorNBT data = new ArmorNBT();

		ArmorMaterialStats head2 = materials.get(0).getStatsOrUnknown(FeetMaterialStats.TYPE);
		ArmorMaterialStats head = materials.get(1).getStatsOrUnknown(FeetMaterialStats.TYPE);
		HandleMaterialStats handle = materials.get(2).getStatsOrUnknown(MaterialTypes.HANDLE);
		ExtraMaterialStats extra = materials.get(3).getStatsOrUnknown(MaterialTypes.EXTRA);
		// start with head
		data.head(head, head2);
		data.extra(extra);
		data.handle(handle);

		data.modifiers = 5;

		return data;
	}
}
