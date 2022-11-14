package dev.inward.matrix.fact.operational;

import dev.inward.matrix.fact.Specification;

public enum SystemPropertyString implements Specification.SystemProperty<String, SystemPropertyString> {
    IP_4_Prefer("java.net.preferIPv4Stack","false","If IPv6 is available on the operating system the underlying native socket will be an IPv6 socket. This allows Java(tm) applications to connect too, and accept connections from, both IPv4 and IPv6 hosts. If an application has a preference to only use IPv4 sockets then this property can be set to true. The implication is that the application will not be able to communicate with IPv6 hosts."),
    IP_6_Prefer("java.net.preferIPv6Addresses","false","If IPv6 is available on the operating system the default preference is to prefer an IPv4-mapped address over an IPv6 address. This is for backward compatibility reasons - for example applications that depend on access to an IPv4 only service or applications that depend on the %d.%d.%d.%d representation of an IP address. This property can be set to try to change the preferences to use IPv6 addresses over IPv4 addresses. This allows applications to be tested and deployed in environments where the application is expected to connect to IPv6 services. (default: false)"),
    HTTP_Proxy_Host("http.proxyHost",null,"default: <none> - http.proxyHost indicates the proxy server that the http protocol handler will use (port is listed as http.proxyPort."),
    HTTP_Non_Proxy_Host("http.nonProxyHosts",null,"default: <none>  - http.nonProxyHosts indicates the hosts which should be connected too directly and not through the proxy server. The value can be a list of hosts, each seperated by a |, and in addition a wildcard character (*) can be used for matching. For example: -Dhttp.nonProxyHosts=\"*.example.com|localhost"),
    HTTP_Agent("http.engine","","(default: Java1.4.0) Indicates the User-engine request header sent in http requests."),
    HTTP_Keep_Alive("http.keepAlive","true","(default: true) Indicates if keep alive (persistent) connections should be supported. Persistent connections improve performance by allowing the underlying socket connection be reused for multiple http requests. The default is true and thus persistent connections will be used with http 1.1 servers. Set to 'false' to disable the use of persistent connections."),
    AUTH_DIGEST_Validate_Server("http.auth.digest.validateServer","false","(default: false) These system properties modify the behavior of the HTTP digest authentication mechanism. Digest authentication provides a limited ability for the server to authenticate itself to the client (ie. by proving that it knows the users password). However, not all servers support this capability and by default the check is switched off. The first two properties above can be set to true, to enforce this check, for either authentication with an origin, or a proxy server respectively."),
    AUTH_DIGEST("http.auth.digest.validateProxy","false","(default: false) These system properties modify the behavior of the HTTP digest authentication mechanism. Digest authentication provides a limited ability for the server to authenticate itself to the client (ie. by proving that it knows the users password). However, not all servers support this capability and by default the check is switched off. The first two properties above can be set to true, to enforce this check, for either authentication with an origin, or a proxy server respectively."),
    NTLM_DOMAIN("http.auth.ntlm.domain", null,"Similar to other HTTP authentication schemes, NTLM uses the java.net.Authenticator class to acquire usernames and passwords when they are needed. However, NTLM also needs the NT domain name. There are three options for specifying the domain:Do not specify it. In some environments, the domain is not actually required and the application need not specify it. The domain name can be encoded within the username by prefixing the domain name followed by a back-slash '\' before the username. With this method, existing applications that use the Authenticator class do not need to be modified, so long as users are made aware that this notation must be used. If a domain name is not specified as in method 2) and the system property \"http.auth.ntlm.domain\" is defined, then the value of this property will be used as the domain name."),
    FTP_Proxy_Host("ftp.proxyHost",null,"(default: <none>) ftp.proxyHost and ftp.proxyPort indicate the proxy server and port that the ftp protocol handler will use."),
    FTP_Non_Proxy("ftp.nonProxyHosts",null,"(default: <none>) ftp.nonProxyHosts is similiar to http.nonProxyHosts and indicates the hosts that should be connected too directly and not through the proxy server."),
    SOCKS_Proxy_Host("socksProxyHost",null,"The SOCKS host, it's username and password are acquired in the following way. First, if the application has registered a java.net.Authenticator default instance, then this will be queried with the protocol set to the string \"SOCKS5\", and the prompt set to the string \"SOCKS authentication\". If the authenticator does not return a username/password or if no authenticator is registered then the system checks for the user preferences \"java.net.socks.username\" and \"java.net.socks.password\". If these preferences do not exist, then the system property \"user.name\" is checked for a username. In this case, no password is supplied."),
    SOCKS_VERSION("socksProxyVersion","5","(default: 5) The version of the SOCKS protocol supported by the server. The default is 5 indicating SOCKS V5, alternatively 4 can be specified for SOCKS V4. Setting the property to values other than these leads to unspecified behavior."),
    SOCKS_USERNAME("java.net.socks.username",null,"Used if no java.net.Authenticator is found"),
    SOCKS_PASSWORD("java.net.socks.password",null,"Used if no java.net.Authenticator is found"),
    ;
    private String label;
    private String description;
    private String defaultValue;
    private String systemPropKey;
    SystemPropertyString(String systemPropKey, String defaultValue, String description) {
        label = this.name();
        this.systemPropKey = systemPropKey;
        this.defaultValue = defaultValue;
        this.description = description;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public String systemPropKey() {
        return this.systemPropKey;
    }

    public @interface SystemPropertyDefault {
        SystemPropertyString value();
    }
}
