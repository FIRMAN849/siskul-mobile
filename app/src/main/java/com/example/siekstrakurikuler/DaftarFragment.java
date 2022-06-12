package com.example.siekstrakurikuler;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DaftarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DaftarFragment extends Fragment {

    private EditText edNama , edKelas, edAlamat , edEkskul,edAlasan;
    Button btnDaftarEkskul;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DaftarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DaftarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DaftarFragment newInstance(String param1, String param2) {
        DaftarFragment fragment = new DaftarFragment();
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
        return inflater.inflate(R.layout.fragment_daftar, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edNama = view.findViewById(R.id.etextNama);
        edKelas = view.findViewById(R.id.etextKelas);
        edAlamat = view.findViewById(R.id.etextAlamat);
        edEkskul = view.findViewById(R.id.etextEkskul);
        edAlasan = view.findViewById(R.id.etextAlasan);
        btnDaftarEkskul = view.findViewById(R.id.btnDaftar);



        btnDaftarEkskul.setOnClickListener(v->{
            if(edNama.getText().length()>0 && edKelas.getText().length()>0 && edAlamat.getText().length()>0 && edEkskul.getText().length()>0 && edAlasan.getText().length()>0 ){
                saveData(edNama.getText().toString(),edKelas.getText().toString(), edAlamat.getText(),toString(),edEkskul.getText().toString(),edAlasan.getText().toString());
            }else{
                Toast.makeText(getActivity(),"Silahkan isi semua data", Toast.LENGTH_LONG).show();
            }
        });
    }


    private void saveData(String name, String kelas, Editable text, String alamat, String ekskul, String alasan){
        Map<String, Object> user = new HashMap<>();
        user.put("name",name);
        user.put("kelas",kelas);
        user.put("alamat",alamat);
        user.put("ekskul",ekskul);
        user.put("alasan",alasan);



        db.collection("pendaftarekskul")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getActivity(),"Berhasil",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }




}