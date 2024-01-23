package pl.kurs.Wizard;

public enum SpellType {
    HEAL("HEAL",30.0),
    FIREBALL("FIREBALL",-25.0),
    LIGHTING_STRIKE("LIGHTING STRIKE",-20.0);

    private final double healthImpact;
    private final String spellDescription;
    private SpellType(String spellDescription, double healthImpact) {
        this.spellDescription = spellDescription;
        this.healthImpact = healthImpact;
    }

    public double getHealthImpact() {
        return healthImpact;
    }

    public String getSpellDescription() {
        return spellDescription;
    }
}
