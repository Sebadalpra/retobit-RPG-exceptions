public class Mage extends Character {
    private int mana;
    private static final int CAST_SPELL_MANA_COST = 10;
    private static final int CAST_SPELL_DAMAGE = 20;
    private static final int HEAL_MANA_COST = 15;
    private static final int HEAL_AMOUNT = 20;

    public Mage(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    public int getMana() {
        return this.mana;
    }

    // -------------------------------------------------
    // Helper. Metodo para comprobar el maná y consumirlo
    public void consumeMana(int cost){
        if (mana - cost <= 0) {
            throw new InsufficientManaException(this.name + " no tiene maná suficiente");
        }
        mana -= cost;
    }


    // -------------------------------------------------

    public void castSpell(Character target) throws InsufficientManaException{
        super.validateTarget(target);
        consumeMana(CAST_SPELL_MANA_COST);
        target.receiveDamage(CAST_SPELL_DAMAGE);
        target.status = Status.POISONED;
    }

    public void heal(Character target) throws InsufficientManaException{
        super.validateTarget(target);
        consumeMana(HEAL_MANA_COST);
        target.health += HEAL_AMOUNT;

    }

}
