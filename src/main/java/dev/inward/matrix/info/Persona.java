package dev.inward.matrix.info;

import dev.inward.matrix.Index;

import java.util.Properties;

public class Persona extends Dogma<Persona.Identity, Persona, Persona.Representative, Persona.PersonaAttributes> {

    public Persona(Identity identity) {
        super(identity);
    }

    public static class Identity extends Dogma.Identity<Identity,Persona,Persona.Representative,PersonaAttributes> {

        public Identity(String s, Index<Path_ofInfo> index) {
            super(s, index);
        }
    }

    public static class Representative extends Dogma.Representative<Identity, Persona,Representative,PersonaAttributes> {

        public Representative(Persona addressed, Resource<Identity, Persona, Representative, PersonaAttributes> resource) {
            super(addressed, resource);
        }
    }
    public static class PersonaAttributes extends Dogma.DogmaAttributes<Identity, Persona,Representative,PersonaAttributes        > {

        public PersonaAttributes(Properties properties, long size) {
            super(properties, size);
        }
    }
}
