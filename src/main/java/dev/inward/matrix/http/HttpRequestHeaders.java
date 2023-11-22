package dev.inward.matrix.http;

public enum HttpRequestHeaders implements HttpHeader {

    A_IM("A-IM","Acceptable instance-manipulations for the request.[12]	A-IM: feed	RFC 3229",HttpHeader.DefaultHttpHeader.class),
    Accept("Accept","Media type(s) that is/are acceptable for the response. See Content negotiation.	Accept: text/html	Permanent	RFC 2616, 7231",HttpHeader.DefaultHttpHeader.class),
    Accept_Charset("Accept-Charset","Character sets that are acceptable.	Accept-Charset: utf-8	Permanent	RFC 2616",HttpHeader.DefaultHttpHeader.class),
    Accept_Datetime("Accept-Datetime","Acceptable version in time.	Accept-Datetime: Thu, 31 May 2007 20:35:00 GMT	Provisional	RFC 7089",HttpHeader.DefaultHttpHeader.class),
    Accept_Encoding("Accept-Encoding","List of acceptable encodings. See HTTP compression.	Accept-Encoding: gzip, deflate	Permanent	RFC 2616, 7231",HttpHeader.DefaultHttpHeader.class),
    Accept_Language("Accept-Language","List of acceptable human languages for response. See Content negotiation.	Accept-Language: en-US	Permanent	RFC 2616, 4021, 7231",HttpHeader.DefaultHttpHeader.class),
    Access_Control_Request_Method("Access-Control-Request-Method","",HttpHeader.DefaultHttpHeader.class),
    Access_Control_Request_Headers("Access-Control-Request-Headers","Initiates a request for cross-origin resourceRecord sharing with Origin (below).	Access-Control-Request-Method: GET	Permanent: standard",HttpHeader.DefaultHttpHeader.class),
    Authorization("Authorization","Authentication credentials for HTTP authentication.	Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==	Permanent	RFC 2616, 7123, 7235",HttpHeader.DefaultHttpHeader.class),
    Cache_Control("Cache-Control","Used to specify directives that must be obeyed by all caching mechanisms along the request-response chain.	Cache-Control: no-cache	Permanent	RFC 2616, 7231, 7234",HttpHeader.DefaultHttpHeader.class),
    Connection("Connection","Control options for the current connection and list of hop-by-hop request fields.Must not be used with HTTP/2. Connection: keep-alive Connection: Upgrade  Permanent	RFC 2616, 7230",HttpHeader.DefaultHttpHeader.class),
    Content_Encoding("Content-Encoding","The type of encoding used on the data. See HTTP compression.	Content-Encoding: gzip	Permanent	RFC 2616, 7231",HttpHeader.DefaultHttpHeader.class),
    Content_Length("Content-Length","The length of the request body in octets (8-bit bytes).	Content-Length: 348	Permanent	RFC 2616, 7230, 7231",HttpHeader.DefaultHttpHeader.class),
    Content_MD5("Content-MD5","A Base64-encoded binary MD5 sum of the content of the request body.	Content-MD5: Q2hlY2sgSW50ZWdyaXR5IQ==	Obsolete[16]	RFC 1544, 1864, 4021",HttpHeader.DefaultHttpHeader.class),
    Content_Type("Content-Type","The Media type of the body of the request (used with POST and PUT requests).	Content-Type: application/x-www-form-urlencoded	Permanent	RFC 2616, 4021, 7231",HttpHeader.DefaultHttpHeader.class),
    Cookie("Cookie","An HTTP cookie previously sent by the server with Set-Cookie (below).	Cookie: $Version=1; Skin=new;	Permanent: standard	RFC 2965, 6265",HttpHeader.DefaultHttpHeader.class),
    Date("Date","The date and time at which the message was originated (in \"HTTP-date\" format as defined by RFC 7231 Date/Time Formats).	Date: Tue, 15 Nov 1994 08:12:31 GMT	Permanent	RFC 2616, 5322, 5536, 7231",HttpHeader.DefaultHttpHeader.class),
    Expect("Expect","Indicates that particular server behaviors are required by the client.	Expect: 100-continue	Permanent	RFC 2616, 7231",HttpHeader.DefaultHttpHeader.class),
    Forwarded("Forwarded","Disclose original information of a client connecting to a web server through an HTTP proxy.[17]	Forwarded: for=192.0.2.60;proto=http;by=203.0.113.43 Forwarded: for=192.0.2.43, for=198.51.100.17	Permanent	RFC 7239",HttpHeader.DefaultHttpHeader.class),
    From("From","The email address of the user making the request.	From: user@example.com	Permanent	RFC 2616, 5322, 5536, 6854, 7231",HttpHeader.DefaultHttpHeader.class),
    Host("Host","The authority name of the server (for virtual hosting), and the TCP port number on which the server is listening. The port number may be omitted if the port is the standard port for the service requested. Mandatory since HTTP/1.1.[18] If the request is generated directly in HTTP/2, it should not be used.[19] Host: en.wikipedia.org:8080  Host: en.wikipedia.org   HTTP2-Settings	A request that upgrades from HTTP/1.1 to HTTP/2 MUST include exactly one HTTP2-Setting header field. The HTTP2-Settings header field is a connection-specific header field that includes parameters that govern the HTTP/2 connection, provided in anticipation of the server accepting the request to upgrade.[20][21]	HTTP2-Settings: token64	Permanent: standard",HttpHeader.DefaultHttpHeader.class),
    If_Match("If-Match","Only perform the action if the client supplied entity matches the same entity on the server. This is mainly for methods like PUT to only update a resourceRecord if it has not been modified since the user last updated it.	If-Match: \"737060cd8c284d8af7ad3082f209582d\"	Permanent	RFC 2616, 7323",HttpHeader.DefaultHttpHeader.class),
    If_Modified_Since("If-Modified-Since","Allows a 304 Not Modified to be returned if content is unchanged.	If-Modified-Since: Sat, 29 Oct 1994 19:43:31 GMT	Permanent	RFC 2616, 7323",HttpHeader.DefaultHttpHeader.class),
    If_None_Match("If-None-Match","Allows a 304 Not Modified to be returned if content is unchanged, see HTTP ETag.	If-None-Match: \"737060cd8c284d8af7ad3082f209582d\"	Permanent	RFC 2616, 7232",HttpHeader.DefaultHttpHeader.class),
    If_Range("If-Range","If the entity is unchanged, send me the part(s) that I am missing; otherwise, send me the entire new entity.	If-Range: \"737060cd8c284d8af7ad3082f209582d\"	Permanent	RFC 2616, 7232, 7233",HttpHeader.DefaultHttpHeader.class),
    If_Unmodified_Since("If-Unmodified-Since","Only send the response if the entity has not been modified since a specific time.	If-Unmodified-Since: Sat, 29 Oct 1994 19:43:31 GMT	Permanent	RFC 2616, 7232",HttpHeader.DefaultHttpHeader.class),
    Max_Forwards("Max-Forwards","Limit the number of times the message can be forwarded through proxies or gateways.	Max-Forwards: 10	Permanent	RFC 2616, 7231'",HttpHeader.DefaultHttpHeader.class),
    Origin("Origin","Initiates a request for cross-origin resourceRecord sharing (asks server for Access-Control-* response fields).	Origin: http://www.example-social-network.com	Permanent: standard	RFC 6454",HttpHeader.DefaultHttpHeader.class),
    Pragma("Pragma","Implementation-specific fields that may have various effects anywhere along the request-response chain.	Pragma: no-cache	Permanent	RFC 2616, 7234",HttpHeader.DefaultHttpHeader.class),
    Prefer("Prefer","Allows client to request that certain behaviors be employed by a server while processing a request.	Prefer: return=representation	Permanent	RFC 7240",HttpHeader.DefaultHttpHeader.class),
    Proxy_Authorization("Proxy-Authorization","Authorization credentials for connecting to a proxy.	Proxy-Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==	Permanent	RFC 2616, 7235",HttpHeader.DefaultHttpHeader.class),
    Range("Range","Request only part of an entity. Bytes are numbered from 0. See Byte serving.	Range: bytes=500-999	Permanent	RFC 2616, 7233",HttpHeader.DefaultHttpHeader.class),
    Referer("Referer","This is the address of the previous web page from which a link to the currently requested page was followed. (The word \"referrer\" has been misspelled in the RFC as well as in most implementations to the point that it has become standard usage and is considered correct terminology)	Referer: http://en.wikipedia.org/wiki/Main_Page	Permanent	RFC 2616, 7231",HttpHeader.DefaultHttpHeader.class),
    TE("TE","The transfer encodings the user agent is willing to accept: the same values as for the response header field Transfer-Encoding can be used, plus the \"trailers\" value (related to the \"chunked\" transfer method) to notify the server it expects to receive additional fields in the trailer after the last, zero-sized, chunk.  Only trailers is supported in HTTP/2.[15]    TE: trailers, deflate	Permanent	RFC 2616, 7230",HttpHeader.DefaultHttpHeader.class),
    Trailer("Trailer","The Trailer general field value indicates that the given set of header fields is present in the trailer of a message encoded with chunked transfer coding.	Trailer: Max-Forwards	Permanent	RFC 2616, 7230",HttpHeader.DefaultHttpHeader.class),
    Transfer_Encoding("Transfer-Encoding","The form of encoding used to safely transfer the entity to the user. Currently defined methods are: chunked, compress, deflate, gzip, identity.  Must not be used with HTTP/2.[15]    Transfer-Encoding: chunked	Permanent	RFC 2616, 7230",HttpHeader.DefaultHttpHeader.class),
    User_Agent("User-Agent","The user agent string of the user agent.	User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:12.0) Gecko/20100101 Firefox/12.0	Permanent	RFC 2616, 5536, 7231",HttpHeader.DefaultHttpHeader.class),
    Upgrade("Upgrade","Ask the server to upgrade to another protocol.  Must not be used in HTTP/2.[15] Upgrade: h2c, HTTPS/1.3, IRC/6.9, RTA/x11, websocket	Permanent	RFC 2616, 7230",HttpHeader.DefaultHttpHeader.class),
    Via("Via","Informs the server of proxies through which the request was sent.	Via: 1.0 fred, 1.1 example.com (Apache/1.1)	Permanent	RFC 2616, 7230",HttpHeader.DefaultHttpHeader.class),
    Warning("Warning","A general warning about possible problems with the entity body.	Warning: 199 Miscellaneous warning	Permanent	RFC 2616, 7234",HttpHeader.DefaultHttpHeader.class),

