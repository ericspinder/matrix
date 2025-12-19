/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.catalog.platform.unix;

import dev.inward.matrix.concept.catalog.platform.Platform;
import dev.inward.matrix.concept.fact.FactView;

import java.util.Map;

public abstract class Unix<BC extends Unix<BC,BV,BM>,BV extends UnixView<BC,BV,BM>,BM extends UnixBureauModel<BC,BV,BM>> extends Platform<BC,BV,BM> {
    public Unix(String name, boolean readOnly, BM unixBureauModel, Map<String, Object> attributes, Class<FactView<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>>[] supportedFileViews, String rootPath) {
        super(name,readOnly,unixBureauModel, attributes, supportedFileViews,rootPath);
    }

    @Override
    protected String parseRootPathForFileSystem(String rootPath) {
        if (rootPath != null && !rootPath.isEmpty()) {
            if (!rootPath.startsWith("/")) {
                throw new RuntimeException("if not empty or null, rootPath must start with / ");
            }
            return rootPath;
        }
        return "/";
    }
}
