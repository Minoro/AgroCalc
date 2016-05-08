package br.com.minoro.calcpulverizador;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InstrucoesActivity extends Fragment {


    public InstrucoesActivity() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_instrucoes, container, false);

        TextView text = (TextView) view.findViewById(R.id.text_instrucoes);
        CharSequence instrucoes = getText(R.string.text_instrucoes);
        text.setText(instrucoes);
        return view;
    }

}
