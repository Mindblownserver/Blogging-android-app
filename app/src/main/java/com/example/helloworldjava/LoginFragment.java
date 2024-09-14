package com.example.helloworldjava;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {
    public boolean isShown = false;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View currentView = inflater.inflate(R.layout.fragment_login, container, false);
        currentView.findViewById(R.id.signInBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText passwordInput = currentView.findViewById(R.id.password);
                EditText usernameInput = currentView.findViewById(R.id.username);

                if(usernameInput.getText().toString().equals("Yassine") && passwordInput.getText().toString().equals("1234567890")){
                    // send data to Home
                    Bundle result = new Bundle();
                    result.putString("username", usernameInput.getText().toString());
                    getParentFragmentManager().setFragmentResult("user", result);
                    usernameInput.setText("");
                    passwordInput.setText("");
                    // change fragment
                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment);
                }else{
                    Toast.makeText(currentView.getContext(), "The Username or/and password are incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
        currentView.findViewById(R.id.showHideBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText passwordInput =currentView.findViewById(R.id.password);
                if(isShown){
                    passwordInput.setInputType(InputType.TYPE_TEXT_VARIATION_NORMAL);
                    Toast.makeText(currentView.getContext(), "Password", Toast.LENGTH_SHORT).show();
                }else{
                    passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    Toast.makeText(currentView.getContext(), "Normal text", Toast.LENGTH_SHORT).show();
                }
                isShown=!isShown;
            }
        });

        return currentView;
    }

}