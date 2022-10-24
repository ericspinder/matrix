package dev.inward.matrix.datum.fact.notion.interaction.dns;

public class ResourceRecord {

    public enum InternetClass {
        Internet("IN","Default"),
        Helios("HS","Helios"),
        Chaosnet("CS", "Chaosnet"),
        ;
        public final String code;
        public final String description;
        InternetClass(String code,String description) {
            this.code = code;
            this.description = description;
        }
    }
    protected final Domain domain;
    protected final ResourceRecordType resourceRecordType;

    public ResourceRecord(Domain domain, ResourceRecordType resourceRecordType) {
        this.domain = domain;
        this.resourceRecordType = resourceRecordType;
    }

    public Domain getDomain() {
        return domain;
    }

    public ResourceRecordType getResourceRecordType() {
        return resourceRecordType;
    }
}
