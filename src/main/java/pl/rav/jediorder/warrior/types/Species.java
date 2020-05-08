package pl.rav.jediorder.warrior.types;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Species {
    HUMAN("Human"),
    YODANIN("Yoda's species"),
    DATHMIRIAN("Dathomirian"),      // Darth Maul
    HUMANOID("Humanoid");           // Snoke
    private String desc;
}