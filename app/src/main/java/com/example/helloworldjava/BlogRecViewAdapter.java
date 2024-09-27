package com.example.helloworldjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BlogRecViewAdapter extends RecyclerView.Adapter<BlogRecViewAdapter.ViewHolder>{

    private ArrayList<Blog> blogList = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_blog_widget, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.blog_title.setText(blogList.get(position).getTitle());
        holder.blog_author.setText(blogList.get(position).getAuthor());
        holder.blog_read_time.setText(blogList.get(position).getReadTime());
        holder.blog_publish_date.setText(blogList.get(position).getPublishDate());
    }

    @Override
    public int getItemCount() {
        return blogList.size();
    }

    public Blog getChildByPos(int position){
        return  blogList.get(position);
    }

    public void setBlogs(ArrayList<Blog> blogList){
        this.blogList = blogList;
        notifyDataSetChanged();
    }

    // ViewHolder generates the content
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView blog_author;
        private TextView blog_title;
        private TextView blog_read_time;
        private TextView blog_publish_date;
        private ImageView blog_img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            blog_author = itemView.findViewById(R.id.blog_author);
            blog_title = itemView.findViewById(R.id.blog_title);
            blog_read_time = itemView.findViewById(R.id.blog_read_time);
            blog_publish_date = itemView.findViewById(R.id.blog_publish_date);
            blog_img = itemView.findViewById(R.id.blog_img);

        }
    }
}
