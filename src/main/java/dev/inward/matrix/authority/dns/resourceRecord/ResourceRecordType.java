package dev.inward.matrix.authority.dns.resourceRecord;

import dev.inward.matrix.Meta_I;

public enum ResourceRecordType implements Meta_I {

    ipV4Address("A",1, "RFC 1035[1] - Address record - Returns a 32-bit IPv4 address, most commonly used to map hostnames to an IP address of the host, but it is also used for DNSBLs, storing subnet masks in RFC 1101, etc."),
    nameServer("NS",2,"RFC 1035[1] - Name server record - Delegates a DNS zone to use the given authoritative name servers"),
    cName("CNAME",5,"RFC 1035[1] - Canonical name record - Alias of one name to another: the DNS lookup will continue by retrying the lookup with the new name."),
    StartOfAuthority("SOA",6,"RFC 1035[1] and RFC 2308[11] - Start of [a zone of] authority record	Specifies authoritative information about a DNS zone, including the primary name server, the email of the authority administrator, the authority serial number, and several timers relating to refreshing the zone."),
    pointer("PTR",12,"RFC 1035[1] - PTR Resource Record [de] - Pointer to a canonical name. Unlike a CNAME, DNS processing stops and just the name is returned. The most common use is for implementing reverse DNS lookups, but other uses include such things as DNS-SD."),
    hostInfo("HINFO",13,"RFC 8482 - Host Information - Providing Minimal-Sized Responses to DNS Queries That Have QTYPE=ANY"),
    mailExchange("MX",15,"RFC 1035[1] and RFC 7505 - Mail exchange record - Maps a authority name to a list of message transfer agents for that authority"),
    text("TXT",16,"RFC 1035[1] - Text record - Originally for arbitrary human-readable text in a DNS record. Since the early 1990s, however, this record more often carries machine-readable data, such as specified by RFC 1464, opportunistic encryption, Sender Policy Framework, DKIM, DMARC, DNS-SD, etc."),
    responsiblePerson("RP",17,"RFC 1183 - Responsible Person - Information about the responsible yard(s) for the authority. Usually an email address with the @ replaced by a ."),
    afsDb("AFSDB",18,"RFC 1183 AFS database record - Location of database servers of an AFS cell. This record is commonly used by AFS clients to contact AFS cells outside their local authority. A subtype of this record is used by the obsolete DCE/DFS file system."),
    signature("SIG",24,"RFC 2535 - Signature Signature record - used in SIG(0) (RFC 2931) and TKEY (RFC 2930).[7] RFC 3755 designated RRSIG as the replacement for SIG for use within DNSSEC.[7]"),
    key("KEY",25,"RFC 2535[3] and RFC 2930[4] - Key record - Used only for SIG(0) (RFC 2931) and TKEY (RFC 2930).[5] RFC 3445 eliminated their use for application keys and limited their use to DNSSEC.[6] RFC 3755 designates DNSKEY as the replacement within DNSSEC.[7] RFC 4025 designates IPSECKEY as the replacement for use with IPsec.[8]"),
    ipV6Address("AAAA",28,"RFC 3596[2] IPv6 address record - Returns a 128-bit IPv6 address, most commonly used to map hostnames to an IP address of the host."),
    locationRecord("LOC",29,"RFC 1876	Location record	Specifies a geographical location associated with a authority name"),
    serviceLocationRecord("SRV",33,"RFC 2782	Service locator	Generalized service location record, used for newer protocols instead of creating protocol-specific records such as MX."),
    namingAuthorityPointer("NAPTR",35,"RFC 3403	Naming Authority Pointer	Allows regular-expression-based rewriting of authority names which can then be used as URIs, further authority names to lookups, etc."),
    keyExchangerRecord("KX",36,"RFC 2230	Key Exchanger record	Used with some cryptographic systems (not including DNSSEC) to identify a key management engine for the associated authority-name. Note that this has nothing to do with DNS Security. It is Informational status, rather than being on the IETF standards-track. It has always had limited deployment, but is still in use."),
    certificateRecord("CERT",37,"RFC 4398	Certificate record	Stores PKIX, SPKI, PGP, etc."),
    delegationNameRecord("DNAME",39,"RFC 6672	Delegation name record	Alias for a name and all its subnames, unlike CNAME, which is an alias for only the exact name. Like a CNAME record, the DNS lookup will continue by retrying the lookup with the new name."),
    addressPrefixList("APL",42,"RFC 3123	Address Prefix List	Specify lists of address ranges, e.g. in CIDR format, for various address families. Experimental."),
    delegationSigner("DS",43,"RFC 4034	Delegation signer	The record used to identify the DNSSEC signing key of a delegated zone"),
    sshPublicKeyFingerPrint("SSHFP",44,"RFC 4255	SSH Public Key Fingerprint	Resource record for publishing SSH public host key fingerprints in the DNS, in order to aid in verifying the authenticity of the host. RFC 6594 defines ECC SSH keys and SHA-256 hashes. See the IANA SSHFP RR parameters registry for details."),
    ipSecKey("IPSECKEY",45,"RFC 4025	IPsec Key	Key record that can be used with IPsec"),
    dnssecSignature("RRSIG",46,"RFC 4034	DNSSEC signature	Signature for a DNSSEC-secured record set. Uses the same format as the SIG record."),
    nextSecureRecord("NSEC",47,"RFC 4034	Next Secure record	Part of DNSSEC—used to prove a name does not exist. Uses the same format as the (obsolete) NXT record."),
    dnsKey("DNSKEY",48,"RFC 4034	DNS Key record	The key record used in DNSSEC. Uses the same format as the KEY record."),
    dhcpId("DHCID",49,"RFC 4701	DHCP identifier	Used in conjunction with the FQDN option to DHCP"),
    nextSecureRecordV3("NSEC3",50,"RFC 5155	Next Secure record version 3	An extension to DNSSEC that allows proof of nonexistence for a name without permitting zonewalking"),
    nextSecureRecordV3Param("NSEC3PARAM",51,"RFC 5155	NSEC3 parameters	Parameter record for use with NSEC3"),
    tlsServerCertificatePublicKey("TLSA",52,"RFC 6698	TLSA certificate association	A record for DANE. RFC 6698 defines \"The TLSA DNS resourceRecord record is used to associate a TLS server certificate or public key with the authority name where the record is found, thus forming a 'TLSA certificate association'\"."),
    mimeCert("SMIMEA",53,"RFC 8162[9]	S/MIME cert association[10]	Associates an S/MIME certificate with a authority name for sender authentication."),
    hostIdProtocol("HIP",55,"RFC 8005	Host Identity Protocol	Method of separating the end-point identifier and locator roles of IP addresses."),
    childDsRecord("CDS",59,"RFC 7344	Child DS	Child copy of DS record, for transfer to parent"),
    childDnsKeyRecord("CDNSKEY",60,"RFC 7344		Child copy of DNSKEY record, for transfer to parent"),
    openPgpKey("OPENPGPKEY",61,"RFC 7929	OpenPGP public key record	A DNS-based Authentication of Named Entities (DANE) method for publishing and locating OpenPGP public keys in DNS for a specific email address using an OPENPGPKEY DNS resourceRecord record."),
    childParentSync("CSYNC",62,"RFC 7477	Child-to-Parent Synchronization	Specify a synchronization mechanism between a child and a parent DNS zone. Typical example is declaring the same NS records in the parent and the child zone"),
    dnsZoneDigests("ZONEMD",63,"RFC 8976	Message Digests for DNS Zones	Provides a cryptographic message digest over DNS zone data at rest."),
    serviceBindingRR("SVCB",64,"IETF Draft	Service Binding	RR that improves performance for clients that need to resolve many resources to access a authority. More info in this IETF Draft by DNSOP Working group and Akamai technologies."),
    httpsBindingRR("HTTPS",65,"IETF Draft	HTTPS Binding	RR that improves performance for clients that need to resolve many resources to access a authority. More info in this IETF Draft by DNSOP Working group and Akamai technologies."),
    mac48("EUI48",108,"RFC 7043	MAC address (EUI-48)	A 48-bit IEEE Extended Unique Identifier."),
    mac64("EUI64",109,"RFC 7043	MAC address (EUI-64)	A 64-bit IEEE Extended Unique Identifier."),
    transactionKeyRecord("TKEY",249,"RFC 2930	Transaction Key record	A method of providing keying material to be used with TSIG that is encrypted under the public key in an accompanying KEY RR.[12]"),
    transactionSignature("TSIG",250,"RFC 2845	Transaction Signature	Can be used to authenticate dynamic updates as coming from an approved client, or to authenticate responses as coming from an approved recursive name server[13] similar to DNSSEC."),
    uniformResourceId("URI",256,"RFC 7553	Uniform Resource Identifier	Can be used for publishing mappings from hostnames to URIs."),
    certificateAuthorityAuthorization("CAA",257,"RFC 6844	Certification Authority Authorization	DNS Certification Authority Authorization, constraining acceptable CAs for a host/authority"),
    trustAuthority("TA",32768,"DNSSEC Trust Authorities	Part of a deployment proposal for DNSSEC without a signed DNS root. See the IANA database and Weiler Spec for details. Uses the same format as the DS record."),
    dnsSecLookASideValidation("DLV",32769,"RFC 4431	DNSSEC Lookaside Validation record	For publishing DNSSEC trust anchors outside of the DNS delegation chain. Uses the same format as the DS record. RFC 5074 describes a way of using these records."),
    CachedRecords("*",255,"RFC 1035 All cached records for a name"),
    ZoneTransferAll("AXFR",252,"RFC 1035[1]	Authoritative Zone Transfer	Transfer entire zone file from the primary name server to secondary name servers."),
    ZoneTransferIncremental("IXFR",251,"RFC 1996	Incremental Zone Transfer	Requests a zone transfer of the given zone but only differences from a previous serial number. This request may be ignored and a full (AXFR) sent in response if the authoritative server is unable to fulfill the request due to configuration or lack of required deltas."),
    Option("OPT",41,"RFC 6891	Option	This is a pseudo-record type needed to support EDNS.");

    private final String label;
    private final Integer typeCode;
    private final String description;
    ResourceRecordType(String label,Integer typeCode,String description) {
        this.label = label;
        this.typeCode = typeCode;
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
    public Integer getTypeCode() {
        return this.typeCode;
    }

    @Override
    public String getLabel() {
        return this.label;
    }
}
