package com.guercifzone.myhealthv2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.guercifzone.myhealthv2.Adapters.ProductAdapter;
import com.guercifzone.myhealthv2.Classes.JsonUtil;
import com.guercifzone.myhealthv2.Classes.Product;


import java.util.ArrayList;
import java.util.List;

public class Test_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Parse JSON
        Product product = JsonUtil.parseProductJson(this, "test.json");
        if (product != null && product.product != null) {
            List<String> dataToDisplay = new ArrayList<>();
            dataToDisplay.add("Product Code: " + product.code);
            dataToDisplay.add("Abbreviated Name: " + product.product.abbreviated_product_name);
            dataToDisplay.add("Brands: " + product.product.brands);
            dataToDisplay.add("Categories: " + product.product.categories);

            dataToDisplay.add("Countries: " + product.product.countries);
            dataToDisplay.add("Ingredients: " + product.product.nutriments);


            // Add more fields as needed
            recyclerView.setAdapter(new ProductAdapter(dataToDisplay));

        }
    }
}