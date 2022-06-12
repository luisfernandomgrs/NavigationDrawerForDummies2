package com.luisf.learning.appatmnavigationdrawer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.luisf.learning.appatmnavigationdrawer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Um evento foi executado com sucesso!", Snackbar.LENGTH_LONG).setAction("Ok", null).show();

                // exec action to open call window...
                //ligarSuporte();

                // load image from web...
                //carregarImagem();

                // open web link at google-maps
                //carregarLink();

                // Sending email...
                enviarEmail();
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_clientes,
                R.id.nav_contatos,
                R.id.nav_principal,
                R.id.nav_servicos,
                R.id.nav_sobre)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
     */

    public void ligarSuporte() {
        String actionToExec = "tel:+555532510001";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(actionToExec));
        startActivity(intent);
    }

    public void carregarImagem() {
        String actionToExec = "https://files.nsctotal.com.br/s3fs-public/styles/paragraph_image_style/public/graphql-upload-files/praia%20do%20santinho.jpg?RT0lAbBCtiYyHw1K3mlTqFfUAbunqMJm&itok=Hr7XNElF&width=750";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(actionToExec));
        startActivity(intent);
    }

    public void carregarLink() {
        String actionToExec = "https://www.google.com.br/maps/place/Parque+da+Cidade+-+Itajub%C3%A1/@-22.4109112,-45.4380434,3a,75y,90t/data=!3m8!1e2!3m6!1sAF1QipPk4MlhY_7Kwe54xkVzNeNcn1HQzRXYeUN6T8jh!2e10!3e12!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipPk4MlhY_7Kwe54xkVzNeNcn1HQzRXYeUN6T8jh%3Dw152-h86-k-no!7i4096!8i2304!4m9!1m2!2m1!1sparque+itajub%C3%A1!3m5!1s0x94cb64a6ffcabd9d:0x968f953049e5cb89!8m2!3d-22.4109112!4d-45.4380434!15sCg9wYXJxdWUgaXRhanViw6GSAQljaXR5X3Bhcms?hl=pt-BR";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(actionToExec));
        startActivity(intent);
    }

    public void enviarEmail() {
        // define new stance
        Intent intent = new Intent(Intent.ACTION_SEND);

        // settings parameters
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria.com.br"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem automática");

        // setting type of the Intent
        //intent.setType("image");

        intent.setType("message/rfc822");
        // other option of app's to share content...
        // intent.setType("text/plain");
        // intent.setType("image/*");
        // intent.setType("image/png"); // show only app's to open this file with extension
        // intent.setType("application/pdf"); // an example of MIME Types, accepted

        /* No Start automatically
        startActivity(intent);*/
        startActivity(Intent.createChooser(intent, "Escolha um App de e-mail"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}