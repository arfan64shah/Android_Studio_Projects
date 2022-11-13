package com.example.assignmentweek9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText length;
    EditText width;
    EditText radius;
    TextView res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        length = (EditText) findViewById(R.id.x_coord);
        width = (EditText) findViewById(R.id.y_coord);
        radius = (EditText) findViewById(R.id.radius);
        res = (TextView) findViewById(R.id.result);



    }

    public void onButtonClick(View view)
    {
        double l, w, r;

        l = Double.parseDouble(String.valueOf(length.getText()));
        w = Double.parseDouble(String.valueOf(width.getText()));
        r = Double.parseDouble(String.valueOf(radius.getText()));

        System.out.println(l);
        System.out.println(w);
        System.out.println(r);


        Rectangle rectangle = new Rectangle(l,w);
        Square square = new Square(l);
        Circle circle = new Circle(r);
        res.setText("for rectange length = (" +l+")and width=("+w+" \narea rectangle: " + rectangle.Area() + "\n circumfrance of rectagle: " + rectangle.Circumference()+
        "for square width = (" +w +" \narea squre: " + square.Area() + "\n circumfrance of squre: " + square.Circumference() +
                "for circle radius = (" +r +" \narea circle: " + circle.Area() + "\n circumfrance of circle: " + circle.Circumference());
    }


}