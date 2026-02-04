package com.google.android.gms.nearby.messages;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public final class SubscribeOptions {
    public static final SubscribeOptions DEFAULT = new Builder().build();
    private final Strategy zzbbI;
    private final MessageFilter zzbbV;

    @Nullable
    private final SubscribeCallback zzbbW;

    public class Builder {
        private Strategy zzbbI = Strategy.DEFAULT;
        private MessageFilter zzbbV = MessageFilter.INCLUDE_ALL_MY_TYPES;

        @Nullable
        private SubscribeCallback zzbbW;

        public SubscribeOptions build() {
            return new SubscribeOptions(this.zzbbI, this.zzbbV, this.zzbbW);
        }

        public Builder setCallback(SubscribeCallback subscribeCallback) {
            this.zzbbW = (SubscribeCallback) zzx.zzz(subscribeCallback);
            return this;
        }

        public Builder setFilter(MessageFilter messageFilter) {
            this.zzbbV = messageFilter;
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            this.zzbbI = strategy;
            return this;
        }
    }

    private SubscribeOptions(Strategy strategy, MessageFilter messageFilter, @Nullable SubscribeCallback subscribeCallback) {
        this.zzbbI = strategy;
        this.zzbbV = messageFilter;
        this.zzbbW = subscribeCallback;
    }

    @Nullable
    public final SubscribeCallback getCallback() {
        return this.zzbbW;
    }

    public final MessageFilter getFilter() {
        return this.zzbbV;
    }

    public final Strategy getStrategy() {
        return this.zzbbI;
    }
}
