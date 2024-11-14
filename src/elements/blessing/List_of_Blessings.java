package elements.blessing;


import java.util.Arrays;
import java.util.List;

public interface List_of_Blessings {

    List<Blessing> Legendary_List = Arrays.asList(
            new Blessing("Blessing of Vitality", "HP", 100),
            new Blessing("Blessing of Might", "ATK", 80),
            new Blessing("Blessing of Fortitude", "DEF", 80),
            new Blessing("Blessing of Agility", "DODGE", 30),
            new Blessing("Blessing of Precision", "CRIT", 20)
    );

    List<Blessing> Epic_List = Arrays.asList(
            new Blessing("Benediction of Vigor", "HP", 80),
            new Blessing("Benediction of Prowess", "ATK", 70),
            new Blessing("Benediction of Resilience", "DEF", 60),
            new Blessing("Benediction of Swiftness", "DODGE", 22),
            new Blessing("Benediction of Mastery", "CRIT", 17),
            new Blessing("Benediction of Vitality","HP",50),
            new Blessing("Benediction of Impact", "ATK", 55),
            new Blessing("Benediction of Fortitude", "DEF", 50),
            new Blessing("Benediction of Reflexes", "DODGE", 20),
            new Blessing("Benediction of Accuracy", "CRIT", 16)
    );

    List<Blessing> Rare_List = Arrays.asList(
            new Blessing("Boon of Endurance", "HP", 60),
            new Blessing("Boon of Strength", "ATK", 50),
            new Blessing("Boon of Hardiness", "DEF", 45),
            new Blessing("Boon of Agility", "DODGE", 19),
            new Blessing("Boon of Precision", "CRIT", 15),
            new Blessing("Boon of Vitality","HP",40),
            new Blessing("Boon of Impact", "ATK", 45),
            new Blessing("Boon of Fortitude", "DEF", 40),
            new Blessing("Boon of Reflexes", "DODGE", 18),
            new Blessing("Boon of Accuracy", "CRIT", 14)
    );

    List<Blessing> Uncommon_List = Arrays.asList(
            new Blessing("Charm of Vitality", "HP", 50),
            new Blessing("Charm of Prowess", "ATK", 40),
            new Blessing("Charm of Resilience", "DEF", 35),
            new Blessing("Charm of Swiftness", "DODGE", 16),
            new Blessing("Charm of Mastery", "CRIT", 12),
            new Blessing("Charm of Vitality","HP",30),
            new Blessing("Charm of Impact", "ATK", 35),
            new Blessing("Charm of Fortitude", "DEF", 30),
            new Blessing("Charm of Reflexes", "DODGE", 12),
            new Blessing("Charm of Accuracy", "CRIT", 10)
    );

    List<Blessing> Common_List = Arrays.asList(
            new Blessing("Gift of Endurance","HP",40),
            new Blessing("Gift of Strength", "ATK", 30),
            new Blessing("Gift of Hardiness", "DEF", 24),
            new Blessing("Gift of Agility", "DODGE", 12),
            new Blessing("Gift of Precision", "CRIT", 8),
            new Blessing("Gift of Vitality","HP",30),
            new Blessing("Gift of Impact", "ATK", 25),
            new Blessing("Gift of Fortitude", "DEF", 20),
            new Blessing("Gift of Reflexes", "DODGE", 10),
            new Blessing("Gift of Accuracy", "CRIT", 6)
    );
}
