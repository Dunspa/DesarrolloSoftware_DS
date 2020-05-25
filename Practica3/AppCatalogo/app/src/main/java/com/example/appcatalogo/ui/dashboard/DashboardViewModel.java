package com.example.appcatalogo.ui.dashboard;

import android.widget.ListView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<ListView> listacatalogo;

    public DashboardViewModel() {

    }

    public LiveData<ListView> getCatalogo() {
        return listacatalogo;
    }
}