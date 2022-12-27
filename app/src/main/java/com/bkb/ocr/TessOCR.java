package com.bkb.ocr;

import java.io.File;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import com.googlecode.tesseract.android.TessBaseAPI;

public class TessOCR {
    private TessBaseAPI mTess;

    public TessOCR() {
        // TODO Auto-generated constructor stub
        mTess = new TessBaseAPI();
        String datapath = Environment.getExternalStorageDirectory() + "/tesseract/";
//        String datapath = Environment.getDataDirectory().getPath() + "/tesseract/";
        String language = "eng";
        System.out.println(datapath);
        File dir = new File(datapath + "tessdata/");
        if (!dir.exists())
            dir.mkdirs();
        mTess.init(datapath, language);
    }

    public String getOCRResult(Bitmap bitmap) {

        mTess.setImage(bitmap);
        String result = mTess.getUTF8Text();

        return result;
    }

    public void onDestroy() {
        if (mTess != null)
            mTess.end();
    }

}
