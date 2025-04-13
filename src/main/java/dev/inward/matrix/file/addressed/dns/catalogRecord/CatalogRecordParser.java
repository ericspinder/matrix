/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.file.addressed.dns.DnsDirectoryKey;
import dev.inward.matrix.file.addressed.dns.ResourceRecordParser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public abstract class CatalogRecordParser<LB extends CatalogRecordLibrarian<LB,K,F,V,M,R,G>,K extends CatalogRecordKey<LB,K,F,V,M,R,G>,F extends CatalogRecord<LB,K,F,V,M,R,G>,V extends CatalogRecordView<LB,K,F,V,M,R,G>,M extends CatalogRecordModel<LB,K,F,V,M,R,G>,R extends CatalogRecordReference<LB,K,F,V,M,R,G>,G extends CatalogRecordSteward<LB,K,F,V,M,R,G>> extends ResourceRecordParser<LB,K,F,V,M,R,G> {

    public CatalogRecordParser(DnsDirectoryKey directoryKey) {
        super(directoryKey);
    }
    @SuppressWarnings("unchecked")


    public F getNew(K identity, String target,String startPath, String endPath, Zone zone, String protocol, int priority, int weight, int port, long syncAmount, TimeUnit syncUnit, int ttl) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return ((Class<F>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]).getDeclaredConstructor(CatalogRecordKey.class, String.class, String.class, String.class, Zone.class, String.class, Integer.class, Integer.class, Integer.class,Long.class, TimeUnit.class,Integer.class).newInstance(identity,target, startPath, endPath, zone, protocol, priority, weight, port, syncAmount, syncUnit,ttl);
    }

    @Override
    public F parse(String[] parts) {
        UUID uuid = UUID.fromString(parts[0]);;
        K catalogRecordKey = newRRKeyBuilder().setDirectoryKey(dnsDirectoryKey).setId(uuid).setDirectoryKey(dnsDirectoryKey).buildMatrixKey();
        try {
            return getNew(catalogRecordKey,parts[1],parts[2],parts[3], Zone.valueOf(parts[4]),parts[5],Integer.parseInt(parts[6]),Integer.parseInt(parts[7]),Integer.parseInt(parts[8]),Long.parseLong(parts[9]),TimeUnit.valueOf(parts[10]),Integer.parseInt(parts[11]));
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
