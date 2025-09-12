/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.file.directory.DirectoryReference;

public class HttpDirectoryReference extends DirectoryReference<HttpDirectory,HttpDirectoryKey,HttpDirectoryView,HttpDirectoryModel, HttpDirectoryReference, HttpDirectoryLibrarian,String> {
    public HttpDirectoryReference(HttpDirectory referent, HttpDirectoryLibrarian resource) {
        super(referent, resource);
    }
}
