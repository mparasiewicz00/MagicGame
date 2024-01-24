package pl.kurs.Wizard;

public class MagicGameRunner {
    public static void main(String[] args) {
        Wizard wizardAdam = new Wizard("Adam", 20, WizardType.WIZARD_OF_FIRE);
        Wizard wizardGienek = new Wizard("Gienek", 920, WizardType.WIZARD_OF_WIND);

        wizardAdam.throwSpell("FIREBALL", wizardGienek);
        wizardAdam.throwSpell("FIREBALL", wizardGienek);
        System.out.println(wizardGienek);
        wizardAdam.throwSpell("HEAL", wizardGienek);
        System.out.println(wizardGienek);
    }
}
