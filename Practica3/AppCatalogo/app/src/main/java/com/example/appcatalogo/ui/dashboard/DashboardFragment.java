package com.example.appcatalogo.ui.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.appcatalogo.R;

import java.util.ArrayList;

class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> texto;
    private final ArrayList<String> descripcion;
    private final ArrayList<Double> precio;
    private final ArrayList<Integer> idImagen;
    public CustomList(Activity context, ArrayList<String> texto, ArrayList<String> descripcion, ArrayList<Double> precio, ArrayList<Integer> idImagen) {
        super(context, R.layout.elemento_catalogo, texto);
        this.context = context;
        this.texto = texto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.idImagen = idImagen;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.elemento_catalogo, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.texto);
        TextView descrip = (TextView) rowView.findViewById(R.id.descripcion);
        TextView pre = (TextView) rowView.findViewById(R.id.precio);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);

        txtTitle.setText(texto.get(position));
        descrip.setText(descripcion.get(position));
        pre.setText("Precio: " + Double.toString(precio.get(position)) + "€");
        imageView.setImageResource(idImagen.get(position));

        return rowView;
    }
}

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ListView list;
        final ArrayList<String> nombre = new ArrayList<>();
        nombre.add("Nombre1");
        nombre.add("Nombre2");
        nombre.add("Nombre3");
        nombre.add("Nombre4");
        nombre.add("Nombre5");
        nombre.add("Nombre6");
        nombre.add("Nombre7");

        final ArrayList<String> descripcion = new ArrayList<>();
        descripcion.add("Una descripción explicando algo");
        descripcion.add("Una descripción explicando algo");
        descripcion.add("Una descripción explicando algo");
        descripcion.add("Una descripción explicando algo");
        descripcion.add("Una descripción explicando algo");
        descripcion.add("Una descripción explicando algo");
        descripcion.add("Una descripción explicando algo");

        final ArrayList<Double> precio = new ArrayList<>();
        precio.add(30.12);
        precio.add(2.60);
        precio.add(1.54);
        precio.add(20.01);
        precio.add(33.01);
        precio.add(12.12);
        precio.add(300.12);

        final ArrayList<Integer> imageId = new ArrayList<>();
        imageId.add(R.drawable.image);
        imageId.add(R.drawable.image);
        imageId.add(R.drawable.image);
        imageId.add(R.drawable.image);
        imageId.add(R.drawable.image);
        imageId.add(R.drawable.image);
        imageId.add(R.drawable.image);

        final CustomList adapter = new CustomList(getActivity(), nombre, descripcion, precio, imageId);
        list = (ListView) root.findViewById(R.id.catalogo);
        list.setAdapter(adapter);

        EditText filtro = (EditText) root.findViewById(R.id.filtrobusqueda);
        filtro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // Actualizar lista
        /*final SwipeRefreshLayout actualizar = (SwipeRefreshLayout) root.findViewById(R.id.swiperefresh);
        actualizar.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        ListView list;
                        nombre.add("NombreNUEVO");
                        ArrayList<String> descripcion = new ArrayList<>();
                        descripcion.add("Una descripción explicando algo NUEVA");
                        imageId.add(R.drawable.image);

                        adapter.notifyDataSetChanged();
                        actualizar.setRefreshing(false);
                    }
                }
        );*/

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Uri uri = Uri.parse("http://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        return root;
    }
}
