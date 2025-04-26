/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.network.nioClient;


import dev.inward.matrix.Hosts;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.memory.bureau.network.NetworkClient;
import dev.inward.matrix.control.catalog.*;
import dev.inward.matrix.control.library.*;
import dev.inward.matrix.file.*;
import dev.inward.matrix.file.addressed.info.Persona;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.Map;

public class NioClient extends NetworkClient<NioClient,NioClientView,NioClientModel,NioClientReference,NioClientLibrarian> {

    public NioClient(String name, boolean readOnly, Map<String, Object> attributes, Class<FileView<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>>[] supportedFileViews, Hosts.Remote remoteHost, Hosts.LocalHost localHost) {
        super(name, readOnly,attributes, supportedFileViews,remoteHost,localHost);

    }


    @Override
    public <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> type) {
        if (type.isAssignableFrom(NioClientView.class)) {
            try {
                return type.getConstructor(NioClient.class, NioClientModel.class).newInstance(this,this.getItemReference().getGestalt().getModel());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public <S extends Scheme<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB>, L extends Library<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB>, LV extends LibraryView<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB>, LM extends LibraryModel<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB>, LR extends LibraryReference<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB>, LB extends LibraryLibrarian<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB>, PATH extends Comparable<PATH>, C extends Catalog<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB>, CV extends CatalogView<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB>, CM extends CatalogModel<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB>, CR extends CatalogReference<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB>, CB extends CatalogLibrarian<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB>, DK extends DirectoryKey<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB>, D extends Directory<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB>, DV extends DirectoryView<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB>, DM extends DirectoryModel<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB>, DR extends DirectoryReference<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB>, DB extends DirectoryLibrarian<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB>, K extends FileKey<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB, K, F, V, M, R, B>, F extends File<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB, K, F, V, M, R, B>, V extends FileView<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB, K, F, V, M, R, B>, M extends FileModel<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB, K, F, V, M, R, B>, R extends FileReference<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB, K, F, V, M, R, B>, B extends FileLibrarian<S, L, LV, LM, LR, LB, PATH, C, CV, CM, CR, CB, DK, D, DV, DM, DR, DB, K, F, V, M, R, B>> F getFile(K key, R reference, Persona persona) {
        return null;
    }
}
