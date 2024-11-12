package ru.mirea.kachalov.mushroomfinder.presentation.recViews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ru.mirea.kachalov.domain.models.Mushroom;
import ru.mirea.kachalov.mushroomfinder.R;

public class MainMushroomsRecAdapter extends RecyclerView.Adapter<MainMushroomsViewHolder> {

    private List<Mushroom> mushroomList;
    private Context context;

    public MainMushroomsRecAdapter(List<Mushroom> mushroomList) {
        this.mushroomList = mushroomList;
    }

    @NonNull
    @Override
    public MainMushroomsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.mushroom_item, parent, false);

        return new MainMushroomsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainMushroomsViewHolder holder, int position) {
        Mushroom mushroom = mushroomList.get(position);

        Glide.with(context)
                .load(mushroom.getImg())
                .into(holder.getImageView());

        holder.getTextViewTitle().setText(mushroom.getName());
        holder.getTextViewType().setText(mushroom.getType());
    }

    @Override
    public int getItemCount() {
        return mushroomList.size();
    }

}
