package com.example.clevertaptask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.clevertap.android.sdk.CleverTapAPI;

import java.util.HashMap;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getActivity().getApplicationContext());


        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// event with properties
                HashMap<String, Object> prodViewedAction = new HashMap<String, Object>();
                prodViewedAction.put("Product ID", "1");
                prodViewedAction.put("Product Image ", "https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg");
                prodViewedAction.put("Product Name", "CleverTap");

                HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
                profileUpdate.put("Email", "vivek.c1994@gmail.com");               // Email address of the user
                profileUpdate.put("MSG-push", true);                        // Enable push notifications
                if (clevertapDefaultInstance != null) {
                    clevertapDefaultInstance.pushProfile(profileUpdate);
                    clevertapDefaultInstance.pushEvent("Product viewed", prodViewedAction);
                }
            }
        });
    }
}