package concreteguy.guncollection.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrcrayfish.guns.client.GunModel;
import com.mrcrayfish.guns.client.render.gun.IOverrideModel;
import com.mrcrayfish.guns.client.util.RenderUtil;
import concreteguy.guncollection.client.SpecialModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class gc_ar15_colt_9mm_smg_customModel implements IOverrideModel {

    @SuppressWarnings("resource")
    @Override
    public void render(float partialTicks, ItemTransforms.TransformType transformType, ItemStack stack, ItemStack parent, @Nullable LivingEntity entity, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {
        BakedModel bakedModel = SpecialModels.GC_AR15_COLT_9MM_SMG_MAIN.getModel();
        Minecraft.getInstance().getItemRenderer().render(stack, ItemTransforms.TransformType.NONE, false, poseStack, buffer, light, overlay, GunModel.wrap(bakedModel));

        float cooldown = 0F;
        if(entity != null && entity.equals(Minecraft.getInstance().player))
        {
            ItemCooldowns tracker = Minecraft.getInstance().player.getCooldowns();
            cooldown = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
            cooldown = (float) easeInOutBack(cooldown);
        }

        poseStack.pushPose();
        poseStack.translate(0, -5.8 * 0.0625, 0);
        poseStack.translate(0, 0, cooldown/8);
        poseStack.translate(0, 5.8 * 0.0625, 0);
        RenderUtil.renderModel(SpecialModels.GC_AR15_BOLT.getModel(), transformType, null, stack, parent, poseStack, buffer, light, overlay);
        poseStack.popPose();
    }

    /**
     * Easing function based on code from https://easings.net/#easeInOutBack
     */
    private double easeInOutBack(double x)
    {
        return 1 - Math.pow(1 - (2 * x), 4);
    }
}