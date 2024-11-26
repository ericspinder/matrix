package dev.inward.matrix;

import dev.inward.matrix.director.library.catalog.Ledger;
import dev.inward.matrix.fact.Addressed;
import dev.inward.matrix.fact.Expire;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributeView;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public abstract class Index<PATH extends Comparable<PATH>,I extends Index<PATH,I>> implements Comparable<I>, BasicFileAttributeView {

    protected final Ledger<PATH> ledger;
    protected final FileAttributes fileAttributes;

    protected final PATH path;
    protected final Map<Concept.Gathering<PATH,?,?,?,?,?>, Instant> conceptsLastGathered = new HashMap<>();
    protected final Map<Notion.Gathering<PATH,?,?,?,?,?>,Instant> notionsLastGathered = new WeakHashMap<>();

    protected AtomicInteger conceptsAdded;

    public Index(Ledger<PATH> ledger, PATH path, Properties properties) {
        this.ledger = ledger;
        this.path = path;
        this.fileAttributes = new FileAttributes(properties);
    }

    public static class FileAttributes extends dev.inward.matrix.FileAttributes {

        public FileAttributes(Properties properties) {
            super(properties);
        }

        @Override
        public boolean isRegularFile() {
            return false;
        }

        @Override
        public boolean isDirectory() {
            return true;
        }

        @Override
        public boolean isSymbolicLink() {
            return false;
        }

        @Override
        public boolean isOther() {
            return false;
        }
    }
//    public static class Branched<PATH extends Comparable<PATH>> extends Index<PATH,Branched<PATH>> {
//
//        protected final Branch branch;
//
//        public Branched(Ledger<PATH> ledger, PATH path, Properties properties, Branch branch) {
//            super(ledger,path,properties);
//            this.branch = branch;
//        }
//
//        public Branch getBranch() {
//            return branch;
//        }
//
//        @Override
//        public String getPathString() {
//            return null;
//        }
//
//        @Override
//        public int compareTo(Branched<PATH> that) {
//            int isZero = this.ledger.compareTo(that.ledger);
//            if (isZero == 0) {
//                isZero = this.branch.compareTo(that.branch);
//            }
//        }
//    }
//    public static class Worker<PATH extends Comparable<PATH>> extends Index<PATH,Worker<PATH>> {
//
//        protected final Service<PATH,?,?,?,?,?,?,?,?,?,?> service;
//
//        public Worker(Ledger<PATH> ledger, PATH path, Properties properties, Service<PATH,?,?,?,?,?,?,?,?,?,?> service) {
//            super(ledger,path,properties);
//            this.service = service;
//        }
//
//        public Service<PATH,?,?,?,?,?,?,?,?,?,?> getService() {
//            return service;
//        }
//
//        @Override
//        public String getPathString() {
//            return null;
//        }
//    }

}


