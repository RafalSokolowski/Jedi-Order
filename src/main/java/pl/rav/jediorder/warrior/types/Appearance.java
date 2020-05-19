package pl.rav.jediorder.warrior.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Appearance {
    YODA("Light/Yoda/Yoda2.png"),
    VADER("Light/DarthVader.png"),
    PALPATINE("Light/DarthSidious.png"),
    QUIGON("Light/QuiGonJinn.png"),
    OBIWAN("Light/ObiWanKenobi.png"),
    LUKE("Light/LukeSkywalker.png"),
    MAUL("Dark/DarthMaul/DarthMaul.png"),
    REN("Dark/KyloRen/KyloRen.png"),
    SNOKE("Dark/LeaderSnoke/LeaderSnoke.png");
    private String desc;
}
