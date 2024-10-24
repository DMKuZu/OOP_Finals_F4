package scene.menu;

import game.Game;
import scene.Scene;

import static game.WhichScene.MENU;

public class Atlas extends Scene {

    public Atlas( Game GAME){
        super(GAME);
    }

    @Override
    protected String displayText_Display() {
        return "The Entity   \t- Antagonist\n" +
                "The Beings\t\t- Hero's source of power\n" +
                "Erotoma\t\t- World name\n" +
                "Factions of Erotoma:\n" +
                "    - Saroia\n" +
                "    - Quacero\n" +
                "    - Azrue\n" +
                "Azsaqroqua \t\t- Center city of Erotoma\n" +
                "Radea\t\t- Saroian alchemist\n" +
                "Mazupe \t\t- Quaceron explorer\n" +
                "Zipau \t\t- Azrueian researcher\n" +
                "\n" +
                "/////////////// Atlas - Factions\n" +
                "# Saroia\n" +
                "- Saroians are slender and flexible beings. They are quite agile\n" +
                "  and are generally cheerful.\n" +
                "- Saroians can do chain attacks while only expending mana the\n" +
                "  first time they initiate an attack, but instead of rolling for\n" +
                "  crit, they have to roll for a chance to continue the chain attack.\n" +
                "  This means they can't crit.\n" +
                "\n" +
                "# Quacero\n" +
                "- Quacerons are tough and bulky beings. Due to how they look,\n" +
                "  Saroians and Azrueians who haven't seen a Quaceron before\n" +
                "  would be intimidated, but really they are very gentle and polite\n" +
                "  even under pressure.\n" +
                "- Quacerons have more HP than the other races, but will always\n" +
                "  attack last.\n" +
                "\n" +
                "# Azrue\n" +
                "- What Azrueians lack in physical features, they make up with their\n" +
                "  immense intelligence. They enjoy gathering knowledge and sharing\n" +
                "  it amongst others. Due to their need for knowledge, they often\n" +
                "  overlook simple gestures regarding them as a prude and impolite.\n" +
                "  Despite being regarded as such, they are loyal to whomever they\n" +
                "  give their trust.\n" +
                "- Azrueians have a higher chance to crit than the other races, but\n" +
                "  have lower HP than the other races.\n" +
                "\n" +
                "/////////////// Atlas - Characters\n" +
                "# Radea\n" +
                "- Radea, a Saroian, is the head of the Alchemy Group in Azsaroqua.\n" +
                "  Due to the nature of alchemy, the group is considered unofficial\n" +
                "  and is mostly maintained with the help of Radea's adventures.\n" +
                "- As a Saroian, Radea can do chain attacks. Being the head of the\n" +
                "  Alchemy Group in Azsaroqua, Radea can increase the effectivity of\n" +
                "  any potion used.\n" +
                "\n" +
                "# Mazupe\n" +
                "- Mazupe, a Quaceron, is an avid explorer that has roamed in all 3\n" +
                "  factions' lands. Moving from one city to another had made Mazupe\n" +
                "  a skillful veteran amongst the group.\n" +
                "- As a Quaceron, Mazupe has more HP. Being a skillful veteran,\n" +
                "  Mazupe gains more mana when using block.\n" +
                "\n" +
                "# Zipau\n" +
                "- Zipau, an Azrueian, is a researcher of the Science Institute of\n" +
                "  Azsaroqua. With the help of the institute's collections, Zipau\n" +
                "  has become knowledgeable of the technology used in the 3 factions.\n" +
                "- As an Azrueian, Zipau has a higher chance to crit. With all the\n" +
                "  knowledge Zipau has gathered, Zipau gains extra stats from relics\n" +
                "  collected.\n" +
                "\n" +
                "> BACK";

    }

    protected String displayText_Choice() {
        return "Press ENTER or type the command.";
    }


    public void onInputReceived(String input) {
        switch (input.toLowerCase()) {
            case "back":
            case "":
                System.out.println("Going back to menu...");
                GAME.nextScene(MENU);
                break;
            default:
                System.out.println("Invalid input: " + input);
                break;
        }
    }
}
