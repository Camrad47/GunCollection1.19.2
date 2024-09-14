package concreteguy.guncollection.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.mrcrayfish.guns.client.render.gun.IOverrideModel;
import com.mrcrayfish.guns.client.util.RenderUtil;
import com.mrcrayfish.guns.common.AmmoContext;
import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.item.attachment.IAttachment;
import concreteguy.guncollection.client.SpecialModels;
import concreteguy.guncollection.core.registry.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class gc_ak_zastava_m70_gl_customModel implements IOverrideModel {


    @Override
    public void render(float partialTicks, ItemTransforms.TransformType transformType, ItemStack stack, ItemStack parent, @Nullable LivingEntity entity, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {
        poseStack.pushPose();
        poseStack.mulPose(Vector3f.XN.rotationDegrees(-15F));
        RenderUtil.renderModel(SpecialModels.GC_AK_ZASTAVA_M70_MAIN.getModel(), stack, poseStack, buffer, light, overlay);
        poseStack.popPose();

        poseStack.pushPose();
        poseStack.mulPose(Vector3f.XN.rotationDegrees(-15F));
        RenderUtil.renderModel(SpecialModels.GC_AK_ZASTAVA_M70_GL_SIGHT_UP.getModel(), stack, poseStack, buffer, light, overlay);
        poseStack.popPose();

        poseStack.pushPose();
        poseStack.mulPose(Vector3f.XN.rotationDegrees(-15F));
        RenderUtil.renderModel(SpecialModels.GC_AKM_BOLT.getModel(), stack, poseStack, buffer, light, overlay);
        poseStack.popPose();

        if (Gun.hasAmmo(stack)){
        poseStack.mulPose(Vector3f.XN.rotationDegrees(-15F));
        RenderUtil.renderModel(SpecialModels.GC_M70_RIFLE_GRENADE.getModel(), stack, poseStack, buffer, light, overlay);}
    }

    private double easeInOutBack(double x)
    {
        return 1 - Math.pow(1 - (2 * x), 4);
    }
}
