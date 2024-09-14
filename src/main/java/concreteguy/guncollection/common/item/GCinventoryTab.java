package concreteguy.guncollection.common.item;

import concreteguy.guncollection.core.registry.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import com.mrcrayfish.guns.item.GunItem;

public class GCinventoryTab {
    public static final CreativeModeTab GUNCOLLECTIONTAB = new CreativeModeTab("gcmodtab") {
        @Override
        public ItemStack makeIcon() {
            ItemStack stack = new ItemStack(ItemRegistry.GC_GUNPOWDER_T2.get());
            return stack;
        }



    };



}
