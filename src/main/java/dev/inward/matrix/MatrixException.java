package dev.inward.matrix;

import dev.inward.matrix.fact.matter.Indicia;

public class MatrixException extends Blocker {

    public enum Type {
        NotRightScheme("Not the right scheme, mismatched"),
        VisitorFailed("Class Visitor failed to operate"),
        ReflectiveOperationFailed("A reflective operation failed to instantiate class"),
        BadCastToGeneric("A bad cast when trying to retrieve a value"),
        Cannot_Update_Timer("Cannot update timer object with new finish time once set"),
        Catalog_not_initialized("Catalog not initialized"),
        ConstructorProblem_Reflective("Unable to create needed constructor, reflective operation failed"),
        ConstructorProblem_WrongClass("Unable to find needed constructor, likely should be using a different class"),
        ClassCastException("Unable to cast to needed class"),
        CodeSigners_not_initialized("Code Signer not initialized"),
        Domain_not_initialized_malformed_URL("Domain not initialized, malformed URL"),
        InSitu_already_init("InSitu already initialized, see Fidelity.Aforementioned"),
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
        Terrene_Not_Among_Known_Worlds("Terrene is not among known worlds"),
        UnableToStartJMX_className("JMX failed to start; class not found"),
        UnknownHost("unknown host");
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

    public MatrixException(Type type, String locus, Indicia.Focus focus, Indicia.Severity severity, Exception e) {
        super(locus,focus,severity,e);
        this.type = type;
    }


}
