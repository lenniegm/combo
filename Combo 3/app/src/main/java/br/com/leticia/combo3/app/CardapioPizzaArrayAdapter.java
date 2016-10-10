package br.com.leticia.combo3.app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import br.com.leticia.combo3.R;


public class CardapioPizzaArrayAdapter extends ArrayAdapter<ListacardapiopizzaActivity> {

    private LayoutInflater inflater;

    public CardapioPizzaArrayAdapter(Activity activity, List<ListacardapiopizzaActivity> itens)
    {
        super(activity, R.layout.listacardapiopizza, itens);
        this.inflater = (LayoutInflater)
                activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    static class ViewHolder {
        public TextView titulo;
        public TextView descricao;
        public ImageView avatar;
    }


    public View getView(int position, View row, ViewGroup parent) {
        ViewHolder holder;

        if (row == null) {

            row = inflater.inflate(R.layout.listacardapiopizza, null);
            holder = new ViewHolder();
            holder.titulo = (TextView) row.findViewById(R.id.titulo);
            holder.descricao = (TextView) row.findViewById(R.id.descricao);
            holder.avatar = (ImageView) row.findViewById(R.id.avatar);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        ListacardapiopizzaActivity c = getItem(position);
        holder.titulo.setText(c.getTitulo());
        holder.descricao.setText(c.getDescricao());
        holder.avatar.setImageResource(R.mipmap.pizza);
        return row;

    }


}
