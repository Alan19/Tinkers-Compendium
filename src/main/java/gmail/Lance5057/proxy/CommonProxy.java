package gmail.Lance5057.proxy;

import gmail.Lance5057.com.mod_TinkersDefense;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {

        // Client stuff
        public void registerRenderers() {
                // Nothing here as the server doesn't render graphics or entities!
        }
        
        public void registerTileEntitySpecialRenderer()
        {
        	
        }
        
        public ModelBiped getArmorModel(int id)
        { 
        	return null;
        }

        public World getClientWorld()
        {
        return null;
        }

		@Override
		public Object getServerGuiElement(int ID, EntityPlayer player,
				World world, int x, int y, int z) {
			// Hooray, no 'magic' numbers - we know exactly which Gui this refers to
			if (ID == mod_TinkersDefense.GUI_ITEM_INV)
			{
			// Use the player's held item to create the inventory
			//return new Container_CrestMount(player.inventory, new TileEntity_CrestMount());
			}
			return null;
		}

		@Override
		public Object getClientGuiElement(int ID, EntityPlayer player,
				World world, int x, int y, int z) {
			if (ID == mod_TinkersDefense.GUI_ITEM_INV)
			{
			// We have to cast the new container as our custom class
			// and pass in currently held item for the inventory
			//return new Gui_CrestMount((Container_CrestMount) new Container_CrestMount(player.inventory, new TileEntity_CrestMount()));
			}
			return null;
			}
		} 