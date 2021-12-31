package com.notionds.dataSupplier.advisor;

import com.notionds.dataSupplier.meta.Meta_I;

public class Matter {

    private final String name;
    private final Footing footing;
    private final Locus locus;
    private final Boolean goodThing;

    public Matter(String name, Footing footing, Locus locus, Boolean goodThing) {
        this.name = name;
        this.footing = footing;
        this.locus = locus;
        this.goodThing = goodThing;
    }

    public enum Footing implements Meta_I {
        Ending("Ending","unable to execution of process","dev.inward.matter.footing.ending"),
        Changing("Changing","","dev.inward.matter.footing.changing"),
        Deleting("Deleting", "Something was deleted","dev.inward.matter.footing.deleting"),
        Monitory("Monitory", "Locus is providing information on a monitory matter, generally a regularly emitted item for observation and may indicate an adverse state","dev.inward.matter.footing.monitory"),
        Admonitory("Admonitory", "Locus is providing information on an admonitory matter, ", "dev.inward.matter.footing.admonitory"),
        Integral("Integral", "Locus is providing information on an integral matter", "dev.inward.matter.footing.integral"),
        ;
        private final String name;
        private final String description;
        private final String i18n;
        Footing(final String name, final String description, final String i18n) {
            this.name = name;
            this.description = description;
            this.i18n = i18n;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public String getI18n() {
            return i18n;
        }
    }
    public enum Locus implements Meta_I {
        Trace("Trace", "An report from the use of instance's method", "dev.inward.matter.locus.trace"),
        Notion_Report("Report","A notion is reporting an error it encountered", "dev.inward.matter.locus.notion"),
        Chronicle_Related("","A chronicle error", "dev.inward.matter.locus.chronicle"),
        Factory_Concern("Factory Concern", "","dev.inward.matter.locus.factory"),
        Platform_Issue("Platform Issue","","dev.inward.matter.locus.platform"),
        System_Wide("System Wide","An unexpected occurrence", "dev.inward.matter.locus.system"),
        ;
        private final String name;
        private final String description;
        private final String i18n;
        Locus(final String name, final String description, final String i18n) {
            this.name = name;
            this.description = description;
            this.i18n = i18n;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public String getI18n() {
            return i18n;
        }
    }
}
