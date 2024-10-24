package scene.menu;

import elements.creature.hero.Mazupe;
import elements.creature.hero.Radea;
import elements.creature.hero.Supa;
import elements.creature.hero.Zipau;
import game.Game;
import scene.Scene;

import static game.WhichScene.START;

public class Choose_Hero extends Scene {

    public Choose_Hero(Game GAME){
        super(GAME);
    }

    @Override
    protected String displayText_Display() {
        return "Since the beginning of time, the land of Erotoma was created\n" +
                "by the grace of The Beings. The Beings created a land full of\n" +
                "diversity. Creatures were created in the likeness of The Beings.\n" +
                "As time passed, these creatures evolved and started\n" +
                "naming themselves and creating factions based on which of The\n" +
                "Beings had created them. Thus, Erotoma was split into 3:\n" +
                "The Saroia, The Quacero, and The Azrue. Each having their own\n" +
                "cultures but all sharing the same language.\n\n" +

                "As the factions grew, so did their ideals. The differences in\n" +
                "their ideals were enough to cause a war amongst the 3 factions.\n" +
                "What seemed to be a war that would last forever was abruptly\n" +
                "ended due to the birth of The Entity. If it weren't for the\n" +
                "legends being passed down from generations, the existence of\n" +
                "The Entity would be long forgotten. The Entity was a being of\n" +
                "pure chaos. It had almost wiped out the 3 factions... until\n" +
                "The Beings intervened. It was the first time and the last time\n" +
                "that the factions ever saw The Beings. As right after The Beings\n" +
                "fought The Entity, they all vanished to the far horizon where\n" +
                "none of the factions could see. After the disappearance of\n" +
                "The Beings and The Entity, the 3 factions decided to make peace\n" +
                "and unite to rebuild for a better civilization.\n\n" +

                "Fast forward to the current era. In the center of Erotoma lies\n" +
                "the heart of the 3 factions. A city of diversity, Azsaroqua.\n" +
                "A city where Saroians, Quacerons, and Azrueians gather to share\n" +
                "their culture and traditions.\n\n" +

                "In this city, 3 friends with different cultures share the same\n" +
                "outlook on life, to search for the whereabouts of The Beings.\n\n" +

                "The 3 embark on a quest after hearing about a rumor of a sudden\n" +
                "appearance of a small island on the far outskirts of Erotoma\n" +
                "containing what seems to be a temple.\n\n";
    }

    @Override
    protected String displayText_Choice() {
        return "Choose a HERO by typing the number or their name.\n\n" +
                "Choose your character:\n\n" +
                "> 1 : Radea\n" +
                "> 2 : Mazupe\n" +
                "> 3 : Zipau\n";
    }

    @Override
    public void onInputReceived(String input) {
        switch (input.toLowerCase()) {
            case "1":
            case "radea":
                System.out.println("Chose Radea");
                GAME.setHERO(new Radea());
                GAME.nextScene(START);
                break;
            case "2":
            case "mazupe":
                System.out.println("Chose Mazupe");
                GAME.setHERO(new Mazupe());
                GAME.nextScene(START);
                break;
            case "3":
            case "zipau":
                System.out.println("Chose Zipau");
                GAME.setHERO(new Zipau());
                GAME.nextScene(START);
                break;
            case "69":
            case "superidolsirkhaigumonan":
                System.out.println("Chose SupaIdolSirKhai");
                GAME.setHERO(new Supa());
                GAME.nextScene(START);
                break;
            default:
                System.out.println("Invalid input: " + input);
                break;
        }
    }
}
