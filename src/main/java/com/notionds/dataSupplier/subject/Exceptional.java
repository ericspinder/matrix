package com.notionds.dataSupplier.subject;

import java.io.PrintStream;
import java.io.PrintWriter;

public interface Exceptional {
    String getMessage();
    String getLocalizedMessage();
    java.lang.Throwable getCause();
    String toString();
    void printStackTrace();
    void printStackTrace(PrintStream s);
    void printStackTrace(PrintWriter s);
    StackTraceElement[] getStackTrace();
}
