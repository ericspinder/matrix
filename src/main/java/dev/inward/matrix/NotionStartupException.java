package dev.inward.matrix;

import dev.inward.matrix.datum.fact.matter.Indicia;
import crud.rubric.Blocker;

public class NotionStartupException extends Blocker {

    public enum Type {
        VisitorFailed("Class Visitor failed to operate"),
        ReflectiveOperationFailed("A reflective operation failed to instantiate class"),
        BadCastToGeneric("A bad cast when trying to retrieve a value"),
        Cannot_Update_Timer("Cannot update timer object with new finish time once set"),
        ConstructorProblem_Reflective("Unable to create needed constructor, reflective operation failed"),
        ConstructorProblem_WrongClass("Unable to find needed constructor, likely should be using a different class"),
        ClassCastException("Unable to cast to needed class"),
        MissingDefaultValue("Missing a default value"),
        MissMatchedOptionKey("Option key was not set for proper instance value"),
        NetworkUnavailable_No_Return("Problem gaining network details"),
        NotImplemented("Not implemented"),
        Pickup_Not_Set("The thread doesn't contain a fact when processing DATUM on Bus"),
        WAITED_TOO_LONG_FOR_CONNECTION("Waited too long for a connection"),
        SoftReference_Problem("SoftReference problem"),
        Recursion("Unlikely Recursion"),
        TEST_CONNECTION_FAILURE("A fatal error in when running the startup connection test"),
        Timeout_On_Non_Containerized_Notion("A timeout occurred ona non containerized Notion, which has been hard closed by default"),
        No_Failover_Available("No Connection Suppliers in failover stack"),
        UnableToParseOS("Unable to parse Operating using using the System Property: 'os.name'"),
        UnableToChangeJXM("Unable to change JMX after it been loaded"),
        UnableToStartJMX_className("JMX failed to start; class not found"),
        ;
        private final String description;
        Type(String description) {
            this.description = description;
        }
        public String getDescription() {
            return this.description;
        }
    }
    public final Type type;
    public final Class where;

    public NotionStartupException(Type type, Class where, Indicia.Focus focus, Indicia.Severity severity, Exception e) {
        super(where.getCanonicalName(),focus,severity,e);
        this.type = type;
        this.where = where;
    }


}
