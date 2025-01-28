package dev.inward.matrix;


import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.concurrent.atomic.AtomicLong;

public interface FileAttributes<PATH extends Comparable<PATH>,K extends FileKey<PATH,K,FILE,F>,FILE extends MatrixFile<PATH,K,FILE,F>,F extends FileAttributes<PATH,K,FILE,F>> extends BasicFileAttributes {


}
