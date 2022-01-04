package com.notionds.dataSupplier.operational;

import com.notionds.dataSupplier.meta.Meta;
import com.notionds.dataSupplier.task.Conditions;
import com.notionds.dataSupplier.task.Request;
import com.notionds.dataSupplier.task.Result;
import com.notionds.dataSupplier.task.Task;

public abstract class TaskOption<C extends Conditions, R extends Result<Q>,Q extends Request> extends Meta<Task<C,R,Q>> {

    TaskOption(String label, String description, String i18n, Task<C,R,Q> defaultValue) {
        super(label,description,i18n,defaultValue);
    }

}
