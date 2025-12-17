/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.authority;

import dev.inward.matrix.concept.fact.directory.*;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.library.LibraryModel;
import dev.inward.matrix.control.library.LibraryView;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.control.scheme.SchemeModel;
import dev.inward.matrix.control.scheme.SchemeView;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Authority<S extends Scheme<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,SV extends SchemeView<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,SM extends SchemeModel<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,L extends Library<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,LV extends LibraryView<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,LM extends LibraryModel<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,A extends Authority<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,AV extends AuthorityView<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,AM extends AuthorityModel<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DF extends Directory<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DK extends DirectoryKey<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DV extends DirectoryView<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DM extends DirectoryModel<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DL extends DirectoryLibrarian<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DX extends DirectoryContext<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,PATH extends Comparable<PATH>> implements Control<A,AV,AM> {

    protected final UUID uuid = UUID.randomUUID();
    protected final Instant createTime = Instant.now();
    protected final String userInfo;
    protected final L library;

    protected StringBuilder firstLimitReachedMessage(String className, long warnTotal, long hardLimit) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(className).append("warnTotal:").append(warnTotal).append(" hardLimit").append(hardLimit);
        return stringBuilder;
    }
    protected String hardLimitReached(String className, long warnTotal, long hardLimit, AtomicLong count, String previousMessage) {
        return firstLimitReachedMessage(className,warnTotal,hardLimit).append(' ').append(previousMessage).toString() ;
    }

    public Authority(String userInfo, L library) {
        this.userInfo = userInfo;
        this.library = library;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public Instant getCreateInstant() {
        return createTime;
    }

}