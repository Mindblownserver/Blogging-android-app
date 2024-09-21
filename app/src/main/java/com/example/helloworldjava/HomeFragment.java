package com.example.helloworldjava;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView blogRecView;
    private ArrayList<Blog> blogs;
    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // setting up Recycler view
        blogRecView = view.findViewById(R.id.blog_rec_view);
        blogs = new ArrayList<>();
        blogs.add(new Blog("Why I hate Side-Quests", "The Psychology of Side Content", "Graham Walker", "7", "Aug 29 2024", "https://static.wixstatic.com/media/1fc4a4_3d816b3c490444c58ba4898419e7d35a~mv2.png/v1/fill/w_420,h_235,al_c,lg_1,q_85,enc_auto/1fc4a4_3d816b3c490444c58ba4898419e7d35a~mv2.png"));
        blogs.add(new Blog("Dredge: Why Your Brain is Your Worst Enemy and Best Friend", "What Dredge teaches us about how the brain responds to threat", "Graham Walker", "7", "Aug 29 2024", "https://static.wixstatic.com/media/1fc4a4_0d4993347c0b4eeca6fe57e3a938e05a~mv2.png/v1/fill/w_337,h_506,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/1fc4a4_0d4993347c0b4eeca6fe57e3a938e05a~mv2.png"));
        blogs.add(new Blog("Why don’t videogames give you PTSD?", "And what this teaches us Post Traumatic Stress Disorder", "Graham Walker", "7", "Aug 29 2024", "https://static.wixstatic.com/media/1fc4a4_ad944cc53f9e4ca79f33db23f4b5e5c8~mv2.png/v1/fill/w_596,h_296,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/1fc4a4_ad944cc53f9e4ca79f33db23f4b5e5c8~mv2.png"));
        blogs.add(new Blog("Why I hate Side-Quests", "The Psychology of Side Content", "Graham Walker", "7", "Aug 29 2024", "https://static.wixstatic.com/media/1fc4a4_3d816b3c490444c58ba4898419e7d35a~mv2.png/v1/fill/w_420,h_235,al_c,lg_1,q_85,enc_auto/1fc4a4_3d816b3c490444c58ba4898419e7d35a~mv2.png"));
        blogs.add(new Blog("Dredge: Why Your Brain is Your Worst Enemy and Best Friend", "What Dredge teaches us about how the brain responds to threat", "Graham Walker", "7", "Aug 29 2024", "https://static.wixstatic.com/media/1fc4a4_0d4993347c0b4eeca6fe57e3a938e05a~mv2.png/v1/fill/w_337,h_506,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/1fc4a4_0d4993347c0b4eeca6fe57e3a938e05a~mv2.png"));
        blogs.add(new Blog("Why don’t videogames give you PTSD?", "And what this teaches us Post Traumatic Stress Disorder", "Graham Walker", "7", "Aug 29 2024", "https://static.wixstatic.com/media/1fc4a4_ad944cc53f9e4ca79f33db23f4b5e5c8~mv2.png/v1/fill/w_596,h_296,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/1fc4a4_ad944cc53f9e4ca79f33db23f4b5e5c8~mv2.png"));

        BlogRecViewAdapter adapter = new BlogRecViewAdapter();
        adapter.setBlogs(blogs);
        blogRecView.setAdapter(adapter);
        blogRecView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}