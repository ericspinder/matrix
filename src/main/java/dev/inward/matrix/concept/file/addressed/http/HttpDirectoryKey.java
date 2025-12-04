/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.file.addressed.http;

import dev.inward.matrix.concept.file.directory.DirectoryKey;

import java.net.URI;

public class HttpDirectoryKey extends DirectoryKey<HttpDirectory,HttpDirectoryKey,HttpDirectoryView,HttpDirectoryModel, HttpDirectoryReference, HttpDirectoryLibrarian,String> {
    protected HttpDirectoryKey(URI uri, String directoryPath) {
        super(uri, directoryPath);
    }
}
