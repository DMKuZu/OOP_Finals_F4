package game;

public class Prompt_Display {


    public void nextPrompt(){                                                          ///creates gap for each prompts
        System.out.println("||");
        System.out.println("||");
        System.out.println("||");
        System.out.println("||");
        System.out.println("||");
    }

    public void startMenu() {                                                          ///this is the start menu
        nextPrompt();
        System.out.println("|| The Entity");
        System.out.println("||");
        System.out.println("|| > Start");
        System.out.println("|| > Atlas");
//        System.out.println("|| > Help");
        System.out.println("|| > Credits");
        System.out.println("|| > Exit");
        System.out.println("||");
        System.out.println("|| Type a command to get started!");
    }

    public void introPrompt() {
        nextPrompt();
        System.out.println("|| Since the beginning of time, the land of Erotoma was created");
        System.out.println("|| by the grace of The Beings. The Beings created a land full of");
        System.out.println("|| diversity. Creatures were created in the likeness of The Beings.");
        System.out.println("|| As time passed, these creatures have evolved and had started");
        System.out.println("|| naming themselves and creating factions based on which of The");
        System.out.println("|| Beings had created them. Thus, Erotoma was split into 3.");
        System.out.println("|| The Saroia, The Quacero, and The Azrue. Each having their own");
        System.out.println("|| cultures but all share the same language.");
        System.out.println("||");
        System.out.println("|| As the factions grew, so did their ideals. The difference of");
        System.out.println("|| their ideals were enough to cause a war amongst the 3 factions.");
        System.out.println("|| What seemed to be a war that would last forever was abruptly");
        System.out.println("|| ended due to the birth of The Entity. If it wasn't for the");
        System.out.println("|| legends being passed down from generations, the existence of");
        System.out.println("|| The Entity would be long forgotten. The Entity was a being of");
        System.out.println("|| pure chaos. It had almost wiped out the 3 factions... until");
        System.out.println("|| The Beings intervened. It was the first time and the last time");
        System.out.println("|| that the factions ever saw The Beings. As right after The Beings");
        System.out.println("|| fought The Entity, they all vanished to the far horizon where");
        System.out.println("|| none of the Factions could see. After the disappearance of");
        System.out.println("|| The Beings and The Entity, the 3 factions decided to make peace");
        System.out.println("|| and unite to rebuild for a better civilization.");
        System.out.println("||");
        System.out.println("|| Fast forward to the current era. In the center of Erotoma lies");
        System.out.println("|| the heart of the 3 factions. A city of diversity, Azsaroqua.");
        System.out.println("|| A city where Saroians, Quaceron, and Azrueians gather to share");
        System.out.println("|| their culture and traditions.");
        System.out.println("||");
        System.out.println("|| In this city, 3 friends with different cultures share the same");
        System.out.println("|| outlook in life, to search for the whereabouts of The Beings.");
        System.out.println("||");
        System.out.println("|| The 3 embark on a quest after hearing about a rumour of a sudden");
        System.out.println("|| appearance of a small island in the far outskirts of Erotoma");
        System.out.println("|| containing what seems to be a temple.");
        System.out.println("||");
        System.out.println("|| Choose your character:");
        System.out.println("||");
        System.out.println("|| > Radea");
        System.out.println("|| > Mazupe");
        System.out.println("|| > Zipau");
        System.out.println("||");
    }

