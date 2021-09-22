package dev.inward.crud;

import dev.inward.fact.session.Engagement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Update<V extends Comparable<V>> extends CrudOperation<V>  {

    public abstract boolean beforeUpdate(Engagement engagement);

    public abstract boolean afterUpdate(Engagement engagement);

    public abstract boolean rollback(Engagement engagement);

}
