package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.domain.Authority;
import dev.inward.matrix.engine.Zone;

public abstract class Context<X extends Context<X>> implements Comparable<X> {

    public static final char PRODUCTION = '\u0000';

    protected final String serverName;
    protected final Zone zone;
    protected final Authority authority;
    protected final char testCode;

    public Context(String serverName, Authority authority, Zone zone, char testCode) {
        this.serverName = serverName;
        this.authority = authority;
        this.zone = zone;
        this.testCode = testCode;
    }

    public Domain getDomain() {
        return domain;
    }

    public boolean isProduction() {
        return this.testCode == '\u0000';
    }

    public static class Service extends Platform<Service> {

        protected final String name;
        public Service(Domain domain, Zone zone,char testCode, String name) {
            super(domain,zone,testCode);
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

    public static class Ethereal extends Platform<Ethereal> {
        public Ethereal(Domain domain,Zone zone) {
            super(domain,zone,PRODUCTION);
        }
        @Override
        public int compareTo(Ethereal that) {
            if (this.domain == null && that.domain == null) {
                return 0;
            }
            if (this.domain == null) {
                return 1;
            }
            if (that.equals(null)) {
                return -1;
            }
            int isZero = this.domain.compareTo(that.domain);
            if (isZero == 0) {
                return this.zone.compareTo(that.domain);
            }

        }
    }
    public static class Demarc extends Platform<Demarc> {
        protected final byte[] demarc;
        protected final Ethereal ethereal;
        public Demarc(Domain domain, Zone zone, byte[] demarc, Ethereal ethereal) {
            super(domain,zone,PRODUCTION);
            this.demarc = demarc;
            this.ethereal = ethereal;
        }
        public byte[] demarc() {
            return this.demarc;
        }
        public Ethereal ethereal() {
            return this.ethereal;
        }
        public String getAsPrettyMacAddress() {
            String[] hexadecimal = new String[demarc.length];
            for (int i = 0; i < demarc.length; i++) {
                hexadecimal[i] = String.format("%02X", demarc[i]);
            }
            return String.join("-", hexadecimal);
        }
    }
    public static class Platform<X extends Platform<X>> extends Context<X> {
        public Platform(Domain domain, Zone zone, char testCode) {
            super(domain,zone,testCode);
        }
    }
    public static class Character<X extends Character<X>> extends Context<X> {

        protected char character;

        public Character(Domain domain, Zone zone, char testCode, char character) {
            super(domain,zone, testCode);
            this.character = character;
        }
    }
    public static class Web extends Character<Web> {
        public Web(Domain domain, Zone zone, char testCode) {
            super(domain,zone,testCode,'/');
        }
    }
    public static class Home extends Character<Home> {
        public Home(Domain domain, Zone zone,char testCode) {
            super(domain,zone,testCode,'~');
        }
    }

    public int compareTo(X that) {
        int isZero = this.domain.compareTo(that.domain);
        if (isZero == 0) {
            if (this.isProduction() && that.isProduction()) {
                return 0;
            }
            if (this.isProduction()) {
                return 1;
            }
            return (int) this.testCode - (int) that.testCode;
        }
        return isZero;
    }
}
