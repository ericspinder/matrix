/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.item.datum.Seat;
import dev.inward.matrix.item.materilized.administrator.agent.Persona;
import dev.inward.matrix.route.Ticket;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Bus<TARGET,V extends View<TARGET,V,M>, M extends Model<TARGET,V,M>,S extends Seat<TARGET,V,M>> {

    protected final Map<S, Ticket<?>> seats;

    public Bus(Class<? extends Map<S,Persona>> seatingPlan) {
        try {
            this.seats = seatingPlan.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}
