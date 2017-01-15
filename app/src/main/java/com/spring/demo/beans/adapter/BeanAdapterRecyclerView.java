package com.spring.demo.beans.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spring.demo.R;
import com.spring.demo.beans.model.Bean;

import java.util.ArrayList;

/**
 * Created by mabisrror on 1/14/17.
 */

public class BeanAdapterRecyclerView extends RecyclerView.Adapter<BeanAdapterRecyclerView.BeansViewHolder>{
    private ArrayList<Bean> beans;
    private int resource;


    public BeanAdapterRecyclerView(ArrayList<Bean> beans, int resource) {
        this.beans = beans;
        this.resource = resource;
    }

    @Override
    public BeansViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new BeansViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeansViewHolder holder, int position) {
        Bean bean = beans.get(position);
        holder.bindBean(bean);
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    public class BeansViewHolder extends RecyclerView.ViewHolder {

        private TextView tvIdSpringBean;
        private TextView tvNombre;
        private TextView tvApellido;
        private TextView tvDni;
        private TextView tvFechaRegistro;

        public BeansViewHolder(View itemView) {
            super(itemView);

            tvIdSpringBean = (TextView)itemView.findViewById(R.id.lblIdSpringBean);
            tvNombre = (TextView)itemView.findViewById(R.id.lblNombre);
            tvApellido = (TextView)itemView.findViewById(R.id.lblApellido);
            tvDni = (TextView)itemView.findViewById(R.id.lblDni);
            tvFechaRegistro = (TextView)itemView.findViewById(R.id.lblFechaRegistro);
        }


        public void bindBean(Bean bean) {
            tvIdSpringBean.setText(String.valueOf(bean.getIdSpringBean()));
            tvNombre.setText(bean.getNombre());
            tvApellido.setText(bean.getApellido());
            tvDni.setText(bean.getDni());
            tvFechaRegistro.setText(bean.getFechaRegistro());
        }
    }
}
