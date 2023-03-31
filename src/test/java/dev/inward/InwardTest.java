package dev.inward;

import java.nio.file.spi.FileSystemProvider;
import java.util.List;


public class InwardTest {

    void listProviders() {
        System.out.println(fileSystemProviders.toString());
    }
    List<FileSystemProvider> fileSystemProviders = FileSystemProvider.installedProviders();

}
