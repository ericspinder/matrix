/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.catalog.platform;

import dev.inward.matrix.concept.catalog.Catalog;
import dev.inward.matrix.control.administration.Bureau;
import dev.inward.matrix.concept.fact.FactView;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.Map;


public abstract class Platform<PC extends Platform<PC,PV,PM>,PV extends PlatformView<PC,PV,PM>,PM extends PlatformModel<PC,PV,PM>> extends Catalog<PC,PV,PM> {

    protected final FileSystem defaultFileSystem = FileSystems.getDefault();

    public Platform(String name, boolean readOnly, PM platformModel, Map<String, Object> attributes, Class<FactView<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>>[] supportedFileViews, String rootPath) {
        super(name, readOnly,fileBureauModel,attributes, supportedFileViews);
        this.rootPath = rootPath;
    }

    protected abstract String parseRootPathForFileSystem(String rootPath);
}
