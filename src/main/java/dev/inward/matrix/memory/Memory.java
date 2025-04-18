/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory;

import dev.inward.matrix.Datum;

import java.nio.file.FileStore;

public abstract class Memory<MB extends MemoryLibrarian<MB,MD,MV,MM,MR,MT>,MD extends Memory<MB,MD,MV,MM,MR,MT>,MV extends MemoryView<MB,MD,MV,MM,MR,MT>,MM extends MemoryModel<MB,MD,MV,MM,MR,MT>,MR extends MemoryReference<MB,MD,MV,MM,MR,MT>,MT extends MemoryLibrarian<MB,MD,MV,MM,MR,MT>> extends FileStore implements Datum<MB,MD,MV,MM,MR,MT> {
}
