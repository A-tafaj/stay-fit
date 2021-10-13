package fiek.unipr.stayfit.fragments;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.ByteArrayOutputStream;

import fiek.unipr.stayfit.R;
import fiek.unipr.stayfit.activities.UserActivity;

public class profileFragment extends Fragment {
    private static final String TAG = "profileFragment";
    Button captureBtn;
    ImageView iv_capture;
    View view;
    TextView tvProfileName;
    FloatingActionButton floatingBtn;

    private SharedPreferences preferences;
    private static final int Image_Capture_Code = 1;

    public profileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getContext().getSharedPreferences("Image", Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_profile, container, false);
        captureBtn = view.findViewById(R.id.captureBtn);
        floatingBtn = view.findViewById((R.id.floatingBtn));
        iv_capture = view.findViewById(R.id.iv_capture);

        String pref = preferences.getString("image", null);

        if (pref != null) {
            byte[] imageAsBytes = Base64.decode(pref.getBytes(), Base64.DEFAULT);
            iv_capture.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));
        }

        Bundle args = getArguments();
        try {
            String myString = args.getString("email");
            tvProfileName.setText(myString);

        } catch (Exception e) {
            Toast.makeText(getActivity(), "empty arg", Toast.LENGTH_LONG).show();
        }

        captureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cInt, Image_Capture_Code);
            }
        });
        floatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Image_Capture_Code) {
            if (resultCode == RESULT_OK) {
                String encoded = bitMapToString(data);
                saveImgToSharedPref(encoded);

                byte[] imageAsBytes = Base64.decode(encoded.getBytes(), Base64.DEFAULT);

                iv_capture.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));//.setImageBitmap(bp);
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getActivity(), "Cancelled", Toast.LENGTH_LONG).show();
            }
        }
    }

    private String bitMapToString(Intent data) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] b = byteArrayOutputStream.toByteArray();
        String encoded = Base64.encodeToString(b, Base64.DEFAULT);

        return encoded;
    }

    public void saveImgToSharedPref(String image) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("image", image).commit();
        String pref = preferences.getString("image", "");
        Log.d(TAG, "saveImgToSharedPref: " + pref);
    }
}

