package com.example.helloworldjava;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class BlogPostActivity extends AppCompatActivity implements DataFields{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_blog_post);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left,systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // fetching data via intent
        Bundle intentExtras = getIntent().getExtras();
        Blog blog = (Blog) intentExtras.getSerializable(BLOG_FIELD);

        if(blog!=null){
            TextView title = findViewById(R.id.blog_title);
            TextView subTitle = findViewById(R.id.blog_subtitle);
            TextView author = findViewById(R.id.blog_author);
            TextView readTime = findViewById(R.id.blog_read_time);
            TextView publishDate = findViewById(R.id.blog_date);

            title.setText(blog.getTitle());
            subTitle.setText(blog.getSubtitle());
            author.setText(blog.getAuthor());
            readTime.setText(String.format(blog.getReadTime()));
            publishDate.setText(blog.getPublishDate());
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home){
            finishAfterTransition();
            //overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}