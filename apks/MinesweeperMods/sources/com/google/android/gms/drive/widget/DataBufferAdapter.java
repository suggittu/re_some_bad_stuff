package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.drive.internal.zzz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class DataBufferAdapter extends BaseAdapter {
    private final Context mContext;
    private final LayoutInflater mInflater;
    private final int zzavs;
    private int zzavt;
    private final int zzavu;
    private final List zzavv;
    private boolean zzavw;

    public DataBufferAdapter(Context context, int i) {
        this(context, i, 0, new ArrayList());
    }

    public DataBufferAdapter(Context context, int i, int i2) {
        this(context, i, i2, new ArrayList());
    }

    public DataBufferAdapter(Context context, int i, int i2, List list) {
        this.zzavw = true;
        this.mContext = context;
        this.zzavt = i;
        this.zzavs = i;
        this.zzavu = i2;
        this.zzavv = list;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public DataBufferAdapter(Context context, int i, int i2, DataBuffer... dataBufferArr) {
        this(context, i, i2, Arrays.asList(dataBufferArr));
    }

    public DataBufferAdapter(Context context, int i, List list) {
        this(context, i, 0, list);
    }

    public DataBufferAdapter(Context context, int i, DataBuffer... dataBufferArr) {
        this(context, i, 0, Arrays.asList(dataBufferArr));
    }

    private View zza(int i, View view, ViewGroup viewGroup, int i2) {
        View viewInflate = view == null ? this.mInflater.inflate(i2, viewGroup, false) : view;
        try {
            TextView textView = this.zzavu == 0 ? (TextView) viewInflate : (TextView) viewInflate.findViewById(this.zzavu);
            Object item = getItem(i);
            if (item instanceof CharSequence) {
                textView.setText((CharSequence) item);
            } else {
                textView.setText(item.toString());
            }
            return viewInflate;
        } catch (ClassCastException e) {
            zzz.zza("DataBufferAdapter", e, "You must supply a resource ID for a TextView");
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", e);
        }
    }

    public void append(DataBuffer dataBuffer) {
        this.zzavv.add(dataBuffer);
        if (this.zzavw) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        Iterator it = this.zzavv.iterator();
        while (it.hasNext()) {
            ((DataBuffer) it.next()).release();
        }
        this.zzavv.clear();
        if (this.zzavw) {
            notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int count = 0;
        Iterator it = this.zzavv.iterator();
        while (true) {
            int i = count;
            if (!it.hasNext()) {
                return i;
            }
            count = ((DataBuffer) it.next()).getCount() + i;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return zza(i, view, viewGroup, this.zzavt);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int i2 = i;
        for (DataBuffer dataBuffer : this.zzavv) {
            int count = dataBuffer.getCount();
            if (count > i2) {
                try {
                    return dataBuffer.get(i2);
                } catch (CursorIndexOutOfBoundsException e) {
                    throw new CursorIndexOutOfBoundsException(i, getCount());
                }
            }
            i2 -= count;
        }
        throw new CursorIndexOutOfBoundsException(i, getCount());
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return zza(i, view, viewGroup, this.zzavs);
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.zzavw = true;
    }

    public void setDropDownViewResource(int i) {
        this.zzavt = i;
    }

    public void setNotifyOnChange(boolean z) {
        this.zzavw = z;
    }
}
