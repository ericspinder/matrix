package dev.inward.matrix.crud;


import dev.inward.matrix.Recommendation;

public interface NotionExceptionWrapper {

    String getMessage();
    Recommendation getRecommendation();
    Throwable getCause();
}
