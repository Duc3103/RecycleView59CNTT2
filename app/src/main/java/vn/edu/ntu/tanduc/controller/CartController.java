package vn.edu.ntu.tanduc.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.tanduc.model.Product;

public class CartController extends Application implements ICartController

{
    List <Product> productList = new ArrayList<>();

    public CartController(){
        productList.add(new Product("Cà phê sữa đá",29000,"Đậm đà hương vị Việt"));
        productList.add(new Product("Trà sen vàng",59000,"Hạt sen bùi"));
        productList.add(new Product("Trà thạch đào",49000,"Thạch giòn sần sật"));
        productList.add(new Product("Americano",39000,"Đậm đà khí chất"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }
}
