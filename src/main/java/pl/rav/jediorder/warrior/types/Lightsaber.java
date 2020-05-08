package pl.rav.jediorder.warrior.types;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Lightsaber {
    SITH_LIGHTSABER("Sith lightsaber"),
    DOUBLE_BLADED_LIGHTSABER("Double-bladed lightsaber"),
    DOUBLE_BLADED_SPINNING_LIGHTSABER("Double-bladed spinning lightsaber"),
    SPLIT_SABER("Split saber"),
    DUAL_PHASE_LIGHTSABER("Dual-phase lightsaber"),
    BROADSABER("Broadsaber"),
    CONTAINED_ENERGY_AXE("Contained energy axe"),
    CROSSGUARD_LIGHTSABER("Crossguard lightsaber"),
    CURVED_HILT_LIGHTSABER("Curved-hilt lightsaber"),
    LIGHTSABER_PISTOL("Lightsaber pistol"),
    LIGHTSABER_RIFLE("Lightsaber rifle"),
    LIGHTSABER_PIKE("Lightsaber pike"),
    CANE_LIGHTSABER("Cane lightsaber"),
    TRAINING_LIGHTSABER("Training lightsaber"),
    SHOTO_LIGHTSABER("Shoto lightsaber"),
    GUARD_SHOTO("Guard shoto"),
    GREAT_LIGHTSABER("Great lightsaber"),
    LIGHTWHIP("Lightwhip"),
    DARKSABER("Darksaber");
    private String desc;
}