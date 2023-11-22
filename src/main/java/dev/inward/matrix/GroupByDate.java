package dev.inward.matrix;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class GroupByDate implements Comparable<GroupByDate> {

    protected final String date;
    protected final DateTimeFormatter formatter;
    protected final int hashcode;

    public GroupByDate(String date, DateTimeFormatter formatter) {
        this.date = date;
        this.formatter = formatter;
        this.hashcode = Objects.hash(formatter.parse(date));
    }

    public final String getDate() {
        return date;
    }

    public final DateTimeFormatter getFormatter() {
        return formatter;
    }

    @Override
    public int compareTo(GroupByDate that) {
        return this.hashcode - that.hashcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupByDate)) return false;
        GroupByDate that = (GroupByDate) o;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return hashcode;
    }
}
