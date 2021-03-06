package com.jawg.electricalshow.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;


import com.jawg.electricalshow.R;

import java.io.Serializable;
import java.util.List;


/**
 * intent 跳转方法
 *
 * @author Administrator
 */
public class IntentMethod {
    private static UsageStatsManager sUsageStatsManager;
    private Intent intent;
    private static IntentMethod instance;

    /**
     * 返回imageloader实例化的对象
     *
     * @return
     */
    public static IntentMethod getInstance() {
        if (null == instance) {
            instance = new IntentMethod();
        }
        return instance;
    }

    /**
     * 跳转方法one
     *
     * @param endActivity 到达界面
     */
    public void startMethodOne(Context context, Class<?> endActivity) {
        intent = new Intent(context, endActivity);
        context.startActivity(intent);
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
        ((Activity) context).finish();
    }

 /**
     * 跳转方法one
     *
     * @param endActivity 到达界面
     */
    public void startMethodOne(Context context, Class<?> endActivity,
                               Object object) {
        intent = new Intent(context, endActivity);
        intent.putExtra("entity", (Serializable) object);
        context.startActivity(intent);
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
        ((Activity) context).finish();
    }


    /**
     * 跳转方法two
     *
     * @param endActivity 到达界面
     */
    public void startMethodTwo(Context context, Class<?> endActivity) {
        intent = new Intent(context, endActivity);
        context.startActivity(intent);
        // 设置切换动画，从右边进入，左边
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
    }

    /**
     * 跳转方法two
     *
     * @param endActivity 到达界面
     */
    public void startMethodTwo(Context context, Class<?> endActivity,
                               Object object) {
        intent = new Intent(context, endActivity);
        intent.putExtra("entity", (Serializable) object);
        context.startActivity(intent);
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
    }

    /**
     * 跳转方法two
     *
     * @param endActivity 到达界面
     */
    public void startMethodWithEntityInt(Context context, Class<?> endActivity,
                                         Object object, int from) {
        intent = new Intent(context, endActivity);
        intent.putExtra("entity", (Serializable) object);
        intent.putExtra("from", from);
        context.startActivity(intent);
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
    }
 /**
     * 跳转方法two
     *
     * @param endActivity 到达界面
     */
    public void startMethodWithEntityInt(Context context, Class<?> endActivity, String flag1,
                                         Object object, String flag2, int from) {
        intent = new Intent(context, endActivity);
        intent.putExtra(flag1, (Serializable) object);
        intent.putExtra(flag2, from);
        context.startActivity(intent);
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
    }

    /**
     * 跳转方法two
     *
     * @param endActivity 到达界面
     */
    public void startMethodWithEntity(Context context, Class<?> endActivity, String flag,
                                      Object object) {
        intent = new Intent(context, endActivity);
        intent.putExtra(flag, (Serializable) object);
        context.startActivity(intent);
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
    }

    /**
     * 跳转方法
     *
     * @param endActivity 到达界面
     */
    public void startMethodWithString(Context context, Class<?> endActivity, String flag,
                                      String value) {
        intent = new Intent(context, endActivity);
        intent.putExtra(flag, value);
        context.startActivity(intent);
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
    }

    /**
     * 跳转方法
     *
     * @param endActivity 到达界面
     */
    public void startMethodWithInt(Context context, Class<?> endActivity, String flag,
                                   int value) {
        intent = new Intent(context, endActivity);
        intent.putExtra(flag, value);
        context.startActivity(intent);
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
    }

    /**
     * 跳转方法
     *
     * @param endActivity 到达界面
     */
    public void startMethodWithStringInt(Context context, Class<?> endActivity, String flag,
                                         String value, String flag2,
                                         int value2) {
        intent = new Intent(context, endActivity);
        intent.putExtra(flag, value);
        intent.putExtra(flag2, value2);
        context.startActivity(intent);
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
    }

    /**
     * 跳转方法
     *
     * @param endActivity 到达界面
     */
    public void startMethodWithString2Int(Context context, Class<?> endActivity, String flag,
                                          String value, String flag2,
                                          int value2, String flag3,
                                          int value3) {
        intent = new Intent(context, endActivity);
        intent.putExtra(flag, value);
        intent.putExtra(flag2, value2);
        intent.putExtra(flag3, value3);
        context.startActivity(intent);
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
    }
    /**
     * 跳转方法
     *
     * @param endActivity 到达界面
     */
    public void startMethodWith2String1Int(Context context, Class<?> endActivity, String flag,
                                           String value, String flag2, String value2, String flag3,
                                           int value3) {
        intent = new Intent(context, endActivity);
        intent.putExtra(flag, value);
        intent.putExtra(flag2, value2);
        intent.putExtra(flag3, value3);
        context.startActivity(intent);
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
    }
/**
     * 跳转方法
     *
     * @param endActivity 到达界面
     */
    public void startMethodWith2String(Context context, Class<?> endActivity, String flag,
                                       String value, String flag2, String value2) {
        intent = new Intent(context, endActivity);
        intent.putExtra(flag, value);
        intent.putExtra(flag2, value2);
        context.startActivity(intent);
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
    }

