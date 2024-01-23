package pl.kurs.Wizard;

public class MagicGameRunner {
    public static void main(String[] args) {
        Wizard wizardAdam = new Wizard("Adam", 20, WizardType.WIZARD_OF_FIRE);
        Wizard wizardGienek = new Wizard("Gienek", 920, WizardType.WIZARD_OF_WIND);

        wizardGienek.throwSpell("FIREBALL", wizardAdam);
        wizardGienek.throwSpell("LIGHTING STRIKE", wizardAdam);
        wizardAdam.throwSpell("FIREBALL", wizardGienek);
        System.out.println(wizardAdam);
        wizardGienek.throwSpell("HEAL", wizardAdam);
        System.out.println(wizardAdam);
        System.out.println(wizardGienek);

    }
}
