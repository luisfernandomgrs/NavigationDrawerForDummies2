package com.luisf.learning.appatmnavigationdrawer.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.luisf.learning.appatmnavigationdrawer.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class SobreFragment extends Fragment {
    private Button buttonActionDial;

    public SobreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sobre, container, false);

        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        String descricao = "A ATM Consultoria tem como missão apoiar organizações " +
                "que desejam alcançar o sucesso através da excelência em gestão e " +
                "da busca pela qualidade.";
        return new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsultoria.com.br", "Envie um e-mail")
                .addWebsite("https://appatmconsultoria.com/", "Acesse nosso site")

                .addGroup("Redes Sociais")
                .addFacebook("your_id", "Facebook")
                .addTwitter("your_id", "Twitter")
                .addYoutube("your_channel_id","Youtube")
                .addPlayStore("your url at PlayStore","PlayStore")
                .addGitHub("luisfernandomgrs","GitHub")
                .addInstagram("your_id","Instagram")

                .addItem(versao)

                .create();
    }
}