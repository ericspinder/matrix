/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.http;

import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.scheme.SchemeView;

public class HttpSchemeView extends SchemeView<HttpScheme,HttpSchemeView,HttpSchemeModel,HttpLibrary,HttpLibraryView,HttpLibraryModel,HttpAuthority,HttpAuthorityView,HttpAuthorityModel,HttpDirectory,HttpDirectoryKey,HttpDirectoryView,HttpDirectoryModel,HttpDirectoryLibrarian,HttpDirectoryContext,String> {

    public HttpSchemeView(String name, Control control) {
        super(name, control);
    }
}
