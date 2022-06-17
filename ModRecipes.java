package com.ytxsy.restrart_craft.init;

import com.ytxsy.restrart_craft.item.ModItems;
import com.ytxsy.restrart_craft.util.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ModRecipes {
	
	public static void Init() {
		//Only smelting recipes
		GameRegistry.addSmelting(
				new ItemStack(Items.IRON_INGOT),
				new ItemStack(ModItems.RESTRART_INGOT),
				0.07f);
		GameRegistry.addSmelting(
				new ItemStack(Items.STICK),
				new ItemStack(Items.BLAZE_ROD),
				0.5f);
		GameRegistry.addSmelting(
				new ItemStack(Blocks.WOOL, 1, 32767),
				new ItemStack(Blocks.WOOL, 1, 1),
				0f);
		GameRegistry.addSmelting(
				new ItemStack(Blocks.GLASS, 1, 32767),
				new ItemStack(Blocks.GLASS, 1, 1),
				0f);
		//GameRegistry.addSmelting(
		//      new ItemStack(种类.ID, 1, meta),
		//		new ItemStack(种类.ID, 1, meta),
		//		经验f);
	}
	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> evt) {
		IForgeRegistry<IRecipe> r = evt.getRegistry();
		//Example
		//r.register(new GobletFill().setRegistryName(new ResourceLocation(Reference.MOD_ID, "goblet_fill")));
	}
}