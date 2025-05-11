/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.local;

import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.predictable.Director;

import java.util.HashMap;
import java.util.Map;

public class  Local implements Control<Local,LocalView,LocalModel> {

    public Local(LocalModel localModel) {
        this.localModel = localModel;
    }
    protected Map<String, Director> directorByTerrene_Domain = new HashMap<>();

    public void addDirector(Domain domain, Director director) {
        this.directorByTerrene_Domain.put(domain.getTerrene() + "_" + domain.getDomainName(), director);
    }
    public void removeDirector(Domain domain) {
        this.directorByTerrene_Domain.remove(domain.getTerrene() + "_" + domain.getDomainName());
    }
}
