import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(mockBun);
    }

    @Test
    public void testGetPriceWithOneIngredient() {
        Mockito.when(mockBun.getPrice()).thenReturn(50f);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(30f);

        burger.addIngredient(mockIngredient1);

        assertEquals(130, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetPriceWithTwoIngredients() {
        Mockito.when(mockBun.getPrice()).thenReturn(50f);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(30f);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(40f);

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        assertEquals(170, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetPriceWithoutIngredients() {
        Mockito.when(mockBun.getPrice()).thenReturn(50f);

        assertEquals(100, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetPriceWithMovedIngredient() {
        Mockito.when(mockBun.getPrice()).thenReturn(50f);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(30f);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(40f);

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.moveIngredient(0, 1);

        assertEquals(170, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetPriceWithRemovedIngredient() {
        Mockito.when(mockBun.getPrice()).thenReturn(50f);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(40f);

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.removeIngredient(0);

        assertEquals(140, burger.getPrice(), 0.001);
    }

    @Test
    public void testMoveIngredient() {
        Mockito.when(mockBun.getPrice()).thenReturn(50f);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(30f);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(40f);

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.moveIngredient(0, 1);

        assertEquals(170, burger.getPrice(), 0.001);
    }

    @Test
    public void testRemoveIngredient() {
        Mockito.when(mockBun.getPrice()).thenReturn(50f);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(40f);

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.removeIngredient(0);

        assertEquals(140, burger.getPrice(), 0.001);
    }
}