    Upgrade_Insecure_Requests("Upgrade-Insecure-Requests","Tells a server which (presumably in the middle of a HTTP -> HTTPS migration) hosts mixed content that the client would prefer redirection to HTTPS and can handle Content-Security-Policy: upgrade-insecure-requests    Must not be used with HTTP/2[15] Upgrade-Insecure-Requests: 1",DefaultHttpHeader.class),
    X_Requested_With("X-Requested-With","Mainly used to identify Ajax requests (most JavaScript frameworks send this field with value of XMLHttpRequest); also identifies Android apps using WebView[23]	X-Requested-With: XMLHttpRequest",DefaultHttpHeader.class),
    DNT("DNT","Requests a web application to disable their tracking of a user. This is Mozilla's version of the X-Do-Not-Track header field (since Firefox 4.0 Beta 11). Safari and IE9 also have support for this field.[25] On March 7, 2011, a draft proposal was submitted to IETF.[26] The W3C Tracking Protection Working Group is producing a specification.[27]	DNT: 1 (Do Not Track Enabled)    DNT: 0 (Do Not Track Disabled)",DefaultHttpHeader.class),
    X_Forwarded_For("X-Forwarded-For","A de facto standard for identifying the originating IP address of a client connecting to a web server through an HTTP proxy or load balancer. Superseded by Forwarded header.	X-Forwarded-For: client1, proxy1, proxy2X-Forwarded-For: 129.78.138.66, 129.78.64.103",DefaultHttpHeader.class),
    X_Forwarded_Host("X-Forwarded-Host","A de facto standard for identifying the original host requested by the client in the Host HTTP request header, since the host name and/or port of the reverse proxy (load balancer) may differ from the origin server handling the request. Superseded by Forwarded header.	X-Forwarded-Host: en.wikipedia.org:8080 X-Forwarded-Host: en.wikipedia.org",DefaultHttpHeader.class),
    X_Forwarded_Proto("X-Forwarded-Proto","A de facto standard for identifying the originating protocol of an HTTP request, since a reverse proxy (or a load balancer) may communicate with a web server using HTTP even if the request to the reverse proxy is HTTPS. An alternative form of the header (X-ProxyUser-Ip) is used by Google clients talking to Google servers. Superseded by Forwarded header.	X-Forwarded-Proto: https",DefaultHttpHeader.class),
    Front_End_Https("Front-End-Https","Non-standard header field used by Microsoft applications and load-balancers	Front-End-Https: on",DefaultHttpHeader.class),
    X_Http_Method_Override("X-Http-Method-Override","Requests a web application to override the method specified in the request (typically POST) with the method given in the header field (typically PUT or DELETE). This can be used when a user agent or firewall prevents PUT or DELETE methods from being sent directly (note that this is either a bug in the software component, which ought to be fixed, or an intentional configuration, in which case bypassing it may be the wrong thing to do).	X-HTTP-Method-Override: DELETE",DefaultHttpHeader.class),
    X_ATT_DeviceId("X-ATT-DeviceId","Allows easier parsing of the MakeModel/Firmware that is usually found in the User-Agent String of AT&T Devices	X-Att-Deviceid: GT-P7320/P7320XXLPG",DefaultHttpHeader.class),
    X_Wap_Profile("X-Wap-Profile","Links to an XML file on the Internet with a full description and details about the device currently connecting. In the example to the right is an XML file for an AT&T Samsung Galaxy S2.	x-wap-profile: http://wap.samsungmobile.com/uaprof/SGH-I777.xml", DefaultHttpHeader.class),
    Proxy_Connection("Proxy-Connection","Implemented as a misunderstanding of the HTTP specifications. Common because of mistakes in implementations of early HTTP versions. Has exactly the same functionality as standard Connection field.  Must not be used with HTTP/2.[15] Proxy-Connection: keep-alive",DefaultHttpHeader.class),
    X_UIDH("X-UIDH","Server-side deep packet insertion of a unique ID identifying customers of Verizon Wireless; also known as \"perma-cookie\" or \"supercookie\"	X-UIDH: ...",DefaultHttpHeader.class),
    X_Csrf_Token("X-Csrf-Token","Used to prevent cross-site request forgery. Alternative header names are: X-CSRFToken[40] and X-XSRF-TOKEN[41]	X-Csrf-Token: i8XNjC4b8KVok4uw5RftR38Wgp2BFwql",DefaultHttpHeader.class),
    X_Request_ID("X-Request-ID","Correlates HTTP requests between a client and server.	X-Request-ID: f058ebd6-02f7-4d3f-942e-904344e8cde5",DefaultHttpHeader.class),
    X_Correlation_ID("X-Correlation-ID","Correlates HTTP requests between a client and server.	X-Request-ID: f058ebd6-02f7-4d3f-942e-904344e8cde5",DefaultHttpHeader.class),
    Save_Data("Save-Data","The Save-Data client hint request header available in Chrome, Opera, and Yandex browsers lets developers deliver lighter, faster applications to users who opt-in to data saving mode in their browser.	Save-Data: on[22]	Tells a server which (presumably in the middle of a HTTP -> HTTPS migration) hosts mixed content that the client would prefer redirection to HTTPS and can handle Content-Security-Policy: upgrade-insecure-requests Must not be used with HTTP/2[15]",DefaultHttpHeader.class),
    ;
    String key;
    String description;
    Class klass;

    HttpRequestHeaders(String key, String description, Class klass) {
        this.key= key;
        this.description = description;
        this.klass = klass;
    }
    public String key() {
        return this.key;
    }
    public String description() {
        return this.description;
    }
    public Class<HttpHeader> klass() {
        return this.klass;
    }
}
