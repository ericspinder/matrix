/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.file.directory.DirectoryView;

public class HttpDirectoryView extends DirectoryView<HttpDirectory,HttpDirectoryKey,HttpDirectoryView,HttpDirectoryModel,HttpDirectoryReference,HttpDirectoryLibrarian,String> {

    public HttpDirectoryView(String name, HttpDirectory httpDirectory) {
        super(name, httpDirectory);
    }
}
