package com.spring.demo.api;

import android.util.Log;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.spring.demo.beans.model.Bean;
import com.spring.demo.beans.service.BeanResponse;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mabisrror on 1/14/17.
 */

public class BeanResponseTypeAdapter extends TypeAdapter {
    @Override
    public void write(JsonWriter out, Object value) throws IOException {

    }

    @Override
    public Object read(JsonReader reader) throws IOException {
        Log.d("READ", "READ INFO");
        final BeanResponse response = new BeanResponse();
        ArrayList<Bean> list = new ArrayList<Bean>();
        reader.beginObject();

        while (reader.hasNext()) {
            Log.d("COUNT", "COUNT");
            Bean bean = readBean(reader);
            list.add(bean);
        }
        reader.endObject();
        response.setBeans(list);
        return response;
    }

    public Bean readBean(JsonReader reader) throws IOException {
        Bean bean = new Bean();
        reader.nextName();
        reader.beginObject();
        while (reader.hasNext()) {
            String next = reader.nextName();
            switch (next) {
                case "idSpringBean":
                    int idSpringBean = reader.nextInt();
                    Log.d("idSpringID: ", "spring id: " + idSpringBean);
                    bean.setIdSpringBean(idSpringBean);
                    break;
                case "nombre":
                    bean.setNombre(reader.nextString());
                    break;
                case "apellido":
                    bean.setApellido(reader.nextString());
                    break;
                case "dni":
                    bean.setDni(reader.nextString());
                    break;
                case "fechaRegistro":
                    bean.setFechaRegistro(reader.nextString());
                    break;
            }
        }
        reader.endObject();
        return bean;
    }
}
