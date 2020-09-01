package com.king.generic;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * correct old type
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-06-15 10:22:26
 */
@Data
@NoArgsConstructor
public class GenericsType<T> {

    private T object;

    public GenericsType(T value) {
        this.object = value;
    }

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        /*
        [Good News]
        Here we don't need to do type-casting and we can remove ClassCastException at runtime.
         */
        GenericsType<String> type = new GenericsType<>();
        type.setObject("Pankaj"); // valid

        // [Warning] raw use of parameterized class 'GenericType'
        // [Resolve] @SuppressWarnings("rawtypes")
        GenericsType rawType = new GenericsType(); // raw type
        // [Warning] unchecked call to 'setObject' as a member of raw type 'GenericType'
        rawType.setObject("Pankaj"); // valid
        rawType.setObject(10); // valid and autoboxing support
    }

}
