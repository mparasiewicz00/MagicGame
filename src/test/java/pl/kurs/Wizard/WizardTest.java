package pl.kurs.Wizard;

import org.junit.jupiter.api.Test;
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
}