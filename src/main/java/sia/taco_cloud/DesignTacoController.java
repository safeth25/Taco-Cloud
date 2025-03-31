package sia.taco_cloud;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import lombok.extern.slf4j.Slf4j;
import sia.taco_cloud.Ingredient;
import sia.taco_cloud.Ingredient.Type;
@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = Arrays.asList(
            new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
            new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
            new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
            new Ingredient("CARN", "Carnitas", Type.PROTEIN),
            new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
            new Ingredient("LETC", "Lettuce", Type.VEGGIES),
            new Ingredient("CHED", "Cheddar", Type.CHEESE),
            new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
            new Ingredient("SLSA", "Salsa", Type.SAUCE),
            new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
            );
    
        Type[] types = Ingredient.Type.values();

        for(Type type: types){
            // Filtern der Zutaten nach Typ und Hinzufügen zum Modell
            List<Ingredient> filteredIngredients = ingredients.stream()
            .filter(ingredient -> ingredient.getType() == type)  // Filter nach Typ
            .collect(Collectors.toList());
             
            model.addAttribute(type.toString().toLowerCase(), filteredIngredients);
        }
            model.addAttribute("design", new Taco());    
            return "design";
    }

    @PostMapping
    public String processDesign(Design design){
        // Save the taco design...
        // We'll do this in chapter 3
        log.info("Processing design: " + design);

        return "redirect:/orders/current"
    }
}
