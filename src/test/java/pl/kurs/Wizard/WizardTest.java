package pl.kurs.Wizard;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.InjectMocks.*;
import static org.mockito.Mockito.*;


class WizardTest {

    @InjectMocks
    private Wizard wizard;

    @Test
    void throwAllowedSpellByWizardOfFire() {
        Wizard wizard1 = mock(Wizard.class);
        Wizard wizard2 = mock(Wizard.class);

        doReturn(WizardType.WIZARD_OF_FIRE).when(wizard1).getWizardType();
        doReturn(WizardType.WIZARD_OF_WIND).when(wizard2).getWizardType();

        wizard1.throwSpell("FIREBALL", wizard2);

        assertAll(
                () -> verify(wizard1, atLeastOnce()).throwSpell("FIREBALL", wizard2),
                () -> verify(wizard2, atMostOnce()).setHealthLevel(175.0),
                () -> verify(wizard2, atMostOnce()).getHealthLevel()
        );
    }

    @Test
    void throwNotAllowedSpellByWizardOfWind() {
        Wizard wizard1 = mock(Wizard.class);
        Wizard wizard2 = mock(Wizard.class);


        doReturn(WizardType.WIZARD_OF_FIRE).when(wizard1).getWizardType();
        doReturn(WizardType.WIZARD_OF_WIND).when(wizard2).getWizardType();
        doReturn(200.0).when(wizard1).getHealthLevel();

        wizard2.throwSpell("FIREBALL", wizard1);

        assertAll(
                () -> verify(wizard1, never()).setHealthLevel(175.0),
                () -> assertEquals(200.0, wizard1.getHealthLevel())
        );
    }

    @Test
    void throwHealSpellByWizardWhenTargetWizardHealthLevelIsFull() {
        Wizard wizard1 = mock(Wizard.class);
        Wizard wizard2 = mock(Wizard.class);

        doReturn(WizardType.WIZARD_OF_FIRE).when(wizard1).getWizardType();
        doReturn(WizardType.WIZARD_OF_WIND).when(wizard2).getWizardType();
        doReturn(200.0).when(wizard2).getHealthLevel();

        wizard1.throwSpell("HEAL", wizard2);

        assertAll(
                () -> verify(wizard2, atMostOnce()).setHealthLevel(200.0),
                () -> assertEquals(200.0, wizard2.getHealthLevel())
        );
    }

    @Test
    void throwHealSpellByWizardWhenTargetWizardLevelIsNotFull() {
        Wizard wizard1 = mock(Wizard.class);
        Wizard wizard2 = mock(Wizard.class);

        doReturn(WizardType.WIZARD_OF_FIRE).when(wizard1).getWizardType();
        doReturn(WizardType.WIZARD_OF_WIND).when(wizard2).getWizardType();
        doReturn(200.0).when(wizard2).getHealthLevel();

        wizard1.throwSpell("FIREBALL", wizard2);
        wizard1.throwSpell("FIREBALL", wizard2);
        wizard1.throwSpell("HEAL", wizard2);

        assertAll(
                () -> verify(wizard1, times(2)).throwSpell("FIREBALL", wizard2),
                () -> verify(wizard1, times(1)).throwSpell("HEAL", wizard2)
        );
    }
}