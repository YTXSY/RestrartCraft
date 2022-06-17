package com.ytxsy.restrart_craft.enchantments;

import com.ytxsy.restrart_craft.IdlFramework;
import com.ytxsy.restrart_craft.util.EntityUtil;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static net.minecraft.init.MobEffects.INSTANT_DAMAGE;
import static net.minecraft.init.MobEffects.SLOWNESS;


@Mod.EventBusSubscriber (modid = IdlFramework.MODID)
public class ModEnchantmentSTOP {
    public ModEnchantmentSTOP(String stop, Enchantment.Rarity common, EnumEnchantmentType armor, EntityEquipmentSlot[] armorSlots) {
    }
    @SubscribeEvent
    public static void onHit(LivingHurtEvent event)
    {
        EntityLivingBase hurtOne = event.getEntityLiving();
        World world = hurtOne.world;

        if (event.isCanceled() || world.isRemote) {
            return;
        }
        Entity trueSource = event.getSource().getTrueSource();
        if (trueSource instanceof EntityLivingBase)
        {
            EntityLivingBase attacker = (EntityLivingBase) trueSource;
            if (ModEnchantmentInit.STOP.getLevelOnCreature(attacker) > 0) {
                EntityUtil.ApplyBuff(hurtOne,SLOWNESS,1,1.5f);
                EntityUtil.ApplyBuff(hurtOne,INSTANT_DAMAGE,0,0.1f);
            }
            if (ModEnchantmentInit.STOP.getLevelOnCreature(attacker) > 1) {
                EntityUtil.ApplyBuff(hurtOne,SLOWNESS,2,2.5f);
                EntityUtil.ApplyBuff(hurtOne,INSTANT_DAMAGE,0,0.3f);
            }
            if (ModEnchantmentInit.STOP.getLevelOnCreature(attacker) > 2) {
                EntityUtil.ApplyBuff(hurtOne,SLOWNESS,4,5f);
                EntityUtil.ApplyBuff(hurtOne,INSTANT_DAMAGE,0,0.5f);
            }
            if (ModEnchantmentInit.STOP.getLevelOnCreature(attacker) > 3) {
                EntityUtil.ApplyBuff(hurtOne,SLOWNESS,8,10.5f);
                EntityUtil.ApplyBuff(hurtOne,INSTANT_DAMAGE,0,0.7f);
            }
            if (ModEnchantmentInit.STOP.getLevelOnCreature(attacker) > 4) {
                EntityUtil.ApplyBuff(hurtOne,SLOWNESS,16,15f);
                EntityUtil.ApplyBuff(hurtOne,INSTANT_DAMAGE,1,0.1f);
            }
            if (ModEnchantmentInit.STOP.getLevelOnCreature(attacker) > 5) {
                EntityUtil.ApplyBuff(hurtOne,SLOWNESS,32,3f);
                EntityUtil.ApplyBuff(hurtOne,INSTANT_DAMAGE,1,0.3f);
            }
        }
    }

}
