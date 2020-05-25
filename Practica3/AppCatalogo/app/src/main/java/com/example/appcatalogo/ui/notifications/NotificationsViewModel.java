package com.example.appcatalogo.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("App creada por:\nJose Luis Gallego Peña \nSergio Campos Megias \n\n\nDesarrollo de Software 2020");
    }

    public LiveData<String> getText() {
        return mText;
    }
}