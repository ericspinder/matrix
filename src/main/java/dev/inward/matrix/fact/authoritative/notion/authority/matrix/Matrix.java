package dev.inward.matrix.fact.authoritative.notion.authority.matrix;

import dev.inward.matrix.authority.InternetClass;
import dev.inward.matrix.authority.ResourceRecord;
import dev.inward.matrix.authority.ResourceRecordType;
import dev.inward.matrix.authority.ServerRecord;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.report.DefaultFailure;
import dev.inward.matrix.authority.Authority;
import dev.inward.matrix.fact.authoritative.notion.authority.SubjectMatter;
import dev.inward.matrix.fact.authoritative.notion.authority.matrix.ziggurat.Ziggurat;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Matrix extends Authority<String,Instan> {

//    protected final Map<Edition, Registrar> editionRegistrarMap;
    protected Map<String, SubjectMatter[]> subjectMatterServers;

    public Matrix(Identity.Ghost id, Controller.Matrix controller, Map<InternetClass, ServerRecord[]> nameservers, SubjectMatter[] subjectMatterServers) {
        super(id,controller,nameservers);

        for (SubjectMatter subjectMatter: subjectMatterServers) {
            this.subjectMatterServers.put(makeSubjectMatterKey(subjectMatter.getInternetClass(),subjectMatter.getIndicia().getLocus()),subjectMatter);
        }
    }
    public void replaceSubjectMatterServers(SubjectMatter[] subjectMatterServers) {

    }
    public final String makeSubjectMatterKey(InternetClass internetClass, String locus) {
        return new StringBuilder().append(internetClass.authorityCode).append(locus).toString();
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
            DefaultFailure defaultFailure = new DefaultFailure(this.identity,ego, Instant.now(),"dev.inward.matrix.fact.notion.authority",InternetClass.Aforementioned,details);
            SubjectMatter subjectMatter = ((Matrix)this.identity.getContext().getDomain().getAuthority()).getSubjectMatterServers(defaultFailure.getIndica(),defaultFailure.getModificationInstant(), ego);
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
