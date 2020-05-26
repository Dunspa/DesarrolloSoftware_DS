package com.example.appcatalogo.ui.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.appcatalogo.R;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.LogRecord;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

// Representa cada uno de los datos que vamos a estar recibiendo por medio de la API REST
class Post {
    @SerializedName("name")
    private String name;
    @SerializedName("desc")
    private String desc;
    @SerializedName("precio")
    private double precio;
    @SerializedName("link")
    private String link;
    @SerializedName("img")
    private String img;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public double getPrecio() {
        return precio;
    }

    public String getLink() {
        return link;
    }

    public String getImg() {
        return img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

// Interfaz para gestionar cada petición a la API REST
interface PostService {
    String API_ROUTE = "getAllGames";    // URI donde se realizará la petición

    @GET(API_ROUTE)
    Call< List<Post> > getPost();
}


class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private ArrayList<String> texto;
    private ArrayList<String> descripcion;
    private ArrayList<Double> precio;
    private ArrayList<String> imagen;
    private ArrayList<String> web;

    public CustomList(Activity context, ArrayList<String> texto, ArrayList<String> descripcion, ArrayList<Double> precio, ArrayList<String> imagen, ArrayList<String> web) {
        super(context, R.layout.elemento_catalogo, texto);
        this.context = context;
        this.texto = texto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.web = web;
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
        pre.setText("Precio: " + Double.toString(precio.get(position)) + "€");;
        Picasso.get().load(imagen.get(position)).into(imageView);

        return rowView;
    }

    public String getWeb(int position) {
        return web.get(position);
    }

    public void getPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.132:8084/PracticaFinal/api/hello/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService postService = retrofit.create(PostService.class);
        Call< List<Post> > call = postService.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                for(Post post : response.body()) {
                    texto.add(post.getName());
                    descripcion.add(post.getDesc());
                    precio.add(post.getPrecio());
                    imagen.add(post.getImg());
                    web.add(post.getLink());
                }
                notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                if (t instanceof IOException) {
                    System.out.println("this is an actual network failure :( inform the user and possibly retry");
                }
                else {
                    System.out.println("conversion issue! big problems :(");
                }
            }
        });
    }
}

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private CustomList adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ListView list;
        final ArrayList<String> nombre = new ArrayList<>();
        final ArrayList<String> descripcion = new ArrayList<>();
        final ArrayList<Double> precio = new ArrayList<>();
        final ArrayList<String> imagen = new ArrayList<>();
        final ArrayList<String> web = new ArrayList<>();

        adapter = new CustomList(getActivity(), nombre, descripcion, precio, imagen, web);
        list = (ListView) root.findViewById(R.id.catalogo);
        list.setAdapter(adapter);
        // Realizar petición a API REST
        /*try {

            URL url = new URL("http://10.0.2.2:8084/PracticaFinal/api/hello/getAllGames");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
                Log.i("COSA", output);
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }*/
        adapter.getPosts();

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
                Uri uri = Uri.parse(adapter.getWeb(i));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        return root;
    }
}