    /**
     * 跳转方法
     *
     * @param endActivity 到达界面
     */
    public void startMethodWith2Int(Context context, Class<?> endActivity, String flag2,
                                    int value2, String flag3,
                                    int value3) {
        intent = new Intent(context, endActivity);
        intent.putExtra(flag2, value2);
        intent.putExtra(flag3, value3);
        context.startActivity(intent);
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
    }

    /**
     * 跳转方法
     *
     * @param endActivity 到达界面
     */
    public void startMethodTwoString(Context context, Class<?> endActivity, String flag,
                                     String value, String flag2,
                                     String value2) {
        intent = new Intent(context, endActivity);
        intent.putExtra(flag, value);
        intent.putExtra(flag2, value2);
        context.startActivity(intent);
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
    }

   /**
     * 跳转方法
     *
     * @param endActivity 到达界面
     */
    public void startMethodTwoStringFinish(Context context, Class<?> endActivity, String flag,
                                           String value, String flag2,
                                           String value2) {
        intent = new Intent(context, endActivity);
        intent.putExtra(flag, value);
        intent.putExtra(flag2, value2);
        context.startActivity(intent);
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
        ((Activity) context).finish();
    }

    /**
     * 跳转方法two
     *
     * @param endActivity 到达界面
     *                    flag标记是从抢单跳转 还是未完成 1抢单 2未完成
     *                    orderType标记是买单还是送单 1买单 2送单
     */
    public void startMethodTwo(Context context, Class<?> endActivity,
                               Object object, int flag, int orderType) {
        intent = new Intent(context, endActivity);
        intent.putExtra("entity", (Serializable) object);
        intent.putExtra("flag", flag);
        intent.putExtra("orderType", orderType);
        context.startActivity(intent);
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
    }

    /**
     * startresult返回
     *
     * @param context 到达界面
     */
    public void startMethodSetResult(Context context, int result) {
        intent = new Intent();
        intent.putExtra("flag", result);
        ((Activity) context).setResult(result, intent);
        ((Activity) context).finish();
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
    }

    /**
     * 返回方法
     *
     * @param context Ŀ��activity
     */
    public void rebackMethod(Context context) {
        ((Activity) context).finish();
        // 设置切换动画，从右边进入，左边�??�?
        ((Activity) context).overridePendingTransition(R.anim.toleft,
                R.anim.infright);
    }

    /**
     * 跳web页
     *
     * @param context
     * @param uriString
     */
    public void goToWeb(Context context, String uriString) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uriString));
        context.startActivity(intent);
    }

    public void startReult(Context context, Class<?> endActivity,
                           int requestCode, String flag) {
        intent = new Intent(context, endActivity);
        intent.putExtra("flag", flag);
        ((Activity) context).startActivityForResult(intent, requestCode);
    }

    public void startReultTow(Context context, Class<?> endActivity,
                              int requestCode) {
        intent = new Intent(context, endActivity);
        ((Activity) context).startActivityForResult(intent, requestCode);
    }

    public void startReultThree(Context context, Class<?> endActivity,
                                int requestCode, Object object) {
        intent = new Intent(context, endActivity);
        intent.putExtra("entity", (Serializable) object);
        ((Activity) context).startActivityForResult(intent, requestCode);
    }

    public static String getLauncherTopApp(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> appTasks = activityManager.getRunningTasks(1);
            if (null != appTasks && !appTasks.isEmpty()) {
                return appTasks.get(0).topActivity.getPackageName();
            }
        } else {
            long endTime = System.currentTimeMillis();
            long beginTime = endTime - 10000;
            if (sUsageStatsManager == null) {
                sUsageStatsManager = (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);
            }
            String result = "";
            UsageEvents.Event event = new UsageEvents.Event();
            UsageEvents usageEvents = sUsageStatsManager.queryEvents(beginTime, endTime);
            while (usageEvents.hasNextEvent()) {
                usageEvents.getNextEvent(event);
                if (event.getEventType() == UsageEvents.Event.MOVE_TO_FOREGROUND) {
                    result = event.getPackageName();
                }
            }
            if (!TextUtils.isEmpty(result)) {
                return result;
            }
        }
        return "";
    }


}
