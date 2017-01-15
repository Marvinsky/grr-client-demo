package com.spring.demo.beans.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.spring.demo.beans.model.Bean;

import java.util.ArrayList;

/**
 * Created by mabisrror on 1/14/17.
 */

public class BeanResponse {

    ArrayList<Bean> beans = new ArrayList<Bean>();

    public ArrayList<Bean> getBeans() {
        return beans;
    }

    public void setBeans(ArrayList<Bean> beans) {
        this.beans = beans;
    }
}
