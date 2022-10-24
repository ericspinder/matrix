package dev.inward.matrix.personality;

import dev.inward.matrix.NotionStartupException;
import dev.inward.matrix.domain.Server;
import dev.inward.matrix.matter.Indicia;

import java.security.Permission;
import java.security.cert.CertPath;
import java.util.Map;
import java.util.Objects;

public class Psyche extends Permission {

    protected final String description;
    protected final CertPath credential;
    protected final Map<Server,Credential>

    public Psyche(String name, CertPath credential, String description) {
        super(name);
        this.credential = credential;
        this.description = description;
    }

    public boolean implies(Psyche psyche) {
        return this.getName().equals(psyche.getName());
    }
    @Override
    public void checkGuard(Object object) {
        throw new NotionStartupException(NotionStartupException.Type.NotImplemented,this.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Exceptional,null);
    }
    @Override
    public boolean implies(Permission permission) {
        if (permission instanceof Psyche) {
            return implies((Psyche) permission);
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, credential);
    }

    @Override
    public String getActions() {
        return this.description;
    }
    public String getDescription() {
        return this.description;
    }
}
