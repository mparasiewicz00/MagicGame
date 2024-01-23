package pl.kurs.Wizard;

import java.util.Objects;
import java.util.Optional;

public class Wizard {

    public String wizardName;
    private double healthLevel;
    private long wizardAge;
    private WizardType wizardType;

    public Wizard(String wizardName, long wizardAge, WizardType wizardType) {
        this.wizardName = wizardName;
        this.healthLevel = 200.0;
        this.wizardAge = wizardAge;
        this.wizardType = wizardType;
    }

    public String getWizardName() {
        return wizardName;
    }

    public void setWizardName(String wizardName) {
        this.wizardName = wizardName;
    }

    public double getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(double healthLevel) {
        this.healthLevel = healthLevel;
    }

    public long getWizardAge() {
        return wizardAge;
    }

    public void setWizardAge(long wizardAge) {
        this.wizardAge = wizardAge;
    }

    public WizardType getWizardType() {
        return wizardType;
    }

    public void setWizardType(WizardType wizardType) {
        this.wizardType = wizardType;
    }


    @Override
    public String toString() {
        return "Wizard{" +
                "wizardName='" + wizardName + '\'' +
                ", healthLevel=" + healthLevel +
                ", wizardAge=" + wizardAge +
                ", wizardType=" + wizardType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wizard wizard = (Wizard) o;
        return Double.compare(healthLevel, wizard.healthLevel) == 0 && wizardAge == wizard.wizardAge && Objects.equals(wizardName, wizard.wizardName) && wizardType == wizard.wizardType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wizardName, healthLevel, wizardAge, wizardType);
    }

    public void throwSpell(String spellType, Wizard targetWizard) {
        SpellType spell = checkSpellType(spellType);
        Optional.ofNullable(spell)
                .ifPresentOrElse(x -> {
                    assert spell != null;
                    spellAction(spell, targetWizard);
                }, () -> System.out.println("Invalid spell: " + spellType));
    }

    private SpellType checkSpellType(String spellType) {
        for (SpellType spell : wizardType.getSpells()) {
            if (spell.getSpellDescription().equalsIgnoreCase(spellType)) {
                return spell;
            }
        }
        return null;
    }

    private void spellAction(SpellType spell, Wizard targetWizard) {
        double healthImpact = spell.getHealthImpact();

        if (healthImpact > 0) {
            targetWizard.healWizard(healthImpact);
        } else if (healthImpact < 0) {
            targetWizard.takeDamage(-healthImpact);
        }
    }

    private void healWizard(double healthImpact) {
        setHealthLevel(healthLevel += healthImpact);
        if (getHealthLevel() > 200.0) {
            setHealthLevel(200.0);
        }
    }

    private void takeDamage(double healthImpact) {
        setHealthLevel(healthLevel -= healthImpact);
        if (getHealthLevel() < 0.0) {
            setHealthLevel(0.0);
        }
    }



}
