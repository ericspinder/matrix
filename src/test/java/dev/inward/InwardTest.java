package dev.inward;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URL;
import java.nio.file.spi.FileSystemProvider;
import java.util.List;


public class InwardTest {

    void listProviders() {
        System.out.println(fileSystemProviders.toString());
    }
    List<FileSystemProvider> fileSystemProviders = FileSystemProvider.installedProviders();


    @Test
    void testMethod() {

        URI uri = URI.create("https://user@localhost:8080");
        System.out.println(uri.getSchemeSpecificPart());
        System.out.println(uri.getUserInfo());
    }
}
