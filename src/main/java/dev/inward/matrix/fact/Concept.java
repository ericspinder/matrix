package dev.inward.matrix.fact;

import dev.inward.matrix.Context;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.director.library.catalog.Catalog;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public abstract class Concept<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Identity.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> implements Addressed<S,L,PATH,ID,T,C>, Path {

    protected final T identity;

    public Concept(T identity) {
        this.identity = identity;
    }

    public final T getIdentity() {
        return this.identity;
    }

    /**
     * <p> An absolute path is complete in that it doesn't need to be combined
     * with other path information in order to locate a file.
     *
     * @return {@code true} A fact is true by default
     */
    @Override
    public boolean isAbsolute() {
        return true;
    }

    /**
     * Returns the root component of this path as a {@code Path} object,
     * or {@code null} if this path does not have a root component.
     *
     * @return a path representing the root component of this path,
     * or {@code null}
     */
    @Override
    @SuppressWarnings("unchecked")
    public C getRoot() {
        C  defaultReturn = null;
        for (Path defaultPath: ((Context<S,L,PATH,ID,T,C>)this.identity..getContext().getLibrary().getRootDirectories()) {
            C defaultRoot = ((C) defaultPath);
            if (defaultRoot.identity.compareTo(this.identity) {
                return defaultRoot;
            }
            if (defaultRoot.identity.getPersona() == Identity.Aforementioned) {
                defaultReturn = defaultRoot;
            }
        }
        return defaultReturn;
    }

    /**
     * @return this fact
     */
    @Override
    @SuppressWarnings("unchecked")
    public C getFileName() {
        return (C)this;
    }

    @Override
    public FileSystem getFileSystem() {
        return this.identity.getContext().getLibrary();
    }

    @Override
    public Path getParent() {
        return null;
    }

    @Override
    public Path getName(int index) {
        return null;
    }

    @Override
    public Path subpath(int beginIndex, int endIndex) {
        return null;
    }

    /**
     * Tests if this path starts with the given path.
     *
     * <p> This path <em>starts</em> with the given path if this path's root
     * component <em>starts</em> with the root component of the given path,
     * and this path starts with the same name elements as the given path.
     * If the given path has more name elements than this path then {@code false}
     * is returned.
     *
     * <p> Whether or not the root component of this path starts with the root
     * component of the given path is file system specific. If this path does
     * not have a root component and the given path has a root component then
     * this path does not start with the given path.
     *
     * <p> If the given path is associated with a different {@code FileSystem}
     * to this path then {@code false} is returned.
     *
     * @param other the given path
     * @return {@code true} if this path starts with the given path; otherwise
     * {@code false}
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean startsWith(Path other) {
        if (other.getClass().isAssignableFrom(this.getClass()) || this.getClass().isAssignableFrom(other.getClass())) {
            C that = (C)other;
            return this.identity.getContext().getLibrary().compareTo(that.identity.getContext().getLibrary()) == 0;
        }
        return false;
    }

    /**
     * Tests if this path ends with the given path.
     *
     * <p> If the given path has <em>N</em> elements, and no root component,
     * and this path has <em>N</em> or more elements, then this path ends with
     * the given path if the last <em>N</em> elements of each path, starting at
     * the element farthest from the root, are equal.
     *
     * <p> If the given path has a root component then this path ends with the
     * given path if the root component of this path <em>ends with</em> the root
     * component of the given path, and the corresponding elements of both paths
     * are equal. Whether or not the root component of this path ends with the
     * root component of the given path is file system specific. If this path
     * does not have a root component and the given path has a root component
     * then this path does not end with the given path.
     *
     * <p> If the given path is associated with a different {@code FileSystem}
     * to this path then {@code false} is returned.
     *
     * @param other the given path
     * @return {@code true} if this path ends with the given path; otherwise
     * {@code false}
     */
    @Override
    public boolean endsWith(Path other) {
        return false;
    }

    /**
     * Returns 'this' as a Fact's directory is already normalized.
     */
    @Override
    @SuppressWarnings("unchecked")
    public C normalize() {
        return (C) this;
    }

    /**
     * Resolve the given path against this path.
     *
     * <p> If the {@code other} parameter is an {@link #isAbsolute() absolute}
     * path then this method trivially returns {@code other}. If {@code other}
     * is an <i>empty path</i> then this method trivially returns this path.
     * Otherwise this method considers this path to be a directory and resolves
     * the given path against this path. In the simplest case, the given path
     * does not have a {@link #getRoot root} component, in which case this method
     * <em>joins</em> the given path to this path and returns a resulting path
     * that {@link #endsWith ends} with the given path. Where the given path has
     * a root component then resolution is highly implementation dependent and
     * therefore unspecified.
     *
     * @param other the path to resolve against this path
     * @return the resulting path
     * @see #relativize
     */
    @Override
    public Path resolve(Path other) {
        return null;
    }

    /**
     * Constructs a relative path between this path and a given path.
     *
     * <p> Relativization is the inverse of {@link #resolve(Path) resolution}.
     * This method attempts to construct a {@link #isAbsolute relative} path
     * that when {@link #resolve(Path) resolved} against this path, yields a
     * path that locates the same file as the given path. For example, on UNIX,
     * if this path is {@code "/a/b"} and the given path is {@code "/a/b/c/d"}
     * then the resulting relative path would be {@code "c/d"}. Where this
     * path and the given path do not have a {@link #getRoot root} component,
     * then a relative path can be constructed. A relative path cannot be
     * constructed if only one of the paths have a root component. Where both
     * paths have a root component then it is implementation dependent if a
     * relative path can be constructed. If this path and the given path are
     * {@link #equals equal} then an <i>empty path</i> is returned.
     *
     * <p> For any two {@link #normalize normalized} paths <i>p</i> and
     * <i>q</i>, where <i>q</i> does not have a root component,
     * <blockquote>
     * <i>p</i>{@code .relativize(}<i>p</i>
     * {@code .resolve(}<i>q</i>{@code )).equals(}<i>q</i>{@code )}
     * </blockquote>
     *
     * <p> When symbolic links are supported, then whether the resulting path,
     * when resolved against this path, yields a path that can be used to locate
     * the {@link Files#isSameFile same} file as {@code other} is implementation
     * dependent. For example, if this path is  {@code "/a/b"} and the given
     * path is {@code "/a/x"} then the resulting relative path may be {@code
     * "../x"}. If {@code "b"} is a symbolic link then is implementation
     * dependent if {@code "a/b/../x"} would locate the same file as {@code "/a/x"}.
     *
     * @param other the path to relativize against this path
     * @return the resulting relative path, or an empty path if both paths are
     * equal
     * @throws IllegalArgumentException if {@code other} is not a {@code Path} that can be relativized
     *                                  against this path
     */
    @Override
    public Path relativize(Path other) {
        return null;
    }

    /**
     * Returns a URI to represent this path.
     *
     * <p> This method constructs an absolute {@link URI} with a {@link
     * URI#getScheme() scheme} equal to the URI scheme that identifies the
     * provider. The exact form of the scheme specific part is highly provider
     * dependent.
     *
     * <p> In the case of the default provider, the URI is hierarchical with
     * a {@link URI#getPath() path} component that is absolute. The query and
     * fragment components are undefined. Whether the authority component is
     * defined or not is implementation dependent. There is no guarantee that
     * the {@code URI} may be used to construct a {@link File java.io.File}.
     * In particular, if this path represents a Universal Naming Convention (UNC)
     * path, then the UNC server name may be encoded in the authority component
     * of the resulting URI. In the case of the default provider, and the file
     * exists, and it can be determined that the file is a directory, then the
     * resulting {@code URI} will end with a slash.
     *
     * <p> The default provider provides a similar <em>round-trip</em> guarantee
     * to the {@link File} class. For a given {@code Path} <i>p</i> it
     * is guaranteed that
     * <blockquote>
     * {@link Path#of(URI) Path.of}{@code (}<i>p</i>{@code .toUri()).equals(}<i>p</i>
     * {@code .}{@link #toAbsolutePath() toAbsolutePath}{@code ())}
     * </blockquote>
     * so long as the original {@code Path}, the {@code URI}, and the new {@code
     * Path} are all created in (possibly different invocations of) the same
     * Java virtual machine. Whether other providers make any guarantees is
     * provider specific and therefore unspecified.
     *
     * <p> When a file system is constructed to access the contents of a file
     * as a file system then it is highly implementation specific if the returned
     * URI represents the given path in the file system or it represents a
     * <em>compound</em> URI that encodes the URI of the enclosing file system.
     * A format for compound URIs is not defined in this release; such a scheme
     * may be added in a future release.
     *
     * @return the URI representing this path
     * @throws IOError           if an I/O error occurs obtaining the absolute path, or where a
     *                           file system is constructed to access the contents of a file as
     *                           a file system, and the URI of the enclosing file system cannot be
     *                           obtained
     * @throws SecurityException In the case of the default provider, and a security manager
     *                           is installed, the {@link #toAbsolutePath toAbsolutePath} method
     *                           throws a security exception.
     */
    @Override
    public URI toUri() {
        return null;
    }

    /**
     * Returns a {@code Path} object representing the absolute path of this
     * path.
     *
     * <p> If this path is already {@link Path#isAbsolute absolute} then this
     * method simply returns this path. Otherwise, this method resolves the path
     * in an implementation dependent manner, typically by resolving the path
     * against a file system default directory. Depending on the implementation,
     * this method may throw an I/O error if the file system is not accessible.
     *
     * @return a {@code Path} object representing the absolute path
     * @throws IOError           if an I/O error occurs
     * @throws SecurityException In the case of the default provider, a security manager
     *                           is installed, and this path is not absolute, then the security
     *                           manager's {@link SecurityManager#checkPropertyAccess(String)
     *                           checkPropertyAccess} method is invoked to check access to the
     *                           system property {@code user.dir}
     */
    @Override
    public Path toAbsolutePath() {
        return null;
    }

    /**
     * Returns the <em>real</em> path of an existing file.
     *
     * <p> The precise definition of this method is implementation dependent but
     * in general it derives from this path, an {@link #isAbsolute absolute}
     * path that locates the {@link Files#isSameFile same} file as this path, but
     * with name elements that represent the actual name of the directories
     * and the file. For example, where filename comparisons on a file system
     * are case insensitive then the name elements represent the names in their
     * actual case. Additionally, the resulting path has redundant name
     * elements removed.
     *
     * <p> If this path is relative then its absolute path is first obtained,
     * as if by invoking the {@link #toAbsolutePath toAbsolutePath} method.
     *
     * <p> The {@code options} array may be used to indicate how symbolic links
     * are handled. By default, symbolic links are resolved to their final
     * target. If the option {@link LinkOption#NOFOLLOW_LINKS NOFOLLOW_LINKS} is
     * present then this method does not resolve symbolic links.
     * <p>
     * Some implementations allow special names such as "{@code ..}" to refer to
     * the parent directory. When deriving the <em>real path</em>, and a
     * "{@code ..}" (or equivalent) is preceded by a non-"{@code ..}" name then
     * an implementation will typically cause both names to be removed. When
     * not resolving symbolic links and the preceding name is a symbolic link
     * then the names are only removed if it guaranteed that the resulting path
     * will locate the same file as this path.
     *
     * @param options options indicating how symbolic links are handled
     * @return an absolute path represent the <em>real</em> path of the file
     * located by this object
     * @throws IOException       if the file does not exist or an I/O error occurs
     * @throws SecurityException In the case of the default provider, and a security manager
     *                           is installed, its {@link SecurityManager#checkRead(String) checkRead}
     *                           method is invoked to check read access to the file, and where
     *                           this path is not absolute, its {@link SecurityManager#checkPropertyAccess(String)
     *                           checkPropertyAccess} method is invoked to check access to the
     *                           system property {@code user.dir}
     */
    @Override
    public Path toRealPath(LinkOption... options) throws IOException {
        return null;
    }

    /**
     * Registers the file located by this path with a watch service.
     *
     * <p> In this release, this path locates a directory that exists. The
     * directory is registered with the watch service so that entries in the
     * directory can be watched. The {@code events} parameter is the events to
     * register and may contain the following events:
     * <ul>
     *   <li>{@link StandardWatchEventKinds#ENTRY_CREATE ENTRY_CREATE} -
     *       entry created or moved into the directory</li>
     *   <li>{@link StandardWatchEventKinds#ENTRY_DELETE ENTRY_DELETE} -
     *        entry deleted or moved out of the directory</li>
     *   <li>{@link StandardWatchEventKinds#ENTRY_MODIFY ENTRY_MODIFY} -
     *        entry in directory was modified</li>
     * </ul>
     *
     * <p> The {@link WatchEvent#context context} for these events is the
     * relative path between the directory located by this path, and the path
     * that locates the directory entry that is created, deleted, or modified.
     *
     * <p> The set of events may include additional implementation specific
     * event that are not defined by the enum {@link StandardWatchEventKinds}
     *
     * <p> The {@code modifiers} parameter specifies <em>modifiers</em> that
     * qualify how the directory is registered. This release does not define any
     * <em>standard</em> modifiers. It may contain implementation specific
     * modifiers.
     *
     * <p> Where a file is registered with a watch service by means of a symbolic
     * link then it is implementation specific if the watch continues to depend
     * on the existence of the symbolic link after it is registered.
     *
     * @param watcher   the watch service to which this object is to be registered
     * @param events    the events for which this object should be registered
     * @param modifiers the modifiers, if any, that modify how the object is registered
     * @return a key representing the registration of this object with the
     * given watch service
     * @throws UnsupportedOperationException if unsupported events or modifiers are specified
     * @throws IllegalArgumentException      if an invalid combination of events or modifiers is specified
     * @throws ClosedWatchServiceException   if the watch service is closed
     * @throws NotDirectoryException         if the file is registered to watch the entries in a directory
     *                                       and the file is not a directory  <i>(optional specific exception)</i>
     * @throws IOException                   if an I/O error occurs
     * @throws SecurityException             In the case of the default provider, and a security manager is
     *                                       installed, the {@link SecurityManager#checkRead(String) checkRead}
     *                                       method is invoked to check read access to the file.
     */
    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        return null;
    }

    /**
     * Compares two abstract paths lexicographically. The ordering defined by
     * this method is provider specific, and in the case of the default
     * provider, platform specific. This method does not access the file system
     * and neither file is required to exist.
     *
     * <p> This method may not be used to compare paths that are associated
     * with different file system providers.
     *
     * @param other the path compared to this path.
     * @return zero if the argument is {@link #equals equal} to this path, a
     * value less than zero if this path is lexicographically less than
     * the argument, or a value greater than zero if this path is
     * lexicographically greater than the argument
     * @throws ClassCastException if the paths are associated with different providers
     */
    @Override
    public int compareTo(Path other) {
        return 0;
    }

    /**
     * Tests if this path starts with a {@code Path}, constructed by converting
     * the given path string, in exactly the manner specified by the {@link
     * #startsWith(Path) startsWith(Path)} method. On UNIX for example, the path
     * "{@code foo/bar}" starts with "{@code foo}" and "{@code foo/bar}". It
     * does not start with "{@code f}" or "{@code fo}".
     *
     * @param other the given path string
     * @return {@code true} if this path starts with the given path; otherwise
     * {@code false}
     * @throws InvalidPathException If the path string cannot be converted to a Path.
     * @implSpec The default implementation is equivalent for this path to:
     * <pre>{@code
     *     startsWith(getFileSystem().getPath(other));
     * }</pre>
     */
    @Override
    public boolean startsWith(String other) {
        return Path.super.startsWith(other);
    }

    /**
     * Tests if this path ends with a {@code Path}, constructed by converting
     * the given path string, in exactly the manner specified by the {@link
     * #endsWith(Path) endsWith(Path)} method. On UNIX for example, the path
     * "{@code foo/bar}" ends with "{@code foo/bar}" and "{@code bar}". It does
     * not end with "{@code r}" or "{@code /bar}". Note that trailing separators
     * are not taken into account, and so invoking this method on the {@code
     * Path}"{@code foo/bar}" with the {@code String} "{@code bar/}" returns
     * {@code true}.
     *
     * @param other the given path string
     * @return {@code true} if this path ends with the given path; otherwise
     * {@code false}
     * @throws InvalidPathException If the path string cannot be converted to a Path.
     * @implSpec The default implementation is equivalent for this path to:
     * <pre>{@code
     *     endsWith(getFileSystem().getPath(other));
     * }</pre>
     */
    @Override
    public boolean endsWith(String other) {
        return Path.super.endsWith(other);
    }

    /**
     * Converts a given path string to a {@code Path} and resolves it against
     * this {@code Path} in exactly the manner specified by the {@link
     * #resolve(Path) resolve} method. For example, suppose that the name
     * separator is "{@code /}" and a path represents "{@code foo/bar}", then
     * invoking this method with the path string "{@code gus}" will result in
     * the {@code Path} "{@code foo/bar/gus}".
     *
     * @param other the path string to resolve against this path
     * @return the resulting path
     * @throws InvalidPathException if the path string cannot be converted to a Path.
     * @implSpec The default implementation is equivalent for this path to:
     * <pre>{@code
     *     resolve(getFileSystem().getPath(other));
     * }</pre>
     * @see FileSystem#getPath
     */
    @Override
    public Path resolve(String other) {
        return Path.super.resolve(other);
    }

    /**
     * Resolves the given path against this path's {@link #getParent parent}
     * path. This is useful where a file name needs to be <i>replaced</i> with
     * another file name. For example, suppose that the name separator is
     * "{@code /}" and a path represents "{@code dir1/dir2/foo}", then invoking
     * this method with the {@code Path} "{@code bar}" will result in the {@code
     * Path} "{@code dir1/dir2/bar}". If this path does not have a parent path,
     * or {@code other} is {@link #isAbsolute() absolute}, then this method
     * returns {@code other}. If {@code other} is an empty path then this method
     * returns this path's parent, or where this path doesn't have a parent, the
     * empty path.
     *
     * @param other the path to resolve against this path's parent
     * @return the resulting path
     * @implSpec The default implementation is equivalent for this path to:
     * <pre>{@code
     *     (getParent() == null) ? other : getParent().resolve(other);
     * }</pre>
     * unless {@code other == null}, in which case a
     * {@code NullPointerException} is thrown.
     * @see #resolve(Path)
     */
    @Override
    public Path resolveSibling(Path other) {
        return Path.super.resolveSibling(other);
    }

    /**
     * Converts a given path string to a {@code Path} and resolves it against
     * this path's {@link #getParent parent} path in exactly the manner
     * specified by the {@link #resolveSibling(Path) resolveSibling} method.
     *
     * @param other the path string to resolve against this path's parent
     * @return the resulting path
     * @throws InvalidPathException if the path string cannot be converted to a Path.
     * @implSpec The default implementation is equivalent for this path to:
     * <pre>{@code
     *     resolveSibling(getFileSystem().getPath(other));
     * }</pre>
     * @see FileSystem#getPath
     */
    @Override
    public Path resolveSibling(String other) {
        return Path.super.resolveSibling(other);
    }

    /**
     * Returns null
     */
    @Override
    public File toFile() {
        return null;
    }

    /**
     * Registers the file located by this path with a watch service.
     *
     * <p> An invocation of this method behaves in exactly the same way as the
     * invocation
     * <pre>
     *     watchable.{@link #register(WatchService, WatchEvent.Kind[], WatchEvent.Modifier[]) register}(watcher, events, new WatchEvent.Modifier[0]);
     * </pre>
     *
     * <p> <b>Usage Example:</b>
     * Suppose we wish to register a directory for entry create, delete, and modify
     * events:
     * <pre>
     *     Path dir = ...
     *     WatchService watcher = ...
     *
     *     WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
     * </pre>
     *
     * @param watcher The watch service to which this object is to be registered
     * @param events  The events for which this object should be registered
     * @return A key representing the registration of this object with the
     * given watch service
     * @throws UnsupportedOperationException If unsupported events are specified
     * @throws IllegalArgumentException      If an invalid combination of events is specified
     * @throws ClosedWatchServiceException   If the watch service is closed
     * @throws NotDirectoryException         If the file is registered to watch the entries in a directory
     *                                       and the file is not a directory  <i>(optional specific exception)</i>
     * @throws IOException                   If an I/O error occurs
     * @throws SecurityException             In the case of the default provider, and a security manager is
     *                                       installed, the {@link SecurityManager#checkRead(String) checkRead}
     *                                       method is invoked to check read access to the file.
     * @implSpec The default implementation is equivalent for this path to:
     * <pre>{@code
     *     register(watcher, events, new WatchEvent.Modifier[0]);
     * }</pre>
     */
    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>... events) throws IOException {
        return Path.super.register(watcher, events);
    }

    /**
     * Returns an iterator over the name elements of this path.
     *
     * <p> The first element returned by the iterator represents the name
     * element that is closest to the root in the directory hierarchy, the
     * second element is the next closest, and so on. The last element returned
     * is the name of the file or directory denoted by this path. The {@link
     * #getRoot root} component, if present, is not returned by the iterator.
     *
     * @return an iterator over the name elements of this path.
     * @implSpec The default implementation returns an {@code Iterator<Path>} which, for
     * this path, traverses the {@code Path}s returned by
     * {@code getName(index)}, where {@code index} ranges from zero to
     * {@code getNameCount() - 1}, inclusive.
     */
    @Override
    public Iterator<Path> iterator() {
        return Path.super.iterator();
    }

    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Actions are performed in the order of iteration, if that
     * order is specified.  Exceptions thrown by the action are relayed to the
     * caller.
     * <p>
     * The behavior of this method is unspecified if the action performs
     * side-effects that modify the underlying source of elements, unless an
     * overriding class has specified a concurrent modification policy.
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @implSpec <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     * @since 1.8
     */
    @Override
    public void forEach(Consumer<? super Path> action) {
        Path.super.forEach(action);
    }

    /**
     * Creates a {@link Spliterator} over the elements described by this
     * {@code Iterable}.
     *
     * @return a {@code Spliterator} over the elements described by this
     * {@code Iterable}.
     * @implSpec The default implementation creates an
     * <em><a href="../util/Spliterator.html#binding">early-binding</a></em>
     * spliterator from the iterable's {@code Iterator}.  The spliterator
     * inherits the <em>fail-fast</em> properties of the iterable's iterator.
     * @implNote The default implementation should usually be overridden.  The
     * spliterator returned by the default implementation has poor splitting
     * capabilities, is unsized, and does not report any spliterator
     * characteristics. Implementing classes can nearly always provide a
     * better implementation.
     * @since 1.8
     */
    @Override
    public Spliterator<Path> spliterator() {
        return Path.super.spliterator();
    }

    @Override
    public final int getNameCount() {
        if (this.getParent() == null) {
            return 1;
        }
        return this.getParent().getNameCount() + 1;
    }
}
