package com.servent.redage.enitity.renderer;

import com.servent.redage.RedAge;
import com.servent.redage.enitity.custom.RedSlime;
import com.servent.redage.enitity.model.RedSlimeModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RedSlimeRenderer extends MobRenderer<RedSlime, RedSlimeModel<RedSlime>> {
    private static final ResourceLocation RED_SLIME_LOCATION = new ResourceLocation(RedAge.MOD_ID, "textures/entity/red_slime.png");

    public RedSlimeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RedSlimeModel<>(pContext.bakeLayer(RedSlimeModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(RedSlime redSlime) {
        return RED_SLIME_LOCATION;
    }
}
