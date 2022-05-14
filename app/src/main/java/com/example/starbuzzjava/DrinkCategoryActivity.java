package com.example.starbuzzjava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 1. Когда пользователь выбирает команду Drinks, открывается активность DrinkCategoryActivity.
 * 2. DrinkCategoryActivity создает ArrayAdapter<Drink> — адаптер массива для массивов, содержащих объекты Drink.
 * 3. Источником данных адаптера массива является массив drinks из класса Drink.
 * 4. DrinkCategoryActivity приказывает ListView использовать адаптер массива, вызывая метод setAdapter().
 */

public class DrinkCategoryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Drink.drinks);
        ListView listDrinks = (ListView) findViewById(R.id.list_drinks);
        listDrinks.setAdapter(listAdapter);

        // Создание слушателя
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Передача напитка, выбранного пользователем в DrinkActivity
                Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
                intent.putExtra(DrinkActivity.EXTRA_DRINKID, (int) id);
                startActivity(intent);
            }
        };
        // Назначение слушателя для спискового представления
        listDrinks.setOnItemClickListener(itemClickListener);
    }
}
