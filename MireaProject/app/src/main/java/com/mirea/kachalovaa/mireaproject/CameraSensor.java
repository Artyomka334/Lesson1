package com.mirea.kachalovaa.mireaproject;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CameraSensor#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CameraSensor extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CameraSensor() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CameraSensor.
     */
    // TODO: Rename and change types and number of parameters
    public static CameraSensor newInstance(String param1, String param2) {
        CameraSensor fragment = new CameraSensor();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camera_sensor, container, false);
    }

    private ImageView imageView1, imageView2, imageView3, imageView4;
    private  static  final int REQUEST_CODE_PERMISSION =  200;
    private  boolean  isWork = false;
    private ActivityResultLauncher<Intent> cameraActivityResultLauncher;
    private Uri imageUri;
    private String clickedTag;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView1 = view.findViewById(R.id.image_1);
        imageView2 = view.findViewById(R.id.image_2);
        imageView3 = view.findViewById(R.id.image_3);
        imageView4 = view.findViewById(R.id.image_4);
        imageView1.setTag("image_1");
        imageView2.setTag("image_2");
        imageView3.setTag("image_3");
        imageView4.setTag("image_4");

        imageView1.setOnClickListener((v) -> setPicture(imageView1));
        imageView2.setOnClickListener((v) -> setPicture(imageView2));
        imageView3.setOnClickListener((v) -> setPicture(imageView3));
        imageView4.setOnClickListener((v) -> setPicture(imageView4));

        int  cameraPermissionStatus = ContextCompat.checkSelfPermission(view.getContext(),  android.Manifest.permission.CAMERA);
        int  storagePermissionStatus  = ContextCompat.checkSelfPermission(view.getContext(),  android.Manifest.permission.
                WRITE_EXTERNAL_STORAGE);

        if  (cameraPermissionStatus  ==  PackageManager.PERMISSION_GRANTED  &&  storagePermissionStatus
                ==  PackageManager.PERMISSION_GRANTED)  {
            isWork = true;
        }  else  {
            //  Выполняется запрос к пользователь на получение необходимых разрешений
            requestPermissions(new String[] {
                    android.Manifest.permission.CAMERA,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
            },  REQUEST_CODE_PERMISSION);
        }


        //  Создание функции  обработки  результата  от  системного  приложения  «камера»
        ActivityResultCallback<ActivityResult> callback  =  new  ActivityResultCallback<ActivityResult>()  {
            @Override
            public  void onActivityResult(ActivityResult result)  {
                if  (result.getResultCode()  ==  Activity.RESULT_OK)  {
                    Intent data = result.getData();
                    switch (clickedTag) {
                        case "image_1":
                            imageView1.setImageURI(imageUri);
                            break;
                        case "image_2":
                            imageView2.setImageURI(imageUri);
                            break;
                        case "image_3":
                            imageView3.setImageURI(imageUri);
                            break;
                        case "image_4":
                            imageView4.setImageURI(imageUri);
                            break;
                    }
                }
            }
        };
        cameraActivityResultLauncher  = registerForActivityResult(
                new  ActivityResultContracts.StartActivityForResult(),
                callback);
    }

    public void setPicture(View view) {
        Intent cameraIntent = new  Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (isWork) {
            try  {
                File  photoFile  =  createImageFile();
                String  authorities  =  getContext().getApplicationContext().getPackageName()  +  ".fileprovider";
                imageUri  = FileProvider.getUriForFile(getActivity(),  authorities,  photoFile);
                clickedTag = (String) view.getTag();

                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,  imageUri);
                cameraActivityResultLauncher.launch(cameraIntent);
            }  catch  (IOException  e)  {
                e.printStackTrace();
            }
        }
    }

    private File createImageFile()  throws IOException {
        String timeStamp =  new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ENGLISH).format(new Date());
        String imageFileName =  "IMAGE_" + timeStamp + "_";
        File storageDirectory =  getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        return File.createTempFile(imageFileName, ".jpg",  storageDirectory);
    }

    @Override
    public  void onRequestPermissionsResult(int  requestCode, @NonNull String[]  permissions, @NonNull  int[]  grantResults)  {
        super.onRequestPermissionsResult(requestCode,  permissions,  grantResults);
        if  (requestCode ==  REQUEST_CODE_PERMISSION)  {
            isWork = grantResults.length >  0
                    &&  grantResults[0]  ==  PackageManager.PERMISSION_GRANTED;
        }
    }

}