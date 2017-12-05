package com.starcompany.act.data;

import android.app.Activity;
import android.os.AsyncTask;

public class AsyncTaskParamsThread extends AsyncTask <String, Void, String>{

    private Activity m_Activity;

    /*
     * コンストラクタ
     *
     *  @param activity: 読み出し元Activity
     */
    public AsyncTaskParamsThread(Activity activity) {

        // 呼び出し元のアクティビティを変数へセット
        this.m_Activity = activity;
    }
    @Override
    protected String doInBackground(String... params) {
        String url1 = params[0];
        String url2 = params[1];
        String ret = "";

        /*
         *
          * Achievement achievement = new Achievement();
                    achievement.title = Task.TaskName[0];
                    achievement.content = "none";
                    achievement.count  = 1;

         */
        try {
            // Sleep処理（例：HTTP通信）
            Thread.sleep(1000);

            // Sleep処理（例：HTTP解析／画像変換とか）
            Thread.sleep(1000);

            // 取得してきた文字列・画像などをreturnでonPostExecuteへ渡す
            ret = url1 + ", " + url2;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ret;    }
}
