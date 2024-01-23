package pl.kurs.Wizard;

public enum WizardType {
    WIZARD_OF_FIRE("Mag ognia", SpellType.HEAL, SpellType.FIREBALL),
    WIZARD_OF_WIND("Mag wiatru", SpellType.HEAL, SpellType.LIGHTING_STRIKE);
    private final String typeDescription;
    private final SpellType[] spells;

    WizardType(String typeDescription, SpellType... spells) {
        this.typeDescription = typeDescription;
        this.spells = spells;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public SpellType[] getSpells() {
        return spells;
    }
}

