package com.example.happywash;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//Es una clase para la creación de las tarjetas con la descripción de las lavanderías
//en la pantalla de selección de lavandería
public class CustomAdapter extends BaseAdapter{
    Lavanderia [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(SeleccionLavanderias seleccion, Lavanderia[] lavs, int[] imagenes) {
        result=lavs;
        context=seleccion;
        imageId=imagenes;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    //Holder es un objeto interno para el guardado de los datos
    public class Holder
    {
        TextView nombre;
        TextView direccion;
        TextView horario;
        ImageView img;
        Button seleccionar;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //Se agregan los datos al objeto Holder y este mostrará en pantalla la tarjeta correspondiente
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.tarjeta_lavanderia, null);
        holder.nombre=(TextView) rowView.findViewById(R.id.nombre);
        holder.direccion=(TextView) rowView.findViewById(R.id.direccion);
        holder.horario=(TextView) rowView.findViewById(R.id.horario);
        holder.img=(ImageView) rowView.findViewById(R.id.imagen_lavanderia);
        holder.nombre.setText(result[position].getNombre());
        holder.direccion.setText(result[position].getDireccion());
        holder.horario.setText(result[position].getHorario());
        holder.img.setImageResource(imageId[position]);
        holder.seleccionar = (Button) rowView.findViewById(R.id.seleccionar_lav);
        holder.seleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.happywash", "com.example.happywash.Orden");
                intent.putExtra("id", result[position].getId());
                context.startActivity(intent);
            }
        });
        return rowView;
    }

}
