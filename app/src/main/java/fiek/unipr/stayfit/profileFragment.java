/*
package fiek.unipr.stayfit;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.media.MediaRecorder.VideoSource.CAMERA;
import static androidx.core.content.ContextCompat.checkSelfPermission;

public class profileFragment extends Fragment {
    Button captureBtn;
    ImageView iv_capture;
    View view;

    public profileFragment() {
        // Required empty public constructor
    }

    public static profileFragment newInstance(String param1, String param2) {
        profileFragment fragment = new profileFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        captureBtn = (Button) view.findViewById(R.id.captureBtn);
        iv_capture = getActivity().findViewById(R.id.iv_capture);

        captureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "clicked", Toast.LENGTH_LONG).show();
            }
        });

        return view;

    }

}*//*

package fiek.unipr.stayfit;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.media.MediaRecorder.VideoSource.CAMERA;
import static androidx.core.content.ContextCompat.checkSelfPermission;

public class profileFragment extends Fragment {
    Button captureBtn;
    ImageView iv_capture;
    View view;
    TextView tvProfileName;

    public profileFragment() {
        // Required empty public constructor
    }

    public static profileFragment newInstance(String param1, String param2) {
        profileFragment fragment = new profileFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        captureBtn = (Button) view.findViewById(R.id.captureBtn);
        iv_capture = getActivity().findViewById(R.id.iv_capture);

        Bundle args = getArguments();
        try {
            String myString = args.getString("email");
            tvProfileName.setText(myString);

        }
        catch (Exception e){
            Toast.makeText(getActivity(),"empty arg", Toast.LENGTH_LONG).show();
        }

        captureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "clicked", Toast.LENGTH_LONG).show();
            }
        });

        return view;

    }

}
*/
package fiek.unipr.stayfit;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.media.MediaRecorder.VideoSource.CAMERA;
import static androidx.core.content.ContextCompat.checkSelfPermission;

public class profileFragment extends Fragment {
    Button captureBtn;
    ImageView iv_capture;
    View view;
    TextView tvProfileName;

    public profileFragment() {
        // Required empty public constructor
    }

    public static profileFragment newInstance(String param1, String param2) {
        profileFragment fragment = new profileFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        captureBtn = (Button) view.findViewById(R.id.captureBtn);
        iv_capture = getActivity().findViewById(R.id.iv_capture);

        Bundle args = getArguments();
        try {
            String myString = args.getString("email");
            tvProfileName.setText(myString);

        }
        catch (Exception e){
            Toast.makeText(getActivity(),"empty arg", Toast.LENGTH_LONG).show();
        }

        captureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "clicked", Toast.LENGTH_LONG).show();
            }
        });

        return view;

    }

}
