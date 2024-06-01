package dev.inward.matrix.authority.source;

import dev.inward.matrix.Terrene;
import dev.inward.matrix.authority.dns.resourceRecord.ResourceRecord;
import dev.inward.matrix.authority.dns.resourceRecord.ResourceRecordType;
import dev.inward.matrix.authority.dns.resourceRecord.ServerRecord;
import dev.inward.matrix.Identity;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.report.DefaultFailure;
import dev.inward.matrix.Host;
import dev.inward.matrix.fact.authoritative.notion.authority.SubjectMatter;
import dev.inward.matrix.fact.authoritative.notion.authority.source.ziggurat.Ziggurat;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Source extends Host<String> {

//    protected final Map<Edition, Registrar> editionRegistrarMap;
    protected Map<String, SubjectMatter[]> subjectMatterServers;

    public Source(Identity.Ghost id, Controller.Matrix controller, Map<Terrene, ServerRecord[]> nameservers, SubjectMatter[] subjectMatterServers) {
        super(id,controller,nameservers);

        for (SubjectMatter subjectMatter: subjectMatterServers) {
            this.subjectMatterServers.put(makeSubjectMatterKey(subjectMatter.getInternetClass(),subjectMatter.getIndicia().getLocus()),subjectMatter);
        }
    }
    public void replaceSubjectMatterServers(SubjectMatter[] subjectMatterServers) {

    }
    public final String makeSubjectMatterKey(Terrene terrene, String locus) {
        return new StringBuilder().append(terrene.terrene).append(locus).toString();
    }

    @Override
    public ResourceRecord[] getResourceRecords(String servername, ResourceRecordType[] resourceRecordTypes) {
        return new ResourceRecord[0];
    }

    /**
     *
     * @param indicia the Matter's indicia, the method gets both the InternetClass and the Locus
     * @param createInstant the instant the Matter was created
     * @param ego the containerId which was being accessed
     * @return The SubjectMatter using an appropriate date range
     */
    public SubjectMatter getSubjectMatterServers(Indicia indicia, Instant createInstant, Identity.Ego ego) {
        SubjectMatter result = null;
        SubjectMatter[] allSubjectMatterDates = this.subjectMatterServers.get(makeSubjectMatterKey(indicia.getInternetClass(),indicia.getLocus()));
        if (allSubjectMatterDates.length > 0) {
            result = getByDate(allSubjectMatterDates,createInstant);
        }
        else {
            result = getByDate(this.subjectMatterServers.get(makeSubjectMatterKey(indicia.getInternetClass(),"*")),createInstant);
        }
        if (result == null) {
            Map<String,Object> details = new HashMap<>();
            details.put("details","Cannot place SubjectMatter for a date");
            details.put("solution", "make sure that every InternetClass has a * locus and it has a max end date");
            details.put("createDate", createInstant);
            DefaultFailure defaultFailure = new DefaultFailure(this.identity,ego, Instant.now(),"dev.inward.source.fact.notion.authority", Terrene.Aforementioned,details);
            SubjectMatter subjectMatter = ((Source)this.identity.getContext().getDomain().getAuthority()).getSubjectMatterServers(defaultFailure.getIndica(),defaultFailure.getModificationInstant(), ego);
            if (subjectMatter == null) {
                System.out.println(defaultFailure);
            }
            Ziggurat ziggurat =
        }
        return result;

    }
    private SubjectMatter getByDate(SubjectMatter[] allSubjectMatterDates,Instant createDate) {
        for (SubjectMatter subjectMatter: allSubjectMatterDates) {
            if (createDate.isAfter(subjectMatter.getStartInstant())&& createDate.isBefore(subjectMatter.getEndInstant())) {
                return subjectMatter;
            }
        }
        return null;
    }

}
