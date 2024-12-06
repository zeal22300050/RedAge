package com.servent.redage.enitity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.servent.redage.RedAge;
import com.servent.redage.enitity.custom.RedSlime;
import com.servent.redage.enitity.model.RedSlimeModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.Slime;
import org.jetbrains.annotations.Nullable;

public class RedSlimeRenderer extends MobRenderer<RedSlime, RedSlimeModel<RedSlime>> {
    private static final ResourceLocation RED_SLIME_LOCATION = new ResourceLocation(RedAge.MOD_ID, "textures/entity/red_slime.png");

    public RedSlimeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RedSlimeModel<>(pContext.bakeLayer(RedSlimeModel.LAYER_LOCATION)), 0.25f);
    }

    public void render(RedSlime pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        this.shadowRadius = 0.25F * (float)pEntity.getSize();
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    protected void scale(RedSlime pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
        float $$3 = 0.999F;
        pPoseStack.scale(0.999F, 0.999F, 0.999F);
        pPoseStack.translate(0.0F, 0.001F, 0.0F);
        float $$4 = (float)pLivingEntity.getSize();
        float $$5 = Mth.lerp(pPartialTickTime, pLivingEntity.oSquish, pLivingEntity.squish) / ($$4 * 0.5F + 1.0F);
        float $$6 = 1.0F / ($$5 + 1.0F);
        pPoseStack.scale($$6 * $$4, 1.0F / $$6 * $$4, $$6 * $$4);
    }

    @Override
    protected @Nullable RenderType getRenderType(RedSlime pLivingEntity, boolean pBodyVisible, boolean pTranslucent, boolean pGlowing) {
        ResourceLocation resourceLocation = this.getTextureLocation(pLivingEntity);
        return RenderType.entityTranslucent(resourceLocation, true);
    }

    @Override
    public ResourceLocation getTextureLocation(RedSlime redSlime) {
        return RED_SLIME_LOCATION;
    }
}
