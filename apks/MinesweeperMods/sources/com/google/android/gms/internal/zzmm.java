package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.SimpleArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class zzmm extends AbstractSet {
    private final ArrayMap zzanZ;

    public zzmm() {
        this.zzanZ = new ArrayMap();
    }

    public zzmm(int i) {
        this.zzanZ = new ArrayMap(i);
    }

    public zzmm(Collection collection) {
        this(collection.size());
        addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        if (this.zzanZ.containsKey(obj)) {
            return false;
        }
        this.zzanZ.put(obj, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        return collection instanceof zzmm ? zza((zzmm) collection) : super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.zzanZ.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.zzanZ.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.zzanZ.keySet().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (!this.zzanZ.containsKey(obj)) {
            return false;
        }
        this.zzanZ.remove(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.zzanZ.size();
    }

    public boolean zza(zzmm zzmmVar) {
        int size = size();
        this.zzanZ.putAll((SimpleArrayMap) zzmmVar.zzanZ);
        return size() > size;
    }
}
