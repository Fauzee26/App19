package fauzi.hilmy.app19;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import fauzi.hilmy.app19.Response.DataItem;

public class AdapterDetail extends RecyclerView.Adapter<AdapterDetail.MyViewHolder> {

    Context context;
    List<DataItem> data = new ArrayList<>();

    public AdapterDetail(Context context, List<DataItem> listPoison) {
        this.context = context;
        this.data = listPoison;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Picasso.with(context)
                .load(data.get(position).getGambar())
                .resize(1920, 800)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog;
                dialog = new Dialog(context, R.style.DialogTheme);
                dialog.setContentView(R.layout.dialog_culture);
                TextView txtNama = dialog.findViewById(R.id.txtNama);
                TextView txtDeskripsi = dialog.findViewById(R.id.txtDeskripsi);
                ImageView imagee = dialog.findViewById(R.id.imageModel);
                txtNama.setText(data.get(position).getNama());
                txtDeskripsi.setText(data.get(position).getDeskripsi());

                Picasso.with(context)
                        .load(data.get(position).getGambar())
                        .resize(1920, 800)
                        .placeholder(R.mipmap.ic_launcher)
                        .into(imagee);

                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
