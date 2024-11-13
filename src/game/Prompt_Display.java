package game;

import elements.blessing.Blessing;
import elements.enemy.Current_Enemy;
import elements.favor.Favor;
import elements.favor.Favors_Inventory;
import elements.hero.Chosen_Hero;

public class Prompt_Display implements  List_of_Texts{
    private int encounterCtr;
    private int worldCtr;

    protected void setEncounterCtr(int encounterCtr) {
        this.encounterCtr = encounterCtr;
    }
    protected void setWorldCtr(int worldCtr) {
        this.worldCtr = worldCtr;
    }

    protected Prompt_Display(){
        encounterCtr = 0;
        worldCtr = 0;
    }

    protected void nextPrompt(){
        for(int i = 0; i < 5; i++){
            System.out.println("\033[H\033[2J");
            System.out.flush();
        }
    }

    private void header(){
        if(worldCtr < 4 && encounterCtr < 13)   System.out.printf ("                      Encounter %d    of    Chapter %d\n",encounterCtr,worldCtr);
        else if(encounterCtr == 13)             System.out.printf ("                        World Boss    of    Chapter %d\n",worldCtr);
        if(worldCtr == 4)                       System.out.println("                          The Final Battle");
    }

//Start menu prompt
///////*****************************************************

    protected void startMenu() {             //this is the start menu
        nextPrompt();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.println("|| The Entity");
        System.out.println("||");
        System.out.println("|| > Start");
        System.out.println("|| > Atlas");
        System.out.println("|| > Credits");
        System.out.println("|| > Exit");
        System.out.println("||");
        System.out.println("|| Type a command to get started!");
    }

    protected void introPrompt() {
        nextPrompt();
        System.out.println("||--------------------------------------------------------------------------||");
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
        System.out.println("|| > 1 : Radea");
        System.out.println("|| > 2 : Mazupe");
        System.out.println("|| > 3 : Zipau");
    }

    protected void atlas() {
        nextPrompt();
        System.out.println("||--------------------------------------------------------------------------||");
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
        System.out.println("|| > BACK");
    }

    protected void credits() {
        nextPrompt();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.println("|| John Winston W. Tabada");
        System.out.println("|| Aaron Rey A. Jacalan");
        System.out.println("|| Ruhmer Jairus Espina");
        System.out.println("|| Lovely Shane Ong");
        System.out.println("||");
        System.out.println("|| > BACK");
    }

    protected void exit() {
        nextPrompt();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.println("|| Thank you for playing The Entity!");
        System.out.println("||--------------------------------------------------------------------------||");
    }

//exposition prompts
///////*****************************************************
    protected void startWorldPrompt(){
        nextPrompt();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.println(startOfWorldTexts.get(worldCtr-1));
        System.out.println("||");
        System.out.println("|| > Press ENTER to continue...");
    }

    protected void scenarioPrompt(){
        nextPrompt();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.println("|| " + scenarioTexts_1.get(encounterCtr-1));
        System.out.println("||");
        System.out.println("|| > Press ENTER to continue...");
    }

    protected void victoryPrompt(String enemyName,int essence, Blessing blessing){
        nextPrompt();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.println("|| A strange sensation washes over you as the " + enemyName);
        System.out.println("|| dissolves into nothingness.");
        System.out.println("|| A cold, empty feeling settles in.");
        System.out.println("|| A peculiar, otherworldly energy pulses from the remains.");
        System.out.println("|| You reach out, a part of you hesitant,");
        System.out.println("|| another part drawn to its inexplicable allure.");
        System.out.println("|| You absorb the energy, a foreign force coursing through your veins.");
        System.out.println("|| Its purpose, its significance, remains a mystery.");
        System.out.println("|| ");
        System.out.println("|| You have obtained: ");
        System.out.println("|| +" + essence + " essence  ->  Used as an offering to The Being.");
        System.out.println("|| " + blessing.toString());
        System.out.println("||");
        System.out.println("|| > Press ENTER to continue...");
    }

