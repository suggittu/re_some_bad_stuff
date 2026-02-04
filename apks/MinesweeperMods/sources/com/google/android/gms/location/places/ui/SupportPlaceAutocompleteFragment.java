package com.google.android.gms.location.places.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.gms.R;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes2.dex */
public class SupportPlaceAutocompleteFragment extends Fragment {
    private View zzaRh;
    private View zzaRi;
    private EditText zzaRj;

    @Nullable
    private LatLngBounds zzaRk;

    @Nullable
    private AutocompleteFilter zzaRl;

    @Nullable
    private PlaceSelectionListener zzaRm;

    private void zzzF() {
        this.zzaRi.setVisibility(!this.zzaRj.getText().toString().isEmpty() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzzG() {
        int i;
        try {
            startActivityForResult(new PlaceAutocomplete.IntentBuilder(2).setBoundsBias(this.zzaRk).setFilter(this.zzaRl).zzeq(this.zzaRj.getText().toString()).zzig(1).build(getActivity()), 1);
            i = -1;
        } catch (GooglePlayServicesNotAvailableException e) {
            int i2 = e.errorCode;
            Log.e("Places", "Could not open autocomplete activity", e);
            i = i2;
        } catch (GooglePlayServicesRepairableException e2) {
            int connectionStatusCode = e2.getConnectionStatusCode();
            Log.e("Places", "Could not open autocomplete activity", e2);
            i = connectionStatusCode;
        }
        if (i != -1) {
            GoogleApiAvailability.getInstance().showErrorDialogFragment(getActivity(), i, 2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (i2 == -1) {
                Place place = PlaceAutocomplete.getPlace(getActivity(), intent);
                if (this.zzaRm != null) {
                    this.zzaRm.onPlaceSelected(place);
                }
                setText(place.getName().toString());
            } else if (i2 == 2) {
                Status status = PlaceAutocomplete.getStatus(getActivity(), intent);
                if (this.zzaRm != null) {
                    this.zzaRm.onError(status);
                }
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.place_autocomplete_fragment, viewGroup, false);
        this.zzaRh = viewInflate.findViewById(R.id.place_autocomplete_search_button);
        this.zzaRi = viewInflate.findViewById(R.id.place_autocomplete_clear_button);
        this.zzaRj = (EditText) viewInflate.findViewById(R.id.place_autocomplete_search_input);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.google.android.gms.location.places.ui.SupportPlaceAutocompleteFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SupportPlaceAutocompleteFragment.this.zzzG();
            }
        };
        this.zzaRh.setOnClickListener(onClickListener);
        this.zzaRj.setOnClickListener(onClickListener);
        this.zzaRi.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.location.places.ui.SupportPlaceAutocompleteFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SupportPlaceAutocompleteFragment.this.setText("");
            }
        });
        zzzF();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.zzaRh = null;
        this.zzaRi = null;
        this.zzaRj = null;
        super.onDestroyView();
    }

    public void setBoundsBias(@Nullable LatLngBounds latLngBounds) {
        this.zzaRk = latLngBounds;
    }

    public void setFilter(@Nullable AutocompleteFilter autocompleteFilter) {
        this.zzaRl = autocompleteFilter;
    }

    public void setHint(CharSequence charSequence) {
        this.zzaRj.setHint(charSequence);
        this.zzaRh.setContentDescription(charSequence);
    }

    public void setOnPlaceSelectedListener(PlaceSelectionListener placeSelectionListener) {
        this.zzaRm = placeSelectionListener;
    }

    public void setText(CharSequence charSequence) {
        this.zzaRj.setText(charSequence);
        zzzF();
    }
}
