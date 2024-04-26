package com.mirea.kachalovaa.mireaproject;

import static android.Manifest.permission.POST_NOTIFICATIONS;

import android.content.pm.PackageManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VoiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VoiceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VoiceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VoiceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VoiceFragment newInstance(String param1, String param2) {
        VoiceFragment fragment = new VoiceFragment();
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
        return inflater.inflate(R.layout.fragment_voice, container, false);
    }

    private boolean isWork = false;
    private  static  final  int  REQUEST_CODE_PERMISSION  =  200;

    private TextView durationText;
    private Button startStopRecording;
    private Button startTrack;

    private MediaRecorder mediaRecorder =  null;
    private MediaPlayer mediaPlayer =  null;
    boolean startRecording =  true;
    boolean startPlaying =  true;

    String fileName;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        durationText = view.findViewById(R.id.durationText);
        startStopRecording = view.findViewById(R.id.startStopAudio);
        startTrack = view.findViewById(R.id.startTrack);

        startTrack.setEnabled(false);
        durationText.setVisibility(View.INVISIBLE);

        fileName = (new File(getActivity().getExternalFilesDir(Environment.DIRECTORY_MUSIC),
                "/audiorecordtest.3gp")).getAbsolutePath();

        int notificationsPermissionStatus = ContextCompat.checkSelfPermission(getContext(), POST_NOTIFICATIONS);
        int  audioRecordPermissionStatus  =  ContextCompat.checkSelfPermission(getContext(),
                android.Manifest.permission.RECORD_AUDIO);
        int  storagePermissionStatus  =  ContextCompat.checkSelfPermission(getContext(),  android.Manifest.permission.
                WRITE_EXTERNAL_STORAGE);
        if  (audioRecordPermissionStatus  ==  PackageManager.PERMISSION_GRANTED  &&  storagePermissionStatus
                ==  PackageManager.PERMISSION_GRANTED && notificationsPermissionStatus == PackageManager.PERMISSION_GRANTED)  {
            isWork  =  true;
        }  else  {
            //  Выполняется  запрос  к  пользователь  на  получение  необходимых  разрешений
            requestPermissions(new  String[]  {android.Manifest.permission.RECORD_AUDIO,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE, POST_NOTIFICATIONS},  REQUEST_CODE_PERMISSION);
        }

        startStopRecording.setOnClickListener(view1 -> {
            if (startRecording) {
                startStopRecording.setText("Остановить запись");
                startTrack.setEnabled(false);
                startRecording();
            } else {
                startStopRecording.setText("Начать запись");
                startTrack.setEnabled(true);
                stopRecording();
            }

            startRecording = !startRecording;
        });

        startTrack.setOnClickListener(view1 -> {
            if (startPlaying) {
                startTrack.setText("Остановить проигрыш");
                startStopRecording.setEnabled(false);
                startPlaying();
            } else {
                startTrack.setText("Запустить проигрыш");
                startStopRecording.setEnabled(false);
                stopPlaying();
            }

            startPlaying = !startPlaying;
        });
    }

    @Override
    public  void  onRequestPermissionsResult(int  requestCode, @NonNull String[]  permissions, @NonNull  int[]
            grantResults)  {
        super.onRequestPermissionsResult(requestCode,  permissions,  grantResults);
        switch  (requestCode){
            case  REQUEST_CODE_PERMISSION:
                isWork = grantResults[0] ==  PackageManager.PERMISSION_GRANTED;
                break;
        }
        if  (!isWork) getActivity().finish();
    }

    private  void startRecording()  {
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioChannels(1);
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setOutputFile(fileName);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        try  {
            mediaRecorder.prepare();
        }  catch  (IOException e)  {
            Log.e("ERRORS",  "prepare()  failed");
        }
        mediaRecorder.start();
    }

    private  void stopRecording() {
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;

        getDuration();
    }

    private void getDuration() {
        MediaMetadataRetriever mediaMetadataRetriever= new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(fileName);

        String duration = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);

        durationText.setText(getTimeFormatted(Integer.parseInt(duration)));
        durationText.setVisibility(View.VISIBLE);
    }

    private String getTimeFormatted(int time) {
        return String.format("Длительность: %02d:%02d", TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time)),
                TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time)));
    }

    private  void startPlaying()  {
        mediaPlayer = new  MediaPlayer();
        try  {
            mediaPlayer.setDataSource(fileName);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException  e)  {
            Log.e("ERRORS",  "prepare()  failed");
        }
    }

    private  void stopPlaying()  {
        mediaPlayer.release();
        mediaPlayer = null;
    }
}