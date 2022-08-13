package dev.inward.matrix.clues;

import dev.inward.matrix.advisor.NotionStartupException;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Indicia;

import java.util.HashMap;

public class Clues<X extends Context<X>> extends HashMap<Class<?>,Clue<?>> {

    @SuppressWarnings("unchecked")
    public <EXHIBIT,CLUE extends Clue<EXHIBIT>> CLUE get(Class<CLUE> clueClass) {
        return (CLUE) super.getOrDefault(clueClass,this.initDefault(clueClass));
    }
    public <EXHIBIT,CLUE extends Clue<EXHIBIT>> CLUE initDefault(Class<CLUE> clueClass) {
        try {
            return clueClass.getDeclaredConstructor(clueClass).newInstance();
        } catch (ReflectiveOperationException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Exceptional,e);
        }
    }
}
