/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.concept.file.addressed.http;

public enum HttpResponseHeaders implements HttpHeader {

    Accept_CH("Accept-CH","Requests HTTP Client Hints	Accept-CH: UA, Platform	Experimental	RFC 8942",DefaultHttpHeader.class),
    Access_Control_Allow_Origin("Access-Control-Allow-Origin","",DefaultHttpHeader.class),
    Access_Control_Allow_Credentials("Access-Control-Allow-Credentials","",DefaultHttpHeader.class),
    Access_Control_Expose_Headers("Access-Control-Expose-Headers","",DefaultHttpHeader.class),
    Access_Control_Max_Age("Access-Control-Max-Age","",DefaultHttpHeader.class),
    Access_Control_Allow_Methods("Access-Control-Allow-Methods","",DefaultHttpHeader.class),
    Access_Control_Allow_Headers("Access-Control-Allow-Headers","Specifying which web sites can participate in cross-origin nameServerRecord sharing	Access-Control-Allow-Origin: *	Permanent: standard	RFC 7480",DefaultHttpHeader.class),
    Accept_Patch("Accept-Patch","Specifies which patch document formats this server supports	Accept-Patch: text/example;charset=utf-8	Permanent	RFC 5789",DefaultHttpHeader.class),
    Accept_Ranges("Accept-Ranges","What partial content range types this server supports via byte serving	Accept-Ranges: bytes	Permanent	RFC 2616, 7233",DefaultHttpHeader.class),
    Age("Age","The age the object has been in a proxy cache in seconds	Age: 12	Permanent	RFC 2616, 7234",DefaultHttpHeader.class),
    Allow("Allow","Valid methods for a specified nameServerRecord. To be used for a 405 Method not allowed	Allow: GET, HEAD	Permanent	RFC 2616, 7231",DefaultHttpHeader.class),
    Alt_Svc("Alt-Svc","A server uses \"Alt-Svc\" header (meaning Alternative Services) to indicate that its resources can also be accessed at a different network location (host or port) or using a different protocol When using HTTP/2, servers should instead send an ALTSVC frame. Alt-Svc: http/1.1=\"http2.example.com:8001\"; ma=7200	Permanent",DefaultHttpHeader.class),
    Cache_Control("Cache-Control","Tells all caching mechanisms from server to client whether they may cache this object. It is measured in seconds	Cache-Control: max-age=3600	Permanent	RFC 2616, 7231, 7234",DefaultHttpHeader.class),
    Connection("Connection", "Control options for the current connection and list of hop-by-hop response fields.[14] Must not be used with HTTP/2.[15]  Connection: close	Permanent	RFC 2616, 7230",DefaultHttpHeader.class),
    Content_Disposition("Content-Disposition","An opportunity to raise a \"File Download\" dialogue box for a known MIME type with binary format or suggest a filename for dynamic content. Quotes are necessary with special characters.	Content-Disposition: attachment; filename=\"fname.ext\"	Permanent	RFC 2616, 4021, 6266",DefaultHttpHeader.class),
    Content_Encoding("Content-Encoding","The type of encoding used on the data. See HTTP compression.	Content-Encoding: gzip	Permanent	RFC 2616, 7231",DefaultHttpHeader.class),
    Content_Language("Content-Language","The natural language or languages of the intended audience for the enclosed content[50]	Content-Language: da	Permanent	RFC 2616, 4021, 7231",DefaultHttpHeader.class),
    Content_Length("Content-Length","The length of the response body in octets (8-bit bytes)	Content-Length: 348	Permanent	RFC 2616, 7230, 7231",DefaultHttpHeader.class),
    Content_Location("Content-Location","An alternate location for the returned data	Content-Location: /directory.htm	Permanent	RFC 2616, 4021, 7231",DefaultHttpHeader.class),
    Content_MD5("Content-MD5","A Base64-encoded binary MD5 sum of the content of the response	Content-MD5: Q2hlY2sgSW50ZWdyaXR5IQ==	Obsolete[16]	RFC 1544, 1864, 4021",DefaultHttpHeader.class),
    Content_Range("Content-Range","Where in a full body message this partial message belongs	Content-Range: bytes 21010-47021/47022	Permanent	RFC 2616, 7233",DefaultHttpHeader.class),
    Content_Type("Content-Type","The MIME type of this content	Content-Type: text/html; charset=utf-8	Permanent	RFC 2616, 4021, 7231",DefaultHttpHeader.class),
    Date("Date","The date and time that the message was sent (in \"HTTP-date\" format as defined by RFC 7231) [51]	Date: Tue, 15 Nov 1994 08:12:31 GMT	Permanent	RFC 2616, 5322, 5536, 7231",DefaultHttpHeader.class),
    Delta_Base("Delta-Base","Specifies the delta-encoding entity tag of the response.[12]	Delta-Base: \"abc\"	Permanent	RFC 3229",DefaultHttpHeader.class),
    ETag("ETag","An identifier for a specific version of a nameServerRecord, often a message digest	ETag: \"737060cd8c284d8af7ad3082f209582d\"	Permanent	RFC 2616, 7232",DefaultHttpHeader.class),
    Expires("Expires","Gives the date/time after which the response is considered stale (in \"HTTP-date\" format as defined by RFC 7231)	Expires: Thu, 01 Dec 1994 16:00:00 GMT	Permanent: standard	RFC 2616, 4021, 5536, 7234",DefaultHttpHeader.class),
    IM("IM","Instance-manipulations applied to the response.[12]	IM: feed	Permanent	RFC 3229",DefaultHttpHeader.class),
    Last_Modified("Last-Modified","The last modified date for the requested object (in \"HTTP-date\" format as defined by RFC 7231)	Last-Modified: Tue, 15 Nov 1994 12:45:26 GMT	Permanent	RFC 2616, 7232",DefaultHttpHeader.class),
    Link("Link","Used to express a typed relationship with another nameServerRecord, where the relation type is defined by RFC 5988	Link: </feed>; rel=\"alternate\"[52]	Permanent	RFC 5988",DefaultHttpHeader.class),
    Location("Location","Used in redirection, or when a new nameServerRecord has been created. Example 1: Location: http://www.w3.org/pub/WWW/People.html  Example 2: Location: /pub/WWW/People.html    Permanent	RFC 2068, 2616, 7231",DefaultHttpHeader.class),
    P3P("P3P","This field is supposed to set P3P policy, in the form of P3P:CP=\"your_compact_policy\". However, P3P did not take off,[53] most browsers have never fully implemented it, a lot of websites set this field with fake policy text, that was enough to fool browsers the existence of P3P policy and grant permissions for third party cookies.	P3P: CP=\"This is not a P3P policy! See https://en.wikipedia.org/wiki/Special:CentralAutoLogin/P3P for more user.\"	Permanent",DefaultHttpHeader.class),
    Pragma("Pragma","Implementation-specific fields that may have various effects anywhere along the request-response chain.	Pragma: no-cache	Permanent	RFC 2616, 7234",DefaultHttpHeader.class),
    Preference_Applied("Preference-Applied","Indicates which Prefer tokens were honored by the server and applied to the processing of the request.	Preference-Applied: return=representation	Permanent	RFC 7240",DefaultHttpHeader.class),
    Proxy_Authenticate("Proxy-Authenticate","Request authentication to access the proxy.	Proxy-Authenticate: Basic	Permanent	RFC 2068, 2616, 7235",DefaultHttpHeader.class),
    Public_Key_Pins("Public-Key-Pins","HTTP Public Key Pinning, announces hash of website's authentic TLS certificate	Public-Key-Pins: max-age=2592000; pin-sha256=\"E9CZ9INDbd+2eRQozYqqbQ2yXLVKB9+xcprMF+44U1g=\";	Permanent	RFC 7469",DefaultHttpHeader.class),
    Retry_After("Retry-After","If an entity is temporarily unavailable, this instructs the client to try again later. Value could be a specified period of time (in seconds) or a HTTP-date.[55] Example 1: Retry-After: 120 Example 2: Retry-After: Fri, 07 Nov 2014 23:59:59 GMTPermanent    RFC 2616, 7231",DefaultHttpHeader.class),
    Server("Server","A name for the server	Server: Apache/2.4.1 (Unix)	Permanent	RFC 2068, 2616, 7231",DefaultHttpHeader.class),
    Set_Cookie("Set-Cookie","An HTTP cookie	Set-Cookie: UserID=JohnDoe; Max-Age=3600; Version=1	Permanent: standard	RFC 6265",DefaultHttpHeader.class),
    Strict_Transport_Security("Strict-Transport-Security","A HSTS Policy informing the HTTP client how long to cache the HTTPS only policy and whether this applies to subdomains.	Strict-Transport-Security: max-age=16070400; includeSubDomains	Permanent: standard",DefaultHttpHeader.class),
    Trailer("Trailer","The Trailer general field value indicates that the given set of header fields is present in the trailer of a message encoded with chunked transfer coding.	Trailer: Max-Forwards	Permanent	RFC 2616, 7230",DefaultHttpHeader.class),
    Transfer_Encoding("Transfer-EncodingTransfer-Encoding","The form of encoding used to safely transfer the entity to the user. Currently defined methods are: chunked, compress, deflate, gzip, identity. Must not be used with HTTP/2.[15] Transfer-Encoding: chunked	Permanent	RFC 2616, 7230",DefaultHttpHeader.class),
    Tk("Tk","Tracking Status header, value suggested to be sent in response to a DNT(do-not-track), possible values:\n \"!\" — under construction\n\"?\" — dynamic\n\"G\" — gateway to multiple parties\n\"N\" — not tracking\n\"T\" — tracking\n\"C\" — tracking with consent\n\"P\" — tracking only if consented\n\"D\" — disregarding DNT\n\"U\" — updated    Tk: ?	Permanent",DefaultHttpHeader.class),
    Upgrade("Upgrade","Ask the client to upgrade to another protocol. Must not be used in HTTP/2[15] Upgrade: h2c, HTTPS/1.3, IRC/6.9, RTA/x11, websocket	Permanent	RFC 2616, 7230",DefaultHttpHeader.class),
    Vary("Vary","Tells downstream proxies how to match future request headers to decide whether the cached response can be used rather than requesting a fresh one from the origin server.  Example 1: Vary: * Example 2: Vary: Accept-Language Permanent	RFC 2068, 2616, 7231",DefaultHttpHeader.class),
    Via("Via","Informs the client of proxies through which the response was sent.	Via: 1.0 fred, 1.1 example.com (Apache/1.1)	Permanent	RFC 2616, 7230",DefaultHttpHeader.class),
    Warning("Warning","A general warning about possible problems with the entity body.	Warning: 199 Miscellaneous warning	Permanent	RFC 2616, 7234",DefaultHttpHeader.class),
    WWW_Authenticate("WWW-Authenticate","Indicates the authentication scheme that should be used to access the requested entity.	WWW-Authenticate: Basic	Permanent	RFC 2068, 2616, 7235",DefaultHttpHeader.class),
    X_Frame_Options("X-Frame-Options","Clickjacking protection: deny - no rendering within a frame, sameorigin - no rendering if origin mismatch, allow-from - allow from specified location, allowall - non-standard, allow from any location	X-Frame-Options: deny	Obsolete[57]",DefaultHttpHeader.class),

