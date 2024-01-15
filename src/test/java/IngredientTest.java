import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final String ingredientName;
    private final float ingredientPrice;

    public IngredientTest(String ingredientName, float ingredientPrice) {
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"ТестовыйСоус1", 20},
                {"ТестовыйСоус2", 25},
        });
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, ingredientName, ingredientPrice);
        assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, ingredientName, ingredientPrice);
        assertEquals(ingredientPrice, ingredient.getPrice(), 0.001);
    }
}
