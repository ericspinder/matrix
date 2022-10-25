package dev.inward.matrix.datum.fact;

import dev.inward.matrix.NotionStartupException;
import dev.inward.matrix.datum.Identity;

import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.domain.Server;
import dev.inward.matrix.engine.Induction;
import dev.inward.matrix.matter.Indicia;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.report.Report;
import dev.inward.matrix.phenomenon.producer.settlement.Settlement;
import dev.inward.matrix.resources.Resources;
import dev.inward.matrix.resources.Supplier;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.datum.Standard;

import java.lang.reflect.InvocationTargetException;

public abstract class Operational<F extends Fact<F,I,X,R,NI,NX>,O extends Operational<F,O,I,X,B,R,N,NI,NX,A,U>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,I,X,B,R,N,NI,NX,A,U>,R extends Representative<F,I,X,R,NI,NX>,N extends Notion<N,NI,NX,A>,NI extends Identity<NI,NX>,NX extends Context<NX>,A extends Agent<N,NI,NX,A>,U extends Resources<F,I,X,R,NI,NX>> {

    protected final Zone zone;
    protected final Supplier<?,F,O,I,X,B,R,N,NI,NX,A,U> supplier;
    protected final Specification<F,I,X> specification;

    public Operational(Zone zone, Specification<F,I,X> specification, Supplier<Y,F,O,I,X,B,R,N,NI,NX,A> supplier) {
        this.zone = zone;
        this.specification = specification;
        this.supplier = supplier;
        for (Standard standard: specification.getStandards(zone)) {
            inductionMap.put(standard.getDatumClassName(), this.initDatumClass(standard));
        }
    }
    protected Induction<F,O,I,X,B,R,N,NI,NX,A> initDatumClass(Standard standard) {
        try {
            return (Induction) Class.forName(standard.getInductionClassName()).getConstructor(String.class).newInstance(standard.getDatumClassName());
        }
        catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException(NotionStartupException.Type.ConstructorProblem_Reflective,this.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Exceptional,e);
        }
    }

    public Supplier<Y,F,O,I,X,B,R,N,NI,NX,A> supplier() {
        return this.supplier;
    }

    public Specification<F,I,X> specification() {
        return this.specification;
    }

    public Settlement settle(Matter<?,I,X> matter) {
        Server[] servers = this.specification.indiciaServerMap.get(matter.getIndica());

    }

    public void report(Report<NI, NX> report) {
        Server[] servers = this.specification.indiciaServerMap.get(report.getIndica());

    }
}
