package dev.inward.matrix.route;

import dev.inward.matrix.Meta_I;

public enum Passage implements Meta_I {
        NEW("new","Driver has not started his Route"),
        First_Route("first route","new Driver"),
        COMPLETING("completing", "Driver is completing his route"),
        HOLD("hold","Waiting for work"),
        EXCEPTIONAL("exceptional","Exceptional"),
        CANCELLED("cancelled","Cancelled"),
        POOLED("pooled","Pooled"),
        LOANED("loaned","Loaned"),
        ;
        final String label;
        final String description;
        Passage(String label, String description) {
            this.label = label;
            this.description = description;
        }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }
}