    Content_Security_Policy("Content-Security-Policy","",DefaultHttpHeader.class),
    X_Content_Security_Policy("X-Content-Security-Policy","",DefaultHttpHeader.class),
    X_WebKit_CSP("X-WebKit-CSP","Content Security Policy definition.	X-WebKit-CSP: default-src 'self'  Expect-CT[59]	Notify to prefer to enforce Certificate Transparency.	Expect-CT: max-age=604800, enforce, report-uri=\"https://example.example/report\"",DefaultHttpHeader.class),
    NEL("NEL","Used to configure network request logging.	NEL: { \"report_to\": \"name_of_reporting_group\", \"max_age\": 12345, \"include_subdomains\": false, \"success_fraction\": 0.0, \"failure_fraction\": 1.0 }",DefaultHttpHeader.class),
    Permissions_Policy("Permissions-Policy","To allow or disable different features or APIs of the browser.	Permissions-Policy: fullscreen=(), camera=(), microphone=(), geolocation=(), interest-cohort=()[62] Refresh	Used in redirection, or when a new nameServerRecord has been created. This refresh redirects after 5 seconds. Header extension introduced by Netscape and supported by most web browsers. Defined by HTML Standard[63]	Refresh: 5; url=http://www.w3.org/pub/WWW/People.html",DefaultHttpHeader.class),
    Report_To("Report-To","Instructs the user agent to store reporting endpoints for an origin.	Report-To: { \"group\": \"csp-endpoint\", \"max_age\": 10886400, \"endpoints\": [ { \"url\": \"https-url-of-site-which-collects-reports\" } ] }\"",DefaultHttpHeader.class),
    Status("Status","CGI header field specifying the status of the HTTP response. Normal HTTP responses use a separate \"Status-Line\" instead, defined by RFC 7230.[65]	Status: 200 OK",DefaultHttpHeader.class),
    Timing_Allow_Origin("Timing-Allow-Origin","The Timing-Allow-Origin response header specifies origins that are allowed to see values of attributes retrieved via features of the Resource Timing API, which would otherwise be reported as zero due to cross-origin restrictions.[66]	Timing-Allow-Origin: *    Timing-Allow-Origin: <origin>[, <origin>]*",DefaultHttpHeader.class),
    X_Content_Duration("X-Content-Duration","Provide the duration of the audio or video in seconds; only supported by Gecko browsers	X-Content-Duration: 42.666", DefaultHttpHeader.class),
    X_Content_Type_Options("X-Content-Type-Options","The only defined value, \"nosniff\", prevents Internet Explorer from MIME-sniffing a response away from the declared content-type. This also applies to Google Chrome, when downloading extensions.[69]	X-Content-Type-Options: nosniff[70]",DefaultHttpHeader.class),
    X_Powered_By("X-Powered-By","Specifies the technology (e.g. ASP.NET, PHP, JBoss) supporting the web application (version details are often in X-Runtime, X-Version, or X-AspNet-Version)	X-Powered-By: PHP/5.4.0",DefaultHttpHeader.class),
    X_Redirect_By("X-Redirect-By","Specifies the component that is responsible for a particular redirect.	X-Redirect-By: WordPress  X-Redirect-By: Polylang",DefaultHttpHeader.class),
    X_Request_ID("X-Request-ID","",DefaultHttpHeader.class),
    X_Correlation_ID("X-Correlation-ID","Correlates HTTP requests between a client and server.	X-Request-ID: f058ebd6-02f7-4d3f-942e-904344e8cde5",DefaultHttpHeader.class),
    X_UA_Compatible("X-UA-Compatible","Recommends the preferred rendering engine (often a backward-compatibility mode) to use to display the content. Also used to activate Chrome Frame in Internet Explorer. In HTML Standard, only the IE=edge value is defined.[73]	X-UA-Compatible: IE=edge X-UA-Compatible: IE=EmulateIE7    X-UA-Compatible: Chrome=1",DefaultHttpHeader.class),
    X_XSS_Protection("X-XSS-Protection","Cross-site scripting (XSS) filter	X-XSS-Protection: 1; mode=block",DefaultHttpHeader.class),
        ;
    String key;
    String description;
    Class<? super HttpHeader> klass;
    HttpResponseHeaders(String key, String description, Class klass) {
        this.key = key;
        this.description = description;
        this.klass = klass;
    }
    public String key() {
        return this.key;
    }
    public String description() {
        return this.description;
    }
    public Class<? super HttpHeader> klass() {
        return this.klass;
    }
}
