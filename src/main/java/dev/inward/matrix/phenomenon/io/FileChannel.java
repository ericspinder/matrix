package dev.inward.matrix.phenomenon.io;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.engine.Role;
import dev.inward.matrix.phenomenon.producer.communications.Network;

import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.time.Duration;

public class FileChannel extends InputOutput<AsynchronousFileChannel>  {

    protected final Path path;
    protected OpenOption[] options;
    public FileChannel(Context.Demarc ethereal, Duration defaultTimeout, long sleep, long snooze, Network network, Role role, Path path, O) {
        super(ethereal, defaultTimeout, sleep, snooze, network, role);
        this.path = path;
    }

    @Override
    protected AsynchronousFileChannel init() {
        AsynchronousFileChannel.open(path,)
    }

    @Override
    public int compareTo(InputOutput<AsynchronousFileChannel> o) {
        return 0;
    }
}
