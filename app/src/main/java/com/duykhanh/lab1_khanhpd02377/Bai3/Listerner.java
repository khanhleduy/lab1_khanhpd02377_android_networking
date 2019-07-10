package com.duykhanh.lab1_khanhpd02377.Bai3;

import android.graphics.Bitmap;

public interface Listerner {
    void onImageLoaded(Bitmap bitmap);
    void onError();
}
