package dev.inward.matrix.operational;

public enum SystemPropertyInteger implements Options.SystemProperty<Integer, SystemPropertyInteger> {
    NameService_Cache("networkaddress.cache.ttl",10,"Specified in java.security to indicate the caching policy for successful name lookups from the name service. The value is specified as integer to indicate the number of seconds to cache the successful lookup. A value of -1 indicates \"cache forever\". The default behavior is to cache forever when a security manager is installed, and to cache for an implementation specific period of time, when a security manager is not installed."),
    NameService_Cache_negative("networkaddress.cache.negative.ttl",10, "(default: 10) Specified in java.security to indicate the caching policy for un-successful name lookups from the name service.. The value is specified as integer to indicate the number of seconds to cache the failure for un-successful lookups. A value of 0 indicates \"never cache\". A value of -1 indicates \"cache forever\"."),
    HTTP_Keep_Alive_Max_Setting("http.maxConnections",5,"(default: 5) If HTTP keep-alive is enabled (is on by default), this value is the number of idle connections that will be simultaneously kept alive, per-destination."),
    HTTP_Proxy_Port("http.proxyPort",80, "(default: 80 if http.proxyHost specified) http.proxyPort indicates the proxy port that the http protocol handler will use"),
    FTP_Proxy_Port("ftp.proxyPort",80,"(default: 80 if ftp.proxyHost specified) ftp.proxyPort indicate the port that the ftp protocol handler will use."),
    AUTH_DIGEST_cnonceRepeat("http.auth.digest.cnonceRepeat",5,"(default: 5) It is not normally necessary to set the third property (http.auth.digest.cnonceRepeat). This determines how many times a cnonce value is reused. This can be useful when the MD5-sess algorithm is being used. Increasing the value reduces the computational overhead on both the client and the server by reducing the amount of material that has to be hashed for each HTTP request."),
    CLIENT_Connect_Timeout("sun.net.client.defaultConnectTimeout",-1,"(default: -1) These properties specify the default connect timeout for the protocol handler used by java.net.URLConnection. sun.net.client.defaultConnectTimeout specifies the timeout (in milliseconds) to establish the connection to the host. For example for http connections it is the timeout when establishing the connection to the http server. For ftp connection it is the timeout when establishing the connection to ftp servers."),
    CLIENT_Read_Timeout("sun.net.client.defaultReadTimeout",-1,"(default: -1) These properties specify the default read timeout for the protocol handler used by java.net.URLConnection."),
    SOCKS_PROXY_PORT("socksProxyPort",1080,"(default: 1080)"),
    ;
    private String label;
    private String description;
    private Integer defaultValue;
    private String systemPropKey;
    SystemPropertyInteger(String systemPropKey,Integer defaultValue,String description) {
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
    public Integer getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public String systemPropKey() {
        return this.systemPropKey;
    }

    public @interface SystemPropertyDefault {
        SystemPropertyInteger value();
    }
}
