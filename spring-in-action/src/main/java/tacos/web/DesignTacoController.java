package tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.Order;
import tacos.Taco;
import tacos.data.IngredientRepository;
import tacos.data.TacoRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @SessionAttributes specifies any model objects like the order attribute
 * that should be kept in session and available across multiple requests
 */
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;
    private final TacoRepository tacoRepository;

    public DesignTacoController(IngredientRepository ingredientRepository, TacoRepository tacoRepository) {
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository = tacoRepository;
    }

    /**
     * ensures that an Order object will be created in the model
     * The order object remains in the session.
     * name - the name of the model attribute to bind to
     */
    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        Arrays.stream(Type.values()).forEach(type ->
                model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type)));
        model.addAttribute("design", new Taco());

        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

    /**
     * @param design @valid is a switch to validate taco design
     * @param errors
     * @param order
     * @return
     * @ModelAttribute - indicate that its value should come from the model
     * and that Spring MVC shouldn't attempt to bind request parameter to it.
     */
    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors, @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "design";
        }

        /**
         * save the Taco design
         * we'll do this in Chapter3
         */
        Taco saved = tacoRepository.save(design);
        order.addDesign(saved);
        log.info("Processing design: " + design);

        return "redirect:/orders/current";
    }

}
