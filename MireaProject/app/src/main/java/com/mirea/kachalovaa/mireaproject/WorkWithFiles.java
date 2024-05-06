package com.mirea.kachalovaa.mireaproject;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WorkWithFiles#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorkWithFiles extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WorkWithFiles() {

    }

    public static WorkWithFiles newInstance(String param1, String param2) {
        WorkWithFiles fragment = new WorkWithFiles();
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
        return inflater.inflate(R.layout.fragment_work_with_files, container, false);
    }

    private EditText loginTextFileName;
    private EditText password;

    private Button loadButton;

    private FloatingActionButton floatingButton;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginTextFileName = view.findViewById(R.id.loginFileName);
        password = view.findViewById(R.id.contentField);
        loadButton = view.findViewById(R.id.loadButton);
        floatingButton = view.findViewById(R.id.floatingButton);
        loadButton.setOnClickListener(view1 -> readFile());
        floatingButton.setOnClickListener(view1 -> createPopup());
    }

    private void createPopup() {
        View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.pop_up_window, null);
        final PopupWindow popUpWindow = new PopupWindow(popupView, 1000, 1000, true);
        TextView contentEncrypted = popupView.findViewById(R.id.encryptedPassword);
        contentEncrypted.setText(new String(encryptTextMessage(password.getText().toString()), StandardCharsets.UTF_8));
        Button saveButton = popupView.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(view1 -> {
            writeFile();
            popUpWindow.dismiss();
        });
        if (loginTextFileName.getText().toString().length() < 1 || password.getText().toString().length() < 1) {
            saveButton.setEnabled(false);
        } else {
            saveButton.setEnabled(true);
        }
        popUpWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
    }

    private byte[] encryptTextMessage(String text) {
        try {
            byte[] cipherText = Base64.encode(text.getBytes(), Base64.DEFAULT);

            return cipherText;
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        return "".getBytes();
    }

    private String decryptTextMessage(String content) {
        try {
            String cipherText = new String(Base64.decode(content, Base64.DEFAULT));

            return cipherText;
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        return "";
    }

    private void writeFile() {
        String content = password.getText().toString();
        FileOutputStream outputStream;
        try {
            outputStream = getContext().openFileOutput(loginTextFileName.getText().toString(), Context.MODE_PRIVATE);
            outputStream.write(new String(encryptTextMessage(content), StandardCharsets.UTF_8).getBytes());

            outputStream.close();
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void readFile() {
        FileInputStream fin = null;
        try {
            fin = getContext().openFileInput(loginTextFileName.getText().toString());
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String content = decryptTextMessage(new String(bytes));
            password.setText(content);

        } catch (IOException ex) {
            Toast.makeText(getActivity(), "ERROR: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException ex) {
                Toast.makeText(getActivity(), "ERROR: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}