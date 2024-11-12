package ru.mirea.kachalov.mushroomfinder.presentation.recViews;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.mirea.kachalov.mushroomfinder.R;

public class MainMushroomsViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView textViewTitle;
    private TextView textViewType;

    public MainMushroomsViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.image);
        textViewTitle = itemView.findViewById(R.id.shroomTitle);
        textViewType = itemView.findViewById(R.id.type);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextViewTitle() {
        return textViewTitle;
    }

    public TextView getTextViewType() {
        return textViewType;
    }

}
