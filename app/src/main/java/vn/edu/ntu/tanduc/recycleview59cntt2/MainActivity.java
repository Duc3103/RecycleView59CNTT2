package vn.edu.ntu.tanduc.recycleview59cntt2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.tanduc.controller.ICartController;
import vn.edu.ntu.tanduc.model.Product;

public class MainActivity extends AppCompatActivity
{
    RecyclerView rvListNH;
    Adapter adapter;
    List<Product> productList = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
    }
    private void addView()
    {
        rvListNH = findViewById(R.id.rvMatHang);
        rvListNH.setLayoutManager(new LinearLayoutManager( this));
        ICartController controller =(ICartController) getApplication();
        productList = controller.getAllProducts();
        adapter = new Adapter(productList);
        rvListNH.setAdapter(adapter);
    }
    private  class ProductViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtName, txtPrice, txtDesc;
        ImageView imvAddToCart;
        Product p;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = this.itemView.findViewById(R.id.txtNamePro);
            txtPrice = this.itemView.findViewById(R.id.txtPrice);
            txtDesc = this.itemView.findViewById(R.id.txtDesc);
            imvAddToCart = this.itemView.findViewById(R.id.imageView2);
        }
        public void bind(Product p)
        {
            this.p = p;
            txtName.setText(p.getName());
            txtPrice.setText(new Integer(p.getPrice()).toString());
            txtDesc.setText(p.getDesc());
        }
    }
    private class Adapter extends RecyclerView.Adapter<ProductViewHolder>
    {
        List<Product> productList;

        public Adapter(List<Product> productList) {
            this.productList = productList;
        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.product, parent, false);
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            holder.bind(productList.get(position));
        }

        @Override
        public int getItemCount() {
            return productList.size();
        }
    }
}
