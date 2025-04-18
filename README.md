# Pinder's Matrix

This is the not yet working code of a java agent which is a Java Files implementation which allows users to both retrieve a URL for a remote object and serve it with an ACL security. It will include schemas for 'dns', 'http','https', 'log' (events from the Matrix's worker threads), 'code' (a git like repository of addressable and versioned code for use ad hoc), 'realm' (Kerberos patterned secure login service) and 'info' (the client preference and server security details)

I've made extensive changes, really going to town on generics. The file objects have now have individual Keys, attributes, models, resources, and references. Directories extend the file object while 'named' files extend Addressed.


An extreme 'work in progress', which has changed significantly from the initial concept but the basic classes have been settled into:

    dev.inward.matrix.Scheme extends java.net.URLStreamHandler
    
    dev.inward.matrix.control.library.Library extends java.net.FileSystemProvider

    dev.inward.matrix.Ledger extends java.net.FileSystem
Ledgers contain Gatherings which hold Addressed objects

    dev.inward.matrix.predictable.Predictable implements java.nio.file.WatchService
Predictable is the manager of Matrix objects when creating Complications

    dev.inward.matrix.predictable.Complication implements java.nio.file.WatchKey
Complications are the runnable, which are configured by Criterion and produce Matters

    dev.inward.matrix.file.log.addressed.Matter extends dev.inward.matrix.file.addressed.Addressed implements java.nio.file.WatchEvent<Indicia> 
Matters are sent to/kept in the 'log' scheme, the concept is to push all logs off the system almost immediately, both for processing externally and to keep them safe from any malfeasance that might occur on a front end system (killing the logs is the first sign of a 'hacked' system)

    dev.inward.matrix.log.Indica 
Indica acts is a depot object which defines events, it's key extends Watch

    dev.inward.matrix.Criterion implements java.nio.file.WatchEvent.Modifier
Criterion is used by Predictable as the instruction for the WatchKey

    DATUM
DATUM is a plain Object reference meant to engage primitives and 'non matrix' objects into the system
    
    dev.inward.matrix.Ware
Ware holds both the Attributes associated with the DATUM object and a SoftReference to it

    dev.inward.matrix.View
Attributes holds the Model for the DATUM and any Properties directly associated with the instance 

    dev.inward.matrix.Model
Model holds a map of the fields from a DATUM, and the Aspect associated with it

    dev.inward.matrix.Aspect
Aspect holds the friendly name of the field and it's description 

    dev.inward.matrix.Datum
Datum is an interface and the lowest level programmed file objects, all other files implement it. While it has both Envoy and DatumAttributes attached to it in generics it's otherwise empty and meant to be implemented by client code when required

    dev.inward.matrix.DatumReference extends Ware
Envoy is the Ware extension for Datum objects

    dev.inward.matrix.DatumView extends Attributes
DatumAttributes is the Attributes extension for Datum objects

    dev.inward.matrix.file.FileKey implements java.nio.file.Watchable, java.file.Path
FileKey is the lowest identifiable file object

    dev.inward.matrix.file.File implements Datum
MatrixFile is the lowest object which may be created from parsing a FileKey. It branches commonality between directory and files.

    dev.inward.matrix.Registar extends Envoy
Registar is the container for MatrixFile objects

    dev.inward.matrix.file.FileView extends DatumAttributes
FileAttributes is the attributes for a MatrixFile object 

    dev.inward.matrix.file.addressed.AddressedKey
Identity is the lowest Matrix object which is generally addressable

    dev.inward.matrix.file.addressed.Addressed
Addressed is what's created by the Identity, each of the schemes will extend this Object to present individual files

    dev.inward.matrix.file.addressed.AddressedReference
Representative is the Registar extension for Addressed objects

    dev.inward.matrix.file.addressed.Addressed.AddressedAttributes
Addressed.FileAttributes is the attributes for the Addressed Objects

Much more....


