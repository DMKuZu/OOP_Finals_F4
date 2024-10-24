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
        return """
                The Entity   \t- Antagonist
                The Beings\t\t- Hero's source of power
                Erotoma\t\t- World name
                Factions of Erotoma:
                    - Saroia
                    - Quacero
                    - Azrue
                Azsaqroqua \t\t- Center city of Erotoma
                Radea\t\t- Saroian alchemist
                Mazupe \t\t- Quaceron explorer
                Zipau \t\t- Azrueian researcher
                
                /////////////// Atlas - Factions
                # Saroia
                - Saroians are slender and flexible beings. They are quite agile
                  and are generally cheerful.
                - Saroians can do chain attacks while only expending mana the
                  first time they initiate an attack, but instead of rolling for
                  crit, they have to roll for a chance to continue the chain attack.
                  This means they can't crit.
                
                # Quacero
                - Quacerons are tough and bulky beings. Due to how they look,
                  Saroians and Azrueians who haven't seen a Quaceron before
                  would be intimidated, but really they are very gentle and polite
                  even under pressure.
                - Quacerons have more HP than the other races, but will always
                  attack last.
                
                # Azrue
                - What Azrueians lack in physical features, they make up with their
                  immense intelligence. They enjoy gathering knowledge and sharing
                  it amongst others. Due to their need for knowledge, they often
                  overlook simple gestures regarding them as a prude and impolite.
                  Despite being regarded as such, they are loyal to whomever they
                  give their trust.
                - Azrueians have a higher chance to crit than the other races, but
                  have lower HP than the other races.
                
                /////////////// Atlas - Characters
                # Radea
                - Radea, a Saroian, is the head of the Alchemy Group in Azsaroqua.
                  Due to the nature of alchemy, the group is considered unofficial
                  and is mostly maintained with the help of Radea's adventures.
                - As a Saroian, Radea can do chain attacks. Being the head of the
                  Alchemy Group in Azsaroqua, Radea can increase the effectivity of
                  any potion used.
                
                # Mazupe
                - Mazupe, a Quaceron, is an avid explorer that has roamed in all 3
                  factions' lands. Moving from one city to another had made Mazupe
                  a skillful veteran amongst the group.
                - As a Quaceron, Mazupe has more HP. Being a skillful veteran,
                  Mazupe gains more mana when using block.
                
                # Zipau
                - Zipau, an Azrueian, is a researcher of the Science Institute of
                  Azsaroqua. With the help of the institute's collections, Zipau
                  has become knowledgeable of the technology used in the 3 factions.
                - As an Azrueian, Zipau has a higher chance to crit. With all the
                  knowledge Zipau has gathered, Zipau gains extra stats from relics
                  collected.
                """;
    }

    protected String displayText_Choice() {
        return "Press ENTER to go back.";
    }


    public void onInputReceived(String input) {
        System.out.println("Going back to menu...");
        GAME.nextScene(MENU);
    }
}
