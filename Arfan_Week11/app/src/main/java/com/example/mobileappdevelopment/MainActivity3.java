package com.example.mobileappdevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import com.squareup.picasso.Picasso;

public class MainActivity3 extends AppCompatActivity {
    ImageView imageView;
    TextView t1;
    TextView t2;
    TextView t3;
    EditText in;
    Map<String, Car> cars = new HashMap<String, Car>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Car car1 = new Car("Tesla","battery",100,"https://tesla-cdn.thron.com/delivery/public/image/tesla/8a74d206-66dc-4386-8c7a-88ff32174e7d/bvlatuR/std/4096x2560/Model-S-Main-Hero-Desktop-LHD");
        Car car2 = new Car("Land Cruiser","battery",100,"https://upload.wikimedia.org/wikipedia/commons/thumb/6/6d/2021_Toyota_Land_Cruiser_300_3.4_ZX_%28Colombia%29_front_view_04.png/1024px-2021_Toyota_Land_Cruiser_300_3.4_ZX_%28Colombia%29_front_view_04.png");
        Car car3 = new Car("Mercedes","battery",100,"https://cdn.motor1.com/images/mgl/jllxgl/s4/2023-mercedes-amg-c43-front-3-4.webp");
        Car car4 = new Car("Galloper","battery",100,"https://upload.wikimedia.org/wikipedia/commons/thumb/6/6c/Hyundai_Galloper_20090527_front.JPG/1024px-Hyundai_Galloper_20090527_front.JPG");
        imageView = findViewById(R.id.img);
        t1 = findViewById(R.id.out1);
        t2 = findViewById(R.id.out2);
        t3 = findViewById(R.id.out3);
        in = findViewById(R.id.inp);
        loadImage(car1.image);

        t1.setText("Model: "+car1.model);
        t2.setText("Battery: "+car1.battery);
        t3.setText("Max speed: " +String.valueOf(car1.mx_speed));



        cars.put("Tesla",car1);
        cars.put("Land Cruiser",car2);
        cars.put("Mercedes",car3);
        cars.put("Galloper",car4);
    }

    private void loadImage(String url) {
        Picasso.get()
                .load(url)

                .into(imageView);
    }

    public void onBtnClick (View view){
        String inp = String.valueOf(in.getText());
        Car ncar = cars.get(inp);

        loadImage(ncar.image);
        t1.setText("Model: "+ncar.model);
        t2.setText("Battery: "+ncar.battery);
        t3.setText("Max speed: " +String.valueOf(ncar.mx_speed));
    }
}