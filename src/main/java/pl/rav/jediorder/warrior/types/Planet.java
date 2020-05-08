package pl.rav.jediorder.warrior.types;

import lombok.AllArgsConstructor;

    @AllArgsConstructor
    public enum Planet {
        UNKNOWN("Unknown"),         // Yoda:)
        CORUSCANT("Coruscant"),     // Qui-Gon Jinn
        STEWJON("Stewjon"),         // Obi-Wan Kenobi
        TATOOINE("Tatooine"),       // Luke Skywalker
        DATHOMIR("Dathomir"),       // Darth Maul
        CHANDRILLA("Chandrilla"),   // Kylo Ren
        EXEGOL("Exegol");           // Snoke
        private String desc;
    }






