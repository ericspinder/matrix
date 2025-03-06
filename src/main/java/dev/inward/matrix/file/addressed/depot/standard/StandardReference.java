/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.standard;

import dev.inward.matrix.file.addressed.depot.DepotReference;

public class StandardReference extends ConfigurationReference<StandardKey,Standard,StandardReference,StandardAttributes,StandardResource,StandardModel> {
    public StandardReference(Standard addressed, StandardResource resource) {
        super(addressed, resource);
    }
}
