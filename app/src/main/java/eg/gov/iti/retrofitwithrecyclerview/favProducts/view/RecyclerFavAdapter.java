package eg.gov.iti.retrofitwithrecyclerview.favProducts.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import eg.gov.iti.retrofitwithrecyclerview.R;
import eg.gov.iti.retrofitwithrecyclerview.allProducts.view.ClickListener;
import eg.gov.iti.retrofitwithrecyclerview.models.Product;

public class RecyclerFavAdapter extends RecyclerView.Adapter<RecyclerFavAdapter.ViewHolder> {

    private static final String TAG = "RecyclerAdapter";
    private List<Product> arrayList;
    private final Context context;
    private final ClickListener clickListener;

    public RecyclerFavAdapter(Context context, ClickListener clickListener) {
        super();
        arrayList = new ArrayList<>();
        this.context = context;
        this.clickListener = clickListener;
    }

    public void setArrayList(List<Product> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.fav_list_container, parent, false);
        Log.i(TAG, "onCreateViewHolder: ");
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTitle.setText(arrayList.get(position).title);
        holder.txtDesc.setText(arrayList.get(position).description);
        Glide.with(context).load(arrayList.get(position).thumbnail).apply(new RequestOptions().override(200, 200)).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground).into(holder.imageView);
//        holder.imageView.setImageBitmap(arrayList.get(position).thumbnail);
        holder.txtPrice.setText(String.valueOf(arrayList.get(position).price));
        holder.txtBrand.setText(arrayList.get(position).brand);
        holder.txtDiscount.setText(String.format("%s%%", arrayList.get(position).discountPercentage));
        holder.ratingBar.setRating((float) arrayList.get(position).rating);
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClickListener(arrayList.get(holder.getAdapterPosition()));
            }
        });


        Log.i(TAG, "onBindViewHolder: ");
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;
        TextView txtPrice;
        TextView txtBrand;
        TextView txtDesc;
        TextView txtDiscount;
        RatingBar ratingBar;
        ImageView imageView;
        Button btnRemove;
        public ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtViewFavTitle);
            txtDesc = itemView.findViewById(R.id.txtViewFavDesc);
            txtBrand = itemView.findViewById(R.id.txtViewFavBrand);
            txtPrice = itemView.findViewById(R.id.txtViewFavPrice);
            txtDiscount = itemView.findViewById(R.id.txtFavDiscount);
            ratingBar = itemView.findViewById(R.id.ratingBarFav);
            btnRemove = itemView.findViewById(R.id.btnRemove);
            imageView = itemView.findViewById(R.id.imgViewFav);
            constraintLayout = itemView.findViewById(R.id.row);

            ratingBar.setIsIndicator(true);
            ratingBar.setStepSize(.1f);
        }
    }
}
