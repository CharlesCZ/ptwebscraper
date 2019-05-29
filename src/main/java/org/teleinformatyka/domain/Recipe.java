package org.teleinformatyka.domain;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Recipe {

    @Id
    private String id;
   // @UniqueElements
    private String title;
    private String ingredients;
    private String instructions;





    @Override
    public String toString() {
        return
                "\n"+"title"+"\n"+  title  +
                "\n"+"ingredients" +"\n"+ ingredients  +
                "\n"+"instructions" +"\n"+ instructions;
    }
}
