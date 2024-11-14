package elements.hero;

import elements.blessing.Blessing;
import elements.value.Stats;
import elements.enemy.Current_Enemy;
import elements.favor.Favors_Inventory;

public abstract class Chosen_Hero {
    ////////////////////////////////////////////////////////////////////////getter
    public abstract String getNAME();
    public abstract Stats getSTATS();
    public abstract Stats getCURRSTATS();
    public abstract String getSKILL_NAME(int skillNum);
    public abstract int getTOTAL_USES(int skillNum);
    public abstract int getCURR_USES(int skillNum);
    public abstract int getESSENCE();
    public abstract Favors_Inventory getFAVOR();
    public abstract void addESSENCE(int essence);


    ////////////////////////////////////////////////////////////////////////setter
    public abstract void useESSENCE();
    public abstract void addBLESSING(Blessing blessing);
    public abstract String swapFavor(int favorNum);

    public abstract void refresh_encounter();
    public abstract void refresh_world();
    public abstract void apply_blessing(Blessing blessing);


    ////////////////////////////////////////////////////////////////////////hero stuff
    protected abstract String skill1(boolean isCrit,int damage,Current_Enemy enemy);
    protected abstract String skill2(boolean isCrit,int damage,Current_Enemy enemy);
    protected abstract String skill3(boolean isCrit,int damage,Current_Enemy enemy);
    protected abstract String skill4(boolean isCrit,int damage,Current_Enemy enemy);
    protected abstract String skill5(boolean isCrit,int damage,Current_Enemy enemy);

    public abstract String use_skill(int skillNum, Current_Enemy enemy);
    public abstract String use_favor(int favorNum);


    //////////////////////////////////////////////////////////////////////// boss stuff
    protected abstract String skill1(boolean isCrit, int damage, Chosen_Hero hero);
    protected abstract String skill2(boolean isCrit, int damage, Chosen_Hero hero);
    protected abstract String skill3(boolean isCrit, int damage, Chosen_Hero hero);
    protected abstract String skill4(boolean isCrit, int damage, Chosen_Hero hero);
    protected abstract String skill5(boolean isCrit, int damage, Chosen_Hero hero);

    public abstract String boss_use_skill(int skillNum, Chosen_Hero hero);

    /////////////////////////////////////////////////////////////////////////////// descriptions
    public abstract void statDesc();
    public abstract void skillDesc();
    public abstract void blessingDesc();

}
