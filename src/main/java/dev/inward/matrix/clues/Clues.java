package dev.inward.matrix.clues;

import dev.inward.matrix.advisor.NotionStartupException;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Subject;

import java.util.HashMap;

public class Clues<X extends Context<X>> extends HashMap<Class<?>,Clue<X,?>> {

    @SuppressWarnings("unchecked")
    public <EXHIBIT,CLUE extends Clue<X,EXHIBIT>> CLUE get(Class<CLUE> clueClass, X context) {
        return (CLUE) super.getOrDefault(clueClass,this.initDefault(clueClass, context));
    }
    public <EXHIBIT,CLUE extends Clue<X,EXHIBIT>> CLUE initDefault(Class<CLUE> clueClass,X context) {
        try {
            return clueClass.getDeclaredConstructor(context.getClass()).newInstance(context);
        } catch (ReflectiveOperationException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Subject.Focus.Admonitory, Subject.Severity.Exceptional,e);
        }
    }
}