    protected void defeatPrompt(String enemyName){
        nextPrompt();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.println("|| A heavy weight settles upon your shoulders as the " + enemyName);
        System.out.println("|| looms overhead. Its dark, corrupting energy seeps into your soul.");
        System.out.println("|| A serene calm washes over you, a quiet acceptance of your impending doom.");
        System.out.println("|| The world around you fades into obscurity, replaced by an endless void.");
        System.out.println("|| As the shadows claim you, a single thought echoes in your mind:");
        System.out.println("|| ");
        System.out.println("|| 'perhaps this is the end...'");
        System.out.println("|| 'or perhaps... it is merely the beginning of a new, unknown journey...'");
        System.out.println("||");
        System.out.println("|| > Press ENTER to continue...");
    }

//encounter prompts
///////*****************************************************
    protected void encounter_fork(){
        nextPrompt();
        //dapat dynamic ni
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.println("|| As you walk along you notice a Strong enemy in front of you.");
        System.out.println("|| Before the enemy notices you, you start running away.");
        System.out.println("|| When all of a sudden another enemy blocks your escape.");
        System.out.println("||");
        System.out.println("|| > 1 : Fight against the strong enemy");
        System.out.println("|| > 2 : Fight the enemy blocking your escape");
    }

    protected void encounter_trance(){
        nextPrompt();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.println("|| A fog of uncertainty clouds your mind. The path ahead, once clear,");
        System.out.println("|| now seems shrouded in mist. A sense of weariness settles over you,");
        System.out.println("|| a heavy weight on your shoulders. ");
        System.out.println("||");
        System.out.println("|| Suddenly, a chilling sensation grips your soul.");
        System.out.println("|| You're pulled into a trance, a captive of an unseen force.");
        System.out.println("|| A voice, ancient and powerful, echoes within your mind. ");
        System.out.println("||");
        System.out.println("|| 'Remember your purpose', it commands. ");
        System.out.println("|| 'The essence you've collected fuels your destiny.'");
        System.out.println("||");
        System.out.println("|| A vision flashes before your eyes: a cosmic tapestry, intricate and vast. ");
        System.out.println("|| You are a mere thread, a part of a grand design. ");
        System.out.println("|| A sense of urgency returns, a renewed drive to fulfill your mission. ");
        System.out.println("||");
        System.out.println("|| > Press ENTER to continue...");
    }

    protected void trance_offer(int essence,int favorSize){
        nextPrompt();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.println("|| Will you offer the essence to The Being?");
        System.out.println("|| or");
        System.out.println("|| Will you wake up and continue along your path?");
        System.out.println("||");
        System.out.println("|| You have " + essence + " essence and " + favorSize + " | 3 Favors.");
        System.out.println("|| ");
        System.out.println("|| > 1 : Offer     -> 1 essence for 1 favor");
        System.out.println("|| > 2 : Continue  -> Next encounter");
    }

    protected void trance_notenough(){
        nextPrompt();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.println("|| You don't have enough essence.");
        System.out.println("|| ");
        System.out.println("|| You wake up and continue along your path.");
        System.out.println("|| ");
        System.out.println("|| Press ENTER to continue...");
    }

    protected void trance_continue(){
        nextPrompt();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.println("|| You wake up and continue along your path.");
        System.out.println("|| ");
        System.out.println("|| Press ENTER to continue...");
    }

    protected void trance_fullinv(Favors_Inventory inv){
        nextPrompt();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.println("|| You have 3 | 3 Favors from The Being!");
        System.out.println("|| ");
        System.out.println("|| Choose a favor that you want to exchange.");
        inv.swapFavorDesc();
        System.out.println("|| ");
        System.out.println("|| > 4 : Continue  -> Next encounter");
    }
    protected void trance_exchanged(String msg){
        nextPrompt();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.println("|| " + msg);
        System.out.println("|| ");
        System.out.println("|| > Press ENTER to continue...");
    }

    protected void trance_pulled(Favor favor){
        nextPrompt();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.println("|| You have obtained: ");
        System.out.println("|| " + favor.toString());
        System.out.println("|| ");
        System.out.println("|| > Press ENTER to continue...");
    }

