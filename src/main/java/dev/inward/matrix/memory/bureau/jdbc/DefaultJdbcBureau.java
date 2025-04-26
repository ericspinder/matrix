/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.jdbc;

import dev.inward.matrix.Scheme;
import dev.inward.matrix.control.catalog.*;
import dev.inward.matrix.control.library.*;
import dev.inward.matrix.file.*;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.Map;

public final class DefaultJdbcBureau extends JdbcBureau<DefaultJdbcBureau,DefaultJdbcBureauView,DefaultJdbcBureauModel,DefaultJdbcBureauReference,DefaultJdbcBureauLibrarian> {
    public DefaultJdbcBureau(DefaultJdbcBureauKey key, Map<String, Object> attributes, Class<FileView<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>>... supportedFileViews) {
        super(key, attributes, supportedFileViews);
    }

    @Override
    public <S extends Scheme<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, LK extends LibraryKey<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, L extends Library<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, LV extends LibraryView<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, LM extends LibraryModel<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, LR extends LibraryReference<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, LG extends LibraryLibrarian<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, PATH extends Comparable<PATH>, CK extends CatalogKey<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, C extends Catalog<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, CV extends CatalogView<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, CM extends CatalogModel<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, CR extends CatalogReference<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, CG extends CatalogLibrarian<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, DB extends DirectoryLibrarian<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, DK extends DirectoryKey<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, D extends Directory<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, DV extends DirectoryView<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, DM extends DirectoryModel<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, DR extends DirectoryReference<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, DG extends DirectoryLibrarian<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG>, LB extends FileLibrarian<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG, LB, K, F, V, M, R, G>, K extends FileKey<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG, LB, K, F, V, M, R, G>, F extends File<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG, LB, K, F, V, M, R, G>, V extends FileView<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG, LB, K, F, V, M, R, G>, M extends FileModel<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG, LB, K, F, V, M, R, G>, R extends FileReference<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG, LB, K, F, V, M, R, G>, G extends FileLibrarian<S, LK, L, LV, LM, LR, LG, PATH, CK, C, CV, CM, CR, CG, DB, DK, D, DV, DM, DR, DG, LB, K, F, V, M, R, G>> F getFile(K key, R reference) {
        return null;
    }

    @Override
    public <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> type) {
        if (type.isAssignableFrom(DefaultJdbcBureauView.class)) {
            try {
                return type.getConstructor(DefaultJdbcBureau.class, DefaultJdbcBureauModel.class).newInstance(this,this.getKey().getItemReference().getGestalt().getModel());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
