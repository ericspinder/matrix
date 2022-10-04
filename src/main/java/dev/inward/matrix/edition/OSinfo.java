package dev.inward.matrix.edition;

import dev.inward.matrix.NotionStartupException;
import dev.inward.matrix.matter.Indicia;

import java.util.Locale;

public class OSinfo {
    public enum OS {
        WINDOWS,
        UNIX,
        POSIX_UNIX,
        MAC,
        OTHER;
    }

    protected final OS os;
    protected final String version;

    public OSinfo() {
        this.os = parseOS();
        this.version = System.getProperty("os.version");
    }
    private OS parseOS() {
        String osName = System.getProperty("os.name");
        if (osName == null) {
            throw new NotionStartupException(NotionStartupException.Type.UnableToParseOS, this.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Unexpected,null);
        }
        osName = osName.toLowerCase(Locale.ENGLISH);
        if (osName.contains("windows")) {
            return OS.WINDOWS;
        } else if (osName.contains("linux")
                || osName.contains("mpe/ix")
                || osName.contains("freebsd")
                || osName.contains("irix")
                || osName.contains("digital unix")
                || osName.contains("unix")) {
            return OS.UNIX;
        } else if (osName.contains("mac os")) {
            return OS.MAC;
        } else if (osName.contains("sun os")
                || osName.contains("sunos")
                || osName.contains("solaris")) {
            return OS.POSIX_UNIX;
        } else if (osName.contains("hp-ux")
                || osName.contains("aix")) {
            return OS.POSIX_UNIX;
        } else {
            return OS.OTHER;
        }
    }
    public OS getOs() {
        return os;
    }
    public String getVersion() {
        return version;
    }
}
