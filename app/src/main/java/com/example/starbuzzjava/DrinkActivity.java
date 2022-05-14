package com.example.starbuzzjava;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends Activity {
    public static final String EXTRA_DRINKID = "drinkId";

    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_drink);
        super.onCreate(savedInstanceState);

        // Получить из интента информацию о выбранном виде кофе
        int drinkId = (Integer) getIntent().getExtras().get(EXTRA_DRINKID);
        // Создать объект с из массива drinks
        Drink drink = Drink.drinks[drinkId];

        // Установить название напитка в TextView
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(drink.getName());

        // Установить описание напитка TextView
        TextView description = (TextView) findViewById(R.id.description);
        description.setText(drink.getDescription());

        // Установить фото в ImageView
        ImageView photo = (ImageView) findViewById(R.id.photo);
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());
    }
}
