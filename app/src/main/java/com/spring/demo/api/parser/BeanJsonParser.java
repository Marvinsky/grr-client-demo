package com.spring.demo.api.parser;

import com.spring.demo.model.Bean;
import com.spring.demo.beans.service.BeanResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by mabisrror on 1/14/17.
 */

public class BeanJsonParser {
    public static BeanResponse parse(String content) {
        BeanResponse response = new BeanResponse();
        try {
            JSONObject reader = new JSONObject(content);
            JSONArray beanJsonarray = reader.getJSONArray("beans");

            ArrayList<Bean> beanList = new ArrayList<>();

            for (int i = 0; i < beanJsonarray.length(); i++) {
                JSONObject beanJson = beanJsonarray.getJSONObject(i);
                Bean bean = new Bean();
                bean.setIdSpringBean(beanJson.getInt("idSpringBean"));
                bean.setNombre(beanJson.getString("nombre"));
                bean.setApellido(beanJson.getString("apellido"));
                bean.setDni(beanJson.getString("dni"));
                bean.setFechaRegistro(beanJson.getString("fechaRegistro"));
                beanList.add(bean);
            }
            response.setBeans(beanList);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return response;
    }
}
