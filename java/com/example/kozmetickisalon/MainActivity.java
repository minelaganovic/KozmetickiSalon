package com.example.kozmetickisalon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kozmetickisalon.model.User;
import com.example.kozmetickisalon.retrofit.RetrofitService;
import com.example.kozmetickisalon.api.appapi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private appapi userApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        userApi = new RetrofitService().getRetrofit().create(appapi.class);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dobijanje korisničkih unosa
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Kreiranje objekta User
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);

                // Izvršavanje Retrofit zahteva za prijavu
                Call<User> call = userApi.login(user);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            // Prijavljivanje uspešno, otvaranje HomeActivity
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish(); // Završavanje trenutne aktivnosti
                        } else {
                            // Prijavljivanje neuspešno, prikazivanje odgovarajuće poruke
                            Toast.makeText(MainActivity.this, "Prijavljivanje nije uspelo", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        // Greška prilikom izvršavanja Retrofit zahteva
                        Toast.makeText(MainActivity.this, "Greška prilikom povezivanja", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}