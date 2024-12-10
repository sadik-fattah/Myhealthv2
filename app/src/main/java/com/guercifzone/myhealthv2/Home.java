package com.guercifzone.myhealthv2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.guercifzone.myhealthv2.Adapters.AdapterRecyclerview;
import com.guercifzone.myhealthv2.Models.ProductData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private final String JSON_URL ="https://world.openfoodfacts.org/api/v0/product/3274080005003.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<ProductData> lsArzone;
    RecyclerView recyclerView;
    AdapterRecyclerview myadapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lsArzone = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        Jsonrequest();

    }

    private void Jsonrequest() {
        request = new JsonArrayRequest(JSON_URL.toString().trim(), new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responce) {
                JSONObject jsonObject = null;
                for (int i = 0;i< responce.length();i++){
                    try {
                        jsonObject = responce.getJSONObject(i);
                        ProductData arzone = new ProductData();
                        arzone.setProduct_name(jsonObject.getString("product_name"));
                        arzone.setBarcode(jsonObject.getString("code"));
                        arzone.setIngredients_text(jsonObject.getString("ingredients_text_ar"));
                        arzone.setImage_url(jsonObject.getString("image_url"));
                        lsArzone.add(arzone);
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
                setuprecyclerview(lsArzone);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){

            }
        });
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
    private void setuprecyclerview(List<ProductData> lsArzone){
        myadapter = new AdapterRecyclerview(this,lsArzone);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setAdapter(myadapter);
    }

}