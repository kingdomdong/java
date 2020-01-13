package tacos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

import static lombok.AccessLevel.PRIVATE;

/**
 * @RequiredArgsConstructor required arguments are final fields and fields with constrains such as @NonNull
 */
@Data
@RequiredArgsConstructor
//@NoArgsConstructor(access = PRIVATE, force = true)
//@Entity
public class Ingredient {

//    @Id
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}
