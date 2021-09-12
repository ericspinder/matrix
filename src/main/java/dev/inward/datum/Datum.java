package dev.inward.datum;

import dev.inward.HouseKeeping;

import java.lang.reflect.ParameterizedType;

public abstract class Datum<F extends Comparable<F>> {

    private HouseKeeping houseKeeping;

    private Class<F> factClass;

    public Datum(HouseKeeping houseKeeping) {
        this.houseKeeping = houseKeeping;
        this.factClass = (Class<F>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void update(F fact)

}
