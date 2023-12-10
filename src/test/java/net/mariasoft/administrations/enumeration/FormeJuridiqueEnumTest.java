package net.mariasoft.administrations.enumeration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FormeJuridiqueEnumTest {
    /**
     * Method under test: {@link FormeJuridiqueEnum#getDescription()}
     */
    @Test
    void testGetDescription() {
        assertEquals("Entreprise Unipersonnelle A Responsabilités Limitées",
                FormeJuridiqueEnum.valueOf("EURL").getDescription());
    }
}
