package com.spring.demo.beans.service;

import com.spring.demo.model.Bean;

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
