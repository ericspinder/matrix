package dev.inward.matrix.phenomenon.io;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.threshold.Threshold;

import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.time.Duration;

public class FileChannel extends InputOutput<AsynchronousFileChannel>  {

    protected final Path path;
    protected OpenOption[] options;
    public FileChannel(Context.Demarc ethereal, Duration defaultTimeout, long sleep, long snooze, Threshold threshold, Path path) {
        super(ethereal, defaultTimeout, sleep, snooze, threshold);
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
