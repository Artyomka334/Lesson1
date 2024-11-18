package ru.mirea.kachalov.retrofitapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoAdapter extends RecyclerView.Adapter<TodoViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Todo> todos;

    public TodoAdapter(Context context, List<Todo> todoList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.todos = todoList;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.textViewTitle.setText(todo.getTitle());
        holder.checkBoxCompleted.setChecked(todo.getCompleted());

        holder.checkBoxCompleted.setOnCheckedChangeListener((buttonView, isChecked) -> {
            todo.setCompleted(isChecked);
            updateTodoCompletion(todo.getId(), isChecked);
        });

        ;
        Picasso.get()
                .load(new Random().nextInt(2) == 0 ?
                        "https://letsenhance.io/static/73136da51c245e80edc6ccfe44888a99/1015f/MainBefore.jpg" :
                        "https://i0.wp.com/picjumbo.com/wp-content/uploads/beautiful-autumn-nature-with-a-river-in-the-middle-of-the-forest-free-image.jpeg")
                .error(R.drawable.error_image)
                .placeholder(R.drawable.load_image)
                .resize(600, 100)
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    private void updateTodoCompletion(int todoId, boolean completed) {
        ApiService apiService = RetrofitController.getRetrofitInstance().create(ApiService.class);
        Todo todo = todos.get(todoId);
        todo.setCompleted(completed);

        Call<Todo> call = apiService.changeTodo(todoId, todo);
        call.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                Log.e("DEBUG", "status: " + response.code());
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.e("DEBUG", "error:	" + t.getMessage());
            }
        });
    }

}
