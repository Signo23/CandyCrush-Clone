package test.model.game.level.grid.table;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import candy.model.game.level.grid.table.TableBuilder;
import candy.model.game.level.grid.table.TableBuilderImpl;

public class TableBuilderTest {
    private static TableBuilder tb;

    @BeforeAll
    public static void initBuilder() {
        tb = new TableBuilderImpl();
    }

    @Test
    public void testDimension() {
        System.out.println("testDimension()");
        assertEquals(1, 1);
    }

    // @After

}