    protected void encounter_battle_choice(Chosen_Hero hero, Current_Enemy enemy){
        nextPrompt();
        header();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.printf ("|| %s\n",enemy.getNAME());
        System.out.printf ("|| HP: %d | %d\n",enemy.getCURRSTATS().getHP(),enemy.getSTATS().getHP());
        System.out.println("||");
        System.out.println("||");
        System.out.printf ("|| %s\n",hero.getNAME());
        System.out.printf ("|| HP: %d | %d\n",hero.getCURRSTATS().getHP(),hero.getSTATS().getHP());
        System.out.println("||");
        System.out.println("|| What do you want to do?");
        System.out.println("|| > 1 : Skills");
        System.out.println("|| > 2 : Favors");
        System.out.println("|| > 3 : Info");
    }


//battle prompt
///////*****************************************************
    protected void battle_skills(Chosen_Hero hero, Current_Enemy enemy){
        nextPrompt();
        header();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.printf ("|| %s\n",enemy.getNAME());
        System.out.printf ("|| HP: %d | %d\n",enemy.getCURRSTATS().getHP(),enemy.getSTATS().getHP());
        System.out.println("||");
        System.out.println("||");
        System.out.printf ("|| %s\n",hero.getNAME());
        System.out.printf ("|| HP: %d | %d\n",hero.getCURRSTATS().getHP(),hero.getSTATS().getHP());
        System.out.println("||");
        System.out.println("|| Choose the number of the skill!");
        System.out.printf ("|| > 1 : %s = Unlimited uses\n",hero.getSKILL_NAME(1));
        System.out.printf ("|| > 2 : %s = %d | %d uses\n",hero.getSKILL_NAME(2),hero.getCURR_USES(2),hero.getTOTAL_USES(2));
        System.out.printf ("|| > 3 : %s = %d | %d uses\n",hero.getSKILL_NAME(3),hero.getCURR_USES(3),hero.getTOTAL_USES(3));
        System.out.printf ("|| > 4 : %s = %d | %d uses\n",hero.getSKILL_NAME(4),hero.getCURR_USES(4),hero.getTOTAL_USES(4));
        System.out.printf ("|| > 5 : %s = %d | %d uses\n",hero.getSKILL_NAME(5),hero.getCURR_USES(5),hero.getTOTAL_USES(5));
        System.out.println("|| > 6 : BACK");
    }

    protected void battle_hero_action(Chosen_Hero hero, Current_Enemy enemy, String msg){
        nextPrompt();
        header();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.printf ("|| %s\n",enemy.getNAME());
        System.out.printf ("|| HP: %d | %d\n",enemy.getCURRSTATS().getHP(),enemy.getSTATS().getHP());
        System.out.println("||");
        System.out.printf ("|| %s\n",hero.getNAME());
        System.out.printf ("|| HP: %d | %d\n",hero.getCURRSTATS().getHP(),hero.getSTATS().getHP());
        System.out.println("||");
        System.out.printf ("|| %s\n", msg);
        System.out.println("||");
        System.out.println("|| > Press ENTER to continue...");
    }

    protected void battle_enemy_action(Chosen_Hero hero, Current_Enemy enemy, String msg){
        nextPrompt();
        header();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.printf ("|| %s\n",enemy.getNAME());
        System.out.printf ("|| HP: %d | %d\n",enemy.getCURRSTATS().getHP(),enemy.getSTATS().getHP());
        System.out.println("||");
        System.out.printf ("|| %s\n", msg);
        System.out.println("||");
        System.out.printf ("|| %s\n",hero.getNAME());
        System.out.printf ("|| HP: %d | %d\n",hero.getCURRSTATS().getHP(),hero.getSTATS().getHP());
        System.out.println("||");
        System.out.println("|| > Press ENTER to continue...");
    }

    protected void battle_favors(Chosen_Hero hero, Current_Enemy enemy) {
        nextPrompt();
        header();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.printf ("|| %s\n",enemy.getNAME());
        System.out.printf ("|| HP: %d | %d\n",enemy.getCURRSTATS().getHP(),enemy.getSTATS().getHP());
        System.out.println("||");
        System.out.println("||");
        System.out.printf ("|| %s\n",hero.getNAME());
        System.out.printf ("|| HP: %d | %d\n",hero.getCURRSTATS().getHP(),hero.getSTATS().getHP());
        System.out.println("||");
        System.out.println("|| Choose the number of the favor");
        System.out.printf("|| > 1 : %s\n", hero.getFAVOR().getFavorName(1));
        System.out.printf("|| > 2 : %s\n", hero.getFAVOR().getFavorName(2));
        System.out.printf("|| > 3 : %s\n", hero.getFAVOR().getFavorName(3));
        System.out.println("|| > 4 : BACK");
    }

    protected void battle_info(Chosen_Hero hero){
        nextPrompt();
        header();
        System.out.println("||--------------------------------------------------------------------------||");
        System.out.println("||                         Hero Information");
        System.out.println("|| STATS");
        hero.statDesc();
        System.out.println("|| ");
        System.out.println("|| Skills");
        hero.skillDesc();
        System.out.println("||");
        System.out.println("|| FAVORS");
        hero.getFAVOR().favorDesc();
        System.out.println("||");
        System.out.println("|| BLESSINGS");
        hero.blessingDesc();
        System.out.println("||");
        System.out.println("|| > BACK");
    }

}