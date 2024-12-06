package com.servent.redage.enitity.custom;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;

public class RedSlime extends Slime {
    public RedSlime(EntityType<? extends Slime> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes();
    }

    /* この関数を使うと別のダメージボイスを再生できる
//    @Override
//    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
//        return SoundEvents.MAGMA_CUBE_HURT;
//    }
*/

    @Override
    protected ParticleOptions getParticleType() {
        return ParticleTypes.LAVA;
    }
}
