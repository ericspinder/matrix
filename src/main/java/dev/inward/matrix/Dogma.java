package dev.inward.matrix;

import dev.inward.matrix.predictable.Predictable;
import dev.inward.matrix.info.Path_ofInfo;

import java.io.IOException;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.*;
import java.security.Principal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Dogma<I extends Dogma.Identity<I,D,F>,D extends Dogma<I,D,F>,F extends Dogma.FileAttributes<I,D,F>> extends Addressed<Path_ofInfo,String,I,D,Dogma.Representative<I,D,F>,F> implements Principal {

    public static class Identity<I extends Identity<I,D,F>,D extends Dogma<I,D,F>,F extends FileAttributes<I,D,F>> extends dev.inward.matrix.Identity<Path_ofInfo,String,I,D,Representative<I,D,F>,F> {

        @SafeVarargs
        public Identity(String s, Index<Path_ofInfo, ?>... indices) {
            super(s, indices);
        }

        @Override
        public Library<?, ?, Path_ofInfo> getLibrary() {
            return null;
        }

        @Override
        public Predictable<Path_ofInfo, I,D,Dogma.Representative<I,D,F>,F> newWatchService() {
            return null;
        }


        @Override
        public WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
            return null;
        }
    }
    public static class Representative<I extends Dogma.Identity<I,D,F>,D extends Dogma<I,D,F>,F extends Dogma.FileAttributes<I,D,F>> extends dev.inward.matrix.Representative<Path_ofInfo,String,I,D,Representative<I,D,F>,F> {

        public Representative(D addressed, Resource<Path_ofInfo, String, I, D, Representative<I,D,F>,F> resource, Properties initFileAttributes) {
            super(addressed, resource, initFileAttributes);
        }
    }
    public static class House extends Dogma<House.Identity,House> implements GroupPrincipal {

        protected final Map<Persona, AclEntry[]> personaRightsMap = new ConcurrentHashMap<>();
        public House(Identity identity, Map<Persona, AclEntry[]> personaRightsMap) {
            super(identity);
            if (personaRightsMap != null) {
                this.personaRightsMap.putAll(personaRightsMap);
            }
        }
        public static class Identity extends Dogma.Identity<Identity,House> {

            @SafeVarargs
            public Identity(String s, Index<Path_ofInfo, ?>... indices) {
                super(s, indices);
            }
        }
        public static class FileAttributes extends Dogma.FileAttributes<Identity,House> {

            public FileAttributes(House house) {
                super(house);
            }
        }
    }
    public static class Agent extends Dogma<Agent.Identity,Agent> implements UserPrincipal {

        protected final Map<House, AclEntry[]> houseRightsMap = new ConcurrentHashMap<>();
        public Agent(Identity identity,Map<House,AclEntry[]> houseRightsMap) {
            super(identity);
            if (houseRightsMap != null) {
                this.houseRightsMap.putAll(houseRightsMap);
            }
        }


        public static class Identity extends Dogma.Identity<Identity,Agent> {

            @SafeVarargs
            public Identity(String s, Index<Path_ofInfo, ?>... indices) {
                super(s, indices);
            }
        }
        public static class FileAttributes extends Dogma.FileAttributes<Identity,Agent> {

            public FileAttributes(Agent agent) {
                super(agent);
            }
        }
    }

    public static class Persona extends Dogma<Persona.Identity,Persona> {

        public Persona(Identity identity) {
            super(identity);
        }

        public static class Identity extends Dogma.Identity<Identity,Persona> {

            @SafeVarargs
            public Identity(String s, Index<Path_ofInfo,?>... indices) {
                super(s, indices);
            }
        }
        public static class FileAttributes extends Dogma.FileAttributes<Identity,Persona> {

            public FileAttributes(Persona persona) {
                super(persona);
            }
        }
    }
    public Dogma(I identity) {
        super(identity);
    }

    @Override
    public String getName() {
        return this.fileKey.id;
    }

    @Override
    public int compareTo(D that) {
        return this.fileKey.compareTo(that.fileKey);
    }

    public static class FileAttributes<I extends Identity<I,D,F>,D extends Dogma<I,D,F>,F extends FileAttributes<I,D,F>> extends dev.inward.matrix.FileAttributes<Path_ofInfo,I,D,Representative<I,D,F>,F> {

        public FileAttributes(D dogma) {
            super(dogma);
        }

        @Override
        public boolean isRegularFile() {
            return false;
        }

        @Override
        public boolean isDirectory() {
            return false;
        }

        @Override
        public boolean isSymbolicLink() {
            return false;
        }

        @Override
        public boolean isOther() {
            return true;
        }
    }
}