    public void atlas() {
        nextPrompt();
        System.out.println("|| The Entity   \t- Antagonist");
        System.out.println("|| The Beings\t\t- Hero's source of power");
        System.out.println("|| Erotoma\t\t- World name");
        System.out.println("|| Factions of Erotoma:");
        System.out.println("||     - Saroia");
        System.out.println("||     - Quacero");
        System.out.println("||     - Azrue");
        System.out.println("|| Azsaqroqua \t\t- Center city of Erotoma");
        System.out.println("|| Radea\t\t- Saroian alchemist");
        System.out.println("|| Mazupe \t\t- Quaceron explorer");
        System.out.println("|| Zipau \t\t- Azrueian researcher");
        System.out.println("||");
        System.out.println("|| /////////////// Atlas - Factions");
        System.out.println("|| # Saroia");
        System.out.println("|| - Saroians are slender and flexible beings. They are quite agile");
        System.out.println("||   and are generally cheerful.");
        System.out.println("|| - Saroians can do chain attacks while only expending mana the");
        System.out.println("||   first time they initiate an attack, but instead of rolling for");
        System.out.println("||   crit, they have to roll for a chance to continue the chain attack.");
        System.out.println("||   This means they can't crit.");
        System.out.println("||");
        System.out.println("|| # Quacero");
        System.out.println("|| - Quacerons are tough and bulky beings. Due to how they look,");
        System.out.println("||   Saroians and Azrueians who haven't seen a Quaceron before");
        System.out.println("||   would be intimidated, but really they are very gentle and polite");
        System.out.println("||   even under pressure.");
        System.out.println("|| - Quacerons have more HP than the other races, but will always");
        System.out.println("||   attack last.");
        System.out.println("||");
        System.out.println("|| # Azrue");
        System.out.println("|| - What Azrueians lack in physical features, they make up with their");
        System.out.println("||   immense intelligence. They enjoy gathering knowledge and sharing");
        System.out.println("||   it amongst others. Due to their need for knowledge, they often");
        System.out.println("||   overlook simple gestures regarding them as a prude and impolite.");
        System.out.println("||   Despite being regarded as such, they are loyal to whomever they");
        System.out.println("||   give their trust.");
        System.out.println("|| - Azrueians have a higher chance to crit than the other races, but");
        System.out.println("||   have lower HP than the other races.");
        System.out.println("||");
        System.out.println("|| /////////////// Atlas - Characters");
        System.out.println("|| # Radea");
        System.out.println("|| - Radea, a Saroian, is the head of the Alchemy Group in Azsaroqua.");
        System.out.println("||   Due to the nature of alchemy, the group is considered unofficial");
        System.out.println("||   and is mostly maintained with the help of Radea's adventures.");
        System.out.println("|| - As a Saroian, Radea can do chain attacks. Being the head of the");
        System.out.println("||   Alchemy Group in Azsaroqua, Radea can increase the effectivity of");
        System.out.println("||   any potion used.");
        System.out.println("||");
        System.out.println("|| # Mazupe");
        System.out.println("|| - Mazupe, a Quaceron, is an avid explorer that has roamed in all 3");
        System.out.println("||   factions' lands. Moving from one city to another had made Mazupe");
        System.out.println("||   a skillful veteran amongst the group.");
        System.out.println("|| - As a Quaceron, Mazupe has more HP. Being a skillful veteran,");
        System.out.println("||   Mazupe gains more mana when using block.");
        System.out.println("||");
        System.out.println("|| # Zipau");
        System.out.println("|| - Zipau, an Azrueian, is a researcher of the Science Institute of");
        System.out.println("||   Azsaroqua. With the help of the institute's collections, Zipau");
        System.out.println("||   has become knowledgeable of the technology used in the 3 factions.");
        System.out.println("|| - As an Azrueian, Zipau has a higher chance to crit. With all the");
        System.out.println("||   knowledge Zipau has gathered, Zipau gains extra stats from relics");
        System.out.println("||   collected.");
        System.out.println("||");
    }

    /*public void help() {
        nextPrompt();
        System.out.println("||//////////////////////////////////////////");
        System.out.println("|| # List of Commands");
        System.out.println("||   @ Start menu");
        System.out.println("||      - start");
        System.out.println("||      - atlas");
        System.out.println("||      - help");
        System.out.println("||      - credits");
        System.out.println("||      - exit");
        System.out.println("||");
        System.out.println("||   @ Choose characters");
        System.out.println("||      - radea");
        System.out.println("||      - mazupe");
        System.out.println("||      - zipau");
        System.out.println("||");
        System.out.println("||   @ Exit from help, atlas, credits");
        System.out.println("||      - just press ENTER");
        System.out.println("||      - exit");
        System.out.println("||");
    }*/


    public void credits() {
        nextPrompt();
        System.out.println("||//////////////////////////////////////////////");
        System.out.println("|| John Winston W. Tabada");
        System.out.println("|| Aaron Rey A. Jacalan");
        System.out.println("|| Ruhmer Jairus R. Espina");
        System.out.println("|| Lovely Shane P. Ong");
        System.out.println("||");
    }


    public void exit() {
        nextPrompt();
        System.out.println("|| Exiting...");
        System.out.println("|| Thank you for playing The Entity!");
    }
}