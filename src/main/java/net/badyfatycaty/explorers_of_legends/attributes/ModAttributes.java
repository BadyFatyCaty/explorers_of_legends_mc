package net.badyfatycaty.explorers_of_legends.attributes;

import net.badyfatycaty.explorers_of_legends.attributes.crit.CritDamage;
import net.badyfatycaty.explorers_of_legends.attributes.crit.CritRate;
import net.badyfatycaty.explorers_of_legends.attributes.element.earth.EarthDamage;
import net.badyfatycaty.explorers_of_legends.attributes.element.earth.EarthResistance;
import net.badyfatycaty.explorers_of_legends.attributes.element.fire.FireDamage;
import net.badyfatycaty.explorers_of_legends.attributes.element.fire.FireResistance;
import net.badyfatycaty.explorers_of_legends.attributes.element.nature.NatureDamage;
import net.badyfatycaty.explorers_of_legends.attributes.element.nature.NatureResistance;
import net.badyfatycaty.explorers_of_legends.attributes.element.water.WaterDamage;
import net.badyfatycaty.explorers_of_legends.attributes.element.water.WaterResistance;
import net.badyfatycaty.explorers_of_legends.attributes.element.air.AirDamage;
import net.badyfatycaty.explorers_of_legends.attributes.element.air.AirResistance;
import net.badyfatycaty.explorers_of_legends.attributes.magic.CastSpeed;
import net.badyfatycaty.explorers_of_legends.attributes.magic.MagicDamage;
import net.badyfatycaty.explorers_of_legends.attributes.magic.MagicResistance;
import net.badyfatycaty.explorers_of_legends.attributes.mana.Mana;
import net.badyfatycaty.explorers_of_legends.attributes.mana.ManaRegen;
import net.badyfatycaty.explorers_of_legends.attributes.mana.MaxMana;
import net.badyfatycaty.explorers_of_legends.attributes.physical_dmg.blunt.BluntDamage;
import net.badyfatycaty.explorers_of_legends.attributes.physical_dmg.blunt.BluntResistance;
import net.badyfatycaty.explorers_of_legends.attributes.physical_dmg.piercing.PiercingDamage;
import net.badyfatycaty.explorers_of_legends.attributes.physical_dmg.piercing.PiercingResistance;
import net.badyfatycaty.explorers_of_legends.attributes.physical_dmg.slicing.SlicingDamage;
import net.badyfatycaty.explorers_of_legends.attributes.physical_dmg.slicing.SlicingResistance;
import net.badyfatycaty.explorers_of_legends.attributes.ranged.DrawSpeed;
import net.badyfatycaty.explorers_of_legends.attributes.ranged.ProjectileDamage;
import net.badyfatycaty.explorers_of_legends.attributes.ranged.ProjectileResistance;
import net.badyfatycaty.explorers_of_legends.attributes.spirit.SpectralDamage;
import net.badyfatycaty.explorers_of_legends.attributes.spirit.SpectralResistance;
import net.badyfatycaty.explorers_of_legends.attributes.spirit.entity.SpiritAttackSpeed;
import net.badyfatycaty.explorers_of_legends.attributes.spirit.entity.SpiritDamage;
import net.badyfatycaty.explorers_of_legends.attributes.spirit.entity.SpiritHealth;
import net.badyfatycaty.explorers_of_legends.attributes.spirit.entity.SpiritMovementSpeed;
import net.badyfatycaty.explorers_of_legends.attributes.stamina.MaxStamina;
import net.badyfatycaty.explorers_of_legends.attributes.stamina.Stamina;
import net.badyfatycaty.explorers_of_legends.attributes.stamina.StaminaRegen;
import net.neoforged.bus.api.IEventBus;
import org.apache.logging.log4j.util.Cast;

public class ModAttributes {
    public static void registerAllAttributes(IEventBus modEventBus) {
        CritDamage.REGISTRY.register(modEventBus);
        CritRate.REGISTRY.register(modEventBus);

        EarthDamage.REGISTRY.register(modEventBus);
        EarthResistance.REGISTRY.register(modEventBus);
        FireDamage.REGISTRY.register(modEventBus);
        FireResistance.REGISTRY.register(modEventBus);
        NatureDamage.REGISTRY.register(modEventBus);
        NatureResistance.REGISTRY.register(modEventBus);
        WaterDamage.REGISTRY.register(modEventBus);
        WaterResistance.REGISTRY.register(modEventBus);
        AirDamage.REGISTRY.register(modEventBus);
        AirResistance.REGISTRY.register(modEventBus);

        CastSpeed.REGISTRY.register(modEventBus);
        MagicDamage.REGISTRY.register(modEventBus);
        MagicResistance.REGISTRY.register(modEventBus);

        Mana.REGISTRY.register(modEventBus);
        MaxMana.REGISTRY.register(modEventBus);
        ManaRegen.REGISTRY.register(modEventBus);

        DrawSpeed.REGISTRY.register(modEventBus);
        ProjectileDamage.REGISTRY.register(modEventBus);
        ProjectileResistance.REGISTRY.register(modEventBus);

        SpiritAttackSpeed.REGISTRY.register(modEventBus);
        SpiritDamage.REGISTRY.register(modEventBus);
        SpiritHealth.REGISTRY.register(modEventBus);
        SpiritMovementSpeed.REGISTRY.register(modEventBus);

        SpectralDamage.REGISTRY.register(modEventBus);
        SpectralResistance.REGISTRY.register(modEventBus);

        Stamina.REGISTRY.register(modEventBus);
        MaxStamina.REGISTRY.register(modEventBus);
        StaminaRegen.REGISTRY.register(modEventBus);

        HealthRegen.REGISTRY.register(modEventBus);

        BluntDamage.REGISTRY.register(modEventBus);
        BluntResistance.REGISTRY.register(modEventBus);
        PiercingDamage.REGISTRY.register(modEventBus);
        PiercingResistance.REGISTRY.register(modEventBus);
        SlicingDamage.REGISTRY.register(modEventBus);
        SlicingResistance.REGISTRY.register(modEventBus);
    }

}
